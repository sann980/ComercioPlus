/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.view;

import br.com.controleestoque.dao.ClienteDao;
import br.com.controleestoque.dao.ItemVendaDao;
import br.com.controleestoque.dao.ProdutosDao;
import br.com.controleestoque.dao.VendasDao;
import br.com.controleestoque.model.Clientes;
import br.com.controleestoque.model.ItemVenda;
import br.com.controleestoque.model.Produtos;
import br.com.controleestoque.model.Vendas;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.text.NumberFormat;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class FrmPagamentos extends javax.swing.JFrame {

    /**
     * Creates new form FrmPagamentos
     */
    Clientes cliente = new Clientes();
    FrmVendas telaVendas = new FrmVendas();
    DefaultTableModel car;
    double totalVenda;

    public FrmPagamentos() {
        initComponents();

        txtDinheiro.setText("0,00");
        txtPix.setText("0,00");
        txtCartaoDebito.setText("0,00");
        txtCartaoCredito.setText("0,00");
        txtCheque.setText("0,00");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDinheiro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPix = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        btnFinalizarVenda = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtCartaoDebito = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCheque = new javax.swing.JTextField();
        txtCartaoCredito = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancelarVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Pagamentos");

        jPanel1.setBackground(new java.awt.Color(126, 217, 87));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAGAMENTO");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel6.setText("OBS. (F7):");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setText("DINHEIRO (F2):");

        txtDinheiro.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel8.setText("PIX (F3):");

        txtPix.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel10.setText("TROCO:");

        txtTroco.setEditable(false);
        txtTroco.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        btnFinalizarVenda.setBackground(new java.awt.Color(0, 204, 0));
        btnFinalizarVenda.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btnFinalizarVenda.setForeground(new java.awt.Color(0, 204, 0));
        btnFinalizarVenda.setText("PAGAMENTO (F12)");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel11.setText("TOTAL:");

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel12.setText("CARTÃO DEB. (F4):");

        txtCartaoDebito.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel13.setText("CHEQUE (F6):");

        txtCheque.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        txtCartaoCredito.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel9.setText("CARTÃO CRÉD. (F5):");

        btnCancelarVenda.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelarVenda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelarVenda.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelarVenda.setText("CANC. PAGAMENTO (F11)");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCheque, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtPix)
                            .addComponent(txtDinheiro)
                            .addComponent(txtTroco)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCartaoCredito)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCartaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCartaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarVenda)
                    .addComponent(btnCancelarVenda))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        //Botão finalizar venda
        double pgDin, pgPix, pgCartCred, pgCartDeb, pgCheque, totalPago, totalTroco;

        //Pega os valores referente aos pagamentos em dinheiro, pix, cartão e cheque
        pgDin = Double.parseDouble(txtDinheiro.getText().replaceAll(",", "."));
        pgPix = Double.parseDouble(txtPix.getText().replaceAll(",", "."));
        pgCartCred = Double.parseDouble(txtCartaoCredito.getText().replaceAll(",", "."));
        pgCartDeb = Double.parseDouble(txtCartaoDebito.getText().replaceAll(",", "."));
        pgCheque = Double.parseDouble(txtCheque.getText().replaceAll(",", "."));

        totalPago = pgDin + pgPix + pgCartCred + pgCartDeb + pgCheque;

        if (totalPago >= totalVenda) { //Compara se os valores pagos são maior ou igual ao total da compra
            //Calcular o troco
            ClienteDao daoC = new ClienteDao();
            
            totalTroco = totalPago - totalVenda;

            txtTroco.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(totalTroco)));

            Vendas objVenda = new Vendas();
            //Seta os dados do Cliente (id)
            if (cliente.getCpf() != null) {
                objVenda.setCliente(cliente);
            } else if (cliente.getCpf() == null) {
                cliente = daoC.buscarCientePorNome("Cliente nao identificado");
                objVenda.setCliente(cliente);
            }

            //Seta a data atual do sistema
            Date hoje = new Date();
            SimpleDateFormat dataEUA = new SimpleDateFormat("yyyy-MM-dd");
            String dataFormatada = dataEUA.format(hoje);
            objVenda.setDataVenda(dataFormatada);
            
            //Seta o total da venda sem desconto
            objVenda.setTotalVendaSemDesconto(telaVendas.totalComDesconto + telaVendas.desconto);
            
            //Seta o valor de Bruto de desconto
            objVenda.setTotalDesconto(telaVendas.desconto);
            
            //Seta o valor da venda com desconto
            objVenda.setTotalVendaComDesconto(totalVenda);
            
            //Observações
            objVenda.setObs(txtObs.getText());

            //Registrando venda
            VendasDao daoVenda = new VendasDao();
            daoVenda.registrarVenda(objVenda);

            //Retorna o id da ultima venda realizada
            objVenda.setId(daoVenda.retornaUltimaVenda());
            //System.out.println("Id da ultima venda: " + objVenda.getId());

            //Cadastrando os produtos na tabela intemvendas
            for (int i = 0; i < car.getRowCount(); i++) {
                Produtos objProdutos = new Produtos();
                ProdutosDao daoProdutos = new ProdutosDao();

                int qtdEstoque, qtdComprada, qtdAtualizada; //Variaveis para serem utilizada na baixa de produtos

                ItemVenda item = new ItemVenda();
                item.setVenda(objVenda); //Seta id da Ultima venda

                objProdutos = daoProdutos.buscarProdutoPorCodBarras(car.getValueAt(i, 0).toString());
                item.setProduto(objProdutos); //Seta id dos produtos
                item.setQtd(Integer.parseInt(car.getValueAt(i, 3).toString())); //Seta quantidade de produtos
                item.setSubtotal(Integer.parseInt(car.getValueAt(i, 3).toString()) * objProdutos.getPrecoVarejo()); //Seta Subtotal
                    //Setando o valor do desconto
                if(car.getValueAt(i, 4) != null){
                    item.setDesconto(Double.parseDouble(car.getValueAt(i, 4).toString().
                            substring(3, car.getValueAt(i, 4).toString().length()).replaceAll(",", ".")));
                }else{
                    item.setDesconto(0);
                }
                
                //Seta o subtotal
                item.setTotal(Double.parseDouble(car.getValueAt(i, 5).toString()
                                 .substring(3, car.getValueAt(i, 5).toString().length()).replaceAll(",", ".")));
                
                
                //---------------------Dar baixa no estoque-------------------------
                qtdEstoque = daoProdutos.retornaEstoqueAtual(objProdutos.getId());
                qtdComprada = Integer.parseInt(car.getValueAt(i, 3).toString());
                qtdAtualizada = qtdEstoque - qtdComprada;

                daoProdutos.baixaEstoque(objProdutos.getId(), qtdAtualizada);
                
                //Verificar se a qtd em estoque está abaixo da qtd para aviso
                if(qtdAtualizada <= objProdutos.getQtdEstoqueAviso()){
                    
                    JOptionPane.showMessageDialog(null, "A quantidade do produto " + objProdutos.getDescricao() + 
                            ", está abaixo ou iqual a quantidade programada para aviso.");
                    
                }
                //------------------------------------------------------------------

                ItemVendaDao daoItem = new ItemVendaDao();
                daoItem.cadastrarItenVenda(item);

            }
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
            
            int op;

                op = JOptionPane.showConfirmDialog(null, "Você deseja imprimir o cupom fiscal?");

                if (op == 0) {
                    imprimirCoprovante();
                }

            daoVenda.limparPdv(telaVendas, car);

            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Os valores de pagamento precisam ser maior ou igual ao total da compra!");
        }

    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed
        //Botão Cancelar Venda
        int op;

        op = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja CANCELAR a venda?");

        if (op == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void imprimirCoprovante() {
        //Pegar data
        Date hoje = new Date();
        SimpleDateFormat dataEUA = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = dataEUA.format(hoje);
        //Pegar hora
        dataEUA = new SimpleDateFormat("H:mm:ss");
        String hora = dataEUA.format(hoje);

        String conteudoCupom = "";

        for (int i = 0; i < car.getRowCount(); i++) {
            String preco = telaVendas.carrinho.getValueAt(i, 2).toString().substring(3, telaVendas.carrinho.getValueAt(i, 2).toString().length());
            String descontoProduto;
            String subtotal = telaVendas.carrinho.getValueAt(i, 5).toString().substring(3, telaVendas.carrinho.getValueAt(i, 5).toString().length());
            
            if(car.getValueAt(i, 4) == null){
                descontoProduto = "0,00";
            }else{
                descontoProduto = telaVendas.carrinho.getValueAt(i, 4).toString().substring(3, telaVendas.carrinho.getValueAt(i, 4).toString().length());
            }
              
            conteudoCupom += i + 1 + "  "+car.getValueAt(i, 0).toString()+"  "+car.getValueAt(i, 1).toString()+"\n\r"
                             +preco+"  "+car.getValueAt(i, 3).toString()+"  "+descontoProduto+" "+subtotal
                             +"  "+"\n\r";
        }
        
        String totalDesconto = telaVendas.txtTotalDesconto.getText().substring(3, telaVendas.txtTotalDesconto.getText().length());
        String totalCompra = telaVendas.txtTotalGeral.getText().substring(3, telaVendas.txtTotalGeral.getText().length());
        
        String cupom58MM =   "         EDIM - Mecanico        \n\r"
                            +"        Servicos em Geral       \n\r"
                            +"      Av. Tabajara BR - 222     \n\r"
                            +"         Santa Luzia - MA       \n\r"
                            +"     CNPJ: 46.850.444/0001-17   \n\r"
                            +"         (98) 9 8123-5692       \n\r"
                            +"        "+dataFormatada+" "+hora+"\n\r"
                            +"                                \n\r"
                            +"     *** SEM VALOR FISCAL ***   \n\r"
                            +"--------------------------------\n\r"
                            +"ITEM  CODIGO  DESCRICAO         \n\r"
                            +"PRECO  QTD  DESCONTO TOTAL      \n\r"
                            +"--------------------------------\n\r"
                            +conteudoCupom+"                  \n\r"
                            +"--------------------------------\n\r"
                            +"     Total de Desconto: "+totalDesconto+"\n\r"
                            +"       Total da Compra: "+totalCompra+"\n\r"
                            +"--------------------------------\n\r"
                            +"    AGRADECEMOS A PREFERENCIA   \n\r";
        
        this.imprimir(cupom58MM);
    }

    public void imprimir(String pTexto) {
        try {
            InputStream prin = new ByteArrayInputStream(pTexto.getBytes());
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            //Pega a impressora padrão
            PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
            printerAttributes.add(new JobName("Impressao", null));
            printerAttributes.add(OrientationRequested.PORTRAIT);
            printerAttributes.add(MediaSizeName.ISO_A4);
            //Informa o tipo de folha
            DocPrintJob printJob = impressora.createPrintJob();

            try {
                printJob.print(documentoTexto, (PrintRequestAttributeSet) printerAttributes);
                //Tenta Imprimir
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar a impressão: ");
            }

            prin.close();

        } catch (Exception e) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPagamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCartaoCredito;
    private javax.swing.JTextField txtCartaoDebito;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPix;
    public javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    // End of variables declaration//GEN-END:variables

}