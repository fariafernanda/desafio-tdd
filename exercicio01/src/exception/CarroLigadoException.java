package exception;

public class CarroLigadoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "O carro já está ligado";
	}
}
