package piscemu.models;

/**
 * Multiplex de 2 entradas
 */
public class Mux2_1 implements ClockListener{
    
    private static final short QTDEntradas = 2;  
    private BarramentoDados[] barramentoEntrada;
    private BarramentoDados barramentoSaida;
    private BarramentoSinais barramentoSinais;
    private int maskSinal;
    
    
    public Mux2_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados saida,
                  int maskSinal, BarramentoSinais barramentoSinais){
        barramentoEntrada = new BarramentoDados[QTDEntradas];
        barramentoEntrada[0] = entrada1;
        barramentoEntrada[1] = entrada2;
        barramentoSaida = saida;
        this.maskSinal = maskSinal;
        this.barramentoSinais = barramentoSinais;
    }
    
    public TDados getDado(){
        return barramentoSaida.getDados();
    }

    public void clock() {
        if((barramentoSinais.getSinais() & maskSinal) != maskSinal){
            barramentoSaida.setDados(barramentoEntrada[0].getDados());
        }else{
            barramentoSaida.setDados(barramentoEntrada[1].getDados());
        }
    }


    public void masterSync() {}
    
    
    
}
