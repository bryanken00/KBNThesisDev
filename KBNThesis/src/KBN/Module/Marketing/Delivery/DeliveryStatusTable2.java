package KBN.Module.Marketing.Delivery;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DeliveryStatusTable2 extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	
	public final JScrollPane scrollPane = new JScrollPane();
	public DeliveryStatusTable2() {
		setBounds(0, 0, 933, 550);
		setLayout(null);
		scrollPane.setBounds(0, 0, 933, 550);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Order Date","Reference Number","Delivery ID","Delivery Date","Date Delivered","Location","Delivered By"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
