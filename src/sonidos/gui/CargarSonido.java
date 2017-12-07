package sonidos.gui;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import sonidos.op.Clase;
import sonidos.op.Cliente;
import java.nio.file.*;
import sonidos.op.Sonido;

import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CargarSonido extends JDialog {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Cliente cliente;
	File ficheroA, ficheroI;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarSonido dialog = new CargarSonido(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CargarSonido(Cliente Cliente) {
		this.cliente = Cliente;
		
		setModal(true);
		
		setTitle("Subir Sonido");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
 		setBounds(100, 100, 500, 231); 
		contentPane = new JPanel(); 
		setContentPane(contentPane); 
		contentPane.setLayout(null); 

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(236, 12, 210, 20); 
		contentPane.add(textField); 
		textField.setColumns(10);

		JLabel lblAudio = new JLabel("Audio");
		lblAudio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAudio.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 51, 163, 20);
		contentPane.add(textField_1); 
		textField_1.setColumns(10);
		
		ArrayList<Clase> clases = Clase.getAll();
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		for (int i = 0; i < clases.size(); i++) {
			comboBox.addItem(clases.get(i).getClase());
		}		
		
		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label = new JLabel("");
		label.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton_2 = new JButton("+");
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc1=new JFileChooser();
				fc1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3","mp3");
				fc1.setFileFilter(filtro);
				int seleccion=fc1.showOpenDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION){
					ficheroA=fc1.getSelectedFile();
					textField_1.setText(ficheroA.getAbsolutePath());
				}
			}
		});
		
		JButton btnAgregarImaegen = new JButton("Agregar Imagen");
		contentPane.add(btnAgregarImaegen);
		btnAgregarImaegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc=new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG","jpg");
				fc.setFileFilter(filtro);
				int seleccion=fc.showOpenDialog(contentPane);
				if(seleccion==JFileChooser.APPROVE_OPTION){
					ficheroI=fc.getSelectedFile();
					ImageIcon imagen = new ImageIcon(ficheroI.getAbsolutePath());										
					Image img = imagen.getImage();
					Image otraimg = img.getScaledInstance(130,130,java.awt.Image.SCALE_SMOOTH); 
					ImageIcon otroicon = new ImageIcon(otraimg);																									
					label.setIcon(otroicon);
					label.setText(ficheroI.getAbsolutePath());
				}
			}
		});
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titulo = textField.getText();
				String imagen = label.getText();
				String audio = textField_1.getText();
				String tipo = (String) comboBox.getSelectedItem();
				int cliente = Cliente.getId();
				int numero = (int) (Math.random() * (1000000-1000000)) + 1000000;
				if (titulo != "" && imagen != "" && audio != "" && tipo != "" && cliente != 0) {
					Path origenI = Paths.get(imagen);
					Path destinoI = Paths.get("C:\\Users\\User\\eclipse-workspace\\sonidos\\src\\recursos\\ico\\imagen" + numero + ".jpg");
					String absolutePathI = destinoI.toString();
			        try {
						Files.copy(origenI, destinoI, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        Path origenA = Paths.get(audio);
					Path destinoA = Paths.get("C:\\Users\\User\\eclipse-workspace\\sonidos\\bin\\recursos\\audio\\audio" + numero +".mp3");
					String absolutePathA = destinoA.toString();
			        try {
						Files.copy(origenA, destinoA, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Sonido son = new Sonido(titulo, absolutePathI, absolutePathA, tipo, cliente);
					son.guardar();
					dispose();
				}
				else{
					System.out.println("Verificar Datos a Guardar");
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAudio, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnAgregarImaegen)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2)))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulo)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAudio)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarImaegen)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
}
