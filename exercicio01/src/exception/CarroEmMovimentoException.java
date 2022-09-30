package exception;

public class CarroEmMovimentoException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Não é possível. O carro está em movimento.";
	}
}
