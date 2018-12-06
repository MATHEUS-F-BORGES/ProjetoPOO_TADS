/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.model.contas;

import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class ContaMessage {

    public static void errorTransf() {
        JOptionPane.showMessageDialog(null,
                "Conta não encontrada, tente novamente!",
                "Transferência entre contas",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void cancelTransf() {
        JOptionPane.showMessageDialog(null,
                "Trasnferência cancelada!",
                "Trasnferência entre contas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void valTransf() {
        JOptionPane.showMessageDialog(null,
                "Valor inválido!",
                "Transferência entre contas",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void bemVindo() {
        JOptionPane.showMessageDialog(null,
                "Bem-Vindo, preencha as informações \npara a abertura de conta",
                "Preenchimento de campo incorreto",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void infoCorrente() {
        JOptionPane.showMessageDialog(null, "Antes de realizar a abertura da sua conta corrente,\ndeve estar ciente que há a cobrança da "
                + "taxa de manutenção \nno valor de R$1,30 a cada utilização!",
                "Informação Conta Corrente", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void infoPoup() {
        JOptionPane.showMessageDialog(null, "Antes de realizar a abertura da sua conta poupança \ndeve estar ciente que sua rentabilidade é de "
                + "\n0,06% p.u (Por Utilização)",
                "Informação Conta Poupança", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void contAberta() {
        JOptionPane.showMessageDialog(null,
                "Conta aberta!",
                "Abertura de conta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void contAtualizada() {
        JOptionPane.showMessageDialog(null,
                "Conta Atualizada!",
                "Abertura de conta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void termos() {
        JOptionPane.showMessageDialog(null,
                "É preciso aceitar os termos!",
                "Termo de ciência",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
