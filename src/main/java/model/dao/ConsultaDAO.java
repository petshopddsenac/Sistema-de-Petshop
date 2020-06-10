package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String sql = "INSERT INTO CONSULTA (CLIENTE, ANIMAL, FUNCIONARIO, SERVICO, DATASERVICO, HORASERVICO, ID) VALUES"
				+ "(?, ?, ?, ?, ?, ?,?) ";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt.setObject(1, novaConsulta.getClientes());
			stmt.setObject(2, novaConsulta.getAnimal());
			stmt.setObject(3, novaConsulta.getFuncionarios());
			stmt.setObject(4, novaConsulta.getServicos());
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
				+ "SET Cliente =? , Animal = ?, Funcionario =?, Servico =?, dataConsulta = ?, horaConsulta = ?"
				+ "WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setObject(1, consulta.getClientes());
			stmt.setObject(2, consulta.getAnimal());
			stmt.setObject(3, consulta.getFuncionarios());
			stmt.setObject(4, consulta.getServicos());
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

	private Consulta ConstruirConsulta(ResultSet rs) {
		Consulta consulta = new Consulta();
		try {
			consulta.setId(rs.getInt("id"));
			ClienteDAO cDAO = new ClienteDAO();
			Cliente clientes = cDAO.consulrPorId(rs.getInt("id"));

			AnimalDAO animalDAO = new AnimalDAO();
			ArrayList<Animal> pet = animalDAO.consultarTodos();
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			Funcionario func = funcDAO.ConsultarFuncionario(rs.getInt("id"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir consulta a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return consulta;

	}

}
