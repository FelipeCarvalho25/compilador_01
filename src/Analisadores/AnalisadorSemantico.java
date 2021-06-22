package Analisadores;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Tabela;
import EstruturasDados.Pilha;

import java.util.ArrayList;

public class AnalisadorSemantico {
    private static String contexto = "";
    private static int VT = 0;
    private static int VP = 0;
    private static int VIT = 0;
    private static int tipo = 0;
    private static int ponteiro = 1;
    private static boolean var_indexada = false;
    private static Pilha pilha_de_desvios ;
    private static ArrayList<Tabela> tabela_simbolos;
    private static ArrayList<AreaInstrucao> area_instrucao;
    private static Pilha pilhaAuxiliar;
    private static int numErrSemantico = 0;
    private static String mensagensErros = "";

    public AnalisadorSemantico(){
        pilha_de_desvios = new Pilha();
        area_instrucao = new ArrayList<>();
        tabela_simbolos =  new ArrayList<>();
        pilhaAuxiliar = new Pilha();
    }

    public ArrayList<AreaInstrucao> getCodIntermed(){
        return area_instrucao;
    }
    public static boolean analisarSemantica(String codigo, String valor) {
        if(true){
            return  true;
        }

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
                    mensagensErros += "ERRO: tipo inválido para constante";
                }
                break;
            case "#11":
                if(tabela_simbolos.indexOf(valor) != -1){
                    //ajustar o if acima
                    numErrSemantico += 1;
                    mensagensErros += "ERRO: identificador já declarado";
                }else{
                    VT = VT + 1;
                    VP = VP + 1;
                    //ajustar VT ESTÁ COMO INT, PRECISA REVER
                    tabela_simbolos.add (new Tabela(valor, tipo, (char)VT, '-'));
                }
                break;
            case "#12":
                if(contexto == "variável") {
                    if (tabela_simbolos.indexOf(valor) != -1) {
                        numErrSemantico += 1;
                        mensagensErros +="ERRO: identificador já declarado";
                    } else {
                        var_indexada = false;
                        //ajustar
                        pilhaAuxiliar.empilhar(valor);
                    }
                }else{
                    var_indexada = false;
                    //ajustar
                    pilhaAuxiliar.empilhar(valor);
                }
                break;
            case "#13":
                if(contexto == "variável"){
                    if(var_indexada == false){
                        VT = VT+1;
                        VP = VP+1;
                        tabela_simbolos.add (new Tabela(valor, tipo, (char)VT, '-'));
                    }else{
                        int contante_int = Integer.parseInt(pilhaAuxiliar.desempilhar().toString());
                        VIT = VIT + contante_int;
                        tabela_simbolos.add (new Tabela(valor, tipo, (char)VT, (char)contante_int));
                        VT = VT + contante_int;
                    }
                }

                if(contexto == "atribuição"){
                    //preciso ajustar a tabela de simbolos
                    if((tabela_simbolos.indexOf(valor) != -1) &&
                            tabela_simbolos.get(tabela_simbolos.indexOf(valor)).categoria == 1){
                        char atr1 = tabela_simbolos.get(tabela_simbolos.indexOf(valor)).atributo1;
                        char atr2 = tabela_simbolos.get(tabela_simbolos.indexOf(valor)).atributo2;

                        if(atr2 == '-'){
                            if(var_indexada == false){
                                pilhaAuxiliar.empilhar(atr1);
                            }else{
                                numErrSemantico += 1;
                                mensagensErros +="ERRO: identificador de variável não indexada";
                            }
                        }else{
                            if(var_indexada == true){
                                pilhaAuxiliar.empilhar((int)atr1 + (int)pilhaAuxiliar.desempilhar() -1);
                                //armazenar o "atributo 1" + constante inteira – 1 em uma lista de atributos
                            }else{
                                //erro: “identificador de variável indexada exige índice”
                                numErrSemantico += 1;
                                mensagensErros +="ERRO: identificador de variável indexada exige índice";
                            }
                        }

                    }else{
                        numErrSemantico += 1;
                        //erro: “identificador não declarado ou de constante”
                        mensagensErros +="ERRO: identificador não declarado ou de constante";
                    }
                }

                if(contexto == "entrada dados"){}

            case "#14":
                //tabela_simbolos.add  (new Tabela(valor, tipo, VT, constante_inteira));
                pilhaAuxiliar.empilhar(valor);
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
                while (!pilhaAuxiliar.pilhaVazia()){
                    area_instrucao.add(new AreaInstrucao(ponteiro, "STR", (int)pilhaAuxiliar.desempilhar()));
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
                if((tabela_simbolos.indexOf(valor) != -1) &&
                        tabela_simbolos.get(tabela_simbolos.indexOf(valor)).categoria == 1){
                    var_indexada = false;
                    pilhaAuxiliar.empilhar(valor);
                }else{
                    numErrSemantico += 1;
                    mensagensErros +="identificador não declarado";
                }
                break;
            case "#20":
                char atr1 = tabela_simbolos.get(tabela_simbolos.indexOf(valor)).atributo1;
                char atr2 = tabela_simbolos.get(tabela_simbolos.indexOf(valor)).atributo2;
                if(var_indexada == false){
                    if(atr2 == '-'){
                        area_instrucao.add(new AreaInstrucao(ponteiro, "LDV", (int)atr1));
                        ponteiro += 1;
                    }
                }
                else{
                    if(atr2 != '-'){
                        area_instrucao.add(new AreaInstrucao(ponteiro, "LDV", (int)atr1 + (int)pilhaAuxiliar.desempilhar() - 1));
                        ponteiro += 1;
                    }
                    else{
                        numErrSemantico += 1;
                       mensagensErros +="identificador de constante ou de variável não indexada”";
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
                int endereço = (int) pilha_de_desvios.desempilhar();
                int index = 0;
                for (AreaInstrucao area:area_instrucao) {
                    if(area.ponteiro == endereço){
                        area.iParametro = ponteiro;
                        AreaInstrucao temp = area_instrucao.get(index);
                        area_instrucao.remove(index);
                        area_instrucao.add(index, temp);
                    }
                    index += 1;
                }
                 break;
            case "#25":
            case "#31":
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMF", '?'));
                pilha_de_desvios.empilhar(ponteiro);
                ponteiro = ponteiro + 1;
                 break;
            case "#26":
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMT", '?'));
                pilha_de_desvios.empilhar(ponteiro);
                ponteiro = ponteiro + 1;
                break;
            case "#27":
                endereço = (int) pilha_de_desvios.desempilhar();
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
                pilha_de_desvios.empilhar(ponteiro);
                ponteiro = ponteiro + 1;
                break;
            case "#28":
            case "#30":
                pilha_de_desvios.empilhar(ponteiro);
                 break;
            case "#29":
                endereço = (int) pilha_de_desvios.desempilhar();
                area_instrucao.add(new AreaInstrucao(ponteiro, "JMT", endereço));
                ponteiro = ponteiro + 1;
                 break;
            case "#32":
                int endereço1 = (int) pilha_de_desvios.desempilhar();
                int endereço2 = (int) pilha_de_desvios.desempilhar();
                index = 0;
                for (AreaInstrucao area:area_instrucao) {
                    if(area.ponteiro == endereço1){
                        area.iParametro = ponteiro + 1;
                        AreaInstrucao temp = area_instrucao.get(index);
                        area_instrucao.remove(index);
                        area_instrucao.add(index, temp);
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
                    area_instrucao.add(new AreaInstrucao(ponteiro, "DIVIR", 0));
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

    public int getNumErrSemantico(){
        return numErrSemantico;
    }

    public String getMensagensErros(){
        return mensagensErros;
    }
}
