package model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.dao.ClienteDAO;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;

public class ClienteBO {

	ClienteDAO cDAO = new ClienteDAO();

	public String cadastrar(Cliente novoCliente) {
		ClienteDAO cDAO = new ClienteDAO();
		String mensagem = "";
		if (novoCliente.getId() > 0) {
			mensagem = "Cliente cadastrado com sucesso";

		} else {
			mensagem = "Erro ao cadastrar cliente";
		}
		return mensagem;
	}

	public ArrayList<Cliente> listarComSeletor(ClienteSeletor seletor) {
		return cDAO.listarComSeletor(seletor);

	}

	public ArrayList<Cliente> listarTodos() {
		ArrayList<Cliente> clientes = cDAO.listarTodos();
		return clientes;
	}

	public String excluirPorId(int id) {
		String mensagem = "";
		ClienteDAO dao = new ClienteDAO();
		if (dao.excluir(id)) {
			mensagem = "Excluído com sucesso";
		} else {
			mensagem = "Erro ao excluir";
		}
		return mensagem;

	}

	public String excluir(String cpf) {
		String mensagem = "";
		boolean retorno = false;
		if (cDAO.cpfJaUtilizado(cpf)) {
			retorno = cDAO.excluirPorCpf(cpf);
			if (retorno == true) {
				mensagem = "Cliente excluido com sucesso.";
			}
		} else {
			mensagem = "Este CPF não consta no cadastro.";
		}
		return mensagem;
	}

	public boolean existeCpf(String txtCpf) {
		ClienteDAO cDAO = new ClienteDAO();
		if (cDAO.cpfJaUtilizado(txtCpf)) {
			return true;
		} else {
			return false;
		}

	}
}