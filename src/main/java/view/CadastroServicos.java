package view;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JTextField;

import controller.ServicoController;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class CadastroServicos extends JFrame {
	private JTextField textNome;
	private JTextField textPreco;
	JCheckBox chkBoxNecessitaConsulta;

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
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 20, 50, 25);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(70, 20, 180, 25);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço: ");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPreco.setBounds(10, 65, 50, 25);
		getContentPane().add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setBounds(70, 65, 95, 25);
		getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblNecessitaConsulta = new JLabel("Necessita Consulta: ");
		lblNecessitaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNecessitaConsulta.setBounds(10, 112, 120, 25);
		getContentPane().add(lblNecessitaConsulta);
		
		JCheckBox chkboxNecessitaConsulta = new JCheckBox("");
		chkboxNecessitaConsulta.setBounds(130, 112, 21, 23);
		getContentPane().add(chkboxNecessitaConsulta);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}

		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(125, 215, 85, 30);
		getContentPane().add(btnLimpar);

		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicoController controller = new ServicoController();
				controller.cadastrarServico(textNome.getText(), chkBoxNecessitaConsulta.isSelected(), Double.parseDouble(textPreco.getText()));
			}
		});
		btnSalvar.setBounds(265, 215, 85, 30);
		getContentPane().add(btnSalvar);
		
		
			
		}
	private void limparCampos() {
		this.textNome.setText("");
		this.textPreco.setText("");
	
	}
	}

