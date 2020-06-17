package model.bo;

import model.dao.FuncionarioDAO;

import model.vo.FuncionarioVO;

import java.util.ArrayList;

public class FuncionarioBO {

	public void cadastrarFuncionarioBO(FuncionarioVO funcionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (FuncionarioDAO.existeRegistroPorCpf(FuncionarioVO.getCpf())) {
			System.out.println("\nUsuário já Cadastrado");
		} else {
			funcionarioVO = funcionarioDAO.salvar(funcionarioVO);
			if (FuncionarioVO.getIdUsuario() > 0) {
				System.out.println("\nUsuário cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Usuário.");
			}
		}
	}

	public void excluirUsuarioBO(FuncionarioVO FuncionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (funcionarioDAO.existeRegistroPorIdUsuario(FuncionarioVO.getIdUsuario())) {
			boolean conseguiuExcluir = funcionarioDAO.excluir(FuncionarioVO.getIdUsuario());
			if (conseguiuExcluir) {
				System.out.println("\nUsuário excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Usuário.");
			}
		} else {
			System.out.println("\nUsuário não existe na base da dados.");
		}
	}

	public void atualizarUsuarioBO(FuncionarioVO FuncionarioVO) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (funcionarioDAO.existeRegistroPorIdUsuario(FuncionarioVO.getIdUsuario())) {
			boolean alterou = funcionarioDAO.alterar(funcionarioDAO);
			if (alterou) {
				System.out.println("\nUsuário atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Usuário.");
			}
		} else {
			System.out.println("\nUsuário ainda não foi cadastrado.");
		}
	}

	public ArrayList<FuncionarioVO> consultarFuncionarioBO() {
		FuncionarioDAO usuarioDAO = new FuncionarioDAO();
		ArrayList<FuncionarioVO> usuariosVO = usuarioDAO.consultarTodos();
		if (usuariosVO.isEmpty()) {
			System.out.println("\nLista de Usuários está vazia.");
		}
		return usuariosVO;
	}

	public FuncionarioVO consultarFuncionarioBO(FuncionarioVO funcionarioVO) {
		FuncionarioDAO usuarioDAO = new FuncionarioDAO();
		FuncionarioVO usuario = usuarioDAO.consultarPorId(funcionarioVO.getIdUsuario());
		if (usuario == null) {
			System.out.println("\nUsuário não Localizado.");
		}
		return usuario;
	}

}
