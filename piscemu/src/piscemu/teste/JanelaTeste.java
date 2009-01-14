/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package piscemu.teste;

import piscemu.views.JanelaSobre;
import piscemu.views.JanelaTutorial;
import java.io.File;
import javax.swing.JFileChooser;
import piscemu.controlers.ControleCentral;

public class JanelaTeste extends javax.swing.JFrame {
    ControleCentral controle;

    public JanelaTeste() {
        initComponents();
        this.janelaSobre = new JanelaSobre();
        this.janelaTutorial = new JanelaTutorial();
        controle = new ControleCentral();
        controle.rodaMicro();
        // Posicionar a janela no centro.
        this.setLocationRelativeTo(null);
        controle.start( );
        atualizaTela();
        setFuncionando(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EMux = new javax.swing.JTextField();
        ER0 = new javax.swing.JTextField();
        ER1 = new javax.swing.JTextField();
        ER2 = new javax.swing.JTextField();
        ER3 = new javax.swing.JTextField();
        ER4 = new javax.swing.JTextField();
        ERx = new javax.swing.JTextField();
        EPC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        EMuxA = new javax.swing.JTextField();
        EMuxB = new javax.swing.JTextField();
        ERd = new javax.swing.JTextField();
        EMem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ERend = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ERi = new javax.swing.JTextField();
        EUla = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        BAtuliza = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        menuConfigurar = new javax.swing.JMenu();
        itemCarregar = new javax.swing.JMenuItem();
        itemReiniciar = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuExecutar = new javax.swing.JMenu();
        itemMicroinstrucao = new javax.swing.JMenuItem();
        itemInstrucao = new javax.swing.JMenuItem();
        itemTodas = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        itemTutorial = new javax.swing.JMenuItem();
        itemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practical Instruction Set Computer Simulator (PISCSim)");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("janelaPrincipal"); // NOI18N
        setResizable(false);

        jLabel1.setText("R0");

        jLabel2.setText("R1");

        jLabel3.setText("R2");

        jLabel4.setText("R4");

        jLabel5.setText("R3");

        jLabel6.setText("RX");

        jLabel7.setText("PC");

        jLabel8.setText("MUX");

        jLabel9.setText("Memoria");

        jLabel10.setText("RD");

        jLabel11.setText("MUX_A");

        jLabel12.setText("MUX_B");

        jLabel13.setText("Rend");

        jLabel14.setText("RI");

        jLabel15.setText("ULA");

        BAtuliza.setText("Atualiza Tela");
        BAtuliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAtulizaActionPerformed(evt);
            }
        });

        menuConfigurar.setMnemonic('c');
        menuConfigurar.setText("Configurar");

        itemCarregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemCarregar.setMnemonic('a');
        itemCarregar.setText("Carregar arquivo");
        itemCarregar.setToolTipText("Clique para carregar o arquivo com as instruções a serem simuladas.");
        itemCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCarregarActionPerformed(evt);
            }
        });
        menuConfigurar.add(itemCarregar);

        itemReiniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemReiniciar.setMnemonic('r');
        itemReiniciar.setText("Reiniciar");
        itemReiniciar.setToolTipText("Clique para reinicia o simulador.");
        itemReiniciar.setEnabled(false);
        itemReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReiniciarActionPerformed(evt);
            }
        });
        menuConfigurar.add(itemReiniciar);

        itemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSair.setMnemonic('s');
        itemSair.setText("Sair");
        itemSair.setToolTipText("Clique para sair.");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });
        menuConfigurar.add(itemSair);

        menuPrincipal.add(menuConfigurar);

        menuExecutar.setMnemonic('e');
        menuExecutar.setText("Executar");

        itemMicroinstrucao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemMicroinstrucao.setMnemonic('m');
        itemMicroinstrucao.setText("Próxima microinstrução");
        itemMicroinstrucao.setToolTipText("Clique para executar a próxima microinstrução.");
        itemMicroinstrucao.setEnabled(false);
        itemMicroinstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMicroinstrucaoActionPerformed(evt);
            }
        });
        menuExecutar.add(itemMicroinstrucao);

        itemInstrucao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itemInstrucao.setMnemonic('i');
        itemInstrucao.setText("Próxima instrução");
        itemInstrucao.setToolTipText("Clique para executar a próxima instrução.");
        itemInstrucao.setEnabled(false);
        itemInstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInstrucaoActionPerformed(evt);
            }
        });
        menuExecutar.add(itemInstrucao);

        itemTodas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        itemTodas.setMnemonic('t');
        itemTodas.setText("Todas instruções");
        itemTodas.setToolTipText("Clique para executar todas as instruções.");
        itemTodas.setEnabled(false);
        itemTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTodasActionPerformed(evt);
            }
        });
        menuExecutar.add(itemTodas);

        menuPrincipal.add(menuExecutar);

        menuAjuda.setMnemonic('a');
        menuAjuda.setText("Ajuda");

        itemTutorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemTutorial.setMnemonic('u');
        itemTutorial.setText("Tutorial");
        itemTutorial.setToolTipText("Clique para exibir as dicas sobre o uso do simulador.");
        itemTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTutorialActionPerformed(evt);
            }
        });
        menuAjuda.add(itemTutorial);

        itemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemSobre.setMnemonic('b');
        itemSobre.setText("Sobre");
        itemSobre.setToolTipText("Clique para exibir informações sobre o simulador e seus autores.");
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(itemSobre);

        menuPrincipal.add(menuAjuda);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EMux, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(ER0, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EMem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(ERd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ERend, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ER1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ER2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(ER3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(EMuxA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(EMuxB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ER4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ERx, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14)
                                                        .addComponent(ERi, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(EPC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BAtuliza))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(EUla, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ER0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ER1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EMux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ER2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ER3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ER4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ERx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ERd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)))
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ERi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BAtuliza)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EMuxA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EMem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ERend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EMuxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EUla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
    System.exit(0);
}//GEN-LAST:event_itemSairActionPerformed

private void itemCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCarregarActionPerformed
    JFileChooser dialogArquivo = new JFileChooser("Carregar arquivo fonte.");
    File arquivoSelecionado;
    
    dialogArquivo.showDialog(this, "Abrir");
    arquivoSelecionado = dialogArquivo.getSelectedFile();
    
    if (arquivoSelecionado != null) {
        System.out.println("Arquivo selecionado: " + arquivoSelecionado.toString());
        setFuncionando(true);
    } else {
        System.out.println("Nenhum arquivo selecionado.");
    }
}//GEN-LAST:event_itemCarregarActionPerformed

private void itemReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReiniciarActionPerformed
    System.out.println("Reiniciar...");
    setFuncionando(false);
}//GEN-LAST:event_itemReiniciarActionPerformed

private void itemMicroinstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMicroinstrucaoActionPerformed
    //System.out.println("Próxima microinstrução...");
    controle.proximaMicro();
    atualizaTela();
    
}//GEN-LAST:event_itemMicroinstrucaoActionPerformed

private void itemInstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInstrucaoActionPerformed
    System.out.println("Próxima instrução...");
}//GEN-LAST:event_itemInstrucaoActionPerformed

private void itemTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTodasActionPerformed
    System.out.println("Executar todas as instruções...");
}//GEN-LAST:event_itemTodasActionPerformed

private void itemTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTutorialActionPerformed
    System.out.println("Exibir tutorial...");
    this.janelaTutorial.setVisible(true);
}//GEN-LAST:event_itemTutorialActionPerformed

private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreActionPerformed
    System.out.println("Exibir sobre...");
    this.janelaSobre.setVisible(true);
}//GEN-LAST:event_itemSobreActionPerformed

private void BAtulizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAtulizaActionPerformed
    atualizaTela();
}//GEN-LAST:event_BAtulizaActionPerformed

private void setFuncionando(boolean state) {
    this.itemReiniciar.setEnabled(state);
    this.itemMicroinstrucao.setEnabled(state);
    this.itemInstrucao.setEnabled(state);
    this.itemTodas.setEnabled(state);    
}
private void atualizaTela(){
    ER0.setText(controle.getR0().getValor() + "");
    ER1.setText(controle.getR1().getValor() + "");
    ER2.setText(controle.getR2().getValor() + "");
    ER3.setText(controle.getR3().getValor() + "");
    ER4.setText(controle.getR4().getValor() + "");
    ERd.setText(controle.getRD().getValor() + "");
    EPC.setText(controle.getPC().getValor() + "");
    ERx.setText(controle.getRX().getValor() + "");
    ERend.setText(controle.getRE().getValor() + "");
    ERi.setText(controle.getIR().getValor() + "");
    EMem.setText(controle.getMEM().getValor() + "");
    EMux.setText(controle.getMUX().getValor() + "");
    EMuxA.setText(controle.getMUXA().getValor() + "");
    EMuxB.setText(controle.getMUXB().getValor() + "");
    EUla.setText(controle.getULA().getValor() + "");
}




    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAtuliza;
    private javax.swing.JTextField EMem;
    private javax.swing.JTextField EMux;
    private javax.swing.JTextField EMuxA;
    private javax.swing.JTextField EMuxB;
    private javax.swing.JTextField EPC;
    private javax.swing.JTextField ER0;
    private javax.swing.JTextField ER1;
    private javax.swing.JTextField ER2;
    private javax.swing.JTextField ER3;
    private javax.swing.JTextField ER4;
    private javax.swing.JTextField ERd;
    private javax.swing.JTextField ERend;
    private javax.swing.JTextField ERi;
    private javax.swing.JTextField ERx;
    private javax.swing.JTextField EUla;
    private javax.swing.JMenuItem itemCarregar;
    private javax.swing.JMenuItem itemInstrucao;
    private javax.swing.JMenuItem itemMicroinstrucao;
    private javax.swing.JMenuItem itemReiniciar;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenuItem itemTodas;
    private javax.swing.JMenuItem itemTutorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuConfigurar;
    private javax.swing.JMenu menuExecutar;
    private javax.swing.JMenuBar menuPrincipal;
    // End of variables declaration//GEN-END:variables
    private JanelaSobre janelaSobre;
    private JanelaTutorial janelaTutorial;

}
