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


	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", dataNascimento="
				+ dataNascimento + ", peso=" + peso + ", dono=" + dono + "]";
	}
	
	

}
