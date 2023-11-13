package KBN.Module.Warehouse.Packaging;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ArchiveRightClick extends JPanel {
	public JButton btnArchive;
	public JButton btnAddItem;
	public JButton btnQRGen;

	/**
	 * Create the panel.
	 */
	public ArchiveRightClick() {
		setBounds(100, 100, 200, 90);
		setLayout(null);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAddItem.setFocusable(false);
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(0, 0, 200, 30);
		add(btnAddItem);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnArchive.setFocusable(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(0, 30, 200, 30);
		add(btnArchive);
		
		btnQRGen = new JButton("Generate QR");
		btnQRGen.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnQRGen.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQRGen.setFocusable(false);
		btnQRGen.setBackground(Color.WHITE);
		btnQRGen.setBounds(0, 60, 200, 30);
		add(btnQRGen);

	}
}
