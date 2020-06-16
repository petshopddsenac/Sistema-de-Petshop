package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

		JLabel lblInfo = new JLabel("Digite o CPF a ser excluído");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setBounds(20, 30, 160, 25);
		getContentPane().add(lblInfo);

		JFormattedTextField formattedTextCPF = new JFormattedTextField();
		formattedTextCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextCPF.setBounds(185, 30, 185, 25);
		getContentPane().add(formattedTextCPF);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
				Cliente cliente = new Cliente();
				controller.excluirPorCpf(cliente.getCpf());
			}
		});
		btnExcluir.setBounds(140, 195, 85, 30);
		getContentPane().add(btnExcluir);

	}
}