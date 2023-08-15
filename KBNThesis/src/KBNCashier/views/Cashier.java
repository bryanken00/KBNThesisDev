package KBNCashier.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;

public class Cashier extends JFrame {

	// Class
	private DbConnection dbCon;
	
	private JPanel contentPane;
	private JPanel panelMenuList;
	private JPanel panelPrice;
	private JPanel panelMenuListTop;
	private JPanel panelTop;
	private JPanel panelOrderList;
	private JPanel panelLow;
	private JPanel panelCategory;
	private JPanel panelProductList;
	
	public Cashier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Class
		dbCon = new DbConnection();
		
		initialize();
		
	}
	
	
	private void initialize() {
		
		panelMenuList = new JPanel();
		panelMenuList.setBounds(10, 11, 884, 699);
		contentPane.add(panelMenuList);
		panelMenuList.setLayout(null);
		
		panelMenuListTop = new JPanel();
		panelMenuListTop.setBounds(10, 11, 864, 40);
		panelMenuList.add(panelMenuListTop);
		panelMenuListTop.setLayout(null);
		
		panelCategory = new JPanel();
		panelCategory.setBounds(10, 62, 864, 51);
		panelMenuList.add(panelCategory);
		panelCategory.setLayout(null);
		
		panelProductList = new JPanel();
		panelProductList.setBounds(10, 124, 864, 564);
		panelMenuList.add(panelProductList);
		panelProductList.setLayout(null);
		
		panelPrice = new JPanel();
		panelPrice.setBounds(904, 11, 350, 699);
		contentPane.add(panelPrice);
		panelPrice.setLayout(null);
		
		panelTop = new JPanel();
		panelTop.setBounds(10, 11, 330, 40);
		panelPrice.add(panelTop);
		panelTop.setLayout(null);
		
		panelOrderList = new JPanel();
		panelOrderList.setBounds(10, 62, 330, 437);
		panelPrice.add(panelOrderList);
		panelOrderList.setLayout(null);
		
		panelLow = new JPanel();
		panelLow.setBounds(10, 510, 330, 178);
		panelPrice.add(panelLow);
		panelLow.setLayout(null);
	}
}
