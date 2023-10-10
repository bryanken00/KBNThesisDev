package KBN.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import KBN.Module.Production.KBNProducts.KBNData;
import KBN.Module.Production.KBNProducts.KBNDataViewDetails;
import KBN.Module.Production.KBNProducts.KBNDataViewDetailsData;
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
			// Tracking
			private KBNDataViewDetails trackView;
			private KBNDataViewDetailsData KBNDetailsData;
		private int kbnDataCounter;
		
		// Add Item
		private AddItemProduction addItem;
		
		
		// Strings
			// Acc Level
			private String AccountLevel = "";
			private String userName = "";

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

		trackView = new KBNDataViewDetails();
		
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
		userName = dataSet.getUsername();
	}
	
	// KBN Data
	private void kbnDataFunc() {
        defaultPanel();
        kbnMain.setVisible(true);
        kbnData = new KBNData();
        kbnMain.container.setViewportView(kbnData);
        kbnDataCounter_();
        kbnDataButtons();
        kbnDataPanelGenerator();
        
	}
	
	private void kbnDataCounter_() {
		try {
			String SQL = "SELECT COUNT(TrackingID) FROM tblconfirmationtracking";
			st.execute(SQL);
			rs = st.getResultSet();
			if(rs.next())
				kbnDataCounter = rs.getInt(1);
			
			kbnData.iCountKBNProducts(kbnDataCounter);
		} catch (Exception e) {
			JMessage("Error kbnDataCounter: " + e.getMessage());
		}
	}
	
	private void kbnDataButtons() {
		for(int i = 0; i < kbnDataCounter; i++) {
			kbnData.btnViewDetails[i].addActionListener(this);
		}
	}
	
	private void kbnDataPanelGenerator() {
		try {
			String SQL = "SELECT a.TrackingID, DATE_FORMAT(a.DateAdded, '%Y-%m-%d') AS FormattedDateAdded, a.Status, a.AddedBy \n"
					+ "FROM tblconfirmationtracking AS a";
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				kbnData.lblTrackingID[i].setText(rs.getString(1));
				kbnData.lblDate[i].setText(rs.getString(2));
				kbnData.lblStatus[i].setText(rs.getString(3));
				i++;
			}
		} catch (Exception e) {
			JMessage("Error kbnDataPanelGenerator: " + e.getMessage());
		}
	}
	
	// Add Item
	
	private void AddItemFuncKBN() {
		try {
			if(addItem.checker.equals("Verified")) {
				String prodName = addItem.txtProductName.getText();
				String variant = addItem.cbVariant.getSelectedItem() + "";
				int quantity = Integer.parseInt(addItem.txtQuantity.getText());
				
		        LocalDate currentDate = LocalDate.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        String formattedDate = currentDate.format(formatter);
		        
				String checker = "SELECT TrackingID "
						+ "FROM tblconfirmationtracking WHERE DateAdded >= '" + formattedDate +"'";
				
				int checker__ = 0;
				st.execute(checker);
				rs = st.getResultSet();
				if(rs.next()) {
					checker__++;
				}
				
				if(checker__ == 0) {
					String SQLTracking = "INSERT INTO tblconfirmationtracking(DateAdded,Status, AddedBy) VALUES(NOW(),'PENDING','" + userName + "');";
					st.execute(SQLTracking);
				}
				
				String SQLConfirmDATA = "INSERT INTO tblconfirmationproduct (TrackingID, ProductName, ProductVariant, ProductQuantity,TimeAdded) \n"
						+ "SELECT MAX(a.TrackingID), b.prodName, b.prodVolume, '" + quantity + "', CURRENT_TIME \n"
						+ "FROM tblconfirmationtracking AS a \n"
						+ "JOIN tblproducts AS b ON b.prodName = '" + prodName + "' AND b.prodVolume = '" + variant + "' \n"
						+ "GROUP BY b.prodName, b.prodVolume;";
				

				st.execute(SQLConfirmDATA);
				JMessage("Product Added!");
				addItem.txtProductName.setText("");
				addItem.cbVariant.removeAllItems();
				addItem.txtQuantity.setText("0");
				addItem.checker = "Not-Verified";
				if(addItem.closeChecker.isSelected()) {
					kbnDataFunc();
					addItem.dispose();
				}
			}else {
				JMessage("Please Verify first");
			}
		} catch (Exception e) {
			JMessage("Error btnAddItem: " + e.getMessage());
		}
	}
	
	// View Details Data
	private void viewDetails(int index) {
		try {
			String trackingID = kbnData.lblTrackingID[index].getText();
	        trackView.lblTrackingID.setText("Tracking ID: " + trackingID);
	        
	        KBNDetailsData = new KBNDataViewDetailsData();
	        trackView.scrollPane.setViewportView(KBNDetailsData);
	        
	        String SQLCount = "SELECT COUNT(a.ProductName) \n"
	        		+ "FROM tblconfirmationproduct AS a \n"
	        		+ "JOIN tblconfirmationtracking AS b ON a.TrackingID = b.TrackingID \n"
	        		+ "WHERE b.TrackingID = '" + trackingID + "'";
	        
	        st.execute(SQLCount);
	        rs = st.getResultSet();
	        
	        int count = 0;
	        if(rs.next())
	        	count = rs.getInt(1);
	        
	        KBNDetailsData.prodCount(count);
	        
	        String SQL = "SELECT a.ID, a.ProductName, a.ProductVariant, a.ProductQuantity \n"
	        		+ "FROM tblconfirmationproduct AS a \n"
	        		+ "JOIN tblconfirmationtracking AS b ON a.TrackingID = b.TrackingID \n"
	        		+ "WHERE b.TrackingID = '" + trackingID + "'";
	        
	        st.execute(SQL);
	        rs = st.getResultSet();
	        int i = 0;
	        while(rs.next()) {
	        	KBNDetailsData.productID[i] = rs.getString(1);
	        	KBNDetailsData.lblProductName[i].setText(rs.getString(2));
	        	KBNDetailsData.lblVariant[i].setText(rs.getString(3));
	        	KBNDetailsData.lblQuantity[i].setText(rs.getString(4));
		        if(!kbnData.lblStatus[index].getText().equalsIgnoreCase("PENDING"))
		        	KBNDetailsData.btnDelete[i].setVisible(false);
	        	i++;
	        }
	        
	        
	        
			trackView.setVisible(true);
			trackView.revalidate();
		} catch (Exception e) {
			JMessage("Error viewDetails: " + e.getMessage());
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Navs
			if(e.getSource() == nav.btnKBNProduct) {
				kbnDataFunc();
			}
			
			if(e.getSource() == nav.btnAddItem) {
				addItem.setVisible(true);
			}
			
			if(e.getSource() == addItem.btnAddItem) {
				AddItemFuncKBN();
			}
		
		// KBNData Buttons
			if(kbnData.btnViewDetails != null) {
				for(int i = 0; i < kbnData.btnViewDetails.length; i++) {
					if(e.getSource() == kbnData.btnViewDetails[i]) {
						viewDetails(i);
						break;
					}
				}
			}
	}
}
