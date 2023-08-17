package KBNCashier.panels.category;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class panelCategoryList extends JPanel {
	
	private int categoryCount = 0;
	public JButton[] btnCategory;

	public panelCategoryList() {
		setBounds(0, 0, 821, 51);
		setLayout(null);
	}
	
	public void settingUpCount(int count) {
		categoryCount = count;
		settingUP();
	}
	
	private void settingUP() {
		btnCategory = new JButton[categoryCount];
		btnSetup();
	}
	
	private void btnSetup() {
		int x = 10;
		for(int i = 0; i < categoryCount; i++) {
			if(i != 0)
				x += 197;
			btnCategory[i] = new JButton("New button");
			btnCategory[i].setBounds(x, 5, 177, 29);
			btnCategory[i].setFocusable(false);
			btnCategory[i].setBorderPainted(false);
			btnCategory[i].setBackground(Color.WHITE);
			add(btnCategory[i]);
		}
		this.setPreferredSize(new Dimension(x+197, 1));
	}
}
