package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class AuditTrail extends JPanel {
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	
	private JTextField textField;
	private JTable table;
	private JButton btnMarketing;
	private JButton btnSales;
	private JButton btnWarehouse;
	private JButton btnProduction;
	private JButton btnToday;
	private JButton btnYesterday;
	private JButton btnLast7;
	private JButton btnLast15;
	
	public AuditTrail() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(31, 107, 225, 568);
        add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Department");
        lblNewLabel.setBounds(10, 32, 205, 35);
        panel.add(lblNewLabel);
        
        btnMarketing = new JButton("Marketing");
        btnMarketing.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnMarketing.setFocusable(false);
        btnMarketing.setBorderPainted(false);
        btnMarketing.setBackground(Color.WHITE);
        btnMarketing.setBounds(15, 78, 195, 41);
        panel.add(btnMarketing);
        
        btnSales = new JButton("Sales");
        btnSales.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSales.setFocusable(false);
        btnSales.setBorderPainted(false);
        btnSales.setBackground(Color.WHITE);
        btnSales.setBounds(15, 133, 195, 41);
        panel.add(btnSales);
        
        btnWarehouse = new JButton("Warehouse");
        btnWarehouse.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnWarehouse.setFocusable(false);
        btnWarehouse.setBorderPainted(false);
        btnWarehouse.setBackground(Color.WHITE);
        btnWarehouse.setBounds(15, 185, 195, 41);
        panel.add(btnWarehouse);
        
        btnProduction = new JButton("Production");
        btnProduction.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnProduction.setFocusable(false);
        btnProduction.setBorderPainted(false);
        btnProduction.setBackground(Color.WHITE);
        btnProduction.setBounds(15, 237, 195, 41);
        panel.add(btnProduction);
        
        btnToday = new JButton("Today");
        btnToday.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnToday.setFocusable(false);
        btnToday.setBorderPainted(false);
        btnToday.setBackground(Color.WHITE);
        btnToday.setBounds(15, 335, 195, 41);
        panel.add(btnToday);
        
        btnYesterday = new JButton("Yesterday");
        btnYesterday.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnYesterday.setFocusable(false);
        btnYesterday.setBorderPainted(false);
        btnYesterday.setBackground(Color.WHITE);
        btnYesterday.setBounds(15, 390, 195, 41);
        panel.add(btnYesterday);
        
        btnLast7 = new JButton("Last 7 days");
        btnLast7.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnLast7.setFocusable(false);
        btnLast7.setBorderPainted(false);
        btnLast7.setBackground(Color.WHITE);
        btnLast7.setBounds(15, 442, 195, 41);
        panel.add(btnLast7);
        
        btnLast15 = new JButton("Lat 15 days");
        btnLast15.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnLast15.setFocusable(false);
        btnLast15.setBorderPainted(false);
        btnLast15.setBackground(Color.WHITE);
        btnLast15.setBounds(15, 494, 195, 41);
        panel.add(btnLast15);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(10, 289, 205, 35);
        panel.add(lblDate);
        
        textField = new JTextField();
        textField.setText("search bar");
        textField.setColumns(10);
        textField.setBounds(644, 28, 319, 28);
        add(textField);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(266, 67, 697, 608);
        add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        tableSetup();
        
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Time & Date", "User", "Action"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
