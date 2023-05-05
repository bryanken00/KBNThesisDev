package KBN.Module.Warehouse;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ArchiveRightClick extends JPanel {
	private JButton btnArchive;

	/**
	 * Create the panel.
	 */
	public ArchiveRightClick() {
		setBounds(100, 100, 120, 30);
		setLayout(null);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setFocusable(false);
		btnArchive.setBorderPainted(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(0, 0, 120, 30);
		add(btnArchive);

	}
}
