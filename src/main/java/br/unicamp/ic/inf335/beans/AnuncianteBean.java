/**
 * 
 */
package br.unicamp.ic.inf335.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bonacin Classe que representa um anunciante, com respectivos dados e
 *         anuncios associados
 */
public class AnuncianteBean {
	/**
	 * Nome do anunciante
	 */
	private String nome;
	/**
	 * CFP do anuncioante
	 */
	private String CPF;
	/**
	 * Lista de anuncios de um anunciante
	 */
	private List<AnuncioBean> anuncios;

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public List<AnuncioBean> getAnuncios() {
		return anuncios;
	}

	/**
	 * Construtor deafult
	 */
	public AnuncianteBean() {
		nome = new String();
		CPF = new String();
		anuncios = new ArrayList<AnuncioBean>();
	}

	/**
	 * Construtor com parametros
	 * 
	 * @param nome
	 * @param cPF
	 * @param anuncios
	 */
	public AnuncianteBean(String nome, String cPF, List<AnuncioBean> anuncios) {
		super();
		if(nome == null || nome == "") {
			nome = "";
		}
		this.nome = nome;
		if(cPF == null || cPF == "") {
			cPF = "";
		}
		CPF = cPF;
		if (anuncios == null) {
			anuncios = new ArrayList<>();
		}
		this.anuncios = anuncios;
	}

	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * 
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void addAnuncio(AnuncioBean nAnuncio) {
		anuncios.add(nAnuncio);
	}

	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * 
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void removeAnuncio(int i) {
		if (anuncios.size() > 0 && i < anuncios.size() && i >= 0) {
			anuncios.remove(i);
		}
	}

	/**
	 * Calcula o valor medio de anuncios de um anuciante
	 * 
	 * @return valor medio dos anuncios
	 */
	public Double valorMedioAnuncios() {
		Double soma = 0.0;
		for (AnuncioBean an : anuncios) {
			soma += an.getValor();
		}
		return soma / anuncios.size();
	}

}
