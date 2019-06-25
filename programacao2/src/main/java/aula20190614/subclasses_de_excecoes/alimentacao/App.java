package aula20190614.subclasses_de_excecoes.alimentacao;

public class App {
	
	public static void main(String[] args) {
		
		Robo r2d2 = new Robo();
		
		Boi boi = new Boi();
		Frango frango = new Frango();
		Suino suino = new Suino();
		
		r2d2.alimentar(boi);
		r2d2.alimentar(frango);
		r2d2.alimentar(suino);

		
		r2d2.alimentar(frango);
		System.out.println("Ok.");

	}

}
