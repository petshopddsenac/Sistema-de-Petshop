package controller;

import java.util.ArrayList;

import model.bo.ServicoBO;
import model.vo.Servico;

public class ServicoController {

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
	
}
