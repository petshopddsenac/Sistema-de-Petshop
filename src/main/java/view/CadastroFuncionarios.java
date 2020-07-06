package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.vo.Funcionario;


import controller.FuncionarioController;
import model.dao.FuncionarioDAO;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastroFuncionarios extends JInternalFrame {
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textField;
	private JTextField textFieldBairro;
	private JTextField textTelefone;
	private JTextField textemail;
	private JFormattedTextField TextCEP;
	private JFormattedTextField TextCPF;
	private JLabel lblNumero;
	private String cbFuncionario;

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
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");

			TextCPF = new JFormattedTextField(mascaraCpf);
			TextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
			TextCPF.setBounds(65, 45, 200, 25);
			getContentPane().add(TextCPF);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

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

				LimparCampos();

			}
		});
		btnLimpar.setBounds(200, 310, 85, 30);
		getContentPane().add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				FuncionarioController controladora = new FuncionarioController();
				String nomeDigitado = textNome.getText();
				String ruaDigitado  = textRua.getText();
				String cpfDigitado = TextCPF.getText();
				
				String mensagem = controladora.validarCamposDigitado(nomeDigitado, ruaDigitado,cpfDigitado);
				if (mensagem.isEmpty()) {
					Funcionario funcionario = new Funcionario();
					funcionario = controladora.salvar(funcionario);
					JOptionPane.showMessageDialog(null, "salvo com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, mensagem);
				}

		
			}
		});
		btnSalvar.setBounds(320, 310, 85, 30);
		getContentPane().add(btnSalvar);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCep.setBounds(300, 115, 30, 25);
		getContentPane().add(lblCep);

		try {
			MaskFormatter mascaraCep = new MaskFormatter("###-####");

			TextCEP = new JFormattedTextField(mascaraCep);
			TextCEP.setBounds(335, 115, 150, 25);
			getContentPane().add(TextCEP);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

	protected void LimparCampos() {
		this.textemail.setText("");
		this.textField.setText("");
		this.textFieldBairro.setText("");
		this.textNome.setText("");
		this.textRua.setText("");
		this.textTelefone.setText("");
		this.TextCEP.setText("");
		this.TextCPF.setText("");

	}

}
