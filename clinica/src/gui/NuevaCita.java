package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;

public class NuevaCita extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaCita frame = new NuevaCita();
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
	public NuevaCita() {
		setTitle("Nueva Cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Identificador del paciente: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(90, 32, 167, 31);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(246, 39, 141, 19);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Rango horario: ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(90, 85, 98, 19);
		panel.add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mañana");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(117, 119, 103, 21);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tarde");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(222, 119, 103, 21);
		panel.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("Introduzca fecha y hora: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(90, 172, 146, 21);
		panel.add(lblNewLabel_2);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1652824800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinner.setBounds(247, 172, 115, 20);
		panel.add(spinner);

		JLabel lblNewLabel_3 = new JLabel("Tipo de cita: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(90, 226, 85, 19);
		panel.add(lblNewLabel_3);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Revisión");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_2.setBounds(117, 258, 103, 21);
		panel.add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Intervención");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_3.setBounds(222, 258, 103, 21);
		panel.add(rdbtnNewRadioButton_3);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(117, 362, 85, 21);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
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

		btnNewButton_1.setBounds(240, 362, 85, 21);
		panel.add(btnNewButton_1);
	}
}
