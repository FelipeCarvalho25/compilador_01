import javax.swing.*;
import java.awt.*;

public class Tela {

    private JPanel tela_principal;
    private JPanel area_edicao;
    private JPanel area_mensagem;
    private JEditorPane editor_texto;
    private JScrollPane mensagem_responsive;
    private JToolBar options;
    private JButton abrirPastaButton;
    private JButton tesouraButton;
    private JButton copiarButton;
    private JButton colarButton;
    private JButton marteloButton;
    private JButton playButton;
    private JButton boiaButton;
    private JButton novoArquivoButton;

    public Tela(){
        Dimension tamanho = new Dimension();
        tamanho.setSize(800, 500);
        tela_principal.setPreferredSize(tamanho);
        Dimension tamanho1 = new Dimension();
        tamanho1.setSize(600, 150);
        area_mensagem.setSize(tamanho1);

    }
    public JPanel getTela_principal(){
        return this.tela_principal;
    }
}
