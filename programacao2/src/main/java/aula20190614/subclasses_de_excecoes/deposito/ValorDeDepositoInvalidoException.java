package aula20190614.subclasses_de_excecoes.deposito;

public class ValorDeDepositoInvalidoException extends RuntimeException {
	
	public ValorDeDepositoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
