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
		}catch(NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

	private static final int TAMANHO_MINIMO = 3;
	private static final int TAMANHO_MAXIMO = 255;
	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_CEP = 8;
	
	
	

	public String Salvar(String Nome, String Rua, String Bairro,  String Numero, String Telefone,
			String email, String Cpf, String Cep) {
		String mensagem = "";
		mensagem += validarCampoDeTexto("Nome", Nome, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);
		mensagem += validarCampoDeTexto("Rua", Rua, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);
		mensagem += validarCampoDeTexto("Bairro", Bairro, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);
		mensagem += validarCampoDeTexto("Número", Numero, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);

		mensagem += validarCampoDeTexto("Telefone", Telefone, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);
		mensagem += validarCampoDeTexto("Email", email, TAMANHO_MINIMO, TAMANHO_MAXIMO, true);
		mensagem += validarCampoDeTexto("CPF", Cpf, 11, 11, true);
		mensagem += validarCampoDeTexto("CEP", Cep, 8, 8, true);

		
		

		if (mensagem.isEmpty()) {
			Cliente novoCliente = new Cliente(TAMANHO_MINIMO, Nome, Rua, Bairro, Numero, Telefone, email, Cpf, Cep);
			mensagem = bo.cadastrar(novoCliente);
		}

		return mensagem;
	}

	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo,
			boolean obrigatorio) {
		String mensagemValidacao = "";

		if (obrigatorio && valor != null && !valor.isEmpty() || valor.length() < tamanhoMinimo
				|| valor.length() > tamanhoMaximo) {
			mensagemValidacao = nomeDoCampo + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
					+ tamanhoMaximo + " caracteres \n";
		}

		return mensagemValidacao;
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
	
	public List<Cliente> listarTodosOsClientes(){
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