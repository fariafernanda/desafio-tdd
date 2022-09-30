package exception;

public class CarroSemCombustivelException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "O carro está sem combustível";
	}
}
