package KBNCashier.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;
import KBNCashier.panels.category.panelCategoryDefault;
import KBNCashier.panels.low.lowerTotal;
import KBNCashier.panels.menuBar.menuBarPanel;
import KBNCashier.panels.orderList.orderListPanel;
import KBNCashier.panels.productList.ProductList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Cashier extends JFrame {

	// Class
	private DbConnection dbCon;
	//Class Panel
	private panelCategoryDefault panelCat;
	private ProductList prodList;
	private orderListPanel pOrderList;
	private lowerTotal lower;
	private menuBarPanel menu;
	
	//
	private int prodCount = 0;
	
	private Statement st;
	private ResultSet rs;
	
	private JPanel contentPane;
	private JPanel panelMenuList;
	private JPanel panelPrice;
	private JPanel panelMenuListTop;
	private JPanel panelTop;
	private JPanel panelOrderList;
	private JPanel panelLow;
	private JPanel panelCategory;
	private JScrollPane panelProductList;
	private JTextField txtCustomerName;
	
	public Cashier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Class
		dbCon = new DbConnection();
		panelCat = new panelCategoryDefault();
		prodList = new ProductList();
		pOrderList = new orderListPanel();
		lower = new lowerTotal();
		menu = new menuBarPanel();
		
		try {
			st = dbCon.getConnection().createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL Connection");
		}

		
		initialize();
		defaultPanel();
		prodCounter();
		setDateNow();
	}
	
	
	private void defaultPanel() {
		panelCategory.add(panelCat);
		panelProductList.setViewportView(prodList);
		panelOrderList.add(pOrderList);
		panelLow.add(lower);
		panelMenuListTop.add(menu);
	}
	
	private void prodCounter() {
		try {
			String sql = "SELECT COUNT(prodName) from tblproducts";
			st.execute(sql);
			rs = st.getResultSet();
			if(rs.next())
				prodCount = rs.getInt(1);
		}catch(Exception e) {
			
		}
		
		
		//KBN prodCount
		prodList.setupProdCount(prodCount);
		productDetails();
		
	}
	
	private void productDetails() {
		try {
			String sql = "SELECT prodImg, prodName, prodPrice, prodVolume, Quantity from tblproducts";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				prodList.lblIcon[i].setText(rs.getString(1));
				prodList.lblProdName[i].setText(rs.getString(2));
				prodList.prodPrice[i] = rs.getString(3);
				prodList.prodVolume[i] = rs.getString(4);
				prodList.prodQuantity[i] = rs.getString(5);
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "productDetailsERROR: " + e.getMessage());
		}
	}
	
	private void setDateNow() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy, HH:mm");
		String formattedDate = now.format(formatter);
		menu.lblDate.setText(formattedDate);
		 
	}
	
	private void initialize() {
		
		panelMenuList = new JPanel();
		panelMenuList.setBounds(10, 11, 841, 699);
		contentPane.add(panelMenuList);
		panelMenuList.setLayout(null);
		
		panelMenuListTop = new JPanel();
		panelMenuListTop.setBackground(Color.WHITE);
		panelMenuListTop.setBounds(10, 11, 821, 40);
		panelMenuList.add(panelMenuListTop);
		panelMenuListTop.setLayout(null);
		
		panelCategory = new JPanel();
		panelCategory.setBounds(10, 62, 821, 51);
		panelMenuList.add(panelCategory);
		panelCategory.setLayout(null);
		
		panelProductList = new JScrollPane();
		panelProductList.setBounds(10, 124, 821, 564);
		panelMenuList.add(panelProductList);
		
		panelPrice = new JPanel();
		panelPrice.setBounds(861, 11, 393, 699);
		contentPane.add(panelPrice);
		panelPrice.setLayout(null);
		
		panelTop = new JPanel();
		panelTop.setBounds(10, 11, 373, 40);
		panelPrice.add(panelTop);
		panelTop.setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setText("Customer Name");
		txtCustomerName.setBounds(10, 4, 353, 32);
		panelTop.add(txtCustomerName);
		
		panelOrderList = new JPanel();
		panelOrderList.setBounds(10, 62, 373, 437);
		panelPrice.add(panelOrderList);
		panelOrderList.setLayout(null);
		
		panelLow = new JPanel();
		panelLow.setBounds(10, 510, 373, 178);
		panelPrice.add(panelLow);
		panelLow.setLayout(null);
	}
}
