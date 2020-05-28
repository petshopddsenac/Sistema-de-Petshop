package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Animal;

public class AnimalDAO {

	public Animal salvar(Animal novoAnimal) {

		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ANIMAL (NOME, ESPECIE, RACA, DATANASCIMENTO PESO, IDCLIENTE) VALUES "
				+ "(?, ?, ?, ?, ?, ?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novoAnimal.getNome());
			stmt.setString(2, novoAnimal.getEspecie());
			stmt.setString(3, novoAnimal.getRaca());
			stmt.setDate(4, novoAnimal.getDataNascimento());
			stmt.setDouble(5, novoAnimal.getPeso());

			if (novoAnimal.getDono() != null) {
				stmt.setInt(6, novoAnimal.getDono().getId());
			} else {
				stmt.setInt(5, 0);
			}

			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				novoAnimal.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo animal.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoAnimal;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELE FROM ANIMAL WHERE IDANIMAL = " + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir animal.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Animal animal) {
		Connection conn = Banco.getConnection();
		String sql = "UPDATE ANIMAL SET NOME, ESPECIE, RACA, DATANASCIMENTO, PESO, DONO" + "WHERE ID =? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, animal.getNome());
			stmt.setString(2, animal.getEspecie());
			stmt.setString(3, animal.getRaca());
			stmt.setDate(4, animal.getDataNascimento());
			stmt.setDouble(5, animal.getPeso());

			if (animal.getDono() != null) {
				stmt.setInt(6, animal.getDono().getId());
			}

			stmt.setInt(7, animal.getId());
			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar animal.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

}
