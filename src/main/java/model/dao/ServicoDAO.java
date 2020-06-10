package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Servico; 
public class ServicoDAO {

	public Servico cadastrar(Servico novoServico) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO SERVICO(NOME, TIPO, DATASERVICO, NECESSITACONSULTA, PRECO) VALUES  " + "(?,?, ?,?,?)";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt.setString(1, novoServico.getNome());
			stmt.setBoolean(2, novoServico.isNecessitaConsulta());
			stmt.setDouble(3, novoServico.getPreco());

			stmt.execute();

			ResultSet generatedKeyes = stmt.getGeneratedKeys();
			if (generatedKeyes.next()) {
				int idGerado = generatedKeyes.getInt(1);
				novoServico.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo serviço");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoServico;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM SERVICO WHERE IDSERVICO = " + id;
		Statement stmt = Banco.getStatement(conn);
		int quantidadeLinhasAfetadas = 0;
		ResultSet rs = null;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir servico.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean Alterar(Servico servico) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE SERVICO SET NOME, TIPO, DATASERVICO, NECESSITACONSULTA, PRECO " + "WHERE ID =?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, servico.getNome());

			stmt.setBoolean(2, servico.isNecessitaConsulta());
			stmt.setDouble(3, servico.getPreco());

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar serviço");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public ArrayList<Servico> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM SERVICO";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;

		ArrayList<Servico> servicos = new ArrayList<Servico>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Servico serv = ConstruirServico(rs);
				servicos.add(serv);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar serviços");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);

		}
		return servicos;
	}
	
	

	private Servico ConstruirServico(ResultSet rs) {
		Servico servico = new Servico();
		try {
			servico.setId(rs.getInt("id"));
			servico.setNome(rs.getString("Nome"));
			servico.setNecessitaConsulta(rs.getBoolean("necessitaConsulta"));
			servico.setPreco(rs.getDouble("preço"));
		} catch (SQLException e) {
			System.out.println("Erro ao contruir o serviço a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());

		}

		return servico;
	}
	
	
	

}
