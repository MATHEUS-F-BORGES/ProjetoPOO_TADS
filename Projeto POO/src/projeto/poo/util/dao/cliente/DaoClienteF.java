package projeto.poo.util.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.poo.interfaces.Daos;
import projeto.poo.model.cliente.ClienteFisico;
import projeto.poo.servico.cliente.Servico;
import projeto.poo.util.bdconnection.ConnectionUtils;

/**
 *
 * @author victo
 */
public class DaoClienteF implements Daos<ClienteFisico> {

    @Override
    public void inserir(ClienteFisico cliente) {
        
          String sql = "INSERT INTO CLIENTEFISICO (NOME, TIPOCLI, CPF, DATNASC, LOGRADOURO, "
                + "NUMERO, BAIRRO, CIDADE, ESTADO, TELEFONE, EMAIL ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, "Pessoa Fisica");
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, Servico.convesorDataString(cliente.getData()));
            preparedStatement.setString(5, cliente.getLogradouro());
            preparedStatement.setInt(6, cliente.getNumero());
            preparedStatement.setString(7, cliente.getBairro());
            preparedStatement.setString(8, cliente.getCidade());
            preparedStatement.setString(9, cliente.getEstado());
            preparedStatement.setString(10, cliente.getTelefone());
            preparedStatement.setString(11, cliente.getEmail());
            
            preparedStatement.execute();
            
            Servico.cadSucesso();
        } catch (SQLException ex) {
          Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
           Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ClienteFisico procurar(String valor) {
        String sql = "SELECT * FROM ClienteFisico WHERE UPPER(NOME) LIKE UPPER(?) ";
        ClienteFisico cliente = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + valor + "%");

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (cliente == null) {
                    cliente = new ClienteFisico();
                }
                cliente.setId(result.getInt("ID"));
                cliente.setNome(result.getString("NOME"));
                cliente.setTipo(result.getString("TIPOCLI"));
                cliente.setCpf(result.getString("CPF"));
                SimpleDateFormat form = new SimpleDateFormat("dd/mm/yyyy");
                Date data = form.parse(result.getString("DATNASC"));
                cliente.setData(data);
                cliente.setLogradouro(result.getString("LOGRADOURO"));
                cliente.setNumero(result.getInt("NUMERO"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setEstado(result.getString("ESTADO"));
                cliente.setTelefone(result.getString("TELEFONE"));
                cliente.setEmail(result.getString("EMAIL"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }



    public static ClienteFisico procurar(int id) {
        String sql = "SELECT * FROM ClienteFisico WHERE UPPER(ID) LIKE UPPER(?) ";
        ClienteFisico cliente = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (cliente == null) {
                    cliente = new ClienteFisico();
                }
                cliente.setId(result.getInt("ID"));
                cliente.setNome(result.getString("NOME"));
                cliente.setTipo(result.getString("TIPOCLI"));
                cliente.setCpf(result.getString("CPF"));
                SimpleDateFormat form = new SimpleDateFormat("dd/mm/yyyy");
                Date data = form.parse(result.getString("DATNASC"));
                cliente.setData(data);
                cliente.setLogradouro(result.getString("LOGRADOURO"));
                cliente.setNumero(result.getInt("NUMERO"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setEstado(result.getString("ESTADO"));
                cliente.setTelefone(result.getString("TELEFONE"));
                cliente.setEmail(result.getString("EMAIL"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (result != null && !result.isClosed()) {
                    result.close();
                }
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoClienteF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    
    
    @Override
    public void atualizar(ClienteFisico objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public ClienteFisico obter(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
   
}
