/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.Fornecedores;
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
public class ProdutosDao {
    //Atributo privado do tipo Connection
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public ProdutosDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrar produtos
    public void cadastrar(Produtos obj){
        try {
           //1 - Criando o comando SQL
            String sql = "insert into tb_produtos(cod_barras,descricao,un,custo,"
                    + "varejo,qtd_estoque,est_aviso,for_id) values(?,?,?,?,?,?,?,?);";
            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getCodBarras());
            stmt.setString(2, obj.getDescricao());
            stmt.setString(3, obj.getUn());
            stmt.setDouble(4, obj.getPrecoCusto());
            stmt.setDouble(5, obj.getPrecoVarejo());
            stmt.setInt(6, obj.getQtdEstoque());
            stmt.setInt(7, obj.getQtdEstoqueAviso());
            
            stmt.setInt(8, obj.getFornecedor().getId());
            
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo alrerar produto
    public void alterarProduto(Produtos obj){
        try {
           //1 - Criando o comando SQL
            String sql = "update tb_produtos set cod_barras=?,descricao=?,un=?,custo=?,"
                    +"varejo=?,qtd_estoque=?,est_aviso=?,for_id=? where id=?";
            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setString(1, obj.getCodBarras());
            stmt.setString(2, obj.getDescricao());
            stmt.setString(3, obj.getUn());
            stmt.setDouble(4, obj.getPrecoCusto());
            stmt.setDouble(5, obj.getPrecoVarejo());
            stmt.setInt(6, obj.getQtdEstoque());
            stmt.setInt(7, obj.getQtdEstoqueAviso());
            
            stmt.setInt(8, obj.getFornecedor().getId());
            
            stmt.setInt(9, obj.getId());
            
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro aqui!: " + erro);
        }
    }
    
    //Metodo excluir produto
    public void excluirProduto(Produtos obj){
        try {
           //1 - Criando o comando SQL
            String sql = "delete from tb_produtos where id=?";
            
            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo listar produtos
    public List<Produtos> listarProdutos() throws SQLException{
        try {
            //1 - Criar Lista
        List<Produtos> lista = new ArrayList<>();
        
        //2 - Criar comando SQL, Organizar e Executar
        String sql = "select p.id,p.cod_barras,p.descricao,p.un,p.custo,"
                + "p.varejo,p.qtd_estoque,p.est_aviso,f.nome from tb_produtos as p "
                + "inner join tb_fornecedores as f on (p.for_id = f.id)";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setCodBarras(rs.getString("p.cod_barras"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setUn(rs.getString("p.un"));
                obj.setPrecoCusto(rs.getDouble("p.custo"));
                obj.setPrecoVarejo(rs.getDouble("p.varejo"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setQtdEstoqueAviso(rs.getInt("p.est_aviso"));
                
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    //Metodo listar produtos por nome
    public List<Produtos> listarProdutosPorNome(String nome) throws SQLException{
        try {
            //1 - Criar Lista
        List<Produtos> lista = new ArrayList<>();
        
        //2 - Criar comando SQL, Organizar e Executar
        String sql = "select p.id,p.cod_barras,p.descricao,p.un,p.custo,"
            + "p.varejo,p.qtd_estoque,p.est_aviso,f.nome from tb_produtos as p "
            + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setCodBarras(rs.getString("p.cod_barras"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setUn(rs.getString("p.un"));
                obj.setPrecoCusto(rs.getDouble("p.custo"));
                obj.setPrecoVarejo(rs.getDouble("p.varejo"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setQtdEstoqueAviso(rs.getInt("p.est_aviso"));                
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    //Metodo buscar produto por nome
    public Produtos buscarProdutoPorNome(String nome){
        try {
            //1 - Criar comando SQL
        String sql = "select p.id,p.cod_barras,p.descricao,p.un,p.custo,"
            + "p.varejo,p.qtd_estoque,est_aviso,f.nome from tb_produtos as p "
            + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("p.id"));
                obj.setCodBarras(rs.getString("p.cod_barras"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setUn(rs.getString("p.un"));
                obj.setPrecoCusto(rs.getDouble("p.custo"));
                obj.setPrecoVarejo(rs.getDouble("p.varejo"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setQtdEstoqueAviso(rs.getInt("p.est_aviso"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
            }
            
            return obj;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
    }
    
    //Metodo buscar produto por ID
    public Produtos buscarProdutoPorId(int id){
        try {
            //1 - Criar comando SQL
        String sql = "select * from tb_produtos where id = ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setCodBarras("cod_barras");
                obj.setDescricao(rs.getString("descricao"));
                obj.setUn("un");
                obj.setPrecoCusto(rs.getDouble("custo"));
                obj.setPrecoVarejo(rs.getDouble("varejo"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                obj.setQtdEstoque(rs.getInt("est_aviso"));
                
            }
            
            return obj;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
    }
    
    //Metodo buscar produto por Código de Barras
    public Produtos buscarProdutoPorCodBarras(String codBarras){
        try {
            //1 - Criar comando SQL
        String sql = "select p.id,p.cod_barras,p.descricao,p.un,p.custo,"
            + "p.varejo,p.qtd_estoque,p.est_aviso,f.nome from tb_produtos as p "
            + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.cod_barras = ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, codBarras);
            
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("p.id"));
                obj.setCodBarras(rs.getString("p.cod_barras"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setUn(rs.getString("p.un"));
                obj.setPrecoCusto(rs.getDouble("p.custo"));
                obj.setPrecoVarejo(rs.getDouble("p.varejo"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setQtdEstoqueAviso(rs.getInt("p.est_aviso"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
            }
            
            return obj;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
    }
    
    //Metodo para retornar a quantidade atual de um produto em estoque
    public int retornaEstoqueAtual(int id){
        try {
            int qtdEstoque = 0;
            
            //1 - Criando o comando SQL
            String sql = "SELECT qtd_estoque from tb_produtos where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);  
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                qtdEstoque = (rs.getInt("qtd_estoque"));
            }
            
            return qtdEstoque;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    //Metodo para dar baixa no estoque
    public void baixaEstoque(int id, int qtdNova){
        try {
            //1 - Criando o comando SQL
            String sql = "update tb_produtos set qtd_estoque=? where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, id);
                
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo para adicionar produtos ao estoque
    public void adicionarEstoque(int id, int qtdNova){
        try {
            //1 - Criando o comando SQL
            String sql = "update tb_produtos set qtd_estoque=? where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, qtdNova);
            stmt.setInt(2, id);

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
}
