package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class OrderListPanel extends JPanel {
	
	// Class Import
	public OrderListPanelData opd;
	
	private JTextField txtSearch;
	
	public OrderListPanel() {
		setBounds(0, 0, 320, 677);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 320, 595);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(scrollPane);
		
		opd = new OrderListPanelData();
		scrollPane.setViewportView(opd);
		
		JLabel lblNewLabel = new JLabel("Order List");
		lblNewLabel.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/Order.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 119, 40);
		add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search by Order Number");
		txtSearch.setBounds(139, 15, 171, 30);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New Order 1 Minute ago");
		lblNewLabel_1.setBounds(10, 52, 300, 19);
		add(lblNewLabel_1);
	}
}
