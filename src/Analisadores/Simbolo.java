package Analisadores;
import java.util.ArrayList;
import java.util.List;
public class Simbolo {
    private String nome;
    private static final List<Simbolo> tabelaDeSimbolos = new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void addSimbolo(Simbolo simbolo) {
        if (!Simbolo.tabelaDeSimbolos.contains(simbolo))
            Simbolo.tabelaDeSimbolos.add(simbolo);
    }

    public static List<Simbolo> getTabelaDeSimbolos() {
        return tabelaDeSimbolos;
    }

    @Override
    public String toString(){
        return this.getNome();
    }

    @Override
    public boolean equals(Object obj){
        Simbolo s = (Simbolo) obj;
        return s.getNome().equals(this.nome);
    }
}
