
package interfacecompilador;

import Analisadores.AnalisadorLexico;
import Editor_de_Texto.Area_de_transferencia;
import Editor_de_Texto.Manipulador_arquivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JF
 */
public class Tela_principal extends javax.swing.JFrame {
    // Variables declaration - do not modify
    private javax.swing.JMenu arquivo;
    private javax.swing.JMenu compilacao;
    private javax.swing.JMenu edicao;
    private javax.swing.JButton add_arquivo;
    private javax.swing.JButton abrir_pasta;
    private javax.swing.JButton salvar;
    private javax.swing.JButton recortar;
    private javax.swing.JButton copiar;
    private javax.swing.JButton colar;
    private javax.swing.JButton compilar;
    private javax.swing.JButton executar;
    private javax.swing.JButton boia;
    private javax.swing.JMenuBar barra_menu;
    private javax.swing.JPanel area_cont_linha;
    private javax.swing.JPanel rodape;
    private javax.swing.JScrollPane painel_area_texto;
    private javax.swing.JScrollPane area_mensagem;
    private javax.swing.JTextArea area_text_mensagem;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea area_texto;
    private javax.swing.JLabel  label_cont;
    private javax.swing.JLabel label_rodape;
    private javax.swing.JToolBar barra_ferramentas;
    private javax.swing.JMenuItem item_arq_novo;
    private javax.swing.JMenuItem item_arq_abrir;
    private javax.swing.JMenuItem item_arq_salvar;
    private javax.swing.JMenuItem item_arq_salvar_como;
    private javax.swing.JMenuItem item_arq_sair;
    private javax.swing.JMenuItem item_edi_copiar;
    private javax.swing.JMenuItem item_edi_colar;
    private javax.swing.JMenuItem item_edi_recortar;
    private javax.swing.JMenuItem item_comp_compilar;
    private javax.swing.JMenuItem item_comp_executar;
    private javax.swing.JScrollPane dentroTab;
    private javax.swing.JTabbedPane area_tabs;
    private javax.swing.JFileChooser seletor_aqruivos;
    private File file;
    private String texto_original;
    private boolean abriu_arquivo = false;
    private boolean salvou_arquivo = true;
    private boolean salvando = false;
    private AnalisadorLexico analisadorLexico;

    private Integer contlinha;
    // End of variables declaration

    public Tela_principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        painel_area_texto = new JScrollPane();
        area_texto = new JTextArea();
        label_cont = new JLabel();
        label_rodape = new JLabel();
        area_mensagem = new JScrollPane();
        barra_ferramentas = new JToolBar();
        add_arquivo = new JButton();
        abrir_pasta = new JButton();
        salvar = new JButton();
        jSeparator1 = new JToolBar.Separator();
        recortar = new JButton();
        copiar = new JButton();
        colar = new JButton();
        jSeparator2 = new JToolBar.Separator();
        compilar = new JButton();
        executar = new JButton();
        jSeparator3 = new JToolBar.Separator();
        boia = new JButton();
        jSeparator4 = new JSeparator();
        area_cont_linha = new JPanel();
        rodape = new JPanel();
        barra_menu = new JMenuBar();
        arquivo = new JMenu();
        edicao = new JMenu();
        compilacao = new JMenu();
        item_arq_novo = new JMenuItem();
        item_arq_abrir = new JMenuItem();
        item_arq_salvar = new JMenuItem();
        item_arq_salvar_como = new JMenuItem();
        item_arq_sair = new JMenuItem();
        item_edi_copiar = new JMenuItem();
        item_edi_colar = new JMenuItem();
        item_edi_recortar = new JMenuItem();
        item_comp_compilar = new JMenuItem();
        item_comp_executar = new JMenuItem();
        dentroTab = new JScrollPane();
        area_tabs = new JTabbedPane();
        contlinha = new Integer(1);
        seletor_aqruivos =  new JFileChooser();
        area_text_mensagem = new javax.swing.JTextArea();
        analisadorLexico = new AnalisadorLexico();


        label_cont.setText(contlinha.toString());
        label_rodape.setText("Linha:1,  Coluna:1" );
        label_cont.setVerticalAlignment(SwingConstants.TOP);
        label_rodape.setVerticalAlignment(SwingConstants.TOP);
        label_rodape.setHorizontalAlignment(SwingConstants.LEFT);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        area_texto.setColumns(20);
        KeyListener keyAction = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    if(area_texto.getLineCount() + 1 > contlinha){
                        incrementa_linha();
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                    if(area_texto.getText().split("\n").length < contlinha){
                        decrementa_linha();
                    }

                }
                String coluna = "1";
                if (area_texto.getText().split("\n").length == contlinha){
                    coluna = Integer.toString(area_texto.getText().split("\n")[contlinha-1].length()+1);
                }
                label_rodape.setText("Linha:" + contlinha.toString() + ", Coluna:" + coluna);
                if (abriu_arquivo) {
                    if (area_texto.getText().compareTo(texto_original)== 1) {
                        area_tabs.setTitleAt(0, file.getName() + "*");
                        salvou_arquivo = false;
                    }
                }else if(area_tabs.getTitleAt(0) == "Sem título"){
                    area_tabs.setTitleAt(0,  "Sem título*");
                    salvou_arquivo = false;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        area_texto.addKeyListener(keyAction);
        area_texto.setRows(5);
        dentroTab.setViewportView(area_texto);

        area_text_mensagem.setColumns(20);
        area_text_mensagem.setRows(5);
        area_mensagem.setViewportView(area_text_mensagem);
        area_text_mensagem.setEnabled(false);
        area_text_mensagem.setDisabledTextColor(Color.RED);
        area_text_mensagem.setText("Inicio do programa");

        area_tabs.addTab("Sem título", dentroTab);

        painel_area_texto.setViewportView(area_tabs);

        barra_ferramentas.setRollover(true);

        add_arquivo.setIcon(new ImageIcon("contentes/file-add_114479.png")); // NOI18N
        add_arquivo.setBorderPainted(false);
        add_arquivo.setFocusable(false);
        add_arquivo.setHorizontalTextPosition(SwingConstants.CENTER);
        add_arquivo.setVerticalTextPosition(SwingConstants.BOTTOM);
        add_arquivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (salvar_arquivo()){
                    area_texto.setText("");
                    contlinha = 1;
                    label_cont.setText("1");
                    abriu_arquivo = false;
                    salvou_arquivo = true;
                    area_tabs.setTitleAt(0,  "Sem título");
                }
            }
        });
        barra_ferramentas.add(add_arquivo);

        abrir_pasta.setIcon(new ImageIcon("contentes/openpaste.png")); // NOI18N
        abrir_pasta.setBorderPainted(false);
        abrir_pasta.setFocusable(false);
        abrir_pasta.setHorizontalTextPosition(SwingConstants.CENTER);
        abrir_pasta.setVerticalTextPosition(SwingConstants.BOTTOM);
        abrir_pasta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (salvar_arquivo()){
                    interface_abrir_arquivo();
                }
            }
        });
        barra_ferramentas.add(abrir_pasta);

        salvar.setIcon(new ImageIcon("contentes/savedisk.png")); // NOI18N
        salvar.setBorderPainted(false);
        salvar.setFocusable(false);
        salvar.setHorizontalTextPosition(SwingConstants.CENTER);
        salvar.setVerticalTextPosition(SwingConstants.BOTTOM);
        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvando = true;
                if (salvar_arquivo()){
                    salvando = false;
                    area_tabs.setTitleAt(0,  file.getName());
                    salvou_arquivo = true;
                    abriu_arquivo = true;
                }

            }
        });
        barra_ferramentas.add(salvar);
        barra_ferramentas.add(jSeparator1);

        recortar.setIcon(new ImageIcon("contentes/sizer.png")); // NOI18N
        recortar.setBorderPainted(false);
        recortar.setFocusable(false);
        recortar.setHorizontalTextPosition(SwingConstants.CENTER);
        recortar.setVerticalTextPosition(SwingConstants.BOTTOM);
        recortar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                recortarActionPerformed(evt);
            }
        });
        barra_ferramentas.add(recortar);

        copiar.setIcon(new ImageIcon("contentes/copiar.png")); // NOI18N
        copiar.setBorderPainted(false);
        copiar.setFocusable(false);
        copiar.setHorizontalTextPosition(SwingConstants.CENTER);
        copiar.setVerticalTextPosition(SwingConstants.BOTTOM);
        copiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        barra_ferramentas.add(copiar);

        colar.setIcon(new ImageIcon("contentes/colar.png")); // NOI18N
        colar.setBorderPainted(false);
        colar.setFocusable(false);
        colar.setHorizontalTextPosition(SwingConstants.CENTER);
        colar.setVerticalTextPosition(SwingConstants.BOTTOM);
        colar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                colarActionPerformed(evt);
            }
        });
        barra_ferramentas.add(colar);
        barra_ferramentas.add(jSeparator2);

        compilar.setIcon(new ImageIcon("contentes/martelo.png")); // NOI18N
        compilar.setBorderPainted(false);
        compilar.setFocusable(false);
        compilar.setHorizontalTextPosition(SwingConstants.CENTER);
        compilar.setVerticalTextPosition(SwingConstants.BOTTOM);
        compilar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //chama compilador
                area_text_mensagem.setText(analisadorLexico.compilar(area_texto.getText()));
            }
        });
        barra_ferramentas.add(compilar);

        executar.setIcon(new ImageIcon("contentes/play.png")); // NOI18N
        executar.setBorderPainted(false);
        executar.setFocusable(false);
        executar.setHorizontalTextPosition(SwingConstants.CENTER);
        executar.setVerticalTextPosition(SwingConstants.BOTTOM);
        executar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //chama compilador
                area_text_mensagem.setText("Executando...\nExecutado.");
            }
        });
        barra_ferramentas.add(executar);
        barra_ferramentas.add(jSeparator3);

        boia.setIcon(new ImageIcon("contentes/boia.png")); // NOI18N
        boia.setBorderPainted(false);
        boia.setFocusable(false);
        boia.setHorizontalTextPosition(SwingConstants.CENTER);
        boia.setVerticalTextPosition(SwingConstants.BOTTOM);
        barra_ferramentas.add(boia);

        area_cont_linha.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout jPanel1Layout = new GroupLayout(area_cont_linha);
        area_cont_linha.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_cont, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label_cont, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(rodape);
        rodape.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_rodape, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(label_rodape))
        );

        item_arq_abrir.setText("Abrir");
        item_arq_abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (salvar_arquivo()){
                    interface_abrir_arquivo();
                }

            }
        });
        item_arq_novo.setText("Novo");
        item_arq_salvar.setText("Salvar");
        item_arq_salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvando = true;
                if (salvar_arquivo()){
                    salvando = false;
                    area_tabs.setTitleAt(0,  file.getName());
                    salvou_arquivo = true;
                    abriu_arquivo = true;
                }
            }
        });
        item_arq_salvar_como.setText("Salvar como");
        item_arq_salvar_como.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salvando = true;
                if (salvar_arquivo()){
                    salvando = false;
                    area_tabs.setTitleAt(0,  file.getName());
                    salvou_arquivo = true;
                    abriu_arquivo = true;
                }
            }
        });
        item_arq_sair.setText("Sair");
        item_arq_sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (abriu_arquivo == false){
                    System.exit(0);
                }
                else{
                    if (salvou_arquivo == false){
                        JOptionPane tela_ao_sair = new JOptionPane();
                        switch (tela_ao_sair.showConfirmDialog(null, "Suas alterações não foram salvas. Deseja salvar?")) {
                            case 0:
                                if (salvar_arquivo()){
                                    System.exit(0);
                                }

                                break;
                            case 1:
                                //chama saída do programa.
                                System.exit(0);
                                break;
                            default:
                                //não faz nada
                                break;
                        }
                    }else{
                        System.exit(0);
                    }

                }
            }
        });

        arquivo.add(item_arq_abrir);
        arquivo.add(item_arq_novo);
        arquivo.add(item_arq_salvar);
        arquivo.add(item_arq_salvar_como);
        arquivo.add(item_arq_sair);

        arquivo.setText("Arquivo");
        arquivo.setToolTipText("");
        barra_menu.add(arquivo);

        item_edi_copiar.setText("Copiar");
        item_edi_copiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });
        item_edi_colar.setText("Colar");
        item_edi_colar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                colarActionPerformed(evt);
            }
        });
        item_edi_recortar.setText("Recortar");
        item_edi_recortar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                recortarActionPerformed(evt);
            }
        });

        edicao.add(item_edi_copiar);
        edicao.add(item_edi_colar);
        edicao.add(item_edi_recortar);
        edicao.setText("Edição");
        barra_menu.add(edicao);

        item_comp_compilar.setText("Compilar");
        item_comp_compilar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //chama compilador
                area_text_mensagem.setText(analisadorLexico.compilar(area_texto.getText()));
            }
        });
        item_comp_executar.setText("Executar");
        item_comp_executar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //chama compilador
                area_text_mensagem.setText("Executando...\nExecutado.");
            }
        });

        compilacao.add(item_comp_compilar);
        compilacao.add(item_comp_executar);
        compilacao.setText("Compilação");
        barra_menu.add(compilacao);

        setJMenuBar(barra_menu);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(barra_ferramentas, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addComponent(area_mensagem)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(area_cont_linha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(painel_area_texto, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rodape, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(barra_ferramentas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(painel_area_texto, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(area_cont_linha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(area_mensagem, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rodape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    public boolean salvar_arquivo(){
            if (salvou_arquivo == true){
                return true;
            }else if(salvando == true){
                Path caminho;
                //cchama botão de salvar da tela.
                if(abriu_arquivo == false){
                    JTextField caminho_salvar = new JTextField();
                    JFileChooser salvarChoose = new JFileChooser();
                    salvarChoose.setFileFilter(new javax.swing.filechooser.FileFilter(){
                        public boolean accept(File f){
                            return (f.getName().endsWith(".txt")) || f.isDirectory();
                        }
                        public String getDescription(){
                            return "Text documents (*.txt)";
                        }
                    });
                    salvarChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int i= salvarChoose.showSaveDialog(this);
                    if (i==1){
                        caminho_salvar.setText("");
                        return false;
                    } else {
                        file = salvarChoose.getSelectedFile();
                        caminho_salvar.setText(file.getPath());
                        if ( !file.getPath().endsWith(".txt") ){
                            caminho_salvar.setText(file.getPath() + ".txt");
                        }

                        caminho = Paths.get(caminho_salvar.getText());
                        file = new File(caminho_salvar.getText());
                    }

                }else{
                    caminho = Paths.get(file.getPath()) ;
                }

                Manipulador_arquivo salvar = new Manipulador_arquivo();
                try {
                    salvar.salva_arquivo(area_texto.getText(), caminho);
                } catch (IOException e) {
                    return false;
                }
            }
            else{
                JOptionPane tela_ao_sair = new JOptionPane();
                switch (tela_ao_sair.showConfirmDialog(null, "Suas alterações não foram salvas. Deseja salvar?")) {
                    case 0:
                        Path caminho;
                        //cchama botão de salvar da tela.
                        if(abriu_arquivo == false){
                            JTextField caminho_salvar = new JTextField();
                            JFileChooser salvarChoose = new JFileChooser();
                            salvarChoose.setFileFilter(new javax.swing.filechooser.FileFilter(){
                                public boolean accept(File f){
                                    return (f.getName().endsWith(".txt")) || f.isDirectory();
                                }
                                public String getDescription(){
                                    return "Text documents (*.txt)";
                                }
                            });
                            salvarChoose.setFileSelectionMode(JFileChooser.FILES_ONLY);
                            int i= salvarChoose.showSaveDialog(this);
                            if (i==1){
                                caminho_salvar.setText("");
                                return false;
                            } else {
                                file = salvarChoose.getSelectedFile();
                                caminho_salvar.setText(file.getPath());
                                if (!file.getPath().endsWith(".txt")){
                                    caminho_salvar.setText(file.getPath() + ".txt");
                                }
                                caminho = Paths.get(caminho_salvar.getText());
                                file = new File(caminho_salvar.getText());
                            }

                        }else{
                            caminho = Paths.get(file.getPath()) ;
                        }

                        Manipulador_arquivo salvar = new Manipulador_arquivo();
                        try {
                            salvar.salva_arquivo(area_texto.getText(), caminho);
                        } catch (IOException e) {
                            return false;
                        }
                        break;
                    default:
                        //não faz nada
                        break;
                }
            }
            return  true;
    }
    public String getTexto(){
        return this.area_texto.getText();
    }
    public File getFile(){
        return  this.file;
    }
    private void interface_abrir_arquivo() {

        seletor_aqruivos.setFileFilter(new javax.swing.filechooser.FileFilter(){
            public boolean accept(File f){
                return (f.getName().endsWith(".txt")) || f.isDirectory();
            }
            public String getDescription(){
                return "Text documents (*.txt)";
            }
        });
        int returnVal = seletor_aqruivos.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = seletor_aqruivos.getSelectedFile();
            area_tabs.setTitleAt(0, file.getName());
            try {
                // What to do with the file, e.g. display it in a TextArea
                area_texto.read( new FileReader( file.getAbsolutePath() ), null );
                texto_original = area_texto.getText();
                abriu_arquivo = true;
                salvou_arquivo = true;
                label_cont.setText("1");
                contlinha = 1;
                incrementa_linha();
            } catch (IOException ex) {
                System.out.println("problem accessing file"+file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {
        Area_de_transferencia copiar_colar = new Area_de_transferencia();
        copiar_colar.setInTransfer(area_texto.getSelectedText());
    }

    private void colarActionPerformed(java.awt.event.ActionEvent evt) {
        Area_de_transferencia copiar_colar = new Area_de_transferencia();
        String texto_atual = area_texto.getText();
        texto_atual += copiar_colar.getInTransfer();
        area_texto.setText(texto_atual);
    }

    private void recortarActionPerformed(java.awt.event.ActionEvent evt) {
        Area_de_transferencia copiar_colar = new Area_de_transferencia();
        copiar_colar.setInTransfer(area_texto.getSelectedText());
        String texto_recortado = area_texto.getSelectedText();
        String texto_inteiro = area_texto.getText();
        area_texto.replaceSelection("");
    }
    public boolean getAbriuArquivo(){
        return this.abriu_arquivo;
    }
    public boolean getSalvouArquivo(){
        return this.salvou_arquivo;
    }
    public void incrementa_linha(){
        String texto_atual = label_cont.getText().replace("<html>", "").replace("</html>", "") + "<br>";

        if (this.abriu_arquivo){
            int distancia = area_texto.getLineCount() - contlinha;
            if(distancia == 0){
                return;
            }
            for( int i = 0; i < distancia-1; i ++){
                contlinha ++;
                texto_atual +=   contlinha.toString()  + "<br>" ;
            }
            contlinha = area_texto.getLineCount();
        }else{
                contlinha = area_texto.getLineCount() + 1;
        }
        texto_atual +=   contlinha.toString()  ;
        label_cont.setText("<html>" + texto_atual + "</html>");
        System.out.println(texto_atual);
    }

    public void decrementa_linha(){
        String texto_atual = label_cont.getText().replace("<html>", "").replace("</html>", "");
        String texto_replace = "<br>" + Integer.toString(area_texto.getLineCount());
        texto_atual =  texto_atual.replace(texto_replace, "");
        label_cont.setText("<html>" + texto_atual + "</html>");
        System.out.println(texto_atual);

        contlinha--;
    }




}
