package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class TelaListagemClientes extends JFrame {
	
	private JTable tblClientes;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "Nome", "CPF", "Rua", "DDD", "Número", "Bairro", "CEP", "Telefone", "Email" };
	private JTextField textNome;
	private JTextField txtCpf;


	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
			}
		
	private void atualizarTabelaClientes() {
		limparTabelaClientes();
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		for (Cliente c : clientes) {
			Object[] novaLinhaDaTabela = new Object[9];
			novaLinhaDaTabela[0] = c.getNome();
			novaLinhaDaTabela[1] = c.getCpf();
			novaLinhaDaTabela[2] = c.getRua();
			novaLinhaDaTabela[3] = c.getDdd();
			novaLinhaDaTabela[4] = c.getNumero();
			novaLinhaDaTabela[5] = c.getBairro();
			novaLinhaDaTabela[6] = c.getCep();
			novaLinhaDaTabela[7] = c.getEmail();
			novaLinhaDaTabela[8] = c.getTelefone();
			
			model.addRow(novaLinhaDaTabela);

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemClientes frame = new TelaListagemClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TelaListagemClientes() {
		setTitle("Listagem de Clientes");
		setBounds(100, 100, 1315, 520);
		getContentPane().setLayout(null);

		JButton btnBuscar = new JButton("Buscar!");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuscar.setBackground(new Color(0, 128, 0));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteSeletor seletor = new ClienteSeletor();
				seletor.setNome(textNome.getText());
				seletor.setCpf(txtCpf.getText());

				ClienteController controller = new ClienteController();
				clientes = controller.listarClientes(seletor);

				atualizarTabelaClientes();
			}
		});
		btnBuscar.setBounds(529, 19, 760, 97);
		getContentPane().add(btnBuscar);

		tblClientes = new JTable();
		tblClientes.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		tblClientes.setBounds(12, 177, 1277, 293);
		getContentPane().add(tblClientes);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(12, 30, 61, 16);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(90, 19, 302, 43);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(12, 84, 61, 16);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(90, 73, 302, 43);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClientes.setBounds(614, 146, 76, 28);
		getContentPane().add(lblClientes);

	}
}
