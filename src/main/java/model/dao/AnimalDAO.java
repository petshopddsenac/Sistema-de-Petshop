package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import model.seletor.AnimalSeletor;
import model.vo.Animal;

public class AnimalDAO {

	public Animal cadastrar(Animal novoAnimal) {

		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ANIMAL (NOME, ESPECIE, RACA, IDADE, PESO) VALUES "
				+ "(?, ?, ?, ?, ?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novoAnimal.getNome());
			stmt.setString(2, novoAnimal.getEspecie());
			stmt.setString(3, novoAnimal.getRaca());
			stmt.setDouble(4, novoAnimal.getIdade());
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
		String sql = "UPDATE ANIMAL SET NOME, ESPECIE, RACA, IDADE, PESO, DONO" + "WHERE ID =? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, animal.getNome());
			stmt.setString(2, animal.getEspecie());
			stmt.setString(3, animal.getRaca());
			stmt.setDouble(4, animal.getIdade());
			stmt.setDouble(5, animal.getPeso());
			stmt.setObject(6, animal.getDono());
			stmt.setInt(7, animal.getId());

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

	public Animal construirAnimal(ResultSet result) {
		Animal animal = new Animal();
		try {
			animal.setId(result.getInt("ID"));
			animal.setNome(result.getNString("Nome"));
			animal.setEspecie(result.getNString("Espécie"));
			animal.setRaca(result.getNString("Raça"));
			animal.setIdade(result.getDouble("Idade"));
			animal.setPeso(result.getDouble("Peso"));

			AnimalDAO aDAO = new AnimalDAO();

		} catch (SQLException e) {
			System.out.println("Erro ao construir animal a partir do ResultSet. Causa: " + e.getMessage());
		}
		return animal;
	}

	public ArrayList<Animal> listarComSeletor(AnimalSeletor seletor) {
		String sql = "SELECT * FROM ANIMAL  animal";
		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);

		}
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ArrayList<Animal> pets = new ArrayList<Animal>();
		try {
			ResultSet result = stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}

	private String criarFiltros(AnimalSeletor seletor, String sql) {

		sql += "WHERE";
		boolean primeiro = true;

		if (seletor.getDono() != null) {
			if (!primeiro) {
				sql += "AND";
			}
			sql += "animal.dono" + seletor.getDono();
			primeiro = false;
		}
		if ((seletor.getRaca() != null) && (seletor.getRaca().trim().length() > 0)) {
			if (!primeiro) {
				sql += "AND";
			}
			sql += "animal.raca LIKE '%" + seletor.getRaca() + "%'";
			primeiro = false;

		}

		if ((seletor.getEspecie() != null) && (seletor.getEspecie().trim().length() > 0)) {
			if (!primeiro) {
				sql += "AND";
			}
			sql += "animal.especie LIKE '%'" + seletor.getEspecie() + "%'";
			primeiro = false;
		}

		return sql;
	}

	public ArrayList<Animal> consultarTodos() {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		ResultSet resultado = null;
		
		ArrayList<Animal> animais = new ArrayList<Animal>();
		
		String query = " SELECT * FROM ANIMAL ";
		
		
		
		try {
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				Animal animais1 = new Animal();
				
				animais1.setId(resultado.getInt("ID"));
				animais1.setNome(resultado.getString("NOME"));
				animais1.setEspecie(resultado.getString("ESPECIE"));
			

			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar animais.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return animais;
	}

	public int inserir(Animal animalVO) {
		int novoId = -1;

		String sql = " INSERT INTO ANIMAL (NOME, ESPECIE, RACA, DATANASCIMENTO, PESO, ID) " + " VALUES (?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, animalVO.getNome());
			prepStmt.setString(2, animalVO.getEspecie());
			prepStmt.setString(3, animalVO.getRaca());
			prepStmt.setDouble(4, animalVO.getIdade());
			prepStmt.setDouble(5, animalVO.getPeso());
			prepStmt.setInt(6, animalVO.getId());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir O Animal. Causa: \n: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return novoId;
	}

	public Animal obterPorId(int animal) {
		String sql = " SELECT * FROM ANIMAL " + " WHERE ID=?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		Animal An = null;

		try {
			prepStmt.setInt(1, animal);
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				An = new Animal();
				An.setId(result.getInt("ID"));
				An.setNome(result.getString("NOME"));
				An.setEspecie(result.getString("ESPECIE"));
				An.setIdade(result.getDouble("Idade"));
				An.setPeso(result.getDouble("Peso"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return An;
	}

	public boolean atualizar(Animal animala) {
		boolean sucessoUpdate = false;

		String sql = " UPDATE ANIMAL ANIMAL SET NOME=?, ESPECIE=?, RACA=?, PESO=?,  ID=?, IDADE =? " + " WHERE ANIMAL.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, animala.getNome());
			prepStmt.setString(2, animala.getEspecie());
			prepStmt.setString(3, animala.getRaca());
			prepStmt.setDouble(4, animala.getPeso());
			prepStmt.setDouble(5, animala.getId());
			prepStmt.setDouble(6, animala.getIdade());

			int codigoRetorno = prepStmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o Animal. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public ArrayList<Animal> listarTodosA(AnimalSeletor seletor) {
		String sql = " SELECT * FROM ANIMAL animal";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}

		if (seletor.temPaginacao()) {

			sql += " LIMIT " + seletor.getLimite() + " OFFSET " + seletor.getOffset();
		}
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Animal> produtos = new ArrayList<Animal>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				Animal animala = construirAnimalDoResultSet(result);
				produtos.add(animala);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	private Animal construirAnimalDoResultSet(ResultSet result) {
		Animal A = new Animal();

		try {
			A.setId(result.getInt("ID"));
			A.setNome(result.getString("NOME"));
			A.setPeso(result.getDouble("PESO"));
			A.setEspecie(result.getString("ESPECIE"));
			A.setRaca(result.getString("RACA"));
			A.setIdade(result.getDouble("IDADE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return A;
	}

	public ArrayList<Animal> listarTodos() {
		String sql = " SELECT * FROM ANIMAL ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Animal> produtos = new ArrayList<Animal>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				Animal An = new Animal();
				An = new Animal();
				An.setId(result.getInt("ID"));
				An.setNome(result.getString("NOME"));
				An.setEspecie(result.getString("ESPECIE"));
				An.setRaca(result.getNString("Raça"));
				An.setPeso(result.getDouble("PESO"));
				An.setIdade(result.getDouble("IDADE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public Animal salvar1(Animal animal) {

		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO ANIMAL (NOME, ESPECIE, RACA, IDADE, PESO) VALUES "
				+ "(?, ?, ?, ?, ?,)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, animal.getNome());
			stmt.setString(2, animal.getEspecie());
			stmt.setString(3, animal.getRaca());
			stmt.setDouble(4, animal.getIdade());
			stmt.setDouble(5, animal.getPeso());
			

			if (animal.getDono() != null) {
				stmt.setInt(6, animal.getDono().getId());
			} else {
				stmt.setInt(5, 0);
			}

			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGerado = generatedKeys.getInt(1);
				animal.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo animal.");
			System.out.println("Erro: " + e.getMessage());
		}

		return animal;
	}

	public ArrayList<Animal> buscar() {
		String sql = " SELECT * FROM ANIMAL ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Animal> animal = new ArrayList<Animal>();

		try {
			ResultSet result = prepStmt.executeQuery();

			while (result.next()) {
				Animal An = new Animal();

				An.setNome(result.getNString("NOME"));
				An.setEspecie(result.getString("ESPECIE"));
				An.setRaca(result.getString("RACA"));
				An.setIdade(result.getDouble("IDADE"));
				An.setPeso(result.getDouble("PESO"));

			animal.add(An);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animal;
	}

	

}
