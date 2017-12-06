package sonidos.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import sonidos.op.Sonido;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComponentAudio extends JPanel {
	
	private Sonido sonido;
	/**
	 * Create the panel.
	 */
	public ComponentAudio(Sonido sonido) {
		setBorder(null);
		this.sonido = sonido;
		JLabel lblTitulo = new JLabel(sonido.getTitulo());
		lblTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTitulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(sonido.getId());
			}
		});
		
		JLabel lbImage = new JLabel("");
		lbImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(sonido.getId());
			}
		});
		lbImage.setIcon(new ImageIcon(ComponentAudio.class.getResource("/recursos/ico/resonance_audio_logo_large.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblTitulo)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lbImage, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(lbImage, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(lblTitulo)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

}
