package model.vo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

public class Consulta {

	private int id;
	private Cliente cliente;
	private Animal animal;
	private Funcionario funcionario;
	private Servico servico;
	private Date dataConsulta;
	private Time horaConsulta;
	private String diagnostico;
	

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(int id, Cliente cliente, Animal animal, Funcionario funcionario, Servico servico,
			Date dataConsulta, Time horaConsulta, String diagnostico) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.animal = animal;
		this.funcionario = funcionario;
		this.servico = servico;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.diagnostico = diagnostico;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public Date getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public Time getHoraConsulta() {
		return horaConsulta;
	}


	public void setHoraConsulta(Time horaConsulta) {
		this.horaConsulta = horaConsulta;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	@Override
	public String toString() {
		return "Consulta [id=" + id + ", clientes=" + cliente + ", animal=" + animal + ", funcionarios=" + funcionario
				+ ", servicos=" + servico + ", dataServico=" + dataConsulta + ", horaServico=" + horaConsulta
				+ ", diagnostico=" + diagnostico + "]";
	}
	
	
	
}