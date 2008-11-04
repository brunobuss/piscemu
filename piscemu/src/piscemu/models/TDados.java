package piscemu.models;

/**
 * Palavra de dados do processador
 */
public class TDados {
    
    private short dado;
    
    public TDados(int dado){
        this.dado = (short)dado;
    }
    
    public TDados(TDados dado){
        this.dado = dado.getDado();
    }
    
    public short getDado(){
        return dado;
    }
    
    public void setDado(int dado){
        this.dado = (short)dado;
    }
    
    public void setDado(TDados dado){
        this.dado = dado.getDado();
    }
    
    public TDados soma(TDados dado){
        return new TDados((short)(this.dado+dado.getDado()));
    }
    
    public TDados subtrai(TDados dado){
        return new TDados((short)(dado.getDado() - this.dado));
    }
    
    public TDados compara(TDados dado){
        if(this.dado > dado.getDado())
            return new TDados(1);
        else if(this.dado < dado.getDado())
            return new TDados(-1);
        else
            return new TDados(0);
    }
    
    public TDados and(TDados dado){
        return new TDados((short)(this.dado & dado.getDado()));
    }
    
    public TDados or(TDados dado){
        return new TDados((short)(this.dado | dado.getDado()));
    }
    
    public TDados not(){
        // fazer
        return new TDados(~this.dado);
    }
    
    public TDados zero(){
        return new TDados(0);
    }
    
    public TDados negacao(){
        return new TDados((short)(-this.dado));
    }
    
    public TDados shiftR(TDados dado){
        return new TDados(this.dado>>dado.getDado());
    }
    
    public TDados shiftL(TDados dado){
        return new TDados(this.dado<<dado.getDado());
    }    
}
