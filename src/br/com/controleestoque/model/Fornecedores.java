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
public class Fornecedores extends Clientes {
    //Atributos
    private String cnpj;
    
    //Getts e Setts

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
}
