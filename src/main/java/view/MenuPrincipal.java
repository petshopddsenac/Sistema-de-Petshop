package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.MenuItem;

import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private PainelCadastroCliente cadastroCliente;
	private PainelCadastrarAnimal cadastroAnimal;

	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setFont(null);
		setTitle("Menu Principal");
		setBackground(new Color(152, 251, 152));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 465);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setForeground(new Color(0, 0, 0));
		mnCliente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/grupo.png")));
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addKeyListener(new KeyAdapter() {

		});
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cadastroCliente == null || !cadastroCliente.isVisible()) {
					cadastroCliente = new PainelCadastroCliente();
					desktopPane.add(cadastroCliente);
					cadastroCliente.show();

				}
			}
		});
		mntmCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmCadastrarCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/equipe.png")));

		mnCliente.add(mntmCadastrarCliente);

		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmListarClientes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/grup.png")));
		mnCliente.add(mntmListarClientes);

		JMenu mnAnimal = new JMenu("Animal");
		mnAnimal.setForeground(new Color(0, 0, 0));
		mnAnimal.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnAnimal.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/animais-de-estimacao.png")));
		menuBar.add(mnAnimal);

		JMenuItem mntmCadastrarAnimal = new JMenuItem("Cadastrar Animal");
		mntmCadastrarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroAnimal menuCadastroAnimal = new CadastroAnimal();
				menuCadastroAnimal.setVisible(true);
				
				
			}
		});
		mntmCadastrarAnimal.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_F10,0));
		mntmCadastrarAnimal.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/cao.png")));
		mnAnimal.add(mntmCadastrarAnimal);

		JMenuItem mntmListarAnimais = new JMenuItem("Listar Animais");
		mntmListarAnimais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmListarAnimais.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/gatinha.png")));
		mnAnimal.add(mntmListarAnimais);

		JMenu mnServico = new JMenu("Serviço");
		mnServico.setForeground(new Color(0, 0, 0));
		mnServico.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnServico.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/animal.png")));
		menuBar.add(mnServico);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Serviço");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroServicos menuCadastroServico = new CadastroServicos();
				menuCadastroServico.setVisible(true);
			}
		});
		mntmCadastrar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/higiene.png")));
		mnServico.add(mntmCadastrar);

		JMenuItem mntmListarServicos = new JMenuItem("Listar Serviços");
		mntmListarServicos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/limpeza.png")));
		mnServico.add(mntmListarServicos);

		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setForeground(new Color(0, 0, 0));
		mnConsulta.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnConsulta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/veterinaria.png")));
		menuBar.add(mnConsulta);

		JMenuItem mntmCadastrarConsulta = new JMenuItem("Cadastrar Consulta");
		mntmCadastrarConsulta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/relatorio-medico.png")));
		mnConsulta.add(mntmCadastrarConsulta);

		JMenuItem mntmListarConsultas = new JMenuItem("Listar Consultas");
		mntmListarConsultas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/calendario.png")));
		mnConsulta.add(mntmListarConsultas);

		JMenu mnFuncionario = new JMenu("Funcionário");
		mnFuncionario.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/veterinario.png")));
		mnFuncionario.setForeground(new Color(0, 0, 0));
		mnFuncionario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnFuncionario);

		JMenuItem mntmCadastrarFuncionrio = new JMenuItem("Cadastrar Funcionário");
		mntmCadastrarFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				CadastroFuncionarios menuCadastroFuncionario = new CadastroFuncionarios();
				menuCadastroFuncionario.setVisible(true);
				
				
				
			}
		});
		mntmCadastrarFuncionrio.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/medico.png")));
		mnFuncionario.add(mntmCadastrarFuncionrio);

		JMenuItem mntmListarFuncionrios = new JMenuItem("Listar Funcionários");
		mntmListarFuncionrios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/estetoscopio.png")));
		mnFuncionario.add(mntmListarFuncionrios);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ícones/info.png")));

		mnSobre.setForeground(new Color(0, 0, 0));
		mnSobre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
