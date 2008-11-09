/*
 * Entrada na Cache.
 * Armazena o bloco de informação e o bit de validade.
 */

package piscemu.models;

public class EntradaCache {

    private final int tamBloco = 4;
    
    private TDados[] blocoMemoria;
    private boolean bitValidade;
    
    private short rotulo;
    
    public EntradaCache(){
        blocoMemoria = new TDados[tamBloco];
        
        for(int i = 0; i < tamBloco; i++){
            blocoMemoria[i] = new TDados(0);
        }
        bitValidade = false;
    }
    
    public boolean entradaValida(){
        return bitValidade;
    }
    
    public void invalidaEntrada(){
        bitValidade = false;
    }
    
    public void setBloco(TDados[] bloco, short rotulo){
        //TODO: Adicionar tratamento de exceção.
        for(short i = 0; i < tamBloco; i++){
            setDado(bloco[i], rotulo, i);
        }
        this.rotulo = rotulo;
        bitValidade = true;
    }

     public void setDado(TDados dado, short rotulo, short pos){
        //TODO: Adicionar tratamento de exceção.
        blocoMemoria[pos].setDado(dado);
    }
    
    public TDados getDado(short palavra){
        
        //TODO: Alterar para exception
        if(palavra < 0 || palavra >= tamBloco){
            return new TDados(0);
        }
        
        return blocoMemoria[palavra];
    }
    
    public short getRotulo(){
        return rotulo;
    }
}
