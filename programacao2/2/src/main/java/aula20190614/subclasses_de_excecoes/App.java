package aula20190614.subclasses_de_excecoes;
public class App {
	public static void main(String[] args) {
		gerarExcecao();
	}
	public static void gerarExcecao() {
		//RuntimeException umaExcecao = new RuntimeException("Ulha!");
		RuntimeException umaExcecao = new UlhaException();
		throw umaExcecao;
	}
}