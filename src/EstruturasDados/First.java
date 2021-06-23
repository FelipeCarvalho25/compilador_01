package EstruturasDados;

import Analisadores.AnalisadorLexicoConstants;

public class First {
    static public final RecoverySet program = new RecoverySet();
    static public final RecoverySet define = new RecoverySet();
    static public final RecoverySet constante = new RecoverySet();
    static public final RecoverySet constantes = new RecoverySet();
    static public final RecoverySet variable = new RecoverySet();
    static public final RecoverySet variaveis = new RecoverySet();
    static public final RecoverySet valor = new RecoverySet();
    static public final RecoverySet tipo = new RecoverySet();
    static public final RecoverySet get = new RecoverySet();
    static public final RecoverySet put = new RecoverySet();
    static public final RecoverySet tipo_const = new RecoverySet();
    static public final RecoverySet list_ident_const_rec = new RecoverySet();
    static public final RecoverySet list_const = new RecoverySet();
    static public final RecoverySet list_ident_var = new RecoverySet();
    static public final RecoverySet corp_prog = new RecoverySet();
    static public final RecoverySet coment_prog = new RecoverySet();
    static public final RecoverySet verify = new RecoverySet();
    static public final RecoverySet is = new RecoverySet();
    static public final RecoverySet truefalse = new RecoverySet();
    static public final RecoverySet set = new RecoverySet();
    static public final RecoverySet repet = new RecoverySet();
    static public final RecoverySet exp_logic = new RecoverySet();
    static public final RecoverySet menor_prio = new RecoverySet();
    static public final RecoverySet media_prio = new RecoverySet();
    static public final RecoverySet maior_prio = new RecoverySet();
    static public final RecoverySet elemento = new RecoverySet();
    static public final RecoverySet indice = new RecoverySet();
    static {
        program.add(new Integer(AnalisadorLexicoConstants.PROGRAM));
        program.add(new Integer(AnalisadorLexicoConstants.ACHAVE));

        define.add(new Integer(AnalisadorLexicoConstants.DEFINE));
        define.add(new Integer(AnalisadorLexicoConstants.ACHAVE));

        constante.add(new Integer(AnalisadorLexicoConstants.NOT));
        constante.add(new Integer(AnalisadorLexicoConstants.VARIABLE));

        constantes.add(new Integer(AnalisadorLexicoConstants.IS));
        constantes.add(new Integer(AnalisadorLexicoConstants.PONTO));

        variable.add(new Integer(AnalisadorLexicoConstants.VARIABLE));

        variaveis.add(new Integer(AnalisadorLexicoConstants.IS));
        variaveis.add(new Integer(AnalisadorLexicoConstants.PONTO));

        tipo.add(new Integer(AnalisadorLexicoConstants.NATURAL));
        tipo.add(new Integer(AnalisadorLexicoConstants.REAL));
        tipo.add(new Integer(AnalisadorLexicoConstants.CHAR));
        tipo.add(new Integer(AnalisadorLexicoConstants.BOOLEAN));

        valor.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_INT));
        valor.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_REAL));
        valor.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_LIT));
        valor.add(new Integer(AnalisadorLexicoConstants.TRUE));
        valor.add(new Integer(AnalisadorLexicoConstants.FALSE));

        get.add(new Integer(AnalisadorLexicoConstants.GET));
        get.add(new Integer(AnalisadorLexicoConstants.ACHAVE));

        put.add(new Integer(AnalisadorLexicoConstants.PUT));
        put.add(new Integer(AnalisadorLexicoConstants.ACHAVE));

        tipo_const.add(new Integer(AnalisadorLexicoConstants.IDENTIFICADOR));
        tipo_const.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_REAL));
        tipo_const.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_LIT));
        tipo_const.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_INT));

        list_ident_const_rec.add(new Integer(AnalisadorLexicoConstants.VIRGULA));

        list_const.add(new Integer(AnalisadorLexicoConstants.IDENTIFICADOR));

        list_ident_var.add(new Integer(AnalisadorLexicoConstants.VARIABLE));

        corp_prog.add(new Integer(AnalisadorLexicoConstants.EXECUTE));
        corp_prog.add(new Integer(AnalisadorLexicoConstants.ACHAVE));

        coment_prog.add(new Integer(AnalisadorLexicoConstants.COMENT));

        verify.add(new Integer(AnalisadorLexicoConstants.VERIFY));

        is.add(new Integer(AnalisadorLexicoConstants.IS));

        truefalse.add(new Integer(AnalisadorLexicoConstants.TRUE));
        truefalse.add(new Integer(AnalisadorLexicoConstants.FALSE));

        set.add(new Integer(AnalisadorLexicoConstants.SET));

        repet.add(new Integer(AnalisadorLexicoConstants.WHILE));
        repet.add(new Integer(AnalisadorLexicoConstants.LOOP));

        exp_logic.add(new Integer(AnalisadorLexicoConstants.EQUIVALENTE));
        exp_logic.add(new Integer(AnalisadorLexicoConstants.DIFERENTE));
        exp_logic.add(new Integer(AnalisadorLexicoConstants.MENOR));
        exp_logic.add(new Integer(AnalisadorLexicoConstants.MAIOR));
        exp_logic.add(new Integer(AnalisadorLexicoConstants.MENOROUIGUAL));
        exp_logic.add(new Integer(AnalisadorLexicoConstants.MAIOROUIGUAL));

        menor_prio.add(new Integer(AnalisadorLexicoConstants.ADICAO));
        menor_prio.add(new Integer(AnalisadorLexicoConstants.SUBTRACAO));
        menor_prio.add(new Integer(AnalisadorLexicoConstants.OU));

        media_prio.add(new Integer(AnalisadorLexicoConstants.MULTIPLICACAO));
        media_prio.add(new Integer(AnalisadorLexicoConstants.DIVISAO));
        media_prio.add(new Integer(AnalisadorLexicoConstants.DIVISAOINTEIRA));
        media_prio.add(new Integer(AnalisadorLexicoConstants.RESTODIVISAO));
        media_prio.add(new Integer(AnalisadorLexicoConstants.E));

        maior_prio.add(new Integer(AnalisadorLexicoConstants.POTENCIA));

        elemento.add(new Integer(AnalisadorLexicoConstants.IDENTIFICADOR));
        elemento.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_REAL));
        elemento.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_LIT));
        elemento.add(new Integer(AnalisadorLexicoConstants.CONSTANTE_NUM_INT));
        elemento.add(new Integer(AnalisadorLexicoConstants.TRUE));
        elemento.add(new Integer(AnalisadorLexicoConstants.FALSE));
        elemento.add(new Integer(AnalisadorLexicoConstants.APARENT));
        elemento.add(new Integer(AnalisadorLexicoConstants.NAO));

        indice.add(new Integer(AnalisadorLexicoConstants.ACOLCH));
    }
}
