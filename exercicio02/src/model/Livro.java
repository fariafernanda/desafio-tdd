package model;

import exception.entradaInvalidaException;
import exception.valorNegativoInvalidoException;
import interfaces.Imposto;

public class Livro extends Produto implements Imposto {

	private String autor;
	private String tema;
	private int qtdPag;

	public Livro(String nome, double preco, int qtd, String autor, String tema, int qtdPag) throws Exception {
		super(nome, preco, qtd);

		if (autor.equals("")) {
			throw new entradaInvalidaException();
		}
		if (tema.equals("")) {
			throw new entradaInvalidaException();
		}
		if (qtdPag < 1) {
			throw new valorNegativoInvalidoException();
		}

		this.autor = autor;
		this.tema = tema;
		this.qtdPag = qtdPag;

	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	@Override
	public double calculaImposto() {
		double imposto;
		if (getTema().equals("educativo")) {

			imposto = getPreco() * 0.0;
			return imposto;
		}

		imposto = getPreco() * 0.1;
		return imposto;
	}

}
