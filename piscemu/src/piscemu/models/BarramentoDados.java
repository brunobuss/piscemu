package piscemu.models;

/**
 * Representação de um barramento da arquitetura
 */
public class BarramentoDados {

    private TDado dados;
    
    public BarramentoDados(TDado dados){
        dados = new TDado(dados);
    }
    
    public BarramentoDados(){
        dados = new TDado((short)0);
    }
    public void setDados(TDado dados){
        this.dados.setValor(dados.getValor());
    }
    
    public void setDados(BarramentoDados dados){
        this.dados.setValor(dados.getDados().getValor());
    }
    
    public TDado getDados(){
        return this.dados;
    }
}
