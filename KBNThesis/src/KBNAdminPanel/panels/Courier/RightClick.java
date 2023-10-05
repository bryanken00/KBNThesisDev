package KBNAdminPanel.panels.Courier;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class RightClick extends JPanel {
	public JButton btnEdit;
	public JButton btnView;

	public RightClick() {
		setBounds(0, 0, 150, 61);
		setLayout(null);
		
		btnEdit = new JButton("View");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setFocusable(false);
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEdit.setBackground(new Color(8, 104, 0));
		btnEdit.setBounds(0, 0, 150, 30);
		add(btnEdit);
		
		btnView = new JButton("Edit");
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnView.setFocusable(false);
		btnView.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnView.setBackground(new Color(8, 104, 0));
		btnView.setBounds(0, 31, 150, 30);
		add(btnView);
	}

}
