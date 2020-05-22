package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAnimal extends JInternalFrame {
	private JTextField textNomePet;
	private JTextField textEspecie;
	private JTextField textRaca;
	private JTextField textField;
	private JTextField textDono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAnimal frame = new CadastroAnimal();
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
	public CadastroAnimal() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 465, 335);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 15, 45, 25);
		getContentPane().add(lblNome);
		
		textNomePet = new JTextField();
		textNomePet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomePet.setBounds(65, 15, 175, 25);
		getContentPane().add(textNomePet);
		textNomePet.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Espécie: ");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecie.setBounds(10, 55, 55, 25);
		getContentPane().add(lblEspecie);
		
		textEspecie = new JTextField();
		textEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEspecie.setBounds(65, 55, 175, 25);
		getContentPane().add(textEspecie);
		textEspecie.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça: ");
		lblRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaca.setBounds(10, 90, 45, 25);
		getContentPane().add(lblRaca);
		
		textRaca = new JTextField();
		textRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRaca.setBounds(65, 90, 175, 25);
		getContentPane().add(textRaca);
		textRaca.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento: ");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataNascimento.setBounds(10, 200, 120, 25);
		getContentPane().add(lblDataNascimento);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setBounds(10, 130, 45, 25);
		getContentPane().add(lblPeso);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(65, 130, 85, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JFormattedTextField formattedTextDataNascimento = new JFormattedTextField();
		formattedTextDataNascimento.setBounds(150, 200, 125, 25);
		getContentPane().add(formattedTextDataNascimento);
		
		JLabel lblDono = new JLabel("Dono: ");
		lblDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDono.setBounds(10, 165, 45, 25);
		getContentPane().add(lblDono);
		
		textDono = new JTextField();
		textDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDono.setBounds(65, 165, 175, 25);
		getContentPane().add(textDono);
		textDono.setColumns(10);
		
		JButton btnCadastrar = new JButton("Limpar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(110, 260, 85, 30);
		getContentPane().add(btnCadastrar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(240, 260, 85, 30);
		getContentPane().add(btnSalvar);

	}

}
