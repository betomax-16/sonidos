package sonidos.gui; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sonidos.op.Cliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Registro extends JDialog {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLastname;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JPasswordField txtConfirmPass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro dialog = new Registro();
					dialog.setVisible(true);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Registro reg = (Registro)e.getSource();
				reg.toFront();
				reg.getFocusableWindowState();
			}
		});
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(180, 15, 197, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(100, 18, 70, 14);
		contentPane.add(lblNombre);
		
		txtLastname = new JTextField();
		txtLastname.setBounds(180, 46, 197, 20);
		contentPane.add(txtLastname);
		txtLastname.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(95, 49, 75, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario (\u00FAnico):");
		lblNombreDeUsuario.setBounds(10, 80, 160, 14);
		contentPane.add(lblNombreDeUsuario);
		
		txtUser = new JTextField();
		txtUser.setBounds(180, 77, 197, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico:");
		lblCorreoElectrnico.setBounds(49, 112, 121, 14);
		contentPane.add(lblCorreoElectrnico);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(180, 108, 197, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(81, 143, 89, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblRepiteLaContrasea = new JLabel("Repite la Contrase\u00F1a:");
		lblRepiteLaContrasea.setBounds(34, 174, 136, 14);
		contentPane.add(lblRepiteLaContrasea);
		
		JCheckBox checkBox = new JCheckBox("He le\u00EDdo y acepto los t\u00E9rminos y condiciones de la aplicaci\u00F3n");
		checkBox.setBounds(49, 218, 367, 23);
		contentPane.add(checkBox);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(180, 139, 197, 20);
		contentPane.add(txtPass);
		
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setBounds(180, 171, 197, 20);
		contentPane.add(txtConfirmPass);
		
		JButton btnSave = new JButton("Registrarme");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtName.getText();
				String apellidos = txtLastname.getText();
				String usuario = txtUser.getText();
				String correo = txtEmail.getText();
				String pass = txtPass.getText();
				String confirmPass = txtConfirmPass.getText();
								
				if (nombre.trim() != "" && apellidos.trim() != "" && usuario.trim() != "" &&
					correo.trim() != "" && pass.trim() != "" && pass.trim().equals(confirmPass.trim()) && checkBox.isSelected()) {
					Cliente cli = new Cliente(usuario, nombre, apellidos, pass, correo);
					if (cli.guardar() > 0) {
						Cliente cliente = Cliente.getDatos(cli.getUsuario(), cli.getContrasena()); 
						if (cliente != null) {
							Principal prin = new Principal(cliente);
							prin.setVisible(true);
							dispose();
						}
					}
				}
				else{
					
				}
			}
		});
		btnSave.setBounds(103, 256, 225, 34);
		contentPane.add(btnSave);
	}
}
