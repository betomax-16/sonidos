package sonidos.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sonidos.op.Cliente;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = Cliente.getDatos(txtUser.getText(), txtPass.getText());
				if (cliente != null) {					
					Principal prin = new Principal(cliente);
					prin.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(101, 190, 220, 28);
		contentPane.add(btnNewButton);

		txtUser = new JTextField();
		txtUser.setBounds(101, 53, 220, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(101, 114, 220, 28);
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(101, 37, 126, 14);
		contentPane.add(lblNombreDeUsuario);

		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(101, 100, 103, 14);
		contentPane.add(lblNewLabel);

		JLabel lblnoTienesCuenta = new JLabel("\u00BFNo tienes cuenta? Registrate aqu\u00ED");
		lblnoTienesCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Registro reg = new Registro();							
				reg.setVisible(true);
				dispose();
			}
		});
		lblnoTienesCuenta.setForeground(Color.BLUE);
		lblnoTienesCuenta.setBounds(101, 165, 220, 14);
		contentPane.add(lblnoTienesCuenta);
	}
}