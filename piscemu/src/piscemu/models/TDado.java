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
    
    public TDado soma(TDado dado, BarramentoFlags flags){
        short ret = (short)(this.valor + dado.getValor());
        // Verificar o Carry
        
        if(ret < 0)
            flags.setNegativo(true);
        else if(ret == 0)
            flags.setZero(true);
               
        return new TDado(ret);
    }
    
    public TDado subtrai(TDado dado, BarramentoFlags flags){
        
        short ret = (short)(dado.getValor() - this.valor);
        
        // Verificar Carry
        
        if(ret < 0)
            flags.setNegativo(true);
        else if(ret == 0)
            flags.setZero(true);
        
        return new TDado(ret);
    }
    
    public TDado compara(TDado dado, BarramentoFlags flags){
        if(this.valor < dado.getValor()){
            flags.setMaior(true);
            return new TDado(1);
        }else if(this.valor > dado.getValor()){
            flags.setMenor(true);
            return new TDado(-1);
        }else{
            flags.setIgual(true);
            return new TDado(0);
        }
    }
    
    public TDado and(TDado dado, BarramentoFlags flags){
        return new TDado((short)(this.valor & dado.getValor()));
    }
    
    public TDado or(TDado dado, BarramentoFlags flags){
        return new TDado((short)(this.valor | dado.getValor()));
    }
    
    public TDado not(BarramentoFlags flags){
        // fazer
        return new TDado(~this.valor);
    }
    
    public TDado zero(BarramentoFlags flags){
        return new TDado(0);
    }
    
    public TDado negacao(BarramentoFlags flags){
        return new TDado((short)(-this.valor));
    }
    
    public TDado shiftR(TDado dado, BarramentoFlags flags){
        return new TDado(this.valor>>dado.getValor());
    }
    
    public TDado shiftL(TDado dado, BarramentoFlags flags){
        return new TDado(this.valor<<dado.getValor());
    }    
}
