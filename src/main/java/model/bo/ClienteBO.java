package model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import controller.ClienteController;
import model.dao.ClienteDAO;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;
import util.GeradorPlanilha;

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
	public Cliente cadastrarCliente(Cliente cliente) {
		ClienteDAO cDAO = new ClienteDAO();
		return cDAO.cadastrar(cliente);
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
	
	public String excluirCliente(String Nome) {
		String mensagem ="";
		Cliente cliente = new Cliente();
		if(cliente.getNome().isEmpty()) {
			mensagem = "Digite um nome";
		}
		return mensagem;
	
			
	}
	
	public boolean alterarCiente (Cliente clienteAlterado) {
		ClienteDAO dao = new ClienteDAO();
		return dao.alterar(clienteAlterado);
		
	}
	
	public void gerarRelatorio(ArrayList<Cliente> clientes, String caminhoEscolido) {
		GeradorPlanilha gerador = new GeradorPlanilha();
		gerador.gerarPlanilhaClientes(caminhoEscolido, clientes);
		
	}
	
}