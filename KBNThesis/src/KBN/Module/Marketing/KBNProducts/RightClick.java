package KBN.Module.Marketing.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class RightClick extends JPanel {
	public JButton btnEdit;
	public JButton btnAddItem;
	public JButton btnArchive;

	/**
	 * Create the panel.
	 */
	public RightClick() {
		setBounds(100, 100, 200, 90);
		setLayout(null);
		
		btnAddItem = new JButton("Add New Product");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setFocusable(false);
		btnAddItem.setBorderPainted(false);
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(0, 0, 200, 30);
		add(btnAddItem);
		
		btnEdit = new JButton("Edit Details");
		btnEdit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnEdit.setFocusable(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(0, 30, 200, 30);
		add(btnEdit);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setFocusable(false);
		btnArchive.setBorderPainted(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(0, 60, 200, 30);
		add(btnArchive);

	}
}
