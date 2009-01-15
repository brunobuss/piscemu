/*
 * Linha do cache
 */

package piscemu.models;

public class LinhaCache {

    //Associatividade do cache
    private final int assoc = 2;
    private short ultimoRotuloLiberado;
    
    private EntradaCache[] entradas;
    
    public LinhaCache(){
        
        entradas = new EntradaCache[assoc];
        
        for(int i = 0; i < assoc; i++){
            entradas[i] = new EntradaCache();
        }
    }
    
    private int posNoCache(short rotulo){
        
        for(int i = 0; i < assoc; i++){
            
            if(entradas[i].getRotulo() == rotulo && entradas[i].entradaValida() == true){
                return i;
            }
            
        }
        return -1;
    } 
    
    public boolean estaNoCache(short rotulo){
        
        if(posNoCache(rotulo) == -1){
            return false;
        }
        else{
            return true;    
        }
    }     
    
    public TDado getDado(short rotulo, short palavra){
        
        int iPos = posNoCache(rotulo);
        
        if(iPos != -1){
                return new TDado(entradas[iPos].getDado(palavra));
        }
        
        return new TDado(0);
    }
    
    public TDado[] retornaBlocoPorEntrada(short entrada){
        
        TDado[] bloco = new TDado[4];
        
        for(short i = 0; i < 4; i++){
            bloco[i] = new TDado(entradas[entrada].getDado(i));
        }
        
        return bloco;
    }    
    
    public void setBloco(TDado[] bloco, short rotulo){       
        entradas[getPosLivre()].setBloco(bloco, rotulo);
    }

    public void setDado(TDado dado, short rotulo, short palavra){       
        entradas[posNoCache(rotulo)].setDado(dado, rotulo, palavra);
    }    
    
    public void invalidaCachePorRotulo(short rotulo){
        int pos = posNoCache(rotulo);
        
        if(pos != -1){
            entradas[pos].invalidaEntrada();
        }
    }

     public void invalidaCachePorEntrada(short entrada){
            ultimoRotuloLiberado = entradas[entrada].getRotulo();
            entradas[entrada].invalidaEntrada();
    }
    
     public short ultimoRotuloLiberado(){
         return ultimoRotuloLiberado;
     }
     
    public int getPosLivre(){
        for(int i = 0; i < assoc; i++){
            if(entradas[i].entradaValida() == false){
                return i;
            }
        }    
        
        return -1;
    }
    
    public boolean temPosLivre(){
        
        if(getPosLivre() == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
