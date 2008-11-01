package piscemu.teste;

import piscemu.models.BarramentoDados;
import piscemu.models.ULA;
import piscemu.models.TDados;

public class TesteULA{

    public TesteULA(String[] args) {
        BarramentoDados barraA = new BarramentoDados();
        BarramentoDados barraB = new BarramentoDados();
        BarramentoDados barraS = new BarramentoDados();
        boolean[] sin = new boolean[ULA.QTDSinais];
        
        ULA ula = new ULA(barraS, barraA, barraB);
        
        barraA.setDados(new TDados(5));
        barraB.setDados(new TDados(6));

        sin[0] = false; sin[1] = false; sin[2] = false; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("add");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = false; sin[2] = false; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println("sub");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = false; sin[2] = true; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("A");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/
        sin[0] = false; sin[1] = false; sin[2] = true; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println("comp");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = true; sin[2] = false; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("and");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = true; sin[2] = false; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println("ou");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = true; sin[2] = true; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("not");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = false; sin[1] = true; sin[2] = true; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println("zera");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = true; sin[1] = false; sin[2] = false; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("neg");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        barraA.setDados(new TDados(64));
        sin[0] = true; sin[1] = false; sin[2] = false; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println(">>");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = true; sin[1] = false; sin[2] = true; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("<<");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = true; sin[1] = false; sin[2] = true; sin[3] = true;
        ula.setSinal(sin);
        
        System.out.println(">>");
        System.out.println(barraS.getDados().getDado());
/******************************************************************************/        
        sin[0] = true; sin[1] = true; sin[2] = false; sin[3] = false;
        ula.setSinal(sin);
        
        System.out.println("<<");
        System.out.println(barraS.getDados().getDado());

    }

}
