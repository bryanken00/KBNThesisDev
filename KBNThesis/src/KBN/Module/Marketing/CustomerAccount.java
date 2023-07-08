package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

public class CustomerAccount extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	public JButton btnCreate; 
	public JLabel lblNewLabel;
	public JLabel lblNotif;
	public JButton btnClientProfile;
	
	public CustomerAccount() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 113, 939, 504);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("search bar");
		txtSearchBar.setBounds(24, 59, 483, 28);
		add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(602, 57, 120, 28);
		btnCreate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCreate.setFocusable(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(Color.WHITE);
		add(btnCreate);
		
		lblNotif = new JLabel("icon");
		lblNotif.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification.png")));
		lblNotif.setBounds(917, 11, 32, 32);
		add(lblNotif);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
		btnClientProfile.setBorderPainted(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(797, 640, 166, 28);
		add(btnClientProfile);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
		lblNewLabel.setBounds(0, 0, 989, 699);
		add(lblNewLabel);
		
		

		
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"User ID","Account","Email", "Contact", "Brand", "Account Type"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
