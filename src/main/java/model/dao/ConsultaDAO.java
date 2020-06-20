package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.vo.Animal;
import model.vo.Cliente;
import model.vo.Consulta;
import model.vo.Funcionario;
import model.vo.Servico;

public class ConsultaDAO {

	public Consulta cadastrar(Consulta novaConsulta) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO CONSULTA (IDCONSULTA, IDCLIENTE, IDANIMAL, IDFUNCIONARIO, IDSERVICO, DATAC, TIMEC, DIAGNOSTICO) VALUES"
				+ "(?,?,?,?,?,?,?,?) ";		
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt.setObject(1, novaConsulta.getCliente());
			stmt.setObject(2, novaConsulta.getAnimal());
			stmt.setObject(3, novaConsulta.getFuncionario());
			stmt.setObject(4, novaConsulta.getServico());
			stmt.setDate(5, novaConsulta.getDataConsulta());
			stmt.setTime(6, novaConsulta.getHoraConsulta());
			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				novaConsulta.setId(idGerado);
			}

			JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova consulta");

		}
		return novaConsulta;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM CONSULTA WHERE IDCONSULTA = " + id;
		Statement stmt = Banco.getStatement(conn);
		int quantidadeLinhasAfetadas = 0;
		ResultSet rs = null;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("Erro ao excluir consulta.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Consulta consulta) {
		Connection conn = Banco.getConnection();
		String sql = " UPDATE CONSULTA "
				+ "SET IDCLIENTE =? , Animal = ?, Funcionario =?, Servico =?, dataConsulta = ?, horaConsulta = ?"
				+ "WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setObject(1, consulta.getCliente().getId());
			stmt.setObject(2, consulta.getAnimal().getId());
			stmt.setObject(3, consulta.getFuncionario().getId());
			stmt.setObject(4, consulta.getServico().getId());
			stmt.setDate(5, consulta.getDataConsulta());
			stmt.setTime(6, consulta.getHoraConsulta());

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a consulta");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return quantidadeLinhasAfetadas > 0;

	}

	public ArrayList<Consulta> ListarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM CONSULTA";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;

		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta con = ConstruirConsulta(rs);
				consultas.add(con);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar consultas");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);

		}
		return consultas;
	}
	
	
	public Consulta ConsultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		Consulta consulta = new Consulta();

		String query = "SELECT IDCONSULTA, IDCLIENTE, IDANIMAL, IDFUNCIONARIO, IDSERVICO, DATAC, TIMEC, DIAGNOSTICO FROM CONSULTA WHERE IDCONSULTA = " + id;

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				consulta = new Consulta();
				consulta.setId(Integer.parseInt(resultado.getString("ID")));
				consulta.setCliente(resultado.getInt("IDCLIENTE"));
				consulta.setAnimal(resultado.getInt("IDANIMAL"));
				consulta.setFuncionario(resultado.getInt("IDFUNCIONARIO"));
				consulta.setServico(resultado.getInt("IDSERVICO"));
				consulta.setDataConsulta(resultado.getDate("DATAC"));
				consulta.setHoraConsulta(resultado.getTime("TIMEC"));				
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Consultas.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return consulta;
	}
	
	public boolean existeRegistroPorIdConsulta(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT IDCONSULTA FROM CONSULTA WHERE IDSERVICO = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
	
	

	private Consulta ConstruirConsulta(ResultSet rs) {
		Consulta consulta = new Consulta();
		try {
			consulta.setId(rs.getInt("id"));
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.consultarPorId(rs.getInt("id"));	
			
			AnimalDAO animalDAO = new AnimalDAO();
			Animal animal = animalDAO.obterPorId(rs.getInt("id"));
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.ConsultarFuncionario(rs.getInt("id"));
			ServicoDAO servicoDAO = new ServicoDAO();
			Servico servico = servicoDAO.ConsultarPorId(rs.getInt("id"));
			DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			consulta.setDataConsulta(rs.getDate("dataConsulta"));
			consulta.setHoraConsulta(rs.getTime("horaConsulta"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir consulta a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return consulta;

	}
	
	
	

}
