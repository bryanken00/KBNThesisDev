package KBNAdminPanel.panels.Courier;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CourierPanel extends JPanel {
	
	public JTextField txtSearchBar;
	public JButton btnSearch;
	public JButton btnCreate;
	public JTable table;
	public DefaultTableModel main;
	private String[] columnDefaultData;

	public CourierPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(255, 255, 255));
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		header.setLayout(null);
		
		JLabel lblEmployeeList = new JLabel("Courier List");
		lblEmployeeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmployeeList.setBounds(10, 11, 235, 31);
		header.add(lblEmployeeList);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(CourierPanel.class.getResource("/KBNAdminPanel/resources/search.png")));
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSearch.setOpaque(false);
		btnSearch.setFocusable(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(789, 11, 37, 31);
		header.add(btnSearch);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(607, 11, 181, 31);
		header.add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		btnCreate = new JButton("+ New");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setFocusable(false);
		btnCreate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCreate.setBackground(new Color(8, 104, 0));
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBounds(856, 11, 103, 31);
		header.add(btnCreate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 969, 613);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"CourierID", "Full Name", "Address", "Contact"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		
		//Designing
		table.setRowHeight(30);
	}
}
