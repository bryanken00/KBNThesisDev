package KBN.Module.Warehouse.Archive;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class RestoreRightClick extends JPanel {
	public JButton btnRestore;

	/**
	 * Create the panel.
	 */
	public RestoreRightClick() {
		setBounds(100, 100, 120, 30);
		setLayout(null);
		
		btnRestore = new JButton("Restore");
		btnRestore.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRestore.setFocusable(false);
		btnRestore.setBorderPainted(false);
		btnRestore.setBackground(Color.WHITE);
		btnRestore.setBounds(0, 0, 120, 30);
		add(btnRestore);

	}
}
