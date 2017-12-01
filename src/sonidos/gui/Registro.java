package sonidos.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(180, 15, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(100, 18, 70, 14);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 46, 197, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(95, 49, 75, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario (\u00FAnico):");
		lblNombreDeUsuario.setBounds(10, 80, 160, 14);
		contentPane.add(lblNombreDeUsuario);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 77, 197, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico:");
		lblCorreoElectrnico.setBounds(49, 112, 121, 14);
		contentPane.add(lblCorreoElectrnico);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 108, 197, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(81, 143, 89, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblRepiteLaContrasea = new JLabel("Repite la Contrase\u00F1a:");
		lblRepiteLaContrasea.setBounds(34, 174, 136, 14);
		contentPane.add(lblRepiteLaContrasea);
		
		JCheckBox chckbxAceptoLosTrminos = new JCheckBox("He le\u00EDdo y acepto los t\u00E9rminos y condiciones de la aplicaci\u00F3n");
		chckbxAceptoLosTrminos.setBounds(49, 218, 367, 23);
		contentPane.add(chckbxAceptoLosTrminos);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 139, 197, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(180, 171, 197, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Registrarme");
		btnNewButton.setBounds(103, 256, 225, 34);
		contentPane.add(btnNewButton);
	}
}
