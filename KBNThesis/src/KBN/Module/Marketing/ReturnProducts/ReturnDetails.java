package KBN.Module.Marketing.ReturnProducts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReturnDetails extends JDialog {
	public JTable table;
	public JLabel lblReason;
	public JLabel lblReturnStatus;
	public DefaultTableModel main;
	
	public ReturnDetails() {
		setBounds(100, 100, 649, 608);
		getContentPane().setLayout(null);
		setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(null);
		middlePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setBounds(10, 11, 613, 104);
		getContentPane().add(middlePanel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 35, 593, 8);
		middlePanel.add(separator_1);
		
		JLabel lblReturnReason = new JLabel("Reason:");
		lblReturnReason.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReturnReason.setBounds(10, 11, 136, 20);
		middlePanel.add(lblReturnReason);
		
		lblReason = new JLabel("New label");
		lblReason.setBounds(10, 47, 593, 46);
		middlePanel.add(lblReason);
		
		JLabel lblStatus = new JLabel("Reason:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(380, 11, 77, 20);
		middlePanel.add(lblStatus);
		
		lblReturnStatus = new JLabel("Reason:");
		lblReturnStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReturnStatus.setBounds(467, 11, 136, 20);
		middlePanel.add(lblReturnStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 613, 432);
		getContentPane().add(scrollPane);
		
		table = new JTable();
        main = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane.setViewportView(table);
        tableSetup();
	}
	
	private void tableSetup() {
		String[] columnDefaultData = {"Product Name", "Variant", "Quantity"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		table.setRowHeight(50);
	}
}
