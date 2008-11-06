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
      
    private ArrayList<ClockListener> t1;
    private ArrayList<ClockListener> t2;
    private ArrayList<ClockListener> t3;
    private BarramentoDados barramentoEntrada;
    private BarramentoSinais barramentoSinais;
    
    public UC(BarramentoDados barramentoEntrada, BarramentoSinais barramentoSinais){
        this.barramentoEntrada = barramentoEntrada;
        this.barramentoSinais = barramentoSinais;
        t1 = new ArrayList<ClockListener>();
        t2 = new ArrayList<ClockListener>();
        t3 = new ArrayList<ClockListener>();
    }
    
    public void setSinaisControle(){
        barramentoSinais.setsinais(0); //entra o codigo da micro
    }
    
    public void setFlags(boolean[] flags){
        
    }
    
    public void addListenerT1(ClockListener listener){
        t1.add(listener);
    }
    
    public void addListenerT2(ClockListener listener){
        t2.add(listener);
    }
    
    public void addListenerT3(ClockListener listener){
        t3.add(listener);
    }
    
    private void eventoT1(){
        for (int i = 0; i < t1.size(); i++) {
            t1.get(i).clock();
            
        }
    }
    
    private void eventoT2(){
        for (int i = 0; i < t2.size(); i++) {
            t2.get(i).clock();
            
        }
    }
    
    private void eventoT3(){
        for (int i = 0; i < t3.size(); i++) {
            t3.get(i).clock();
            
        }
    }
}
