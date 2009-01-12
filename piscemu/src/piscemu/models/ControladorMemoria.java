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
    private TDado[] memoria;
    
    private MemoriaCache memCache;
    private int cacheHit = 0;
    private int cacheMiss = 0;
    
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
        
        
        memoria = new TDado[tamMemoria];
        
        //Cria todas as instancias de TDados do vetor de memória.
        for(int i = 0; i < tamMemoria; i++){
            memoria[i].setValor(0);
        }
        
        memCache = new MemoriaCache();
        
        //<para_testar>
        memoria[0].setValor(53);
        //</para_testar>
    }
    
    
    public void carregaMemoria(TDado[] dados, short count, int memPos){

        if(dados.length < count){
            return; //TODO: Adicionar exception.
        }
        
        for(int i = 0; i < count; i++, memPos++){
            if(memPos >= tamMemoria){
                memPos = memPos % tamMemoria;
            }
            
            memoria[memPos] = new TDado(dados[i]);
        }
        
    }
    
    public TDado getDado(){
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
            
        TDado dado;
        int posMem = barramentoEntradaEndereco.getDados().getValorAbs();
        
        if(sinalEscritaLeitura == false){ //Leitura        
            
            if(memCache.estaNoCache(posMem)){
                cacheHit++;
            }
            else{
                if(memCache.temPosLivre(posMem)){
                    memCache.setBloco(montaBloco(posMem), posMem);
                }
                else{
                    TDado[] bloco = memCache.liberaPosCache(posMem);
                    rebateParaMemoria(bloco, memCache.getUltimaPosLiberada());
                    memCache.setBloco(montaBloco(posMem), posMem);
                }
                cacheMiss++;
            }
            
            dado = new TDado(memCache.getDado(posMem));
            barramentoSaidaDados.setDados(dado);
        }
        else{ //Escrita
            dado = new TDado(barramentoEntradaDados.getDados());
            
            if(memCache.estaNoCache(posMem)){
                memCache.setDado(dado, posMem);
            }            
            else{
                memoria[posMem].setValor(dado);
            }
        }
    }
    
    private TDado[] montaBloco(int posMem){
        int base;
        TDado[] bloco = new TDado[4];
        
        base = (posMem & PISCBitMasks.BMASK_END_INDICE) | (posMem & PISCBitMasks.BMASK_END_ROTULO);
        
        
        for(int i = 0; i < 4; i++){
            bloco[i] = memoria[base + i];
        }
        
        return bloco;
    }
    
    private void rebateParaMemoria(TDado[] bloco, int posBaseMem){
        for(int i = 0; i < 4; i++){
            memoria[posBaseMem + i] = bloco[i];
        }        
    }
}
