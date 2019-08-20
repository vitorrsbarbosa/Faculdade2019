package bimestre02.aep02.repository;

import bimestre02.aep02.entity.Cor;
import bimestre02.aep02.exception.CorJaInseridaException;
import bimestre02.aep02.exception.CorNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CorRepositoryMemoria implements Repository<Cor> {

    private Set<Cor> corList;

    public CorRepositoryMemoria() {
        this.corList = new HashSet<>();
    }

    @Override
    public void excluirTodos() {
        this.corList.clear();
    }

    @Override
    public void excluir(int id) {
        Cor corRemovida = this.corList.stream()
                .filter(cor -> cor.getId() == id)
                .findAny().orElseThrow(CorNotFoundException::new);

        this.corList.remove(corRemovida);
    }

    @Override
    public void alterar(Cor objeto) {
        excluir(objeto.getId());
        inserir(objeto);
    }

    @Override
    public List<Cor> obterTodas() {
        return (List<Cor>) new HashSet<>(corList);
    }

    @Override
    public void inserir(Cor objeto) {
        corList.stream()
                .filter(cor -> cor.getId() != objeto.getId())
                .findAny().ifPresentOrElse(cor -> {
                    throw new CorJaInseridaException();
                },
                () -> corList.add(objeto)
        );
    }
}