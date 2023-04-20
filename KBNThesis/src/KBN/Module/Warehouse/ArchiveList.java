 package KBN.Module.Warehouse;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArchiveList extends JPanel {


	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	
	
	
	public ArchiveList() {
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
		columnDefaultData = new String[] {"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME", "RELEASED VOLUME", "PRODUCT DATE","USER - Archive", "ARCHIVE DATE"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);

		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
	}
}
