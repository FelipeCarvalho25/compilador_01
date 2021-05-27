package VMExecucao;

import interfacecompilador.Tela_execucao;

public class Maquina_Virtual_Execucao {
    String codigoExecucao = "";
    private Tela_execucao tela_de_execucao;
    public Maquina_Virtual_Execucao(String codigo){
        codigoExecucao = codigo;
        tela_de_execucao = new Tela_execucao();

    }
    public void executa(){
        if(codigoExecucao.length() == 0){
            tela_de_execucao.setTexto("Programa Executado com sucesso!");
            tela_de_execucao.setDisableInput();
            tela_de_execucao.setVisible(true);
        }
    }
}
