package EstruturasDados;

public class AreaInstrucao {
    public int numero ;
    public String codigo;
    public float fParametro;
    public int iParametro;
    public String sParametro;

    public AreaInstrucao(int numeroPar, String codigoPar, int parInt){
        numero = numeroPar;
        codigo  = codigoPar;
        iParametro = parInt;
    }
    public AreaInstrucao(int numeroPar, String codigoPar, float parReal){
        numero = numeroPar;
        codigo  = codigoPar;
        fParametro = parReal;
    }
    public AreaInstrucao(int numeroPar, String codigoPar, String parString){
        numero = numeroPar;
        codigo  = codigoPar;
        sParametro = parString;
    }
}
