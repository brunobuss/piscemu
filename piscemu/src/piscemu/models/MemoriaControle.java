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
        
        // <Para_fins_de_teste>
        endereco[0] = 1; controle[0] = Sinais.SINAL_T | Sinais.SINAL_U | Sinais.SINAL_V | Sinais.SINAL_G;
        endereco[1] = 2; controle[1] = Sinais.SINAL_M | Sinais.SINAL_N | Sinais.SINAL_O | Sinais.SINAL_U | Sinais.SINAL_I | Sinais.SINAL_MS;
        endereco[2] = 3; controle[2] = Sinais.SINAL_L | Sinais.SINAL_H;
        endereco[3] = 4; controle[3] = Sinais.SINAL_U | Sinais.SINAL_J;
        endereco[4] = -1; controle[4] = Sinais.SINAL_M | Sinais.SINAL_N | Sinais.SINAL_O | Sinais.SINAL_S | Sinais.SINAL_T | Sinais.SINAL_V | Sinais.SINAL_G;
        // </Para_fins_de_teste>
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
