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
public class Produtos {
    
    //Atributos
    private int id;
    private String codBarras;
    private String descricao;
    private String un;
    private double precoCusto;
    private double precoVarejo;
    private int qtdEstoque;
    private int qtdEstoqueAviso;
   
    
    private Fornecedores Fornecedor;
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVarejo() {
        return precoVarejo;
    }

    public void setPrecoVarejo(double precoVarejo) {
        this.precoVarejo = precoVarejo;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdEstoqueAviso() {
        return qtdEstoqueAviso;
    }

    public void setQtdEstoqueAviso(int qtdEstoqueAviso) {
        this.qtdEstoqueAviso = qtdEstoqueAviso;
    }    

    public Fornecedores getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(Fornecedores Fornecedor) {
        this.Fornecedor = Fornecedor;
    }
    
}
