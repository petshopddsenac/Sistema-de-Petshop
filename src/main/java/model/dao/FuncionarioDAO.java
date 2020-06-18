package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.seletor.FuncionarioSeletor;
import model.vo.Funcionario;



public class FuncionarioDAO {

	public Funcionario cadastrar(Funcionario novoFuncionario) {
		Connection conn = Banco.getConnection();

		String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, EMAIL, TELEFONE, CARGO, SALARIO, SERVIÇO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs = null;
		try {
			stmt.setString(1, novoFuncionario.getNome());
			stmt.setString(2, novoFuncionario.getCpf());
			stmt.setString(3, novoFuncionario.getRua());
			stmt.setString(4, novoFuncionario.getNumero());
			stmt.setString(5, novoFuncionario.getBairro());
			stmt.setString(6, novoFuncionario.getCep());
			stmt.setString(7, novoFuncionario.getEmail());
			stmt.setNString(8, novoFuncionario.getTelefone());
			stmt.setString(9, novoFuncionario.getCargo());
			stmt.setDouble(10, novoFuncionario.getSalario());
			stmt.setObject(11, novoFuncionario.getServicos());

			rs = stmt.getGeneratedKeys();
			int refIdGerado = 0;

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				refIdGerado = idGerado;

				novoFuncionario.setId(idGerado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo funcionário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return novoFuncionario;

	}

	public boolean alterar(Funcionario funcionario) {
		Connection conn = Banco.getConnection();
		String sql = " UPDADE FUNCIONARIO"
				+ "SET NOME =?, CPF = ?, RUA = ?, NUMERO =?, BAIRRO =?, CEP =?,EMAIL =?, TELEFONE =?, CARGO =?, SALARIO =? "
				+ "WHERE ID =?";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setString(3, funcionario.getRua());
			stmt.setString(4, funcionario.getNumero());
			stmt.setString(5, funcionario.getBairro());
			stmt.setString(6, funcionario.getCep());
			stmt.setString(7, funcionario.getEmail());
			stmt.setNString(8, funcionario.getTelefone());
			stmt.setString(9, funcionario.getCargo());
			stmt.setDouble(10, funcionario.getSalario());
			registrosAlterados = stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o funcionário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}

		return registrosAlterados > 0;

	}
	
	public  Funcionario ConsultarFuncionario(int id) {
		Connection conn = Banco.getConnection();
		String sql = "SELECT FROM FUNCIONARIO WHERE ID " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet rs = null;
		Funcionario funcionario = new Funcionario();
		try {
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				funcionario.setId(rs.getInt(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setCpf(rs.getString(3));
				funcionario.setRua(rs.getString(4));
				funcionario.setNumero(rs.getString(5));
				funcionario.setBairro(rs.getString(6));
				funcionario.setCep(rs.getString(7));
				funcionario.setEmail(rs.getString(8));
				funcionario.setTelefone(rs.getString(9));
				funcionario.setCargo(rs.getNString(10));
				funcionario.setSalario(rs.getDouble(11));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionario;
		
	}
	
	

	public ArrayList<Funcionario> consultarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM FUNCIONARIO";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				Funcionario funcionario = construirFuncionario(result);
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar funcionários.");
			System.out.println("Erro: " + e.getMessage());
		}
		return funcionarios;

	}

	private Funcionario construirFuncionario(ResultSet result) {
		Funcionario func = new Funcionario();
		try {
			func.setId(result.getInt("Id"));
			func.setNome(result.getString("Nome"));
			func.setCpf(result.getNString("CPF"));
			func.setRua(result.getNString("Rua"));
			func.setNumero(result.getNString("Número"));
			func.setCep(result.getNString("CEP"));
			func.setTelefone(result.getString("Telefone"));
			func.setEmail(result.getNString("email"));
			func.setCargo(result.getNString("Cargo"));
			func.setSalario(result.getDouble("Salário"));
		

		} catch (SQLException e) {
			System.out.println("Erro ao construir funcionário a partir do ResultSet. Causa: " + e.getMessage());
		}
		return func;

	}

	public ArrayList<Funcionario> listarComSeletor(FuncionarioSeletor seletor) {
		String sql = "SELECT * FROM FUNCIONARIO f";
		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		ArrayList<Funcionario> funcionarios = new ArrayList();
		try {
			ResultSet result = stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;

	}

	private String criarFiltros(FuncionarioSeletor seletor, String sql) {
		sql += "WHERE";
		boolean primeiro = true;

		if (seletor.getIdFuncionario() > 0) {
			if (!primeiro) {
				sql += "AND";
			}
			sql += "funcionario.id" + seletor.getIdFuncionario();
			primeiro = false;
		}

		if ((seletor.getNome() != null) && (seletor.getNome().trim().length() > 0)) {
			if (!primeiro) {
				sql += "AND";
			}

			if ((seletor.getCargo() != null) && (seletor.getCargo().trim().length() > 0)) {
				if (!primeiro) {
					sql += "AND";
				}
				if (seletor.getSalario() > 0) {
					if (!primeiro) {
						sql += "AND";
					}

				}

			}

		}
		return sql;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM FUNCIONARIO WHERE ID= " + id;
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir funcionário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		boolean excluiu = quantidadeLinhasAfetadas > 0;

		return excluiu;
	}

	public Funcionario salvar(Funcionario funcionarioVO) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, EMAIL, TELEFONE, CARGO, SALARIO, SERVIÇO)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, funcionarioVO.getNome());
			stmt.setString(2, funcionarioVO.getCpf());
			stmt.setString(3, funcionarioVO.getRua());
			stmt.setString(4, funcionarioVO.getNumero());
			stmt.setString(5, funcionarioVO.getBairro());
			stmt.setString(6, funcionarioVO.getCep());
			stmt.setString(7, funcionarioVO.getEmail());
			stmt.setNString(8, funcionarioVO.getTelefone());
			stmt.setString(9, funcionarioVO.getCargo());
			stmt.setDouble(10, funcionarioVO.getSalario());
			stmt.setObject(11, funcionarioVO.getServicos());
			stmt.execute();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				funcionarioVO.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Salvar o Funcionario.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return funcionarioVO;
	}

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM funcionario WHERE cpf = '" + cpf + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Funcionário por CPF.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean ConsultarFuncionarioPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		Funcionario funcionario = new Funcionario();

		String query = "SELECT id, cargo, salario, cpf, FROM funcionario WHERE id = " + id;

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				funcionario.setId(Integer.parseInt(resultado.getString(1)));
				funcionario.setNome(resultado.getString(2));
				funcionario.setBairro(resultado.getString(3));
				funcionario.setCargo(resultado.getString(4));
				funcionario.setCep(resultado.getNString(5));
				funcionario.setCpf(resultado.getNString(6));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionario != null;
	
	}

	public boolean existeRegistroPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT id FROM funcionario WHERE id = " + id;
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
	

	public Funcionario ConsultarFuncionariosPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		Funcionario funcionario = new Funcionario();

		String query = "SELECT ID, NOME, NECESSITACONSULTA, PRECO FROM SERVICO WHERE IDSERVICO = " + id;

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				funcionario.setId(Integer.parseInt(resultado.getString(1)));
				funcionario.setNome(resultado.getString(2));
				funcionario.setBairro(resultado.getString(3));
				funcionario.setCargo(resultado.getString(4));
				funcionario.setCep(resultado.getNString(5));
				funcionario.setCpf(resultado.getNString(6));
				
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Funcionarios.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionario;
	
		
	}
}