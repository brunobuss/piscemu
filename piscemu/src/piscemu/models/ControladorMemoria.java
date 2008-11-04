/*
 * Controlador de memória do PISC, como descrito em:
 * http://code.google.com/p/piscemu/wiki/SistemaMemoria
 */

package piscemu.models;

public class ControladorMemoria {

    private final int tamMemoria = 128 * 1024; //128K
    
    private BarramentoDados barramentoEntradaEndereco;
    private BarramentoDados barramentoSaidaDados;
    private BarramentoDados barramentoEntradaDados;
    private boolean sinalEscritaLeitura;
       
    private TDados[] memoria;
    
    public ControladorMemoria(BarramentoDados barramentoEntradaEndereco,
                                BarramentoDados barramentoSaidaDados,
                                BarramentoDados barramentoEntradaDados){
        this.barramentoEntradaEndereco = barramentoEntradaEndereco;
        this.barramentoSaidaDados = barramentoSaidaDados;
        this.barramentoEntradaDados = barramentoEntradaDados;
        
        
        memoria = new TDados[tamMemoria];
        
        //Cria todas as instancias de TDados do vetor de memória.
        for(int i = 0; i < tamMemoria; i++){
            memoria[i] = new TDados(0);
        }
    }
    
    //0 == leitura, 1 == escrita
    public void setSinal(boolean sinal){
        sinalEscritaLeitura = sinal;
    }
    
    public void operaMemoria(){
        
        TDados dado;
        
        if(sinalEscritaLeitura == false){ //Leitura           
            dado = new TDados(memoria[barramentoEntradaEndereco.getDados().getDado()]);
            barramentoSaidaDados.setDados(dado);
        }
        else{ //Escrita
            dado = new TDados(barramentoEntradaDados.getDados());
            memoria[barramentoEntradaEndereco.getDados().getDado()] = dado;
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

}