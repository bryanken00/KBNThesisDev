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
import javax.swing.JButton;

public class ConfirmationPanel extends JPanel {

	public DefaultTableModel main;
	private String[] columnDefaultData;
	
	public JPanel confirmPanel;
	public JTable table;
	public JLabel lblInputted;
	public JLabel lblDateInputted;
	public JButton btnConfirm;
	public JLabel lblTrackingID;
	public JLabel lblTotalQuantity;
	public JLabel lblTotalItem;
	
	public ConfirmationPanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 989, 699);
        setLayout(null);
		
        confirmPanel = new JPanel();
        confirmPanel.setBounds(10, 11, 320, 677);
        confirmPanel.setLayout(null);
        add(confirmPanel);
        
        JPanel container = new JPanel();
        container.setBackground(new Color(255, 255, 255));
        container.setBorder(new LineBorder(new Color(0, 0, 0)));
        container.setBounds(340, 11, 639, 677);
        add(container);
        container.setLayout(null);
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(98,137,95));
        topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        topPanel.setBounds(10, 11, 619, 81);
        topPanel.setLayout(null);
        container.add(topPanel);
        
        JLabel lblBy = new JLabel("Inputted By:");
        lblBy.setForeground(new Color(255, 255, 255));
        lblBy.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblBy.setBounds(172, 11, 99, 24);
        topPanel.add(lblBy);
        
        JLabel lblDate = new JLabel("Date Inputted:");
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDate.setBounds(380, 11, 99, 24);
        topPanel.add(lblDate);
        
        lblInputted = new JLabel("Inputted By:");
        lblInputted.setForeground(Color.WHITE);
        lblInputted.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblInputted.setBounds(172, 39, 99, 31);
        topPanel.add(lblInputted);
        
        lblDateInputted = new JLabel("Inputted By:");
        lblDateInputted.setForeground(Color.WHITE);
        lblDateInputted.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDateInputted.setBounds(380, 39, 99, 31);
        topPanel.add(lblDateInputted);
        
        JLabel lblTrackingId = new JLabel("Tracking ID:");
        lblTrackingId.setForeground(Color.WHITE);
        lblTrackingId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTrackingId.setBounds(10, 11, 99, 24);
        topPanel.add(lblTrackingId);
        
        lblTrackingID = new JLabel("001");
        lblTrackingID.setForeground(Color.WHITE);
        lblTrackingID.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTrackingID.setBounds(10, 39, 99, 31);
        topPanel.add(lblTrackingID);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 103, 619, 511);
        container.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        lblTotalQuantity = new JLabel("Total Quantity:");
        lblTotalQuantity.setForeground(new Color(0, 0, 0));
        lblTotalQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTotalQuantity.setBounds(10, 637, 250, 24);
        container.add(lblTotalQuantity);
        
        btnConfirm = new JButton("Confirm");
        btnConfirm.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnConfirm.setForeground(new Color(255, 255, 255));
        btnConfirm.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnConfirm.setFocusable(false);
        btnConfirm.setBackground(new Color(75, 119, 71));
        btnConfirm.setBounds(501, 631, 128, 34);
        container.add(btnConfirm);
        
        lblTotalItem = new JLabel("Total Item: ");
        lblTotalItem.setForeground(new Color(0, 0, 0));
        lblTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTotalItem.setBounds(270, 637, 219, 24);
        container.add(lblTotalItem);
        tableSetup();
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
		

	}
	
	private void tableSetup() {
		main = new DefaultTableModel(table.getRowCount(), table.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
		columnDefaultData = new String[] {"Product Name", "Variant", "Quantity"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
