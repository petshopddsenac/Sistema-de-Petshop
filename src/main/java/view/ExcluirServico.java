package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ExcluirServico extends JInternalFrame {
	private JTextField textFieldid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirServico frame = new ExcluirServico();
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
	public ExcluirServico() {
		setTitle("Excluir Serviço");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Indorme o id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(35, 35, 85, 30);
		getContentPane().add(lblId);
		
		textFieldid = new JTextField();
		textFieldid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldid.setBounds(130, 35, 100, 30);
		getContentPane().add(textFieldid);
		textFieldid.setColumns(10);

	}

}
