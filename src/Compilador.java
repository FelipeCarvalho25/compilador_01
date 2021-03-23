import javax.swing.*;

public class Compilador {
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Tela().getTela_principal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
