package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mant_alumnos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel lblCodAlumno, lblNombres, lblApellidos, lblDni, lblEdad, lblCelular, lblEstado, lblErrorAlumno;
	private JTextField txtCodAlumno, txtNombres, txtApellidos, txtDni, txtEdad, txtCelular;
	private JComboBox<String> cbEstado;
	private JButton btnAgregarAlumno, btnActualizarAlumno, btnEliminarAlumno, btnLimpiarAlumno, btnCargarAlumnos, btnGuardarAlumnos;
	private JTable tableAlumnos;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mant_alumnos frame = new Mant_alumnos();
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
	public Mant_alumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Initialize components and layout
		contentPane.setLayout(null);

		lblCodAlumno = new JLabel("Código Alumno:");
		lblCodAlumno.setBounds(20, 20, 100, 25);
		contentPane.add(lblCodAlumno);

		txtCodAlumno = new JTextField();
		txtCodAlumno.setBounds(130, 20, 120, 25);
		contentPane.add(txtCodAlumno);

		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(20, 55, 100, 25);
		contentPane.add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setBounds(130, 55, 120, 25);
		contentPane.add(txtNombres);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(20, 90, 100, 25);
		contentPane.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(130, 90, 120, 25);
		contentPane.add(txtApellidos);

		lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 125, 100, 25);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(130, 125, 120, 25);
		contentPane.add(txtDni);

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 160, 100, 25);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(130, 160, 120, 25);
		contentPane.add(txtEdad);

		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(20, 195, 100, 25);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setBounds(130, 195, 120, 25);
		contentPane.add(txtCelular);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(20, 230, 100, 25);
		contentPane.add(lblEstado);

		cbEstado = new JComboBox<>(new String[]{"Activo", "Inactivo"});
		cbEstado.setBounds(130, 230, 120, 25);
		contentPane.add(cbEstado);

		btnAgregarAlumno = new JButton("Agregar");
		btnAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregarAlumno(e);
			}
		});
		btnAgregarAlumno.setBounds(270, 20, 120, 25);
		contentPane.add(btnAgregarAlumno);

		btnActualizarAlumno = new JButton("Actualizar");
		btnActualizarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizarAlumno(e);
			}
		});
		btnActualizarAlumno.setBounds(270, 55, 120, 25);
		contentPane.add(btnActualizarAlumno);

		btnEliminarAlumno = new JButton("Eliminar");
		btnEliminarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminarAlumno(e);
			}
		});
		btnEliminarAlumno.setBounds(270, 90, 120, 25);
		contentPane.add(btnEliminarAlumno);

		btnLimpiarAlumno = new JButton("Limpiar");
		btnLimpiarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiarAlumno(e);
			}
		});
		btnLimpiarAlumno.setBounds(270, 125, 120, 25);
		contentPane.add(btnLimpiarAlumno);

		btnCargarAlumnos = new JButton("Cargar Archivo");
		btnCargarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCargarAlumnos(e);
			}
		});
		btnCargarAlumnos.setBounds(270, 160, 120, 25);
		contentPane.add(btnCargarAlumnos);

		btnGuardarAlumnos = new JButton("Guardar Archivo");
		btnGuardarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnGuardarAlumnos(e);
			}
		});
		btnGuardarAlumnos.setBounds(270, 195, 120, 25);
		contentPane.add(btnGuardarAlumnos);

		lblErrorAlumno = new JLabel("");
		lblErrorAlumno.setForeground(Color.RED);
		lblErrorAlumno.setBounds(20, 265, 370, 25);
		contentPane.add(lblErrorAlumno);

		tableModel = new DefaultTableModel(
			new Object[]{"Código", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado"}, 0
		);
		tableAlumnos = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tableAlumnos);
		scrollPane.setBounds(20, 300, 400, 120);
		contentPane.add(scrollPane);

		setSize(460, 480);
		setResizable(false);
	}

	private String leerCodAlumno() {
		return txtCodAlumno.getText().trim();
	}

	private String leerNombres() {
		return txtNombres.getText().trim();
	}

	private String leerApellidos() {
		return txtApellidos.getText().trim();
	}

	private String leerDni() {
		return txtDni.getText().trim();
	}

	private String leerEdad() {
		return txtEdad.getText().trim();
	}

	private String leerCelular() {
		return txtCelular.getText().trim();
	}

	private String leerEstado() {
		return (String) cbEstado.getSelectedItem();
	}

	private void limpiarCampos() {
		txtCodAlumno.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cbEstado.setSelectedIndex(0);
		lblErrorAlumno.setText("");
	}

	private void mostrarError(String mensaje) {
		lblErrorAlumno.setText(mensaje);
	}

	private void limpiarError() {
		lblErrorAlumno.setText("");
	}
	protected void actionPerformedBtnAgregarAlumno(ActionEvent e) {
	}
	
	protected void actionPerformedBtnActualizarAlumno(ActionEvent e) {
	}
	
	protected void actionPerformedBtnEliminarAlumno(ActionEvent e) {
	}
	
	protected void actionPerformedBtnLimpiarAlumno(ActionEvent e) {
		limpiarCampos();
		limpiarError();
		tableModel.setRowCount(0); // Limpiar la tabla
		mostrarError("Campos limpiados.");
	}
	
	protected void actionPerformedBtnCargarAlumnos(ActionEvent e) {
	}
	
	protected void actionPerformedBtnGuardarAlumnos(ActionEvent e) {
	}
	


}