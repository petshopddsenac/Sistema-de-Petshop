package model.vo;

import java.sql.Date;

public class Animal {
	
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private Date dataNascimento;
	private String peso;
	private Cliente dono;
	
	
	public Animal() {
		super();
		
	}


	public Animal(int id, String nome, String especie, String raca, Date dataNascimento, String peso, Cliente dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
		this.dono = dono;
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


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public Cliente getDono() {
		return dono;
	}


	public void setDono(Cliente dono) {
		this.dono = dono;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", dataNascimento="
				+ dataNascimento + ", peso=" + peso + ", dono=" + dono + "]";
	}
	
	

}
