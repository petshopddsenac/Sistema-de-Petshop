package model.vo;

public class Pessoa {
	
	private int id;
	private String nome;
	private String cpf;
	private String rua;
	private int ddd;
	private String numero;
	private String bairro;
	private String cep;
	private String email;
	private String telefone;
	


	public Pessoa(int id, String nome, String cpf, String rua, int ddd, String numero, String bairro, String cep,
			String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rua = rua;
		this.ddd = ddd;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.email = email;
		this.telefone = telefone;
	}



	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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



	public int getDdd() {
		return ddd;
	}



	public void setDdd(int ddd) {
		this.ddd = ddd;
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



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", email=" + email + ", ddd=" + ddd + ", telefone=" + telefone + "]";
	}
	
	
}
