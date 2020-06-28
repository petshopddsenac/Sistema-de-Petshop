package controller;

import java.util.ArrayList;

import model.bo.ConsultaBO;
import model.vo.Consulta;

public class ConsultaController {

	public void cadastrarConsultaController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.cadastrarConsultaBO(consultaVO);
	}
	
	public void excluirConsultaController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.excluirConsultaBO(consultaVO);
	}
	
	public void alterarConsultaController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.atualizarConsultaBO(consultaVO);
	}
	
	public ArrayList<Consulta> consultarConsultasController() {
		ConsultaBO consultaVO = new ConsultaBO();
		return consultaVO.consultarConsultasBO();
	}
	
	public void ConsultarConsultaPorIdController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.consultarConsultaBO(consultaVO);
	}
	
}
