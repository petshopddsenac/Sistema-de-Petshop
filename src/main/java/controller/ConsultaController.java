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
		consultaBO.excluirServicoBO(consultaVO);
	}
	
	public void alterarConsultaController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.atualizarServicoBO(consultaVO);
	}
	
	public ArrayList<Consulta> consultarConsultasController() {
		ConsultaBO consultaVO = new ConsultaBO();
		return consultaVO.consultarServicosBO();
	}
	
	public void ConsultarConsultaPorIdController(Consulta consultaVO) {
		ConsultaBO consultaBO = new ConsultaBO();
		consultaBO.consultarServicoBO(consultaVO);
	}
	
}
