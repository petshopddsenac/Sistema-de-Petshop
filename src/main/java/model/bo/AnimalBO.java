package model.bo;
import java.util.ArrayList;
import java.util.List;
import model.dao.AnimalDAO;
import model.dao.GeradorPlanilha;
import model.seletor.AnimalSeletor;
import model.vo.Animal;



public class AnimalBO {

	AnimalDAO dao = new AnimalDAO();

	public boolean inserir(Animal animalVO) {
		int idGerado = dao.inserir(animalVO);

		return idGerado > 0;

	}

	public Animal buscarAnimalporId(Animal animalVO) {
		AnimalDAO animalDAO = new AnimalDAO();
		Animal animal = animalDAO.obterPorId(animalVO.getId());
		if (animal == null) {
			System.out.println("\nAnimal não Localizado.");
		}
		return animal;
	}

	
	
	public boolean atualizar(Animal animal) {
		boolean sucesso = dao.atualizar(animal);
		return sucesso;
	}
	
	public ArrayList<Animal> listarAnimal() {
		ArrayList<Animal> animal = dao.listarTodos();
		return animal;
	}

	
	public void gerarPlanilha(List<Animal> animal, String caminhoEscolhido) {
		GeradorPlanilha gerador = new GeradorPlanilha();
		gerador.gerarPlanilhaAnimais(caminhoEscolhido, animal);
	}
		

	public List<Animal> listarAnimais(AnimalSeletor seletor) {
		return dao.listarComSeletor(seletor);
	}

	public static Animal salvar(Animal animal) {
		AnimalDAO animalDAO = new AnimalDAO();
		
		
		return animalDAO.salvar1(animal);
	}

	public ArrayList<Animal> buscar() {
		AnimalDAO animalDAO = new AnimalDAO();
		
		return animalDAO.buscar();
	}

	public void excluirPorId(int id) {
	
		AnimalDAO dao = new AnimalDAO();
		 dao.excluir(id);
		
}
}


