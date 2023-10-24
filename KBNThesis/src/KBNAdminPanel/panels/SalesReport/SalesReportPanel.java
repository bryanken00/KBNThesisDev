package KBNAdminPanel.panels.SalesReport;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SalesReportPanel extends JPanel {
	
	
	public JTable table;
	public DefaultTableModel main;
	public JComboBox comboBox;
	public JMonthChooser monthChooser;
	public JButton btnPrint;

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
		header.setBackground(new Color(151,175,149));
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		
		JLabel lblNewLabel = new JLabel("Sales Overview");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(35, 5, 334, 42);
		header.add(lblNewLabel);

		String [] categories = {"Weekly", "Monthly","Yearly"};
		comboBox = new JComboBox(categories);
		comboBox.setBounds(564, 8, 162, 37);
		header.add(comboBox);
		
		monthChooser = new JMonthChooser();
		monthChooser.setBounds(736, 8, 114, 37);
		header.add(monthChooser);
		
		btnPrint = new JButton("Print");
		btnPrint.setForeground(new Color(255, 255, 255));
		btnPrint.setVerticalTextPosition(SwingConstants.CENTER);
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPrint.setFocusable(false);
		btnPrint.setBorderPainted(false);
		btnPrint.setBackground(new Color(4,109,0));
		btnPrint.setBounds(860, 9, 99, 35);
		header.add(btnPrint);
		
		JScrollPane container = new JScrollPane();
		container.setBounds(10, 75, 969, 613);
		panel.add(container);
		
		table = new JTable();
		main = new DefaultTableModel(table.getRowCount(), table.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		container.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		String[] columnidentifier = {"Products", "Week 1","Week 2","Week 3", "Week 4", "Total"}; // Default
		main.setColumnIdentifiers(columnidentifier);
		table.setModel(main);
		
		TableColumn column = table.getColumnModel().getColumn(0); // This is the first column
        column.setPreferredWidth(400);
        table.setRowHeight(50);
        
        Font cellFont = new Font("Arial", Font.PLAIN, 20);
        table.setFont(cellFont);

	}
}
