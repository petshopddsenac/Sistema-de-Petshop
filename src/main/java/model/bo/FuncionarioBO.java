package model.bo;

import model.dao.FuncionarioDAO;
import model.vo.Funcionario;
import model.bo.*;

import java.util.ArrayList;

public class FuncionarioBO {

	public void cadastrarFuncionarioBO(Funcionario funcionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioVO = funcionarioDAO.cadastrar(funcionarioVO);
		funcionarioVO = funcionarioDAO.salvar(funcionarioVO);
		if (funcionarioDAO.existeRegistroPorCpf(funcionarioVO.getCpf())) {
			System.out.println("\nFuncionario já Cadastrado");
		} else {
			funcionarioVO = funcionarioDAO.salvar(funcionarioVO);
			if (funcionarioVO.getId() > 0) {
				System.out.println("\nFuncionário cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Funcionário.");
			}
		}
	}

	public void excluirUsuarioBO(Funcionario FuncionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (funcionarioDAO.ConsultarFuncionarioPorId(FuncionarioVO.getId())) {
			boolean conseguiuExcluir = funcionarioDAO.excluir(FuncionarioVO.getId());
			if (conseguiuExcluir) {
				System.out.println("\nFuncionário excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Funcionário.");
			}
		} else {
			System.out.println("\nEsse Funcionário não existe na base da dados.");
		}
	}

	public void atualizarUsuarioBO(Funcionario FuncionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (funcionarioDAO.existeRegistroPorId(FuncionarioVO.getId())) {
			boolean alterou = funcionarioDAO.alterar(FuncionarioVO);
			if (alterou) {
				System.out.println("\nFuncionário atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Funcionário.");
			}
		} else {
			System.out.println("\nFuncionário ainda não foi cadastrado.");
		}
	}

	public ArrayList<Funcionario> consultarFuncionarioBO() {
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
		ArrayList<Funcionario> Funcionario = FuncionarioDAO.consultarTodos();
		if (Funcionario.isEmpty()) {
			System.out.println("\nLista de funcionários está vazia.");
		}
		return Funcionario;
	}

	public Funcionario consultarFuncionarioBO(Funcionario funcionarioVO) {
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = FuncionarioDAO.ConsultarFuncionariosPorId(funcionarioVO.getId());
		if (funcionario == null) {
			System.out.println("\nFuncionário não Localizado.");
		}
		return funcionario;
	}

}
