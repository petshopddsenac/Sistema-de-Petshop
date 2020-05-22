package model.vo;

import java.util.ArrayList;

public class Cliente extends Pessoa {

	private int id;
	private ArrayList<Animal> Pets;
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(int id, ArrayList<Animal> pets) {
		super();
		this.id = id;
		Pets = pets;
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
