import Editor_de_Texto.Manipulador_arquivo;
import Saida.Mensagem_saida;
import interfacecompilador.Tela_principal;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Controler {
    private  Tela_principal tela;
    private Manipulador_arquivo editor;
    private Mensagem_saida mensagem;

    public Controler(Tela_principal tela, Manipulador_arquivo editor, Mensagem_saida mensagem_saida){
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
                if (tela.getAbriuArquivo() == false && tela.getSalvouArquivo() == true){
                    System.exit(0);
                }
                else{
                    if (tela.getSalvouArquivo() == false){
                        JOptionPane tela_ao_sair = new JOptionPane();
                        switch (tela_ao_sair.showConfirmDialog(null, "Suas alterações não foram salvas. Deseja salvar?")) {
                            case 0:
                                if (tela.salvar_arquivo()){
                                    System.exit(0);
                                }

                                break;
                            case 1:
                                //chama saída do programa.
                                System.exit(0);
                                break;
                            default:
                                //não faz nada
                                break;
                        }
                    }else{
                        System.exit(0);
                    }

                }
            }
        });
    }
}
