package KBN.Module.Production;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import KBN.commons.dataSetter;
import KBN.views.WarehouseModule;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductionModule extends JFrame implements ActionListener{

	//class
	private dataSetter dataSet;
	private Backtracking bt;
	private BacktrackingNav btn;
	
	private String columnDefaultData[];
	private DefaultTableModel main;
	
	private JPanel contentPane;
	private JLabel lblUsername;
	private JComboBox cbCategories;
	private JTextField txtSearchBar;
	private JButton btnSearch;
	private JButton btnAddItem;
	private JButton btnArchive;
	private JButton btnRestore;
	private JTable table;
	private JButton btnKBNProducts;
	private JButton btnRebranding;
	private JButton btnBacktracking;
	private JScrollPane scrollPane;
	private JPanel pButton;
	private JPanel pNav;
	private JPanel panelTable;

	public ProductionModule() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Production Inventory");
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
        components();
		table = new JTable();
		scrollPane.setViewportView(table);
		tableSetup();
		
		bt = new Backtracking();
		panelTable.add(bt);
		
		btn = new BacktrackingNav();
		this.add(btn);
		
		setDefault();
		
	}
	
	private void components() {
		pNav = new JPanel();
		pNav.setBounds(0, 0, 1264, 75);
		pNav.setLayout(null);
		contentPane.add(pNav);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ProductionModule.class.getResource("/KBN/resources/tempPicture.png")));
		lblLogo.setBounds(29, 11, 99, 53);
		pNav.add(lblLogo);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(1033, 17, 135, 40);
		pNav.add(lblUsername);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(ProductionModule.class.getResource("/KBN/resources/tempPicture.png")));
		lblLogo_1.setBounds(1178, 11, 61, 53);
		pNav.add(lblLogo_1);
		
		btnKBNProducts = new JButton("KBN Products");
		btnKBNProducts.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnKBNProducts.addActionListener(this);
		btnKBNProducts.setFocusable(false);
		btnKBNProducts.setBorderPainted(false);
		btnKBNProducts.setBackground(Color.WHITE);
		btnKBNProducts.setBounds(217, 11, 151, 46);
		pNav.add(btnKBNProducts);
		
		btnRebranding = new JButton("Rebranding");
		btnRebranding.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRebranding.addActionListener(this);
		btnRebranding.setFocusable(false);
		btnRebranding.setBorderPainted(false);
		btnRebranding.setBackground(Color.WHITE);
		btnRebranding.setBounds(390, 11, 151, 46);
		pNav.add(btnRebranding);
		
		btnBacktracking = new JButton("Backtracking");
		btnBacktracking.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnBacktracking.setFocusable(false);
		btnBacktracking.setBorderPainted(false);
		btnBacktracking.setBackground(Color.WHITE);
		btnBacktracking.setBounds(551, 11, 151, 46);
		btnBacktracking.addActionListener(this);
		pNav.add(btnBacktracking);
        
        setUsername();
        
		pButton = new JPanel();
		pButton.setLayout(null);
		pButton.setBounds(0, 74, 1264, 75);
		contentPane.add(pButton);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setFocusable(false);
		btnAddItem.setBorderPainted(false);
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(171, 14, 117, 46);
		pButton.add(btnAddItem);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setFocusable(false);
		btnArchive.setBorderPainted(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(298, 14, 117, 46);
		pButton.add(btnArchive);
		
		btnRestore = new JButton("Restore");
		btnRestore.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRestore.setFocusable(false);
		btnRestore.setBorderPainted(false);
		btnRestore.setBackground(Color.WHITE);
		btnRestore.setBounds(425, 14, 117, 46);
		pButton.add(btnRestore);
		
		String Categories[] = {"Categories", "Test1","Test2", "Waxes"};
		cbCategories = new JComboBox(Categories);
		cbCategories.setOpaque(false);
		cbCategories.setFocusable(false);
		cbCategories.setBounds(650, 14, 200, 46);
		cbCategories.setVisible(true);
		pButton.add(cbCategories);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(908, 14, 200, 46);
		pButton.add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(WarehouseModule.class.getResource("/KBN/resources/searchBarIcon.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(1118, 14, 50, 46);
		btnSearch.setOpaque(false);
		pButton.add(btnSearch);
		
		panelTable = new JPanel();
		panelTable.setLayout(null);
		panelTable.setBounds(0, 148, 1264, 573);
		contentPane.add(panelTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1264, 573);
		panelTable.add(scrollPane);
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"Product Name", "Quantity", "Price", "Reseller", "Receive", "Apperance"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
	}
	
	private void setDefault() {
		setTitle("Production Inventory");
		scrollPane.setVisible(true);
		pButton.setVisible(true);
		
		bt.setVisible(false);
		btn.setVisible(false);
	}

	private void setDisableAll() {
		scrollPane.setVisible(false);
		pButton.setVisible(false);
		bt.setVisible(false);
		btn.setVisible(false);
	}
	
	private void KBNProductsFunc() {
		setDefault();
	}
	
	private void backtrackFunc() {
		setDisableAll();
		bt.setVisible(true);
		btn.setVisible(true);
		setTitle("Production Inventory - Backtracking");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnKBNProducts) {
			KBNProductsFunc();
		}
		else if(e.getSource() == btnBacktracking) {
			backtrackFunc();
		}
	}
}
