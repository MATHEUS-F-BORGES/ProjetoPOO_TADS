package projeto.poo.util.dao.conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.poo.interfaces.Daos;
import projeto.poo.model.cliente.ClienteFisico;
import projeto.poo.model.cliente.ClienteJuridico;
import projeto.poo.model.contas.ContaCorrente;
import projeto.poo.model.contas.ContaPoupança;
import projeto.poo.model.contas.Contas;
import projeto.poo.util.bdconnection.ConnectionUtils;
import projeto.poo.util.dao.cliente.DaoClienteF;
import projeto.poo.util.dao.cliente.DaoClienteJ;

/**
 *
 * @author victo
 */
public class DaoConta implements Daos<Contas> {

    @Override
    public void inserir(Contas conta) {
        String sql = "INSERT INTO CONTA (NOMECONT, NUMCONTA, TIPOCONTA, SALDO, "
                + "IDCLIENTEF, IDCLIENTEJ) VALUES (?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, conta.getNomeCont());
            preparedStatement.setInt(2, conta.getNumConta());
            preparedStatement.setString(3, conta.getTipoConta());
            preparedStatement.setFloat(4, conta.getSaldo());

            if (conta.getCliente().getTipo().equalsIgnoreCase("Cliente Fisico")) {
                preparedStatement.setInt(5, conta.getCliente().getId());
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setNull(5, Types.INTEGER);
                preparedStatement.setInt(6, conta.getCliente().getId());
            }

            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void atualizar(Contas conta) {

        String sql = "UPDATE Conta SET NOMECONT=?, NUMCONTA=?, TIPOCONTA=?, SALDO=? WHERE (NUMCONTA=?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, conta.getNomeCont());
            preparedStatement.setInt(2, conta.getNumConta());
            preparedStatement.setString(3, conta.getTipoConta());
            preparedStatement.setFloat(4, conta.getSaldo());
            preparedStatement.setInt(5, conta.getNumConta());

            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void excluir(int numConta) {
        String sql = "DELETE FROM Conta WHERE NUMCONTA=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, numConta);

            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    @Override
    public Contas procurar(String valor) {
        String sql = "SELECT * FROM Conta WHERE (UPPER(NOMECONT) LIKE UPPER(?) "
                + "OR UPPER(NUMCONTA) LIKE UPPER(?)) ";
        Contas conta = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionUtils.getConnection();

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, "%" + valor + "%");
            preparedStatement.setString(2, "%" + valor + "%");

            result = preparedStatement.executeQuery();
            DaoClienteJ daoJ = new DaoClienteJ();
            DaoClienteF daoF = new DaoClienteF();
            while (result.next()) {
                conta = new Contas();
                ClienteJuridico clienteJ = daoJ.procurar(result.getInt("IDCLIENTEJ"));
                ClienteFisico clienteF = daoF.procurar(result.getInt("IDCLIENTEF"));
                if (clienteJ != null) {
                    conta.setCliente(clienteJ);
                } else {
                    conta.setCliente(clienteF);
                }

                conta.setNomeCont(result.getString("NOMECONT"));
                conta.setNumConta(result.getInt("NUMCONTA"));
                conta.setTipoConta(result.getString("TIPOCONTA"));
                conta.setSaldo(result.getFloat("SALDO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conta;
    }

    @Override
    public ContaCorrente obter(String valor) {
        String sql = "SELECT * FROM Conta WHERE (NUMCONTA=?)";

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            conn = ConnectionUtils.getConnection();

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, valor);

            result = preparedStatement.executeQuery();

            DaoClienteJ daoJ = new DaoClienteJ();
            DaoClienteF daoF = new DaoClienteF();
            if (result.next()) {
                ContaCorrente conta = null;
                ClienteJuridico clienteJ = daoJ.procurar(result.getInt("IDCLIENTEJ"));
                ClienteFisico clienteF = daoF.procurar(result.getInt("IDCLIENTEF"));
                if (clienteJ != null) {
                    String nome = result.getString("NOMECONT");
                    int num = result.getInt("NUMCONTA");
                    String tipo = result.getString("TIPOCONTA");
                    float saldo = result.getFloat("SALDO");
                    conta = new ContaCorrente(clienteJ, nome, num, tipo, saldo);
                } else {
                    String nome = result.getString("NOMECONT");
                    int num = result.getInt("NUMCONTA");
                    String tipo = result.getString("TIPOCONTA");
                    float saldo = result.getFloat("SALDO");
                    conta = new ContaCorrente(clienteF, nome, num, tipo, saldo);
                }
                return conta;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public ContaPoupança obter(String valor, int id) {
        String sql = "SELECT * FROM Conta WHERE (NUMCONTA=?)";

        Connection conn = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            conn = ConnectionUtils.getConnection();

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, valor);

            result = preparedStatement.executeQuery();

            DaoClienteJ daoJ = new DaoClienteJ();
            DaoClienteF daoF = new DaoClienteF();
            if (result.next()) {
                ContaPoupança conta = null;
                ClienteJuridico clienteJ = daoJ.procurar(result.getInt("IDCLIENTEJ"));
                ClienteFisico clienteF = daoF.procurar(result.getInt("IDCLIENTEF"));
                if (clienteJ != null) {
                    String nome = result.getString("NOMECONT");
                    int num = result.getInt("NUMCONTA");
                    String tipo = result.getString("TIPOCONTA");
                    float saldo = result.getFloat("SALDO");
                    conta = new ContaPoupança(clienteJ, nome, num, tipo, saldo);
                } else {
                    String nome = result.getString("NOMECONT");
                    int num = result.getInt("NUMCONTA");
                    String tipo = result.getString("TIPOCONTA");
                    float saldo = result.getFloat("SALDO");
                    conta = new ContaPoupança(clienteF, nome, num, tipo, saldo);
                }
                return conta;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
