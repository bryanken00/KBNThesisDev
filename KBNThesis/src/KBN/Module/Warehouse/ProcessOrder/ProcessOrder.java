package KBN.Module.Warehouse.ProcessOrder;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ProcessOrder extends JPanel {
	
	public DefaultTableModel main;
	public JLabel lblTotalAmount;
	public JLabel lblDiscount;
	public JLabel lblQuantityCount;
	public JLabel lblItemCount;
	public JLabel lblPONumber;
	public JLabel lblMarketingName;
	public JLabel lblCustomerName;
	public JLabel lblOrderDate;
	public JLabel lblAddres;
	public JTable table;
	public JTextField txtSearchBar;
	public JScrollPane orderListScrollPane;

	public ProcessOrder() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panelOrderList = new JPanel();
		panelOrderList.setBackground(new Color(255, 255, 255));
		panelOrderList.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrderList.setBounds(10, 11, 295, 677);
		add(panelOrderList);
		panelOrderList.setLayout(null);
		
		JPanel panelTopNavOrderList = new JPanel();
		panelTopNavOrderList.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTopNavOrderList.setBounds(10, 11, 275, 88);
		panelTopNavOrderList.setBackground(new Color(75, 119, 71));
		panelOrderList.add(panelTopNavOrderList);
		panelTopNavOrderList.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 52, 223, 30);
		panelTopNavOrderList.add(comboBox);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(ProcessOrder.class.getResource("/KBN/resources/SearchBarUniversal.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(233, 11, 32, 30);
		panelTopNavOrderList.add(btnSearch);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("Search OrderNumber");
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.setColumns(10);
		txtSearchBar.setBounds(10, 11, 223, 30);
		panelTopNavOrderList.add(txtSearchBar);
		
		orderListScrollPane = new JScrollPane();
		orderListScrollPane.setBounds(10, 112, 275, 554);
		orderListScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelOrderList.add(orderListScrollPane);
		
		JPanel Container = new JPanel();
		Container.setBackground(new Color(255, 255, 255));
		Container.setBorder(new LineBorder(new Color(0, 0, 0)));
		Container.setBounds(315, 11, 664, 677);
		add(Container);
		Container.setLayout(null);
		
		JPanel panelTopNav = new JPanel();
		panelTopNav.setBounds(10, 11, 644, 88);
		panelTopNav.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTopNav.setBackground(new Color(75, 119, 71));
		Container.add(panelTopNav);
		panelTopNav.setLayout(null);
		
		JLabel lblPO = new JLabel("PO Number");
		lblPO.setForeground(new Color(255, 255, 255));
		lblPO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPO.setBounds(28, 11, 95, 23);
		panelTopNav.add(lblPO);
		
		JLabel lblApproveBy = new JLabel("Approved By");
		lblApproveBy.setForeground(new Color(255, 255, 255));
		lblApproveBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApproveBy.setBounds(151, 11, 95, 23);
		panelTopNav.add(lblApproveBy);
		
		JLabel lblCustName = new JLabel("Customer");
		lblCustName.setForeground(new Color(255, 255, 255));
		lblCustName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustName.setBounds(274, 11, 95, 23);
		panelTopNav.add(lblCustName);
		
		JLabel lblOrderD = new JLabel("Order Date");
		lblOrderD.setForeground(new Color(255, 255, 255));
		lblOrderD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrderD.setBounds(397, 11, 95, 23);
		panelTopNav.add(lblOrderD);
		
		JLabel lblShipAddress = new JLabel("Address");
		lblShipAddress.setForeground(new Color(255, 255, 255));
		lblShipAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShipAddress.setBounds(520, 11, 95, 23);
		panelTopNav.add(lblShipAddress);
		
		lblPONumber = new JLabel("ref1");
		lblPONumber.setForeground(Color.WHITE);
		lblPONumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPONumber.setBounds(10, 54, 116, 23);
		panelTopNav.add(lblPONumber);
		
		lblMarketingName = new JLabel("MarketingName");
		lblMarketingName.setForeground(Color.WHITE);
		lblMarketingName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarketingName.setBounds(136, 54, 116, 23);
		panelTopNav.add(lblMarketingName);
		
		lblCustomerName = new JLabel("CustName");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomerName.setBounds(262, 54, 116, 23);
		panelTopNav.add(lblCustomerName);
		
		lblOrderDate = new JLabel("Date");
		lblOrderDate.setForeground(Color.WHITE);
		lblOrderDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOrderDate.setBounds(388, 54, 116, 23);
		panelTopNav.add(lblOrderDate);
		
		lblAddres = new JLabel("AngonoRizal");
		lblAddres.setForeground(Color.WHITE);
		lblAddres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAddres.setBounds(514, 54, 116, 23);
		panelTopNav.add(lblAddres);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 110, 644, 556);
		Container.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 644, 509);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblItemCount = new JLabel("Items: ");
		lblItemCount.setBounds(24, 516, 104, 29);
		panel.add(lblItemCount);
		lblItemCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblQuantityCount = new JLabel("Total Quantity: ");
		lblQuantityCount.setBounds(155, 516, 104, 29);
		panel.add(lblQuantityCount);
		lblQuantityCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblDiscount = new JLabel("Total Discount: ");
		lblDiscount.setBounds(286, 516, 104, 29);
		panel.add(lblDiscount);
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblTotalAmount = new JLabel("Total Amount: ");
		lblTotalAmount.setBounds(417, 516, 104, 29);
		panel.add(lblTotalAmount);
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnInvoice = new JButton("Process");
		btnInvoice.setBackground(new Color(75, 119, 71));
		btnInvoice.setForeground(new Color(255, 255, 255));
		btnInvoice.setBounds(548, 516, 86, 29);
		btnInvoice.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		btnInvoice.setFocusable(false);
		btnInvoice.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.add(btnInvoice);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		String[] columnDefaultData = new String[] {"Product Name", "Quantity", "Price", "Discount", "Total Price"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
