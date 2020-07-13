package model.vo;

import java.util.ArrayList;

public class Cliente extends Pessoa {

	private int id;
	private String cpf;
	private String rua;
	private String ddd;
	private String telefone;
	private String numero;
	private String bairro;
	private String cep;
	private String email;
	private ArrayList<Animal> Pets;

	public Cliente(int id, String nome, String cpf, String rua, String ddd, String numero, String bairro, String cep,
			String email, String telefone, int id2, String cpf2, String rua2, String ddd2, String telefone2,
			String numero2, String bairro2, String cep2, String email2, ArrayList<Animal> pets) {
		super(id, nome, cpf, rua, ddd, numero, bairro, cep, email, telefone);
		id = id2;
		cpf = cpf2;
		rua = rua2;
		ddd = ddd2;
		telefone = telefone2;
		numero = numero2;
		bairro = bairro2;
		cep = cep2;
		email = email2;
		Pets = pets;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Animal> getPets() {
		return Pets;
	}

	public void setPets(ArrayList<Animal> pets) {
		Pets = pets;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", rua=" + rua + ", ddd=" + ddd + 
				"telefone =" + telefone + ", numero=" + numero + ", bairro=" + bairro + 
				", cep=" + cep +  ", email=" + email + ", pets=" + Pets + "]";
	}
	
	
	
}
