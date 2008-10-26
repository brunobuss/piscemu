package piscemu.models;

/**
 * Palavra de dados do processador
 */
public class TDados {
    
    private short dado;
    
    public TDados(short dado){
        this.dado = dado;
    }
    
    public TDados(TDados dado){
        this.dado = dado.getDado();
    }
    
    public short getDado(){
        return dado;
    }
    
    public void setDado(short dado){
        this.dado = dado;
    }
    
    public void setDado(TDados dado){
        this.dado = dado.getDado();
    }
    
}
