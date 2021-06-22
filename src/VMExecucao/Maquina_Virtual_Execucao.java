package VMExecucao;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Pilha;
import interfacecompilador.Tela_execucao;

import java.util.ArrayList;

public class Maquina_Virtual_Execucao {
    ArrayList<AreaInstrucao> codigoExecucao;
    private static Pilha pilhaAuxiliar;
    private Tela_execucao tela_de_execucao;
    public Maquina_Virtual_Execucao(ArrayList<AreaInstrucao> codigo){
        codigoExecucao = codigo;
        tela_de_execucao = new Tela_execucao();
        pilhaAuxiliar = new Pilha();

    }
    public void executa(){
        if(codigoExecucao.size() == 1){
            tela_de_execucao.setTexto("Programa Executado com sucesso!");
            tela_de_execucao.setDisableInput();
            tela_de_execucao.setVisible(true);
        }
    }
}
