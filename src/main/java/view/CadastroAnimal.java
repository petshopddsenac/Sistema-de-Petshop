package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastroAnimal extends JFrame {
	private JTextField textNomePet;
	private JTextField textEspecie;
	private JTextField textRaca;
	private JTextField textPeso;
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
		
		setBounds(100, 100, 500, 360);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 15, 40, 25);
		getContentPane().add(lblNome);
		
		textNomePet = new JTextField();
		textNomePet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomePet.setBounds(70, 15, 175, 25);
		getContentPane().add(textNomePet);
		textNomePet.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Espécie: ");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecie.setBounds(10, 55, 50, 25);
		getContentPane().add(lblEspecie);
		
		textEspecie = new JTextField();
		textEspecie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEspecie.setBounds(70, 55, 175, 25);
		getContentPane().add(textEspecie);
		textEspecie.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça: ");
		lblRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaca.setBounds(10, 90, 40, 25);
		getContentPane().add(lblRaca);
		
		textRaca = new JTextField();
		textRaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRaca.setBounds(70, 90, 175, 25);
		getContentPane().add(textRaca);
		textRaca.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento: ");
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataNascimento.setBounds(10, 200, 120, 25);
		getContentPane().add(lblDataNascimento);
		
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			JFormattedTextField  formattedTextDataNascimento = new JFormattedTextField (mascaraData);
			formattedTextDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			formattedTextDataNascimento.setBounds(130, 200, 115, 25);
			getContentPane().add(formattedTextDataNascimento);
		}catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setBounds(10, 165, 40, 25);
		getContentPane().add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPeso.setBounds(70, 165, 85, 25);
		getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
				
		JLabel lblDono = new JLabel("Dono: ");
		lblDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDono.setBounds(10, 125, 40, 25);
		getContentPane().add(lblDono);
		
		textDono = new JTextField();
		textDono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDono.setBounds(70, 125, 175, 25);
		getContentPane().add(textDono);
		textDono.setColumns(10);
		
		JButton btnCadastrar = new JButton("Limpar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(110, 280, 85, 30);
		getContentPane().add(btnCadastrar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(240, 280, 85, 30);
		getContentPane().add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 15, 10, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(50, 90, 10, 20);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(50, 157, 10, 20);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(50, 125, 10, 20);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(120, 200, 10, 20);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(50, 49, 10, 20);
		getContentPane().add(label_4);
		
		JLabel lblObrigatorio = new JLabel("* Campos Obrigatorios");
		lblObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObrigatorio.setBounds(35, 235, 135, 20);
		getContentPane().add(lblObrigatorio);

	}
}
