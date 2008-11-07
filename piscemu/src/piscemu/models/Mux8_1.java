package piscemu.models;

/**
 * Multiplex de 8 entradas
 */
public class Mux8_1 implements ClockListener{
    private final short QTDEntradas = 8; 

    private BarramentoDados[] barramentoEntrada;
    private BarramentoDados barramentoSaida;
    private BarramentoSinais barramentoSinais;
    private int maskSinal;
    private int deslocamento;
    
    public Mux8_1(BarramentoDados entrada1, BarramentoDados entrada2, BarramentoDados entrada3,
                  BarramentoDados entrada4, BarramentoDados entrada5, BarramentoDados entrada6,
                  BarramentoDados entrada7, BarramentoDados entrada8, BarramentoDados saida,
                  int maskSinal, BarramentoSinais barramentoSinais){
        
        barramentoEntrada = new BarramentoDados[QTDEntradas];
        barramentoEntrada[0] = entrada1;
        barramentoEntrada[1] = entrada2;
        barramentoEntrada[2] = entrada3;
        barramentoEntrada[3] = entrada4;
        barramentoEntrada[4] = entrada5;
        barramentoEntrada[5] = entrada6;
        barramentoEntrada[6] = entrada7;
        barramentoEntrada[7] = entrada8;
        barramentoSaida = saida;
        this.barramentoSinais = barramentoSinais;
        this.maskSinal = maskSinal;
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
    
    public void setSinal(boolean sinal1, boolean sinal2, boolean sinal3){
        int valor = (barramentoSinais.getSinais() & maskSinal) >> deslocamento;
        barramentoSaida.setDados(barramentoEntrada[valor].getDados());    
    }
    
    public TDados getDado(){
        return barramentoSaida.getDados();
    }

    public void clock() {
        
    }

    public void masterSync() {}
        
    
    
}
