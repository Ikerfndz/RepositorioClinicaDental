package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import DAO.AtletaDAO;
import DAO.MetalDAO;
import DAO.PatrocinadorDAO;
import DAO.PruebaDAO;
import entidades.Atleta;
import entidades.Bronce;
import entidades.Documentacion;
import entidades.Lugar;
import entidades.Metal;
import entidades.Oro;
import entidades.Participante;
import entidades.Patrocinador;
import entidades.Plata;
import entidades.Prueba;
import entidades.Resultado;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class CerrarPrueba extends JFrame {

	private JPanel contentPane;
	private Container buttonGroupTipo;
	private JTextField txtEstablecerComoDefinitiva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
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
	public CerrarPrueba(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if (prueba != null) {
			setTitle("Cerrar Prueba" + idprueba);
		} else
			setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		JTextField textField = new JTextField("" + prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		JTextField textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");

		rbIndividual.setEnabled(false);

		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if (prueba.isIndividual())
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(27, 251, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(27, 373, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(27, 489, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] atletasStr = new String[90];
		for (int i = 0; i < 90; i++) {
			System.out.println(atletassList.get(i).getPersona().data());
			atletasStr[i] = atletassList.get(i).getPersona().data();
		}

		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(140, 247, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(146, 369, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(140, 485, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		buttonCancelar.setBounds(345, 649, 89, 23);
		contentPane.add(buttonCancelar);

		JLabel LabelHoras = new JLabel("Horas:");
		LabelHoras.setBounds(45, 291, 46, 14);
		contentPane.add(LabelHoras);

		JSpinner spinnerHoras = new JSpinner();
		spinnerHoras.setModel(new SpinnerNumberModel(0, null, 24, 1));
		spinnerHoras.setBounds(88, 288, 30, 20);
		contentPane.add(spinnerHoras);

		JLabel LabelMin = new JLabel("Minutos:");
		LabelMin.setBounds(147, 291, 46, 14);
		contentPane.add(LabelMin);

		JLabel LabelSeg = new JLabel("Segundos:");
		LabelSeg.setBounds(245, 291, 46, 14);
		contentPane.add(LabelSeg);

		JSpinner spinnerMin = new JSpinner();
		spinnerMin.setModel(new SpinnerNumberModel(0, null, 60, 1));
		spinnerMin.setBounds(203, 288, 30, 20);
		contentPane.add(spinnerMin);

		JSpinner spinnerSeg = new JSpinner();
		spinnerSeg.setModel(new SpinnerNumberModel(0, null, 60, 1));
		spinnerSeg.setBounds(301, 288, 30, 20);
		contentPane.add(spinnerSeg);

		JLabel LabelCen = new JLabel("Centesimas");
		LabelCen.setBounds(348, 291, 46, 14);
		contentPane.add(LabelCen);

		JSpinner spinnerCen = new JSpinner();
		spinnerCen.setModel(new SpinnerNumberModel(0, null, 100, 1));
		spinnerCen.setBounds(404, 288, 30, 20);
		contentPane.add(spinnerCen);

		JLabel LabelHoras_1 = new JLabel("Horas:");
		LabelHoras_1.setBounds(45, 439, 46, 14);
		contentPane.add(LabelHoras_1);

		JSpinner spinnerHoras_1 = new JSpinner();
		spinnerHoras_1.setBounds(88, 436, 30, 20);
		contentPane.add(spinnerHoras_1);

		JSpinner spinnerHoras_2 = new JSpinner();
		spinnerHoras_2.setModel(new SpinnerNumberModel(0, null, 24, 1));
		spinnerHoras_2.setBounds(88, 559, 30, 20);
		contentPane.add(spinnerHoras_2);

		JLabel LabelHoras_1_1 = new JLabel("Horas:");
		LabelHoras_1_1.setBounds(45, 562, 46, 14);
		contentPane.add(LabelHoras_1_1);

		JLabel LabelMin_1 = new JLabel("Minutos:");
		LabelMin_1.setBounds(140, 439, 46, 14);
		contentPane.add(LabelMin_1);

		JLabel LabelMin_2 = new JLabel("Minutos:");
		LabelMin_2.setBounds(140, 562, 46, 14);
		contentPane.add(LabelMin_2);

		JSpinner spinnerMin_1 = new JSpinner();
		spinnerMin_1.setModel(new SpinnerNumberModel(0, null, 60, 1));
		spinnerMin_1.setBounds(203, 436, 30, 20);
		contentPane.add(spinnerMin_1);

		JSpinner spinnerMin_2 = new JSpinner();
		spinnerMin_2.setModel(new SpinnerNumberModel(0, null, 60, 1));
		spinnerMin_2.setBounds(203, 559, 30, 20);
		contentPane.add(spinnerMin_2);

		JLabel LabelSeg_1 = new JLabel("Segundos:");
		LabelSeg_1.setBounds(245, 439, 46, 14);
		contentPane.add(LabelSeg_1);

		JLabel LabelSeg_2 = new JLabel("Segundos:");
		LabelSeg_2.setBounds(245, 562, 46, 14);
		contentPane.add(LabelSeg_2);

		JSpinner spinnerSeg_1 = new JSpinner();
		spinnerSeg_1.setBounds(301, 436, 30, 20);
		contentPane.add(spinnerSeg_1);

		JSpinner spinnerSeg_2 = new JSpinner();
		spinnerSeg_2.setBounds(301, 556, 30, 20);
		contentPane.add(spinnerSeg_2);

		JLabel LabelCen_1 = new JLabel("Centesimas");
		LabelCen_1.setBounds(348, 439, 46, 14);
		contentPane.add(LabelCen_1);

		JLabel LabelCen_2 = new JLabel("Centesimas");
		LabelCen_2.setBounds(348, 559, 46, 14);
		contentPane.add(LabelCen_2);

		JSpinner spinnerCen_1 = new JSpinner();
		spinnerCen_1.setModel(new SpinnerNumberModel(0, null, 100, 1));
		spinnerCen_1.setBounds(404, 436, 30, 20);
		contentPane.add(spinnerCen_1);

		JSpinner spinnerCen_2 = new JSpinner();
		spinnerCen_2.setModel(new SpinnerNumberModel(0, null, 100, 1));
		spinnerCen_2.setBounds(404, 559, 30, 20);
		contentPane.add(spinnerCen_2);

		JLabel lblNewLabel = new JLabel("idBronce:");
		lblNewLabel.setBounds(28, 528, 46, 14);
		contentPane.add(lblNewLabel);

		DefaultComboBoxModel<Metal> metalesModel = new DefaultComboBoxModel<Metal>();
		MetalDAO mDAO = new MetalDAO(ConexBD.getCon());
		ArrayList<Metal> metalesList = (ArrayList<Metal>) mDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] metalesStr = new String[atletassList.size()];
		for (int i = 0; i < metalesList.size(); i++)
			metalesStr[i] = metalesList.get(i).toString();

		JComboBox<Metal> comboBox = new JComboBox<Metal>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(metalesStr));
		lblprimerpuesto.setLabelFor(comboBox);
		comboBox.setBounds(88, 526, 30, 22);
		contentPane.add(comboBox);

		JComboBox<Metal> comboBox_1 = new JComboBox<Metal>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(metalesStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBox_1.setBounds(88, 404, 30, 22);
		contentPane.add(comboBox_1);

		JComboBox<Metal> comboBox_2 = new JComboBox<Metal>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(metalesStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBox_2.setBounds(88, 331, 30, 22);
		contentPane.add(comboBox_2);

		ArrayList<Metal> m = new ArrayList();
		Connection met = ConexBD.establecerConexion();
		MetalDAO metDAO = new MetalDAO(met);
		m = (ArrayList<Metal>) metDAO.buscarTodos();

		for (int i = 0; i < m.size(); i++) {
			if (m.getClass().equals(Oro.class) && (m.get(i).isAsignada())) {
				ArrayList<Metal> oro = new ArrayList();
				oro.add(m.get(i));
				comboBox.setModel((ComboBoxModel) oro);

			} else if (m.getClass().equals(Plata.class) && (m.get(i).isAsignada())) {
				ArrayList<Metal> plata = new ArrayList();
				plata.add(m.get(i));
				comboBox_1.setModel((ComboBoxModel) plata);

			} else if (m.getClass().equals(Bronce.class) && (m.get(i).isAsignada())) {
				ArrayList<Metal> bronce = new ArrayList();
				bronce.add(m.get(i));
				comboBox_2.setModel((ComboBoxModel) bronce);
			}
		}

		JLabel lblNewLabel_1 = new JLabel("idPlata:");
		lblNewLabel_1.setBounds(27, 408, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("idOro:");
		lblNewLabel_2.setBounds(27, 335, 46, 14);
		contentPane.add(lblNewLabel_2);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(199, 612, 21, 22);
		contentPane.add(chckbxNewCheckBox);

		txtEstablecerComoDefinitiva = new JTextField();
		txtEstablecerComoDefinitiva.setText("Establecer como DEFINITIVA:");
		txtEstablecerComoDefinitiva.setBounds(27, 612, 153, 20);
		contentPane.add(txtEstablecerComoDefinitiva);
		txtEstablecerComoDefinitiva.setColumns(10);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";

				Resultado re = new Resultado();

				if (!chckbxNewCheckBox.isSelected()) {
					errores += "Debe marcar como DEFINITIVO\n";
				}

				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombrePrueba(nombre);
				Prueba nueva = new Prueba();
				if (!valido) {
					errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nueva.setNombre(nombre);
				valido = false;

				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
				valido = Validaciones.validarFechaNuevaPrueba(fecha);
				if (!valido) {
					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
					lblFecha.setForeground(Color.RED);
				} else {
					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
					nueva.setFecha(fechaLD);
				}
				valido = false;
				valido = (comboBoxLugar.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el lugar de celebración de la nueva prueba.\n";
					lblLugar.setForeground(Color.RED);
				} else {
					Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
					nueva.setLugar(lugar);
				}
				valido = false;
				valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
						|| (rbIndividual.isSelected() && rbEquipos.isSelected());
				if (!valido) {
					errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
					rbIndividual.setForeground(Color.RED);
					rbEquipos.setForeground(Color.RED);
				} else {
					nueva.setIndividual(rbIndividual.isSelected() ? true : false);
				}
				valido = false;
				valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
				if (!valido) {
					errores += "Debe seleccionar el Patrocinador de la nueva prueba.\n";
					lblPatrocinador.setForeground(Color.RED);
				} else {
					PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
					String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idPat = Long.valueOf(aux[0]);
					Patrocinador patrocinador = patDAO.buscarPorID(idPat);
					ConexBD.cerrarConexion();
					if (patrocinador == null)
						valido = false;
					else
						nueva.setPatrocinador(patrocinador);
				}

				if (!valido) {
					errores += "Debe seleccionar el puesto\n";
					lblprimerpuesto.setForeground(Color.RED);
				} else {
					AtletaDAO atDAO = new AtletaDAO(ConexBD.getCon());
					String seleccionado = (String) comboBox.getSelectedItem();
					String[] aux = seleccionado.split("\\.");
					long idAt = Long.valueOf(aux[0]);
					Atleta atleta = atDAO.buscarPorID(idAt);
					ConexBD.cerrarConexion();
					if (atleta == null)
						valido = false;
					else
						nueva.setAtleta(atleta);
				}

				long idOro = comboBox.getSelectedIndex();
				float pureza = 0.0F;
				Oro oro = new Oro(idOro, pureza);
				valido = Validaciones.validarId(idOro);
				if (!valido) {
					errores += "El id del oro no es correcto.\n";
				} else
					re.setPrimero(oro);
				valido = false;

				long idPlata = comboBox_1.getSelectedIndex();
				float pureza_2 = 0.0F;
				Plata plata = new Plata(idPlata, pureza_2);
				valido = Validaciones.validarId(idPlata);
				if (!valido) {
					errores += "El id de la plata no es correcto.\n";
				} else
					re.setSegundo(plata);
				valido = false;

				long idBronce = comboBox_2.getSelectedIndex();
				float pureza_3 = 0.0F;
				Bronce bronce = new Bronce(idBronce, pureza_3);
				valido = Validaciones.validarId(idBronce);
				if (!valido) {
					errores += "El id del bronce no es correcto.\n";
				} else
					re.setTercero(bronce);
				valido = false;

				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba " + prueba.getId() + " cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}

				boolean exportadoOK = false;

				PruebaDAO pDAO = new PruebaDAO(ConexBD.establecerConexion());

				long idpruebanueva = pDAO.insertarSinID(nueva);

				if (idpruebanueva <= 0) {

					titulo = "ERROR al insertar el Nuevo Atleta en la BD";
					msj = "Hubo un error y NO se ha insertado el nuevo atleta en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					nueva.setId(idpruebanueva);
					titulo = "Nuevo Atleta insertado en la BD";
					msj = "Se ha insertado correctamente el nuevo atleta:\n" + nueva.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);

					File f = new File("resultado_prueba" + nueva.getId() + ".text");
					FileOutputStream fo;
					try {
						fo = new FileOutputStream(f);
						ObjectOutputStream oos = new ObjectOutputStream(fo);
						oos.writeLong(idpruebanueva);
						oos.writeUTF(nueva.getNombre());
						oos.writeObject((LocalDate) nueva.getFecha());
						// oos.write(nueva.getPatrocinador());

						oos.flush();
						oos.close();
						fo.close();
						titulo = "Nuevo Atleta exportado a fichero";
						msj = "Se ha exportado correctamente el nuevo atleta al fichero " + f.getName();
						JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
						/// Aqui se redirigiría al usuario hacia la pantalla principal
						/// TODO
						System.out.println("Se han exportado los datos del nuevo Atleta al fichero " + f.getName());
					} catch (FileNotFoundException exc) {
						System.out.println("Se ha producido una FileNotFoundException:" + exc.getMessage());
						exc.printStackTrace();
					} catch (IOException ex) {
						System.out.println("Se ha producido una IOException:" + ex.getMessage());
						ex.printStackTrace();
					}

				}
				ConexBD.cerrarConexion();
			}

		});
		buttonAceptar.setBounds(231, 649, 89, 23);
		contentPane.add(buttonAceptar);

	}
}
