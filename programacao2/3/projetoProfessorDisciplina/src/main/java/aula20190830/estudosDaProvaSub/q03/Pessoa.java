package aula20190830.estudosDaProvaSub.q03;

public class Pessoa{
    String tipo = "";

	public String getTipo() {
		return tipo;
	}
    public Pessoa(String tipo){
        this.tipo = tipo;
        /*        
        this.tipo representa a variável que
        está fora do escopo.
        o que se recebe como argumento é
        passado para a variável da instância
        */
    }
}