package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

class AnuncioBeanTest {
	
	@Test
	void deveCriarUmaInstanciaDeAnuncioComOConstrutorComTodosOsParametrosNulos() throws MalformedURLException {

		AnuncioBean anuncio = new AnuncioBean(null, null, null);
		
		assertEquals(0D, anuncio.getDesconto());
		assertEquals(0D, anuncio.getFotosUrl().size());
		assertEquals(0D, anuncio.getProduto().getValor());
		assertEquals(0D, anuncio.getValor());
		
	}

	@Test
	void deveRetornarOValorComDesconto() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(0.9D);
		anuncio.setProduto(new ProdutoBean("", "", "", 100.0D, ""));

		assertEquals(10.0D, anuncio.getValor());
	}

	@Test
	void deveRetornarOValorComDescontoIgualAZero() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(0D);
		anuncio.setProduto(new ProdutoBean("", "", "", 100.0D, ""));

		assertEquals(100.0D, anuncio.getValor());
	}

	@Test
	void deveRetornarOValorComDescontoIgualACem() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(1D);
		anuncio.setProduto(new ProdutoBean("", "", "", 100.0D, ""));

		assertEquals(0.0D, anuncio.getValor());
	}

	@Test
	void naoDeveRetornarDescontoMaiorQueCem() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(2D);
		anuncio.setProduto(new ProdutoBean("", "", "", 100.0D, ""));

		assertEquals(0.0D, anuncio.getValor());
	}

	@Test
	void naoDeveRetornarDescontoMenorQueZero() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(-1D);
		anuncio.setProduto(new ProdutoBean("", "", "", 100.0D, ""));

		assertEquals(100.0D, anuncio.getValor());
	}
	
	@Test
	void deveRetornarDescontoZeroParaProdutoGratis() {

		AnuncioBean anuncio = new AnuncioBean();
		anuncio.setDesconto(0.5D);
		assertEquals(0.0D, anuncio.getValor());
	}
	
	@Test
	void deveCriarUmaInstanciaDeAnuncioComOConstrutorPadrao() {

		AnuncioBean a = new AnuncioBean();
		assertEquals(0.0D, a.getDesconto());
		assertEquals(0.0D, a.getProduto().getValor());
		assertEquals(0, a.getFotosUrl().size());
		assertEquals(0, a.getValor());
	}

	@Test
	void deveCriarUmaInstanciaDeAnuncioComOConstrutorComTodosOsParametros() throws MalformedURLException {

		String codigo = "COD01";
		String nome = "Monitor";
		String descricao = "Ultrawide 29'";
		Double valor = 1299.99;
		String estado = "Novo";
		ProdutoBean p = new ProdutoBean(codigo, nome, descricao, valor, estado);
		
		ArrayList<URL> fotosUrl = new ArrayList<>();
		fotosUrl.add(new URL("http://localhost:8080/fotos/foo"));
		fotosUrl.add(new URL("http://localhost:8080/fotos/bar"));

		Double desconto = 0.15;
		AnuncioBean a = new AnuncioBean(p, fotosUrl, desconto);

		assertEquals(desconto, a.getDesconto());
		assertEquals(valor, a.getProduto().getValor());
		assertEquals(fotosUrl.size(), a.getFotosUrl().size());
		assertEquals(1104.9915D, a.getValor());

	}

}
