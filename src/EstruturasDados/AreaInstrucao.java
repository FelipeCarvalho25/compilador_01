package EstruturasDados;

public class AreaInstrucao {
    public int ponteiro;
    public String comando;
    public float fParametro = -1;
    public int iParametro = -1;
    public String sParametro = null;

    public AreaInstrucao(int numeroPar, String codigoPar, int parInt){
        ponteiro = numeroPar;
        comando = codigoPar;
        iParametro = parInt;
    }
    public AreaInstrucao(int numeroPar, String codigoPar, float parReal){
        ponteiro = numeroPar;
        comando = codigoPar;
        fParametro = parReal;
    }
    public AreaInstrucao(int numeroPar, String codigoPar, String parString){
        ponteiro = numeroPar;
        comando = codigoPar;
        sParametro = parString;
    }
    public String getComando(){
        if(sParametro != null  &&  sParametro != "?"){
            return " " + ponteiro + " " + comando + " " + sParametro;
        }
        else if(fParametro > 0){
            return " " + ponteiro + " " + comando + " " + fParametro;
        }else {
            return " " + ponteiro + " " + comando + " " + iParametro;
        }

    }
}
