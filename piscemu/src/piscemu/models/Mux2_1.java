package piscemu.models;

/**
 * Multiplex de 2 entradas
 */
public class Mux2_1 {

    private BarramentoDados[] barramentoEntrada = new BarramentoDados[2];
    private BarramentoDados barramentoSaida;
    private boolean sinalControle;
    
    
    public Mux2_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados saida){
        barramentoEntrada[0] = entrada1;
        barramentoEntrada[1] = entrada2;
        barramentoSaida = saida;
    }
    
    public void setSinal(boolean sinal){
        sinalControle = sinal;
    }
    
    public void clock(){
        
    }
}
