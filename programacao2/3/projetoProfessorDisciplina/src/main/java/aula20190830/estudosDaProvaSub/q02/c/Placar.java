package aula20190830.estudosDaProvaSub.q02.c;

class Placar{
    private int pontosUltimaMarcacao;
    private int pontuacaoTotal;
    
    public Placar(int pontuacaoInicial){
    }
    public void efetuarMarcacao(int pontos){
        Placar placar = new Placar(0);
        this.pontuacaoTotal += pontos;
        placar.pontosUltimaMarcacao = placar.pontuacaoTotal;
    }
    public void zerar(){
        this.pontuacaoTotal = 0;
    }
    public int obterPontuacaoTotal(){
        pontuacaoTotal = pontosUltimaMarcacao;
        return pontuacaoTotal;
    }
}