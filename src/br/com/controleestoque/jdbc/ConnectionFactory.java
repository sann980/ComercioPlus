/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class ConnectionFactory {

    public Connection getConnection() {
        //Tratamento de erro
        try {
            //String de conexão
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas",
                    "ADMINISTRADOR", "123");

        } catch (SQLException erro) {

            throw new RuntimeException(erro);
        }
    }
}
