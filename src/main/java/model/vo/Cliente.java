package model.vo;

import java.util.ArrayList;

public class Cliente extends Pessoa {

	private int id;
	private ArrayList<Animal> Pets;
	
	
	public Cliente() {
		super();
		
	}
	public Cliente(int id, String nome, String cpf, String rua, String numero, String bairro, String cep, String email,
			String telefone) {
		super(id, nome, cpf, rua, numero, bairro, cep, email, telefone);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Animal> getPets() {
		return Pets;
	}
	public void setPets(ArrayList<Animal> pets) {
		Pets = pets;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", Pets=" + Pets + "]";
	}
	
	
	
}
