package KBN.Module.Marketing.RebrandingNew;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class RebrandingRightClick extends JPanel {
	public JButton btnEdit;
	public JButton btnAddItem;
	public JButton btnArchive;

	/**
	 * Create the panel.
	 */
	public RebrandingRightClick() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 200, 90);
		setLayout(null);
		
		btnAddItem = new JButton("Add New Product");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setFocusable(false);
		btnAddItem.setBorderPainted(false);
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(1, 1, 198, 29);
		add(btnAddItem);
		
		btnEdit = new JButton("Edit Details");
		btnEdit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnEdit.setFocusable(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(1, 30, 198, 30);
		add(btnEdit);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setFocusable(false);
		btnArchive.setBorderPainted(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(1, 60, 198, 29);
		add(btnArchive);

	}
}
