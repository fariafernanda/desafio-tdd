package exception;

public class entradaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public entradaInvalidaException() {

	}

	@Override
	public String toString() {
		return "Entrada inválida";
	}

}
