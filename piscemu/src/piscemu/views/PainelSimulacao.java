package piscemu.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PainelSimulacao extends JPanel {

    private Image imagemFundo;
    
    private String R0;
    private String R1;
    private String R2;
    private String R3;
    private String R4;
    private String RX;
    private String RY;
    private String PC;
    private String IR;
    private String UC;
    private String ULA;
    private String MUXC;
    private String MUXA;
    private String MUXB;
    private String RDados;
    private String REndereco;

    public PainelSimulacao() {
        this.imagemFundo = new ImageIcon("src/piscemu/views/imagemFundo.png").getImage();

        Dimension size = new Dimension(imagemFundo.getWidth(null), imagemFundo.getHeight(null));

        this.R0 = "";
        this.R1 = "";
        this.R2 = "";
        this.R3 = "";
        this.R4 = "";
        this.RX = "";
        this.RY = "";
        this.PC = "";
        this.IR = "";
        this.UC = "";
        this.ULA = "";
        this.MUXA = "";
        this.MUXB = "";
        this.MUXC = "";
        this.RDados = "";
        this.REndereco = "";

        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setLayout(null);
    }

    public void setR0(String novoValor) {
        this.R0 = novoValor;
    }

    public void setR1(String novoValor) {
        this.R1 = novoValor;
    }

    public void setR2(String novoValor) {
        this.R2 = novoValor;
    }

    public void setR3(String novoValor) {
        this.R3 = novoValor;
    }

    public void setR4(String novoValor) {
        this.R4 = novoValor;
    }

    public void setRX(String novoValor) {
        this.RX = novoValor;
    }

    public void setRY(String novoValor) {
        this.RY = novoValor;
    }

    public void setPC(String novoValor) {
        this.PC = novoValor;
    }

    public void setIR(String novoValor) {
        this.IR = novoValor;
    }

    public void setUC(String novoValor) {
        this.R0 = novoValor;
    }

    public void setULA(String novoValor) {
        this.ULA = novoValor;
    }

    public void setMUXA(String novoValor) {
        this.MUXA = novoValor;
    }

    public void setMUXB(String novoValor) {
        this.MUXB = novoValor;
    }

    public void setMUXC(String novoValor) {
        this.MUXC = novoValor;
    }

    public void setRDados(String novoValor) {
        this.RDados = novoValor;
    }

    public void setREndereco(String novoValor) {
        this.R0 = novoValor;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(imagemFundo, 0, 0, null);
    }
}
