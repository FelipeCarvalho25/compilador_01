package VMExecucao;

import EstruturasDados.AreaInstrucao;
import interfacecompilador.Tela_execucao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class Maquina_Virtual_Execucao {
    ArrayList<AreaInstrucao> codigoExecucao;
    private static Stack pilhaAuxiliar;
    private static Stack pilhaVerificacaoTipos;
    private Tela_execucao tela_de_execucao;
    private static int topo = 0;
    private static int ponteiro = 1;
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
            if(instrucao.comando == "ADD" ){
                ADD();
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

        if(codigoExecucao.size() == 1){

            tela_de_execucao.setDisableInput();
            tela_de_execucao.setVisible(true);
        }
    }

    public void ADD(){
        float fresult = -1;
        int iresult = 1;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) + Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) + Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) + Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) + Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                    topo += -1;
                    ponteiro += 1;
                }
                else{
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

    public void ALB(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.set(i, false);
            pilhaVerificacaoTipos.push("logico");
        };
        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALI(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.set(i, 0);
            pilhaVerificacaoTipos.push("inteiro");
        };
        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALR(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.set(i, 0.0);
            pilhaVerificacaoTipos.push("real");
        };
        topo += deslocamento;
        ponteiro += 1;
    }

    public void ALS(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo+1; i <= topo+deslocamento; i++ ){
            pilhaAuxiliar.set(i," ");
            pilhaVerificacaoTipos.push("literal");
        };
        topo += deslocamento;
        ponteiro += 1;
    }

    public void AND(){
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "logico" && tipo2 == "logico"){
                boolean op1 = (boolean) pilhaAuxiliar.pop();
                boolean op2 = (boolean) pilhaAuxiliar.pop();

                pilhaAuxiliar.push(op1 && op2);
                pilhaVerificacaoTipos.push("logico");
                topo = +-1;
                ponteiro = +1;
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
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 >= f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 >= f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 >= i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 >= i1);
                            pilhaVerificacaoTipos.push("logico");
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void BGR(){
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 > f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 > f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 > i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 > i1);
                            pilhaVerificacaoTipos.push("logico");
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void DIF(){
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 != f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 != f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 != i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 != i1);
                            pilhaVerificacaoTipos.push("logico");
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void DIV(){
        float fresult = -1;
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        //topo (val1) nunca pode ser igual a zero!
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo2 == "real" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Float.parseFloat(val2) / Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "real" && tipo1 == "real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  /  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "real"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  /  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
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

    public void DIVINT(){
        float fresult = -1;
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        //topo (val1) nunca pode ser igual a zero!
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo2 == "real" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Float.parseFloat(val2) / Integer.parseInt(val1);
                        Math.floor(fresult);
                        pilhaAuxiliar.push((int)fresult);
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
                        pilhaAuxiliar.push((int)fresult);
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
                        pilhaAuxiliar.push((int)fresult);
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
                        pilhaAuxiliar.push((int)fresult);
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

    public void EQL(){
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 == f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 == f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 == i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 == i1);
                            pilhaVerificacaoTipos.push("logico");
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void JMF(AreaInstrucao instrucao){
        String tipo = pilhaVerificacaoTipos.pop().toString();

        if(tipo != null){
            if(tipo == "logico"){
                boolean num = Boolean.getBoolean(pilhaAuxiliar.pop().toString());
                if(num == false){
                    ponteiro = instrucao.iParametro;
                }else{
                    ponteiro += 1;
                }
                topo += -1;
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void JMP(AreaInstrucao instrucao){
        ponteiro = instrucao.iParametro;
    }

    public void JMT(AreaInstrucao instrucao){
        String tipo = pilhaVerificacaoTipos.pop().toString();

        if(tipo != null){
            if(tipo == "logico"){
                boolean num = Boolean.getBoolean(pilhaAuxiliar.pop().toString());
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
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
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
        if(instrucao.iParametro != -1 && (instrucao.iParametro == 1 | instrucao.iParametro == 0)){
            pilhaAuxiliar.push(instrucao.iParametro);
            pilhaVerificacaoTipos.push("logico");
            topo += 1;
            ponteiro += 1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(6): constante não identificada. Esperado valor lógico.";
            numErrVM += 1;
        }
    }

    public void LDI(AreaInstrucao instrucao){
        if(instrucao.iParametro != -1){
            topo += 1;
            pilhaAuxiliar.push(instrucao.iParametro);
            pilhaVerificacaoTipos.push("inteiro");
            ponteiro += 1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(7): constante não identificada. Esperado valor inteiro.";
            numErrVM += 1;
        }
    }

    public void LDR(AreaInstrucao instrucao){
        if(instrucao.fParametro != -1){
            topo += 1;
            pilhaAuxiliar.push(instrucao.fParametro);
            pilhaVerificacaoTipos.push("real");
            ponteiro += 1;
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(8): constante não identificada. Esperado valor real.";
            numErrVM += 1;
        }
    }

    public void LDS(AreaInstrucao instrucao){
       if(instrucao.sParametro != null ){
           pilhaAuxiliar.push(instrucao.sParametro);
           pilhaVerificacaoTipos.push("literal");
           ponteiro += 1;
           topo += 1;
       }else{
           mensagensErrosVM += "\nRUNTIME ERROR(9): constante não identificada. Esperado valor literal.";
           numErrVM += 1;
       }
    }

    public void MUL(){
        float fresult = -1;
        int iresult = 1;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) * Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) * Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) * Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) * Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                    topo += -1;
                    ponteiro += 1;
                }
                else{
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

    public void MOD (){
        float fresult = -1;
        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        //topo (val1) nunca pode ser igual a zero!
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo2 == "real" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Float.parseFloat(val2) % Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "real" && tipo1 == "real"){
                    if(Float.parseFloat(val1) != 0){
                        fresult = Float.parseFloat(val2)  %  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "inteiro"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Integer.parseInt(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        mensagensErrosVM += "\nRUNTIME ERROR(5): impossível realizar a operação. O valor do dividendo deve ser maior que zero";
                        numErrVM += 1;
                    }
                }else if(tipo2 == "inteiro" && tipo1 == "real"){
                    if(Integer.parseInt(val1) != 0){
                        fresult = Integer.parseInt(val2)  %  Float.parseFloat(val1);
                        pilhaAuxiliar.push(fresult);
                        pilhaVerificacaoTipos.push("real");
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

    public void NOT(){
        String tipo = pilhaVerificacaoTipos.pop().toString();

        if(tipo != null){
            if(tipo == "logico"){
                boolean topob = Boolean.getBoolean(pilhaAuxiliar.pop().toString());
                pilhaAuxiliar.push(!topob);
                pilhaVerificacaoTipos.push("logico");
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void OR(){
        String tipo1 = pilhaVerificacaoTipos.pop().toString();;
        String tipo2 = pilhaVerificacaoTipos.pop().toString();;

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "logico" && tipo2 == "logico"){
                boolean op1 = (boolean) pilhaAuxiliar.pop();
                boolean op2 = (boolean) pilhaAuxiliar.pop();
                pilhaAuxiliar.push((op1 | op2));
                pilhaVerificacaoTipos.push("logico");
                topo = +-1;
                ponteiro = +1;
            }else{
                mensagensErrosVM += "\nRUNTIME ERROR(4): essa instrução é válida apenas para valores lógicos.";
                numErrVM += 1;
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void POT(){
        float fresult = -1;
        int iresult = 1;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                double pow = Math.pow(Double.parseDouble(val1), Double.parseDouble(val2));
                if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                    iresult = (int) pow;
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" | tipo2 =="real"){
                    fresult = (float) pow;
                    pilhaAuxiliar.push(fresult);
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
        ponteiro =+ 1;
        //categoria 1 = inteiro
        //categoria 2 = reais
        //categoria 3 = literais
        //categoria 4 = lógicos
        //categoria 5 = constantes inteiras
        //categoria 6 = constantes reais
        //categoria 7 = constantes literais

        if(instrucao.iParametro == 1 | instrucao.iParametro == 5){
            if(pilhaVerificacaoTipos.get(topo).toString() != "inteiro"){
                mensagensErrosVM += "\nRUNTIME ERROR(10): tipo incompatível. Esperado tipo inteiro";
                numErrVM += 1;
            }
        }

        if(instrucao.iParametro == 2 | instrucao.iParametro == 6){
            if(pilhaVerificacaoTipos.get(topo).toString() != "real"){
                mensagensErrosVM += "\nRUNTIME ERROR(11): tipo incompatível. Esperado tipo real";
                numErrVM += 1;
            }
        }

        if(instrucao.iParametro == 3 | instrucao.iParametro == 7){
            if(pilhaVerificacaoTipos.get(topo).toString() != "literal"){
                mensagensErrosVM += "\nRUNTIME ERROR(12): tipo incompatível. Esperado tipo literal";
                numErrVM += 1;
            }
        }

        if(instrucao.iParametro == 4){
            if(pilhaVerificacaoTipos.get(topo).toString() != "logico"){
                mensagensErrosVM += "\nRUNTIME ERROR(13): tipo incompatível. Esperado tipo lógico";
                numErrVM += 1;
            }
        }
    }

    public void SME(){
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 <= f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 <= f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 <= i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 <= i1);
                            pilhaVerificacaoTipos.push("logico" );
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void SMR(){
        float f1 = 0;
        float f2 = 0;
        int i1 = 0;
        int i2 = 0;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();

        if(tipo1 != null && tipo2 != null){
            if(tipo1 == "real" && tipo2 == "real"){
                f1 = (float)pilhaAuxiliar.pop();
                f2 = (float)pilhaAuxiliar.pop();
                pilhaAuxiliar.push(f2 < f1);
                pilhaVerificacaoTipos.push("logico");
                topo += -1;
                ponteiro += 1;
            }else{
                if(tipo1 == "real" && tipo2 == "inteiro"){
                    f1 = (float)pilhaAuxiliar.pop();
                    i2 = (int)pilhaAuxiliar.pop();
                    pilhaAuxiliar.push(i2 < f1);
                    pilhaVerificacaoTipos.push("logico");
                    topo += -1;
                    ponteiro += 1;
                }else{
                    if(tipo1 == "inteiro" && tipo2 == "real"){
                        i1 = (int)pilhaAuxiliar.pop();
                        f2 = (float)pilhaAuxiliar.pop();
                        pilhaAuxiliar.push(f2 < i1);
                        pilhaVerificacaoTipos.push("logico");
                        topo += -1;
                        ponteiro += 1;
                    }else{
                        if(tipo1 == "inteiro" && tipo2 == "inteiro"){
                            i1 = (int)pilhaAuxiliar.pop();
                            i2 = (int)pilhaAuxiliar.pop();
                            pilhaAuxiliar.push(i2 < i1);
                            pilhaVerificacaoTipos.push("logico");
                            topo += -1;
                            ponteiro += 1;
                        }else{
                            mensagensErrosVM += "\nRUNTIME ERROR(1): essa instrução é válida apenas para valores inteiros ou reais.";
                            numErrVM += 1;
                        }
                    }
                }
            }
        }else{
            mensagensErrosVM += "\nRUNTIME ERROR(2): não foi possível executar a instrução, tipo null encontrado.";
            numErrVM += 1;
        }
    }

    public void STC(AreaInstrucao instrucao){
        int deslocamento = instrucao.iParametro;
        for(int i = topo-deslocamento; i <= topo-1; i++){
            Object num = pilhaAuxiliar.pop();
        }
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

    public void STP(){
        if(numErrVM == 0){
            tela_de_execucao.setTexto("\n Programa executado com sucesso.");
        }
        ponteiro = 0;
    }

    public void SUB(){
        float fresult = -1;
        int iresult = 1;

        String tipo1 = pilhaVerificacaoTipos.pop().toString();
        String tipo2 = pilhaVerificacaoTipos.pop().toString();
        String val1 = pilhaAuxiliar.pop().toString();
        String val2 = pilhaAuxiliar.pop().toString();

        if(val1 != null && val2 != null){
            if (tipo1 != null && tipo2 != null){
                if(tipo1 == "inteiro" && tipo2 == "real"){
                    fresult = Integer.parseInt(val1) - Float.parseFloat(val2);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="inteiro"){
                    fresult = Integer.parseInt(val2) - Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "real" && tipo2 =="real"){
                    fresult = Float.parseFloat(val2) - Float.parseFloat(val1);
                    pilhaAuxiliar.push(fresult);
                    pilhaVerificacaoTipos.push("real");
                    topo += -1;
                    ponteiro += 1;
                }else if(tipo1 == "inteiro" && tipo2 =="inteiro"){
                    iresult = Integer.parseInt(val2) - Integer.parseInt(val1);
                    pilhaAuxiliar.push(iresult);
                    pilhaVerificacaoTipos.push("inteiro");
                    topo += -1;
                    ponteiro += 1;
                }
                else{
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

    public void WRT(){
        tela_de_execucao.setTexto(pilhaAuxiliar.pop().toString());
        topo += -1;
        ponteiro += 1;
    }

}
