package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Mant_cursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mant_cursos frame = new Mant_cursos();
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
	public Mant_cursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	// Componentes de la interfaz
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblNombreAsig;
	private JTextField txtNombreAsig;
	private JLabel lblCiclo;
	private JTextField txtCiclo;
	private JLabel lblCreditos;
	private JTextField txtCreditos;
	private JLabel lblHoras;
	private JTextField txtHoras;
	private JButton btnAgregarCurso;
	private JButton btnActualizarCurso;
	private JButton btnEliminarCurso;
	private JButton btnLimpiarCurso;
	private JTable tableCursos;
	private JButton btnCargarCursos;
	private JButton btnGuardarCursos;
	private JLabel lblErrorCurso;

	// Modelo para la tabla
	private DefaultTableModel modelCursos;

	private void inicializarComponentes() {
		setLayout(null);

		lblCodCurso = new JLabel("Código Curso:");
		lblCodCurso.setBounds(20, 20, 100, 20);
		contentPane.add(lblCodCurso);

		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(130, 20, 100, 20);
		contentPane.add(txtCodCurso);

		lblNombreAsig = new JLabel("Asignatura:");
		lblNombreAsig.setBounds(20, 50, 100, 20);
		contentPane.add(lblNombreAsig);

		txtNombreAsig = new JTextField();
		txtNombreAsig.setBounds(130, 50, 200, 20);
		contentPane.add(txtNombreAsig);

		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(20, 80, 100, 20);
		contentPane.add(lblCiclo);

		txtCiclo = new JTextField();
		txtCiclo.setBounds(130, 80, 50, 20);
		contentPane.add(txtCiclo);

		lblCreditos = new JLabel("Créditos:");
		lblCreditos.setBounds(200, 80, 60, 20);
		contentPane.add(lblCreditos);

		txtCreditos = new JTextField();
		txtCreditos.setBounds(260, 80, 50, 20);
		contentPane.add(txtCreditos);

		lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(330, 80, 50, 20);
		contentPane.add(lblHoras);

		txtHoras = new JTextField();
		txtHoras.setBounds(380, 80, 50, 20);
		contentPane.add(txtHoras);

		btnAgregarCurso = new JButton("Agregar");
		btnAgregarCurso.setBounds(20, 120, 90, 25);
		contentPane.add(btnAgregarCurso);

		btnActualizarCurso = new JButton("Actualizar");
		btnActualizarCurso.setBounds(120, 120, 100, 25);
		contentPane.add(btnActualizarCurso);

		btnEliminarCurso = new JButton("Eliminar");
		btnEliminarCurso.setBounds(230, 120, 90, 25);
		contentPane.add(btnEliminarCurso);

		btnLimpiarCurso = new JButton("Limpiar");
		btnLimpiarCurso.setBounds(330, 120, 90, 25);
		contentPane.add(btnLimpiarCurso);

		modelCursos = new DefaultTableModel(
			new Object[]{"Código", "Asignatura", "Ciclo", "Créditos", "Horas"}, 0
		);
		tableCursos = new JTable(modelCursos);
		JScrollPane scrollPane = new JScrollPane(tableCursos);
		scrollPane.setBounds(20, 160, 400, 70);
		contentPane.add(scrollPane);

		btnCargarCursos = new JButton("Cargar Archivo");
		btnCargarCursos.setBounds(20, 240, 130, 25);
		contentPane.add(btnCargarCursos);

		btnGuardarCursos = new JButton("Guardar Archivo");
		btnGuardarCursos.setBounds(160, 240, 140, 25);
		contentPane.add(btnGuardarCursos);

		lblErrorCurso = new JLabel("");
		lblErrorCurso.setBounds(20, 270, 400, 20);
		lblErrorCurso.setForeground(Color.RED);
		contentPane.add(lblErrorCurso);

		// Listeners
		btnAgregarCurso.addActionListener(e -> agregarCurso());
		btnActualizarCurso.addActionListener(e -> actualizarCurso());
		btnEliminarCurso.addActionListener(e -> eliminarCurso());
		btnLimpiarCurso.addActionListener(e -> limpiarCampos());
		btnCargarCursos.addActionListener(e -> cargarCursosArchivo());
		btnGuardarCursos.addActionListener(e -> guardarCursosArchivo());
		tableCursos.getSelectionModel().addListSelectionListener(e -> cargarCursoSeleccionado());
	}

	@Override
	public void setContentPane(Container contentPane) {
		super.setContentPane(contentPane);
		inicializarComponentes();
	}

	private void agregarCurso() {
		if (!validarCampos()) return;
		Object[] fila = {
			txtCodCurso.getText().trim(),
			txtNombreAsig.getText().trim(),
			txtCiclo.getText().trim(),
			txtCreditos.getText().trim(),
			txtHoras.getText().trim()
		};
		modelCursos.addRow(fila);
		limpiarCampos();
		lblErrorCurso.setText("Curso agregado correctamente.");
	}

	private void actualizarCurso() {
		int fila = tableCursos.getSelectedRow();
		if (fila == -1) {
			lblErrorCurso.setText("Seleccione un curso para actualizar.");
			return;
		}
		if (!validarCampos()) return;
		modelCursos.setValueAt(txtCodCurso.getText().trim(), fila, 0);
		modelCursos.setValueAt(txtNombreAsig.getText().trim(), fila, 1);
		modelCursos.setValueAt(txtCiclo.getText().trim(), fila, 2);
		modelCursos.setValueAt(txtCreditos.getText().trim(), fila, 3);
		modelCursos.setValueAt(txtHoras.getText().trim(), fila, 4);
		limpiarCampos();
		lblErrorCurso.setText("Curso actualizado correctamente.");
	}

	private void eliminarCurso() {
		int fila = tableCursos.getSelectedRow();
		if (fila == -1) {
			lblErrorCurso.setText("Seleccione un curso para eliminar.");
			return;
		}
		modelCursos.removeRow(fila);
		limpiarCampos();
		lblErrorCurso.setText("Curso eliminado correctamente.");
	}

	private void limpiarCampos() {
		txtCodCurso.setText("");
		txtNombreAsig.setText("");
		txtCiclo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		tableCursos.clearSelection();
		lblErrorCurso.setText("");
	}

	private void cargarCursoSeleccionado() {
		int fila = tableCursos.getSelectedRow();
		if (fila != -1) {
			txtCodCurso.setText(modelCursos.getValueAt(fila, 0).toString());
			txtNombreAsig.setText(modelCursos.getValueAt(fila, 1).toString());
			txtCiclo.setText(modelCursos.getValueAt(fila, 2).toString());
			txtCreditos.setText(modelCursos.getValueAt(fila, 3).toString());
			txtHoras.setText(modelCursos.getValueAt(fila, 4).toString());
		}
	}

	private boolean validarCampos() {
		String cod = txtCodCurso.getText().trim();
		String asig = txtNombreAsig.getText().trim();
		String ciclo = txtCiclo.getText().trim();
		String creditos = txtCreditos.getText().trim();
		String horas = txtHoras.getText().trim();

		if (cod.isEmpty() || asig.isEmpty() || ciclo.isEmpty() || creditos.isEmpty() || horas.isEmpty()) {
			lblErrorCurso.setText("Todos los campos son obligatorios.");
			return false;
		}
		try {
			Integer.parseInt(cod);
			Integer.parseInt(ciclo);
			Integer.parseInt(creditos);
			Integer.parseInt(horas);
		} catch (NumberFormatException e) {
			lblErrorCurso.setText("Código, Ciclo, Créditos y Horas deben ser numéricos.");
			return false;
		}
		lblErrorCurso.setText("");
		return true;
	}

	private void cargarCursosArchivo() {
		// Implementar carga desde archivo si es necesario
		lblErrorCurso.setText("Función de carga no implementada.");
	}

	private void guardarCursosArchivo() {
		// Implementar guardado en archivo si es necesario
		lblErrorCurso.setText("Función de guardado no implementada.");
	}

}
