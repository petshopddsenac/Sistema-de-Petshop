package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import model.vo.Cliente;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class CadastroClientes extends JFrame {
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JFormattedTextField TextCEP;
	private JFormattedTextField TextCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClientes frame = new CadastroClientes();
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
	public CadastroClientes() {

		setBounds(100, 100, 650, 410);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome: * ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 50, 25);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(80, 10, 415, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblCPF = new JLabel("CPF: * ");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCPF.setBounds(10, 45, 45, 25);
		getContentPane().add(lblCPF);
		
		final JFormattedTextField TextCPF = new JFormattedTextField();
		MaskFormatter mascaraCpf = new MaskFormatter();
		try {

			mascaraCpf.setMask("###.###.###-##");
			mascaraCpf.install(TextCPF);
			TextCPF.setText("");
			TextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
			TextCPF.setBounds(80, 50, 200, 25);
			getContentPane().add(TextCPF);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		JLabel lblRua = new JLabel("Rua: * ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 80, 40, 25);
		getContentPane().add(lblRua);

		textRua = new JTextField();
		textRua.setBounds(70, 85, 415, 25);
		getContentPane().add(textRua);
		textRua.setColumns(10);

		JLabel lblNumero = new JLabel("Número:  *");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 115, 60, 25);
		getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumero.setBounds(80, 120, 200, 25);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro: * ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 150, 50, 25);
		getContentPane().add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(80, 155, 200, 25);
		getContentPane().add(textBairro);
		textBairro.setColumns(10);

		JLabel lblCEP = new JLabel("CEP: * ");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(296, 120, 40, 25);
		getContentPane().add(lblCEP);

		final JFormattedTextField TextCEP = new JFormattedTextField();
		MaskFormatter mascaraCep;
		try {
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCep.install(TextCEP);
		} catch (ParseException e2) {

			e2.printStackTrace();
		}

		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCEP.setBounds(345, 120, 140, 25);
		getContentPane().add(textCEP);

		JLabel lblEmail = new JLabel("e-mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 225, 50, 25);
		getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail.setBounds(80, 225, 200, 25);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone: * ");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 190, 60, 25);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone.setBounds(80, 190, 200, 25);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();

			}
		});
		btnLimpar.setBounds(185, 320, 85, 30);
		getContentPane().add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
				String nome = textNome.getText();
				String bairro = textBairro.getText();
				String numero = textNumero.getText();
				String telefone = textTelefone.getText();
				String email = textEmail.getText();
				String Cpf = TextCPF.getText();
				String Cep = TextCEP.getText();

				String mensagem = controller.validar(textNome.getText(), textRua.getText(), textBairro.getText(), textNumero.getText(), textTelefone.getText(), 
						textEmail.getText(), TextCPF.getText(), TextCEP.getText());
				
				
				if (mensagem.isEmpty()) {
					Cliente cliente = new Cliente();

					JOptionPane.showMessageDialog(null, " Cliente Salvo com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios!", "Atenção",JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(335, 320, 85, 30);

		getContentPane().add(btnSalvar);
		
		JLabel lblObrigatorio = new JLabel(" * Campos Obrigatórios");
		lblObrigatorio.setForeground(Color.RED);
		lblObrigatorio.setBounds(55, 275, 140, 15);
		lblObrigatorio.setVisible(true);
		getContentPane().add(lblObrigatorio);


	}

	protected void limparCampos() {
		this.textNome.setText("");
		this.textRua.setText("");
		this.textNumero.setText("");
		this.textBairro.setText("");
		this.textTelefone.setText("");
		this.textEmail.setText("");
		this.TextCEP.setText("");
		this.TextCPF.setText("");


	}

}
