package model.seletor;

import java.util.ArrayList;

import model.vo.Servico;

public class FuncionarioSeletor {
	
	private int idFuncionario;
	private String nome;
	private String cargo;
	private double salario;
		

	private int limite;
	private int pagina;
	
	public FuncionarioSeletor() {

		this.limite = 0;
		this.pagina = -1;
		
		}
	
	public boolean temFiltro() {
		if(this.idFuncionario>0) {
		return true;
	
	}
		if((this.nome!= null) && (this.nome.trim().length() >0)){
			return true;
		}
		if((this.cargo != null) && (this.cargo.trim().length()>0)) {
			return true;
		}
		if(this.salario >0) {
			return true;
		}
		return false;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
}
