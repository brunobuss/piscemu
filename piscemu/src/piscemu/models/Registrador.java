package piscemu.models;

/**
 * Registradores da arquitetura.
 */
public class Registrador {

    private BarramentoDados barramentoEntrada;
    private BarramentoDados barramentoSaida;
        
    
    public Registrador(BarramentoDados entrada, BarramentoDados saida){
        barramentoEntrada = entrada;
        barramentoSaida = saida;
    }
    
    public void setSinal(boolean sinal){
        if(sinal == true){
            barramentoSaida.setDados(barramentoEntrada.getDados());
        }
    }
    
    
}
