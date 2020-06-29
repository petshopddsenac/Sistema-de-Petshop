package controller;

import java.util.ArrayList;
import java.util.List;

import model.bo.AnimalBO;

import model.vo.Animal;

public class AnimalController {

	public void inserirAnimalController(Animal animalVO) {
		AnimalBO animalBO = new AnimalBO();
		animalBO.inserir(animalVO);
	}

	public void buscarAnimalController(Animal animalVO) {
		AnimalBO animalBO = new AnimalBO();
		animalBO.buscarAnimalporId(animalVO);

	}

	public void atualizarAnimalController(Animal animalVO) {
		AnimalBO animalBO = new AnimalBO();
		animalBO.atualizar(animalVO);
	}

	public ArrayList<Animal> listarTodosAnimal() {
		AnimalBO animalBO = new AnimalBO();
		return animalBO.listarAnimal();
	}

	public String validarCamposDigitados(String nomeDigitado, String racaDigitado, String donoDigitado,
			String especieDigitado) {

		String mensagem = "";
		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3)
			mensagem += "Animal deve ter no minimo 3 letras";
		if (racaDigitado.isEmpty() || racaDigitado.trim().length() < 3)
			mensagem += "Raça do animal deve ter no minimo 3 letras";
		if (donoDigitado.isEmpty() || donoDigitado.trim().length() < 3) {
			mensagem += "O nome do Dono do animal deve ter no minimo 3 letras";

		}
		return mensagem;
	}

	public Animal salvar(Animal animal) {

		return AnimalBO.salvar(animal);
	}

	public ArrayList<Animal> buscarAnimalController() {
		
		
		
		AnimalBO animalBO = new AnimalBO();
		
		return animalBO.buscar();
	}

}
