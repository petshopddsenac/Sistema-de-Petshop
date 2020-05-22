package model.vo;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	
	private int id;
	private String cargo;
	private double salario;
	private ArrayList<Servico> servicos;
	
	public Funcionario() {
		super();
		
	}
	public Funcionario(int id, String nome, String cpf, String rua, String numero, String bairro, String email,
			String telefone) {
		super(id, nome, cpf, rua, numero, bairro, email, telefone);
		
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
	
	
		
}
