
package interfacecompilador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private Integer contlinha;
    // End of variables declaration

    public Tela_principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        painel_area_texto = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
        label_cont = new javax.swing.JLabel();
        label_rodape = new javax.swing.JLabel();
        area_mensagem = new javax.swing.JScrollPane();
        barra_ferramentas = new javax.swing.JToolBar();
        add_arquivo = new javax.swing.JButton();
        abrir_pasta = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        recortar = new javax.swing.JButton();
        copiar = new javax.swing.JButton();
        colar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        compilar = new javax.swing.JButton();
        executar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        boia = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        area_cont_linha = new javax.swing.JPanel();
        rodape = new javax.swing.JPanel();
        barra_menu = new javax.swing.JMenuBar();
        arquivo = new javax.swing.JMenu();
        edicao = new javax.swing.JMenu();
        compilacao = new javax.swing.JMenu();
        item_arq_novo = new javax.swing.JMenuItem();
        item_arq_abrir = new javax.swing.JMenuItem();
        item_arq_salvar = new javax.swing.JMenuItem();
        item_arq_salvar_como = new javax.swing.JMenuItem();
        item_arq_sair = new javax.swing.JMenuItem();
        item_edi_copiar = new javax.swing.JMenuItem();
        item_edi_colar = new javax.swing.JMenuItem();
        item_edi_recortar = new javax.swing.JMenuItem();
        item_comp_compilar = new javax.swing.JMenuItem();
        item_comp_executar = new javax.swing.JMenuItem();
        contlinha = new Integer(1);


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
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        area_texto.addKeyListener(keyAction);
        area_texto.setRows(5);
        painel_area_texto.setViewportView(area_texto);

        barra_ferramentas.setRollover(true);

        add_arquivo.setIcon(new javax.swing.ImageIcon("contentes/file-add_114479.png")); // NOI18N
        add_arquivo.setBorderPainted(false);
        add_arquivo.setFocusable(false);
        add_arquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_arquivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(add_arquivo);

        abrir_pasta.setIcon(new javax.swing.ImageIcon("contentes/openpaste.png")); // NOI18N
        abrir_pasta.setBorderPainted(false);
        abrir_pasta.setFocusable(false);
        abrir_pasta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir_pasta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(abrir_pasta);

        salvar.setIcon(new javax.swing.ImageIcon("contentes/savedisk.png")); // NOI18N
        salvar.setBorderPainted(false);
        salvar.setFocusable(false);
        salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(salvar);
        barra_ferramentas.add(jSeparator1);

        recortar.setIcon(new javax.swing.ImageIcon("contentes/sizer.png")); // NOI18N
        recortar.setBorderPainted(false);
        recortar.setFocusable(false);
        recortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(recortar);

        copiar.setIcon(new javax.swing.ImageIcon("contentes/copiar.png")); // NOI18N
        copiar.setBorderPainted(false);
        copiar.setFocusable(false);
        copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(copiar);

        colar.setIcon(new javax.swing.ImageIcon("contentes/colar.png")); // NOI18N
        colar.setBorderPainted(false);
        colar.setFocusable(false);
        colar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(colar);
        barra_ferramentas.add(jSeparator2);

        compilar.setIcon(new javax.swing.ImageIcon("contentes/martelo.png")); // NOI18N
        compilar.setBorderPainted(false);
        compilar.setFocusable(false);
        compilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        compilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(compilar);

        executar.setIcon(new javax.swing.ImageIcon("contentes/play.png")); // NOI18N
        executar.setBorderPainted(false);
        executar.setFocusable(false);
        executar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        executar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(executar);
        barra_ferramentas.add(jSeparator3);

        boia.setIcon(new javax.swing.ImageIcon("contentes/boia.png")); // NOI18N
        boia.setBorderPainted(false);
        boia.setFocusable(false);
        boia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barra_ferramentas.add(boia);

        area_cont_linha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(area_cont_linha);
        area_cont_linha.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_cont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(rodape);
        rodape.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(label_rodape))
        );

        item_arq_abrir.setText("Abrir");
        item_arq_novo.setText("Novo");
        item_arq_salvar.setText("Salvar");
        item_arq_salvar_como.setText("Salvar como");
        item_arq_sair.setText("Sair");

        arquivo.add(item_arq_abrir);
        arquivo.add(item_arq_novo);
        arquivo.add(item_arq_salvar);
        arquivo.add(item_arq_salvar_como);
        arquivo.add(item_arq_sair);

        arquivo.setText("Arquivo");
        arquivo.setToolTipText("");
        barra_menu.add(arquivo);

        item_edi_copiar.setText("Copiar");
        item_edi_colar.setText("Colar");
        item_edi_recortar.setText("Recortar");

        edicao.add(item_edi_copiar);
        edicao.add(item_edi_colar);
        edicao.add(item_edi_recortar);
        edicao.setText("Edição");
        barra_menu.add(edicao);

        item_comp_compilar.setText("Compilar");
        item_comp_executar.setText("Executar");

        compilacao.add(item_comp_compilar);
        compilacao.add(item_comp_executar);
        compilacao.setText("Compilação");
        barra_menu.add(compilacao);

        setJMenuBar(barra_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(barra_ferramentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addComponent(area_mensagem)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(area_cont_linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(painel_area_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(barra_ferramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(painel_area_texto, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(area_cont_linha, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(area_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    public void incrementa_linha(){
        String texto_atual = label_cont.getText().replace("<html>", "").replace("</html>", "") + "<br>";
        contlinha = area_texto.getLineCount() + 1;
        texto_atual +=   contlinha.toString()  ;
        label_cont.setText("<html>" + texto_atual + "</html>");
        System.out.println(texto_atual);
    }

    public void decrementa_linha(){
        String texto_atual = label_cont.getText().replace("<html>", "").replace("</html>", "");
        texto_atual =  texto_atual.substring(0, texto_atual.length()-5);
        label_cont.setText("<html>" + texto_atual + "</html>");
        System.out.println(texto_atual);

        contlinha--;
    }




}
