/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

/**
 *
 * @author thiago
 */
public class ULA {
    public static final short QTDSinais = 5;
    public static final short QTDFlags = 5;
    
    private BarramentoDados barramentoSaida;
    private BarramentoDados barramentoEntradaA;
    private BarramentoDados barramentoEntradaB;
    
    public ULA(BarramentoDados barramentoSaida, 
               BarramentoDados barramentoEntradaA,
               BarramentoDados barramentoEntradaB){
        
        this.barramentoEntradaA = barramentoEntradaA;
        this.barramentoEntradaB = barramentoEntradaB;
        this.barramentoSaida = barramentoSaida;
    }
    
    public void setSinal(boolean[] sinais){
        
    }

}
