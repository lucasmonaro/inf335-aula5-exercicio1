package br.unicamp.ic.inf335.beans;

public class ProdutoBean implements java.io.Serializable, Comparable<ProdutoBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private String descricao;
	private Double valor;
	private String estado;

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("o valor deve ser maior ou igual a zero");
		}
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}
	
	public ProdutoBean() {
		codigo = new String();
		nome = new String();
		descricao = new String();
		valor = 0.0;
		estado = new String();
	}

	public ProdutoBean(String codigo, String nome, String descricao, Double valor, String estado) {
		super();
		if(codigo == null || codigo == "") {
			codigo = "";
		}
		this.codigo = codigo;
		if(nome == null || nome == "") {
			nome = "";
		}
		this.nome = nome;
		if(descricao == null || descricao == "") {
			descricao = "";
		}
		this.descricao = descricao;
		if (valor < 0) {
			throw new IllegalArgumentException("o valor deve ser maior ou igual a zero");
		}
		this.valor = valor;
		if(estado == null || estado == "") {
			estado = "";
		}
		this.estado = estado;
	}

	@Override
	public int compareTo(ProdutoBean p) {
		if (valor > p.getValor()) {
			return 1;
		} else if (valor < p.getValor()) {
			return -1;
		} else
			return 0;
	}

}
