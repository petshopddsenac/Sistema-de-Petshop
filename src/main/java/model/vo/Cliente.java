package model.vo;

import java.util.ArrayList;

public class Cliente extends Pessoa {

	private int id;
	private ArrayList<Animal> Pets;
	
	

	
	public Cliente(int id, String nome, String cpf, String rua, String ddd, String numero, String bairro, String cep,
			String email, String telefone, int id2, ArrayList<Animal> pets) {
		super(id, nome, cpf, rua, ddd, numero, bairro, cep, email, telefone);
		id = id2;
		Pets = pets;
	}




	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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
