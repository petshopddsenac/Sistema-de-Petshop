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

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastroClientes extends JFrame {
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textDDD;
	private JTextField txtCpf;
	private JTextField txtCep;

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
		setTitle("Cadastrar Cliente");

		
		setBounds(100, 100, 650, 410);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 10, 60, 25);
		getContentPane().add(lblNome);

		JLabel lblCPF = new JLabel("CPF:  ");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCPF.setBounds(10, 45, 40, 25);
		getContentPane().add(lblCPF);
		
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 80, 40, 25);
		getContentPane().add(lblRua);

		JLabel lblNumero = new JLabel("Complemento: ");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(324, 152, 84, 25);
		getContentPane().add(lblNumero);

		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 116, 50, 25);
		getContentPane().add(lblBairro);

		JLabel lblCEP = new JLabel("CEP: ");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(10, 152, 29, 25);
		getContentPane().add(lblCEP);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 231, 50, 25);
		getContentPane().add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(349, 190, 60, 25);
		getContentPane().add(lblTelefone);

		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskFormatter);
			txtCpf.setBounds(80, 47, 223, 23);
			getContentPane().add(txtCpf);
			txtCpf.setColumns(10);;
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de CPF no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(maskFormatter);
			txtCep.setBounds(80, 153, 223, 25);
			getContentPane().add(txtCep);
			txtCep.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de CEP no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("****************************************************************************************************"); //100 dígitos
			textNome = new JFormattedTextField(maskFormatter);
			textNome.setBounds(80, 10, 531, 25);
			getContentPane().add(textNome);
			textNome.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Nome no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("****************************************************************************************************"); //100 dígitos any caracteres
			textRua = new JFormattedTextField(maskFormatter);
			textRua.setBounds(80, 84, 531, 25);
			getContentPane().add(textRua);
			textRua.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Nome no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		try {
			MaskFormatter maskFormatter = new MaskFormatter("**************************************************"); //50 dígitos any caracteres
			textNumero = new JFormattedTextField(maskFormatter);
			textNumero.setBounds(421, 153, 190, 25);
			getContentPane().add(textNumero);
			textNumero.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Complemento no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		try {
			MaskFormatter maskFormatter = new MaskFormatter("**************************************************"); //50 dígitos any caracteres
			textBairro = new JFormattedTextField(maskFormatter);
			textBairro.setBounds(80, 116, 223, 25);
			getContentPane().add(textBairro);
			textNome.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Bairro no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("**************************************************"); //50 dígitos any caracteres
			textEmail = new JFormattedTextField(maskFormatter);
			textEmail.setBounds(80, 232, 223, 25);
			getContentPane().add(textEmail);
			textEmail.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Email no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("#########"); //9 números any caracteres
			textTelefone = new JFormattedTextField(maskFormatter);
			textTelefone.setBounds(421, 191, 190, 25);
			getContentPane().add(textTelefone);
			textTelefone.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de Telefone no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		try {
			MaskFormatter maskFormatter = new MaskFormatter("##"); //50 dígitos any caracteres
			textDDD = new JFormattedTextField(maskFormatter);
			textDDD.setBounds(80, 191, 223, 25);
			getContentPane().add(textDDD);
			textDDD.setColumns(10);
		} catch (Exception e) {
			System.out.println("Erro na mascara de formatacao de DDD no painel de cadastro de usuario.");
			e.printStackTrace();
		}
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(204, 0, 0));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();

			}
		});
		btnLimpar.setBounds(341, 313, 111, 44);
		getContentPane().add(btnLimpar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 128, 0));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
								
				String mensagem = controller.cadastrarCliente(textNome.getText(), textRua.getText(), textBairro.getText(), textNumero.getText(), textDDD.getText(), textTelefone.getText(), 
						textEmail.getText(), txtCpf.getText(), txtCep.getText());
							
				JOptionPane.showMessageDialog(null, mensagem, "Validação dos Campos", JOptionPane.INFORMATION_MESSAGE);
				limparCampos();

			}

		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(471, 313, 140, 44);

		getContentPane().add(btnSalvar);
		
		JLabel lblObrigatorio = new JLabel(" * Campos Obrigatórios");
		lblObrigatorio.setForeground(Color.RED);
		lblObrigatorio.setBounds(10, 268, 140, 15);
		lblObrigatorio.setVisible(true);
		getContentPane().add(lblObrigatorio);
		

		
		JLabel lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(10, 196, 46, 14);
		getContentPane().add(lblDdd);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(68, 11, 11, 25);
		getContentPane().add(label);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(410, 153, 11, 25);
		getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(68, 153, 11, 25);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(410, 192, 11, 25);
		getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(68, 191, 11, 25);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(68, 115, 11, 25);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(68, 86, 11, 25);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(68, 46, 11, 25);
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
		this.txtCep.setText("");
		this.txtCpf.setText("");

	}
}
