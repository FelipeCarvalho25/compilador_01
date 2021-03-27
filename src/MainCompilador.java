import Editor_de_Texto.Manipulador_arquivo;
import Saida.Mensagem_saida;
import interfacecompilador.Tela_principal;

public class MainCompilador {
    public static void main(String[] args) {
        Tela_principal tela = new Tela_principal();
        Manipulador_arquivo editor = new Manipulador_arquivo();
        Mensagem_saida mensagem = new Mensagem_saida();
        Controler controlador = new Controler(tela,editor,mensagem);
        controlador.iniciar_compilador();
    }
}
