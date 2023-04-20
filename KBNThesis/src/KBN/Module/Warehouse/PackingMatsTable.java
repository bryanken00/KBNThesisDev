package KBN.Module.Warehouse;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PackingMatsTable extends JPanel {

	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	
	
	
	public PackingMatsTable() {
		setBounds(0, 0, 1005, 547);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1005, 547);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"BASTA ITO PACKING MATS TO"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
