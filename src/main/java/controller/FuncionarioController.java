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
}
