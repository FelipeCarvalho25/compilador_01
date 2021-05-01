/* Generated By:JavaCC: Do not edit this line. AnalisadorLexico.java */
package Analisadores;
public class AnalisadorLexico implements AnalisadorLexicoConstants {

  static final public void program() throws ParseException {
    comentario();
    jj_consume_token(PROGRAM);
    jj_consume_token(ACHAVE);
    declaracao_variaveis();
    corpo_do_programa();
    jj_consume_token(FCHAVE);
    identificador_programa();
  }

  static final public void declaracao_variaveis() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEFINE:
      define();
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void define() throws ParseException {
    jj_consume_token(DEFINE);
    jj_consume_token(ACHAVE);
    estrutura_define();
    jj_consume_token(FCHAVE);
  }

  static final public void estrutura_define() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      constante();
      variavel();
      break;
    case VARIABLE:
      variavel();
      constante();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variavel() throws ParseException {
    jj_consume_token(VARIABLE);
    tipo();
    jj_consume_token(IS);
    lista_identificadores_variavel();
    valor();
    jj_consume_token(PONTO);
    variavel_recursiva();
  }

  static final public void constante() throws ParseException {
    jj_consume_token(NOT);
    jj_consume_token(VARIABLE);
    tipo();
    jj_consume_token(IS);
    lista_identificadores_constante();
    valor();
    jj_consume_token(PONTO);
    constante_recursiva();
  }

  static final public void valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANTE_NUM_INT:
      jj_consume_token(CONSTANTE_NUM_INT);
      break;
    case CONSTANTE_NUM_REAL:
      jj_consume_token(CONSTANTE_NUM_REAL);
      break;
    case CONSTANTE_LIT:
      jj_consume_token(CONSTANTE_LIT);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void constante_recursiva() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      constante();
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void variavel_recursiva() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
      variavel();
      break;
    case 0:
      jj_consume_token(0);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NATURAL:
      jj_consume_token(NATURAL);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void lista_identificadores_variavel() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    lista_identificadores_variavel_recursivo();
  }

  static final public void lista_identificadores_variavel_recursivo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VIRGULA:
      jj_consume_token(VIRGULA);
      lista_identificadores_variavel();
      break;
    case ACOLCH:
      jj_consume_token(ACOLCH);
      jj_consume_token(CONSTANTE_NUM_INT);
      jj_consume_token(FCOLCH);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void lista_identificadores_constante() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    lista_identificadores_constante_recursivo();
  }

  static final public void lista_identificadores_constante_recursivo() throws ParseException {
    jj_consume_token(VIRGULA);
    lista_identificadores_constante();
  }

  static final public void corpo_do_programa() throws ParseException {
    jj_consume_token(EXECUTE);
    jj_consume_token(ACHAVE);
    lista_de_comandos();
    jj_consume_token(FCHAVE);
  }

  static final public void lista_de_comandos() throws ParseException {
    comando();
    comando_recursivo();
  }

  static final public void comando() throws ParseException {
    corpo_do_programa();
  }

  static final public void comando_recursivo() throws ParseException {
    lista_de_comandos();
  }

  static final public void identificador_programa() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
  }

  static final public void comentario() throws ParseException {
    jj_consume_token(CONSTANTE_LIT);
  }

  static final public void Programa() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PROGRAM:
      case DEFINE:
      case NOT:
      case VARIABLE:
      case IS:
      case BOOLEAN:
      case CHAR:
      case REAL:
      case NATURAL:
      case EXECUTE:
      case SET:
      case GET:
      case PUT:
      case LOOP:
      case WHILE:
      case TRUE:
      case FALSE:
      case DO:
      case TO:
      case COMENTARIO_LINHA:
      case COMENTARIO_BLOCO:
      case IDENTIFICADOR:
      case CONSTANTE_NUM_REAL:
      case CONSTANTE_NUM_INT:
      case CONSTANTE_LIT:
      case APARENT:
      case FPARENT:
      case ACHAVE:
      case FCHAVE:
      case ACOLCH:
      case FCOLCH:
      case VIRGULA:
      case PONTO:
      case ADICAO:
      case SUBTRACAO:
      case MULTIPLICACAO:
      case DIVISAO:
      case POTENCIA:
      case DIVISAOINTEIRA:
      case RESTODIVISAO:
      case IGUAL:
      case EQUIVALENTE:
      case DIFERENTE:
      case MENOR:
      case MENOROUIGUAL:
      case MAIOR:
      case MAIOROUIGUAL:
      case NAO:
      case OU:
      case E:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PROGRAM:
        jj_consume_token(PROGRAM);
        break;
      case DEFINE:
        jj_consume_token(DEFINE);
        break;
      case NOT:
        jj_consume_token(NOT);
        break;
      case VARIABLE:
        jj_consume_token(VARIABLE);
        break;
      case IS:
        jj_consume_token(IS);
        break;
      case BOOLEAN:
        jj_consume_token(BOOLEAN);
        break;
      case CHAR:
        jj_consume_token(CHAR);
        break;
      case REAL:
        jj_consume_token(REAL);
        break;
      case NATURAL:
        jj_consume_token(NATURAL);
        break;
      case EXECUTE:
        jj_consume_token(EXECUTE);
        break;
      case SET:
        jj_consume_token(SET);
        break;
      case GET:
        jj_consume_token(GET);
        break;
      case PUT:
        jj_consume_token(PUT);
        break;
      case LOOP:
        jj_consume_token(LOOP);
        break;
      case WHILE:
        jj_consume_token(WHILE);
        break;
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      case DO:
        jj_consume_token(DO);
        break;
      case TO:
        jj_consume_token(TO);
        break;
      case APARENT:
        jj_consume_token(APARENT);
        break;
      case FPARENT:
        jj_consume_token(FPARENT);
        break;
      case ACHAVE:
        jj_consume_token(ACHAVE);
        break;
      case FCHAVE:
        jj_consume_token(FCHAVE);
        break;
      case ACOLCH:
        jj_consume_token(ACOLCH);
        break;
      case FCOLCH:
        jj_consume_token(FCOLCH);
        break;
      case VIRGULA:
        jj_consume_token(VIRGULA);
        break;
      case PONTO:
        jj_consume_token(PONTO);
        break;
      case ADICAO:
        jj_consume_token(ADICAO);
        break;
      case SUBTRACAO:
        jj_consume_token(SUBTRACAO);
        break;
      case MULTIPLICACAO:
        jj_consume_token(MULTIPLICACAO);
        break;
      case DIVISAO:
        jj_consume_token(DIVISAO);
        break;
      case POTENCIA:
        jj_consume_token(POTENCIA);
        break;
      case DIVISAOINTEIRA:
        jj_consume_token(DIVISAOINTEIRA);
        break;
      case RESTODIVISAO:
        jj_consume_token(RESTODIVISAO);
        break;
      case IGUAL:
        jj_consume_token(IGUAL);
        break;
      case EQUIVALENTE:
        jj_consume_token(EQUIVALENTE);
        break;
      case DIFERENTE:
        jj_consume_token(DIFERENTE);
        break;
      case MENOR:
        jj_consume_token(MENOR);
        break;
      case MENOROUIGUAL:
        jj_consume_token(MENOROUIGUAL);
        break;
      case MAIOR:
        jj_consume_token(MAIOR);
        break;
      case MAIOROUIGUAL:
        jj_consume_token(MAIOROUIGUAL);
        break;
      case NAO:
        jj_consume_token(NAO);
        break;
      case OU:
        jj_consume_token(OU);
        break;
      case E:
        jj_consume_token(E);
        break;
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      case CONSTANTE_NUM_REAL:
        jj_consume_token(CONSTANTE_NUM_REAL);
        break;
      case CONSTANTE_NUM_INT:
        jj_consume_token(CONSTANTE_NUM_INT);
        break;
      case CONSTANTE_LIT:
        jj_consume_token(CONSTANTE_LIT);
        break;
      case COMENTARIO_BLOCO:
        jj_consume_token(COMENTARIO_BLOCO);
        break;
      case COMENTARIO_LINHA:
        jj_consume_token(COMENTARIO_LINHA);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public AnalisadorLexicoTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x5,0x18,0xe030000,0x9,0x11,0x3c0,0x0,0xcf3ffffe,0xcf3ffffe,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x14,0xffffbf,0xffffbf,};
   }

  /** Constructor with InputStream. */
  public AnalisadorLexico(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AnalisadorLexico(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalisadorLexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AnalisadorLexico(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalisadorLexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AnalisadorLexico(AnalisadorLexicoTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AnalisadorLexicoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[62];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 62; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }
  public String getMessages() {
    return this.token_source.getMensagesManhosas();
  }
}
