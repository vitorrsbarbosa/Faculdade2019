package br.unicesumar.professor;

import java.util.UUID;

public class Professor {
    private String id;
    private String nome;

    public Professor() {
    }
    public String getId() {
        id = UUID.randomUUID().toString();
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
