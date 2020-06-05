package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class ExcluirConsulta extends JInternalFrame {
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirConsulta frame = new ExcluirConsulta();
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
	public ExcluirConsulta() {
		setTitle("Excluir Consulta");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Informe o Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(35, 50, 85, 30);
		getContentPane().add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(120, 50, 100, 30);
		getContentPane().add(textFieldId);
		textFieldId.setColumns(10);

	}

}
