package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 682, 71);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenu mnMantenimiento = new JMenu("Manteniminento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmAlumnos = new JMenuItem("Alumnos");
		mnMantenimiento.add(mntmAlumnos);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mnMantenimiento.add(mntmCursos);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmMatrícula = new JMenuItem("Matrícula");
		mnRegistro.add(mntmMatrícula);
		
		JMenuItem mntmRetiro = new JMenuItem("Retiro");
		mnRegistro.add(mntmRetiro);

		// Llamar a este método en el constructor después de crear los JMenuItem
		inicializarEventos(mntmAlumnos, mntmCursos);
	}
	// Integración con los formularios Mant_alumnos y Mant_cursos
	private void inicializarEventos(JMenuItem mntmAlumnos, JMenuItem mntmCursos) {
		mntmAlumnos.addActionListener(e -> {
			Mant_alumnos frameAlumnos = new Mant_alumnos();
			frameAlumnos.setVisible(true);
		});
		mntmCursos.addActionListener(e -> {
			Mant_cursos frameCursos = new Mant_cursos();
			frameCursos.setVisible(true);
		});
	}
}
