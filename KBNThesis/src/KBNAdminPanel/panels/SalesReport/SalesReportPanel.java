package KBNAdminPanel.panels.SalesReport;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class SalesReportPanel extends JPanel {
	
	
	private JTable table;
	public DefaultTableModel main;

	public SalesReportPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBackground(Color.WHITE);
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		
		JScrollPane container = new JScrollPane();
		container.setBounds(10, 75, 969, 613);
		panel.add(container);
		
		table = new JTable();
		main = new DefaultTableModel(table.getRowCount(), table.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
		container.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		
	}
}
