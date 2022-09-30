package model;

import exception.CarroDesligadoException;
import exception.CarroEmMovimentoException;
import exception.CarroLigadoException;
import exception.CarroParadoException;
import exception.CarroSemCombustivelException;
import exception.EntradaInvalidaException;
import exception.NumeroNegativoInvalidoException;
import exception.VelocidadeMaximaAtingidaException;

public class Veiculo {

	private String marca;
	private String modelo;
	private String placa;
	private String cor;
	private float km;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	private double preco;

	public Veiculo(String marca, String modelo, String placa, String cor, float km, boolean isLigado,
			int litrosCombustivel, int velocidade, double preco) throws Exception {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.km = km;
		this.isLigado = isLigado;
		this.litrosCombustivel = litrosCombustivel;
		this.velocidade = velocidade;
		this.preco = preco;

		if (marca.equals("") || marca.equals(" ")) {
			throw new EntradaInvalidaException();
		}
		if (modelo.equals("") || modelo.equals(" ")) {
			throw new EntradaInvalidaException();
		}
		if (placa.equals("") || placa.equals(" ")) {
			throw new EntradaInvalidaException();
		}
		if (cor.equals("") || cor.equals(" ")) {
			throw new EntradaInvalidaException();
		}

		if (km < 0) {
			throw new NumeroNegativoInvalidoException();
		}
		if (litrosCombustivel < 0) {
			throw new NumeroNegativoInvalidoException();
		}
		if (velocidade < 0) {
			throw new NumeroNegativoInvalidoException();
		}
		if (preco < 0) {
			throw new NumeroNegativoInvalidoException();
		}

	}

	public void acelerar() throws Exception {

		int velAceleracao = 20;
		int velMaxima = 180;

		if (isLigado) {
			if (litrosCombustivel == 0) {
				throw new CarroSemCombustivelException();
			} else if (getVelocidade() + velAceleracao > velMaxima) {
				this.velocidade = velMaxima;
				throw new VelocidadeMaximaAtingidaException();
			} else {
				this.velocidade = getVelocidade() + velAceleracao;
			}
		} else {
			throw new CarroDesligadoException();
		}

	}

	public void abastecer(int combustivel) throws Exception {

		int tanqueCheio = 60;

		if (velocidade == 0) {
			if (getLitrosCombustivel() + combustivel < 60) {
				setLitrosCombustivel(getLitrosCombustivel() + combustivel);
			} else {
				setLitrosCombustivel(tanqueCheio);
			}
		} else {
			throw new CarroEmMovimentoException();

		}

	}

	public void frear() throws Exception {
		if (velocidade > 20) {
			this.velocidade = getVelocidade() - 20;

		} else if (velocidade == 0) {
			throw new CarroParadoException();
		} else {
			this.velocidade = 0;
		}

	}

	public void pintar(String cor) {
		this.cor = cor;

	}

	public void ligar() throws Exception {
		if (isLigado) {
			throw new CarroLigadoException();
		} else {
			isLigado = true;
		}

	}

	public void desligar() throws Exception {

		if (!isLigado) {
			throw new CarroDesligadoException();
		} else if (velocidade > 0) {
			throw new CarroEmMovimentoException();
		} else {
			isLigado = false;
		}

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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public boolean isLigado() {
		return isLigado;
	}

	public void setLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}

	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}

	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
