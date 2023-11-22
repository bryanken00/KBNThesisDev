package KBN.Module.Marketing.ConfirmationProduct;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class ConfirmationListPanel extends JPanel{
	
	public JScrollPane scrollPane;
	public JComboBox comboBox;
	
	public ConfirmationListPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 320, 677);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 67, 320, 610);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(75, 119, 71));
		panel.setBounds(10, 11, 300, 45);
		add(panel);
		panel.setLayout(null);

		String[] status = {"All", "Pending", "Completed"};
		comboBox = new JComboBox(status);
		comboBox.setBounds(10, 11, 183, 23);
		panel.add(comboBox);
		
	}
}
