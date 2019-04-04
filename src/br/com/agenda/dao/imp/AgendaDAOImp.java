package br.com.agenda.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.connection.MySQLConnection;
import br.com.agenda.dao.IAgendaDAO;
import br.com.agenda.model.Agenda;

public class AgendaDAOImp extends MySQLConnection implements IAgendaDAO {

	private static final long serialVersionUID = 1L;
	
	private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
	public AgendaDAOImp() {
	}
			
	@Override
	public void insert(Agenda obj) {
		
		try {
			conn = getConnection();
			StringBuilder query = new StringBuilder();
			
    		query.append("INSERT INTO AGENDA (NOME, EMAIL, TELEFONE, LOGRADOURO, numero_residencia, BAIRRO, CIDADE, ESTADO, UF, CEP) "); 	
			query.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
			
			ps = conn.prepareStatement(query.toString());
			
			ps.setString(1, obj.getNome()); //NOME
			ps.setString(2, obj.getEmail()); //EMAIL
			ps.setLong(3, obj.getTelefone()); //TELEFONE
			ps.setString(4, obj.getLogradouro()); //LOGRADOURO
			ps.setInt(5, obj.getNumeroResidencia()); //NUMERO
			ps.setString(6, obj.getBairro()); //BAIRRO
			ps.setString(7, obj.getCidade()); //CIDADE
			ps.setString(8, obj.getEstado()); //ESTADO
			ps.setString(9, obj.getUf()); //UF
			ps.setLong(10, obj.getCep()); //CEP
		
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Agenda obj) {
		
		try {
			conn = getConnection();
			StringBuilder query = new StringBuilder();
			query.append("UPDATE Agenda SET "); 
			query.append(",NOME = ? ");
			query.append(",EMAIL = ? ");
			query.append(",TELEFONE = ? ");
			query.append(",DATA = ? ");
			query.append(",LOGRADOURO = ? ");
			query.append(",BAIRRO = ? ");
			query.append(",CIDADE = ? ");
			query.append(",ESTADO = ? ");
			query.append(",UF = ? ");
			query.append(",CEP = ? ");
			
			ps.setString(1, obj.getNome()); //NOME
			ps.setString(2, obj.getEmail()); //EMAIL
			ps.setLong(3, obj.getTelefone()); //TELEFONE
			ps.setInt(4, obj.getNumeroResidencia()); //NUMERO
			ps.setString(5, obj.getLogradouro()); //LOGRADOURO
			ps.setString(6, obj.getBairro()); //BAIRRO
			ps.setString(7, obj.getCidade()); //CIDADE
			ps.setString(8, obj.getEstado()); //ESTADO
			ps.setString(9, obj.getUf()); //UF
			ps.setLong(10, obj.getCep()); //CEP
			
			ps.executeUpdate();
			
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		} finally {
			closeConnection(rs,ps,conn);
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			conn = getConnection();
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM AGENDA WHERE ID = ?");
			
			ps.setLong(1, id);
			ps.executeQuery();
			
		}catch (SQLException exc) {
			throw new RuntimeException(exc);
		} finally {
			closeConnection(rs,ps,conn);
		}
	}

	@Override
	public Agenda findById(Long id) {
		
		try {
			conn = getConnection();
			StringBuilder query = new StringBuilder();
			query.append("SELECT ESTUDOS.* FROM AGENDA "); 
			query.append("WHERE ID = ? ");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			//next pq a posição 0 e nula entao pegarmos a proximas
			if (rs.next()) {
				Agenda resultado = new Agenda();
				resultado.setId(rs.getLong("ID"));
				resultado.setNome(rs.getString("NOME"));
				resultado.setEmail(rs.getString("EMAIL"));
				resultado.setId(rs.getLong("TELEFONE"));
				resultado.setDataCadastro(rs.getDate("DATA"));
				resultado.setLogradouro(rs.getString("LOGRADOURO"));
				resultado.setNumeroResidencia(rs.getInt("NUMERO"));
				resultado.setBairro(rs.getString("BAIRRO"));
				resultado.setCidade(rs.getString("CIDADE"));
				resultado.setCidade(rs.getString("ESTADO"));
				resultado.setUf(rs.getString("UF"));
				resultado.setCep(rs.getLong("CEP"));

				return resultado;
			}
			return null;
		}catch (SQLException exc) {
			throw new RuntimeException(exc);
		} finally {
			closeConnection(rs,ps,conn);
		}
	}

	@Override
	public List<Agenda> findAll() {
		try {
			conn = getConnection();
			StringBuilder query = new StringBuilder();
			query.append("SELECT ESTUDOS.* FROM AGENDA "); 
			rs = ps.executeQuery();
			
			//next pq a posição 0 e nula entao pegarmos a proximas
			while (rs.next()) {
				List<Agenda> listaFunc = new ArrayList<>();
				Agenda resultado = new Agenda();
				resultado.setId(rs.getLong("ID"));
				resultado.setNome(rs.getString("NOME"));
				resultado.setEmail(rs.getString("EMAIL"));
				resultado.setId(rs.getLong("TELEFONE"));
				resultado.setDataCadastro(rs.getDate("DATA"));
				resultado.setLogradouro(rs.getString("LOGRADOURO"));
				resultado.setNumeroResidencia(rs.getInt("NUMERO"));
				resultado.setBairro(rs.getString("BAIRRO"));
				resultado.setCidade(rs.getString("CIDADE"));
				resultado.setCidade(rs.getString("ESTADO"));
				resultado.setUf(rs.getString("UF"));
				resultado.setCep(rs.getLong("CEP"));
				listaFunc.add(resultado);
				return listaFunc;
			}
			return null;
		}catch (SQLException exc) {
			throw new RuntimeException(exc);
		}finally {
			closeConnection(rs,ps,conn);
		}
	}	
}