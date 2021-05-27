package interfacecompilador;


import java.awt.*;

public class Tela_execucao extends javax.swing.JFrame {
    // Variables declaration - do not modify
    private javax.swing.JTextArea areaTextExecution;
    private javax.swing.JButton envia;
    private javax.swing.JTextField inputExecution;
    private javax.swing.JScrollPane jScrollPane1;
    private String textoExecucao = "";
    // End of variables declaration
    public Tela_execucao(){
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextExecution = new javax.swing.JTextArea();
        inputExecution = new javax.swing.JTextField();
        envia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTextExecution.setColumns(20);
        areaTextExecution.setRows(5);
        areaTextExecution.setEnabled(false);
        areaTextExecution.setDisabledTextColor(Color.BLACK);
        areaTextExecution.setText(textoExecucao);
        jScrollPane1.setViewportView(areaTextExecution);
        inputExecution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputExecutionActionPerformed(evt);
            }
        });

        envia.setText("Envia");
        envia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inputExecution)
                                                .addGap(18, 18, 18)
                                                .addComponent(envia)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(inputExecution))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(envia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    private void inputExecutionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void enviaActionPerformed(java.awt.event.ActionEvent evt) {
        textoExecucao += " " + inputExecution.getText() + "\n";
        inputExecution.setText("");
        areaTextExecution.setText(textoExecucao);
    }

    public void setTexto(String texto){
        textoExecucao = texto;
        areaTextExecution.setText(textoExecucao);
    }
    public  void setDisableInput(){
        inputExecution.setEnabled(false);
        envia.setEnabled(false);
    }
}
