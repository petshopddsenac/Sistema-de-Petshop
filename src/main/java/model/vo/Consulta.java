package model.vo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Consulta {

	private int id;
	private ArrayList< Cliente> clientes;
	private Animal animal;
	private ArrayList<Funcionario> funcionarios;
	private  ArrayList <Servico> servicos;
	private Date dataServico;
	private Time horaServico;
	private String diagnostico;
	
	
	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Consulta(int id, ArrayList<Cliente> clientes, Animal animal, ArrayList<Funcionario> funcionarios,
			ArrayList<Servico> servicos, Date dataServico, Time horaServico, String diagnostico) {
		super();
		this.id = id;
		this.clientes = clientes;
		this.animal = animal;
		this.funcionarios = funcionarios;
		this.servicos = servicos;
		this.dataServico = dataServico;
		this.horaServico = horaServico;
		this.diagnostico = diagnostico;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public ArrayList<Servico> getServicos() {
		return servicos;
	}


	public void setServicos(ArrayList<Servico> servicos) {
		this.servicos = servicos;
	}


	public Date getDataServico() {
		return dataServico;
	}


	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}


	public Time getHoraServico() {
		return horaServico;
	}


	public void setHoraServico(Time horaServico) {
		this.horaServico = horaServico;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	@Override
	public String toString() {
		return "Consulta [id=" + id + ", clientes=" + clientes + ", animal=" + animal + ", funcionarios=" + funcionarios
				+ ", servicos=" + servicos + ", dataServico=" + dataServico + ", horaServico=" + horaServico
				+ ", diagnostico=" + diagnostico + "]";
	}
	
	
	
}