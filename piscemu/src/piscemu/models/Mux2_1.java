package piscemu.models;

/**
 * Multiplex de 2 entradas
 */
public class Mux2_1 {

    private BarramentoDados[] barramentoEntrada;
    private BarramentoDados barramentoSaida;
    
    
    public Mux2_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados saida){
        barramentoEntrada = new BarramentoDados[2];
        barramentoEntrada[0] = entrada1;
        barramentoEntrada[1] = entrada2;
        barramentoSaida = saida;
    }
    
    public void setSinal(boolean sinal){
        if(sinal == false){
            barramentoSaida.setDados(barramentoEntrada[0]);
        }else{
            barramentoSaida.setDados(barramentoEntrada[1]);
        }
    }
    
    
}
