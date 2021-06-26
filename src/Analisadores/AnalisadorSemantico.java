package Analisadores;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Tabela;
import EstruturasDados.Pilha;

import java.util.ArrayList;
import java.util.Stack;

public class AnalisadorSemantico {
    private static String contexto = "";
    private static int VT = 0;
    private static int VP = 0;
    private static int VIT = 0;
    private static int tipo = 0;
    private static int ponteiro = 1;
    private static boolean var_indexada = false;
    private static Stack pilha_de_desvios ;
    private static ArrayList<Tabela> tabela_simbolos;
    private static ArrayList<AreaInstrucao> area_instrucao;
    private static Pilha pilhaAuxiliar;
    private static int numErrSemantico = 0;
    private static String mensagensErros = "";
    private  static Stack pilha2;

    public AnalisadorSemantico(){
        pilha_de_desvios = new Stack();
        area_instrucao = new ArrayList<>();
        tabela_simbolos =  new ArrayList<>();
        pilhaAuxiliar = new Pilha();
        pilha2 = new Stack();
    }

    public ArrayList<AreaInstrucao> getCodIntermed(){
        return area_instrucao;
    }
    public static boolean analisarSemantica(String codigo, String valor, int linha, int coluna) {

        boolean sucesso = true;
        switch (codigo) {
            case "#1":
                area_instrucao.add(new AreaInstrucao(ponteiro, "STP", 0));
                break;
            case "#2":
                tabela_simbolos.add(new Tabela("identificador", 0,'-','-'));
                break;
            case "#3":
                contexto = "constante";
                VIT = 0;
                break;
            case "#4":
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
            case "#5":
                if(tipo==5){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "LDI", Integer.parseInt(valor)));
                    ponteiro = ponteiro + 1;
                }
                if(tipo==6){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "LDR", Float.parseFloat(valor)));
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
            case "#6":
                contexto = "variável";
                break;
            case "#7":
                 if(contexto == "variável"){
                    tipo = 1;
                }else{
                    tipo = 5;
                }

                break;
            case "#8":
                if (contexto == "variável") {
                    tipo = 6;
                } else {
                    tipo = 2;
                }
                break;
            case "#9":
                if(contexto == "variável"){
                    tipo = 3;
                }else{
                    tipo = 7;
                }
                break;

            case "#10":
                if(contexto == "variável"){
                    tipo = 4;
                }else{
                    numErrSemantico += 1;
                    mensagensErros += "\nERRO(14):Tipo inválido para constante em decklaração de constantes.\nLinha " + linha + " coluna "+ coluna + "";
                }
                break;
            case "#11":
                if(containsTabela(valor) ){
                    numErrSemantico += 1;
                    mensagensErros += "\nERRO(15):Identificador já declarado. \nLinha " + linha + " coluna "+ coluna + "";
                }else{
                    VT = VT + 1;
                    VP = VP + 1;
                    tabela_simbolos.add (new Tabela(valor, tipo, String.valueOf(VT).charAt(0), '-'));
                }
                break;
            case "#12":
                if(contexto == "variável") {
                    if (containsTabela(valor) ) {
                        numErrSemantico += 1;
                        mensagensErros +="\nERRO(15):Identificador já declarado.\n Linha " + linha + " coluna " + coluna + "";
                    } else {
                        var_indexada = false;
                        //pilhaAuxiliar.empilhar(valor);
                        pilha2.push(valor);
                    }
                }else{
                    var_indexada = false;
                    //pilhaAuxiliar.empilhar(valor);
                    pilha2.push(valor);
                }
                break;

            case "#13":
                if(!pilha2.empty()){
                    valor = pilha2.pop().toString();
                }
                if(contexto == "variável"){
                    if(var_indexada == false){
                        VT = VT+1;
                        VP = VP+1;
                        tabela_simbolos.add (new Tabela(valor, tipo, String.valueOf(VT).charAt(0), '-'));
                    }else{
                        int contante_int = Integer.parseInt(pilha2.pop().toString());
                        VIT = VIT + contante_int;
                        tabela_simbolos.add (new Tabela(valor, tipo, String.valueOf(VT).charAt(0), (char)contante_int));
                        VT = VT + contante_int;
                    }
                }else

                if(contexto == "atribuição"){
                    //preciso ajustar a tabela de simbolos
                    int index = indexTabela(valor);
                    if((containsTabela(valor) ) &&

                            tabela_simbolos.get(index).categoria == 1){
                        char atr1 = tabela_simbolos.get(index).atributo1;
                        char atr2 = tabela_simbolos.get(index).atributo2;

                        if(atr2 == '-'){
                            if(var_indexada == false){
                                //pilhaAuxiliar.empilhar(String.valueOf(atr1));
                                pilha2.push(String.valueOf(atr1));
                                System.out.println(atr1);
                            }else{
                                numErrSemantico += 1;
                                mensagensErros +="ERRO(16):Identificador de variável não indexada em comando de atribuição.\nLinha " + linha + " coluna " + coluna + "";
                            }
                        }else{
                            if(var_indexada == true){
                                //pilhaAuxiliar.empilhar(" " + ((int)atr1 + Integer.parseInt(pilha2.pop()) -1));
                                pilha2.push(" " + (Integer.parseInt(String.valueOf(atr1)) + Integer.parseInt(pilha2.pop().toString()) -1));
                                //armazenar o "atributo 1" + constante inteira – 1 em uma lista de atributos
                            }else{
                                //erro: “identificador de variável indexada exige índice”
                                numErrSemantico += 1;
                                mensagensErros +="ERRO(17):Identificador de variável indexada exige índice em comando de atribuição.\nLinha " + linha + " coluna "+ coluna + "";
                            }
                        }

                    }else{
                        numErrSemantico += 1;
                        //erro: “identificador não declarado ou de constante”
                        mensagensErros +="ERRO(18):Identificador não declarado ou de constante em entrada de dados.\nLinha " + linha + " coluna "+ coluna + "";
                    }
                }
                else
                if(contexto == "entrada de dados"){
                    int index = indexTabela(valor);
                    if((containsTabela(valor) ) &&
                            tabela_simbolos.get(index).categoria == 1){
                        char atr1 = tabela_simbolos.get(index).atributo1;
                        char atr2 = tabela_simbolos.get(index).atributo2;
                        int categoria = tabela_simbolos.get(index).categoria;

                        if(atr2 == '-'){
                            if(var_indexada == false){
                                area_instrucao.add(new AreaInstrucao(ponteiro, "REA", categoria));
                                ponteiro += 1;
                                area_instrucao.add(new AreaInstrucao(ponteiro, "STR", Integer.parseInt(String.valueOf(atr1))));
                                ponteiro += 1;
                            }else{
                                numErrSemantico += 1;
                                mensagensErros +="ERRO(16):Identificador de variável não indexada em entrada de dados.\nLinha " + linha + " coluna "+ coluna ;
                            }
                        }else{
                            if(var_indexada == true){
                                int constante_int = Integer.parseInt(pilha2.pop().toString());
                                area_instrucao.add(new AreaInstrucao(ponteiro, "REA", categoria));
                                ponteiro += 1;
                                area_instrucao.add(new AreaInstrucao(ponteiro, "STR", Integer.parseInt(String.valueOf(atr1)) + constante_int -1));
                                ponteiro += 1;
                            }else{
                                //erro: “identificador de variável indexada exige índice”
                                numErrSemantico += 1;
                                mensagensErros +="ERRO(17):Identificador de variável indexada exige índice em entrada de dados.\nLinha " + linha + " coluna "+ coluna ;
                            }
                        }

                    }else{
                        numErrSemantico += 1;
                        //erro: “identificador não declarado ou de constante”
                        mensagensErros +="ERRO(18): identificador não declarado ou de constante em entrada de dados.\nLinha " + linha + " coluna "+ coluna ;
                    }

                }
                break;
            case "#14":
                //tabela_simbolos.add  (new Tabela(valor, tipo, VT, constante_inteira));
                //pilhaAuxiliar.empilhar(valor);
                pilha2.push(valor);
                var_indexada = true;
                break;
            case "#15":
                contexto = "atribuição";
                break;
            case "#16":
                /*gerar instrução: (ponteiro, STR, "atributo"), para cada atributo armazenado na lista de atributos pela ação #13
                ponteiro  ponteiro + 1, para cada instrução STR gerada
                (o valor do topo NÃO deverá ser decrementado para cada instrução STR gerada, exceto para a última)
                */
                if(numErrSemantico > 0){
                    break;
                }
                while (!pilha2.empty()) {
                    area_instrucao.add(new AreaInstrucao(ponteiro, "STR", Integer.parseInt(pilha2.pop().toString())));
                    ponteiro += 1;
                }

                break;
            case "#17":
                contexto = "entrada de dados";
                break;
            case "#18":
                area_instrucao.add(new AreaInstrucao(ponteiro, "WRT", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#19":
                /*ação #19: reconhecimento de identificador em comando de saída ou em expressão
                SE (identificador existe na tabela de símbolos) E (identificador é identificador de constante ou de variável)
                ENTÃO
                variável indexada  falso
                armazenar o identificador reconhecido
                SENÃO
                erro: “identificador não declarado”
                FIMSE*/
                if((containsTabela(valor) ) &&
                        tabela_simbolos.get(indexTabela(valor)).categoria == 1){
                    var_indexada = false;
                    pilha2.push(valor);
                }else{
                    numErrSemantico += 1;
                    mensagensErros +="\n ERRO(19):Identificador não declarado em comando de saída ou expressão.\nLinha " + linha + " coluna "+ coluna ;
                }
                break;
            case "#20":
                if(numErrSemantico > 0){
                    break;
                }
                int indext = indexTabela(pilha2.pop().toString());
                char atr1 = tabela_simbolos.get(indext).atributo1;
                char atr2 = tabela_simbolos.get(indext).atributo2;
                if(var_indexada == false){
                    if(atr2 == '-'){
                        area_instrucao.add(new AreaInstrucao(ponteiro, "LDV", Integer.parseInt(String.valueOf(atr1))));
                        ponteiro += 1;
                    }
                }
                else{
                    if(atr2 != '-'){
                        area_instrucao.add(new AreaInstrucao(ponteiro, "LDV", Integer.parseInt(String.valueOf(atr1)) + Integer.parseInt(pilha2.pop().toString()) - 1));
                        ponteiro += 1;
                    }
                    else{
                        numErrSemantico += 1;
                       mensagensErros +="ERRO(20):Identificador de constante ou de variável não indexada em comando de saída.\nLinha" + linha + " coluna "+ coluna ;
                    }
                }
                break;
            case "#21":
                 area_instrucao.add(new AreaInstrucao(ponteiro, "LDI", Integer.parseInt(valor)));
                ponteiro = ponteiro + 1;
                break;
            case "#22":
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDR", Float.parseFloat(valor)));
                ponteiro = ponteiro + 1;
                break;
            case "#23":
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDS", valor));
                ponteiro = ponteiro + 1;
                break;
            case "#24":
                int endereço = Integer.parseInt(pilha_de_desvios.pop().toString());
                int index = 0;
                for (AreaInstrucao area:area_instrucao) {
                    if(area.ponteiro == endereço){
                        area.iParametro = ponteiro;
                        /*AreaInstrucao temp = area_instrucao.get(index);
                        area_instrucao.remove(index);
                        area_instrucao.add(index, temp);*/
                    }
                    index += 1;
                }
                 break;
            case "#25":
            case "#31":
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMF", '?'));
                pilha_de_desvios.push(ponteiro + "");
                ponteiro = ponteiro + 1;
                 break;
            case "#26":
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMT", '?'));
                pilha_de_desvios.push(ponteiro + "");
                ponteiro = ponteiro + 1;
                break;
            case "#27":
                endereço = Integer.parseInt(pilha_de_desvios.pop().toString());
                index = 0;
                for (AreaInstrucao area:area_instrucao) {
                    if(area.ponteiro == endereço){
                        area.iParametro = ponteiro + 1;
                        AreaInstrucao temp = area_instrucao.get(index);
                        area_instrucao.remove(index);
                        area_instrucao.add(index, temp);
                    }
                    index += 1;
                }
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMP", '?'));
                pilha_de_desvios.push(ponteiro + "");
                ponteiro = ponteiro + 1;
                break;
            case "#28":
            case "#30":
                pilha_de_desvios.push(ponteiro + "");
                 break;
            case "#29":
                endereço = Integer.parseInt(pilha_de_desvios.pop().toString());
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMT", endereço));
                ponteiro = ponteiro + 1;
                 break;
            case "#32":
                int endereço1 = Integer.parseInt(pilha_de_desvios.pop().toString());
                int endereço2 =  Integer.parseInt(pilha_de_desvios.pop().toString());
                index = 0;
                for (AreaInstrucao area:area_instrucao) {
                    if(area.ponteiro == endereço1){
                        area.iParametro = ponteiro + 1;
                        /*AreaInstrucao temp = area_instrucao.get(index);
                        area_instrucao.remove(index);
                        area_instrucao.add(index, temp);*/
                    }
                    index += 1;
                }
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMP", endereço2));
                ponteiro = ponteiro + 1;
                break;
            case "#33":
                area_instrucao.add(new AreaInstrucao(ponteiro, "EQL", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#34":
                area_instrucao.add(new AreaInstrucao(ponteiro, "DIF", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#35":
                area_instrucao.add(new AreaInstrucao(ponteiro, "SMR", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#36":
                area_instrucao.add(new AreaInstrucao(ponteiro, "BGR", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#37":
                area_instrucao.add(new AreaInstrucao(ponteiro, "SME", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#38":
                area_instrucao.add(new AreaInstrucao(ponteiro, "BGE", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#39":
                area_instrucao.add(new AreaInstrucao(ponteiro, "ADD", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#40":
                area_instrucao.add(new AreaInstrucao(ponteiro, "SUB", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#41":
                area_instrucao.add(new AreaInstrucao(ponteiro, "OR", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#42":
                area_instrucao.add(new AreaInstrucao(ponteiro, "MUL", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#43":
                area_instrucao.add(new AreaInstrucao(ponteiro, "DIV", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#44":
                if(tipo == 1) {
                    area_instrucao.add(new AreaInstrucao(ponteiro, "DIVINT", 0));
                    ponteiro = ponteiro + 1;
                }
                break;
            case "#45":
                if(tipo == 1) {
                    area_instrucao.add(new AreaInstrucao(ponteiro, "MOD", 0));
                    ponteiro = ponteiro + 1;
                }
                break;
            case "#46":
                area_instrucao.add(new AreaInstrucao(ponteiro, "AND", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#47":
                area_instrucao.add(new AreaInstrucao(ponteiro, "POT", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#48":
                //true = 1
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDB", 1));
                ponteiro = ponteiro + 1;
                break;
            case "#49":
                //false = 0
                area_instrucao.add(new AreaInstrucao(ponteiro, "LDB", 0));
                ponteiro = ponteiro + 1;
                break;
            case "#50":
                area_instrucao.add(new AreaInstrucao(ponteiro, "NOT", 0));
                ponteiro = ponteiro + 1;
                break;
        }

        return sucesso;
    }

    private static boolean containsTabela(String valor){
        boolean sucess = false;
        for (Tabela tab: tabela_simbolos ) {
            if (tab.nome.contains(valor)){
                sucess = true;
            }
        }

        return sucess;

    }

    private static int indexTabela(String valor){
        int index = -1;
        for (Tabela tab: tabela_simbolos ) {
            if (tab.nome.contains(valor)){
                index += 1;
                break;
            }
            index += 1;
        }

        return index;

    }
    public int getNumErrSemantico(){
        return numErrSemantico;
    }

    public String getMensagensErros(){
        return mensagensErros;
    }
}
