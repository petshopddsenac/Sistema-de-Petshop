package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import model.vo.Cliente;
import model.vo.Pessoa;

import javax.swing.JFormattedTextField;
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
	private JFormattedTextField textCEP;
	private JFormattedTextField textCPF;
	private JTextField textDDD;
	private Pessoa novapessoa;

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

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 60, 25);
		getContentPane().add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(80, 10, 415, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:  ");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCPF.setBounds(10, 45, 45, 25);
		getContentPane().add(lblCPF);
		
		final JFormattedTextField textCPF = new JFormattedTextField();
		MaskFormatter mascaraCpf = new MaskFormatter();
		try {
			mascaraCpf.setMask("###.###.###-##");
			mascaraCpf.install(textCPF);
			textCPF.setText("");
			textCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textCPF.setBounds(80, 50, 200, 25);
			getContentPane().add(textCPF);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 80, 40, 25);
		getContentPane().add(lblRua);

		textRua = new JTextField();
		textRua.setBounds(80, 84, 415, 25);
		getContentPane().add(textRua);
		textRua.setColumns(10);

		JLabel lblNumero = new JLabel("Número: ");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 115, 60, 25);
		getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumero.setBounds(80, 120, 200, 25);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 150, 50, 25);
		getContentPane().add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(80, 155, 200, 25);
		getContentPane().add(textBairro);
		textBairro.setColumns(10);

		JLabel lblCEP = new JLabel("CEP: ");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(306, 120, 29, 25);
		getContentPane().add(lblCEP);

		final JFormattedTextField textCEP = new JFormattedTextField();
		MaskFormatter mascaraCep;
		try {
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCep.install(textCEP);
		} catch (ParseException e2) {

			e2.printStackTrace();
		}

		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCEP.setBounds(345, 120, 140, 25);
		getContentPane().add(textCEP);

		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 225, 50, 25);
		getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail.setBounds(80, 225, 200, 25);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(185, 189, 60, 25);
		getContentPane().add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone.setBounds(255, 191, 200, 25);
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
				String rua = textRua.getText();
				String bairro = textBairro.getText();
				String numero = textNumero.getText();
				String ddd = textDDD.getText();
				String telefone = textTelefone.getText();
				String email = textEmail.getText();
				String cpf = textCPF.getText();
				String cep = textCEP.getText();
				
				String mensagem = controller.validar(textNome.getText(), textRua.getText(), textBairro.getText(), textNumero.getText(), textDDD.getText(), textTelefone.getText(), 
						textEmail.getText(), textCPF.getText(), textCEP.getText());
							
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
		
		textDDD = new JTextField();
		textDDD.setBounds(80, 191, 86, 25);
		getContentPane().add(textDDD);
		textDDD.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(10, 197, 46, 14);
		getContentPane().add(lblDdd);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(68, 11, 11, 25);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(65, 51, 11, 25);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(69, 84, 10, 25);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(68, 121, 11, 25);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(70, 156, 11, 25);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(68, 189, 11, 25);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(244, 189, 11, 25);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(335, 121, 11, 25);
		getContentPane().add(label_7);


	}

	protected void limparCampos() {
		this.textNome.setText("");
		this.textRua.setText("");
		this.textNumero.setText("");
		this.textBairro.setText("");
		this.textDDD.setText("");
		this.textTelefone.setText("");
		this.textEmail.setText("");
		this.textCEP.setText("");
		this.textCPF.setText("");


	}
}
