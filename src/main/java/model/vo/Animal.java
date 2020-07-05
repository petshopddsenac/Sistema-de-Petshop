package model.vo;

import java.sql.Date;

public class Animal {
	
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private Double idade;
	private Double peso;
	private Cliente dono;
	
	
	public Animal() {
		super();
		
	}


	public Animal(int id, String nome, String especie, String raca, Double idade, Double peso, Cliente dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
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


	public Double getIdade() {
		return idade;
	}


	public void setIdade(Double idade) {
		this.idade = idade;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
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
		return "Animal [id=" + id + ", nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", idade=" + idade
				+ ", peso=" + peso + ", dono=" + dono + "]";
	}


	
}
