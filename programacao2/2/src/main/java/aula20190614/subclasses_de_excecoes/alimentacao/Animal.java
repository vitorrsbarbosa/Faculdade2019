package aula20190614.subclasses_de_excecoes.alimentacao;

public class Animal {
	private boolean buchoCheio = false;

	public void comer() {
		if (this.buchoCheio) {
			throw new BuchoCheioExeption();
		}
		this.buchoCheio = true;
	}

	public boolean estahComBuchoCheio() {
		return this.buchoCheio;
	}

}
