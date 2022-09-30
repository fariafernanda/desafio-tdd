package model;

import exception.entradaInvalidaException;
import interfaces.Imposto;

public class VideoGame extends Produto implements Imposto {

	private String marca;
	private String modelo;
	private boolean isUsado;

	public VideoGame(String nome, double preco, int qtd, String marca, String modelo, boolean isUsado)
			throws Exception {
		super(nome, preco, qtd);

		if (marca.equals("")) {
			throw new entradaInvalidaException();
		}
		if (modelo.equals("")) {
			throw new entradaInvalidaException();
		}

		this.marca = marca;
		this.modelo = modelo;
		this.isUsado = isUsado;

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isUsado() {
		return isUsado;
	}

	public void setUsado(boolean isUsado) {
		this.isUsado = isUsado;
	}

	@Override
	public double calculaImposto() {

		double imposto;

		if (isUsado) {
			imposto = getPreco() * 0.25;
			return imposto;
		}

		imposto = getPreco() * 0.45;
		return imposto;
	}

}
