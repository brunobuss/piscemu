package piscemu.models;

/**
 * Representação de um barramento da arquitetura
 */
public class BarramentoDados {

    private TDados dados;
    
    public void setDados(TDados dados){
        this.dados = dados;
    }
    
    public TDados getDados(){
        return this.dados;
    }
}
