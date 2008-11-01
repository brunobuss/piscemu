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
    public static final short QTDSinais = 4;
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
        short num = transformaSinais(sinais);
        switch(num){
            case 0:
                barramentoSaida.setDados(barramentoEntradaA.getDados().soma(barramentoEntradaB.getDados()));
                // a+b
                break;
            case 1:
                barramentoSaida.setDados(barramentoEntradaA.getDados().subtrai(barramentoEntradaB.getDados()));
                // b-a
                break;
            case 2:
                barramentoSaida.setDados(barramentoEntradaA.getDados());
                // a
                break;
            case 3:
                barramentoSaida.setDados(barramentoEntradaA.getDados().compara(barramentoEntradaB.getDados()));
                // a >=< b
                break;
            case 4:
                barramentoSaida.setDados(barramentoEntradaA.getDados().and(barramentoEntradaB.getDados()));
                // a and b
                break;
            case 5:
                barramentoSaida.setDados(barramentoEntradaA.getDados().or(barramentoEntradaB.getDados()));
                // a or b
                break;
            case 6:
                barramentoSaida.setDados(barramentoEntradaA.getDados().not());
                // not a
                break;
            case 7:
                barramentoSaida.setDados(barramentoEntradaA.getDados().zero());
                // 0
                break;
            case 8:
                barramentoSaida.setDados(barramentoEntradaA.getDados().negacao());
                // -a
                break;
            case 9:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(barramentoEntradaB.getDados()));
                // b>>a
                break;
            case 10:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(barramentoEntradaB.getDados()));
                // b<<a
                break;
            case 11:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(new TDados(1)));
                // 1>>a
                break;
            case 12:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(new TDados(1)));
                // 1<<a
                break;
        }
        
    }
    
    private short transformaSinais(boolean[] sinais){
        short ret = 0;
        boolean t;
        for(short i = 0; i < QTDSinais/2; i++){
            t = sinais[i];
            sinais[i] = sinais[QTDSinais-i-1];
            sinais[QTDSinais-i-1] = t;
        }
        
        for(short i = 0; i < QTDSinais; i++){
            if(sinais[i]){
                ret += Math.pow(2,i);
            }
        }
        
        return ret;
    }

}
