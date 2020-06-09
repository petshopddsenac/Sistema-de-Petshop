package model.bo;

import model.dao.ClienteDAO;

public class ClienteBO {
	
	
	
	public boolean excluirPorId(int id) {
		ClienteDAO dao = new ClienteDAO();
		if ( dao.excluir(id) ){
			return true;
		} else {
			return false;
		}
	}

	public boolean existeCpf(String textCpf) {
		// TODO Auto-generated method stub
		return false;
	}

}
