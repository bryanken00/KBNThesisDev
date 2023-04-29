package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CustomerAccount extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	public JButton btnCreate;
	public JLabel lblNewLabel;
	
	public CustomerAccount() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 113, 939, 556);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("search bar");
		txtSearchBar.setBounds(338, 57, 483, 28);
		add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(831, 57, 120, 28);
		add(btnCreate);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
		lblNewLabel.setBounds(0, 0, 989, 699);
		add(lblNewLabel);
		
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Account", "Email", "Contact", "Status", "Details"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
