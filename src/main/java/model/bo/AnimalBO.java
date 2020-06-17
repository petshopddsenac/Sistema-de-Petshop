package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.AnimalDAO;
import model.seletor.AnimalSeletor;
import model.vo.Animal;
import model.seletor.AnimalSeletor;

public class AnimalBO {

	AnimalDAO dao = new AnimalDAO();

	public boolean inserir(Animal animal) {
		int idGerado = dao.inserir(animal);

		return idGerado > 0;

	}

	public model.vo.Animal biscarAnimalporId(String textoid) {

		Animal ProdutoBuscado = dao.obterPorId(Integer.parseInt(textoid));

		return ProdutoBuscado;

	}
	
	public boolean atualizar(Animal animal) {
		boolean sucesso = dao.atualizar(animal);
		return sucesso;
	}
	
	public List<Animal> listarProdutos() {
		ArrayList<Animal> produtos = dao.listarTodos();
		return produtos;
	}

	
	public void gerarPlanilha(List<Animal> animal, String caminhoEscolhido) {
		//TODO
	}

	public List<Animal> listarProdutos(AnimalSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}
}


