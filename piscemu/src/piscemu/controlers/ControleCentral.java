/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package piscemu.controlers;
import piscemu.models.BarramentoDados;
import piscemu.models.Registrador;
import piscemu.models.Mux2_1;
import piscemu.models.Mux8_1;
import piscemu.models.UC;
import piscemu.models.ULA;
import piscemu.models.ControladorMemoria;
import piscemu.models.ClockListener;
/**
 *
 * @author thiago
 */
public class ControleCentral implements ClockListener{
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
        r0 = new Registrador(barrULA, barrR0);
        r1 = new Registrador(barrULA, barrR1);
        r2 = new Registrador(barrULA, barrR2);
        r3 = new Registrador(barrULA, barrR3);
        r4 = new Registrador(barrULA, barrR4);
        rx = new Registrador(barrULA, barrRX);
        pc = new Registrador(barrULA, barrPC);
        rd = new Registrador(barrULA, barrRD);
        re = new Registrador(barrULA, barrRE);
        ir = new Registrador(barrULA, barrIR);
        mux = new Mux2_1(barrMEM, barrULA, barrMUX);
        muxA = new Mux8_1(barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrRD, barrMUXA);
        muxB = new Mux8_1(barrR0, barrR1, barrR2, barrR3, barrR4, barrRX, barrPC, barrRD, barrMUXB);
        uc = new UC(barrIR);
        ula = new ULA(barrULA, barrMUXA, barrMUXB);
        memoria = new ControladorMemoria(barrRE, barrMEM, barrRD);
    }

    public void t1() {
        
    }

    public void t2() {
        
    }

    public void t3() {
        
    }
    
    
    
    
        
        
        
}
