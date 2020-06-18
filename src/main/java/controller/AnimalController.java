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
	
	public ArrayList<Animal> listarTodosAnimal (){
		AnimalBO animalBO = new AnimalBO();
		return animalBO.listarAnimal();
	}
	
	
	
	
	
	}









