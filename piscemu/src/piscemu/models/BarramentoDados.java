package piscemu.models;

/**
 * Representação de um barramento da arquitetura
 */
public class BarramentoDados {

    private TDados dados;
    
    public BarramentoDados(TDados dados){
        dados = new TDados(dados);
    }
    
    public BarramentoDados(){
        dados = new TDados((short)0);
    }
    public void setDados(TDados dados){
        this.dados.setDado(dados);
    }
    
    public void setDados(BarramentoDados dados){
        this.dados.setDado(dados.getDados());
    }
    
    public TDados getDados(){
        return this.dados;
    }
}
