/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.ItemVenda;
import br.com.controleestoque.model.Produtos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class ItemVendaDao {
    //Atributo privado do tipo Connection
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public ItemVendaDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }
    
    //Metodo para cadastrar itens da venda
    public void cadastrarItenVenda(ItemVenda obj){
        try {
            //1 - Criando o comando SQL
            String sql = "insert into tb_itensvendas(venda_id,produto_id,qtd,subtotal,desconto,total) "
                    + "values(?,?,?,?,?,?)";
            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            stmt.setDouble(5, obj.getDesconto());
            stmt.setDouble(6, obj.getTotal());
            
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo para listar intens de uma venda por id
    public List<ItemVenda> listaItemPorVenda(int vendaId) throws SQLException{
        try {
            //1 - Criar Lista
        List<ItemVenda> lista = new ArrayList<>();
        
        //2 - Criar comando SQL, Organizar e Executar
        String sql = "select p.descricao,i.qtd,p.varejo,i.desconto,i.subtotal from tb_itensvendas as i "
                + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);            
            stmt.setInt(1, vendaId);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ItemVenda i = new ItemVenda();
                Produtos p = new Produtos();
                
                p.setDescricao(rs.getString("p.descricao"));
                i.setQtd(rs.getInt("i.qtd"));
                p.setPrecoVarejo(rs.getDouble("p.varejo"));
                i.setDesconto(rs.getDouble("i.desconto"));
                i.setTotal(rs.getDouble("i.subtotal"));
                
                i.setProduto(p);
                
                lista.add(i);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
}
