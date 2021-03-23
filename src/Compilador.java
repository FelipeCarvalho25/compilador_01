import javax.swing.*;

public class Compilador {
    public static void main(String[] args) {
        JMenuBar menu = new JMenuBar();
        JMenu arquivo = new JMenu("Arquivo");
        JMenu edicao = new JMenu("Edição");
        JMenu compilacao = new JMenu("Compilação");

        menu.add(arquivo);
        menu.add(edicao);
        menu.add(compilacao);

        JFrame frame = new JFrame("Compilador");
        frame.setJMenuBar(menu);
        frame.setContentPane(new Tela().getTela_principal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
