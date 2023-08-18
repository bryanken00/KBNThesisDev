package KBNCashier.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;
import KBNCashier.panels.category.panelCategoryDefault;
import KBNCashier.panels.category.panelCategoryList;
import KBNCashier.panels.low.lowerTotal;
import KBNCashier.panels.menuBar.menuBarPanel;
import KBNCashier.panels.orderList.orderListPanel;
import KBNCashier.panels.orderList.prodDetails;
import KBNCashier.panels.productList.ProductList;
import KBNCashier.panels.productList.addCart;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Cashier extends JFrame implements ActionListener, MouseListener{

	// Class
	private DbConnection dbCon;
	
	
	//Class Panel
		// Category
	private panelCategoryDefault panelCat;
	private panelCategoryList panelCatList;
	private JScrollBar horizontalScrollBar;
	
	
	private ProductList prodList;
	private addCart cartButton;
	private lowerTotal lower;
	private menuBarPanel menu;
	
	//orderList
	private orderListPanel pOrderList;
	private prodDetails prodD;
	
	//
	private int prodCount = 0;
	private int catListCount = 0;
	private int prodIndexClicked = 0;
	private int orderListClickCount = 0;
	
	private Statement st;
	private ResultSet rs;
	
	private JPanel contentPane;
	private JPanel panelMenuList;
	private JPanel panelPrice;
	private JPanel panelMenuListTop;
	private JPanel panelTop;
	private JScrollPane panelOrderList;
	private JPanel panelLow;
	private JScrollPane panelCategory;
	private JScrollPane panelProductList;
	private JTextField txtCustomerName;
	
	public Cashier() {
		setResizable(false);
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
		prodD = new prodDetails();
		lower = new lowerTotal();
		menu = new menuBarPanel();
		panelCatList = new panelCategoryList();
		cartButton = new addCart();
		
		try {
			st = dbCon.getConnection().createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL Connection");
		}

		
		initialize();
		defaultPanel();
		prodCounter();
		catListCounter();
		setDateNow();
		//Listener
		mouseList();

	}
	
	private void defaultPanel() {
		panelCategory.setViewportView(panelCat);
		panelProductList.setViewportView(prodList);
		panelOrderList.setViewportView(pOrderList);
		panelLow.add(lower);
		panelMenuListTop.add(menu);
	}
	
	private void mouseList() {
		horizontalScrollBar.addMouseListener(this);
		panelCat.addMouseListener(this);
		panelCatList.addMouseListener(this);
		
		for(int i = 0; i < catListCount; i++) {
			panelCatList.btnCategory[i].addMouseListener(this);
		}
		
		for (int i = 0; i < prodCount; i++) {
			prodList.panel[i].addMouseListener(this);
		}
		
		//addToCart
		cartButton.btnaddToCart.addMouseListener(this);
	}
	
	private void actionList() {
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
	
	private void catListCounter() {
		try {
			String sql = "SELECT COUNT(CategoryName) from tblproductcategories";
			st.execute(sql);
			rs = st.getResultSet();
			if(rs.next())
				catListCount = rs.getInt(1) + 1;
		}catch(Exception e) {
			
		}
		panelCatList.settingUpCount(catListCount);
		catListDetails();
	}
	
	private void catListDetails() {
		try {
			String sql = "SELECT CategoryName from tblproductcategories";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 1;
			panelCatList.btnCategory[0].setText("All");
			while(rs.next()) {
				panelCatList.btnCategory[i].setText(rs.getString(1));
				i++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "catListDetailsERROR: " + e.getMessage());
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
		
		panelCategory = new JScrollPane();
		panelCategory.setBounds(10, 62, 821, 56);
		panelMenuList.add(panelCategory);
		
		panelProductList = new JScrollPane();
		panelProductList.setBounds(10, 124, 821, 564);
		panelMenuList.add(panelProductList);
		
		// Scroll Speed
		int horizontalScrollUnitIncrement = 10;
		horizontalScrollBar = panelCategory.getHorizontalScrollBar();
		horizontalScrollBar.setUnitIncrement(horizontalScrollUnitIncrement);
		
		int veticalScrollUnitIncrement = 10;
		JScrollBar verticalScrollBar = panelProductList.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(veticalScrollUnitIncrement);
		
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
		
		panelOrderList = new JScrollPane();
		panelOrderList.setBounds(10, 62, 373, 437);
		panelPrice.add(panelOrderList);
		
		panelLow = new JPanel();
		panelLow.setBounds(10, 510, 373, 178);
		panelPrice.add(panelLow);
		panelLow.setLayout(null);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Component clickedComponent = e.getComponent();
		for (int i = 0; i < prodCount; i++) {
			if (clickedComponent == prodList.panel[i]) {
				prodIndexClicked = i;
				
				//panel addCart
				prodList.panel[i].add(cartButton);
				prodList.lblIcon[i].setVisible(false);
				prodList.lblProdName[i].setVisible(false);
				
				//details panel
				panelOrderList.setViewportView(prodD);
				prodD.lblIcon.setText(prodList.lblIcon[i].getText());
				prodD.lblProdName.setText("Product: " + prodList.lblProdName[i].getText());
				prodD.lblPrice.setText("Price: " + prodList.prodPrice[i]);
				prodD.lblVariant.setText("Variant: " + prodList.prodVolume[i]);
				prodD.lblStock.setText("Stock: " + prodList.prodQuantity[i]);
				break;
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(e.getSource() == cartButton.btnaddToCart) {
				orderListClickCount++;
				pOrderList.settingUpCount(orderListClickCount);
				
				panelOrderList.setViewportView(pOrderList);
				prodList.panel[prodIndexClicked].remove(cartButton);
				prodList.lblIcon[prodIndexClicked].setVisible(true);
				prodList.lblProdName[prodIndexClicked].setVisible(true);

				panelOrderList.repaint();
				pOrderList.repaint();
				pOrderList.orderListView.repaint();
			}
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {	
		
		if(e.getSource() == panelCat) {
			panelCategory.setViewportView(panelCatList);
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
		for(int i = 0; i < catListCount; i++) {
			if(e.getSource() == panelCatList.btnCategory) {
				panelCategory.setViewportView(panelCatList);
			} 
		}
		if(e.getSource() == panelCatList || e.getSource() == horizontalScrollBar) {
			panelCategory.setViewportView(panelCat);
		}
		
		// add Cart
		if(e.getSource() == cartButton.btnaddToCart) {
			panelOrderList.setViewportView(pOrderList);
			prodList.panel[prodIndexClicked].remove(cartButton);
			prodList.lblIcon[prodIndexClicked].setVisible(true);
			prodList.lblProdName[prodIndexClicked].setVisible(true);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
