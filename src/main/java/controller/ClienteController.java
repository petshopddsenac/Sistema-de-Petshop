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
			String textCpf, String textCep ) {
		Cliente cliente = new Cliente();
		String mensagem = "";
		cliente.setNome(textNome);
		cliente.setCpf(textRua);
		cliente.setRua(textRua);
		cliente.setNumero(textNumero);
		cliente.setBairro(textBairro);
		cliente.setNumero(textNumero);
		cliente.setDdd(textDDD);
		cliente.setTelefone(textTelefone);
		cliente.setEmail(textEmail);
		cliente.setCpf(textRua);
		cliente.setCep(textCep);
		
		return mensagem;
		
	}
	
	public String validar(String textNome, String textRua, String textBairro, String textNumero, String textDDD, String textTelefone, String textEmail,
			String textCPF, String textCEP) {
		
		
		if ((textNome == null) || (textNome.trim().length() < 3) || (textNome.trim().length() < 256)) {
			JOptionPane.showMessageDialog(null, "Nome precisa ter no mínimo 3 caracteres");
		}
		if ((textRua == null) || (textRua.trim().length() < 5) || (textRua.trim().length() < 256)) {
			JOptionPane.showMessageDialog(null, "A Rua deve conter no mínimo 5 caracteres");
		}
		if ((textBairro == null) || (textBairro.trim().length() < 5) || (textBairro.trim().length() < 101)) {
			JOptionPane.showMessageDialog(null, "O Bairro deve conter  no mínimo 5 caracteres ");
		}
		if ((textNumero == null) || (textNumero.trim().length() < 2)) {
			JOptionPane.showMessageDialog(null,"O número deve conter no mínimo 2 caracteres");
		}
		if ((textDDD == null) || (textDDD.trim().length() < 10)) {
			JOptionPane.showMessageDialog(null, "O DDD deve ter 2 caracteres ");
		}
		if ((textTelefone == null) || (textTelefone.trim().length() < 10)) {
			JOptionPane.showMessageDialog(null, "Telefone deve ter  9 caracteres ");
		}
		if ((textCPF == null) || (textCPF.trim().length() != 11)) {
			JOptionPane.showMessageDialog(null, "CPF contém somente 11 números");
		}
		if ((textCEP == null) || (textCEP.trim().length() != 8)) {
			JOptionPane.showMessageDialog(null, " O CEP contém 8 números");
		}
		if(textEmail == null)  {
			JOptionPane.showMessageDialog(null, "Informe um email válido");		
		}
		return null;
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
