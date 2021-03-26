import Editor_de_Texto.Editor_texto;
import Saida.Mensagem_saida;
import interfacecompilador.Tela_principal;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Compilador {
    public static void main(String[] args) {
        Tela_principal tela = new Tela_principal();
        Editor_texto editor = new Editor_texto();
        Mensagem_saida mensagem = new Mensagem_saida();
        Controler controlador = new Controler(tela,editor,mensagem);
        controlador.iniciar_compilador();
    }
}
