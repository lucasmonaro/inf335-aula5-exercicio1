package br.unicamp.ic.inf335.beans;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnuncioBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Poduto anuncioado
	 */
	private ProdutoBean produto;
	/**
	 * Lista de Fotos do anuncio
	 */
	private List<URL> fotosUrl;
	/**
	 * Fração de desconto sendo 0 (0%) e 1 (100%)
	 */
	private Double desconto;

	public ProdutoBean getProduto() {
		return produto;
	}

	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}

	public List<URL> getFotosUrl() {
		return fotosUrl;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	/**
	 * Contrutor default
	 */
	public AnuncioBean() {
		produto = new ProdutoBean();
		fotosUrl = new ArrayList<URL>();
		desconto = 0.0;
	}

	/**
	 * Contrutor com parâmetros
	 * 
	 * @param produto
	 * @param fotosUrl
	 * @param desconto
	 */
	public AnuncioBean(ProdutoBean produto, List<URL> fotosUrl, Double desconto) {
		super();
		if (produto == null) {
			produto = new ProdutoBean();
		}
		this.produto = produto;
		if (fotosUrl == null) {
			fotosUrl = new ArrayList<>();
		}
		this.fotosUrl = fotosUrl;
		if (desconto == null) {
			desconto = 0.D;
		}
		this.desconto = desconto;
	}

	/**
	 * Calcula valor do anuncio
	 * 
	 * @return retona valor do produto menos o desconto
	 */
	public Double getValor() {
		if (desconto <= 0) {
			return produto.getValor();
		}
		if (desconto >= 1) {
			return 0D;
		}
		return produto.getValor() - (produto.getValor() * desconto);
	}
}
