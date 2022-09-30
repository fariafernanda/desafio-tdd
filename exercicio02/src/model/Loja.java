package model;

import java.util.List;

public class Loja {

	private String nome;
	private String cnpj;
	private List<Livro> livros;
	private List<VideoGame> videoGames;

	public Loja(String nome, String cnpj, List<Livro> livros, List<VideoGame> videoGames) {

		this.nome = nome;
		this.cnpj = cnpj;
		this.livros = livros;
		this.videoGames = videoGames;
	}

	public void listaLivros() {
		if (getLivros().size() > 0) {
			livros.forEach(livro -> System.out.println(livro));
		} else
			System.out.println("A loja não tem livros no seu estoque.");
	}

	public void listaVideoGames() {
		if (getVideoGames().size() > 0) {
			videoGames.forEach(videoGame -> System.out.println(videoGame));
		} else {
			System.out.println("A loja não tem video-games no seu estoque.");
		}
	}

	public double calculaPatrimonio() {

		double patrimonio = 0.0;

		for (VideoGame videoGame : videoGames) {

			patrimonio += videoGame.getPreco() * videoGame.getQtd();
		}

		for (Livro livro : livros) {
			patrimonio += livro.getPreco() * livro.getQtd();
		}

		return patrimonio;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

}
