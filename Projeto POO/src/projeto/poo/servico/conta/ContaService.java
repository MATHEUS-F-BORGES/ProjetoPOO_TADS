/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.servico.conta;

import javax.swing.JOptionPane;
import projeto.poo.model.contas.Contas;
import projeto.poo.util.dao.conta.DaoConta;

/**
 *
 * @author victo
 */
public class ContaService {

    public static String cadastrarConta(Contas conta) {

        String resposta = null;

        if (resposta == null) {

            try {

                DaoConta dao = new DaoConta();
                dao.inserir(conta);

            } catch (Exception e) {

                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }

        }

        return resposta;
    }

    public static String atualizarProduto(Contas conta) {

        String resposta = null;

        resposta = null;

        if (resposta == null) {

            try {

                DaoConta dao = new DaoConta();
                dao.atualizar(conta);

            } catch (Exception e) {

                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }

        return resposta;

    }

    public static String excluirProduto(Integer numConta) {

        String resposta = null;

        try {

            DaoConta dao = new DaoConta();
            dao.excluir(numConta);

        } catch (Exception e) {

            e.printStackTrace();
            resposta = "Erro na fonte de dados";

        }

        return resposta;
    }

    public static Contas procurarProduto(String valor) {

        Contas conta = null;
        DaoConta dao = new DaoConta();

        try {

            if (valor == null || "".equals(valor)) {
                JOptionPane.showMessageDialog(null,
                        "Favor digitar o número ou nome da conta",
                        "Busca", JOptionPane.INFORMATION_MESSAGE);
            } else {
                conta = dao.procurar(valor);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return conta;
    }

    public static Contas obterProduto(String nome) {

        Contas produtoResposta = null;
        DaoConta dao = new DaoConta();
        try {

            produtoResposta = dao.obter(nome);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return produtoResposta;

    }
}
