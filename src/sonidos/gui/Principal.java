package sonidos.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import sonidos.op.Cliente;
import sonidos.op.Sonido;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.JInternalFrame;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Cliente cliente;
	private ArrayList<Sonido> sonidos;
	JInternalFrame internalFrameAudios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void cargarSonidos(String tipo){
		if (this.internalFrameAudios != null) {
			this.internalFrameAudios.dispose();
		}
		sonidos = Sonido.buscarPorTipo(tipo);
		
		this.internalFrameAudios = new JInternalFrame("Audios");
		internalFrameAudios.setBorder(null);
		internalFrameAudios.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		
		GroupLayout groupLayout = new GroupLayout(internalFrameAudios.getContentPane());
		GroupLayout.Group grupoH = groupLayout.createSequentialGroup()
											 .addGap(18)
											 .addContainerGap(1117, Short.MAX_VALUE);
		GroupLayout.Group grupoV = groupLayout.createParallelGroup(Alignment.BASELINE);
		for (Sonido sonido : sonidos) {
			ComponentAudio audio = new ComponentAudio(sonido);
			grupoH.addComponent(audio);
			grupoV.addComponent(audio);
		}

		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(grupoH)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						  .addGap(28)
						  .addGroup(grupoV)
						  .addContainerGap(545, Short.MAX_VALUE))
		);
		
		internalFrameAudios.getContentPane().setLayout(groupLayout);
		contentPane.add(internalFrameAudios, BorderLayout.CENTER);
		internalFrameAudios.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public Principal(Cliente cliente) {
		this.cliente = cliente;
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.add(panel, BorderLayout.WEST);
		
		JButton btnNature = new JButton("Naturaleza");
		btnNature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSonidos("naturaleza");
			}
		});
		
		JButton btnCity = new JButton("Ciudad");
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarSonidos("ciudad");
			}
		});
		
		JButton btnAnimals = new JButton("Animales");
		btnAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSonidos("animales");
			}
		});
		
		JButton btnPeople = new JButton("Personas");
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSonidos("personas");
			}
		});
		
		JButton btnOut = new JButton("Cerrar Sesión");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnCity, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
				.addComponent(btnPeople, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
				.addComponent(btnAnimals, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
				.addComponent(btnNature, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
				.addComponent(btnOut, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnCity, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnNature, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnAnimals, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnPeople, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(btnOut, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JButton btnNewAudio = new JButton("Nuevo");
		ImageIcon icon = new ImageIcon(Principal.class.getResource("/recursos/ico/new_add_insert_file_13948.png"));
		Image img = icon.getImage();
		Image otraimg = img.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH); 
		ImageIcon otroicon = new ImageIcon(otraimg);
		btnNewAudio.setIcon(otroicon);
		btnNewAudio.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnNewAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargarSonido cargar = new CargarSonido();
				cargar.setVisible(true);
			}
		});
		
		JLabel lbUserName = new JLabel(this.cliente.getNombre());
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		icon = new ImageIcon(Principal.class.getResource("/recursos/ico/Feedbin-Icon-home-search.svg.png"));
		img = icon.getImage();
		otraimg = img.getScaledInstance(10,10,java.awt.Image.SCALE_SMOOTH); 
		otroicon = new ImageIcon(otraimg);
		btnSearch.setIcon(otroicon);
		
		JLabel lblA = new JLabel("");
		lblA.setIcon(new ImageIcon(Principal.class.getResource("/recursos/ico/profile_logged_default.png")));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(122)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewAudio, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(lblA)
					.addGap(15)
					.addComponent(lbUserName)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblA)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSearch)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewAudio, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbUserName)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
						
		
		
		/*GroupLayout groupLayout = new GroupLayout(internalFrameAudios.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addGap(18)
							.addComponent(btnNewButton_4)
							.addGap(18)
							.addComponent(btnNewButton_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_2)))
					.addContainerGap(898, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5))
					.addContainerGap(518, Short.MAX_VALUE))
		);
		internalFrameAudios.getContentPane().setLayout(groupLayout);
		contentPane.add(internalFrameAudios, BorderLayout.CENTER);
		internalFrameAudios.setVisible(true);*/
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cargarSonidos("animales");
			}
		});		
	}
}