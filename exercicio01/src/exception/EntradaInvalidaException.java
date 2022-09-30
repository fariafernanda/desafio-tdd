package exception;

public class EntradaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "O campo não pode ser vazio";
	}

}
