package KBN.Module.Production;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BacktrackingNav extends JPanel {
	private JTextField textField;
	private JButton btnSearch;
	
	public BacktrackingNav() {
		setBounds(0, 74, 1264, 75);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(938, 18, 200, 46);
		add(textField);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(BacktrackingNav.class.getResource("/KBN/resources/searchBarIcon.png")));
		btnSearch.setOpaque(false);
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(1159, 18, 50, 46);
		add(btnSearch);
	}
}
