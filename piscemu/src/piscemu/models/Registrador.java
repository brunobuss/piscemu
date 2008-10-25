package piscemu.models;

/**
 * Registradores da arquitetura.
 */
public class Registrador {

    private BarramentoDados barramentoEntrada;
    private BarramentoDados barramentoSaida;
    private boolean sinalControle;
    
    
    public Registrador(BarramentoDados entrada, BarramentoDados saida){
        barramentoEntrada = entrada;
        barramentoSaida = saida;
    }
    
    public void setSinal(boolean sinal){
        sinalControle = sinal;
    }
    
    public void clock(){
        
    }
    
}
