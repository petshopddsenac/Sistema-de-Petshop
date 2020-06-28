package controller;

import java.util.ArrayList;

import model.bo.ServicoBO;
import model.vo.Servico;
public class ServicoController {
	
	private ServicoBO bo = new ServicoBO();
	

	public void cadastrarServicoController(Servico servicoVO) {
		ServicoBO servicoBO = new ServicoBO();
		servicoBO.cadastrarServicoBO(servicoVO);
	}
	
	public void excluirServicoController(Servico servicoVO) {
		ServicoBO servicoBO = new ServicoBO();
		servicoBO.excluirServicoBO(servicoVO);
	}
	
	public void alterarServicoController(Servico servicoVO) {
		ServicoBO servicoBO = new ServicoBO();
		servicoBO.atualizarServicoBO(servicoVO);
	}
	
	public ArrayList<Servico> consultarTodos() {
		ServicoBO servicoBO = new ServicoBO();
		return servicoBO.consultarServicosBO();
	}
	
	public void ConsultarPorId(Servico servicoVO) {
		ServicoBO servicoBO = new ServicoBO();
		servicoBO.consultarServicoBO(servicoVO);
	}

	/*public void cadastrar(String nome, String preco, boolean necessitaConsulta) {
		String mensagem = "";

		if (nome != null && !nome.isEmpty() && nome.length() != 2) {
			mensagem = "O nome deve possuir pelo menos 2 caracteres.";
		}

		if (mensagem.isEmpty()) {
			Servico servicoVO = new Servico();
			mensagem = bo.cadastrarServicoBO(servicoVO);
		}
		return;
		
	}	*/
	
}

