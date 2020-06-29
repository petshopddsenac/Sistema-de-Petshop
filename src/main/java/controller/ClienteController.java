package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import model.bo.ClienteBO;
import model.dao.ClienteDAO;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;

public class ClienteController {
	private ClienteDAO dao = new ClienteDAO();
	private ClienteBO bo = new ClienteBO();

	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = bo.excluirPorId(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

	public String Salvar(String Nome, String Rua, String Bairro, String Numero, String Telefone, String email,
			String Cpf, String Cep) {
		String mensagem = "";

		if ((Nome == null) || (Nome.trim().length() < 3)) {
			mensagem += " O nome deve ter no minímo 3 letras ";
		}

		if ((Rua == null) || (Rua.trim().length() < 5)) {
			mensagem += "A Rua deve conter no mínimo 5 caracteres";
		}
		if ((Bairro == null) || (Bairro.trim().length() < 5)) {
			mensagem += " O Bairro deve conter  no mínimo 5 caracteres ";

		}
		if ((Numero == null) || (Numero.trim().length() < 2)) {
			mensagem += "O número deve conter no mínimo 2 caracteres";

		}

		if ((Telefone == null) || (Telefone.trim().length() < 8)) {
			mensagem += "Telefone deve ter no minímo 8 caracteres ";
		}
		if ((Cpf == null) || (Cpf.trim().length() < 11)) {
			mensagem += "Cliente deve ter 11 digitos";

		}
		if ((Cep == null) || (Cep.trim().length() < 8)) {
			mensagem += " O CEP deve conter 8 caracteres";
		}

		return mensagem;
	}

	public ArrayList<Cliente> listarClientes(ClienteSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}

	public String validarCpf(String txtCpf) {
		String mensagem = "";

		if (txtCpf.length() != 11) {
			mensagem += "O cpf deve possuir 11 dígitos.\n";
		}
		if (txtCpf.isEmpty()) {
			mensagem += "O campo do cpf não foi preenchido.\n";
		}

		return mensagem;
	}

	public String cpfExistente(String txtCpf) {
		String mensagem = "";

		ClienteBO cliente = new ClienteBO();
		if (cliente.existeCpf(txtCpf)) {
			mensagem += "Este cpf já está sendo utilizado.\n";
		}
		return mensagem;
	}

	public List<Cliente> listarTodosOsClientes() {
		return bo.listarTodos();
	}

	public String excluirPorCpf(String txtCpf) {
		String mensagem = validarCpf(txtCpf);
		if (mensagem.isEmpty()) {
			ClienteBO bo = new ClienteBO();
			bo.excluir(txtCpf);
		}

		return mensagem;
	}

	public void Salvar(JTextField textNome, JTextField textRua, JTextField textBairro, JTextField textNumero,
			JTextField textTelefone, JTextField textEmail, JFormattedTextField textCPF, JFormattedTextField textCEP) {

	}

	public void gerarRelatorio(ArrayList<Cliente> clientes, String caminhoEscolhido) {

	}

}