/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.Fornecedores;
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
public class FornecedoresDao {
    
    //Atributo privado do tipo Connection
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public FornecedoresDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }
    
    //Metodo para cadastrar Fornecedores
    public void cadastrarFornecedor(Fornecedores obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,"
                    + " cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?);";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getCmplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }
    
    //Metodo para alterar fornecedores
    public void alterarFornecedor(Fornecedores obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "update tb_fornecedores set nome=?,cnpj=?,email=?,telefone=?,celular=?,"
                    + "cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getCmplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());

            stmt.setInt(13, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }        
    }
    
    //Metodo para excluir clientes
    public void axcluirFornecedor(Fornecedores obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "delete from tb_fornecedores where id = ?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo para Listar Fornecedores
    public List<Fornecedores> listarFornecedor() {
        try {
            //1 - Criar lista
            List<Fornecedores> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista
            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setCmplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                list.add(obj);
            }
            return list;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    //Metodo buscar Fornecedor
    public List<Fornecedores> buscarFornecedor(String nome) {
        try {
            //1 - Criar lista
            List<Fornecedores> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_fornecedores where nome like ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista
            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setCmplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                list.add(obj);
            }
            return list;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    public Fornecedores buscarFornecedorUnico(String nome){
        try {
            //1 - Criar comando SQL e executar
            String sql = "select * from tb_fornecedores where nome = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Fornecedores obj = new Fornecedores();
            
            if (rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setCmplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            return null;
        }
    }
}
