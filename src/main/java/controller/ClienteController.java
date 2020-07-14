package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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

	public String cadastrarCliente(String textNome, String textRua, String textBairro, String textNumero, String textDDD,  String textTelefone, String textEmail,
			String txtCpf, String txtCep ) {
		Cliente cliente = new Cliente();
		String mensagem = "";
		cliente.setNome(textNome);
		cliente.setCpf(txtCpf.trim().replaceAll("[^0-9]", ""));
		cliente.setRua(textRua);
		cliente.setDdd(textDDD);
		cliente.setNumero(textNumero);
		cliente.setBairro(textBairro);
		cliente.setCep(txtCep.trim().replaceAll("[^0-9]", ""));
		cliente.setEmail(textEmail);
		cliente.setTelefone(textTelefone);
		
		
		
		mensagem += validar(cliente);
		
		if (mensagem.trim().isEmpty()) {
			cliente = bo.cadastrarCliente(cliente);
		}
		
		if (mensagem.trim().isEmpty()) {
			mensagem += "O Cliente foi cadastrado com sucesso!";
		}
		return mensagem;
		
	}
	
	public String validar(Cliente cliente) {
		
		String mensagem = "";
		
		if ((cliente.getNome() == null) || (cliente.getNome().trim().length() < 3) || (cliente.getNome().trim().length() > 255)) {
			mensagem +=  "- O Nome precisa deve ter entre 3 e 255 caracteres; " + "\n";	
		}
		if ((cliente.getRua() == null) || (cliente.getRua().trim().length() < 5) || (cliente.getRua().trim().length() > 255)) {
			mensagem +=  "- A Rua deve ter entre 5 e 255 caracteres; " + "\n";
		}
		if ((cliente.getBairro() == null) || (cliente.getBairro().trim().length() < 3) || (cliente.getBairro().trim().length() > 100)) {
			mensagem +=  "- O Bairro deve ter entre 5 e 100 caracteres; " + "\n";
		}
		if ((cliente.getNumero() == null) || (cliente.getNumero().trim().length() < 2) || (cliente.getNumero().trim().length() > 50)){
			mensagem +=  "- O Número deve ter entre 2 e 50 caracteres caracteres; " + "\n";
		}
		if ((cliente.getDdd() == null) || (cliente.getDdd().trim().length() != 2)) {
			mensagem +=  "- O DDD deve ter 2 caracteres; " + "\n";
		}
		if ((cliente.getTelefone() == null) || (cliente.getTelefone().trim().length() < 8) || (cliente.getTelefone().trim().length() > 9)) {
			mensagem +=  "- Telefone deve ter 8 ou 9 caracteres; " + "\n";
		}
		if ((cliente.getCpf() == null) || (cliente.getCpf().length() != 11)) {
			mensagem +=  "- O CPF deve conver 11 números; " + "\n";
		}
		if ((cliente.getCep() == null) || (cliente.getCep().length() != 8)) {
			mensagem +=  "- O CEP deve conter 8 números; " + "\n";
		}
		if(cliente.getEmail() == null)  {
			mensagem +=  "- Informe um email válido.";		
		}
		return mensagem;
	}
	
	public static boolean isValidEmailAddressRegex(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
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

	public String excluirCliente(String TextNome) {
		String mensagem = "";
		Cliente cliente = new Cliente();
		cliente.getNome();
		if(cliente.getNome().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Informe um nome" );
		}
		return mensagem;
	}
	
	public void Salvar(JTextField textNome, JTextField textRua, JTextField textBairro, JTextField textNumero,
			JTextField textTelefone, JTextField textEmail, JFormattedTextField textCPF, JFormattedTextField textCEP) {

	}

	public void gerarRelatorio(ArrayList<Cliente> clientes, String caminhoEscolhido) {

	}

	public String cadastrarCliente(JTextField textNome, JTextField textRua, JTextField textBairro,
			JTextField textNumero, JTextField textTelefone, JTextField textEmail, JFormattedTextField textCPF,
			JFormattedTextField textCEP) {
	
		return null;
	}
	
	public String alterar(String textNome, String textRua, String textBairro, String textNumero, String  textTelefone, String  textemail,
			String  textCpf, String  textCep) {
		Cliente clienteAlterado = new Cliente();
		String mensagem = "";
		clienteAlterado.setNome(textNome);
		clienteAlterado.setRua(textRua);
		clienteAlterado.setNumero(textNumero);
		clienteAlterado.setBairro(textBairro);
		clienteAlterado.setTelefone(textTelefone);
		clienteAlterado.setEmail(textemail);
		clienteAlterado.setCpf(textCpf);
		clienteAlterado.setCep(textCep);
		return mensagem;
		
		
	}
	public String alterarCliente(Cliente clienteAlterado) {
		String mensagem = "";
		
		if((clienteAlterado==null ) || clienteAlterado.getNome().isEmpty()) {
			mensagem =  JOptionPane.showInputDialog("Digite um nome");
		}
		
		if((clienteAlterado== null ) || clienteAlterado.getRua().isEmpty()) {
			mensagem = JOptionPane.showInputDialog("Digite o nome da rua");
		}
		if((clienteAlterado== null) || clienteAlterado.getNumero().isEmpty()) {
			mensagem = JOptionPane.showInputDialog("Digite o número do imóvel");
		}
		if((clienteAlterado == null)|| clienteAlterado.getCep().isEmpty()){
		mensagem = JOptionPane.showInputDialog("Informe o CEP do Bairro");	
		}
		if((clienteAlterado ==null) || clienteAlterado.getCpf().trim().isEmpty()) {
			mensagem = JOptionPane.showInputDialog( "Informe um número de CPF váido");
		}
		
		if((clienteAlterado==null) || clienteAlterado.getTelefone().isEmpty()) {
			mensagem = JOptionPane.showInputDialog("Informe um telefone para contato") ;
			
		}
		
		
		return mensagem;
		
	}

	}
