/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

/**
 *
 * @author thiago
 */

public class BarramentoFlags {
    private final int QTDFLAGS = 4;
    
    private final int SINAL = 0;
    private final int ZERO = 1;
    private final int TRANSBORDAMENTO = 2;
    private final int VAIUM = 3;
    
    private boolean[] flags;
    
    
    public BarramentoFlags(){
        flags = new boolean[QTDFLAGS];
    }
    
    public void setZero(boolean estado){
        flags[ZERO] = estado;
    }
    
    public void setSinal(boolean estado){
        flags[SINAL] = estado;
    }
    
    public void setTransbordamento(boolean estado){
        flags[TRANSBORDAMENTO] = estado;
    }
    
    public void setVaium(boolean estado){
        flags[VAIUM] = estado;
    }
    
    public boolean getZero(){
        return flags[ZERO];
    }
    
    public boolean getSinal(){
        return flags[SINAL];
    }
    
    public boolean getTrasbordamento(){
        return flags[TRANSBORDAMENTO];
    }
    
    public boolean getVaium(){
        return flags[VAIUM];
    }

}
