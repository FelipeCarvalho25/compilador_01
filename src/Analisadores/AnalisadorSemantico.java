package Analisadores;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Tabela;
import EstruturasDados.Pilha;

import java.awt.geom.Area;
import java.util.ArrayList;

public class AnalisadorSemantico {
    private String contexto = "";
    private static int VT = 0;
    private static int VP = 0;
    private static int VIT = 0;
    private static int tipo = 0;
    private static String var_indexada = "";
    private Pilha pilha_de_desvios ;
    private static ArrayList<AreaInstrucao> area_instrucao;
    private static int ponteiro = 1;
    private static ArrayList<Tabela> tabela_simbolos;
    private ArrayList<Tabela> tupla;

    public AnalisadorSemantico(){
        pilha_de_desvios = new Pilha();
        area_instrucao = new ArrayList<>();
        tabela_simbolos =  new ArrayList<>();
        tupla = new ArrayList<>();
    }
    public boolean analisarSemantica(String codigo) {
        boolean sucesso = true;
        switch (codigo) {
            case "#1":
                area_instrucao.add(new AreaInstrucao(ponteiro, "STP", 0));
                break;
            case "#2":
                tabela_simbolos = tupla.add(identificador, "0", "-");
                break;
            case "#3":
                contexto = "constante";
                VIT = 0;
                break;
            case 4:
                VP = VP + VIT;
                if(tipo==1 | tipo==5){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "ALI", VP));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==2 | tipo==6){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "ALR", VP));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==3 | tipo==7){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "ALS", VP));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==4){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "ALB", VP));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==1 | tipo==2 | tipo==3 | tipo==4){
                    VP = 0;
                    VIT = 0;
                }
                break;
            case 5:
                if(tipo==5){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "LDI", valor));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==6){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "LDR", valor));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==7){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "LDS", valor));
                    ponteiro = ponteiro + 1;
                }
                area_instrucao.add(new AreaInstrucao(ponteiro, "STC", VP));
                ponteiro = ponteiro + 1;
                VP = 0;
                break;
            case 6:
                contexto = "variável";
                break;
            case 7:
                 if(contexto == "variável"){
                    tipo = 1;
                }else{
                    tipo = 5;
                }

                break;
            case 8:
                if (contexto == "variável") {
                    tipo = 6;
                } else {
                    tipo = 2;
                }
                break;
            case 9:
                if(contexto == "variável"){
                    tipo = 3;
                }else{
                    tipo = 7;
                }
                break;

            case 10:
                if(contexto == "variável"){
                    tipo = 4;
                }else{
                    System.out.println("ERRO: tipo inválido para constante");
                }
                break;
            case 11:
                if(tabela_simbolos.indexOf(identificador) != -1){
                    System.out.println("ERRO: identificador já declarado");
                }else{
                    VT = VT + 1;
                    VP = VP + 1;
                    tabela_simbolos = tupla.add(identificador, tipo, VT, "-");
                }
                break;
            case 12:
                if(contexto == "variável") {
                    if (tabela_simbolos.indexOf(identificador) != -1) {
                        System.out.println("ERRO: identificador já declarado");
                    } else {
                        var_indexada = "falso";
                        tabela_simbolos.add(identificador);
                    }
                }else{
                    var_indexada = "falso";
                    tabela_simbolos.add(identificador);
                }
                break;
            case 13:
                switch(contexto){
                    case "variável":
                        if(var_indexada == "falso"){
                            VT = VT+1;
                            VP = VP+1;
                            tabela_simbolos = tupla.add(identificador, tipo, VT, "-");
                        }else{
                            VIT = VIT + constante_inteira;
                            tabela_simbolos = tupla.add(identificador, tipo, VT, constante_inteira);
                            VT = VT + constante_inteira;
                        }
                        break;
                    case "atribuição":
                        //preciso ajustar a tabela de simbolos
                        if((tabela_simbolos.indexOf(identificador) != -1) &&
                                tabela_simbolos[tabela_simbolos.indexOf(identificador)].tipo == 1){
                            String atr1 = tabela_simbolos[tabela_simbolos.indexOf(identificador)].atr1;
                            String atr2 = tabela_simbolos[tabela_simbolos.indexOf(identificador)].atr2;

                            if(atr2 == "-"){
                                if(var_indexada == "falso"){
                                    //armazenar o "atributo 1" em uma lista de atributos
                                }else{
                                    //erro
                                }
                            }else{
                                if(var_indexada == "verdadeiro"){
                                    //armazenar o "atributo 1" + constante inteira – 1 em uma lista de atributos
                                }else{
                                    //erro: “identificador de variável indexada exige índice”
                                }
                            }

                        }else{
                            //erro: “identificador não declarado ou de constante”
                        }
                        break;
                    case "entrada dados":
                        break;
                }
                break;
            case 14:
                tabela_simbolos = tupla.add(identificador, tipo, VT, constante_inteira);
                var_indexada = "verdadeiro";
                break;
            case 15:
                contexto = "atribuição";
                break;
            case 16:
                break;
            case 17:
                contexto = "entrada de dados";
                break;
            case 18:
                area_instrucao.add(new AreaInstrucao(ponteiro, "WRT", 0));
                ponteiro = ponteiro + 1;
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                 area_instrucao.add(new AreaInstrucao(ponteiro, "LDI", const_inteira));
                ponteiro = ponteiro + 1;
                break;
            case 22:
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDR", const_real));
                ponteiro = ponteiro + 1;
                break;
            case 23:
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDS", const_literal));
                ponteiro = ponteiro + 1;
                break;
            case 24:
                 break;
            case 25:
                 break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                 break;
            case 29:
                 break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                area_instrucao.add(new AreaInstrucao(ponteiro, "EQL", 0));
                ponteiro = ponteiro + 1;
                break;
            case 34:
                area_instrucao.add(new AreaInstrucao(ponteiro, "DIF", 0));
                ponteiro = ponteiro + 1;
                break;
            case 35:
                area_instrucao.add(new AreaInstrucao(ponteiro, "SMR", 0));
                ponteiro = ponteiro + 1;
                break;
            case 36:
                area_instrucao.add(new AreaInstrucao(ponteiro, "BGR", 0));
                ponteiro = ponteiro + 1;
                break;
            case 37:
                area_instrucao.add(new AreaInstrucao(ponteiro, "SME", 0));
                ponteiro = ponteiro + 1;
                break;
            case 38:
                area_instrucao.add(new AreaInstrucao(ponteiro, "BGE", 0));
                ponteiro = ponteiro + 1;
                break;
            case 39:
                area_instrucao.add(new AreaInstrucao(ponteiro, "ADD", 0));
                ponteiro = ponteiro + 1;
                break;
            case 40:
                area_instrucao.add(new AreaInstrucao(ponteiro, "SUB", 0));
                ponteiro = ponteiro + 1;
                break;
            case 41:
                area_instrucao.add(new AreaInstrucao(ponteiro, "OR", 0));
                ponteiro = ponteiro + 1;
                break;
            case 42:
                area_instrucao.add(new AreaInstrucao(ponteiro, "MUL", 0));
                ponteiro = ponteiro + 1;
                break;
            case 43:
                area_instrucao.add(new AreaInstrucao(ponteiro, "DIV", 0));
                ponteiro = ponteiro + 1;
                break;
            case 44:
                if(tipo == 1) {
                    area_instrucao.add(new AreaInstrucao(ponteiro, "DIVIR", 0));
                    ponteiro = ponteiro + 1;
                }
                break;
            case 45:
                if(tipo == 1) {
                    area_instrucao.add(new AreaInstrucao(ponteiro, "MOD", 0));
                    ponteiro = ponteiro + 1;
                }
                break;
            case 46:
                area_instrucao.add(new AreaInstrucao(ponteiro, "AND", 0));
                ponteiro = ponteiro + 1;
                break;
            case 47:
                area_instrucao.add(new AreaInstrucao(ponteiro, "POT", 0));
                ponteiro = ponteiro + 1;
                break;
            case 48:
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDB", "TRUE"));
                ponteiro = ponteiro + 1;
                break;
            case 49:
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDB", "FALSE"));
                ponteiro = ponteiro + 1;
                break;
            case 50:
                area_instrucao.add(new AreaInstrucao(ponteiro, "NOT", 0));
                ponteiro = ponteiro + 1;
                break;
        }

        return sucesso;
    }
}
