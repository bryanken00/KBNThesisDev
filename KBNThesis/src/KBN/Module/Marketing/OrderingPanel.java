package KBN.Module.Marketing;

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
import javax.swing.JScrollPane;

public class OrderingPanel extends JPanel {
	
	public OrderListPanel orderLPanel;
	
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	
	public JPanel PanelOrderList;
	public JPanel panel_1;
	public JLabel lblRefNum;
	public JPanel topPanel;
	public JLabel lblCustomer;
	public JLabel lblOrderDate;
	public JLabel lblAddress;
	public JLabel lblNewLabel_1;
	public JLabel lblClient;
	public JLabel lblCustName;
	public JLabel lblOrderD;
	public JLabel lblAdd;
	public JPanel middlePanel;
	public JSeparator separator_1;
	public JLabel lblOrderStatus;
	public JButton btnProcessComplete;
	public JButton btnDelivery;
	public JButton btnProductionComplete;
	public JButton btnInvoice;
	public JButton btnDeliveryComplete;
	public JPanel tablePanel;
	public JLabel lblItemCount;
	public JLabel lblQuantityCount;
	public JLabel lblDiscount;
	public JLabel lblTotalAmount;
	public JButton btnApproved;

    public OrderingPanel() {
        setBounds(0, 0, 989, 699);
        setLayout(null);
        
        PanelOrderList = new JPanel();
        PanelOrderList.setBounds(10, 11, 320, 677);
        PanelOrderList.setLayout(null);
        add(PanelOrderList);
        
        panel_1 = new JPanel();
        panel_1.setBounds(346, 11, 633, 677);
        add(panel_1);
        panel_1.setLayout(null);
        
        topPanel = new JPanel();
        topPanel.setBounds(10, 10, 613, 105);
        panel_1.add(topPanel);
        topPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Order Summary");
        lblNewLabel.setBounds(10, 11, 136, 20);
        topPanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        lblRefNum = new JLabel("");
        lblRefNum.setBounds(156, 14, 199, 14);
        topPanel.add(lblRefNum);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 35, 593, 8);
        topPanel.add(separator);
        
        lblNewLabel_1 = new JLabel("Client");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(13, 42, 136, 20);
        topPanel.add(lblNewLabel_1);
        
        lblCustomer = new JLabel("Customer");
        lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCustomer.setBounds(162, 42, 136, 20);
        topPanel.add(lblCustomer);
        
        lblOrderDate = new JLabel("Order Date");
        lblOrderDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOrderDate.setBounds(311, 42, 136, 20);
        topPanel.add(lblOrderDate);
        
        lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAddress.setBounds(460, 42, 136, 20);
        topPanel.add(lblAddress);
        
        lblClient = new JLabel("RoseMarioSkin");
        lblClient.setBounds(10, 73, 136, 14);
        topPanel.add(lblClient);
        
        lblCustName = new JLabel("");
        lblCustName.setBounds(156, 73, 136, 14);
        topPanel.add(lblCustName);
        
        lblOrderD = new JLabel("");
        lblOrderD.setBounds(311, 73, 136, 14);
        topPanel.add(lblOrderD);
        
        lblAdd = new JLabel("");
        lblAdd.setBounds(460, 73, 136, 14);
        topPanel.add(lblAdd);
        
        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        middlePanel.setBounds(10, 126, 613, 87);
        panel_1.add(middlePanel);
        
        separator_1 = new JSeparator();
        separator_1.setBounds(10, 35, 593, 8);
        middlePanel.add(separator_1);
        
        lblOrderStatus = new JLabel("Order Status");
        lblOrderStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblOrderStatus.setBounds(10, 11, 136, 20);
        middlePanel.add(lblOrderStatus);
        
        btnApproved = new JButton("<html>Order<br>Approved</html>");
        btnApproved.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnApproved.setFocusable(false);
        btnApproved.setBorderPainted(false);
        btnApproved.setBackground(Color.WHITE);
        btnApproved.setBounds(13, 46, 86, 29);
        middlePanel.add(btnApproved);
        
        btnProcessComplete = new JButton("<html>Processing<br>complete</html>");
        btnProcessComplete.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnProcessComplete.setFocusable(false);
        btnProcessComplete.setBorderPainted(false);
        btnProcessComplete.setBackground(Color.WHITE);
        btnProcessComplete.setBounds(112, 46, 86, 29);
        middlePanel.add(btnProcessComplete);
        
        btnDelivery = new JButton("<html>On<br>Delivery</html>");
        btnDelivery.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnDelivery.setFocusable(false);
        btnDelivery.setBorderPainted(false);
        btnDelivery.setBackground(Color.WHITE);
        btnDelivery.setBounds(310, 46, 86, 29);
        middlePanel.add(btnDelivery);
        
        btnProductionComplete = new JButton("<html>Production<br>complete</html>");
        btnProductionComplete.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnProductionComplete.setFocusable(false);
        btnProductionComplete.setBorderPainted(false);
        btnProductionComplete.setBackground(Color.WHITE);
        btnProductionComplete.setBounds(211, 46, 86, 29);
        middlePanel.add(btnProductionComplete);
        
        btnInvoice = new JButton("Invoice");
        btnInvoice.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnInvoice.setFocusable(false);
        btnInvoice.setBorderPainted(false);
        btnInvoice.setBackground(Color.WHITE);
        btnInvoice.setBounds(508, 46, 86, 29);
        middlePanel.add(btnInvoice);
        
        btnDeliveryComplete = new JButton("<html>Deliver<br>Complete</html>");
        btnDeliveryComplete.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
        btnDeliveryComplete.setFocusable(false);
        btnDeliveryComplete.setBorderPainted(false);
        btnDeliveryComplete.setBackground(Color.WHITE);
        btnDeliveryComplete.setBounds(409, 46, 86, 29);
        middlePanel.add(btnDeliveryComplete);
        
        tablePanel = new JPanel();
        tablePanel.setBounds(10, 224, 613, 442);
        panel_1.add(tablePanel);
        tablePanel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 613, 400);
        tablePanel.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        lblItemCount = new JLabel("Items: ");
        lblItemCount.setBounds(10, 411, 136, 14);
        tablePanel.add(lblItemCount);
        
        lblQuantityCount = new JLabel("Total Quantity: ");
        lblQuantityCount.setBounds(156, 411, 136, 14);
        tablePanel.add(lblQuantityCount);
        
        lblDiscount = new JLabel("Total Discount: ");
        lblDiscount.setBounds(311, 411, 136, 14);
        tablePanel.add(lblDiscount);
        
        lblTotalAmount = new JLabel("Total Amount: ");
        lblTotalAmount.setBounds(460, 411, 136, 14);
        tablePanel.add(lblTotalAmount);
        
        
        // Setter
        orderLPanel = new OrderListPanel();
        PanelOrderList.add(orderLPanel);

        orderLPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Set border here
        
        tableSetup();
    }
    
    
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Product Name", "Quantity", "Price", "Discount", "Total Price"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}