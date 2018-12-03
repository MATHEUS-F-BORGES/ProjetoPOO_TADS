package projeto.poo.model.extrato;

import java.util.Date;
import projeto.poo.model.cliente.Cliente;
import projeto.poo.model.contas.Contas;

/**
 *
 * @author victo
 */
public class Extrato {

    private int id;
    private Cliente cliente;
    private Contas contaO;
    private Contas contaD;
    private Date data;
    private float valor;

    public Extrato(Cliente cliente, Contas contaO, Contas contaD, Date data, float valor) {
        this.cliente = cliente;
        this.contaO = contaO;
        this.data = data;
        this.valor = valor;
    }

    public Extrato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contas getContaO() {
        return contaO;
    }

    public void setContaO(Contas contaO) {
        this.contaO = contaO;
    }

    public Contas getContaD() {
        return contaD;
    }

    public void setContaD(Contas contaD) {
        this.contaD = contaD;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
