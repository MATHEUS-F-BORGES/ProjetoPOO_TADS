package projeto.poo.model.cliente;



/**
 *
 * @author matheus.fboliveira
 * @author victor.gserafim
 */
public class ClienteJuridico extends Cliente {

    private String cnpj;

    public ClienteJuridico(String cnpj, String nome, String tipo,String logradouro, int numero, String bairro, String cidade, String estado, String telefone, String email) {
        super(nome, tipo, logradouro, numero, bairro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }


    

    public ClienteJuridico() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
