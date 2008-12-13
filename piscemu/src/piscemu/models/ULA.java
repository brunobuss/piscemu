/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.models;

/**
 *
 * @author thiago
 */
public class ULA implements ClockListener{
        
    private BarramentoDados barramentoSaida;
    private BarramentoDados barramentoEntradaA;
    private BarramentoDados barramentoEntradaB;
    private BarramentoSinais barramentoSinais;
    private BarramentoFlags barramentoFlags;
    private int maskSinal;
    private int deslocamento;
    
    public ULA(BarramentoDados barramentoSaida, 
               BarramentoDados barramentoEntradaA,
               BarramentoDados barramentoEntradaB,
               BarramentoSinais barramentoSinais, int maskSinal,
               BarramentoFlags barramentoFlags){
        
        this.barramentoEntradaA = barramentoEntradaA;
        this.barramentoEntradaB = barramentoEntradaB;
        this.barramentoSaida = barramentoSaida;
        this.barramentoSinais = barramentoSinais;
        this.maskSinal = maskSinal;
        this.barramentoFlags = barramentoFlags;
        calculaDeslocamento();
    }
    
    private void calculaDeslocamento(){
        int temp = maskSinal;
        int i;
        for(i = 0; i < 32; i++){
            if(temp%2 == 1)
                break;
            temp = temp >> 1;
        }
        deslocamento = i;
    }
    
    public void clock(){
        int num = (barramentoSinais.getSinais() & maskSinal) >> deslocamento;
        switch(num){
            case 0:
                barramentoSaida.setDados(barramentoEntradaA.getDados().soma(barramentoEntradaB.getDados(),barramentoFlags));
                // a+b
                break;
            case 1:
                barramentoSaida.setDados(barramentoEntradaA.getDados().subtrai(barramentoEntradaB.getDados(),barramentoFlags));
                // b-a
                break;
            case 2:
                // Verificar as Flags
                barramentoSaida.setDados(barramentoEntradaA.getDados());
                // a
                break;
            case 3:
                barramentoSaida.setDados(barramentoEntradaB.getDados().compara(barramentoEntradaA.getDados(),barramentoFlags));
                // a >=< b
                break;
            case 4:
                barramentoSaida.setDados(barramentoEntradaA.getDados().and(barramentoEntradaB.getDados(),barramentoFlags));
                // a and b
                break;
            case 5:
                barramentoSaida.setDados(barramentoEntradaA.getDados().or(barramentoEntradaB.getDados(),barramentoFlags));
                // a or b
                break;
            case 6:
                barramentoSaida.setDados(barramentoEntradaA.getDados().not(barramentoFlags));
                // not a
                break;
            case 7:
                barramentoSaida.setDados(barramentoEntradaA.getDados().zero(barramentoFlags));
                // 0
                break;
            case 8:
                barramentoSaida.setDados(barramentoEntradaA.getDados().negacao(barramentoFlags));
                // -a
                break;
            case 9:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(barramentoEntradaB.getDados(),barramentoFlags));
                // b>>a
                break;
            case 10:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(barramentoEntradaB.getDados(),barramentoFlags));
                // b<<a
                break;
            case 11:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(new TDado(1),barramentoFlags));
                // 1>>a
                break;
            case 12:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(new TDado(1),barramentoFlags));
                // 1<<a
                break;
        }
        
    }
    
    public TDado getDado(){
        return barramentoSaida.getDados();
    }

    public void masterSync() {}
    
 
}
