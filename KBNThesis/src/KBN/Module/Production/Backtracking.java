package KBN.Module.Production;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Backtracking extends JPanel {


	private String columnDefaultData[];
	private DefaultTableModel main;
	private JScrollPane scrollPane;
	private JTable table;
	
	public Backtracking() {
		setBounds(0, 0, 1264, 573);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 573);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Product Name", "Serial Number", "Date", "Received By", "Details"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
