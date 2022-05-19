package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import DAO.AtletaDAO;
import DAO.EquipoDAO;
import DAO.PatrocinadorDAO;
import entidades.Atleta;
import entidades.Equipo;
import entidades.Patrocinador;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class nuevoAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldValor;
	private JTextField textFieldTelefono;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoAtleta frame = new nuevoAtleta();
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
	public nuevoAtleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelequipo = new JLabel("Equipo:");
		labelequipo.setBounds(51, 363, 46, 14);
		contentPane.add(labelequipo);
		
	
		
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "�Deseas cerrar la ventana?", "Salir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				System.exit(ABORT);
			}
		});
		btnNewButton_1.setBounds(575, 476, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(166, 99, 86, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*:");
		lblNombre.setBounds(51, 34, 70, 17);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(141, 32, 244, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelOpcion = new JLabel("Selecione la opci\u00F3n:");
		labelOpcion.setBounds(51, 62, 105, 29);
		contentPane.add(labelOpcion);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		rdbtnNewRadioButton.setBounds(176, 65, 51, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NIE");
		rdbtnNewRadioButton_1.setBounds(229, 65, 51, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel labelValor = new JLabel("Introduzca el valor:");
		labelValor.setBounds(51, 102, 105, 14);
		contentPane.add(labelValor);
		
		JLabel labelTelefono = new JLabel("Telefono:");
		labelTelefono.setBounds(51, 140, 46, 14);
		contentPane.add(labelTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(141, 137, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel labelFecha = new JLabel("Fecha Nacimiento:");
		labelFecha.setBounds(290, 140, 97, 14);
		contentPane.add(labelFecha);
		
		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(397, 137, 86, 20);
		contentPane.add(spinnerFecha);
		spinnerFecha.setModel(new SpinnerDateModel(new Date(1652220000000L), null, null, Calendar.DAY_OF_YEAR));
		
		JLabel labelAltura = new JLabel("Altura*:");
		labelAltura.setBounds(51, 204, 48, 22);
		contentPane.add(labelAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(109, 205, 63, 20);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("m. (en formato xx.xx)");
		lblNewLabel_7.setBounds(182, 208, 107, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel labelPeso = new JLabel("Peso*:");
		labelPeso.setBounds(51, 254, 46, 14);
		contentPane.add(labelPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(109, 251, 63, 20);
		contentPane.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Kg. (en formato xx.xx)");
		lblNewLabel_8.setBounds(176, 254, 117, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 359, 202, 22);
		contentPane.add(comboBox);
		
		DefaultComboBoxModel<Equipo> equipoModel = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBoxAtleta = new JComboBox<Equipo>(equipoModel);
		EquipoDAO eqDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equiposList = (ArrayList<Equipo>) eqDAO.buscarTodos();
	
		for (Equipo eq : equiposList)
			comboBoxAtleta.addItem(eq);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta nuevo = new Atleta(); 
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				
				//nombre
				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre del atleta no es válido (3-50 caracteres).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nuevo.getPersona().getNombre();
				valido = false;
				
				// fecha
				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
				valido = Validaciones.validarFechaNuevaAtleta(fecha);
				if (!valido) {
					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
					spinnerFecha.setForeground(Color.RED);
				} else {
					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
					
				}
				valido = false;
				
				//telefono
				String telefono = textFieldTelefono.getText();
				valido = Validaciones.validarNombre(telefono);
				if (!valido) {
					errores += "El telefono del atleta no es valido";
					labelTelefono.setForeground(Color.RED);
				} else
					nuevo.
				valido = false;
				 //altura
				
			Float altura = textFieldAltura.getValue();
			}
		});
		btnNewButton.setBounds(434, 476, 89, 23);
		contentPane.add(btnNewButton);
	}
}
