/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.servico.cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class Servico {
    
    
    
    public static Date convesorData (String data) throws ParseException{
    
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = format.parse(data);
            
        return dataFormatada; 
    }
    
    public static String convesorDataString (Date data) {
    
        String resultado = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        resultado = formato.format(data);
        
            
        return resultado; 
    }
    public static void cadSucesso(){
    
        
        JOptionPane.showMessageDialog(null,
                "Cliente Cadastrado",
                "Cadastro de Cliente",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public static void ClienteNaoCad (){
    
        
        JOptionPane.showMessageDialog(null,
                "Não foi possivel efetuar o cadastro, "
                        + "Entre em contato com o administrador do sistema",
                "Cadastro de Cliente",
                JOptionPane.INFORMATION_MESSAGE);
    }
  
}
