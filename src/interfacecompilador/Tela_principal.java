
package interfacecompilador;

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
    private javax.swing.JPanel cont_linha;
    private javax.swing.JPanel rodape;
    private javax.swing.JScrollPane painel_area_texto;
    private javax.swing.JScrollPane area_mensagem;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea area_texto;
    private javax.swing.JToolBar barra_ferramentas;
    // End of variables declaration

    public Tela_principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        painel_area_texto = new javax.swing.JScrollPane();
        area_texto = new javax.swing.JTextArea();
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
        cont_linha = new javax.swing.JPanel();
        rodape = new javax.swing.JPanel();
        barra_menu = new javax.swing.JMenuBar();
        arquivo = new javax.swing.JMenu();
        edicao = new javax.swing.JMenu();
        compilacao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        area_texto.setColumns(20);
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

        cont_linha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(cont_linha);
        cont_linha.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(rodape);
        rodape.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 17, Short.MAX_VALUE)
        );

        arquivo.setText("Arquivo");
        arquivo.setToolTipText("");
        barra_menu.add(arquivo);

        edicao.setText("Edição");
        barra_menu.add(edicao);

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
                                                .addComponent(cont_linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(cont_linha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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





}
