/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.util.dao.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.poo.interfaces.Daos;
import projeto.poo.model.cliente.ClienteJuridico;
import projeto.poo.servico.cliente.Servico;
import projeto.poo.util.bdconnection.ConnectionUtils;

/**
 *
 * @author victo
 */
public class DaoClienteJ implements Daos<ClienteJuridico> {

    @Override
    public void inserir(ClienteJuridico cliente) {
        String sql = "INSERT INTO CLIENTEJURIDICO (NOMEFANT, TIPOCLI, CNPJ, LOGRADOURO, "
                + "NUMERO, BAIRRO, CIDADE, ESTADO, TELEFONE, EMAIL ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, "Pessoa Juridica");
            preparedStatement.setString(3, cliente.getCnpj());
            preparedStatement.setString(4, cliente.getLogradouro());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getBairro());
            preparedStatement.setString(7, cliente.getCidade());
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getTelefone());
            preparedStatement.setString(10, cliente.getEmail());
            
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
    public ClienteJuridico procurar(String valor) {
        String sql = "SELECT * FROM ClienteJuridico WHERE UPPER(NOMEFANT) LIKE UPPER(?) ";
        ClienteJuridico cliente = null;
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
                    cliente = new ClienteJuridico();
                }
                cliente.setId(result.getInt("ID"));
                cliente.setNome(result.getString("NOMEFANT"));
                cliente.setTipo(result.getString("TIPOCLI"));
                cliente.setCnpj(result.getString("CNPJ"));
                cliente.setLogradouro(result.getString("LOGRADOURO"));
                cliente.setNumero(result.getInt("NUMERO"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setEstado(result.getString("ESTADO"));
                cliente.setTelefone(result.getString("TELEFONE"));
                cliente.setEmail(result.getString("EMAIL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteJ.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DaoClienteJ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }


    public ClienteJuridico procurar(int id) {
        String sql = "SELECT * FROM ClienteJuridico WHERE UPPER(ID) LIKE UPPER(?) ";
        ClienteJuridico cliente = null;
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
                    cliente = new ClienteJuridico();
                }
                cliente.setId(result.getInt("ID"));
                cliente.setNome(result.getString("NOMEFANT"));
                cliente.setTipo(result.getString("TIPOCLI"));
                cliente.setCnpj(result.getString("CNPJ"));
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
    public void atualizar(ClienteJuridico cliente) {
      
      

        String sql = "UPDATE ClienteFisico SET NOMEFANT=?, TIPOCLI=?, CNPJ=?,"
                + ", LOGRADOURO=?, NUMERO=?, BAIRRO=?, CIDADE=?"
                + ", ESTADO=?, TELEFONE=?, EMAIL=? WHERE (ID=?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTipo());
            preparedStatement.setString(3, cliente.getCnpj());
            preparedStatement.setString(4, cliente.getLogradouro());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getBairro());
            preparedStatement.setString(7, cliente.getCidade());
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getTelefone());
            preparedStatement.setString(10, cliente.getEmail());            
            preparedStatement.setInt(11, cliente.getId());

            preparedStatement.execute();
            Servico.AltSucesso();
        } catch (SQLException ex) {
            Logger.getLogger(DaoClienteJ.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoClienteJ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteJuridico obter(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
