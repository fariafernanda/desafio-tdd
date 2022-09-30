package exception;

public class valorNegativoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public valorNegativoInvalidoException() {

	}

	@Override
	public String toString() {
		return "O valor inserido não pode ser negativo";
	}
}
