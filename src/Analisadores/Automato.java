package Analisadores;

public class Automato {
    String[][] aEstados;
    String[][] aEstadosFinais;
    char[] vAlfabeto;

    public Automato(String[][] matrizTransicao, String[][] matrizEstFinais, char[] vAlfabeto) {
        this.aEstados = matrizTransicao;
        this.aEstadosFinais = matrizEstFinais;
        this.vAlfabeto = vAlfabeto;

    }
    public Automato() {
        vAlfabeto = new char[27];
        int i = 0;
        for(char a='a';a<='z';a++)
        {
            i++;
            vAlfabeto[i] = a;
        }
    }
    private int getEstado(String estado, boolean inicial){
        int NewEstado = 0;
        if (inicial){
            for (int index = 0; index < aEstadosFinais.length;index ++){
                if (aEstadosFinais[index][1]=="*"){
                    NewEstado = index;
                }
            }
        }else{
            for (int index = 0; index < aEstadosFinais.length;index ++){
                if (aEstadosFinais[index][0]==estado){
                    NewEstado = index;
                }
            }
        }


        return NewEstado;
    }

    public String automatoExecute(String cSentenca) {
        String cRetorno = "";
        char simbolo = ' ';
        int estado = 0;
        int nSimbol = -1;
        int nOld = 0;

        estado = getEstado("", true);

        if(cSentenca.length() == 0){
            return "";
        }

        for(int index = 0; index < cSentenca.length(); index ++){
            simbolo = cSentenca.charAt(index);
            nOld = nSimbol;
            for(int i = 0; i< vAlfabeto.length; i++){
                if (vAlfabeto[i] == simbolo){
                    nSimbol = i;
                    break;
                }
            }
            if (nSimbol != nOld){
                estado = getEstado(aEstados[estado][nSimbol], false);
                nSimbol = -1;
            }
            else{
                cRetorno = "ERRO: simbolo inválido";

                break;
            }
        }
        if (aEstadosFinais[estado][1] == "1" && cRetorno.length() == 0){
            cRetorno = "Sentença válida";
        }else if(cRetorno.length() == 0){
            cRetorno = "ERRO: setença inválida";
        }



        return cRetorno;
    }
}
