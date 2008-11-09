package piscemu.models;

/**
 * Palavra de dados do processador
 */
public class TDado {
    
    private short valor;
    
    public TDado(int dado){
        this.valor = (short)(dado & 0xFFFF);
    }
    
    public TDado(TDado dado){
        this.valor = dado.getValor();
    }
    
    public short getValor(){
        return valor;
    }
    
    public int getValorAbs(){
        return (int)(valor & 0xFFFF);
    }    
    
    public void setValor(int dado){
        this.valor = (short)dado;
    }
    
    public void setValor(TDado dado){
        this.valor = dado.getValor();
    }
    
    public TDado soma(TDado dado){
        return new TDado((short)(this.valor+dado.getValor()));
    }
    
    public TDado subtrai(TDado dado){
        return new TDado((short)(dado.getValor() - this.valor));
    }
    
    public TDado compara(TDado dado){
        if(this.valor > dado.getValor())
            return new TDado(1);
        else if(this.valor < dado.getValor())
            return new TDado(-1);
        else
            return new TDado(0);
    }
    
    public TDado and(TDado dado){
        return new TDado((short)(this.valor & dado.getValor()));
    }
    
    public TDado or(TDado dado){
        return new TDado((short)(this.valor | dado.getValor()));
    }
    
    public TDado not(){
        // fazer
        return new TDado(~this.valor);
    }
    
    public TDado zero(){
        return new TDado(0);
    }
    
    public TDado negacao(){
        return new TDado((short)(-this.valor));
    }
    
    public TDado shiftR(TDado dado){
        return new TDado(this.valor>>dado.getValor());
    }
    
    public TDado shiftL(TDado dado){
        return new TDado(this.valor<<dado.getValor());
    }    
}
