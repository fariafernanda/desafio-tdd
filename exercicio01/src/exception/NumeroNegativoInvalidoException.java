package exception;

public class NumeroNegativoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Não é possível inserir um número negativo";
	}

}
