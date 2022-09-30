package model;

import exception.entradaInvalidaException;
import exception.valorNegativoInvalidoException;

public abstract class Produto {

	private String nome;
	private double preco;
	private int qtd;

	public Produto(String nome, double preco, int qtd) throws Exception {

		if (nome.equals("")) {
			throw new entradaInvalidaException();
		}
		if (preco < 0) {
			throw new valorNegativoInvalidoException();
		}
		if (qtd < 0) {
			throw new valorNegativoInvalidoException();
		}

		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}
