/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.model;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class Vendas {
    //Atributos
    private int id;
    private Clientes cliente;
    private String dataVenda;
    private double totalVendaSemDesconto;
    private double totalDesconto;
    private double totalVendaComDesconto;
    private String obs;
    
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotalVendaSemDesconto() {
        return totalVendaSemDesconto;
    }

    public void setTotalVendaSemDesconto(double totalVenda) {
        this.totalVendaSemDesconto = totalVenda;
    }

    public double getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(double totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public double getTotalVendaComDesconto() {
        return totalVendaComDesconto;
    }

    public void setTotalVendaComDesconto(double totalVendaComDesconto) {
        this.totalVendaComDesconto = totalVendaComDesconto;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
