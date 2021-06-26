package VMExecucao;

import EstruturasDados.AreaInstrucao;
import interfacecompilador.Tela_execucao;
import jdk.nashorn.internal.runtime.ParserException;

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
    public static int numErrVM = 0;
    public static String mensagensErrosVM = "";
    public Maquina_Virtual_Execucao(ArrayList<AreaInstrucao> codigo){
        codigoExecucao = codigo;
        tela_de_execucao = new Tela_execucao();
        pilhaAuxiliar = new Stack();
        pilhaVerificacaoTipos = new Stack();
    }
    public void executa(){

        for (AreaInstrucao instrucao: codigoExecucao) {
            if(instrucao.comando == "ADD" ){
                ADD(instrucao);
            };
            if(numErrVM != 0){
                return;
            }
            if(instrucao.comando == "ALB"){
                ALB(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "ALI"){
                ALI(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "ALR"){
                ALR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "ALS"){
                ALS(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "AND"){
                AND(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "BGE"){
                BGE(instrucao);
            }
            if(numErrVM != 0){
                return;
            }
            if(instrucao.comando == "BGR"){
                BGR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "DIF"){
                DIF(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "DIV"){
                DIV(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "EQL"){
                EQL(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "EQL"){
                EQL(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "JMF"){
                JMF(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "JMP"){
                JMP(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "JMT"){
                JMT(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "LDV"){
                LDV(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "LDB"){
                LDB(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "LDI"){
                LDI(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "LDR"){
                LDR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "LDS"){
                LDS(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "MUL"){
                MUL(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "MOD"){
                MOD(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "NOT"){
                NOT(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "OR"){
                OR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "REA"){
                REA(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SME"){
                SME(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SMR"){
                SMR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "STR"){
                STR(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "STP"){
                STP(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SUB"){
                SUB(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "WRT"){
                WRT(instrucao);
            }
            if(numErrVM != 0){
                return;
            }
        }

    }

    public void ADD(AreaInstrucao instrucao){

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        float fresult = -1;
        int iresult = 1;
        String val2 = pilhaAuxiliar.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) + Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) + Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) + Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) + Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nERRO(X):Subtração com tipos inválidos, favor conferir. Esperado int ou real.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nERRO(X):Subtração com tipos inválidos, favor conferir.Esperado int ou real.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void ALB(AreaInstrucao instrucao){
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.push(false);
            pilhaVerificacaoTipos.push("logico");
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
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null && (tipo1 == "logico" && tipo2 == "logico")){
            boolean op1 = (boolean)pilhaAuxiliar.pop();
            boolean op2 = (boolean)pilhaAuxiliar.pop();

            pilhaAuxiliar.push(op1 && op2);
            pilhaVerificacaoTipos.push("logico");
            topo =+ -1;
            ponteiro =+ 1;
        }else{
            mensagensErrosVM += "\nERRO(X):Um dos tipos não é um operador lógico! Ou o tipo está vazio!";
            numErrVM += 1;
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

                    pilhaAuxiliar.push(f2 >= f1);
                    pilhaVerificacaoTipos.push("logico");

            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();

                        pilhaAuxiliar.push(i2 >= f1);
                        pilhaVerificacaoTipos.push("logico");

                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();

                            pilhaAuxiliar.push(f2 >= i1);
                            pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();

                                pilhaAuxiliar.push(i2 >= i1);
                                pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "\nERRO(X):Elementos com tipos inválidos. Esperados inteiro ou real.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nERRO(X):Elementos nulos em comparação. Esperados inteiro ou real.";
            numErrVM += 1;
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

                    pilhaAuxiliar.push(f2 > f1);
                    pilhaVerificacaoTipos.push("logico");

            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();

                        pilhaAuxiliar.push(i2 > f1);
                        pilhaVerificacaoTipos.push("logico");

                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();

                            pilhaAuxiliar.push(f2 > i1);
                            pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();

                                pilhaAuxiliar.push(i2 > i1);
                                pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "\nERRO(X):Elementos com tipos inválidos. Esperados inteiro ou real.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nERRO(X):Elementos nulos em comparação. Esperados inteiro ou real.";
            numErrVM += 1;
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
                pilhaAuxiliar.push(f2 != f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 != f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 != i1);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 != i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            mensagensErrosVM += "\nERRO(X):Elementos com tipos inválidos. Esperados inteiro ou real.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nERRO(X):Elementos nulos em comparação. Esperados inteiro ou real.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void DIV(AreaInstrucao instrucao){
        //AJUSTAR TIPOS?
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        float fresult = -1;
        String val2 = pilhaAuxiliar.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    if(Float.parseFloat(val2) != 0){
                        fresult = Integer.parseInt(val1) / Float.parseFloat(val2);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Divisão com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Divisão com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  /  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Divisão com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Divisão com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }
                else{
                    mensagensErrosVM += "\nERRO(X):Divisão com tipos inválidos, favor conferir. Esperado int ou real.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nERRO(X):Divisão com tipos inválidos, favor conferir.Esperado int ou real.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
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
                pilhaAuxiliar.push(f2 == f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 == f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(i2 == f2);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 == i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            //ERRO DE EXECUÇÃO: TIPO NÃO É INTEIRO NEM REAL
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "ERRO(x):Valor nulo. Esperado inteiro ou real.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void JMF(AreaInstrucao instrucao){
        //boolean
        if(pilhaVerificacaoTipos.pop().toString() == "logico"){
            boolean num = Boolean.getBoolean(pilhaAuxiliar.pop().toString());

            if(num == false){
                //verificar se fizemos int na JMF semantica - sim
                ponteiro = instrucao.iParametro;
            }else{
                ponteiro += 1;
            }

            topo += -1;
        }else{
            mensagensErrosVM += "ERRO(x):Topo da pilha não é um valor lógico. Esperado logico.";
            numErrVM += 1;
        }
    }

    public void JMP(AreaInstrucao instrucao){
        //verificar se fizemos int na JMP semantica - sim
        ponteiro = instrucao.iParametro;
    }

    public void JMT(AreaInstrucao instrucao){
        //boolean
        if(pilhaVerificacaoTipos.pop().toString() == "logico"){
            boolean num = Boolean.getBoolean(pilhaAuxiliar.pop().toString());

            if(num == true){
                ponteiro = instrucao.iParametro;
            }else{
                ponteiro += 1;
            }

            topo += -1;
        }else{
            mensagensErrosVM += "ERRO(x):Topo da pilha não é um valor logico. Esperado logico.";
            numErrVM += 1;
        }

    }

    public void LDV(AreaInstrucao instrucao){
        int endereco = instrucao.iParametro;
        String valend = pilhaAuxiliar.remove(endereco).toString();
        String tipoend = pilhaVerificacaoTipos.remove(endereco).toString();
        pilhaAuxiliar.push(valend);
        pilhaVerificacaoTipos.push(tipoend);
        topo += -1;
        ponteiro += 1;
    }

    public void LDB(AreaInstrucao instrucao){
        pilhaAuxiliar.push(instrucao.iParametro);
        pilhaVerificacaoTipos.push("logico");
        topo += 1;
        ponteiro += 1;
    }

    public void LDI(AreaInstrucao instrucao){
        topo += 1;
        pilhaAuxiliar.push(instrucao.iParametro);
        pilhaVerificacaoTipos.push("inteiro");
        ponteiro += 1;
    }

    public void LDR(AreaInstrucao instrucao){
        topo += 1;
        pilhaAuxiliar.push(instrucao.fParametro);
        pilhaVerificacaoTipos.push("real");
        ponteiro += 1;
    }

    public void LDS(AreaInstrucao instrucao){
       if(instrucao.sParametro != null ){
           pilhaAuxiliar.push(instrucao.sParametro);
           pilhaVerificacaoTipos.push("literal");
           ponteiro += 1;
           topo += 1;
       }else{
           mensagensErrosVM += "ERRO(X):Valor nulo em reconhecimento de constante literal. Esperado literal.";
       }


    }

    public void MUL(AreaInstrucao instrucao){
        //SOMENTE PARA VALORES NUMERICOS - ajustar tipos
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        float fresult = -1;
        int iresult = -1;
        String val2 = pilhaAuxiliar.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) * Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2)  *  Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2)  *  Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2)  *  Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nERRO(X):Multiplicação com tipos inválidos, favor conferir. Esperado int ou real.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nERRO(X):Multiplicação com tipos inválidos, favor conferir.Esperado int ou real.";
            numErrVM += 1;
        }



        topo += -1;
        ponteiro += 1;
    }

    public void MOD (AreaInstrucao instrucao){
        //ver no ultimo trabalho ou prova
        //VER MOD e outras que faltarem especificar
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        float fresult = -1;
        String val2 = pilhaAuxiliar.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    if(Float.parseFloat(val2) != 0){
                        fresult = Integer.parseInt(val1) % Float.parseFloat(val2);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Mod com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Mod com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  %  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Mod com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nERRO(X):Mod com dividendo igual a zero, favor conferir. Esperado valor maior que zero.";
                        numErrVM += 1;
                    }
                }
                else{
                    mensagensErrosVM += "\nERRO(X):Mod com tipos inválidos, favor conferir. Esperado int ou real.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nERRO(X):Mod com tipos inválidos, favor conferir.Esperado int ou real.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void NOT(AreaInstrucao instrucao){
        //como barrar com a notação NOT?
        String tTopo = pilhaVerificacaoTipos.pop().toString();
        if(tTopo == "logico"){
            boolean topob = Boolean.getBoolean(pilhaAuxiliar.pop().toString());
            pilhaAuxiliar.push(!topob);
            pilhaVerificacaoTipos.push("logico");
        }
    }

    public void OR(AreaInstrucao instrucao){
        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null && (tipo1 == "logico" && tipo2 == "logico")){
            boolean op1 = (boolean)pilhaAuxiliar.pop();
            boolean op2 = (boolean)pilhaAuxiliar.pop();
            pilhaAuxiliar.push((op1 | op2));
            pilhaVerificacaoTipos.push("logico");
            topo =+ -1;
            ponteiro =+ 1;
        }else{
            mensagensErrosVM += "ERRO(X): Elementos não são do tipo lógico. Esperado logico.";
            numErrVM += 1;
        }
    }

    public void REA(AreaInstrucao instrucao){
        topo =+ 1;
        //categoria 1 = inteiro
        //categoria 2 = reais
        //categoria 3 = literais
        //categoria 4 = lógicos
        //categoria 5 = constantes inteiras
        //categoria 6 = constantes reais
        //categoria 7 = constantes literais

        String entrada = tela_de_execucao.getTextoImput();
        if(instrucao.iParametro == 1 | instrucao.iParametro == 5){
            try{
                int entradaNat = Integer.parseInt(entrada);
                pilhaAuxiliar.push(entradaNat);
                pilhaVerificacaoTipos.push("inteiro");
            }catch(ParserException e){
                mensagensErrosVM += "\nRUNTIME error: tipo incompatível";
                numErrVM += 1;
            }

        }

        if(instrucao.iParametro == 2 | instrucao.iParametro == 6){
            try{
                float entradaRel = Float.parseFloat(entrada);
                pilhaAuxiliar.push(entradaRel);
                pilhaVerificacaoTipos.push("real");
            }catch(ParserException e){
                mensagensErrosVM += "\nRUNTIME error: tipo incompatível";
                numErrVM += 1;
            }
        }

        if(instrucao.iParametro == 3 | instrucao.iParametro == 7){
            if(entrada == null){
                mensagensErrosVM += "\nRUNTIME error: tipo incompatível";
                numErrVM += 1;
            }else{
                pilhaAuxiliar.push(entrada);
                pilhaVerificacaoTipos.push("literal");
            }
        }

        if(instrucao.iParametro == 4){
            try{
                boolean entradaLog = Boolean.parseBoolean(entrada);
                pilhaAuxiliar.push(entradaLog);
                pilhaVerificacaoTipos.push("logico");
            }catch(ParserException e){
                mensagensErrosVM += "\nRUNTIME error: tipo incompatível";
                numErrVM += 1;
            }
        }

        ponteiro =+ 1;

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
                pilhaAuxiliar.push(f2 <= f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(f2 <= i1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 <= i1);
                        pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 <= i1);
                            pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "ERRO(X): Elementos não são númericos. Esperado inteiro ou real.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "ERRO(X): Elementos nulos. Esperado inteiro ou real.";
            numErrVM += 1;
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
                pilhaAuxiliar.push(f2 < f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 < f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 < i1);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 < i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            mensagensErrosVM += "ERRO(X): Elementos não são númericos. Esperado inteiro ou real.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "ERRO(X): Elementos nulos. Esperado inteiro ou real.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void STR(AreaInstrucao instrucao){
        int endereco = instrucao.iParametro;
        String topoval = pilhaAuxiliar.pop().toString();
        String tipo = pilhaVerificacaoTipos.pop().toString();
        pilhaAuxiliar.set(endereco, topoval);
        pilhaVerificacaoTipos.set(endereco, tipo);
        topo += -1;
        ponteiro += 1;
    }

    public void STP(AreaInstrucao instrucao){
        //HALT - Informar o final da execução
        if(numErrVM == 0){
            tela_de_execucao.setTexto("\n Programa executado com sucesso.");
        }
        ponteiro = 0;
    }

    public void SUB(AreaInstrucao instrucao){
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        float fresult = -1;
        int iresult = 1;
        String val2 = pilhaAuxiliar.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) - Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) - Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) - Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) - Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nERRO(X):Subtração com tipos inválidos, favor conferir. Esperado int ou real.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nERRO(X):Subtração com tipos inválidos, favor conferir.Esperado int ou real.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void WRT(AreaInstrucao instrucao){
        //Escrever o valor do topo da memória na tela
        tela_de_execucao.setTexto(pilhaAuxiliar.pop().toString());
        topo += -1;
        ponteiro += 1;
    }


}
