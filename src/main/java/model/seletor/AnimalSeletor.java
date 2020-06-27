package model.seletor;

import java.sql.Date;

import model.vo.Cliente;

public class AnimalSeletor {

	private int idAnimal;
	private String especie;
	private String raca;
	private Cliente Dono;

	private int limite;
	private int pagina;

	public AnimalSeletor() {

		this.limite = 0;
		this.pagina = -1;
	}

	public boolean temFiltro() {
		if (this.idAnimal > 0) {
			return true;
		}
		if (this.Dono != null) {
			return true;
		}
		if ((this.raca != null) && (this.raca.trim().length() > 0)) {
			return true;
		}

		if ((this.especie != null) && (this.especie.trim().length() > 0)) {
			return true;
		}
		return false;

	}

	public boolean temPaginacao() {
		return ((this.limite > 0) && (this.pagina > -1));
	}

	public int getOffset() {
		return (this.limite * (this.pagina - 1));
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
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

	public Cliente getDono() {
		return Dono;
	}

	public void setDono(Cliente dono) {
		Dono = dono;
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
