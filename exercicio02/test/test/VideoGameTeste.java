package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.VideoGame;

public class VideoGameTeste {

	private VideoGame videoGameUsado, videoGameNovo;

	@Before
	public void setup() throws Exception {

		videoGameNovo = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		videoGameUsado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
	}

	@Test
	public void testeCalculaImpostoVideoGameUsado() throws Exception {

		assertEquals(250.0, videoGameUsado.calculaImposto(), 0000.1);

	}

	@Test
	public void testeCalculaImpostoVideoGameNovo() throws Exception {

		assertEquals(810.0, videoGameNovo.calculaImposto(), 0000.1);

	}
}
