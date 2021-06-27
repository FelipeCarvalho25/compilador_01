package VMExecucao;

import EstruturasDados.AreaInstrucao;
import interfacecompilador.Tela_execucao;
import jdk.nashorn.internal.runtime.ParserException;


import java.util.ArrayList;
import java.util.Stack;


public class Maquina_Virtual_Execucao implements Runnable {
    ArrayList<AreaInstrucao> codigoExecucao;
    private static Stack dads;
    private static Stack pilhaVerificacaoTipos;
    private Tela_execucao tela_de_execucao;
    private static int topo = 0;
    private static int ponteiro = 1;
    private static int deslocamento;
    public static int numErrVM = 0;
    public static String mensagensErrosVM = "";
    private static  String titulo = "";
    private static boolean sucess = false;

    public Maquina_Virtual_Execucao(ArrayList<AreaInstrucao> codigo, Tela_execucao tela){
        codigoExecucao = codigo;
        tela_de_execucao = tela;
        dads = new Stack();
        pilhaVerificacaoTipos = new Stack();

    }
    public void setTitle(String name){
        tela_de_execucao.setTitle(name);
        tela_de_execucao.setName(name);
    }
    @Override
    public void run(){
        tela_de_execucao.setVisible(true);
        while(ponteiro < codigoExecucao.size()) {
            AreaInstrucao instrucao = codigoExecucao.get(ponteiro-1);
            if(instrucao.comando == "ADD" ){
                ADD();
            }
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
                AND();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "BGE"){
                BGE();
            }
            if(numErrVM != 0){
                return;
            }
            if(instrucao.comando == "BGR"){
                BGR();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "DIF"){
                DIF();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "DIV"){
                DIV();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "DIVINT"){
                DIVINT();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "EQL"){
                EQL();
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
                MUL();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "MOD"){
                MOD();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "NOT"){
                NOT();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "OR"){
                OR();
            }
            if(numErrVM != 0){
                return;
            }
            if(instrucao.comando == "POT"){
                POT();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "REA"){
                tela_de_execucao.setEnableInput();
                REA(instrucao);
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SME"){
                SME();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SMR"){
                SMR();
            }
            if(numErrVM != 0){
                return;
            }
            if(instrucao.comando == "STC"){
                STC(instrucao);
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
                STP();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "SUB"){
                SUB();
            }
            if(numErrVM != 0){
                return;
            }

            if(instrucao.comando == "WRT"){
                WRT();
            }
            if(numErrVM != 0){
                return;
            }

        }
        sucess = true;
        tela_de_execucao.setTexto("Programa executado com sucesso.");
    }
    public boolean isStopped(){
        return tela_de_execucao.finalizou;
    }

    public void ADD(){

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        float fresult = -1;
        int iresult = 1;
        String val2 = dads.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) + Float.parseFloat(val2);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) + Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) + Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) + Integer.parseInt(val1);
                    dads.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
            }
        }
        else{
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void ALB(AreaInstrucao instrucao){
        deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            dads.push(false);
            pilhaVerificacaoTipos.push("logico");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALI(AreaInstrucao instrucao){
        deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            this.dads.push("0");
            pilhaVerificacaoTipos.push("inteiro");


        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALR(AreaInstrucao instrucao){
        //only float - review this one
        deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            dads.push("0.0");
            pilhaVerificacaoTipos.push("real");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALS(AreaInstrucao instrucao){
        deslocamento = instrucao.iParametro;;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            dads.push(" ");
            pilhaVerificacaoTipos.push("string");
        };

        topo += deslocamento;
        ponteiro += 1;
    }

    public void AND( ){
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 != null && tipo2 != null && (tipo1 == "logico" && tipo2 == "logico")){
                boolean op1 = Boolean.parseBoolean(dads.pop().toString());
                boolean op2 = Boolean.parseBoolean(dads.pop().toString());

                dads.push(op1 && op2);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void BGE(){
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());

                dads.push(f2 >= f1);
                pilhaVerificacaoTipos.push("logico");

            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());

                    dads.push(i2 >= f1);
                    pilhaVerificacaoTipos.push("logico");

                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());

                        dads.push(f2 >= i1);
                        pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());

                            dads.push(i2 >= i1);
                            pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void BGR( ){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());

                dads.push(f2 > f1);
                pilhaVerificacaoTipos.push("logico");

            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());

                    dads.push(i2 > f1);
                    pilhaVerificacaoTipos.push("logico");

                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());

                        dads.push(f2 > i1);
                        pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());

                            dads.push(i2 > i1);
                            pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void DIF( ){
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());
                dads.push(f2 != f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());
                    dads.push(i2 != f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());
                        dads.push(f2 != i1);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());
                            dads.push(i2 != i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void DIV( ){
        //AJUSTAR TIPOS?
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        float fresult = -1;
        String val2 = dads.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    if(Float.parseFloat(val2) != 0){
                        fresult = Integer.parseInt(val1) / Float.parseFloat(val2);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Float.parseFloat(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  /  Float.parseFloat(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Integer.parseInt(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }
                else{
                    mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, tipo null encontrado.";
                    numErrVM += 1;
                }
            }
        }
        else{
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void EQL( ){
        // COMENTAR AMANHA
        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());
                dads.push(f2 == f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());
                    dads.push(i2 == f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());
                        dads.push(i1 == f2);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());
                            dads.push(i2 == i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void JMF(AreaInstrucao instrucao){
        //boolean
        String tipo = pilhaVerificacaoTipos.pop().toString();
        if(tipo == null){
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
            return;
        }
        if(tipo == "logico"){
            boolean num = Boolean.parseBoolean(dads.pop().toString());


            if(num == false){
                //verificar se fizemos int na JMF semantica - sim
                ponteiro = instrucao.iParametro;
            }else{
                ponteiro += 1;
            }

            topo += -1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void JMP(AreaInstrucao instrucao){
        //verificar se fizemos int na JMP semantica - sim
        ponteiro = instrucao.iParametro;
    }

    public void JMT(AreaInstrucao instrucao){
        //boolean
        String tipo = pilhaVerificacaoTipos.pop().toString();
        if(tipo == null){
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
            return;
        }
        if(tipo == "logico"){
            boolean num = Boolean.parseBoolean(dads.pop().toString());

            if(num == true){
                ponteiro = instrucao.iParametro;
            }else{
                ponteiro += 1;
            }

            topo += -1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
            numErrVM += 1;
        }

    }

    public void LDV(AreaInstrucao instrucao){
        int endereco = instrucao.iParametro;
        String valend = dads.get(endereco-1).toString();
        String tipoend = pilhaVerificacaoTipos.get(endereco-1).toString();
        dads.push(valend);
        pilhaVerificacaoTipos.push(tipoend);
        topo += 1;
        ponteiro += 1;
    }

    public void LDB(AreaInstrucao instrucao){
        if(instrucao.iParametro != -1 && (instrucao.iParametro == 1 | instrucao.iParametro == 0)){
            dads.push(instrucao.iParametro == 1);
            pilhaVerificacaoTipos.push("logico");
            topo += 1;
            ponteiro += 1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(6): constante não identificada. Esperado valor lógico.";
            numErrVM += 1;
        }
    }

    public void LDI(AreaInstrucao instrucao){
        topo += 1;
        dads.push(instrucao.iParametro);
        pilhaVerificacaoTipos.push("inteiro");
        ponteiro += 1;
    }

    public void LDR(AreaInstrucao instrucao){
        topo += 1;
        dads.push(instrucao.fParametro);
        pilhaVerificacaoTipos.push("real");
        ponteiro += 1;
    }

    public void LDS(AreaInstrucao instrucao){
        if(instrucao.sParametro != null ){
            dads.push(instrucao.sParametro);
            pilhaVerificacaoTipos.push("literal");
            ponteiro += 1;
            topo += 1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(9): constante não identificada. Esperado valor literal.";
        }


    }
    public void DIVINT(){
        float fresult = -1;
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        //topo (val1) nunca pode ser igual a zero!
        String val1 = dads.pop().toString();
        String val2 = dads.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo2 == "real" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Float.parseFloat(val2) / Integer.parseInt(val1);
                        Math.floor(fresult);
                        dads.push((int)fresult);
                        pilhaVerificacaoTipos.push("inteiro");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "real" && tipo1 == "real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  /  Float.parseFloat(val1);
                        Math.floor(fresult);
                        dads.push((int)fresult);
                        pilhaVerificacaoTipos.push("inteiro");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Integer.parseInt(val1);
                        Math.floor(fresult);
                        dads.push((int)fresult);
                        pilhaVerificacaoTipos.push("inteiro");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "real"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Float.parseFloat(val1);
                        Math.floor(fresult);
                        dads.push((int)fresult);
                        pilhaVerificacaoTipos.push("inteiro");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else{
                    mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
            }
        }else {
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
        }
    }
    public void MUL( ){
        //SOMENTE PARA VALORES NUMERICOS - ajustar tipos
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        float fresult = -1;
        int iresult = -1;
        String val2 = dads.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) * Float.parseFloat(val2);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2)  *  Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2)  *  Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2)  *  Integer.parseInt(val1);
                    dads.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                    return;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
                return;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
            return;
        }



        topo += -1;
        ponteiro += 1;
    }

    public void MOD( ){
        //ver no ultimo trabalho ou prova
        //VER MOD e outras que faltarem especificar
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        float fresult = -1;
        String val2 = dads.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    if(Float.parseFloat(val2) != 0){
                        fresult = Integer.parseInt(val1) % Float.parseFloat(val2);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Float.parseFloat(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "real" && tipo2 =="real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  %  Float.parseFloat(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Integer.parseInt(val1);
                        dads.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                    }
                    else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                        return;
                    }
                }
                else{
                    mensagensErrosVM +=  "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                    return;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
                return;
            }
        }else {
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
            return;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void NOT( ){
        //como barrar com a notação NOT?
        String tTopo = pilhaVerificacaoTipos.pop().toString();
        if(tTopo == "logico"){
            boolean topob = Boolean.parseBoolean(dads.pop().toString());
            dads.push(!topob);
            pilhaVerificacaoTipos.push("logico");
        }
    }

    public void OR( ){
        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "logico" && tipo2 == "logico"){
            boolean op1 = Boolean.parseBoolean(dads.pop().toString());
            boolean op2 = Boolean.parseBoolean(dads.pop().toString());
            dads.push((op1 | op2));
            pilhaVerificacaoTipos.push("logico");
            topo =+ -1;
            ponteiro =+ 1;
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    private boolean getInput(){
        boolean returna = false;

        return returna;
    }
    public void POT(){
        float fresult = -1;
        int iresult = 1;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        String val2 = dads.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                double pow = Math.pow(Double.parseDouble(val1), Double.parseDouble(val2));
                if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                    iresult = (int) pow;
                    dads.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" | tipo2 =="real"){
                    fresult = (float) pow;
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
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


        tela_de_execucao.setAutoRequestFocus(true);


        try {
            tela_de_execucao.getInput();
        } catch (InterruptedException es) {
            es.printStackTrace();
        }
        String entrada = tela_de_execucao.getTextoImput();


        if(instrucao.iParametro == 1 | instrucao.iParametro == 5){
            try{
                int entradaNat = Integer.parseInt(entrada);
                dads.push(entradaNat);
                pilhaVerificacaoTipos.push("inteiro");
            }catch(NumberFormatException e){
                mensagensErrosVM += "\nRUNTIME ERROR(10): tipo incompatível. Esperado tipo inteiro";
                numErrVM += 1;
            }

        }

        if(instrucao.iParametro == 2 | instrucao.iParametro == 6){
            try{
                float entradaRel = Float.parseFloat(entrada);
                dads.push(entradaRel);
                pilhaVerificacaoTipos.push("real");
            }catch(NumberFormatException e){
                mensagensErrosVM += "\nRUNTIME error: tipo incompatível";
                numErrVM += 1;
            }
        }

        if(instrucao.iParametro == 3 | instrucao.iParametro == 7){
            if(entrada == null){
                mensagensErrosVM += "\nRUNTIME ERROR(12): tipo incompatível. Esperado tipo literal";
                numErrVM += 1;
            }else{
                dads.push(entrada);
                pilhaVerificacaoTipos.push("literal");
            }
        }

        if(instrucao.iParametro == 4){
            try{
                boolean entradaLog = Boolean.parseBoolean(entrada);
                dads.push(entradaLog);
                pilhaVerificacaoTipos.push("logico");
            }catch(ParserException e){
                mensagensErrosVM += "\nRUNTIME ERROR(13): tipo incompatível. Esperado tipo lógico";
                numErrVM += 1;
            }
        }

        ponteiro += 1;

    }

    public void SME( ){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());
                dads.push(f2 <= f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());
                    dads.push(f1 <= i2);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());
                        dads.push(f2 <= i1);
                        pilhaVerificacaoTipos.push("logico");

                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());
                            dads.push(i2 <= i1);
                            pilhaVerificacaoTipos.push("logico");

                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }
    public void STC(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo-deslocamento; i <= topo-1; i++){
            dads.set(i, dads.pop()) ;
        }
    }

    public void SMR( ){

        float f1 = 0.0F;
        float f2 = 0.0F;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = (String) pilhaVerificacaoTipos.pop();
        String tipo2 = (String) pilhaVerificacaoTipos.pop();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = Float.parseFloat(dads.pop().toString());
                f2 = Float.parseFloat(dads.pop().toString());
                dads.push(f2 < f1);
                pilhaVerificacaoTipos.push("logico");
            }else {
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = Float.parseFloat(dads.pop().toString());
                    i2 = Integer.parseInt(dads.pop().toString());
                    dads.push(i2 < f1);
                    pilhaVerificacaoTipos.push("logico");
                } else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = Integer.parseInt(dads.pop().toString());
                        f2 = Float.parseFloat(dads.pop().toString());
                        dads.push(f2 < i1);
                        pilhaVerificacaoTipos.push("logico");
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = Integer.parseInt(dads.pop().toString());
                            i2 = Integer.parseInt(dads.pop().toString());
                            dads.push(i2 < i1);
                            pilhaVerificacaoTipos.push("logico");
                        } else {
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        } else {
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }

        topo += -1;
        ponteiro += 1;
    }

    public void STR(AreaInstrucao instrucao){
        int endereco = instrucao.iParametro;
        String topoval = dads.pop().toString();
        String tipo = pilhaVerificacaoTipos.pop().toString();
        if( tipo.equals(pilhaVerificacaoTipos.get(endereco-1).toString())){
            dads.set(endereco-1, topoval);
            pilhaVerificacaoTipos.set(endereco-1, tipo);
            topo += -1;
            ponteiro += 1;
        }else{
            mensagensErrosVM += "RUNTIME ERROR: Tipo diferente da variável em atribução.\nEsperado " + pilhaVerificacaoTipos.get(endereco-1).toString() + " recebido " + tipo;
        }

    }

    public void STP( ){
        //HALT - Informar o final da execução
        if(numErrVM == 0){
            tela_de_execucao.setTexto("\n Programa executado com sucesso.");
        }
        ponteiro = 0;
    }

    public void SUB( ){
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = dads.pop().toString();
        float fresult = -1;
        int iresult = 1;
        String val2 = dads.pop().toString();
        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) - Float.parseFloat(val2);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) - Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) - Float.parseFloat(val1);
                    dads.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) - Integer.parseInt(val1);
                    dads.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                }
                else{
                    mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                    numErrVM += 1;
                }
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
                numErrVM += 1;
            }
        }
        else{
            mensagensErrosVM += "\nRUNTIME ERROR(3): não foi possível executar a instrução, valor null encontrado.";
            numErrVM += 1;
        }


        topo += -1;
        ponteiro += 1;
    }

    public void WRT( ){
        //Escrever o valor do topo da memória na tela
        tela_de_execucao.setTexto(dads.pop().toString());
        String tipo = pilhaVerificacaoTipos.pop().toString();
        topo += -1;
        ponteiro += 1;
    }



}
