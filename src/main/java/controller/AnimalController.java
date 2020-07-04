package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import model.bo.AnimalBO;
import model.bo.ClienteBO;
import model.vo.Animal;
import model.vo.Cliente;

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

	public String validarCamposDigitados(String nomeDigitado, String racaDigitado, 
			String especieDigitado) {

		String mensagem = "";
		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3)
			mensagem += "Animal deve ter no minimo 3 letras";
		if (racaDigitado.isEmpty() || racaDigitado.trim().length() < 3)
			mensagem += "Raça do animal deve ter no minimo 3 letras";
		

		
		return mensagem;
	}

	public String salvar(JTextField textNomePet, JTextField textEspecie, JTextField textRaca,  JComboBox cbDonos, JTextField textPeso,
			JFormattedTextField TextDataN) {
		String mensagem = "";
		AnimalBO bo = new AnimalBO();
		Animal animal = criarAnimal(textNomePet, textEspecie, textRaca, cbDonos, textPeso, TextDataN);
		bo.salvar(animal);
		return mensagem;

		
		
	}

	private Animal criarAnimal(JTextField textNomePet, JTextField textEspecie, JTextField textRaca, JComboBox cbDonos,
			JTextField textPeso, JFormattedTextField textDataN) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Animal> buscarAnimalController() {
		
		
		
		AnimalBO animalBO = new AnimalBO();
		
		return animalBO.buscar();
	}
	
	public void preencherDono(JComboBox<Object> cbDono) {
		ClienteBO cliente = new ClienteBO();
		ArrayList<Cliente> clientes = cliente.listarTodos();
		cbDono.addItem("Selecione");
		for (Cliente dono : clientes) {
			cbDono.addItem((Cliente) dono);
			
		}
		
		
			
		}
	
	public Animal construirAnimal(JTextField textNomePet, JTextField textEspecie, JTextField textRaca,  JComboBox cbDonos, Double textPeso,  
			JFormattedTextField TextDataN  ) {
		String mensagem = cbDonos.toString();
		Cliente cliente = new Cliente();
		if (!mensagem.equalsIgnoreCase(mensagem)) {
			cliente = (Cliente) cbDonos.getSelectedItem();
		}
		
		Animal a = new Animal();
		a.setNome(textNomePet.getText());
		a.setEspecie(textEspecie.getText());
		a.setRaca(textRaca.getText());
		a.setPeso(textPeso);
		a.setDono(cliente);
		a.setDataNascimento(TextDataN.getText());
		return a;
				
	}
		
	
		
	}


