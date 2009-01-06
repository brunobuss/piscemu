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
public class ControleCentral{
        BarramentoFlags flags;
        BarramentoSinais barrSin;
        BarramentoDados barrULA;
        BarramentoDados barrR0;
        BarramentoDados barrR1;
        BarramentoDados barrR2;
        BarramentoDados barrR3;
        BarramentoDados barrR4;
        BarramentoDados barrRX;
        BarramentoDados barrPC;
        BarramentoDados barrRD;//RDados
        BarramentoDados barrRE;//REndereço
        BarramentoDados barrIR;
        BarramentoDados barrMUX;
        BarramentoDados barrMUXA;
        BarramentoDados barrMUXB;
        BarramentoDados barrMEM;
        Registrador r0;
        Registrador r1;
        Registrador r2;
        Registrador r3;
        Registrador r4;
        Registrador rx;
        Registrador pc;
        Registrador rd;
        Registrador re;
        Registrador ir;
        Mux2_1 mux;
        Mux8_1 muxA;
        Mux8_1 muxB;
        UC uc;
        ULA ula;
        ControladorMemoria memoria;

    public ControleCentral() {
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
        muxA = new Mux8_1(barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrRD, barrMUXA, Sinais.SINAL_MUXA, barrSin);
        muxB = new Mux8_1(barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrRD, barrMUXB, Sinais.SINAL_MUXB, barrSin);
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
