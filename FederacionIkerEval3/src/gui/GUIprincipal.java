package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class GUIprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIprincipal frame = new GUIprincipal();
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
	public GUIprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("horas");
		lblNewLabel.setBounds(32, 33, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("minutos");
		lblNewLabel_1.setBounds(32, 78, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("segundos");
		lblNewLabel_2.setBounds(32, 123, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("centesimas");
		lblNewLabel_3.setBounds(32, 169, 62, 14);
		panel.add(lblNewLabel_3);
		
		JSpinner horas = new JSpinner();
		horas.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		horas.setBounds(122, 30, 30, 20);
		panel.add(horas);
		
		JSpinner minutos = new JSpinner();
		minutos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		minutos.setBounds(122, 75, 30, 20);
		panel.add(minutos);
		
		JSpinner segundos = new JSpinner();
		segundos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		segundos.setBounds(122, 120, 30, 20);
		panel.add(segundos);
		
		JSpinner centesimas = new JSpinner();
		centesimas.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		centesimas.setBounds(122, 166, 30, 20);
		panel.add(centesimas);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(171, 205, 89, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("New label");
		label.setBounds(244, 33, 30, 0);
		panel.add(label);
	}
}
