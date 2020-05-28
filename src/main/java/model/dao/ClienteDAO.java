package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Cliente;

public class ClienteDAO {

	public Cliente salvar(Cliente novoCliente) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO CLIENTE (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, EMAIL, TELEFONE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getCpf());
			stmt.setString(3, novoCliente.getRua());
			stmt.setString(4, novoCliente.getNumero());
			stmt.setString(5, novoCliente.getCep());
			stmt.setString(6, novoCliente.getTelefone());
			stmt.setString(7, novoCliente.getEmail());
			stmt.execute();

			rs = stmt.getGeneratedKeys();
			int refIdGerado = 0;

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				refIdGerado = idGerado;
				novoCliente.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return novoCliente;
	}
	
	public boolean alterar(Cliente cliente) {
		Connection conn = Banco.getConnection();
		String sql = " UPDADE CLIENTE" + "SET NOME =?, CPF = ?, RUA = ?, NUMERO =?, BAIRRO =?, CEP =?,EMAIL =? " + "WHERE ID =?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int registrosAlterados =0;
		try {
			stmt.setNString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRua());
			stmt.setString(4,cliente.getNumero());
			stmt.setString(5, cliente.getBairro());
			stmt.setString(6, cliente.getCep());
			stmt.setString(7, cliente.getEmail());
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
	
	public ArrayList<Cliente> listar(){
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM CLIENTE ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				  Cliente cliente = new Cliente();
				  cliente.setNome(rs.getString("nome"));
				  cliente.setCpf(rs.getNString("cpf"));
				  cliente.setRua(rs.getNString("Rua"));
				  cliente.setBairro(rs.getNString("Bairro"));
				  cliente.setCep(rs.getNString("CEP"));
				  cliente.setTelefone(rs.getNString("Telefone"));
				  cliente.setEmail(rs.getNString("email"));
				 

			}
		 } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	        	Banco.closePreparedStatement(stmt);
				Banco.closeConnection(conn);
	        	
		}
		return listar();
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CLIENTE WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);
		
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


