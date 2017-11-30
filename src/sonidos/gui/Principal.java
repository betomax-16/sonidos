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

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
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
		
		JButton btnCity = new JButton("Ciudad");
		
		JButton btnAnimals = new JButton("Animales");
		
		JButton btnPeople = new JButton("Personas");
		
		JButton btnOut = new JButton("Cerrar Sesión");
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
		ImageIcon icon = new ImageIcon("C:\\Users\\betom\\workspace\\sonidos\\recursos.icon\\new_add_insert_file_13948.png");
		Image img = icon.getImage();
		Image otraimg = img.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH); 
		ImageIcon otroicon = new ImageIcon(otraimg);
		btnNewAudio.setIcon(otroicon);
		btnNewAudio.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnNewAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lbUserName = new JLabel("UserName");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		icon = new ImageIcon("C:\\Users\\betom\\workspace\\sonidos\\recursos.icon\\Feedbin-Icon-home-search.svg.png");
		img = icon.getImage();
		otraimg = img.getScaledInstance(10,10,java.awt.Image.SCALE_SMOOTH); 
		otroicon = new ImageIcon(otraimg);
		btnSearch.setIcon(otroicon);
		
		JLabel lblA = new JLabel("");
		lblA.setIcon(new ImageIcon("C:\\Users\\betom\\workspace\\sonidos\\recursos.icon\\profile_logged_default.png"));
		
		
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
		
		JInternalFrame internalFrameAudios = new JInternalFrame("Audios");
		internalFrameAudios.setBorder(null);
		internalFrameAudios.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setCursor(new Cursor(HAND_CURSOR));
			}
		});
		lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\betom\\workspace\\sonidos\\recursos.icon\\resonance_audio_logo_large.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setCursor(new Cursor(HAND_CURSOR));
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(internalFrameAudios.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(1073))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addContainerGap(423, Short.MAX_VALUE))
		);
		internalFrameAudios.getContentPane().setLayout(groupLayout);
		contentPane.add(internalFrameAudios, BorderLayout.CENTER);
		internalFrameAudios.setVisible(true);
	}
}
