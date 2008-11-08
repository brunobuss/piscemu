/*
 * Controlador de memória do PISC, como descrito em:
 * http://code.google.com/p/piscemu/wiki/SistemaMemoria
 */

package piscemu.models;

public class ControladorMemoria implements ClockListener{

    private final int tamMemoria = 64 * 1024; //64K posicoes, 0xFFFF + 1;
    
    private BarramentoDados barramentoEntradaEndereco;
    private BarramentoDados barramentoSaidaDados;
    private BarramentoDados barramentoEntradaDados;
    private BarramentoSinais barramentoSinais;
    private int maskSinais;
    private boolean sinalEscritaLeitura;
    private TDados[] memoria;
    
    public ControladorMemoria(BarramentoDados barramentoEntradaEndereco,
                                BarramentoDados barramentoSaidaDados,
                                BarramentoDados barramentoEntradaDados,
                                int maskSinais,
                                BarramentoSinais barramentoSinais){
        this.barramentoEntradaEndereco = barramentoEntradaEndereco;
        this.barramentoSaidaDados = barramentoSaidaDados;
        this.barramentoEntradaDados = barramentoEntradaDados;
        this.barramentoSinais = barramentoSinais;
        this.maskSinais = maskSinais;
        
        
        memoria = new TDados[tamMemoria];
        
        //Cria todas as instancias de TDados do vetor de memória.
        for(int i = 0; i < tamMemoria; i++){
            memoria[i].setDado(0);
        }
    }
    
    
    public void carregaMemoria(TDados[] dados, short count, int memPos){

        if(dados.length < count){
            return; //TODO: Adicionar exception.
        }
        
        for(int i = 0; i < count; i++, memPos++){
            if(memPos >= tamMemoria){
                memPos = memPos % tamMemoria;
            }
            
            memoria[memPos] = new TDados(dados[i]);
        }
        
    }
    
    public TDados getDado(){
        return barramentoSaidaDados.getDados();
    }

    public void clock() {
           if((barramentoSinais.getSinais() & maskSinais) == maskSinais){
               sinalEscritaLeitura = true;
           }else
           {
               sinalEscritaLeitura = false;
           }
    }

    //0 == leitura, 1 == escrita
    public void masterSync() {
            
        TDados dado;
        
        if(sinalEscritaLeitura == false){ //Leitura           
            dado = new TDados(memoria[barramentoEntradaEndereco.getDados().getValorAbs()]);
            barramentoSaidaDados.setDados(dado);
        }
        else{ //Escrita
            dado = new TDados(barramentoEntradaDados.getDados());
            memoria[barramentoEntradaEndereco.getDados().getValorAbs()].setDado(dado);
        }
    }
}