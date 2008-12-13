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
    private final int QTDFLAGS = 6;
    
    private final int ZERO = 0;
    private final int NEGATIVO = 1;
    private final int IGUAL = 2;
    private final int MENOR = 3;
    private final int MAIOR = 4;
    private final int VAIUM = 5;
    
    private boolean[] flags;
    
    
    public BarramentoFlags(){
        flags = new boolean[QTDFLAGS];
    }
    
    public void setZero(boolean estado){
        flags[ZERO] = estado;
        if(estado == true){
            flags[NEGATIVO] = false;
        }
    }
    
    public void setNegativo(boolean estado){
        flags[NEGATIVO] = estado;
        if(estado == true){
            flags[ZERO] = false;
        }
    }
    
    public void setIgual(boolean estado){
        flags[IGUAL] = estado;
        if(estado == true){
            flags[MENOR] = false;
            flags[MAIOR] = false;
        }
    }
    
    public void setMenor(boolean estado){
        flags[MENOR] = estado;
        if(estado == true){
            flags[MAIOR] = false;
            flags[IGUAL] = false;
        }
    }
    
    public void setMaior(boolean estado){
        flags[MAIOR] = estado;
        if(estado == true){
            flags[MENOR] = false;
            flags[IGUAL] = false;
        }
    }
    
    public void setVaium(boolean estado){
        flags[VAIUM] = estado;
    }
    
    public boolean getZero(){
        return flags[ZERO];
    }
    
    public boolean getNegativo(){
        return flags[NEGATIVO];
    }
    
    public boolean getIgual(){
        return flags[IGUAL];
    }
    
    public boolean getMenor(){
        return flags[MENOR];
    }
    
    public boolean getMaior(){
        return flags[MAIOR];
    }
    
    public boolean getVaium(){
        return flags[VAIUM];
    }

}
