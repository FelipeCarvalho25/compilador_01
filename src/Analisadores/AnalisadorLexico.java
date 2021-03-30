package Analisadores;

public class AnalisadorLexico {
    String mensagens = "";
    String program = "";

    public String compilar(String texto){
        String cSentenca = "";
        Automato automato = new Automato();
        this.program = texto;
        if (texto.length() == 0){
            this.mensagens = "Informe alguma sentença. \n";
        }

        char cChar = ' ';

        for(int i =0; i<texto.length(); i++){
            cChar = texto.charAt(i);
            if (cChar == ' ' || cChar == '\n' || cChar == '\t'|| i == texto.length()-1){
                if (i == texto.length()-1){
                    cSentenca += cChar;
                    cSentenca = cSentenca.trim();

                    if(cSentenca.length()!=0){
                        this.mensagens += automato.automatoExecute(cSentenca)+"\n";
                    }
                    cSentenca = "";
                }else{
                    if(cSentenca.length()!=0){
                        this.mensagens += automato.automatoExecute(cSentenca)+"\n";
                    }
                    cSentenca = "";
                }

            }else{
                cSentenca += cChar;
            }
        }
        return mensagens;
    }
    private void analisaPalavraReservada(String sentenca){

    }
    private void analisaIdentificadores(String sentenca){

    }
    private void analisaConstanteNumerica(String sentenca){

    }
    private void analisaConstanteLiteral(String sentenca){

    }
    private void analisaCComentarioLinha(String sentenca){

    }
    private void analisaCComentarioBloco(String sentenca){

    }
    public String getMensagens(){
        return this.mensagens;
    }
}
