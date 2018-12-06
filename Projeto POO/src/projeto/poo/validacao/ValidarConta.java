/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.validacao;

import projeto.poo.model.contas.Contas;

/**
 *
 * @author victo
 */
public class ValidarConta {

    public static String validar(Contas conta) {

        if (conta == null) {
            return "Não foi informado uma conta";
        }
        if (conta.getNomeCont() == null || "".equals(conta.getNomeCont())) {
            return "É necessário informar o nome da conta";
        }

        if (conta.getNumConta() == 0 || "".equals(conta.getNumConta())) {
            return "Número da conta não gerado";
        }
        if (conta.getTipoConta() == null || "".equals(conta.getTipoConta())) {
            return "É necessário informar o tipo da conta";
        }
        if (conta.getSaldo() != 0) {
            return "Saldo atual é inválido para abertura de conta";
        }
        return null;
    }
}
