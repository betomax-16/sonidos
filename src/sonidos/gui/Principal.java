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
import sonidos.op.ConexionBD;
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
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JMenuItem;
import java.awt.Frame;

public class Principal extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 244, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Personas");
		btnNewButton.setBounds(0, 43, 244, 50);
		panel.add(btnNewButton);
		
		JButton btnNaturaleza = new JButton("Naturaleza");
		btnNaturaleza.setBounds(0, 93, 244, 50);
		panel.add(btnNaturaleza);
		
		JButton btnCiudad = new JButton("Ciudad");
		btnCiudad.setBounds(0, 143, 244, 50);
		panel.add(btnCiudad);
		
		JButton btnAnimales = new JButton("Animales");
		btnAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnimales.setBounds(0, 192, 244, 50);
		panel.add(btnAnimales);
		
		JLabel lblClasesPorDefecto = new JLabel("Clases por Defecto");
		lblClasesPorDefecto.setBounds(10, 18, 145, 14);
		panel.add(lblClasesPorDefecto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(490, 292, -120, -96);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1354, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("Agregar Sonido");
		mnNewMenu.setBounds(0, 0, 164, 37);
		panel_1.add(mnNewMenu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 278, 244, 437);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clases Personalizadas");
		lblNewLabel.setBounds(10, 11, 145, 14);
		panel_2.add(lblNewLabel);
		
		JButton button = new JButton("+");
		button.setBounds(177, 3, 41, 31);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(241, 36, 1113, 679);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(556, 5, 1, 1);
		panel_3.add(internalFrame);
		internalFrame.setUI(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setForeground(Color.BLACK);
		panel_4.setBounds(10, 541, 1093, 127);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/recursos/ico/play.png")));
		btnNewButton_1.setBounds(502, 11, 173, 105);
		panel_4.add(btnNewButton_1);
		internalFrame.setVisible(true);
		ImageIcon icon = new ImageIcon(Principal.class.getResource("/recursos/ico/new_add_insert_file_13948.png"));
		Image img = icon.getImage();
		Image otraimg = img.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH); 
		ImageIcon otroicon = new ImageIcon(otraimg);
		icon = new ImageIcon(Principal.class.getResource("/recursos/ico/Feedbin-Icon-home-search.svg.png"));
		img = icon.getImage();
		otraimg = img.getScaledInstance(10,10,java.awt.Image.SCALE_SMOOTH); 
		otroicon = new ImageIcon(otraimg);
	}
}
