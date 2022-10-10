/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.Funcionarios;
import br.com.controleestoque.timer.PegaTempo;
import br.com.controleestoque.view.FrmMenu;
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
public class FuncionariosDao {
    
    //Conexão
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public FuncionariosDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }
    
    //Metodo para cadastrar clientes
    public void cadastrarFuncionarios(Funcionarios obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,"
                    +"cargo,nivel_acesso,telefone,celular,cep,endereco,numero,"
                    +"complemento, bairro, cidade, estado)"
                    +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getCmplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }
    
    //Metodo alterar funcionários
    public void alterarFuncionarios(Funcionarios obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,"
                    + "senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,"
                    + " cep=?,endereco=?,numero=?,complemento=?,bairro=?, "
                    + " cidade=?,estado=? where id=?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getCmplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());

            stmt.setInt(17, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo excluir funcionários
    public void axcluirFuncionario(Funcionarios obj) {
        try {
            //1 - Criando o comando SQL
            String sql = "delete from tb_funcionarios where id = ?";

            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Metodo Listar TODOS OS FUNCIONÁRIOS
    public List<Funcionarios> listarFuncionarios() {
        try {
            //1 - Criar lista
            List<Funcionarios> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            //Objeto que recebe a execução de select
            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista (Enquanto o result set consegue percorrer todo o array
            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
    
    //Metodo pesquisar Funcionario Unico
    public Funcionarios buscarFuncionarioUnico(String nome){
        try {
            //1 - Criar comando SQL e executar
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Funcionarios obj = new Funcionarios();
            
            if (rs.next()) {
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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

    //Metodo buscar Funcionário
    public List<Funcionarios> buscarFuncionario(String nome) {
        try {
            //1 - Criar lista
            List<Funcionarios> list = new ArrayList<>();

            //2 - Criar comando SQL e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            //Adiciona a lista
            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
    
    //Metodo para efetuar login
    public int fazerLogin(String email, String senha){
        try {
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                //Usuário encontrado
                PegaTempo data = new PegaTempo();
                
                //Se o usuário for do tipo Administrador
                if(rs.getString("nivel_acesso").equals("ADMINISTRADOR")){
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome");
                    //tela.data = data.pegaDataHora();
                    tela.setVisible(true);
                
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema!");
                    return 1;
                }
                //Se o usuário tiver acesso limitado
                else if(rs.getString("nivel_acesso").equals("USUÁRIO")){
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome");
                    //tela.data = data.pegaDataHora();
                    
                    //Desabilita as restrições
                    tela.menuPosicaoDia.setEnabled(false);
                    tela.menuControleVenda.setEnabled(false);
                    
                    tela.setVisible(true);
                
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sitema!");
                    return 1;
                }
            }
            else{
                //Dados não encontrado ou incorretos/incompativeis
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!");
                return 0;
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return 0;
        }
        return 0;
    }
}
