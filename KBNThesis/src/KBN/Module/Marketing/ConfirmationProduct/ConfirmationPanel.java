package KBN.Module.Marketing.ConfirmationProduct;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ConfirmationPanel extends JPanel {
	
	public JPanel confirmPanel;
	public JTable table;
	public JLabel lblInputted;
	public JLabel lblDateInputted;
	
	public DefaultTableModel main;
	private String[] columnDefaultData;
	
	public ConfirmationPanel() {
		setBounds(0, 0, 989, 699);
        setLayout(null);
		
        confirmPanel = new JPanel();
        confirmPanel.setBounds(10, 11, 320, 677);
        confirmPanel.setLayout(null);
        add(confirmPanel);
        
        JPanel container = new JPanel();
        container.setBorder(new LineBorder(new Color(0, 0, 0)));
        container.setBounds(340, 11, 639, 677);
        add(container);
        container.setLayout(null);
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(75, 119, 71, 200));
        topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        topPanel.setBounds(10, 11, 619, 81);
        topPanel.setLayout(null);
        container.add(topPanel);
        
        JLabel lblBy = new JLabel("Inputted By:");
        lblBy.setForeground(new Color(255, 255, 255));
        lblBy.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblBy.setBounds(10, 11, 99, 24);
        topPanel.add(lblBy);
        
        JLabel lblDate = new JLabel("Date Inputted:");
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDate.setBounds(218, 11, 99, 24);
        topPanel.add(lblDate);
        
        lblInputted = new JLabel("Inputted By:");
        lblInputted.setForeground(Color.WHITE);
        lblInputted.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblInputted.setBounds(10, 39, 99, 31);
        topPanel.add(lblInputted);
        
        lblDateInputted = new JLabel("Inputted By:");
        lblDateInputted.setForeground(Color.WHITE);
        lblDateInputted.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDateInputted.setBounds(218, 39, 99, 31);
        topPanel.add(lblDateInputted);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 103, 619, 563);
        container.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        tableSetup();
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text

	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Product Name", "Variant", "Quantity"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
