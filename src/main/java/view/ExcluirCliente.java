package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.ClienteController;
import model.dao.ClienteDAO;
import model.vo.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class ExcluirCliente extends JInternalFrame {
	private JTextField textNomeC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirCliente frame = new ExcluirCliente();
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
	public ExcluirCliente() {
		setTitle("Excluir Cliente");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
			
				String nome = textNomeC.getText();
				 String mensagem = controller.excluirCliente(textNomeC.getText());
				
				 if (mensagem.isEmpty()) {
						Cliente cliente = new Cliente();

						JOptionPane.showMessageDialog(null, " Cliente excluído com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Erro na exclusão do cliente");
					}

				}
			
		});
		btnExcluir.setBounds(140, 195, 85, 30);
		getContentPane().add(btnExcluir);
		
		JLabel lblDigite = new JLabel("Digite o nome a ser excluído:");
		lblDigite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigite.setBounds(90, 20, 195, 25);
		getContentPane().add(lblDigite);
		
		textNomeC = new JTextField();
		textNomeC.setBounds(90, 90, 225, 25);
		getContentPane().add(textNomeC);
		textNomeC.setColumns(10);

	}
}