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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
	private int prodCount = 0; // product count
	private int catListCount = 0; // Category Button Count
	
	private int prodIndexClicked = 0; // prod index
	private int orderListClickCount = 0; //
	
	private int cartRemoveIndex = 0;
	
	private static final long UPDATE_INTERVAL_MS = 1000;
	
	private ArrayList<Integer> arr;
	
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
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		arr = new ArrayList<>();
		
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
		this.startAutoUpdate();
		//Listener
		mouseList();
		actionList();

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
		lower.btnPay.addActionListener(this);
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
	
    private void startAutoUpdate() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable updateTask = this::setDateNow;

        // Schedule the task to run at a fixed interval
        executor.scheduleAtFixedRate(updateTask, 0, UPDATE_INTERVAL_MS, TimeUnit.MILLISECONDS);
    }
	
	private void setDateNow() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy, HH:mm");
		String formattedDate = now.format(formatter);
		menu.lblDate.setText(formattedDate);
		 
	}
	
	private void initialize() {
		
		panelMenuList = new JPanel();
		panelMenuList.setBackground(Color.WHITE);
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
		panelPrice.setBackground(Color.WHITE);
		panelPrice.setBounds(861, 11, 393, 699);
		contentPane.add(panelPrice);
		panelPrice.setLayout(null);
		
		panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
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

	private void setValueOrderList() {
		int finalTotal = 0;
		for(int i = 0; i < orderListClickCount; i++) {
			int price = Integer.parseInt(prodList.prodPrice[Integer.parseInt(arr.get(i).toString())]);
			int quantity = Integer.parseInt(pOrderList.lblQuantity[i].getText());
			int total = quantity * price;
			pOrderList.lblProdName[i].setText(prodList.lblProdName[Integer.parseInt(arr.get(i).toString())].getText());
			pOrderList.lblPrice[i].setText(price + "");
			pOrderList.lblQuantity[i].setText(quantity + "");
			pOrderList.lblTotal[i].setText(total + "");
			pOrderList.prodVolume[i] = prodList.prodVolume[arr.get(i)] + "";
			finalTotal += total;
		}
		setTotal(finalTotal);
		finalTotal = 0;
	}
	
	private void setTotal(int total) {
		int subT = total;
		int discount = Integer.parseInt(lower.lblDiscount.getText());
		double finalTotal = total;
		lower.lblSubTotal.setText("₱" + subT);
		lower.lblTotal.setText("₱" + finalTotal);
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

//		Component clickedComponent1 = e.getComponent();
		for(int i = 0; i < arr.size(); i++) {
			if(clickedComponent == pOrderList.lblAdd[i]) {
//				System.out.println("add " + i);
				int Quantity = Integer.parseInt(pOrderList.lblQuantity[i].getText());
				Quantity++;
				pOrderList.lblQuantity[i].setText(Quantity + "");
				setValueOrderList();
				break;
			}
			
			if(clickedComponent == pOrderList.lblMinus[i]) {
//				System.out.println("minus " + i);
				int Quantity = Integer.parseInt(pOrderList.lblQuantity[i].getText());
				if(Quantity > 1) {
					Quantity--;
					pOrderList.lblQuantity[i].setText(Quantity + "");
					setValueOrderList();
				}
				break;
			}
			
			if(clickedComponent == pOrderList.lblDelete[i]) {

				cartRemoveIndex = i;
				pOrderList = new orderListPanel();
				orderListClickCount--;
				pOrderList.settingUpCount(orderListClickCount);
				arr.remove(cartRemoveIndex);
				setValueOrderList();

				panelOrderList.setViewportView(pOrderList);
				
				for(int ii = 0; ii < arr.size(); ii++) {
					pOrderList.lblAdd[ii].addMouseListener(this);
					pOrderList.lblMinus[ii].addMouseListener(this);
					pOrderList.lblDelete[ii].addMouseListener(this);
				}

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(e.getSource() == cartButton.btnaddToCart) {
				if(!arr.contains(prodIndexClicked)) {
					pOrderList = new orderListPanel();
					orderListClickCount++;
					pOrderList.settingUpCount(orderListClickCount);
					arr.add(prodIndexClicked);
					setValueOrderList();

				}
//				System.out.println("Debug: " + arr.toString());

				panelOrderList.setViewportView(pOrderList);
				prodList.panel[prodIndexClicked].remove(cartButton);
				prodList.lblIcon[prodIndexClicked].setVisible(true);
				prodList.lblProdName[prodIndexClicked].setVisible(true);
				
				for(int i = 0; i < arr.size(); i++) {
					pOrderList.lblAdd[i].addMouseListener(this);
					pOrderList.lblMinus[i].addMouseListener(this);
					pOrderList.lblDelete[i].addMouseListener(this);
				}

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
		if(e.getSource() == lower.btnPay) {
			try {
				//Genarating RefNumber
				String ref = "";
				String sqlRefGen = "SELECT COUNT(OrderRefNumber) FROM tblordercheckout";
				st.execute(sqlRefGen);
				rs = st.getResultSet();
				if(rs.next())
					ref = "ref" + (rs.getInt(1) + 1);
				
				int rowCount = 0;
				int rowCount1 = 0;
				int rowCount2 = 0;
				int rowCount3 = 0;
				
				for(int i = 0; i < arr.size(); i++) {
					// Inserting products on tblordercheckoutdata,
					String prodName = pOrderList.lblProdName[i].getText();
					String prodVolume = pOrderList.prodVolume[i];
					String prodQuantity = pOrderList.lblQuantity[i].getText();
//					String prodPrice = pOrderList.lblPrice[i].getText();
					
		            String sqlKBN = "INSERT INTO tblordercheckoutdata(OrderRefNumber,ProductName, volume, Quantity, Price) " +
	                        "SELECT '" + ref + "', prodName, prodVolume, " + prodQuantity + ", prodPrice " +
	                        "FROM tblproducts " +
	                        "WHERE prodName = '" + prodName + "' AND prodVolume = '" + prodVolume + "'";
		            System.out.println(sqlKBN);
		            rowCount = st.executeUpdate(sqlKBN);
		            
		            // setting up product stock on tblProducts
		            String sqlUpdate = "UPDATE tblProducts "
		            		+ "SET Quantity = Quantity - " + prodQuantity + ", "
		            		+ "Sold = Sold + " + prodQuantity + " "
		            		+ "WHERE prodName = '" + prodName + "' AND prodVolume = '" + prodVolume + "'";
		            System.out.println(sqlUpdate);
		            
		            rowCount1 = st.executeUpdate(sqlUpdate);
		            
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(new Date());
//				System.out.println(date);
				
				String sql2 = "INSERT INTO tblordercheckout(OrderRefNumber, OrderDate, UserID, address, contact, email) VALUES ('" + ref + "','" + date + "','Cashier Walk-In','Walk-IN','00000000000','Walk-IN@gmail.com')";
				rowCount2 = st.executeUpdate(sql2);
				String sqlFinal = "INSERT INTO tblorderstatus VALUES('" + ref + "','Completed')";
				rowCount3 = st.executeUpdate(sqlFinal);
				
				if(rowCount != 0 && rowCount1 !=0 && rowCount2 !=0 && rowCount3 !=0) {
					JOptionPane.showMessageDialog(null, "Order Completed");
					pOrderList = new orderListPanel();
					panelOrderList.setViewportView(pOrderList);
					arr.clear();
					orderListClickCount = 0;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "btnPayERROR: " + e2.getMessage());
			}
		}	
	}
}
