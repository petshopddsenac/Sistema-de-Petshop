package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PainelCadastrarAnimal extends JInternalFrame {
	private JTextField textNome;
	private JTextField textEspecie;
	private JTextField textRaca;
	private JTextField textPeso;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelCadastrarAnimal frame = new PainelCadastrarAnimal();
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
	public PainelCadastrarAnimal() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 515, 350);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 45, 25);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(70, 10, 164, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Espécie:");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecie.setBounds(10, 55, 55, 25);
		getContentPane().add(lblEspecie);
		
		textEspecie = new JTextField();
		textEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEspecie.setBounds(70, 55, 164, 25);
		getContentPane().add(textEspecie);
		textEspecie.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça:");
		lblRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaca.setBounds(10, 90, 45, 25);
		getContentPane().add(lblRaca);
		
		textRaca = new JTextField();
		textRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRaca.setBounds(70, 90, 165, 25);
		getContentPane().add(textRaca);
		textRaca.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setBounds(10, 170, 45, 25);
		getContentPane().add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPeso.setBounds(70, 165, 100, 25);
		getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(10, 210, 115, 25);
		getContentPane().add(lblDataDeNascimento);
		
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
		
		JFormattedTextField formattedTextDataNascimento = new JFormattedTextField(mascaraData);
		formattedTextDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextDataNascimento.setBounds(135, 210, 105, 25);
		getContentPane().add(formattedTextDataNascimento);
		}catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(115, 265, 85, 30);
		getContentPane().add(btnLimpar);
		
		JButton Salvar = new JButton("Salvar");
		Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Salvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Salvar.setBounds(230, 265, 85, 30);
		getContentPane().add(Salvar);
		
		JLabel lblDono = new JLabel("Dono:");
		lblDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDono.setBounds(10, 125, 46, 25);
		getContentPane().add(lblDono);
		
		textField = new JTextField();
		textField.setBounds(70, 125, 165, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
