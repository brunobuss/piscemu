package piscemu.models;

/**
 * Registradores da arquitetura.
 */
public class Registrador implements ClockListener{

    private BarramentoDados barramentoEntrada;
    private BarramentoDados barramentoSaida;
    private BarramentoSinais barramentoSinais;
    private int maskSinal;
     
    public Registrador(BarramentoDados entrada, BarramentoDados saida, int maskSinal,
                       BarramentoSinais barramentoSinais){
        barramentoEntrada = entrada;
        barramentoSaida = saida;
        this.barramentoSinais = barramentoSinais;
        this.maskSinal = maskSinal;
    }
    
    public void clock() {
        if((barramentoSinais.getSinais() & maskSinal) == maskSinal){
            barramentoSaida.setDados(barramentoEntrada.getDados());
        }
    }
    
    public TDado getDado(){
        return barramentoSaida.getDados();
    }

    public void masterSync(){}
}
