package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ExcluirFuncionario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirFuncionario frame = new ExcluirFuncionario();
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
	public ExcluirFuncionario() {
		setBounds(100, 100, 450, 300);

	}

}
