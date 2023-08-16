package KBNCashier.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;
import KBNCashier.panels.category.panelCategoryDefault;
import KBNCashier.panels.productList.ProductList;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class Cashier extends JFrame {

	// Class
	private DbConnection dbCon;
	private panelCategoryDefault panelCat;
	private ProductList prodList;
	
	private JPanel contentPane;
	private JPanel panelMenuList;
	private JPanel panelPrice;
	private JPanel panelMenuListTop;
	private JPanel panelTop;
	private JPanel panelOrderList;
	private JPanel panelLow;
	private JPanel panelCategory;
	private JScrollPane panelProductList;
	private JLabel lblMenuIcon;
	private JLabel lblNewLabel;
	private JLabel lblMenuIcon_2;
	private JLabel lblNewLabel_1;
	private JTextField txtCustomerName;
	private JPanel panelTitleBarOrderList;
	
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
		
		
		//KBN prodCount
		prodList.setupProdCount(20);
		
		initialize();
		defaultPanel();
		
	}
	
	
	private void defaultPanel() {
		panelCategory.add(panelCat);
		panelProductList.setViewportView(prodList);
		
	}
	
	private void initialize() {
		
		panelMenuList = new JPanel();
		panelMenuList.setBounds(10, 11, 841, 699);
		contentPane.add(panelMenuList);
		panelMenuList.setLayout(null);
		
		panelMenuListTop = new JPanel();
		panelMenuListTop.setBounds(10, 11, 821, 40);
		panelMenuList.add(panelMenuListTop);
		panelMenuListTop.setLayout(null);
		
		lblMenuIcon = new JLabel("");
		lblMenuIcon.setIcon(new ImageIcon(Cashier.class.getResource("/KBNCashier/resources/menu.png")));
		lblMenuIcon.setBounds(10, 4, 32, 32);
		panelMenuListTop.add(lblMenuIcon);
		
		JLabel lblMenuIcon_1 = new JLabel("");
		lblMenuIcon_1.setIcon(new ImageIcon(Cashier.class.getResource("/KBNCashier/resources/cal.png")));
		lblMenuIcon_1.setBounds(779, 4, 32, 32);
		panelMenuListTop.add(lblMenuIcon_1);
		
		lblNewLabel = new JLabel("Date Now");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(563, 4, 210, 32);
		panelMenuListTop.add(lblNewLabel);
		
		lblMenuIcon_2 = new JLabel("");
		lblMenuIcon_2.setIcon(new ImageIcon(Cashier.class.getResource("/KBNCashier/resources/clock.png")));
		lblMenuIcon_2.setBounds(529, 8, 24, 24);
		panelMenuListTop.add(lblMenuIcon_2);
		
		lblNewLabel_1 = new JLabel("KBN Cashier");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 4, 210, 32);
		panelMenuListTop.add(lblNewLabel_1);
		
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
		
		panelTitleBarOrderList = new JPanel();
		panelTitleBarOrderList.setBounds(0, 0, 373, 34);
		panelOrderList.add(panelTitleBarOrderList);
		panelTitleBarOrderList.setLayout(null);
		
		panelLow = new JPanel();
		panelLow.setBounds(10, 510, 373, 178);
		panelPrice.add(panelLow);
		panelLow.setLayout(null);
	}
}
