package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class ProdutoBeanTest {

	@Test
	void deveCompararDoisProdutosPeloMenorValor() {

		ProdutoBean p1 = new ProdutoBean();
		ProdutoBean p2 = new ProdutoBean();

		p1.setValor(10D);
		p2.setValor(20D);

		assertEquals(-1, p1.compareTo(p2));
	}

	@Test
	void deveCompararDoisProdutosPeloMaiorValor() {

		ProdutoBean p1 = new ProdutoBean();
		ProdutoBean p2 = new ProdutoBean();

		p1.setValor(10D);
		p2.setValor(20D);

		assertEquals(1, p2.compareTo(p1));
	}

	@Test
	void deveCompararDoisProdutosComOMesmoValor() {

		ProdutoBean p1 = new ProdutoBean();
		ProdutoBean p2 = new ProdutoBean();

		p1.setValor(10D);
		p2.setValor(10D);

		assertEquals(0, p1.compareTo(p2));
	}

	@Test
	void deveCriarUmaInstanciaDeProdutoComOConstrutorPadrao() {

		ProdutoBean p = new ProdutoBean();
		assertEquals("", p.getCodigo());
		assertEquals("", p.getDescricao());
		assertEquals("", p.getEstado());
		assertEquals("", p.getNome());
		assertEquals(0D, p.getValor());
	}

	@Test
	void deveCriarUmaInstanciaDeProdutoComOConstrutorComTodosOsParametros() {

		String codigo = "COD01";
		String nome = "Monitor";
		String descricao = "Ultrawide 29'";
		Double valor = 1299.99;
		String estado = "Novo";

		ProdutoBean p = new ProdutoBean(codigo, nome, descricao, valor, estado);

		assertEquals(codigo, p.getCodigo());
		assertEquals(nome, p.getNome());
		assertEquals(descricao, p.getDescricao());
		assertEquals(valor, p.getValor());
		assertEquals(estado, p.getEstado());

	}

	@Test
	void deveRetornarValorMaiorQueZero() {

		ProdutoBean p = new ProdutoBean();
		p.setValor(1299.99);

		assertTrue(p.getValor() > 0);
	}

	@Test
	void deveRetornarIllegalArgumentExceptionAtribuicaoDeValorMenorQueZero() {

		Double valorNegativo = -1D;

		assertThrows(IllegalArgumentException.class, () -> {
			new ProdutoBean("", "", "", valorNegativo, "");
		});

	}

	@Test
	void deveRetornarIllegalArgumentExceptionNoConstrutorQuandoValorMenorQueZero() {

		Double valorNegativo = -1D;

		assertThrows(IllegalArgumentException.class, () -> {
			ProdutoBean p = new ProdutoBean();
			p.setValor(valorNegativo);
		});

	}

}
