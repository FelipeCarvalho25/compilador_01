package Analisadores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
    String mensagens = "";
    String program = "";

    private BufferedReader codigoFonte;
    private String linha;
    private String caractere;
    private String palavra = "";
    private final List delimitadores = new ArrayList();
    private boolean inComment = false;
    private String numerica;
    private String identificador;
    private String literais;
    private final List operRelacionais = new ArrayList();
    private final List reservadas = new ArrayList();
    private final List operAtribuicao = new ArrayList();
    private final List<Elemento> tokens = new ArrayList();
    private String nomeArquivo;

    public AnalisadorLexico(String pathFile){
        try {
            int i = 10;
            this.nomeArquivo = pathFile;
            numerica = ("^\\d+|^\\d+\\.?\\d+");
            identificador = ("^\\D\\w+|^\\D\\w?$");
            literais = ("^\".*\"$");
            delimitadores.add(" ");
            delimitadores.add(",");
            delimitadores.add(";");
            delimitadores.add(":");
            delimitadores.add("(");
            delimitadores.add(")");
            delimitadores.add("\\n");
            delimitadores.add("{");
            delimitadores.add("}");

            operRelacionais.add("==");
            operRelacionais.add("!=");
            operRelacionais.add(">=");
            operRelacionais.add("<=");
            operRelacionais.add(">");
            operRelacionais.add("<");

            operAtribuicao.add("=");
            operAtribuicao.add("+=");
            operAtribuicao.add("-=");
            operAtribuicao.add("*=");
            operAtribuicao.add("/=");
            operAtribuicao.add("%=");
            operAtribuicao.add("++");
            operAtribuicao.add("--");

            reservadas.add("#include");
            reservadas.add("<stdio.h>");

            reservadas.add("<stdlib.h>");
            reservadas.add("void");
            reservadas.add("int");
            reservadas.add("int*");
            reservadas.add("int**");
            reservadas.add("char");
            reservadas.add("char*");
            reservadas.add("char**");
            reservadas.add("float");
            reservadas.add("float*");
            reservadas.add("float**");
            reservadas.add("long");
            reservadas.add("long*");
            reservadas.add("long**");
            reservadas.add("double");
            reservadas.add("double*");
            reservadas.add("double**");
            reservadas.add("_Bool");
            reservadas.add("_Bool*");
            reservadas.add("_Bool**");
            reservadas.add("struct");
            reservadas.add("typedef");
            reservadas.add("if");
            reservadas.add("else");
            reservadas.add("while");
            reservadas.add("do");
            reservadas.add("for");
            reservadas.add("return");
            reservadas.add("break");
            reservadas.add("switch");
            reservadas.add("case");
            reservadas.add("continue");
            reservadas.add("printf");

            codigoFonte = new BufferedReader(new FileReader(pathFile));
        } catch (FileNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
    }

    public void analisar() throws IOException {
        int nLine = 0;
        while (true){
            nLine++;

            linha = codigoFonte.readLine();
            if (linha == null)
                break;

            int size = linha.length();
            linha = linha.split("\r")[0];
            caractere = "";

            for (int i = 0; i < size;i++){
                caractere = linha.substring(i,i+1);
                if (delimitadores.contains(caractere)){
                    if ((!inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                            "//"))){
                        palavra = "";
                        break;
                    }
                    if ((!inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                            "/*"))){
                        palavra = "";
                        inComment = true;
                    }
                    if ((inComment) && (palavra.length() >= 2) && (palavra.substring(0,2).equals(
                            "*/"))){
                        palavra = "";
                        inComment = false;
                    }

                    if (!inComment){
                        if ((!palavra.equals("")) && (!palavra.contains("/*")))
                            this.addToken(palavra,nLine);

                        //alinhar o token correspondente
                    }
                    palavra = "";

                }
                else
                    palavra = palavra + caractere;
            }

        }
        for(Elemento elemento:tokens){
            mensagens += elemento.toString();
        }

    }

    private void addToken(String palavra,int nLine) {
        if (palavra.matches(numerica)){
            Elemento elemento = new Elemento();
            elemento.setToken("NUMÉRICO");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }

        if (palavra.matches(literais)){
            Elemento elemento = new Elemento();
            elemento.setToken("LITERAL");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }

        if (operRelacionais.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken("OPER RELACIONAL");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }

        if (reservadas.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken(palavra);
            tokens.add(elemento);
            return;
        }
        if (operAtribuicao.contains(palavra)){
            Elemento elemento = new Elemento();
            elemento.setToken("OPER ATRIBUIÇÃO");
            elemento.setLexema(palavra);
            tokens.add(elemento);
            return;
        }
        if(!palavra.equals(reservadas)){
            if (palavra.matches(identificador)){
                Elemento elemento = new Elemento();
                elemento.setToken("IDENTIFICADOR");
                elemento.setLexema(palavra);
                tokens.add(elemento);
                Simbolo simbolo = new Simbolo();
                simbolo.setNome(palavra);
                Simbolo.addSimbolo(simbolo);
                return;
            }

        }


        //Error erro = new ErrorLexico();
        mensagens += 101;
        mensagens +="- Identificador desconhecido: " + palavra + " - ";
        mensagens +=this.nomeArquivo +  " - ";
        mensagens +=nLine;
        //mensagens +=erro;

    }



    public List<Elemento> getTokens(){
        return tokens;
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
