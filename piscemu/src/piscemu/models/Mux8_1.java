package piscemu.models;

/**
 * Multiplex de 8 entradas
 */
public class Mux8_1 {

    private BarramentoDados[] barramentoEntrada = new BarramentoDados[8];
    private BarramentoDados barramentoSaida;
    private boolean sinalControle;
    
    
    public Mux8_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados entrada3
                    , BarramentoDados entrada4, BarramentoDados entrada5, BarramentoDados entrada6
                    , BarramentoDados entrada7, BarramentoDados entrada8, BarramentoDados saida){
        barramentoEntrada[0] = entrada1;
        barramentoEntrada[1] = entrada2;
        barramentoEntrada[2] = entrada3;
        barramentoEntrada[3] = entrada4;
        barramentoEntrada[4] = entrada5;
        barramentoEntrada[5] = entrada6;
        barramentoEntrada[6] = entrada7;
        barramentoEntrada[7] = entrada8;
        barramentoSaida = saida;
    }
    
    public void setSinal(boolean sinal){
        sinalControle = sinal;
    }
    
    public void clock(){
        
    }
}
