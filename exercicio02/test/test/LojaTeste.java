package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exception.entradaInvalidaException;
import exception.valorNegativoInvalidoException;
import model.Livro;
import model.Loja;
import model.VideoGame;

public class LojaTeste {

	private Loja loja;
	private List<Livro> livros = new ArrayList<>();
	private List<VideoGame> games = new ArrayList<>();
	private Loja lojaVazia;
	private Livro livroSemAutor;
	private VideoGame gamePrecoNegativo;

	@Before
	public void setup() throws Exception {

		Livro l1 = new Livro("Senhor dos Anéis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l2 = new Livro("Java POO", 20, 50, "GFT", "educativo", 500);
		livros.add(l1);
		livros.add(l2);

		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		games.add(ps4Usado);
		games.add(ps4);

		loja = new Loja("Americanas", "123456789", livros, games);
	}

	@Test
	public void testeCalcularPatrimonio() throws Exception {
		assertEquals(189800.0, loja.calculaPatrimonio(), 0000.1);
	}

	@Test
	public void testeCalcularPatrimonio_SemItensEmEstoque() throws Exception {
		List<Livro> semLivros = new ArrayList<>();
		List<VideoGame> semGames = new ArrayList<>();
		lojaVazia = new Loja("Falidas", "987654321", semLivros, semGames);

		assertEquals(0.0, lojaVazia.calculaPatrimonio(), 0000.1);

	}

	@Test(expected = entradaInvalidaException.class)
	public void testeInstanciarLivroSemAutor() throws Exception {

		livroSemAutor = new Livro("Java Programming", 120, 1, "", "Educativo", 350);
	}

	@Test(expected = valorNegativoInvalidoException.class)
	public void testeInstanciarVideoGameComPrecoNegativo() throws Exception {
		gamePrecoNegativo = new VideoGame("GameBoy", -280, 1, "Nintendo", "GameBoy Advance", true);

	}

}
