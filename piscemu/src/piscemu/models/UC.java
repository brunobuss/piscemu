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
    public final static int COD_FIM_INSTRUCAO = 0;
    public final static int COD_CONTINUA_INSTRUCAO = 1;
    
    private ArrayList<ClockListener> t1;
    private ArrayList<ClockListener> t2;
    private ArrayList<ClockListener> t3;
    private ArrayList<ClockListener> ms;
    private BarramentoDados barramentoEntrada;
    private BarramentoSinais barramentoSinais;
    private BarramentoFlags barramentoFlags;
    
    public UC(BarramentoDados barramentoEntrada, BarramentoSinais barramentoSinais,
              BarramentoFlags barramentoFlags){
        this.barramentoEntrada = barramentoEntrada;
        this.barramentoSinais = barramentoSinais;
        this.barramentoFlags = barramentoFlags;
        t1 = new ArrayList<ClockListener>();
        t2 = new ArrayList<ClockListener>();
        t3 = new ArrayList<ClockListener>();
        ms = new ArrayList<ClockListener>();
    }
    
    private void setSinaisControle(int sinal){
        barramentoSinais.setsinais(sinal); //entra o codigo da micro
    }
    
    public int proximaMicro(){
        int microinstrucao;
        //faz o que tiver que fazer para pegar a microinstrucao
        microinstrucao = 0;
        setSinaisControle(microinstrucao);
        
        eventoT1();
        eventoT2();
        eventoT3();
        if(/*intrucao tiver operacao de memoria*/false)
            eventoMS();
        
        if(/*terminou a instrucao*/false)
            return COD_FIM_INSTRUCAO;
        else
            return COD_CONTINUA_INSTRUCAO;
    }
    
    /* Não entendi o objetivo deste metodo
    public void setFlags(boolean[] flags){
        
    }
    */ 
    
    public void addListenerT1(ClockListener listener){
        t1.add(listener);
    }
    
    public void addListenerT2(ClockListener listener){
        t2.add(listener);
    }
    
    public void addListenerT3(ClockListener listener){
        t3.add(listener);
    }
    
    public void addListenerMS(ClockListener listener){
        ms.add(listener);
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
    
    private void eventoMS(){
        for (int i = 0; i < ms.size(); i++) {
            ms.get(i).clock();
            
        }
    }
}
