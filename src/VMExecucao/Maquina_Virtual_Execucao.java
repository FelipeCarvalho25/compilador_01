package VMExecucao;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Pilha;
import interfacecompilador.Tela_execucao;

import java.util.ArrayList;
import java.util.Stack;

public class Maquina_Virtual_Execucao {
    ArrayList<AreaInstrucao> codigoExecucao;
    private static Stack pilhaAuxiliar;
    private static Stack pilhaVerificacaoTipos;
    private Tela_execucao tela_de_execucao;
    private static int topo = 0;
    private static int ponteiro = 1;
    private static int deslocamento;
    private static int numErrVM = 0;
    private static String mensagensErrosVM = "";
    public Maquina_Virtual_Execucao(ArrayList<AreaInstrucao> codigo){
        codigoExecucao = codigo;
        tela_de_execucao = new Tela_execucao();
        pilhaAuxiliar = new Stack();
        pilhaVerificacaoTipos = new Stack();
    }
    public void executa(){

        for (AreaInstrucao instrucao: codigoExecucao) {
            if(instrucao.comando == "ADD"){
                ADD(instrucao);
            };

            if(instrucao.comando == "ALB"){
                ALB(instrucao);
            };

            if(instrucao.comando == "ALI"){
                ALI(instrucao);
            };

            if(instrucao.comando == "ALR"){
                ALR(instrucao);
            };

            if(instrucao.comando == "ALS"){
                ALS(instrucao);
            };

            if(instrucao.comando == "AND"){
                AND(instrucao);
            };

            if(instrucao.comando == "BGE"){
                BGE(instrucao);
            }

            if(instrucao.comando == "BGR"){
                BGR(instrucao);
            }

            if(instrucao.comando == "DIF"){
                DIF(instrucao);
            }

            if(instrucao.comando == "DIV"){
                DIV(instrucao);
            }

            if(instrucao.comando == "EQL"){
                EQL(instrucao);
            }

            if(instrucao.comando == "EQL"){
                EQL(instrucao);
            }

            if(instrucao.comando == "JMF"){
                JMF(instrucao);
            }

            if(instrucao.comando == "JMP"){
                JMP(instrucao);
            }

            if(instrucao.comando == "JMT"){
                JMT(instrucao);
            }

            if(instrucao.comando == "LDV"){
                LDV(instrucao);
            }

            if(instrucao.comando == "LDB"){
                LDB(instrucao);
            }

            if(instrucao.comando == "LDI"){
                LDI(instrucao);
            }

            if(instrucao.comando == "LDR"){
                LDR(instrucao);
            }

            if(instrucao.comando == "LDS"){
                LDS(instrucao);
            }

            if(instrucao.comando == "MUL"){
                MUL(instrucao);
            }

            if(instrucao.comando == "MOD"){
                MOD(instrucao);
            }

            if(instrucao.comando == "NOT"){
                NOT(instrucao);
            }

            if(instrucao.comando == "OR"){
                OR(instrucao);
            }

            if(instrucao.comando == "REA"){
                REA(instrucao);
            }

            if(instrucao.comando == "SME"){
                SME(instrucao);
            }

            if(instrucao.comando == "SMR"){
                SMR(instrucao);
            }

            if(instrucao.comando == "STR"){
                STR(instrucao);
            }

            if(instrucao.comando == "STP"){
                STP(instrucao);
            }

            if(instrucao.comando == "SUB"){
                SUB(instrucao);
            }

            if(instrucao.comando == "WRT"){
                WRT(instrucao);
            }
        }

        if(codigoExecucao.size() == 1){
            tela_de_execucao.setTexto("Programa Executado com sucesso!");
            tela_de_execucao.setDisableInput();
            tela_de_execucao.setVisible(true);
        }
    }

    public void ADD(AreaInstrucao instrucao){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;
        float fsum;
        int isum;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        if(tipo1 == "inteiro" && tipo1 != null){
            i1 = (int) pilhaAuxiliar.pop();
            String tipo2 = (String) pilhaVerificacaoTipos.pop();
            if(tipo2 == "inteiro" && tipo2 != null) {
                i2 = (int) pilhaAuxiliar.pop();
                isum = (i1 + i2);
                pilhaAuxiliar.push(isum);
                pilhaVerificacaoTipos.push("inteiro");
            };
            if(tipo2 == "real" && tipo2 != null) {
                f2 = (float) pilhaAuxiliar.pop();
                fsum = (float) (i1 + f2);
                pilhaAuxiliar.push(fsum);
                pilhaVerificacaoTipos.push("real");
            };
        }else{
            if(tipo1 == "real" && tipo1 != null){
                f1 = (float) pilhaAuxiliar.pop();
                String tipo2 = (String) pilhaVerificacaoTipos.pop();
                if(tipo2 == "real" && tipo2 != null){
                    f2 = (float) pilhaAuxiliar.pop();
                    fsum = (f1 + f2);
                    pilhaAuxiliar.push(fsum);
                    pilhaVerificacaoTipos.push("real");
                };
                if(tipo2 == "inteiro" && tipo2 != null){
                    i2 = (int) pilhaAuxiliar.pop();
                    fsum = (f1 + i2);
                    pilhaAuxiliar.push(fsum);
                    pilhaVerificacaoTipos.push("real");
                }
            }
            else{
                //ERRO DE EXECUÇÃO: valor tipo null ou o tipo não é uma constante numérica
            }
        }

        topo += -1;
        ponteiro += 1;
    }

    public void ALB(AreaInstrucao instrucao){
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.push(false);
            pilhaVerificacaoTipos.push("boolean");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALI(AreaInstrucao instrucao){
        deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.push(0);
            pilhaVerificacaoTipos.push("inteiro");

        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALR(AreaInstrucao instrucao){
        //only float - review this one
        deslocamento = (int)instrucao.fParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.push(0.0);
            pilhaVerificacaoTipos.push("real");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALS(AreaInstrucao instrucao){
        deslocamento = Integer.parseInt(instrucao.sParametro);
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.push(" ");
            pilhaVerificacaoTipos.push("string");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void AND(AreaInstrucao instrucao){
        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null && (tipo1 == "boolean" && tipo2 == "boolean")){
            boolean op1 = (boolean)pilhaAuxiliar.pop();
            boolean op2 = (boolean)pilhaAuxiliar.pop();
            boolean res;
            res = (op1 && op2);
            pilhaAuxiliar.push(res);
            pilhaVerificacaoTipos.push("boolean");
            topo =+ -1;
            ponteiro =+ 1;
        }else{
            //ERRO DE EXEC: Um dos tipos não é um operador lógico! Ou o tipo está vazio!
        }
    }

    public void BGE(AreaInstrucao instrucao){
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 >= f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 >= f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 >= i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 >= i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void BGR(AreaInstrucao instrucao){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 > f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 > f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 > i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 > i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void DIF(AreaInstrucao instrucao){
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 != f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 != f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 != i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 != i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void DIV(AreaInstrucao instrucao){
        //AJUSTAR TIPOS?
        int num1 = (int)pilhaAuxiliar.pop();
        int num2 = (int)pilhaAuxiliar.pop();
        int div =0;

        if(topo == 0){
            numErrVM += 1;
            mensagensErrosVM += "RUNTIME error: divisão por 0";
            //HALT - Informar o final da execução
        }else {
            div = num2 / num1;
            pilhaAuxiliar.push(div);
            topo += -1;
            ponteiro += 1;
        }
    }

    public void EQL(AreaInstrucao instrucao){
        // COMENTAR AMANHA
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 == f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 == f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 == i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 == i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void JMF(AreaInstrucao instrucao){
        //boolean
        boolean num = (boolean)pilhaAuxiliar.pop();

        if(num == false){
            //verificar se fizemos int na JMF semantica - sim
            ponteiro = instrucao.iParametro;
        }else{
            ponteiro += 1;
        }

        topo += -1;
    }

    public void JMP(AreaInstrucao instrucao){
        //verificar se fizemos int na JMP semantica - sim
        ponteiro = instrucao.iParametro;
    }

    public void JMT(AreaInstrucao instrucao){
        //boolean
        boolean num = (boolean)pilhaAuxiliar.pop();

        if(num == true){
            //verificar se fizemos int na JMT semantica - sim (=
            ponteiro = instrucao.iParametro;
        }else{
            ponteiro += 1;
        }

        topo += -1;
    }

    public void LDV(AreaInstrucao instrucao){
        //revisar
    }

    public void LDB(AreaInstrucao instrucao){
        pilhaAuxiliar.push(instrucao.iParametro);
        topo += 1;
        ponteiro += 1;
    }

    public void LDI(AreaInstrucao instrucao){
        topo += 1;
        pilhaAuxiliar.push(instrucao.iParametro);
        ponteiro += 1;
    }

    public void LDR(AreaInstrucao instrucao){
        topo += 1;
        pilhaAuxiliar.push(instrucao.fParametro);
        ponteiro += 1;
    }

    public void LDS(AreaInstrucao instrucao){
        topo += 1;
        pilhaAuxiliar.push(instrucao.sParametro);
        ponteiro += 1;
    }

    public void MUL(AreaInstrucao instrucao){
        //SOMENTE PARA VALORES NUMERICOS - ajustar tipos
        float int1 = (float)pilhaAuxiliar.pop();
        float int2 = (float)pilhaAuxiliar.pop();
        float mult;
        mult = int1+int2;
        pilhaAuxiliar.push(mult);

        topo += -1;
        ponteiro += 1;
    }

    public void MOD (AreaInstrucao instrucao){
        //ver no ultimo trabalho ou prova
        //VER MOD e outras que faltarem especificar
    }

    public void NOT(AreaInstrucao instrucao){
        //como barrar com a notação NOT?
    }

    public void OR(AreaInstrucao instrucao){
        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null && (tipo1 == "boolean" && tipo2 == "boolean")){
            boolean op1 = (boolean)pilhaAuxiliar.pop();
            boolean op2 = (boolean)pilhaAuxiliar.pop();
            boolean res;
            res = (op1 | op2);
            pilhaAuxiliar.push(res);
            pilhaVerificacaoTipos.push("boolean");
            topo =+ -1;
            ponteiro =+ 1;
        }else{
            //ERRO DE EXEC: Um dos tipos não é um operador lógico! Ou o tipo está vazio!
        }
    }

    public void REA(AreaInstrucao instrucao){
    }

    public void SME(AreaInstrucao instrucao){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 <= f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 <= f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 <= i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 <= i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void SMR(AreaInstrucao instrucao){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                if(f2 < f1){
                    pilhaAuxiliar.push(true);
                    pilhaVerificacaoTipos.push("boolean");
                }else{
                    pilhaAuxiliar.push(false);
                    pilhaVerificacaoTipos.push("boolean");
                }
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    if(i2 < f1){
                        pilhaAuxiliar.push(true);
                        pilhaVerificacaoTipos.push("boolean");
                    }else{
                        pilhaAuxiliar.push(false);
                        pilhaVerificacaoTipos.push("boolean");
                    }
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        if(f2 < i1){
                            pilhaAuxiliar.push(true);
                            pilhaVerificacaoTipos.push("boolean");
                        }else{
                            pilhaAuxiliar.push(false);
                            pilhaVerificacaoTipos.push("boolean");
                        }
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            if(i2 < i1){
                                pilhaAuxiliar.push(true);
                                pilhaVerificacaoTipos.push("boolean");
                            }else{
                                pilhaAuxiliar.push(false);
                                pilhaVerificacaoTipos.push("boolean");
                            }
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            //ERRO DE EXECUÇÃO: O VALOR É NULO!
        }

        topo += -1;
        ponteiro += 1;
    }

    public void STR(AreaInstrucao instrucao){

    }

    public void STP(AreaInstrucao instrucao){
        //HALT - Informar o final da execução
        ponteiro = 0;
    }

    public void SUB(AreaInstrucao instrucao){
        int int1 = (int)pilhaAuxiliar.pop();
        int int2 = (int)pilhaAuxiliar.pop();
        int subInt = 0;
        subInt = int1 - int2;
        pilhaAuxiliar.push(subInt);

        topo += -1;
        ponteiro += 1;
    }

    public void WRT(AreaInstrucao instrucao){
        //Escrever o valor do topo da memória na tela
        int printTela = (int)pilhaAuxiliar.pop();

        topo += -1;
        ponteiro += 1;
    }


}
