package model;

public class Main {

	public static void main(String[] args) throws Exception {

		Veiculo veiculo = new Veiculo("fiat", "uno", "abc1234", "prata", 178000f, true, 60, 170, 20000d);

		veiculo.abastecer(30);
		System.out.println(veiculo.getVelocidade());
	}

}
