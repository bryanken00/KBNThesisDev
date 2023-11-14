 package KBNAdminPanel.panels.Employee;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class EmployeeList extends JPanel {
	
	public JScrollPane scrollPane;
	public JButton btnTypes;
	public JButton btnDepartment;
	
	
	public EmployeeList() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(1, 1, 966, 610);
//		setBounds(0, 0, 969, 613);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 966, 66);
		add(panel);
		panel.setLayout(null);
		
		btnTypes = new JButton("Types");
		btnTypes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTypes.setBackground(new Color(255, 255, 255));
		btnTypes.setBounds(74, 16, 117, 34);
		btnTypes.setFocusable(false);
		btnTypes.setBorderPainted(false);
		btnTypes.setBackground(new Color(255, 255, 255));
		panel.add(btnTypes);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(265, 16, 96, 34);
		panel.add(lblName);
		
		btnDepartment = new JButton("Types");
		btnDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDepartment.setFocusable(false);
		btnDepartment.setBorderPainted(false);
		btnDepartment.setBackground(Color.WHITE);
		btnDepartment.setBounds(435, 16, 117, 34);
		panel.add(btnDepartment);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContact.setBounds(626, 16, 96, 34);
		panel.add(lblContact);
		
		JLabel lblAction = new JLabel("Action");
		lblAction.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAction.setBounds(796, 16, 96, 34);
		panel.add(lblAction);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 66, 966, 544);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		add(scrollPane);
	}
}
