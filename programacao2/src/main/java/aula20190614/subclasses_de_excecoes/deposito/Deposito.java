package aula20190614.subclasses_de_excecoes.deposito;

public class Deposito {

	private final String conta;
	private final double valor;

	public Deposito(String conta, double valor) {
		if (valor <= 0.00) {
			throw new ValorDeDepositoInvalidoException("Valor depositado: " + valor);
		}
		this.conta = conta;
		this.valor = valor;
	}
	
	public String getConta() {
		return conta;
	}
	public double getValor() {
		return valor;
	}

}
