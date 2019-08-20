package bimestre02.aep01;

public class PercentualDeParticipacaoInvalido extends RuntimeException {

	public PercentualDeParticipacaoInvalido(String  message) {
		super(message);
	}
	public PercentualDeParticipacaoInvalido() {
		this("O percentual de participação deve estar no intervalo entre 0.01 e 100.00!");
	}
}
