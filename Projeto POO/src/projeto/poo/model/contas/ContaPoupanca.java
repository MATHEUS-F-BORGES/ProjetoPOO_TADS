/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.model.contas;

import projeto.poo.model.cliente.Cliente;

/**
 *
 * @author matheus.fboliveira
 * @author victor.gserafim
 */
public class ContaPoupanca extends Contas {

    private float rendimento;

    public ContaPoupanca(Cliente cliente, String nomeCont, int numConta, String tipoConta, float saldo) {
        super(cliente, nomeCont, numConta, tipoConta, saldo);
        this.rendimento = 0.005f;
    }

    public ContaPoupanca() {
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }

    public void aplicarRendimento() {
        this.setSaldo(getSaldo() + (getSaldo() * rendimento));
    }
}
