package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DeliveryStatus extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	private JTextField txtSearchbar;
	
	public DeliveryStatus() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 107, 933, 550);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("List of Deliveries");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(26, 11, 202, 76);
		add(lblNewLabel);
		
		txtSearchbar = new JTextField();
		txtSearchbar.setText("searchbar");
		txtSearchbar.setBounds(713, 42, 191, 29);
		add(txtSearchbar);
		txtSearchbar.setColumns(10);
		
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"BASTA ITO DELIVERY STATUS TO (MARKETING)"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
