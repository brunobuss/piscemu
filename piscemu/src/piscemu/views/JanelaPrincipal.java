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

package piscemu.views;

import java.io.File;
import javax.swing.JFileChooser;

public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
        this.janelaSobre = new JanelaSobre();
        this.janelaTutorial = new JanelaTutorial();
        
        // Posicionar a janela no centro.
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
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
    System.out.println("Próxima microinstrução...");
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

private void setFuncionando(boolean state) {
    this.itemReiniciar.setEnabled(state);
    this.itemMicroinstrucao.setEnabled(state);
    this.itemInstrucao.setEnabled(state);
    this.itemTodas.setEnabled(state);    
}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCarregar;
    private javax.swing.JMenuItem itemInstrucao;
    private javax.swing.JMenuItem itemMicroinstrucao;
    private javax.swing.JMenuItem itemReiniciar;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenuItem itemTodas;
    private javax.swing.JMenuItem itemTutorial;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuConfigurar;
    private javax.swing.JMenu menuExecutar;
    private javax.swing.JMenuBar menuPrincipal;
    // End of variables declaration//GEN-END:variables
    private JanelaSobre janelaSobre;
    private JanelaTutorial janelaTutorial;
}
