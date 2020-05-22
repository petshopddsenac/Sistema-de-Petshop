package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroConsultas extends JInternalFrame {
	private JTextField textAnimal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroConsultas frame = new CadastroConsultas();
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
	public CadastroConsultas() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 580, 395);
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCliente.setBounds(10, 20, 50, 25);
		getContentPane().add(lblCliente);
		
		JLabel lblAnimal = new JLabel("Animal: ");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnimal.setBounds(10, 55, 50, 25);
		getContentPane().add(lblAnimal);
		
		textAnimal = new JTextField();
		textAnimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimal.setBounds(100, 55, 210, 25);
		getContentPane().add(textAnimal);
		textAnimal.setColumns(10);
		
		JLabel lblFuncionario = new JLabel("Funcionarios: ");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFuncionario.setBounds(10, 90, 80, 25);
		getContentPane().add(lblFuncionario);
		
		JComboBox cbFuncionario = new JComboBox();
		cbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbFuncionario.setBounds(100, 90, 210, 25);
		getContentPane().add(cbFuncionario);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(10, 160, 45, 25);
		getContentPane().add(lblData);
		
		JFormattedTextField formattedTextData = new JFormattedTextField();
		formattedTextData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextData.setBounds(100, 160, 125, 25);
		getContentPane().add(formattedTextData);
		
		JLabel lblServico = new JLabel("Serviço:");
		lblServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServico.setBounds(10, 125, 65, 25);
		getContentPane().add(lblServico);
		
		JComboBox cbServico = new JComboBox();
		cbServico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbServico.setBounds(100, 125, 210, 25);
		getContentPane().add(cbServico);
		
		JLabel lblDiagnostico = new JLabel("Diagnóstico:");
		lblDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiagnostico.setBounds(10, 255, 80, 25);
		getContentPane().add(lblDiagnostico);
		
		JLabel lblHora = new JLabel("Hora: ");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setBounds(10, 195, 45, 25);
		getContentPane().add(lblHora);
		
		JTextArea textAreaDiagnostico = new JTextArea();
		textAreaDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaDiagnostico.setBounds(100, 230, 340, 85);
		getContentPane().add(textAreaDiagnostico);
		
		JFormattedTextField formattedTextHora = new JFormattedTextField();
		formattedTextHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextHora.setBounds(100, 195, 125, 25);
		getContentPane().add(formattedTextHora);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(140, 325, 85, 30);
		getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.setBounds(265, 325, 85, 30);
		getContentPane().add(btnSalvar);
		
		JComboBox cbClientes = new JComboBox();
		cbClientes.setBounds(100, 20, 210, 25);
		getContentPane().add(cbClientes);

	}
}
