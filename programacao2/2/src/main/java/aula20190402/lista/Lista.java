package aula20190402.lista;

public class Lista {
	private Object[] dados = new Object[0];

	public int obterTamanho() {
		return dados.length;
	}

	public void adicionar(Object elemento) {
		int tamanho = dados.length;
		
		Object[] novoArray = new Object[tamanho+1];
		
		for (int contador = 0; contador < tamanho; contador++) {
			novoArray[contador] = dados[contador];
		}
		novoArray[tamanho] = elemento;
		dados = novoArray;		
	}

	public Object pegar(int posicao) {
		return dados[posicao];
	}

	public void remover(int posicao) {
		int tamanho = dados.length;
		
		Object[] novoArray = new Object[tamanho-1];
		int contadorNovo = 0;
		for (int contador = 0; contador < tamanho; contador++) {
			if (contador != posicao) {
				novoArray[contadorNovo] = dados[contador];	
				contadorNovo++;
			} 
		}
		dados = novoArray;		
	}
	
	

}
