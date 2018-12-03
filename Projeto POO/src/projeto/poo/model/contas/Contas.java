/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.model.contas;

import projeto.poo.model.cliente.Cliente;
import projeto.poo.util.dao.conta.DaoConta;

/**
 *
 * @author matheus.fboliveira
 * @author victor.gserafim
 */
public class Contas {

    private int id;
    private Cliente cliente;
    private String nomeCont;
    private int numConta;
    private String tipoConta;
    float saldo;

    public Contas(Cliente cliente, String nomeCont, int numConta, String tipoConta, float saldo) {
        this.cliente = cliente;
        this.nomeCont = nomeCont;
        this.numConta = numConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public Contas() {
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomeCont() {
        return nomeCont;
    }

    public void setNomeCont(String nomeCont) {
        this.nomeCont = nomeCont;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void abrirConta() {
    }

    public void fecharConta(Contas conta) {
        DaoConta dao = new DaoConta();
        dao.excluir(conta.getNumConta());
    }

    public void altTipoConta(Contas conta, String tipo) {
        conta.setTipoConta(tipo);
    }

    public void fazerTrasferencia(Contas contaO, Contas contaD, float valor) {
        contaO.sacar(contaO, valor);
        contaD.depositar(contaD, valor);
        DaoConta dao = new DaoConta();
        dao.atualizar(contaO);
        dao.atualizar(contaD);
    }

    public void depositar(Contas conta, float valor) {
        conta.setSaldo(conta.getSaldo() + valor);
        DaoConta dao = new DaoConta();
        dao.atualizar(conta);
    }

    public void sacar(Contas conta, float valor) {
        conta.setSaldo(conta.getSaldo() - valor);
        DaoConta dao = new DaoConta();
        dao.atualizar(conta);
    }
}
