package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AnimalController;
import model.vo.Animal;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class TelaListagemAnimais extends JFrame {

	private JFrame frmListagem;
	private JTable tblAnimais;
	private ArrayList<Animal> animais;
	private String[] nomesColuna = { "ID", "NOME", "ESPECIE", "RAÇA", "DATA NASCIMENTO", "PESO" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemAnimais window = new TelaListagemAnimais();
					window.frmListagem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagemAnimais() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListagem = new JFrame();
		frmListagem.setTitle("Listagem de Animais");
		frmListagem.setBounds(100, 100, 743, 392);
		frmListagem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmListagem.getContentPane().setLayout(null);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AnimalController controladora = new AnimalController();
				animais = controladora.buscarAnimalController();

				AtualizarTabelaAnimal();

			}
		});
		btnBuscar.setBounds(316, 21, 89, 23);
		frmListagem.getContentPane().add(btnBuscar);

		tblAnimais = new JTable();
		tblAnimais.setModel(new DefaultTableModel(
				new String[][] { { "ID", "NOME", "ESPECIE", "RAÇA", "DATA NASCIMENTO", "PESO" }, },
				new String[] { "ID", "NOME", "ESPECIE", "RAÇA", "DATA NASCIMENTO", "PESO" }));
		tblAnimais.setBounds(10, 69, 726, 287);
		frmListagem.getContentPane().add(tblAnimais);
	}

	private void limparTabelaAnimal() {
		tblAnimais.setModel(new DefaultTableModel(new Object[][] { nomesColuna, }, nomesColuna));
	}

	protected void AtualizarTabelaAnimal() {

		limparTabelaAnimal();

		DefaultTableModel model = (DefaultTableModel) tblAnimais.getModel();

		for (Animal a : animais) {

			Object[] novaLinhaTabela = new Object[6];
			novaLinhaTabela[0] = a.getId();
			novaLinhaTabela[1] = a.getNome();
			novaLinhaTabela[2] = a.getEspecie();
			novaLinhaTabela[3] = a.getRaca();
			novaLinhaTabela[4] = a.getIdade();
			novaLinhaTabela[5] = a.getPeso();

			model.addRow(novaLinhaTabela);

		}
	}

}
