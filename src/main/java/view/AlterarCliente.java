package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class AlterarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textBairro;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JFormattedTextField TextCEP;
	private JFormattedTextField TextCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCliente frame = new AlterarCliente();
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
	public AlterarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: *");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 20, 60, 25);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(70, 20, 335, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: *");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 65, 46, 25);
		contentPane.add(lblCpf);
		
		
		final JFormattedTextField TextCPF = new JFormattedTextField();
		MaskFormatter mascaraCpf = new MaskFormatter();
		try {

			mascaraCpf.setMask("###.###.###-##");
			mascaraCpf.install(TextCPF);
			TextCPF.setText("");
			TextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
			TextCPF.setBounds(70, 65, 200, 25);
			getContentPane().add(TextCPF);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		
				
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRua.setBounds(10, 100, 46, 25);
		contentPane.add(lblRua);
		
		textRua = new JTextField();
		textRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRua.setBounds(70, 100, 335, 25);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(10, 145, 60, 25);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumero.setBounds(70, 145, 200, 25);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCep.setBounds(305, 145, 45, 25);
		contentPane.add(lblCep);
		
		final JFormattedTextField TextCEP = new JFormattedTextField();
		MaskFormatter mascaraCep;
		try {
		mascaraCep = new MaskFormatter("#####-###");
		mascaraCep.install(TextCEP);
		TextCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TextCEP.setBounds(360, 145, 140, 25);
		contentPane.add(TextCEP);

		} catch (ParseException e2) {

			e2.printStackTrace();
		}
			
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(10, 185, 50, 25);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBairro.setColumns(10);
		textBairro.setBounds(70, 189, 200, 25);
		contentPane.add(textBairro);
		
		JLabel lblTelefone = new JLabel("Telefone: *");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 235, 60, 25);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone.setBounds(70, 235, 200, 25);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 285, 50, 25);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(70, 285, 200, 25);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteController controller = new ClienteController();
				controller.validar(textNome.getText(), textRua.getText(), textBairro.getText(), textNumero.getText(), textTelefone.getText(), textEmail.getText(),
						TextCPF.getText(), TextCEP.getText());
				
				String mensagem = controller.alterar(textNome.getText(), textRua.getText(), textBairro.getText(),
						textNumero.getText(), textTelefone.getText(), textEmail.getText(), TextCPF.getText(),
						TextCEP.getText());
				if (mensagem.isEmpty()) {
					Cliente clienteAlterado = new Cliente();
					JOptionPane.showMessageDialog(null, "Cliente Alterado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
				}
				
			
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlterar.setBounds(230, 330, 85, 30);
		contentPane.add(btnAlterar);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigatórios");
		lblCamposObrigatrios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCamposObrigatrios.setBounds(325, 240, 115, 15);
		contentPane.add(lblCamposObrigatrios);
	}
}
