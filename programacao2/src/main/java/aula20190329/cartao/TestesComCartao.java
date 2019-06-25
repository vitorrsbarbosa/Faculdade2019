package aula20190329.cartao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestesComCartao {

	@Test
	public void testarExtratoNovoCartao() {
		Cartao visa3356 = new Cartao(5000.00D);
		List<Double> extrato = visa3356.obterExtrato();
		assertEquals(0, extrato.size());		
	}
	@Test
	public void testarExtratoComMovimentacoes() {
		Cartao visa3356 = new Cartao(5000.00D);
		visa3356.debitar(100.00);
		visa3356.debitar(1500.00);
		visa3356.creditar(30.00);
		visa3356.debitar(2.50);
		List<Double> extrato = visa3356.obterExtrato();
		assertEquals(4, extrato.size());
		double somarDosValores = extrato.stream().reduce((total, atual) -> total+atual).get();
		assertEquals(-1572.50, somarDosValores,0.00);
		
	}

}
