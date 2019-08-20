package aula20190619.tipos_de_excecoes;

public class Prensa {
	
	public void conectarRedeEletrica() throws CargaIdentificadaException {
		if (System.currentTimeMillis()%2 == 0) {
			throw new CargaIdentificadaException();
		}
	}
	
	public void ligar() {
		
	}
	
	public void desligar() {
		System.out.println("Desligamento acionado!!!");
	}

}
