package model.vo;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	
	private int id;
	private Animal animal;
	private Pessoa pessoa;
	private String cargo;
	private double salario;
	private ArrayList<Servico> servicos;
	private String cpf;
	public Funcionario() {
		super();
		

		
	}

	public Funcionario(int id,Animal animal,Pessoa pessoa, String nome, String cpf, String rua, String numero, String bairro, String cep,
			String email, String telefone) {
		super(id, nome, cpf, rua, numero, bairro, cep, email, telefone);
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cargo=" + cargo + ", salario=" + salario + ", servicos=" + servicos + "]";
	}

	public Funcionario(int id, String cargo, double salario, ArrayList<Servico> servicos, String cpf) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.salario = salario;
		this.servicos = servicos;
		this.cpf = cpf;
	}
	
		
}
