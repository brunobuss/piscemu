/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

/**
 *
 * @author thiago
 */
public class UC {
    public static final short QTDSinais = 25;
    
    private BarramentoDados barramentoEntrada;
    
    public UC(BarramentoDados barramentoEntrada){
        this.barramentoEntrada = barramentoEntrada;
    }
    
    public boolean[] getSinaisControle(){
        boolean[] sinais = new boolean[QTDSinais];
        return sinais;
    }
    
    public void setFlags(boolean[] flags){
        
    }
}
