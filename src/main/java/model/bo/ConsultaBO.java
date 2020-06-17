package model.bo;

import java.util.ArrayList;

import model.dao.ConsultaDAO;
import model.vo.Consulta;

public class ConsultaBO {
	
	public void cadastrarConsultaBO(Consulta consultaVO) {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		consultaVO = consultaDAO.cadastrar(consultaVO);
		if (consultaVO.getId() > 0) {
			System.out.println("\nConsulta cadastrado com Sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar a Consulta.");
		}
	}
	
	public void excluirServicoBO(Consulta consultaVO ) {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		if (consultaDAO.existeRegistroPorIdConsulta(consultaVO.getId())) {
			boolean conseguiuExcluir = consultaDAO.excluir(consultaVO.getId());
			if (conseguiuExcluir) {
				System.out.println("\nServiço excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Serviço.");
			}
		} else {
			System.out.println("\nServiço não existe na base da dados.");
		}
	}
	
	public void atualizarServicoBO(Consulta consultaVO) {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		if (consultaDAO.existeRegistroPorIdServico(consultaVO.getId())) {
			boolean alterou = consultaDAO.alterar(consultaVO);
			if (alterou) {
				System.out.println("\nServiço atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Serviço.");
			}
		} else {
			System.out.println("\nServiço ainda não foi cadastrado.");
		}
	}
	
	public ArrayList<Consulta> consultarServicosBO() {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		ArrayList<Consulta> consulta = consultaDAO.consultarTodos();
		if (servicos.isEmpty()) {
			System.out.println("\nLista de Serviços está vazia.");
		}
		return consulta;
	}

	public Consulta consultarServicoBO(Consulta consultaVO) {
		ConsultaDAO consultaDAO = new ConsultaDAO();
		Consulta consulta = consultaDAO.ConsultarPorId(consultaVO.getId());
		if (servico == null) {
			System.out.println("\nUsuário não Localizado.");
		}
		return consulta;
	}
}