/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.model.cliente;

import java.util.Date;

/**
 *
 * @author matheus.fboliveira
 * @author victor.gserafim
 */
public class ClienteFisico extends Cliente{

   
    
    private String cpf;
  

    public ClienteFisico(String cpf, String nome, String tipo, Date data,
            String logradouro, int numero, String bairro, String cidade, 
            String estado, String telefone, String email) {
        super(nome, tipo, data, logradouro, numero, bairro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    

    public ClienteFisico() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
