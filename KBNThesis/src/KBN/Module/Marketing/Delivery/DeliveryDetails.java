package KBN.Module.Marketing.Delivery;

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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DeliveryDetails extends JDialog {
	
	public JLabel lblItemCount;
	public JLabel lblQuantityCount;
	public JLabel lblDiscount;
	public JLabel lblTotalAmount;
	public JLabel lblRef;
	public JLabel lblCustName;
	public JLabel lblOrderD;
	public JLabel lblAdd;
	

	public JTable table;
	public DefaultTableModel main;
	
	public DeliveryDetails() {
		getContentPane().setLayout(null);
		setBounds(0, 0, 650, 716);
		setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(null);
		dataPanel.setBackground(Color.WHITE);
		dataPanel.setBounds(0, 0, 633, 677);
		getContentPane().add(dataPanel);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBackground(Color.WHITE);
		topPanel.setBounds(10, 10, 613, 105);
		dataPanel.add(topPanel);
		
		JLabel lblNewLabel_1 = new JLabel("PO Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 11, 97, 37);
		topPanel.add(lblNewLabel_1);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomer.setBounds(187, 11, 97, 37);
		topPanel.add(lblCustomer);
		
		JLabel lblOrderDate = new JLabel("Order Date");
		lblOrderDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrderDate.setBounds(329, 11, 97, 37);
		topPanel.add(lblOrderDate);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress_1.setBounds(471, 11, 97, 37);
		topPanel.add(lblAddress_1);
		
		lblRef = new JLabel("RoseMarioSkin");
		lblRef.setBounds(45, 59, 97, 14);
		topPanel.add(lblRef);
		
		lblCustName = new JLabel("");
		lblCustName.setBounds(187, 59, 114, 14);
		topPanel.add(lblCustName);
		
		lblOrderD = new JLabel("");
		lblOrderD.setBounds(329, 59, 132, 14);
		topPanel.add(lblOrderD);
		
		lblAdd = new JLabel("");
		lblAdd.setBounds(471, 59, 132, 14);
		topPanel.add(lblAdd);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setBounds(10, 126, 613, 540);
		dataPanel.add(tablePanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 613, 504);
		tablePanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblItemCount = new JLabel("Items: ");
		lblItemCount.setBounds(10, 515, 136, 14);
		tablePanel.add(lblItemCount);
		
		lblQuantityCount = new JLabel("Total Quantity: ");
		lblQuantityCount.setBounds(159, 515, 136, 14);
		tablePanel.add(lblQuantityCount);
		
		lblDiscount = new JLabel("Total Discount: ");
		lblDiscount.setBounds(308, 515, 136, 14);
		tablePanel.add(lblDiscount);
		
		lblTotalAmount = new JLabel("Total Amount: ");
		lblTotalAmount.setBounds(457, 515, 136, 14);
		tablePanel.add(lblTotalAmount);
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		String[] columnDefaultData = new String[] {"Product Name", "Quantity", "Price", "Discount", "Total Price"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}

}
