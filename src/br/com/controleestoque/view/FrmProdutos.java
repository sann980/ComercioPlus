/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.view;

import br.com.controleestoque.dao.FornecedoresDao;
import br.com.controleestoque.dao.ProdutosDao;
import br.com.controleestoque.model.Fornecedores;
import br.com.controleestoque.model.Produtos;
import br.com.controleestoque.model.Utilitarios;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class FrmProdutos extends javax.swing.JFrame {

    /**
     * Creates new form FrmClientes
     * @throws java.sql.SQLException
     */
    //Metodo para listar na tabela
    public void listar() throws SQLException {
        ProdutosDao dao = new ProdutosDao();
        List<Produtos> list = dao.listarProdutos();
        DefaultTableModel dados = (DefaultTableModel) TabelaProdutos.getModel();

        dados.setNumRows(0); //Apaga tudo que tem na tabela

        for (Produtos p : list) {
            dados.addRow(new Object[]{
                p.getId(),
                p.getCodBarras(),
                p.getDescricao(),
                p.getUn(),
                NumberFormat.getCurrencyInstance().format(p.getPrecoCusto()),
                NumberFormat.getCurrencyInstance().format(p.getPrecoVarejo()),
                p.getQtdEstoque(),
                p.getQtdEstoqueAviso(),
                p.getFornecedor().getNome()
            });
        }
    }

    public FrmProdutos() {
        initComponents();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelDados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtPrecoVarejo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboBoxFornecedores = new javax.swing.JComboBox();
        btnPesquisarCadastro = new javax.swing.JButton();
        txtQtdEstoque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoDeBarras = new javax.swing.JTextField();
        txtPrecoCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoAtacado = new javax.swing.JTextField();
        txtQtdEstoqueAviso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboBoxUn = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(126, 217, 87));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        painelDados.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrecoVarejo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço Varejo R$:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Qtd. Estoque:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Fornecedor:");

        comboBoxFornecedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxFornecedores.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                comboBoxFornecedoresAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        comboBoxFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxFornecedoresMouseClicked(evt);
            }
        });
        comboBoxFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFornecedoresActionPerformed(evt);
            }
        });

        btnPesquisarCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisarCadastro.setText("Pesquisar");
        btnPesquisarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCadastroActionPerformed(evt);
            }
        });

        txtQtdEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cód. de Barras:");

        txtCodigoDeBarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoDeBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoDeBarrasKeyPressed(evt);
            }
        });

        txtPrecoCusto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Preço de Custo R$:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Preço Atacado R$:");

        txtPrecoAtacado.setEditable(false);
        txtPrecoAtacado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtQtdEstoqueAviso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Qtd. Mín. Para Aviso:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Und. Medida:");

        comboBoxUn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxUn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UND", "G", "KG", "ML", "L" }));

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoCusto))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxUn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoDeBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                        .addGap(19, 19, 19)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecoAtacado, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(txtQtdEstoque))
                        .addGap(18, 18, 18)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQtdEstoqueAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecoVarejo)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCadastro))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecoAtacado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecoVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigoDeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtQtdEstoqueAviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(comboBoxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(comboBoxUn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Produtos", painelDados);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nome:");

        txtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cód. de Barras", "Descrição", "Und", "Preço de Custo", "Preço Varejo", "Qtd. Estoque", "Qtd. Míni. Para Aviso", "Fornecedor"
            }
        ));
        TabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProdutos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar)
                        .addGap(0, 252, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar Produtos", jPanel3);

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setText("NOVO+");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("CADASTRAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEditar, btnExcluir, btnNovo, btnSalvar});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //Limpa painel
        new Utilitarios().limparTela(painelDados);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Botão Cadastrar
        Produtos obj = new Produtos();
        
        obj.setCodBarras(txtCodigoDeBarras.getText());
        obj.setDescricao(txtDescricao.getText());
        obj.setUn(comboBoxUn.getSelectedItem().toString());
        obj.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText().replaceAll(",", ".")));
        obj.setPrecoVarejo(Double.parseDouble(txtPrecoVarejo.getText().replaceAll(",", ".")));
        obj.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
        obj.setQtdEstoqueAviso(Integer.parseInt(txtQtdEstoqueAviso.getText()));
        
        
        //Criar um objeto de Fornecedores
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) comboBoxFornecedores.getSelectedItem();
        
        obj.setFornecedor(f);
        
        ProdutosDao dao = new ProdutosDao();
        
        dao.cadastrar(obj);
        
        //Limpa painel
        new Utilitarios().limparTela(painelDados);

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Botão Editar
        Produtos obj = new Produtos();

        obj.setId(Integer.parseInt(txtID.getText()));
        obj.setCodBarras(txtCodigoDeBarras.getText());
        obj.setDescricao(txtDescricao.getText());
        obj.setUn(comboBoxUn.getSelectedItem().toString());
        obj.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText().replaceAll(",", ".")));
        obj.setPrecoVarejo(Double.parseDouble(txtPrecoVarejo.getText().replaceAll(",", ".")));
        obj.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
        obj.setQtdEstoqueAviso(Integer.parseInt(txtQtdEstoqueAviso.getText()));
        
        
        //Cria um objeto Fornecedor
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) comboBoxFornecedores.getSelectedItem();
        
        //Setando Fornecedor
        obj.setFornecedor(f);
        
        ProdutosDao dao = new ProdutosDao();
        dao.alterarProduto(obj);
        
        //Limpa painel
        new Utilitarios().limparTela(painelDados);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Botão excluir
        Produtos obj = new Produtos();

        obj.setId(Integer.parseInt(txtID.getText()));

        ProdutosDao dao = new ProdutosDao();

        dao.excluirProduto(obj);
        
        //Limpa painel
        new Utilitarios().limparTela(painelDados);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            //Carregar Lista
            listar();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }//GEN-LAST:event_formWindowActivated

    private void TabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProdutosMouseClicked
        //1 - Adicionar itens nos campos id, descricão, preço e estoque
        ProdutosDao pDao = new ProdutosDao();
        Produtos p = new Produtos();
        
        jTabbedPane1.setSelectedIndex(0);
        
        txtID.setText(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 0).toString());
        p = pDao.buscarProdutoPorId(Integer.parseInt(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 0).toString()));
        txtCodigoDeBarras.setText(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 1).toString());
        txtDescricao.setText(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 2).toString());
        comboBoxUn.setSelectedItem(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 3).toString());
        txtPrecoCusto.setText(String.valueOf(p.getPrecoCusto()).format("%.2f", p.getPrecoCusto()));
        txtPrecoVarejo.setText(String.valueOf(p.getPrecoVarejo()).format("%.2f", p.getPrecoVarejo()));
        txtQtdEstoque.setText(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 6).toString());
        txtQtdEstoqueAviso.setText(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 7).toString());
        
        
        //2 - Adicionar itens no ComboBox
        Fornecedores f = new Fornecedores();
        FornecedoresDao dao = new FornecedoresDao();
        
        f = dao.buscarFornecedorUnico(TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 8).toString());
        
        //Remover Itens do ComboBox
        comboBoxFornecedores.removeAllItems();
        
        //Adicionar intens no ComboBox
        comboBoxFornecedores.getModel().setSelectedItem(f);
    }//GEN-LAST:event_TabelaProdutosMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            //Botão pesquisar
            String nome = "%" + txtPesquisar.getText() + "%";
            
            ProdutosDao dao = new ProdutosDao();
            List<Produtos> list = dao.listarProdutosPorNome(nome);
            
            DefaultTableModel dados = (DefaultTableModel) TabelaProdutos.getModel();
            
            dados.setNumRows(0); //Apaga tudo que tem na tabela
            
            for (Produtos p : list) {
                dados.addRow(new Object[]{
                    p.getId(),
                    p.getCodBarras(),
                    p.getDescricao(),
                    p.getUn(),
                    p.getPrecoCusto(),
                    p.getPrecoVarejo(),
                    p.getQtdEstoque(),
                    p.getQtdEstoqueAviso(),
                    p.getFornecedor().getNome()
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        try {
            //Botão pesquisar
            String nome = "%" + txtPesquisar.getText() + "%";
            
            ProdutosDao dao = new ProdutosDao();
            List<Produtos> list = dao.listarProdutosPorNome(nome);
            
            DefaultTableModel dados = (DefaultTableModel) TabelaProdutos.getModel();
            
            dados.setNumRows(0); //Apaga tudo que tem na tabela
            
            for (Produtos p : list) {
                dados.addRow(new Object[]{
                    p.getId(),
                    p.getCodBarras(),
                    p.getDescricao(),
                    p.getUn(),
                    p.getPrecoCusto(),
                    p.getPrecoVarejo(),
                    p.getQtdEstoque(),
                    p.getQtdEstoqueAviso(),
                    p.getFornecedor().getNome()
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    private void btnPesquisarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCadastroActionPerformed
        // Pesquisa por nome e preenche o formulário com os dados encontrado
        String nome = txtDescricao.getText();
        Produtos obj = new Produtos();
        ProdutosDao dao = new ProdutosDao();
        
        obj = dao.buscarProdutoPorNome(nome);
        comboBoxFornecedores.removeAllItems();
        
        if(obj.getDescricao() != null){
            //Exibi os dados no formulário
            txtID.setText(String.valueOf(obj.getId()));
            txtCodigoDeBarras.setText(obj.getCodBarras());
            txtDescricao.setText(obj.getDescricao());
            comboBoxUn.setSelectedItem(obj.getUn());
            txtPrecoCusto.setText(String.valueOf(obj.getPrecoCusto()));
            txtPrecoVarejo.setText(String.valueOf(obj.getPrecoVarejo()));
            txtQtdEstoque.setText(String.valueOf(obj.getQtdEstoque()));
            txtQtdEstoqueAviso.setText(String.valueOf(obj.getQtdEstoqueAviso()));
            
            Fornecedores f = new Fornecedores();
            FornecedoresDao fdao = new FornecedoresDao();
            
            f = fdao.buscarFornecedorUnico(obj.getFornecedor().getNome());
            
            comboBoxFornecedores.getModel().setSelectedItem(f);
            
        }else{
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        }
        
    }//GEN-LAST:event_btnPesquisarCadastroActionPerformed

    private void comboBoxFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFornecedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFornecedoresActionPerformed

    private void comboBoxFornecedoresAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxFornecedoresAncestorAdded
        // Lista os fornecedores cadastrado no banco de dados no Combobox
        FornecedoresDao dao = new FornecedoresDao();
        List<Fornecedores> listaDeFornecedores = dao.listarFornecedor();
        
        //Limpa o combobox
        comboBoxFornecedores.removeAll();
        
        for(Fornecedores f: listaDeFornecedores){
            comboBoxFornecedores.addItem(f);
        }
    }//GEN-LAST:event_comboBoxFornecedoresAncestorAdded

    private void comboBoxFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxFornecedoresMouseClicked
        FornecedoresDao dao = new FornecedoresDao();
        List<Fornecedores> listaDeFornecedores = dao.listarFornecedor();
        comboBoxFornecedores.removeAllItems();
        
        for(Fornecedores f : listaDeFornecedores){
            comboBoxFornecedores.addItem(f);
        }
    }//GEN-LAST:event_comboBoxFornecedoresMouseClicked

    private void txtCodigoDeBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoDeBarrasKeyPressed
        //Evento código de barras da tela de produtos
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
        }
    }//GEN-LAST:event_txtCodigoDeBarrasKeyPressed

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
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisarCadastro;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox comboBoxFornecedores;
    private javax.swing.JComboBox<String> comboBoxUn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTextField txtCodigoDeBarras;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPrecoAtacado;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JTextField txtPrecoVarejo;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtQtdEstoqueAviso;
    // End of variables declaration//GEN-END:variables
}