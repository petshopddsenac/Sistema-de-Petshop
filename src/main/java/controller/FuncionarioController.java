package controller;
import java.util.ArrayList;
import model.bo.FuncionarioBO;
import model.dao.FuncionarioDAO;
import model.vo.Funcionario;

public class FuncionarioController {

	public void cadastrarFuncionarioController(Funcionario funcionarioVO) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.cadastrarFuncionarioBO(funcionarioVO);
	}

	public void excluirFuncionarioController(Funcionario funcionarioVO) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.excluirUsuarioBO(funcionarioVO);

	}

	public void atualizarFuncionarioController(Funcionario funcionarioVO) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.atualizarUsuarioBO(funcionarioVO);

	}

	public ArrayList<Funcionario> consultarTodosFuncionario() {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		return funcionarioBO.consultarFuncionarioBO();

	}

	public void consultarFUncionarioId(Funcionario funcionarioVO) {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		funcionarioBO.consultarFuncionarioBO(funcionarioVO);

	}

	public String validarCamposDigitado(String nomeDigitado, String ruaDigitado, String cpfDigitado) {
		String mensagem = "";
		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3)
			mensagem += "Funcionario deve ter no minimo 3 letras";
		if (ruaDigitado.isEmpty() || ruaDigitado.trim().length() < 3) {
			mensagem += "Rua deve ter no minimo 3 letras";
		}
		return mensagem;
	}
		
	

	public Funcionario salvar(Funcionario funcionario) {
		
		return FuncionarioBO.salvar(funcionario);
	}

	
	
}
