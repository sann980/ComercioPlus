/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.dao;

import br.com.controleestoque.jdbc.ConnectionFactory;
import br.com.controleestoque.model.Clientes;
import br.com.controleestoque.model.Vendas;
import br.com.controleestoque.view.FrmVendas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class VendasDao {
     //Atributo privado do tipo Connection
    private Connection con;

    //Metodo construtor para abrir conexão com o banco de dados
    public VendasDao() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }
    
    //Registrar venda
    public void registrarVenda(Vendas obj){
        try {
            //1 - Criando o comando SQL
            String sql = "insert into tb_vendas(cliente_id,data_venda,"
                    + "total_sem_desconto,valor_desconto,total_com_desconto,observacoes)"
                    + " values(?,?,?,?,?,?)";
            //2 - Conectar ao banco de dados e organiza os comandos SQL
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble(3, obj.getTotalVendaSemDesconto());
            stmt.setDouble(4, obj.getTotalDesconto());
            stmt.setDouble(5, obj.getTotalVendaComDesconto());
            stmt.setString(6, obj.getObs());
            
            //3 - Execuntando o camando SQL
            stmt.execute();
            stmt.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    //Retorna ultima venda
    public int retornaUltimaVenda(){
        try {
            int idVenda = 0;
            
            //Comando SQL que retorna o maior id
            String sql = "select max(id) id from tb_vendas";
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                Vendas p = new Vendas();
                
                p.setId(rs.getInt("id"));
                idVenda = p.getId();
            }
            
            return idVenda;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    //Metodo para filtrar vendas por periodo
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim) throws SQLException{
        try {
            //1 - Criar Lista
        List<Vendas> lista = new ArrayList<>();
        
        //2 - Criar comando SQL, Organizar e Executar
        String sql = "select v.id,date_format(v.data_venda,'%d/%m/%y') as data_formatada,c.nome,"
                + "v.total_sem_desconto,v.valor_desconto,v.total_com_desconto,v.observacoes from tb_vendas as v "
                + " inner join tb_clientes as c on(v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";
        
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);            
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Vendas obj = new Vendas();
                Clientes c = new Clientes();
                
                obj.setId(rs.getInt("v.id"));
                obj.setDataVenda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotalVendaSemDesconto(rs.getDouble("v.total_sem_desconto"));
                obj.setTotalDesconto(rs.getDouble("v.valor_desconto"));
                obj.setTotalVendaComDesconto(rs.getDouble("v.total_com_desconto"));
                obj.setObs(rs.getString("v.observacoes"));
                
                obj.setCliente(c);
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    //Retorna totalComDesconto de vendas por data
    public double retornaTotalVenda(LocalDate dataVenda){
        try {
            double totalVenda = 0;
            
            String sql = "select sum(total_com_desconto) as total from tb_vendas where data_venda=?";
            
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, dataVenda.toString());
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                totalVenda = rs.getDouble("total");
            }
            
            return totalVenda;
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void limparPdv(FrmVendas telaVendas, DefaultTableModel car){
        telaVendas.txtCpf.setText("");
        telaVendas.txtNomeCliente.setText("");
        car.setNumRows(0);
        telaVendas.txtQtdProduto.setText("1");
        telaVendas.totalComDesconto = 0;
        telaVendas.txtTotalGeral.setText("R$ 0,00");
        telaVendas.txtTotalDesconto.setText("R$ 0,00");
    }
}
