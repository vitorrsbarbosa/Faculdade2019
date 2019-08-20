package aula20190625.configuracao_com_dois_bancos;

import java.util.List;

public interface CorRepository {

    void inserir(Cor c) throws Exception;
    List<Cor> obterTodas() throws Exception;
    void alterar(Cor c) throws Exception;
    void excluir(int id) throws Exception;

}