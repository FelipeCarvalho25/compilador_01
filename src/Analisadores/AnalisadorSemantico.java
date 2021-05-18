package Analisadores;

import EstruturasDados.AreaInstrucao;
import EstruturasDados.Tabela;
import EstruturasDados.Pilha;

import java.util.ArrayList;

public class AnalisadorSemantico {
    private String contexto = "";
    private int VT = 0;
    private int VP = 0;
    private Pilha pilha_de_desvios ;
    private ArrayList<AreaInstrucao> area_instrucao;
    private int ponteiro = 1;
    private ArrayList<Tabela> tabela_simbolos;
    private ArrayList<Tabela> tupla;

    public AnalisadorSemantico(){
        pilha_de_desvios = new Pilha();
        area_instrucao = new ArrayList<>();
        tabela_simbolos =  new ArrayList<>();
        tupla = new ArrayList<>();
    }

    public boolean analisarSematica(String codigo, String acoes){
        boolean sucesso = true;



        return sucesso;
    }

}
