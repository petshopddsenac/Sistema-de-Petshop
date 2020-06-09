package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.dao.ClienteDAO;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;

public class ClienteController {
	private ClienteDAO dao = new ClienteDAO();
	private ClienteBO bo = new ClienteBO();
	
	private static final int TAMANHO_MINIMO =3;
	private static final int TAMANHO_MAXIMO =255;
	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_CEP = 8;
	
	
	public String salvar(String Nome, String Rua, String Cpf, String Bairro, String Cep, String Numero, String Telefone, String email) {
		String mensagem = "";
		mensagem += validarCampoDeTexto("Nome", Nome, TAMANHO_MINIMO, TAMANHO_MAXIMO);
		mensagem +=  validarCampoDeTexto("Rua", Rua,TAMANHO_MINIMO, TAMANHO_MAXIMO );
		mensagem +=  validarCampoDeTexto("Bairro", Bairro,TAMANHO_MINIMO, TAMANHO_MAXIMO );
		mensagem +=  validarCampoDeTexto("Número", Numero,TAMANHO_MINIMO, TAMANHO_MAXIMO );
		mensagem +=  validarCampoDeTexto("Telefone",Telefone,TAMANHO_MINIMO, TAMANHO_MAXIMO );
		mensagem +=  validarCampoDeTexto("Email", email,TAMANHO_MINIMO, TAMANHO_MAXIMO );
		mensagem +=  validarCampoDeTexto("CPF", Cpf,11,11 );
		mensagem +=  validarCampoDeTexto("CEP", Cep,8,8 );
		
		
		return mensagem;	
		}
		
		
		
	
	
	

	

	private String validarCampoDeTexto(String string, String nome, int tamanhoMinimo, int tamanhoMaximo) {
		
		return null;
	}



	public ArrayList<Cliente> listarClientes(ClienteSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}

}