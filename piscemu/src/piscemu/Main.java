package piscemu;

import piscemu.views.JanelaPrincipal;

/*
 * Esta classe deverá somente fazer o "bootstrap" do emulador
 * Criando a janela principal e instanciando o control principal.
 * Após isso o controle total da execução será passada a este control.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //JanelaTeste janelaPrincipal = new JanelaTeste();
        //janelaPrincipal.setVisible(true);

        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setVisible(true);
              
    }

}
