/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.controlers;
import piscemu.models.TDado;
import piscemu.models.BarramentoDados;
import piscemu.models.BarramentoSinais;
import piscemu.models.Registrador;
import piscemu.models.Mux2_1;
import piscemu.models.Mux8_1;
import piscemu.models.UC;
import piscemu.models.ULA;
import piscemu.models.ControladorMemoria;
import piscemu.models.Sinais;
import piscemu.models.BarramentoFlags;
/**
 *
 * @author thiago
 */
public class ControleCentral extends Thread{
    private final static int MODO_DIRETO = 0;
    private final static int MODO_INTRUCAO = 0;
    private final static int MODO_MICRO = 0;
    
    private int modoExecucao;   
    private boolean instrucao;
    private boolean micro;
    private boolean continua;
    private BarramentoFlags flags;
    private BarramentoSinais barrSin;
    private BarramentoDados barrULA;
    private BarramentoDados barrR0;
    private BarramentoDados barrR1;
    private BarramentoDados barrR2;
    private BarramentoDados barrR3; 
    private BarramentoDados barrR4;
    private BarramentoDados barrRX;
    private BarramentoDados barrPC;
    private BarramentoDados barrRD;//RDados
    private BarramentoDados barrRE;//REndereço
    private BarramentoDados barrIR;
    private BarramentoDados barrMUX;
    private BarramentoDados barrMUXA;
    private BarramentoDados barrMUXB;
    private BarramentoDados barrMEM;
    private Registrador r0;
    private Registrador r1;
    private Registrador r2;
    private Registrador r3;
    private Registrador r4;
    private Registrador rx;
    private Registrador pc;
    private Registrador rd;
    private Registrador re;
    private Registrador ir;
    private Mux2_1 mux;
    private Mux8_1 muxA;
    private Mux8_1 muxB;
    private UC uc;
    private ULA ula;
    private ControladorMemoria memoria;

    public ControleCentral() {
        instrucao = false;
        micro = false;
        continua = true;
        flags = new BarramentoFlags();
        barrULA = new BarramentoDados();
        barrR0 = new BarramentoDados();
        barrR1 = new BarramentoDados();
        barrR2 = new BarramentoDados();
        barrR3 = new BarramentoDados();
        barrR4 = new BarramentoDados();
        barrRX = new BarramentoDados();
        barrPC = new BarramentoDados();
        barrRD = new BarramentoDados();
        barrRE = new BarramentoDados();
        barrIR = new BarramentoDados();
        barrMUX = new BarramentoDados();
        barrMUXA = new BarramentoDados();
        barrMUXB = new BarramentoDados();
        barrMEM = new BarramentoDados();
        r0 = new Registrador(barrULA, barrR0, Sinais.SINAL_R0, barrSin);
        r1 = new Registrador(barrULA, barrR1, Sinais.SINAL_R1, barrSin);
        r2 = new Registrador(barrULA, barrR2, Sinais.SINAL_R2, barrSin);
        r3 = new Registrador(barrULA, barrR3, Sinais.SINAL_R3, barrSin);
        r4 = new Registrador(barrULA, barrR4, Sinais.SINAL_R4, barrSin);
        rx = new Registrador(barrULA, barrRX, Sinais.SINAL_RX, barrSin);
        pc = new Registrador(barrULA, barrPC, Sinais.SINAL_PC, barrSin);
        rd = new Registrador(barrMUX, barrRD, Sinais.SINAL_RD, barrSin);
        re = new Registrador(barrULA, barrRE, Sinais.SINAL_RE, barrSin);
        ir = new Registrador(barrULA, barrIR, Sinais.SINAL_IR, barrSin);
        mux = new Mux2_1(barrMEM, barrULA, barrMUX, Sinais.SINAL_MUX, barrSin);
        muxA = new Mux8_1(barrRD, barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrMUXA, Sinais.SINAL_MUXA, barrSin);
        muxB = new Mux8_1(barrRD, barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrMUXB, Sinais.SINAL_MUXB, barrSin);
        uc = new UC(barrIR, barrSin, flags);
        ula = new ULA(barrULA, barrMUXA, barrMUXB, barrSin, Sinais.SINAL_ULA, flags);
        memoria = new ControladorMemoria(barrRE, barrMEM, barrRD, Sinais.SINAL_MEM, barrSin);
        
        uc.addListenerT1(muxA);
        uc.addListenerT1(muxB);
        uc.addListenerT1(mux);
        
        uc.addListenerT2(ula);
        
        uc.addListenerT3(re);
        uc.addListenerT3(ir);
        uc.addListenerT3(rd);
        uc.addListenerT3(r0);
        uc.addListenerT3(r1);
        uc.addListenerT3(r2);
        uc.addListenerT3(r3);
        uc.addListenerT3(r4);
        uc.addListenerT3(rx);
        uc.addListenerT3(pc);
        uc.addListenerT3(memoria);

        uc.addListenerMS(memoria);
    }

    @Override
    public void run() {
        int cod = UC.COD_FIM_INSTRUCAO;
        
        while(continua){
            if(modoExecucao == MODO_INTRUCAO && cod == UC.COD_FIM_INSTRUCAO){
                while(instrucao == false){
                    try{
                        Thread.sleep(100);    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }
                instrucao = false;
            }
            if(modoExecucao == MODO_MICRO){
                while(micro == false){
                    try{
                        Thread.sleep(100);    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                micro = false;
            }
            
            cod = uc.proximaMicro();
        }                
    }
    
    public void para(){
        continua = false;
    }
    
    public void rodaDireto(){
        modoExecucao = MODO_DIRETO;
        instrucao = true;
        micro = true;
        
    }
    
    public void rodaInstrucao(){
        modoExecucao = MODO_INTRUCAO;
        micro = true;
    }
    
    public void rodaMicro(){
        modoExecucao = MODO_MICRO;
        instrucao = true;
    }
    
    public void proximaInstrucao(){
        instrucao = true;
    }
    
    public void proximaMicro(){
        micro = true;
    }
    
    public TDado getR0(){
        return r0.getDado();
    }
    
    public TDado getR1(){
        return r1.getDado();
    }
    
    public TDado getR2(){
        return r2.getDado();
    }
    
    public TDado getR3(){
        return r3.getDado();
    }
    
    public TDado getR4(){
        return r4.getDado();
    }
    
    public TDado getRX(){
        return rx.getDado();
    }
    
    public TDado getPC(){
        return pc.getDado();
    }
    
    public TDado getRD(){
        return rd.getDado();
    }
    
    public TDado getRE(){
        return re.getDado();
    }
    
    public TDado getIR(){
        return ir.getDado();
    }
    
    public TDado getMUX(){
        return mux.getDado();
    }
    
    public TDado getMUXA(){
        return muxA.getDado();
    }
    
    public TDado getMUXB(){
        return muxB.getDado();
    }
    
    public TDado getULA(){
        return ula.getDado();
    }
    
    public TDado getMEM(){
        return memoria.getDado();
    }
}
