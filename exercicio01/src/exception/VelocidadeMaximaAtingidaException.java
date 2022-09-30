package exception;

public class VelocidadeMaximaAtingidaException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Velocidade máxima atingida: 180km/h";
	}
}
