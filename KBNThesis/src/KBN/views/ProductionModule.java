package KBN.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import KBN.Module.Production.KBNProducts.KBNData;
import KBN.Module.Production.KBNProducts.KBNPanelMain;
import KBN.Module.Production.Navs.ProductionNav;
import KBN.Module.Production.addItem.AddItemProduction;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;

public class ProductionModule extends JFrame implements ActionListener{
	
	
	// Class
	
		// Nav
		private ProductionNav nav;
		
		// Database
		private DbConnection dbConn;
		private ResultSet rs;
		private Statement st;
		
		// Username
		private dataSetter dataSet;
		
		// KBN Product
		private KBNPanelMain kbnMain;
		// KBN PanelGenerator
		private KBNData kbnData;
		private int kbnDataCounter;
		
		// Add Item
		private AddItemProduction addItem;
		
		
		// Strings
			// Acc Level
			private String AccountLevel = ""; 

	private JPanel contentPane;
	private JPanel panelNav;
	private JPanel container;

	public ProductionModule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
		panelNav = new JPanel();
		panelNav.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNav.setBackground(new Color(255, 255, 255));
		panelNav.setBounds(0, 0, 255, 721);
		contentPane.add(panelNav);
		panelNav.setLayout(null);
		
        container = new JPanel();
        container.setBorder(new LineBorder(new Color(0, 0, 0)));
        container.setBackground(new Color(255, 255, 255));
        container.setBounds(265, 11, 989, 699);
        contentPane.add(container);
        container.setLayout(null);
        
        // Database
        	dbConn = new DbConnection();
            try {
                st = dbConn.getConnection().createStatement();
    		} catch (Exception e) {
    			JMessage("Error ST: " + e.getMessage());
    		}
        
        // Class
        nav = new ProductionNav();
        kbnMain = new KBNPanelMain();
        kbnData = new KBNData();
        addItem = new AddItemProduction();
        
        
        
        panelNav.add(nav);
        container.add(kbnMain);
        kbnMain.container.setViewportView(kbnData);
        defaultPanel();
        kbnMain.setVisible(true);
        
        // Defaults
        setUsername();
        setActionList();
        kbnDataFunc();
	}
	

	// Default Panel
	private void defaultPanel() {
		kbnMain.setVisible(false);
		kbnData.setVisible(false);
	}

	// Action Listener
	private void setActionList() {
		
		// Navs
		nav.btnAddItem.addActionListener(this);
		nav.btnArchiveList.addActionListener(this);
		nav.btnKBNProduct.addActionListener(this);
		nav.btnRebrandingProduct.addActionListener(this);
		
		// KBN
		kbnMain.btnSearch.addActionListener(this);
		
		// Add Item
		addItem.btnAddItem.addActionListener(this);
	}
	
	// Popup Message
	private void JMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	// Setting Up Username
	private void setUsername() {
		dataSet = new dataSetter();
		nav.lblUsername.setText(dataSet.getUsername());
		AccountLevel = dataSet.getAccLevel();
	}
	
	// KBN Data
	private void kbnDataFunc() {
        defaultPanel();
        kbnMain.setVisible(true);
        kbnData = new KBNData();
        kbnMain.container.setViewportView(kbnData);
        kbnDataCounter();
        kbnDataButtons();
	}
	
	private void kbnDataCounter() {
		
	}
	
	private void kbnDataButtons() {
		for(int i = 0; i < kbnDataCounter; i++) {
			kbnData.btnViewDetails[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nav.btnAddItem) {
			addItem.setVisible(true);
		}
		if(e.getSource() == addItem.btnAddItem) {
			if(addItem.checker.equals("Verified")) {
				
			}else {
				JMessage("Please Verify first");
			}
		}
	}
}
