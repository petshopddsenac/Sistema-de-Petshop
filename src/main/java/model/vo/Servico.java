package model.vo;

public class Servico {
	
	private int id;
	private String nome;	
	private boolean necessitaConsulta;
	private double preco;
	
	
	public Servico() {
		super();
	
	}


	public Servico(int id, String nome, boolean necessitaConsulta, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.necessitaConsulta = necessitaConsulta;
		this.preco = preco;
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


	public boolean isNecessitaConsulta() {
		return necessitaConsulta;
	}


	public void setNecessitaConsulta(boolean necessitaConsulta) {
		this.necessitaConsulta = necessitaConsulta;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + ", necessitaConsulta=" + necessitaConsulta + ", preco=" + preco
				+ "]";
	}
	
	
	

}
