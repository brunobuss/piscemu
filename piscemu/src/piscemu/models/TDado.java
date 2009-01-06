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
        
        if((this.getValor() > 0 && dado.getValor() > 0 && ret < 0) || (this.getValor() < 0 && dado.getValor() < 0 && ret > 0))
            flags.setTransbordamento(true);
        else
            flags.setTransbordamento(false);
        // Verificar o Carry
        atualizaFlags(ret, flags);        
               
        return new TDado(ret);
    }
    
    public TDado subtrai(TDado dado, BarramentoFlags flags){
        
        short ret = (short)(dado.getValor() - this.valor);
        
        if((this.getValor() > 0 && dado.getValor() < 0 && ret < 0) || (this.getValor() < 0 && dado.getValor() > 0 && ret < 0))
            flags.setTransbordamento(true);
        else
            flags.setTransbordamento(false);
        // Verificar Carry
        
        atualizaFlags(ret, flags);
        
        return new TDado(ret);
    }
    
    public TDado compara(TDado dado, BarramentoFlags flags){
        short ret = (short)(dado.getValor() - this.valor);
        
        if((this.getValor() > 0 && dado.getValor() < 0 && ret < 0) || (this.getValor() < 0 && dado.getValor() > 0 && ret < 0))
            flags.setTransbordamento(true);
        else
            flags.setTransbordamento(false);
        // verificar Carry
        
        atualizaFlags(ret, flags);
        
        return new TDado(ret);
    }
    
    public TDado and(TDado dado, BarramentoFlags flags){
        short ret = (short)(this.valor & dado.getValor());
        
        atualizaFlags(valor, flags);
        flags.setVaium(false);
        flags.setTransbordamento(false);
        
        return new TDado(ret);       
    }
    
    public TDado or(TDado dado, BarramentoFlags flags){
        short ret = (short)(this.valor | dado.getValor());
        
        atualizaFlags(ret, flags);
        flags.setVaium(false);
        flags.setTransbordamento(false);
        
        return new TDado(ret);
    }
    
    public TDado not(BarramentoFlags flags){
        short ret = (short)~this.valor;
        
        return new TDado(ret);
    }
    
    public TDado zero(BarramentoFlags flags){
        short ret = 0;
               
        return new TDado(ret);
    }
    
    public TDado negacao(BarramentoFlags flags){
        short ret = (short)-this.valor;
        
        
        return new TDado(ret);
    }
    
    public TDado shiftR(TDado dado, BarramentoFlags flags){
        short ret = (short)(this.valor>>1);
        int vai = 0;
        
        if((1 & this.valor) == 1)
            vai = 1;
        
        for(int i = 1; i < dado.getValor(); i++){
            if((1 & ret) == 1)
                vai = 1;
            ret = (short)(ret>>1);
        }
        if(vai == 1)
            flags.setVaium(true);
        else
            flags.setVaium(false);
        
        if((this.getValor() > 0 && ret < 0) || (this.getValor() < 0 && ret > 0))
            flags.setTransbordamento(true);
        else
            flags.setTransbordamento(false);
        
        atualizaFlags(ret, flags);
        
        return new TDado(ret);
    }
    
    public TDado shiftL(TDado dado, BarramentoFlags flags){
        short ret = (short)(this.valor<<1);
        int vai = 0;
        
        if(this.valor < 0)
            vai = 1;
        
        for(int i = 1; i < dado.getValor(); i++){
            if(ret < 0)
                vai = 1;
            ret = (short)(ret<<1);
        }
        if(vai == 1)
            flags.setVaium(true);
        else
            flags.setVaium(false);
        
        if((this.getValor() > 0 && ret < 0) || (this.getValor() < 0 && ret > 0))
            flags.setTransbordamento(true);
        else
            flags.setTransbordamento(false);
        
        atualizaFlags(ret, flags);
        
        return new TDado(ret);
    }
    
    private void atualizaFlags(short resultado, BarramentoFlags flags){
        if(resultado < 0)
            flags.setSinal(true);
        else
            flags.setSinal(false);
        
        if(resultado == 0)
            flags.setZero(true);
        else
            flags.setZero(false);
        
    }
}
