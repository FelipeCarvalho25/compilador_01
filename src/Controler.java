import Editor_de_Texto.Editor_texto;
import Saida.Mensagem_saida;
import interfacecompilador.Tela_principal;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controler {
    private  Tela_principal tela;
    private  Editor_texto editor;
    private Mensagem_saida mensagem;

    public Controler(Tela_principal tela, Editor_texto editor, Mensagem_saida mensagem_saida){
        this.tela = tela;
        this.editor = editor;
        this.mensagem = mensagem_saida;
    }

    public void iniciar_compilador(){
        tela.setVisible(true);
        tela.setName("Compilador");
        tela.setTitle("Compilador");
        tela.setDefaultCloseOperation(tela.DO_NOTHING_ON_CLOSE);

        tela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (true){
                    System.exit(0);
                }
                else{
                    JOptionPane tela_ao_sair = new JOptionPane();
                    switch (tela_ao_sair.showConfirmDialog(null, "Suas alterações não foram salvas. Deseja salvar?")) {
                        case 0:
                            //cchama botão de salvar da tela.
                            JOptionPane.showConfirmDialog(null, "Vocês está salvando um arquivo.");
                            System.exit(0);
                            break;
                        case 1:
                            //chama saída do programa.
                            System.exit(0);
                            break;
                        default:
                            //não faz nada
                            break;
                    }
                }
            }
        });
    }
}
