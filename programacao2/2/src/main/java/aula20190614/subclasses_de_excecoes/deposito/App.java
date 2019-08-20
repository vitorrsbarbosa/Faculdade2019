package aula20190614.subclasses_de_excecoes.deposito;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {

		boolean usuarioQuerContinuar = true;
		while (usuarioQuerContinuar) {
			try {
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));			
				Deposito d1 = new Deposito("1033-4", valor);
				System.out.println("Foi.");
			} catch (Exception excecaoCapturada) {
				System.out.println("Erro: " + excecaoCapturada.getMessage());
				usuarioQuerContinuar = JOptionPane.showConfirmDialog(null, "Valor inv�lido, deseja continuar?","Confirme", JOptionPane.YES_NO_OPTION) == 0;
			}
		}
		System.out.println("Fim.");
	}
}
