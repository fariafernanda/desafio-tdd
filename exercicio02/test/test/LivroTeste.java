package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Livro;

public class LivroTeste {

	private Livro livro, livroEducativo;

	@Before
	public void setup() throws Exception {
		livro = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		livroEducativo = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);

	}

	@Test
	public void testeCalculaImpostoLivroEducativo() throws Exception {

		assertEquals(0.0, livroEducativo.calculaImposto(), 0000.1);

	}

	@Test
	public void testeCalculaImpostoLivroNaoEducativo() throws Exception {

		assertEquals(6.0, livro.calculaImposto(), 0000.1);

	}

}
