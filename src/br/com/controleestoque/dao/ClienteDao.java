/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.Clientes;
import br.com.controleestoque.webservice.WebServiceCep;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class ClienteDao {

    //Atributo privado do tipo Connection
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public ClienteDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }

    //Metodo para cadastrar clientes
    public void cadastrarCliente(Clientes obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular,"
                    + " cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getCmplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Metodo para alterar clientes
    public void alterarCliente(Clientes obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?,"
                    + " cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getCmplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());

            stmt.setInt(14, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo para excluir clientes
    public void axcluirCliente(Clientes obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "delete from tb_clientes where id = ?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Listar Clientes
    public List<Clientes> listarClientes() {
        try {
            //1 - Criar lista
            List<Clientes> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista
            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
    
    //Metodo pesquisar cliente por nome
    public Clientes buscarCientePorNome(String nome){
        try {
            //1 - Criar comando SQL e executar
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Clientes obj = new Clientes();
            
            if (rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
    
    //Metodo pesquisar cliente por CPF
    public Clientes buscarCientePorCpf(String cpf){
        try {
            //1 - Criar comando SQL e executar
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            Clientes obj = new Clientes();
            
            if (rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }

    //Metodo buscar cliente
    public List<Clientes> buscarCliente(String nome) {
        try {
            //1 - Criar lista
            List<Clientes> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista
            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
    
    //Metodo busca CEP
    public Clientes buscaCep(String cep) {
        
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
        
        Clientes obj = new Clientes();

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            
            obj.setCidade(webServiceCep.getCidade());
            obj.setEstado(webServiceCep.getUf());
            
            return obj;
            
        } else {
            
            JOptionPane.showMessageDialog(null, "CEP não encontrado!");
            
            return null;
        }
    }
}
