package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerAccount extends JPanel {
	
	//Table
	public String columnDefaultData[];
	public DefaultTableModel main;
	
	public JLabel lblCustomerAccount;
	public JButton btnCreateAccount;
	public JTextField textField;
	public JTable table;
	public JScrollPane scrollPane;
	public JPanel panel_1;
	
	public CreateAccountDialog cad;
	public JButton btnSearch;
	
	public CustomerAccount() {
		this.setBounds(0, 0, 1066, 647);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 64, 989, 60);
		add(panel);
		panel.setLayout(null);
		
		lblCustomerAccount = new JLabel("Customer Account");
		lblCustomerAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblCustomerAccount.setBounds(10, 10, 159, 40);
		panel.add(lblCustomerAccount);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCreateAccount.setFocusable(false);
		btnCreateAccount.setBorderPainted(false);
		btnCreateAccount.setBackground(Color.WHITE);
		btnCreateAccount.setBounds(507, 7, 159, 46);
		panel.add(btnCreateAccount);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(692, 7, 200, 46);
		panel.add(textField);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/searchBarIcon.png")));
		btnSearch.setOpaque(false);
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(902, 7, 50, 46);
		panel.add(btnSearch);
		
		panel_1 = new JPanel();
		panel_1.setBounds(31, 135, 989, 474);
		add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 989, 474);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Email", "First Name", "Last Name", "Details"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
