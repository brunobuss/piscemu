package piscemu.models;

/**
 * Registradores da arquitetura.
 */
public class Registrador implements ClockListener{

    private String nome;
    private BarramentoDados barramentoEntrada;
    private BarramentoDados barramentoSaida;
    private BarramentoSinais barramentoSinais;
    private int maskSinal;
     
    public Registrador(BarramentoDados entrada, BarramentoDados saida, int maskSinal,
                       BarramentoSinais barramentoSinais, String nome){
        barramentoEntrada = entrada;
        barramentoSaida = saida;
        this.barramentoSinais = barramentoSinais;
        this.maskSinal = maskSinal;
        this.nome = new String(nome);
    }
    
    public void clock() {
        if((barramentoSinais.getSinais() & maskSinal) == maskSinal){
            barramentoSaida.setDados(barramentoEntrada.getDados());
            //<debuger>
            System.out.println( this.nome +  " ent " + barramentoEntrada.getDados().getValor());
            System.out.println( this.nome +  " sai " + barramentoSaida.getDados().getValor());
            //</debuger>
        }
    }
    
    public TDado getDado(){
        return barramentoSaida.getDados();
    }
    
    public void setDado_Debuger(int val){
        barramentoSaida.setDados(new TDado(val));
    }

    public void masterSync(){}
}
