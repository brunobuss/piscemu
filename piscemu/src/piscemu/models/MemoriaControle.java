/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

/**
 *
 * @author thiago
 */
public class MemoriaControle {
    public final static int ALTURA = 10;
    private int[] endereco;
    private int[] controle;

    public MemoriaControle(/*receber um arquivo para load*/) {
        endereco = new int[ALTURA];
        controle = new int[ALTURA];
        
    }
    
    public int getEndereco(int i){
        if(i > -1 && i < ALTURA)
            return endereco[i];
        
        return 0;
    }
    
    public int getControle(int i){
        if(i > -1 && i < ALTURA)
            return endereco[i];
        
        return 0;
    }
    
    

}
