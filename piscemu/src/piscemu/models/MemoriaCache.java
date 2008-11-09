/*
 * Memória Cache do PISC, como descrito em:
 * http://code.google.com/p/piscemu/wiki/SistemaMemoria
 */

package piscemu.models;

public class MemoriaCache {

    private final short nroLinhas = 64;
    private LinhaCache[] aLinhas;
    
    private byte fflop;
    private int ultimaPosLiberada;
    
    public MemoriaCache(){
        aLinhas = new LinhaCache[nroLinhas];
        
        for(int i = 0; i < nroLinhas; i++){
            aLinhas[i] = new LinhaCache();
        }        
    }
    
    public boolean estaNoCache(int posMem){
        int linha, rotulo;
         
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
                       
        return aLinhas[linha].estaNoCache((short)rotulo);
    }
    
    public TDado getDado(int posMem){
        int linha, rotulo, palavra;
         
        
        flipflop();
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
        palavra = (posMem & PISCBitMasks.BMASK_END_PALAVRA);
        
        if(aLinhas[linha].estaNoCache((short)rotulo) == false){
            //TODO: Add Exception
            return new TDado(0);
        }
        
        return aLinhas[linha].getDado((short)rotulo, (short)palavra);
    }
    
    public void invalidaEntrada(int posMem){
        int linha, rotulo;
         
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
                       
        aLinhas[linha].invalidaCachePorRotulo((short) rotulo);
    }
    
    public void setBloco(TDado[] bloco, int posMem){
        
        int linha, rotulo;
         
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
        flipflop();
        
        if(aLinhas[linha].estaNoCache((short)rotulo) == false){
            //TODO: Add Exception
            return;
        }
        
        aLinhas[linha].setBloco(bloco, (short)rotulo);

        
    }
    
    public void setDado(TDado dado, int posMem){
        
        int linha, rotulo, palavra;
         
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
        palavra = (posMem & PISCBitMasks.BMASK_END_PALAVRA);
        flipflop();
        
        if(aLinhas[linha].estaNoCache((short)rotulo) == false){
            //TODO: Add Exception
            return;
        }        
        
        aLinhas[linha].setDado(dado, (short)rotulo, (short)palavra);
    }    

    public TDado[] liberaPosCache(int posMem){
        int linha, rotulo;
        TDado[] bloco;
        
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        rotulo = (posMem & PISCBitMasks.BMASK_END_ROTULO) >> 8;
        
        bloco = aLinhas[linha].retornaBlocoPorEntrada(fflop);
        aLinhas[linha].invalidaCachePorEntrada(fflop);
        
        ultimaPosLiberada = ((posMem & PISCBitMasks.BMASK_END_INDICE) | (aLinhas[linha].ultimoRotuloLiberado() << 8));
        
        return bloco;
    }
    
    public int getUltimaPosLiberada(){
        return ultimaPosLiberada;
    }
    
    public boolean temPosLivre(int posMem){
        int linha;
         
        linha = (posMem & PISCBitMasks.BMASK_END_INDICE) >> 2;
        
        return aLinhas[linha].temPosLivre();
    }
    
    private void flipflop(){
        fflop++;
        fflop = (byte)(fflop%2);
    }
}
