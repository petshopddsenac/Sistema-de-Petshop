package model.vo;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	
	private int id;
	private String cargo;
	private double salario;
	private ArrayList<Servico> servicos;
	private String cpf;
	public Funcionario() {
		super();
		

		
	}

	public Funcionario(int id, String nome, String cpf, String rua, String numero, String bairro, String cep,
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
