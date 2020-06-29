package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.seletor.ClienteSeletor;
import model.vo.Cliente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaListagemClientes extends JFrame {
	private JFrame frmListagemDeClientes;
	private JPanel contentPane;
	private ArrayList<Cliente> clientes;
	private JTable tblClientes;
	private String[] nomesColunas = { "Nome ", "CPF", "Rua", "Número", "CEP", "Bairro", "Telefone", "email" };
	private JTable tabelaClientes;
	private JTextField textNome;
	private JTextField textBairro;
	private JTable table;
	private JTextField textnome;
	private JTextField textbairro;

	private void atualizarTabelaClientes() {
		limparTabelaClientes();
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		for (Cliente c : clientes) {
			Object[] novaLinhaDaTabela = new Object[8];
			novaLinhaDaTabela[0] = c.getNome();
			novaLinhaDaTabela[1] = c.getCpf();
			novaLinhaDaTabela[2] = c.getRua();
			novaLinhaDaTabela[3] = c.getCep();
			novaLinhaDaTabela[4] = c.getBairro();
			novaLinhaDaTabela[5] = c.getNumero();
			novaLinhaDaTabela[6] = c.getTelefone();
			novaLinhaDaTabela[7] = c.getEmail();

			model.addRow(novaLinhaDaTabela);

		}
	}

	
	
	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
		
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
		setTitle("Lista de Cientes");
		frmListagemDeClientes = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(95, 165, 500, 275);
		contentPane.add(table);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 25, 45, 25);
		contentPane.add(lblNome);
		
		textnome = new JTextField();
		textnome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textnome.setBounds(65, 25, 290, 25);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(420, 25, 45, 25);
		contentPane.add(lblBairro);
		
		textbairro = new JTextField();
		textbairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textbairro.setBounds(465, 25, 200, 25);
		contentPane.add(textbairro);
		textbairro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteSeletor seletor = new ClienteSeletor();
				seletor.setNome(textNome.getText());
				seletor.setBairro(textBairro.getText());

				ClienteController controller = new ClienteController();
				clientes = controller.listarClientes(seletor);
				
				atualizarTabelaClientes();

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(255, 110, 85, 30);
		contentPane.add(btnBuscar);
		
		tblClientes = new JTable();
		this.limparTabelaClientes();
		
		
		
		
		frmListagemDeClientes.getContentPane().add(tblClientes);
	
		
	}
	
}
