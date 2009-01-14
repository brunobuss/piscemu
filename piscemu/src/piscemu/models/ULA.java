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
        /*int temp = maskSinal;
        int i;
        for(i = 0; i < 32; i++){
            if(temp%2 == 1)
                break;
            temp = temp >> 1;
        }
        */
        deslocamento = 18/*i*/;
        //<debuger>
        System.out.println("Deslocamento ULA: " + deslocamento);
        //</debuger>
    }
    
    public void clock(){
        int num = (barramentoSinais.getSinais() & maskSinal) >> deslocamento;
        switch(num){
            case 0:
                barramentoSaida.setDados(barramentoEntradaA.getDados().soma(barramentoEntradaB.getDados(),barramentoFlags));
                // a+b
                //<debuger>
                System.out.println("Funcao ULA: +");
                //</debuger>
                break;
            case 1:
                barramentoSaida.setDados(barramentoEntradaA.getDados().subtrai(barramentoEntradaB.getDados(),barramentoFlags));
                // b-a
                //<debuger>
                System.out.println("Funcao ULA: -");
                //</debuger>
                break;
            case 2:
                barramentoSaida.setDados(barramentoEntradaA.getDados());
                if(barramentoEntradaA.getDados().getValor() < 0)
                        barramentoFlags.setSinal(true);
                else
                        barramentoFlags.setSinal(false);
                
                if(barramentoEntradaA.getDados().getValor() == 0)
                        barramentoFlags.setZero(true);
                else
                        barramentoFlags.setZero(false);
                // a
                //<debuger>
                System.out.println("Funcao ULA: repete a");
                //</debuger>
                break;
            case 3:
                barramentoSaida.setDados(barramentoEntradaB.getDados().compara(barramentoEntradaA.getDados(),barramentoFlags));
                // a >=< b
                //<debuger>
                System.out.println("Funcao ULA: cmp");
                //</debuger>
                break;
            case 4:
                barramentoSaida.setDados(barramentoEntradaA.getDados().and(barramentoEntradaB.getDados(),barramentoFlags));
                // a and b
                //<debuger>
                System.out.println("Funcao ULA: and");
                //</debuger>
                break;
            case 5:
                barramentoSaida.setDados(barramentoEntradaA.getDados().or(barramentoEntradaB.getDados(),barramentoFlags));
                // a or b
                //<debuger>
                System.out.println("Funcao ULA: or");
                //</debuger>
                break;
            case 6:
                barramentoSaida.setDados(barramentoEntradaA.getDados().not(barramentoFlags));
                // not a
                //<debuger>
                System.out.println("Funcao ULA: not a");
                //</debuger>
                break;
            case 7:
                barramentoSaida.setDados(barramentoEntradaA.getDados().zero(barramentoFlags));
                // 0
                //<debuger>
                System.out.println("Funcao ULA: 0");
                //</debuger>
                break;
            case 8:
                barramentoSaida.setDados(barramentoEntradaA.getDados().negacao(barramentoFlags));
                // -a
                //<debuger>
                System.out.println("Funcao ULA: - a");
                //</debuger>
                break;
            case 9:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(barramentoEntradaB.getDados(),barramentoFlags));
                // b>>a
                //<debuger>
                System.out.println("Funcao ULA: >>");
                //</debuger>
                break;
            case 10:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(barramentoEntradaB.getDados(),barramentoFlags));
                // b<<a
                //<debuger>
                System.out.println("Funcao ULA: <<");
                //</debuger>
                break;
            case 11:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftR(new TDado(1),barramentoFlags));
                // 1>>a
                //<debuger>
                System.out.println("Funcao ULA: 1>>");
                //</debuger>
                break;
            case 12:
                barramentoSaida.setDados(barramentoEntradaA.getDados().shiftL(new TDado(1),barramentoFlags));
                // 1<<a
                //<debuger>
                System.out.println("Funcao ULA: 1<<");
                //</debuger>
                break;
            case 13:
                barramentoSaida.setDados(barramentoEntradaA.getDados().inc(barramentoFlags));
                //inc
                //<debuger>
                System.out.println("Funcao ULA: inc a");
                //</debuger>
                break;
            case 14:
                barramentoSaida.setDados(barramentoEntradaA.getDados().dec(barramentoFlags));
                //dec
                //<debuger>
                System.out.println("Funcao ULA: dec a");
                //</debuger>
                break;
        }
        
    }
    
    public TDado getDado(){
        return barramentoSaida.getDados();
    }

    public void masterSync() {}
    
 
}
