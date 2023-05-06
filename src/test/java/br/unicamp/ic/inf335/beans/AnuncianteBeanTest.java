package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

class AnuncianteBeanTest {

	@Test
	void deveCriarUmaInstanciaDeAnuncianteComOConstrutorPadrao() throws MalformedURLException {

		AnuncianteBean anunciante = new AnuncianteBean();
		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());

	}

	@Test
	void deveCriarUmaInstanciaDeAnuncianteComOConstrutorComTodosOsParametrosNulos() throws MalformedURLException {

		AnuncianteBean anunciante = new AnuncianteBean(null, null, null);
		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());
	}

	@Test
	void deveCriarUmaInstanciaDeAnuncianteComOConstrutorComTodosOsParametrosVazios() throws MalformedURLException {

		AnuncianteBean anunciante = new AnuncianteBean("", "", null);
		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());
	}

	@Test
	void deveCriarUmaInstanciaDeAnuncianteComOConstrutorComTodosOsParametros() throws MalformedURLException {

		ProdutoBean p1 = new ProdutoBean("COD01", "Produto 1", "Descrição 1", 58.90D, "Novo");
		ProdutoBean p2 = new ProdutoBean("COD02", "Produto 2", "Descrição 1", 97.50D, "Novo");
		ProdutoBean p3 = new ProdutoBean("COD03", "Produto 3", "Descrição 1", 128.80D, "Usado");

		List<URL> p1Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p11"),
				new URL("http://localhost:8080/fotos/p12"));
		List<URL> p2Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p21"),
				new URL("http://localhost:8080/fotos/p22"));
		List<URL> p3Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p31"),
				new URL("http://localhost:8080/fotos/p32"), new URL("http://localhost:8080/fotos/p33"));

		AnuncioBean a1 = new AnuncioBean(p1, p1Fotos, 0.1D);
		AnuncioBean a2 = new AnuncioBean(p2, p2Fotos, 0.2D);
		AnuncioBean a3 = new AnuncioBean(p3, p3Fotos, 0.3D);

		AnuncianteBean anunciante = new AnuncianteBean("A", "123.456.789.10", Arrays.asList(a1, a2, a3));

		assertEquals(3, anunciante.getAnuncios().size());
		assertEquals("123.456.789.10", anunciante.getCPF());
		assertEquals("A", anunciante.getNome());
		assertEquals(53.01D, anunciante.getAnuncios().get(0).getValor());
		assertEquals(78.00D, anunciante.getAnuncios().get(1).getValor());
		assertEquals(90.16000000000001D, anunciante.getAnuncios().get(2).getValor());

	}

	@Test
	void deveAdicionarUmAnuncio() throws MalformedURLException {

		ProdutoBean p1 = new ProdutoBean("COD01", "Produto 1", "Descrição 1", 58.90D, "Novo");

		List<URL> p1Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p11"),
				new URL("http://localhost:8080/fotos/p12"));

		AnuncioBean a1 = new AnuncioBean(p1, p1Fotos, 0.1D);

		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.addAnuncio(a1);

		assertEquals(1, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());
		assertEquals(53.01D, anunciante.getAnuncios().get(0).getValor());

	}

	@Test
	void deveRemoverUmAnuncio() throws MalformedURLException {

		ProdutoBean p1 = new ProdutoBean("COD01", "Produto 1", "Descrição 1", 58.90D, "Novo");

		List<URL> p1Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p11"),
				new URL("http://localhost:8080/fotos/p12"));

		AnuncioBean a1 = new AnuncioBean(p1, p1Fotos, 0.1D);

		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.addAnuncio(a1);

		anunciante.removeAnuncio(0);

		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());

	}

	@Test
	void deveIgnorarRemocaoDeAnunciosInexistentes() throws MalformedURLException {

		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.removeAnuncio(0);

		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());

	}

	@Test
	void deveIgnorarRemocaoDeIndicesInexistentesEmUmaListaSemItens() throws MalformedURLException {

		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.removeAnuncio(-1);
		anunciante.removeAnuncio(20);
		anunciante.removeAnuncio(9999);
		anunciante.removeAnuncio(0);

		assertEquals(0, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());

	}

	@Test
	void deveIgnorarRemocaoDeIndicesInexistentesEmUmaListaComItens() throws MalformedURLException {

		ProdutoBean p1 = new ProdutoBean("COD01", "Produto 1", "Descrição 1", 58.90D, "Novo");

		List<URL> p1Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p11"),
				new URL("http://localhost:8080/fotos/p12"));

		AnuncioBean a1 = new AnuncioBean(p1, p1Fotos, 0.1D);

		AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.addAnuncio(a1);

		anunciante.removeAnuncio(1);
		anunciante.removeAnuncio(-1);

		assertEquals(1, anunciante.getAnuncios().size());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());

	}

	@Test
	void deveCalcularOValorMedioDosAnuncions() throws MalformedURLException {

		ProdutoBean p1 = new ProdutoBean("COD01", "Produto 1", "Descrição 1", 58.90D, "Novo");
		ProdutoBean p2 = new ProdutoBean("COD02", "Produto 2", "Descrição 1", 97.50D, "Novo");
		ProdutoBean p3 = new ProdutoBean("COD03", "Produto 3", "Descrição 1", 128.80D, "Usado");

		List<URL> p1Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p11"),
				new URL("http://localhost:8080/fotos/p12"));
		List<URL> p2Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p21"),
				new URL("http://localhost:8080/fotos/p22"));
		List<URL> p3Fotos = Arrays.asList(new URL("http://localhost:8080/fotos/p31"),
				new URL("http://localhost:8080/fotos/p32"), new URL("http://localhost:8080/fotos/p33"));

		AnuncioBean a1 = new AnuncioBean(p1, p1Fotos, 0.1D);
		AnuncioBean a2 = new AnuncioBean(p2, p2Fotos, 0.2D);
		AnuncioBean a3 = new AnuncioBean(p3, p3Fotos, 0.3D);

		AnuncianteBean anunciante = new AnuncianteBean("A", "123.456.789.10", Arrays.asList(a1, a2, a3));

		assertEquals(73.72333333333334D, anunciante.valorMedioAnuncios());

	}

}
