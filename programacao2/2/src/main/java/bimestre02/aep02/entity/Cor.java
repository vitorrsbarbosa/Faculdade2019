package bimestre02.aep02.entity;

public class Cor {
    private final int id;
    private final String nome;

    public Cor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
