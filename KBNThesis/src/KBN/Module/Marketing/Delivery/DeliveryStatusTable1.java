package KBN.Module.Marketing.Delivery;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DeliveryStatusTable1 extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	
	public final JScrollPane scrollPane = new JScrollPane();
	public DeliveryStatusTable1() {
		setBounds(0, 0, 933, 532);
		setLayout(null);
		scrollPane.setBounds(0, 0, 933, 532);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Order Date","Reference Number","Delivery ID","Delivery Date","Location","Status", "CourierID"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
