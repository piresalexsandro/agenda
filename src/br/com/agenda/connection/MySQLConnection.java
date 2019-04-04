package br.com.agenda.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Classe de conexão SQL Server.
 * @author Leandro Ferreira
 */
public class MySQLConnection implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Recupera a conexão.
     * @return Connection
     * @throws SQLException Connection
     */
    public Connection getConnection() throws SQLException {
        Connection resultado = null;
        try {
            InitialContext context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
            resultado = ds.getConnection();
        } catch (NamingException exc) {
            throw new RuntimeException(exc);
        }
        return resultado;
    }
    
    /**
     * Fecha o resultset o statement e a conexão.
     * @param paramResultSet {@link ResultSet}
     * @param paramPreparedStatement {@link PreparedStatement}
     * @param paramConnection {@link Connection}
     */
    public void closeConnection(ResultSet paramResultSet,PreparedStatement paramPreparedStatement, 
    		Connection paramConnection) {
        closeResultSet(paramResultSet);
        closeStatement(paramPreparedStatement);
        closeConnection(paramConnection);
    }

    /**
     * Fecha a conexão e o prepared statement.
     * @param paramConnection {@link Connection}
     * @param paramPreparedStatement void {@link PreparedStatement}
     */
    public void closeConnection(Connection paramConnection,
        PreparedStatement paramPreparedStatement) {
        closeStatement(paramPreparedStatement);
        closeConnection(paramConnection);
    }

    private void closeResultSet(ResultSet paramResultSet) {
        if (paramResultSet != null) {
            try {
                paramResultSet.close();
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
        }
    }

    private void closeStatement(PreparedStatement paramPreparedStatement) {
        if (paramPreparedStatement != null) {
            try {
                paramPreparedStatement.close();
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
        }
    }

    private void closeConnection(Connection paramConnection) {
        if (paramConnection != null) {
            try {
                paramConnection.close();
            } catch (SQLException exc) {
                throw new RuntimeException(exc);
            }
        }
    }

    //@Override
    public boolean isAlive() {
        boolean retorno = true;
        Connection con = null;

        try {
            con = getConnection();
            Statement st = con.createStatement();
            st.execute("SELECT 1");
        } catch (Exception ex) {
            retorno = false;
        } finally {
            this.closeConnection(con);
        }
        return retorno;
    }
}
