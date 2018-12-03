
package projeto.poo.model.contas;

import projeto.poo.model.cliente.Cliente;

/**
 *
 * @author matheus.fboliveira
 * @author victor.gserafim
 */
public class ContaCorrente extends Contas{
    
    private float taxaAdm;

    public ContaCorrente(Cliente cliente, String nomeCont, int numConta, String tipoConta, float saldo) {
        super(cliente, nomeCont, numConta, tipoConta, saldo);
        this.taxaAdm = 1.30f;
    }
    
    public float getTaxaAdm() {
        return taxaAdm;
    }

    public void setTaxaAdm(float taxaAdm) {
        this.taxaAdm = taxaAdm;
    }
   
    public void aplicartaxa(){
        this.saldo -= taxaAdm;
    }
}
