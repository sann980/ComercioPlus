/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleestoque.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sanderson M. Carvalho
 */
public class PegaTempo {
    
    public String pegaDataHora(){
                Date hoje = new Date();
                SimpleDateFormat dataEUA = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String dataFormatada = dataEUA.format(hoje);
                return dataFormatada;
    }
    
    public String pegaHora(){
                Date hoje = new Date();
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
                String horaFormatada = hora.format(hoje);
                return horaFormatada;
    }
}