package KBN.Module.Marketing.Delivery;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeliveryStatusTable1 extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	
	public final JScrollPane scrollPane = new JScrollPane();
	public DeliveryStatusTable1() {
		setBounds(0, 0, 933, 550);
		setLayout(null);
		scrollPane.setBounds(0, 0, 933, 550);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Order Date","Reference Number","Delivery ID","Delivery Date","Location","Status", "CourierID"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
