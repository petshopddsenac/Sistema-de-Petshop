package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
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
			String especieDigitado, String pesoDigitado, String idadeDigitada) {

		String mensagem = "";
		Double peso = Double.parseDouble(pesoDigitado);
		Double idade = Double.parseDouble(idadeDigitada);
		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3)
		       mensagem = JOptionPane.showInputDialog("Animal deve ter no minimo 3 letras");
		if (racaDigitado.isEmpty() || racaDigitado.trim().length() < 3)
			mensagem = mensagem = JOptionPane.showInputDialog("Raça do animal deve ter no minimo 3 letras");
		if (especieDigitado.isEmpty() || especieDigitado.trim().length() < 3)
			mensagem = JOptionPane.showInputDialog("A espécie do animal deve conter no mínimo 4 letras");
		if(pesoDigitado.isEmpty()) {
			mensagem = JOptionPane.showInputDialog("Digite o peso do animal");
		}
		if(idadeDigitada.isEmpty()) {
			mensagem = JOptionPane.showInputDialog("Digite a idade do animal");
		}
		return mensagem;

	}
		

		

	public Animal salvar() {
		String mensagem = "";
	Animal animal = new Animal();
	if((animal.getNome() !=null) && animal.getNome().isEmpty()) {
		if ((animal.getEspecie() !=null) && animal.getEspecie().isEmpty()){
		if((animal.getRaca() !=null) && animal.getRaca().isEmpty()) {	
			if(animal.getPeso()!=null){
			if(animal.getIdade()!=null) {
				if(animal.getDono()!=null) {
					
				}
			}
			}
			
		}
		}
	}
	return animal;
	
		
		
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
		cbDono.addItem(cliente);
		for (Cliente dono : clientes) {
			cbDono.addItem((Cliente) dono);
			
		}
		
		
			
		}
	
	public Animal construirAnimal(JTextField textNomePet, JTextField textEspecie, JTextField textRaca,  JComboBox cbDonos, Double textPeso,  
			JTextField TextIdade, Double Idade  ) {
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
		a.setIdade(Idade);
		return a;
				
	}
		public void excluirAnimal(int id) {
		AnimalBO bo = new AnimalBO();
		bo.excluirPorId( id);
	}
	
		
	}


