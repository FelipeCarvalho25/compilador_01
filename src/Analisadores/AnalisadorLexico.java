package Analisadores;

public class AnalisadorLexico {
    String mensagens = "";
    String program = "";

    public String compilar(String texto){
        this.program = texto;
        mensagens = "codigo funcionando";
        return mensagens;
    }
    public String getMensagens(){
        return this.mensagens;
    }
}
