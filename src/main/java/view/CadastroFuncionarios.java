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

public class CadastroFuncionarios extends JInternalFrame {
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textField;
	private JTextField textFieldBairro;
	private JTextField textTelefone;
	private JTextField textemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarios frame = new CadastroFuncionarios();
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
	public CadastroFuncionarios() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 625, 405);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 45, 25);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(65, 10, 430, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 45, 45, 25);
		getContentPane().add(lblCpf);
		
		JFormattedTextField formattedTextCPF = new JFormattedTextField();
		formattedTextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextCPF.setBounds(65, 45, 200, 25);
		getContentPane().add(formattedTextCPF);
		
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 80, 45, 25);
		getContentPane().add(lblRua);
		
		textRua = new JTextField();
		textRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRua.setBounds(65, 80, 430, 25);
		getContentPane().add(textRua);
		textRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Número: ");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 115, 50, 25);
		getContentPane().add(lblNumero);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(65, 115, 200, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 150, 45, 25);
		getContentPane().add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldBairro.setBounds(65, 154, 200, 25);
		getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 195, 50, 25);
		getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone.setBounds(65, 195, 200, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 235, 50, 25);
		getContentPane().add(lblEmail);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textemail.setBounds(65, 235, 250, 25);
		getContentPane().add(textemail);
		textemail.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(200, 310, 85, 30);
		getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(320, 310, 85, 30);
		getContentPane().add(btnSalvar);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCep.setBounds(300, 115, 30, 25);
		getContentPane().add(lblCep);
		
		JFormattedTextField formattedTextCEP = new JFormattedTextField();
		formattedTextCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextCEP.setBounds(335, 115, 160, 25);
		getContentPane().add(formattedTextCEP);
		
		

	}

}
