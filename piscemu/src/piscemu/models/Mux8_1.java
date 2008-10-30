package piscemu.models;

/**
 * Multiplex de 8 entradas
 */
public class Mux8_1 {

    private BarramentoDados[] barramentoEntrada;
    private BarramentoDados barramentoSaida;
        
    
    public Mux8_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados entrada3
                    , BarramentoDados entrada4, BarramentoDados entrada5, BarramentoDados entrada6
                    , BarramentoDados entrada7, BarramentoDados entrada8, BarramentoDados saida){
        
        barramentoEntrada = new BarramentoDados[8];
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
    
    public void setSinal(boolean sinal1, boolean sinal2, boolean sinal3){
        if(sinal1 == false && sinal2 == false && sinal3 == false)
            barramentoSaida.setDados(barramentoEntrada[0].getDados());
        else if(sinal1 == false && sinal2 == false && sinal3 == true)
            barramentoSaida.setDados(barramentoEntrada[1].getDados());
        else if(sinal1 == false && sinal2 == true && sinal3 == false)
            barramentoSaida.setDados(barramentoEntrada[2].getDados());
        else if(sinal1 == false && sinal2 == true && sinal3 == true)
            barramentoSaida.setDados(barramentoEntrada[3].getDados());
        else if(sinal1 == true && sinal2 == false && sinal3 == false)
            barramentoSaida.setDados(barramentoEntrada[4].getDados());
        else if(sinal1 == true && sinal2 == false && sinal3 == true)
            barramentoSaida.setDados(barramentoEntrada[5].getDados());
        else if(sinal1 == true && sinal2 == true && sinal3 == false)
            barramentoSaida.setDados(barramentoEntrada[6].getDados());
        else if(sinal1 == true && sinal2 == true && sinal3 == true)
            barramentoSaida.setDados(barramentoEntrada[7].getDados());
        
        
    }
}
