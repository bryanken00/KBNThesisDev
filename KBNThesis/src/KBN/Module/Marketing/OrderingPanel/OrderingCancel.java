package KBN.Module.Marketing.OrderingPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class OrderingCancel extends JPanel {
	
	public OrderListPanel orderLPanel;
	
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	
	public JPanel PanelOrderList;
	public JPanel panel_1;
	public JPanel topPanel;
	public JLabel lblCustomer;
	public JLabel lblOrderDate;
	public JLabel lblAddress;
	public JLabel lblNewLabel_1;
	public JPanel tablePanel;
	public JLabel lblItemCount;
	public JLabel lblQuantityCount;
	public JLabel lblDiscount;
	public JLabel lblTotalAmount;
	public JLabel lblRef;
	public JLabel lblCustName;
	public JLabel lblOrderD;
	public JLabel lblCancelledDate;
	public JLabel lblAdd;
	public JEditorPane cancelReason;
	public JComboBox cbCategory;

    public OrderingCancel() {
		setBackground(new Color(255, 255, 255));
        setBounds(0, 0, 989, 699);
        setLayout(null);
        
        PanelOrderList = new JPanel();
        PanelOrderList.setBounds(10, 11, 320, 677);
        PanelOrderList.setLayout(null);
        add(PanelOrderList);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(346, 11, 633, 677);
        add(panel_1);
        panel_1.setLayout(null);
        
        topPanel = new JPanel();
        topPanel.setBackground(new Color(255, 255, 255));
        topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        topPanel.setBounds(10, 10, 613, 105);
        panel_1.add(topPanel);
        topPanel.setLayout(null);
        
        lblNewLabel_1 = new JLabel("PO Number");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(21, 11, 97, 37);
        topPanel.add(lblNewLabel_1);
        
        lblCustomer = new JLabel("Customer");
        lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCustomer.setBounds(139, 11, 97, 37);
        topPanel.add(lblCustomer);
        
        lblOrderDate = new JLabel("Order Date");
        lblOrderDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOrderDate.setBounds(257, 11, 97, 37);
        topPanel.add(lblOrderDate);
        
        lblAddress = new JLabel("<html><center>Cancelled /<br>Expired Date</center><html>");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAddress.setBounds(375, 11, 97, 37);
        topPanel.add(lblAddress);
        
        JLabel lblAddress_1 = new JLabel("Address");
        lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAddress_1.setBounds(493, 11, 97, 37);
        topPanel.add(lblAddress_1);
        
        lblRef = new JLabel("RoseMarioSkin");
        lblRef.setBounds(21, 59, 97, 14);
        topPanel.add(lblRef);
        
        lblCustName = new JLabel("");
        lblCustName.setBounds(139, 59, 97, 14);
        topPanel.add(lblCustName);
        
        lblOrderD = new JLabel("");
        lblOrderD.setBounds(257, 59, 97, 14);
        topPanel.add(lblOrderD);
        
        lblCancelledDate = new JLabel("");
        lblCancelledDate.setBounds(375, 59, 97, 14);
        topPanel.add(lblCancelledDate);
        
        lblAdd = new JLabel("");
        lblAdd.setBounds(493, 59, 97, 14);
        topPanel.add(lblAdd);
        
        tablePanel = new JPanel();
        tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        tablePanel.setBackground(new Color(255, 255, 255));
        tablePanel.setBounds(10, 126, 613, 395);
        panel_1.add(tablePanel);
        tablePanel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 613, 359);
        tablePanel.add(scrollPane);
        
        table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);
        
        lblItemCount = new JLabel("Items: ");
        lblItemCount.setBounds(13, 370, 136, 14);
        tablePanel.add(lblItemCount);
        
        lblQuantityCount = new JLabel("Total Quantity: ");
        lblQuantityCount.setBounds(162, 370, 136, 14);
        tablePanel.add(lblQuantityCount);
        
        lblDiscount = new JLabel("Total Discount: ");
        lblDiscount.setBounds(311, 370, 136, 14);
        tablePanel.add(lblDiscount);
        
        lblTotalAmount = new JLabel("Total Amount: ");
        lblTotalAmount.setBounds(460, 370, 136, 14);
        tablePanel.add(lblTotalAmount);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 532, 613, 134);
        scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.add(scrollPane_1);
        
        cancelReason = new JEditorPane();
        cancelReason.setText("Cancellation Reason: ");
        cancelReason.setEditable(false);
        scrollPane_1.setViewportView(cancelReason);
        
        
        // Setter
        orderLPanel = new OrderListPanel();
        PanelOrderList.add(orderLPanel);

        orderLPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Set border here
        
        tableSetup();
        
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
        orderLPanel.lblTimeDiff.setVisible(false);
        
        String[] cat = {"All", "Expired", "Cancelled"};
        
        cbCategory = new JComboBox(cat);
        cbCategory.setBounds(10, 49, 260, 28);
        orderLPanel.add(cbCategory);
    }
    
    
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Product Name", "Quantity", "Price", "Discount", "Total Price"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}