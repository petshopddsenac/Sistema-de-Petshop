package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.seletor.AnimalSeletor;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;

public class ClienteDAO {

	public Cliente cadastrar(Cliente novoCliente) {
		
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CLIENTE (NOME, CPF, RUA, DDD, NUMERO, BAIRRO, CEP, EMAIL, TELEFONE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getCpf());
			stmt.setString(3, novoCliente.getRua());
			stmt.setString(4, novoCliente.getDdd());
			stmt.setString(5, novoCliente.getNumero());
			stmt.setString(6, novoCliente.getBairro());
			stmt.setString(7, novoCliente.getCep());
			stmt.setString(8, novoCliente.getEmail());
			stmt.setString(9, novoCliente.getTelefone());

			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				novoCliente.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao salvar novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return novoCliente;
	}

	public Cliente construirCliente(ResultSet rs) {
		Cliente c = new Cliente();
		try {

			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setRua(rs.getString("rua"));
			c.setDdd(rs.getString("ddd"));
			c.setTelefone(rs.getString("telefone"));
			c.setNumero(rs.getString("numero"));
			c.setBairro(rs.getString("bairro"));
			c.setCep(rs.getString("cep"));
			c.setEmail(rs.getString("email"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir cliente a partir do ResultSet. Causa: " + e.getMessage());
		}
		return c;
	}

	public boolean alterar(Cliente cliente) {
		Connection conn = Banco.getConnection();
		String sql = " UPDADE CLIENTE"
				+ "SET NOME =?, CPF = ?, RUA = ?, NUMERO =?, BAIRRO =?, CEP =?,EMAIL =?, TELEFONE =? " + "WHERE ID =?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int registrosAlterados = 0;
		try {
			stmt.setNString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRua());
			stmt.setString(4, cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCep());
			stmt.setString(7, cliente.getEmail());
			stmt.setString(8, cliente.getTelefone());
			if((cliente.getNome()!=null) || !cliente.getNome().isEmpty()) {
				stmt.setString(9, cliente.getNome());
			} else {
				stmt.setString(8, null);
			
			}
			if((cliente.getCpf()!=null) || !cliente.getCpf().isEmpty()) {
			}else {
			stmt.setString(9, null);	
			}
			
			if((cliente.getTelefone()!= null) || !cliente.getTelefone().isEmpty()) {
				stmt.setString(10, null);
			}
			
			
			registrosAlterados = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return registrosAlterados > 0;

	}

	public ArrayList<Cliente> listarComSeletor(ClienteSeletor seletor) {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM CLIENTE ";
		
		if (seletor.temFiltro()) {
			sql = criarFiltros(sql, seletor);
		}
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Cliente c = construirCliente(result);
				clientes.add(c);
				
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes.");
			System.out.println("Erro: " + e.getMessage());
			
		
		}
		return clientes;

	}

	private String criarFiltros(String sql, ClienteSeletor seletor) {
		sql += "WHERE";
		boolean primeiro = true;

		if (seletor.getNome() != null && seletor.getNome().trim().length() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " NOME LIKE " + "'%" + seletor.getNome() + "%' ";
			primeiro = false;
		}

		if (seletor.getCpf() != null && seletor.getCpf().trim().length() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}

			sql += " CPF LIKE " + "'%" + seletor.getCpf() + "%' ";
		}
		return sql;
	}

	public Cliente consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = "SELECT FROM CLIENTE WHERE ID " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		Cliente cliente = new Cliente();
		try {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				cliente.setId(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setRua(rs.getString(4));
				cliente.setNumero(rs.getString(5));
				cliente.setBairro(rs.getString(6));
				cliente.setCep(rs.getString(7));
				cliente.setEmail(rs.getString(8));
				cliente.setTelefone(rs.getString(9));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cliente;
	}

	public ArrayList<Cliente> listarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt("Id"));
				cliente.setId(rs.getInt("Id"));
				cliente.setNome(rs.getNString("Nome"));
				cliente.setCpf(rs.getNString("CPF"));
				cliente.setRua(rs.getNString("Rua"));
				cliente.setNumero(rs.getNString("Número"));
				cliente.setCep(rs.getNString("CEP"));
				cliente.setTelefone(rs.getString("Telefone"));
				cliente.setEmail(rs.getNString("email"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar clientes.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return clientes;
	}

	
	public boolean cpfJaUtilizado(String cpf) {

		Connection conn = Banco.getConnection();
		String sql = " select id from cliente c " + "where c.cpf = '" + cpf + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		boolean cpfUsado = false;

		try {
			rs = stmt.executeQuery();
			cpfUsado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro na verificação de uso do CPF. Causa: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return cpfUsado;
	}
	
	public boolean excluirPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE CPF = '" + cpf + "'";
		Statement stmt = Banco.getStatement(conn);
		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente pelo do cpf.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return quantidadeLinhasAfetadas > 0;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE ID= " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		boolean excluiu = quantidadeLinhasAfetadas > 0;

		return excluiu;
	}

}
