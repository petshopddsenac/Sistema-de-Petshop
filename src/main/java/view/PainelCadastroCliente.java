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

public class PainelCadastroCliente extends JInternalFrame {
	private JTextField textNome;
	private JTextField textField_1;
	private JTextField textBairro;
	private JTextField textField_3;
	private JTextField textTelefone;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelCadastroCliente frame = new PainelCadastroCliente();
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
	public PainelCadastroCliente() {
		setTitle("Menu Cadastro Cliente");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 585, 355);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 45, 25);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(65, 10, 355, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 45, 45, 20);
		getContentPane().add(lblCpf);
		
	try {
		MaskFormatter mascaracpf = new MaskFormatter("###.###.###-##");
		JFormattedTextField formattedTextCPF = new JFormattedTextField(mascaracpf);
		formattedTextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextCPF.setBounds(65, 45, 200, 25);
		getContentPane().add(formattedTextCPF);
	}catch (ParseException e1){
		e1.printStackTrace();
		
	}
		
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 75, 45, 25);
		getContentPane().add(lblRua);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setBounds(65, 75, 355, 25);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 110, 50, 25);
		getContentPane().add(lblNumero);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBairro.setBounds(65, 150, 200, 25);
		getContentPane().add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(223, 110, 30, 25);
		getContentPane().add(lblCep);
		
		try {
			MaskFormatter  mascaraCep = new MaskFormatter("#####-###");
		JFormattedTextField formattedTextCEP = new JFormattedTextField(mascaraCep);
		formattedTextCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextCEP.setBounds(260, 110, 160, 25);
		getContentPane().add(formattedTextCEP);
		}catch(ParseException e1) {
			e1.printStackTrace();
			
		}
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 150, 45, 25);
		getContentPane().add(lblBairro);
		
		textField_3 = new JTextField();
		textField_3.setBounds(65, 110, 125, 25);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 185, 50, 25);
		getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(65, 185, 200, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 225, 45, 25);
		getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(65, 225, 200, 25);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(150, 270, 85, 30);
		getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(276, 270, 85, 30);
		getContentPane().add(btnSalvar);

	}
}
