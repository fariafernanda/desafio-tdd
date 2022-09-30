package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exception.CarroDesligadoException;
import exception.CarroEmMovimentoException;
import exception.CarroLigadoException;
import exception.CarroParadoException;
import exception.CarroSemCombustivelException;
import exception.VelocidadeMaximaAtingidaException;
import model.Veiculo;

public class VeiculoTest {

	private Veiculo veiculoParado, veiculoEmMovimentoAltaVelocidade, veiculoEmMovimento, veiculoDesligado,
			veiculoSemCombustivel;

	@Before
	public void setup() throws Exception {
		veiculoParado = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, true, 20, 0, 20000d);
		veiculoEmMovimentoAltaVelocidade = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, true, 20, 170,
				20000d);
		veiculoEmMovimento = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, true, 20, 60, 20000d);
		veiculoDesligado = veiculoParado = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, false, 20, 0,
				20000d);
		veiculoSemCombustivel = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, true, 0, 0, 20000d);
	}

	@Test
	public void testeAcelerar() throws Exception {
		veiculoEmMovimento.acelerar();
		assertEquals(80, veiculoEmMovimento.getVelocidade());
	}

	@Test(expected = CarroDesligadoException.class)
	public void testeAcelerarComCarroDesligado() throws Exception {

		veiculoDesligado.acelerar();

	}

	@Test(expected = CarroSemCombustivelException.class)
	public void testeAcelerarComCarroSemCombustivel() throws Exception {

		veiculoSemCombustivel.acelerar();

	}

	@Test(expected = VelocidadeMaximaAtingidaException.class)
	public void testeAcelerar_velocidadeMaxima() throws Exception {

		veiculoEmMovimentoAltaVelocidade.acelerar();
		assertEquals(180, veiculoEmMovimentoAltaVelocidade.getVelocidade());

	}

	@Test
	public void testeAbastecer() throws Exception {
		veiculoSemCombustivel.abastecer(30);
		assertEquals(30, veiculoSemCombustivel.getLitrosCombustivel());
	}

	@Test
	public void testeNaoAbastecerTanqueUltrapassando60Litros() throws Exception {
		veiculoSemCombustivel.abastecer(70);
		assertEquals(60, veiculoSemCombustivel.getLitrosCombustivel());
	}

	@Test(expected = CarroEmMovimentoException.class)
	public void testeAbastecerComVeiculoEmMovimento() throws Exception {
		veiculoEmMovimento.abastecer(30);
	}

	@Test
	public void testeFrear() throws Exception {
		veiculoEmMovimento.frear();
		assertEquals(40, veiculoEmMovimento.getVelocidade());
	}

	@Test(expected = CarroParadoException.class)
	public void testeFrearComCarroParado() throws Exception {
		veiculoParado.frear();
	}

	@Test
	public void testePintar() throws Exception {
		veiculoParado.pintar("branco");

		assertEquals("branco", veiculoParado.getCor());
	}

	@Test
	public void testeLigar() throws Exception {

		veiculoDesligado.ligar();
		assertTrue(veiculoDesligado.isLigado());
	}

	@Test(expected = CarroLigadoException.class)
	public void testeLigarComCarroLigado() throws Exception {
		Veiculo carro = new Veiculo("ford", "fiesta", "abc1234", "preta", 12000, true, 40, 0, 8000);

		carro.ligar();
	}

	@Test
	public void testeDesligar() throws Exception {
		Veiculo carro = new Veiculo("ford", "fiesta", "abc1234", "preta", 12000, true, 40, 0, 8000);

		carro.desligar();
		assertTrue(!carro.isLigado());

	}

	@Test(expected = CarroEmMovimentoException.class)
	public void testeDesligarComCarroEmMovimento() throws Exception {

		veiculoEmMovimento.desligar();
	}

}
