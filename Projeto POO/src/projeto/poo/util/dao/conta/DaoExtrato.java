package projeto.poo.util.dao.conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.poo.model.extrato.Extrato;
import projeto.poo.util.bdconnection.ConnectionUtils;

/**
 *
 * @author victo
 */
public class DaoExtrato {

    public void inserir(Extrato extrato) {
        String sql = "INSERT INTO CONTA (DATA, CONTAORIG, CONTADEST, VALOR, "
                + "IDCLIENTEF, IDCLIENTEJ, IDCONTAO, IDCONTAD) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            SimpleDateFormat form = new SimpleDateFormat("dd/mm/yyyy");
            String datForm = form.format(extrato.getData());
            preparedStatement.setString(1, datForm);
            preparedStatement.setInt(2, extrato.getContaO().getNumConta());
            preparedStatement.setInt(3, extrato.getContaD().getNumConta());
            preparedStatement.setFloat(4, extrato.getValor());
            preparedStatement.setInt(7, extrato.getContaO().getId());
            preparedStatement.setInt(7, extrato.getContaD().getId());

            if (extrato.getCliente().getTipo().equalsIgnoreCase("Cliente Fisico")) {
                preparedStatement.setInt(5, extrato.getCliente().getId());
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setNull(5, Types.INTEGER);
                preparedStatement.setInt(6, extrato.getCliente().getId());
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

    public static List<Extrato> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM EXTRATO";
        List<Extrato> listaExtrato = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaExtrato == null) {
                    listaExtrato = new ArrayList<Extrato>();
                }
                Extrato extrato = new Extrato();

                extrato.setId(result.getInt("id"));
                SimpleDateFormat form = new SimpleDateFormat("dd/mm/yyyy");
                Date data = form.parse(result.getString("data"));
                extrato.setData(data);
                extrato.setValor(result.getFloat("valor"));
                extrato.getContaD().setNumConta(result.getInt("contadest"));
                extrato.getContaO().setNumConta(result.getInt("contaorig"));

                listaExtrato.add(extrato);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaExtrato;
    }
}
