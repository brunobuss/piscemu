/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class UC {
    public static final short QTDSinais = 25;
    
    private ArrayList<ClockListener> tempos;
    private BarramentoDados barramentoEntrada;
    
    public UC(BarramentoDados barramentoEntrada){
        this.barramentoEntrada = barramentoEntrada;
        tempos = new ArrayList<ClockListener>();
    }
    
    public boolean[] getSinaisControle(){
        boolean[] sinais = new boolean[QTDSinais];
        return sinais;
    }
    
    public void setFlags(boolean[] flags){
        
    }
    
    public void addClockListener(ClockListener listener){
        tempos.add(listener);
    }
    
    public void eventoT1(){
        for (int i = 0; i < tempos.size(); i++) {
            tempos.get(i).t1();
            
        }
    }
    
    public void eventoT2(){
        for (int i = 0; i < tempos.size(); i++) {
            tempos.get(i).t2();
            
        }
    }
    
    public void eventoT3(){
        for (int i = 0; i < tempos.size(); i++) {
            tempos.get(i).t3();
            
        }
    }
}
