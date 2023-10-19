package KBN.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import KBN.Module.Marketing.ModuleSelectionMarketing;
import KBN.Module.Production.ModuleSelectionProduction;
import KBN.Module.Production.KBNProducts.KBNData;
import KBN.Module.Production.KBNProducts.KBNPanelMain;
import KBN.Module.Production.KBNProducts.ViewDetails.KBNDataViewDetails;
import KBN.Module.Production.KBNProducts.ViewDetails.KBNDataViewDetailsData;
import KBN.Module.Production.Navs.ProductionNav;
import KBN.Module.Production.RebrandingProducts.RebrandingData;
import KBN.Module.Production.RebrandingProducts.RebrandingMain;
import KBN.Module.Production.RebrandingProducts.ViewDetails.RebrandingDataViewDetails;
import KBN.Module.Production.RebrandingProducts.ViewDetails.RebrandingDataViewDetailsData;
import KBN.Module.Production.addItem.AddItemProduction;
import KBN.Module.Production.addItem.AddItemProductionRebranding;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;

public class ProductionModule extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener{
	
	
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
			//
			private int trackingIndex = 0;
		private int kbnDataCounter;
		
		
		// Rebranding
		private RebrandingMain rebrandingMain;
		// Rebranding Panel Generator
		private RebrandingData rebrandingData;
			//Tracking
			private RebrandingDataViewDetails rebrandingTrackView;
			private RebrandingDataViewDetailsData rebrandingDetailsData;
			//
			private int rebrandingtrackingIndex = 0;
		

		private int rebrandingDataCounter;
		
		// Add Item
		private AddItemProduction addItem;
		private AddItemProductionRebranding addItemRebrand;
		
		// Module Selection
		private ModuleSelectionProduction moduleSelection;
		private MarketingModule marketingModule;
		private WarehouseModule_1 warehouseModule;
		
		
		// Strings
			// Acc Level
			private String AccountLevel = "";
			private String userName = "";
			
			
		// Checker
			private JButton btnChecker;

	private JPanel contentPane;
	private JPanel panelNav;
	private JPanel container;

	public ProductionModule() {
		setResizable(false);
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
        
        // Module
    	moduleSelection = new ModuleSelectionProduction();
		getContentPane().add(moduleSelection);
		moduleSelection.setVisible(false);
        
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

		
        // KBN
        kbnMain = new KBNPanelMain();
        kbnData = new KBNData();

		trackView = new KBNDataViewDetails();
        KBNDetailsData = new KBNDataViewDetailsData();
        
        
        // Rebranding
        rebrandingMain = new RebrandingMain();
        rebrandingData = new RebrandingData();
        
        rebrandingTrackView = new RebrandingDataViewDetails();
        rebrandingDetailsData = new RebrandingDataViewDetailsData();

        
        // Add Item
        addItem = new AddItemProduction();
        addItemRebrand = new AddItemProductionRebranding();
        
        

        
        panelNav.add(nav);
        container.add(kbnMain);
        container.add(rebrandingMain);
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
		rebrandingMain.setVisible(false);
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
		addItemRebrand.btnAddItem.addActionListener(this);
		
		
		nav.lblUsername.addMouseListener(this);
		nav.lblUsername.addKeyListener(this);
		moduleSelection.addKeyListener(this);
		moduleSelection.btnMarketingModule.addActionListener(this);
		moduleSelection.btnWarehouseModule.addActionListener(this);
		
		
		// Add Item Rebranding
		addItemRebrand.cbClientName.addItemListener(this);
		addItemRebrand.cbProductName.addItemListener(this);
		
		
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
	
	// Navs Color
	private void navColor() {
		nav.btnArchiveList.setBackground(new Color(255, 255, 255));
		nav.btnKBNProduct.setBackground(new Color(255, 255, 255));
		nav.btnRebrandingProduct.setBackground(new Color(255, 255, 255));

		nav.btnArchiveList.setForeground(new Color(0, 0, 0));
		nav.btnKBNProduct.setForeground(new Color(0, 0, 0));
		nav.btnRebrandingProduct.setForeground(new Color(0, 0, 0));
	}
	
	// KBN Data
	private void kbnDataFunc() {
		navColor();
		nav.btnKBNProduct.setBackground(new Color(8, 104, 0));
		nav.btnKBNProduct.setForeground(new Color(255, 255,255));
        defaultPanel();
        btnChecker = nav.btnKBNProduct;
        addItem.btnChecker = "KBN";
        kbnData = new KBNData();
        kbnMain.container.setViewportView(kbnData);
        kbnDataCounter_();
        kbnDataButtons();
        kbnDataPanelGenerator();
        kbnMain.setVisible(true);
	}
	
	private void kbnDataCounter_() {
		try {
			String SQL = "SELECT COUNT(TrackingID) FROM tblconfirmationtracking WHERE ProductType = 'KBN';";
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
					+ "FROM tblconfirmationtracking AS a "
					+ "WHERE ProductType = 'KBN';";
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
	
	// Rebranding
	private void rebrandingFunc() {
		navColor();
		nav.btnRebrandingProduct.setBackground(new Color(8, 104, 0));
		nav.btnRebrandingProduct.setForeground(new Color(255, 255,255));
        defaultPanel();
        btnChecker = nav.btnRebrandingProduct;
        addItem.btnChecker = "REBRANDING";
        rebrandingData = new RebrandingData();
        rebrandingMain.container.setViewportView(rebrandingData);
        rebrandingDataCounter_();
        rebrandingDataButtons();
        rebrandingDataPanelGenerator();
        rebrandingMain.setVisible(true);
	}
	
	private void rebrandingDataCounter_() {
		try {
			String SQL = "SELECT COUNT(TrackingID) FROM tblconfirmationtracking WHERE ProductType = 'REBRANDING';";
			st.execute(SQL);
			rs = st.getResultSet();
			if(rs.next())
				rebrandingDataCounter = rs.getInt(1);
			
			rebrandingData.iCountKBNProducts(rebrandingDataCounter);
		} catch (Exception e) {
			JMessage("Error rebrandingDataCounter_: " + e.getMessage());
		}
	}
	
	private void rebrandingDataButtons() {
		for(int i = 0; i < rebrandingDataCounter; i++) {
			rebrandingData.btnViewDetails[i].addActionListener(this);
		}
	}
	
	private void rebrandingDataPanelGenerator() {
		try {
			String SQL = "SELECT a.TrackingID, DATE_FORMAT(a.DateAdded, '%Y-%m-%d') AS FormattedDateAdded, a.Status, a.AddedBy \n"
					+ "FROM tblconfirmationtracking AS a "
					+ "WHERE ProductType = 'REBRANDING';";
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				rebrandingData.lblTrackingID[i].setText(rs.getString(1));
				rebrandingData.lblDate[i].setText(rs.getString(2));
				rebrandingData.lblStatus[i].setText(rs.getString(3));
				i++;
			}
		} catch (Exception e) {
			JMessage("Error rebrandingDataPanelGenerator: " + e.getMessage());
		}
	}
	
	private void kbnAdd() {
		try {
			addItem.btnVerifyFuncKBN();
			if(addItem.checker.equals("Verified")) {
				String prodName = addItem.txtProductName.getText();
				String variant = addItem.cbVariant.getSelectedItem() + "";
				int quantity = Integer.parseInt(addItem.txtQuantity.getText());
				
		        LocalDate currentDate = LocalDate.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        String formattedDate = currentDate.format(formatter);
		        
				String checker = "SELECT TrackingID "
						+ "FROM tblconfirmationtracking WHERE DateAdded >= '" + formattedDate +"' AND STATUS = 'PENDING' AND ProductType = 'KBN'";
				
				int checker__ = 0;
				st.execute(checker);
				rs = st.getResultSet();
				if(rs.next()) {
					checker__++;
				}
				
				if(checker__ == 0) {
					String SQLTracking = "INSERT INTO tblconfirmationtracking(DateAdded,Status, AddedBy,ProductType) VALUES(NOW(),'PENDING','" + userName + "', 'KBN');";
					st.execute(SQLTracking);
				}
				
				String SQLConfirmDATA = "INSERT INTO tblconfirmationproduct (TrackingID, ProductName, ProductVariant, ProductQuantity, TimeAdded) \n"
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
				addItem.closeChecker.setSelected(false);
			}else {
				JMessage("Please Verify first");
			}
		} catch (Exception e) {
			JMessage("Error btnAddItem: " + e.getMessage());
		}
	}
	
	private void rebrandingAdd() {
		try {
			if(addItemRebrand.cbProductName.getSelectedItem() == null || addItemRebrand.cbVariant.getSelectedItem() == null) {
				JMessage("Please Select First");
				return;
			}
			
			String userID = addItemRebrand.userID.get(addItemRebrand.cbClientName.getSelectedIndex());
			String prodName = addItemRebrand.cbProductName.getSelectedItem() + "";
			String variant = addItemRebrand.cbVariant.getSelectedItem() + "";
			int quantity = Integer.parseInt(addItemRebrand.txtQuantity.getText());
			
	        LocalDate currentDate = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String formattedDate = currentDate.format(formatter);
	        
			String checker = "SELECT TrackingID "
					+ "FROM tblconfirmationtracking WHERE DateAdded >= '" + formattedDate +"' AND STATUS = 'PENDING' AND ProductType = 'REBRANDING'";
			
			int checker__ = 0;
			st.execute(checker);
			rs = st.getResultSet();
			if(rs.next()) {
				checker__++;
			}
			
			if(checker__ == 0) {
				String SQLTracking = "INSERT INTO tblconfirmationtracking(DateAdded,Status, AddedBy, ProductType) VALUES(NOW(),'PENDING','" + userName + "', 'REBRANDING');";
				st.execute(SQLTracking);
			}
			String SQLRebrandingConfirmDATA = "INSERT INTO tblconfirmationproductRebranding (UserID, TrackingID, ProductName, ProductVariant, ProductQuantity, TimeAdded)\r\n"
					+ "SELECT '" + userID + "', MAX(a.TrackingID), b.prodName, b.prodVolume, '" + quantity + "', CURRENT_TIME\r\n"
					+ "FROM tblconfirmationtracking AS a \r\n"
					+ "JOIN tblrebrandingproducts AS b ON b.prodName = '" + prodName + "' AND b.prodVolume = '" + variant +"' \r\n"
					+ "GROUP BY b.prodName, b.prodVolume;";
			

			st.execute(SQLRebrandingConfirmDATA);
			JMessage("Product Added!");
			
			addItemRebrand.cbProductName.removeAllItems();
			addItemRebrand.cbVariant.removeAllItems();
			addItemRebrand.txtQuantity.setText("0");
			
			if(addItemRebrand.closeChecker.isSelected()) {
				rebrandingFunc();
				addItemRebrand.dispose();
			}
			addItemRebrand.closeChecker.setSelected(false);
		} catch (Exception e) {
			JMessage("Error rebrandingAdd(): " + e.getMessage());
		}
	}
	
	// View Details Data
	private void viewDetails(int index) {
		try {
			trackingIndex = index;
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
	        
	        String SQL = "SELECT a.ID, a.ProductName, a.ProductVariant, a.ProductQuantity, DATE_FORMAT(a.TimeAdded, '%h:%i %p') AS TimeAdded_AMPM, b.TrackingID \n"
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
	        	KBNDetailsData.lblTime[i].setText(rs.getString(5));

		        KBNDetailsData.TrackingID = rs.getString(6);
		        if(!kbnData.lblStatus[index].getText().equalsIgnoreCase("PENDING"))
		        	KBNDetailsData.btnDelete[i].setVisible(false);
		     	KBNDetailsData.btnDelete[i].addActionListener(this);
	        	i++;

	        }

			trackView.revalidate();
			trackView.setVisible(true);
		} catch (Exception e) {
			JMessage("Error viewDetails: " + e.getMessage());
		}

	}
	
	private void RebrandViewDetails(int index) {
		try {
			rebrandingtrackingIndex = index;
			String trackingID = rebrandingData.lblTrackingID[index].getText();
			rebrandingTrackView.lblTrackingID.setText("Tracking ID: " + trackingID);
	        
			rebrandingDetailsData = new RebrandingDataViewDetailsData();
	        rebrandingTrackView.scrollPane.setViewportView(rebrandingDetailsData);
	        
	        String SQLCount = "SELECT COUNT(a.ProductName) \n"
	        		+ "FROM tblconfirmationproductRebranding AS a \n"
	        		+ "JOIN tblconfirmationtracking AS b ON a.TrackingID = b.TrackingID \n"
	        		+ "WHERE b.TrackingID = '" + trackingID + "'";
	        
	        st.execute(SQLCount);
	        rs = st.getResultSet();
	        
	        int count = 0;
	        if(rs.next())
	        	count = rs.getInt(1);
	        
	        
	        rebrandingDetailsData.prodCount(count);
	        
	        String SQL = "SELECT a.ID, a.ProductName, a.ProductVariant, a.ProductQuantity, DATE_FORMAT(a.TimeAdded, '%h:%i %p') AS TimeAdded_AMPM, b.TrackingID \n"
	        		+ "FROM tblconfirmationproductRebranding AS a \n"
	        		+ "JOIN tblconfirmationtracking AS b ON a.TrackingID = b.TrackingID \n"
	        		+ "WHERE b.TrackingID = '" + trackingID + "'";
	        
	        st.execute(SQL);
	        rs = st.getResultSet();
	        int i = 0;
	        while(rs.next()) {
	        	rebrandingDetailsData.productID[i] = rs.getString(1);
	        	rebrandingDetailsData.lblProductName[i].setText(rs.getString(2));
	        	rebrandingDetailsData.lblVariant[i].setText(rs.getString(3));
	        	rebrandingDetailsData.lblQuantity[i].setText(rs.getString(4));
	        	rebrandingDetailsData.lblTime[i].setText(rs.getString(5));

	        	rebrandingDetailsData.TrackingID = rs.getString(6);
		        if(!rebrandingData.lblStatus[index].getText().equalsIgnoreCase("PENDING"))
		        	rebrandingDetailsData.btnDelete[i].setVisible(false);
		        rebrandingDetailsData.btnDelete[i].addActionListener(this);
	        	i++;

	        }

			rebrandingTrackView.revalidate();
			rebrandingTrackView.setVisible(true);
		} catch (Exception e) {
			JMessage("Error Rebranding viewDetails: " + e.getMessage());
		}

	}
	
	private void deleteDetails(int index) {
		try {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete\n" + KBNDetailsData.lblProductName[index].getText() + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if(KBNDetailsData.productID.length == 1) {
					String SQLDelete1 = "DELETE FROM tblconfirmationtracking WHERE TrackingID = '" + KBNDetailsData.TrackingID + "'";
					st.execute(SQLDelete1);
					
					String SQLDelete = "DELETE FROM tblconfirmationproduct WHERE ID = '" + KBNDetailsData.productID[index] + "'";
					st.execute(SQLDelete);
					
					viewDetails(trackingIndex);
					kbnDataFunc();
					trackView.dispose();
				}else {
					String SQLDelete = "DELETE FROM tblconfirmationproduct WHERE ID = '" + KBNDetailsData.productID[index] + "'";
					st.execute(SQLDelete);
					viewDetails(trackingIndex);
				}
			}else {
				
			}

		} catch (Exception e) {
			JMessage("Error deleteDetails: " + e.getMessage());
		}
	}
	
	private void RebranddeleteDetails(int index) {
		try {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete\n" + rebrandingDetailsData.lblProductName[index].getText() + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if(rebrandingDetailsData.productID.length == 1) {
					String SQLDelete1 = "DELETE FROM tblconfirmationtracking WHERE TrackingID = '" + rebrandingDetailsData.TrackingID + "'";
					st.execute(SQLDelete1);
					
					String SQLDelete = "DELETE FROM tblconfirmationproductRebranding WHERE ID = '" + rebrandingDetailsData.productID[index] + "'";
					st.execute(SQLDelete);
					
					RebrandViewDetails(trackingIndex);
					rebrandingFunc();
					rebrandingTrackView.dispose();
				}else {
					String SQLDelete = "DELETE FROM tblconfirmationproductRebranding WHERE ID = '" + rebrandingDetailsData.productID[index] + "'";
					st.execute(SQLDelete);
					RebrandViewDetails(trackingIndex);
				}
			}else {
				
			}

		} catch (Exception e) {
			JMessage("Error RebranddeleteDetails: " + e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Navs
			if(e.getSource() == nav.btnKBNProduct)
				kbnDataFunc();
			
			if(e.getSource() == nav.btnRebrandingProduct)
				rebrandingFunc();

			if(e.getSource() == nav.btnArchiveList) {
				navColor();
				nav.btnArchiveList.setBackground(new Color(8, 104, 0));
				nav.btnArchiveList.setForeground(new Color(255, 255,255));
			}
			
			if(e.getSource() == nav.btnAddItem) {
				if(btnChecker == nav.btnKBNProduct)
					addItem.setVisible(true);
				else if(btnChecker == nav.btnRebrandingProduct) {
					addItemRebrand.getClientName();
					addItemRebrand.setVisible(true);
				}
				else
					JMessage("Something Wrong");
			}
			
			if(e.getSource() == addItem.btnAddItem)
				kbnAdd();
			
			if(e.getSource() == addItemRebrand.btnAddItem)
				rebrandingAdd();
			
		// Module Selection
			if(e.getSource() == moduleSelection.btnMarketingModule) {
				marketingModule = new MarketingModule();
				marketingModule.setVisible(true);
				this.dispose();
			}
			if(e.getSource() == moduleSelection.btnWarehouseModule) {
				warehouseModule = new WarehouseModule_1();
				warehouseModule.setVisible(true);
				this.dispose();
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
			
		// Tracking
		if(KBNDetailsData.btnDelete != null) {
			if(KBNDetailsData.btnDelete.length != 0) {
				for(int i = 0; i < KBNDetailsData.btnDelete.length; i++) {
					if(e.getSource() == KBNDetailsData.btnDelete[i]) {
						deleteDetails(i);
						break;
					}
				}
			}
		}
			
		// Rebraning Data Buttons
			if(rebrandingData.btnViewDetails != null) {
				for(int i = 0; i < rebrandingData.btnViewDetails.length; i++) {
					if(e.getSource() == rebrandingData.btnViewDetails[i]) {
						RebrandViewDetails(i);
						break;
					}
				}
			}
			
		// Rebrand Tracking
		if(rebrandingDetailsData.btnDelete != null) {
			if(rebrandingDetailsData.btnDelete.length != 0) {
				for(int i = 0; i < rebrandingDetailsData.btnDelete.length; i++) {
					if(e.getSource() == rebrandingDetailsData.btnDelete[i]) {
						RebranddeleteDetails(i);
						break;
					}
				}
			}
		}
			

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == nav.lblUsername) {
			if(e.getKeyCode() == 27 || e.getSource() == moduleSelection) {
				moduleSelection.setVisible(false);
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == nav.lblUsername) {
			moduleSelection.setBounds(nav.lblUsername.getX() + 30, nav.lblUsername.getY() - 50, 270, 67);
			moduleSelection.setVisible(true);
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		
    	if(e.getSource() == addItemRebrand.cbClientName) {
    		addItemRebrand.cbProductName.removeItemListener(this);
    	    if (e.getStateChange() == ItemEvent.SELECTED) {
    			String userID_ = addItemRebrand.userID.get(addItemRebrand.cbClientName.getSelectedIndex());
    			addItemRebrand.cbProductName.removeAllItems();
    			
    			try {
    				st.execute("SELECT prodName FROM tblrebrandingproducts WHERE userID = '" + userID_ +"';");
    				rs = st.getResultSet();
    				ArrayList<String> temp = new ArrayList<>();
    				while(rs.next()) {
    					addItemRebrand.cbProductName.addItem(rs.getString(1));
    				}
    				
    				
    			} catch (Exception e2) {
    				JMessage("Error ItemChange cbClientName: " + e2.getMessage());
    			}

        		addItemRebrand.cbProductName.addItemListener(this);
    	    }
		}
    	
    	if(e.getSource() == addItemRebrand.cbProductName) {
    		if(e.getStateChange() == ItemEvent.SELECTED) {
    			String userID_ = addItemRebrand.userID.get(addItemRebrand.cbClientName.getSelectedIndex());
    			String productName = addItemRebrand.cbProductName.getSelectedItem() + "";
    			addItemRebrand.cbVariant.removeAllItems();
    			
				try {
					st.execute("SELECT prodVolume FROM tblrebrandingproducts WHERE userID = '" + userID_ +"' AND prodName = '" + productName + "';");
					rs = st.getResultSet();
					while(rs.next()) {
						addItemRebrand.cbVariant.addItem(rs.getString(1));
					}
				} catch (Exception e2) {
					JMessage("Error ItemChange cbProductName: " + e2.getMessage());
				}
    		}
    	}
	}
}
