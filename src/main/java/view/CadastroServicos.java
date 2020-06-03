package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroServicos extends JInternalFrame {
	private JTextField textNome;
	private JTextField textPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroServicos frame = new CadastroServicos();
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
	public CadastroServicos() {
		setClosable(true);
		
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 20, 45, 25);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(70, 20, 180, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPreco.setBounds(10, 65, 45, 25);
		getContentPane().add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setBounds(70, 65, 95, 25);
		getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblNecessitaConsulta = new JLabel("Necessita Consulta: ");
		lblNecessitaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNecessitaConsulta.setBounds(10, 100, 120, 25);
		getContentPane().add(lblNecessitaConsulta);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnSim.setBounds(70, 130, 50, 25);
		getContentPane().add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNao.setBounds(155, 130, 50, 25);
		getContentPane().add(rdbtnNao);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(125, 215, 85, 30);
		getContentPane().add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(265, 215, 85, 30);
		getContentPane().add(btnSalvar);

	}
}
