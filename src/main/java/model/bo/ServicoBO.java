package model.bo;

import java.util.ArrayList;

import model.dao.ServicoDAO;
import model.vo.Servico;

public class ServicoBO {

	public void cadastrarServicoBO(Servico servicoVO) {
		ServicoDAO servicoDAO = new ServicoDAO();
		servicoVO = servicoDAO.cadastrar(servicoVO);
		if (servicoVO.getId() > 0) {
			System.out.println("\nServiço cadastrado com Sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar o Serviço.");
		}
	}
	
	public void excluirServicoBO(Servico servicoVO ) {
		ServicoDAO servicoDAO = new ServicoDAO();
		if (servicoDAO.existeRegistroPorIdServico(servicoVO.getId())) {
			boolean conseguiuExcluir = servicoDAO.excluir(servicoVO.getId());
			if (conseguiuExcluir) {
				System.out.println("\nServiço excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Serviço.");
			}
		} else {
			System.out.println("\nServiço não existe na base da dados.");
		}
	}
	
	public void atualizarServicoBO(Servico usuarioVO) {
		ServicoDAO servicoDAO = new ServicoDAO();
		if (servicoDAO.existeRegistroPorIdServico(usuarioVO.getId())) {
			boolean alterou = servicoDAO.alterar(usuarioVO);
			if (alterou) {
				System.out.println("\nServiço atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Serviço.");
			}
		} else {
			System.out.println("\nServiço ainda não foi cadastrado.");
		}
	}
	
	public ArrayList<Servico> consultarServicosBO() {
		ServicoDAO servicoDAO = new ServicoDAO();
		ArrayList<Servico> servicos = servicoDAO.consultarTodos();
		if (servicos.isEmpty()) {
			System.out.println("\nLista de Serviços está vazia.");
		}
		return servicos;
	}

	public Servico consultarServicoBO(Servico servicoVO) {
		ServicoDAO servicoDAO = new ServicoDAO();
		Servico servico = servicoDAO.ConsultarPorId(servicoVO.getId());
		if (servico == null) {
			System.out.println("\nUsuário não Localizado.");
		}
		return servico;
	}
}