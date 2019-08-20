package bimestre02.aep01;

public class PercentualDeParticipacao {
	private final double valor;
	
	public PercentualDeParticipacao(double valor) {
		if (valor <= 0.00 || valor > 100) {
			throw new PercentualDeParticipacaoInvalido();
		}
		this.valor = valor;
	}	
	public double getValor() {
		return valor;
	}
}
