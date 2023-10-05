package KBN.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.Module.Warehouse.Archive.ArchiveList;
import KBN.Module.Warehouse.ProcessOrder.ProcessOrder;
import KBN.Module.Warehouse.ProcessOrder.ProcessOrderData;
import KBN.Module.Warehouse.ProcessOrder.onDelivery;
import KBN.Module.Warehouse.RawMatsList.ArchiveRightClick;
import KBN.Module.Warehouse.RawMatsList.RawMaterials;
import KBN.Module.Warehouse.RawMatsList.genQRCode;
import KBN.Module.Warehouse.Summary.SummaryPanel;
import KBN.Module.Warehouse.Summary.exportTable;
import KBN.Module.Warehouse.nav.WarehouseNav;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class WarehouseModule_1 extends JFrame implements ActionListener, MouseListener, KeyListener  {

	
	//Class
	private ArchiveRightClick rightClickRawMats;
	private WarehouseNav wNav;
	private RawMaterials rawMats;
	private ArchiveList arcList;
	private SummaryPanel summary;
	private exportTable exportT;
	private ProcessOrder procOrder;
	private ProcessOrderData procOrderData;
	private onDelivery onDeliver;
	
	// QR Code Generator
	private genQRCode genQR;
	
	// Account
	private dataSetter dataSet;
	private String accLevel = "";
	
	//SQL
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	
	// Date
	private Date date;
	private SimpleDateFormat inputFormat;
	private SimpleDateFormat outputFormat;
	private DateFormat df;
	
	// Export
	private JFileChooser fc;
	
	// Array
	private ArrayList arrSQLResult;
	private List<String> categoryData;
	
	// Counter
	private int processOrder = 0;
	
	// ref ID
	private String refNumber = "";
	private int processPanelIndex = 0;
	
	private JPanel contentPane;
	private JPanel panelNav;
	private JPanel container;

	public WarehouseModule_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("Warehouse Inventory");
		setContentPane(contentPane);
		
		// Right Click
        rightClickRawMats = new ArchiveRightClick();
        this.add(rightClickRawMats);
        rightClickRawMats.setVisible(false);
		
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
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        //Date Format
        date = new Date();
        inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		df = new SimpleDateFormat("yyyy-MM-dd");
        
        // Database
        dbConn = new DbConnection();
        try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			printingError("Statement ERROR: " + e.getMessage());
		}
        
        // Class Declaration
        wNav = new WarehouseNav();
        rawMats = new RawMaterials();
        arcList = new ArchiveList();
        summary = new SummaryPanel();
        exportT = new exportTable();
        procOrder = new ProcessOrder();
        onDeliver = new onDelivery();
        
        // QR Code
        genQR = new genQRCode();
        
        // Nav Panel
        panelNav.add(wNav);
        
        // Container Panel
        container.add(rawMats); // Raw Mats
        container.add(arcList); // Archive
        container.add(summary); // Summary
        container.add(procOrder); // ProcessOrder
        
        // Defaults
        setUsername();
        actionList();
        categoriesSetup();
        warehouseButtonsDefault();
        warehouseButtons();
        panelVisible();
        rawMats.setVisible(true);
        
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth";
		rawMatsTable(sql);
		
		wNav.btnAddItem.setVisible(true);
		wNav.btnQRCode.setVisible(true);
	}
	
	private void printingError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		accLevel = dataSet.getAccLevel();
		wNav.lblUsername.setText(dataSet.getUsername());
	}
	
	private void NavsColor() {
		wNav.btnRawMats.setBackground(Color.WHITE);
		wNav.btnPackMats.setBackground(Color.WHITE);
		wNav.btnFinishProduct.setBackground(Color.WHITE);
		wNav.btnArchiveList.setBackground(Color.WHITE);
		wNav.btnSummary.setBackground(Color.WHITE);
		wNav.btnProcessOrder.setBackground(Color.WHITE);
		

		wNav.btnRawMats.setForeground(Color.BLACK);
		wNav.btnPackMats.setForeground(Color.BLACK);
		wNav.btnFinishProduct.setForeground(Color.BLACK);
		wNav.btnArchiveList.setForeground(Color.BLACK);
		wNav.btnSummary.setForeground(Color.BLACK);
		wNav.btnProcessOrder.setForeground(Color.BLACK);
	}
	
	private void warehouseButtonsDefault() {
		wNav.btnAddItem.setEnabled(false);
		wNav.btnQRCode.setEnabled(false);
		
		wNav.btnRawMats.setEnabled(false);
		wNav.btnPackMats.setEnabled(false);
		wNav.btnFinishProduct.setEnabled(false);
		wNav.btnArchiveList.setEnabled(false);
		wNav.btnSummary.setEnabled(false);
		wNav.btnProcessOrder.setEnabled(false);
		
		rawMats.table.removeMouseListener(this);
	}
	
	private void warehouseButtons() {
		if(accLevel.equals("Admin--") || accLevel.equals("Admin-Warehouse-All")) {
			
			wNav.btnAddItem.setEnabled(true);
			wNav.btnQRCode.setEnabled(true);
			
			wNav.btnRawMats.setEnabled(true);
			wNav.btnPackMats.setEnabled(true);
			wNav.btnFinishProduct.setEnabled(true);
			wNav.btnArchiveList.setEnabled(true);
			wNav.btnSummary.setEnabled(true);
			wNav.btnProcessOrder.setEnabled(true);
			
			rawMats.table.addMouseListener(this);

		} else if(accLevel.equals("Staff-Warehouse-GenerateQR-Inventory")) {
			wNav.btnQRCode.setEnabled(true);
			
			rawMats.table.addMouseListener(this);
		} else if(accLevel.equals("Staff-Warehouse-First-inFirst-out")) {
			
		} else {
			warehouseButtonsDefault();
		}
	}

	private void actionList() {
		
		// wNav
		wNav.btnAddItem.addActionListener(this);
		wNav.btnQRCode.addActionListener(this);
		
		wNav.btnRawMats.addActionListener(this);
		wNav.btnPackMats.addActionListener(this);
		wNav.btnFinishProduct.addActionListener(this);
		wNav.btnArchiveList.addActionListener(this);
		wNav.btnSummary.addActionListener(this);
		wNav.btnProcessOrder.addActionListener(this);
		wNav.btnCompute.addActionListener(this);
		wNav.btnExport.addActionListener(this);
		
		// rightClickRawMats
		rightClickRawMats.btnAddItem.addActionListener(this);
		rightClickRawMats.btnArchive.addActionListener(this);
		rightClickRawMats.btnQRGen.addActionListener(this);
		
		// rawMats
		rawMats.btnSearch.addActionListener(this);
		rawMats.rawMatsCategory.addActionListener(this);
		rawMats.cbAvailable.addActionListener(this);
			// Mouse
			rawMats.table.addMouseListener(this);
			// Key
			rawMats.table.addKeyListener(this);
			
		// Archive
		arcList.btnSearch.addActionListener(this);
		arcList.rawMatsCategory.addActionListener(this);
			// Mouse
			arcList.table.addMouseListener(this);
			// Key
			arcList.table.addKeyListener(this);
			
		// Summary
		summary.btnSearch.addActionListener(this);
		
		// Process Order
		procOrder.btnSearch.addActionListener(this);
		procOrder.btnProcessOrder.addActionListener(this);
		procOrder.cbCategory.addActionListener(this);
			
			// On Delivery
			onDeliver.btnConfirm.addActionListener(this);
	}
	
	private void panelVisible() {
		rawMats.setVisible(false);
		arcList.setVisible(false);
		summary.setVisible(false);
		procOrder.setVisible(false);
		
		// Navs
		wNav.btnCompute.setVisible(false);
		wNav.btnExport.setVisible(false);
		wNav.btnAddItem.setVisible(false);
		wNav.btnQRCode.setVisible(false);
		wNav.startingDate.setVisible(false);
		wNav.endDate.setVisible(false);
	}
	
	private void categoriesSetup() {
		String sql = "SELECT DISTINCT CATEGORIES FROM tblcurrentmonth";
		categoryData = new ArrayList<String>();
		try {
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				categoryData.add(rs.getString(1));
			}
			rawMats.rawMatsCategory.setModel(new DefaultComboBoxModel<String>(categoryData.toArray(new String[0])));
			arcList.rawMatsCategory.setModel(new DefaultComboBoxModel<String>(categoryData.toArray(new String[0])));
			summary.cbSummaryCategories.setModel(new DefaultComboBoxModel<String>(categoryData.toArray(new String[0])));
		} catch (Exception e) {
			printingError("Categories \n" + e.getMessage());
		}
	}

	
	// Raw Materials
	private void rawMatsTable(String sql) {
		rawMats.main.setRowCount(0);
		rawMats.revalidate();
		arrSQLResult = new ArrayList<>();
		try {
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				arrSQLResult.add(rs.getString(1));
				arrSQLResult.add(rs.getString(2));
				arrSQLResult.add(rs.getString(3));
				arrSQLResult.add(rs.getString(4));
				
				//Date
	            date = inputFormat.parse(rs.getString(5));
	            String outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				// END OF DATE
				
				arrSQLResult.add(rs.getString(6));
				arrSQLResult.add(rs.getString(7));
				arrSQLResult.add(rs.getString(8));
				arrSQLResult.add(rs.getString(9));
				rawMats.main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
		}catch (Exception e) {
			printingError("Table ERROR: " + e.getMessage());
		}
	}
	
	// Archive List
	private void printingArchiveList(String sql) {
		arcList.main.getDataVector().removeAllElements();
		arcList.revalidate();
		try {
			st = dbConn.getConnection().createStatement();
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				arrSQLResult.add(rs.getString(1));
				arrSQLResult.add(rs.getString(2));
				arrSQLResult.add(rs.getString(3));
				arrSQLResult.add(rs.getString(4));
				arrSQLResult.add(rs.getString(5));
				
				//Date
	            date = inputFormat.parse(rs.getString(6));
	            String outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				
				arrSQLResult.add(rs.getString(7));
				
//				//Date
				date = inputFormat.parse(rs.getString(8));
				outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				
				arcList.main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
		}catch (Exception e) {
			printingError("Table ERROR: ArchiveList" + e.getMessage());
		}
	}
	
	// Raw Materials Panel
	private void wNavRawMatsFunc() {
		NavsColor();
		wNav.btnRawMats.setBackground(new Color(75, 119, 71));
		wNav.btnRawMats.setForeground(Color.WHITE);
		wNav.btnAddItem.setText("Add Item");
        panelVisible();
		wNav.btnAddItem.setVisible(true);
		wNav.btnQRCode.setVisible(true);
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth";
		rawMatsTable(sql);
        rawMats.setVisible(true);
	}
	
	// QR Code Generator
	private void generateQRCode() {
		String MN = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 2) + "";
		String CN = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 3) + "";
		String S = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 1) + "";
		String itemDate = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 4) + "";
		String Volume = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 5) + "";
		
		String QRCodeName = MN + " " + itemDate +".png";
		String url = "http://localhost/webdevelopment/thesis1_website/warehouse/?MN=" + MN + "&CN=" + CN + "&S=" + S + "&date=" + itemDate+"&tv=" + Volume;
		try {
			genQR.gettingURL(url, QRCodeName);
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR QRCODE: " + e1.getMessage());
		}
	}
	
	// Archive List Panel
	private void wNavArcListFunc() {
		NavsColor();
		wNav.btnArchiveList.setBackground(new Color(75, 119, 71));
		wNav.btnArchiveList.setForeground(Color.WHITE);
        panelVisible();
		wNav.btnAddItem.setText("Restore");
        arcList.setVisible(true);
		String sql = "SELECT a.itemID, a.SUPPLIER, a.MATERIAL_NAME, a.CODE_NAME, a.RELEASED_VOLUME, a.DATE_TODAY, tblarchiveuser.userAccount, tblarchiveuser.ArchiveDate FROM tblcurrentmonth_archive AS a INNER JOIN tblarchiveuser ON a.itemID = tblarchiveuser.itemID";
		printingArchiveList(sql);
	}
	
	
	// Search
	private void rawMatsCat() {
		if(rawMats.cbAvailable.getSelectedIndex() == 0) {
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE CATEGORIES = '" + rawMats.rawMatsCategory.getSelectedItem() + "'";
			rawMatsTable(sql);
		}else {
			String sql = "SELECT DISTINCT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN\r\n"
					+ "FROM tblcurrentmonth\r\n"
					+ "WHERE CATEGORIES = '" + rawMats.rawMatsCategory.getSelectedItem() + "'"
					+ "GROUP BY MATERIAL_NAME, CODE_NAME, SUPPLIER\r\n"
					+ "ORDER BY DATE_TODAY ASC;";
			rawMatsTable(sql);
		}
	}
	
	private void rawMatsAvailable() {
		String sql = "SELECT DISTINCT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN\r\n"
				+ "FROM tblcurrentmonth\r\n"
				+ "GROUP BY MATERIAL_NAME, CODE_NAME, SUPPLIER\r\n"
				+ "ORDER BY DATE_TODAY ASC;\r\n"
				+ "";
		rawMatsTable(sql);
	}
	
	private void rawMatsSearch() {
		String MaterialName = "";
		if(rawMats.txtSearchBar.getText().equals("Search by Material Name"))
			MaterialName = "";
		else
			MaterialName = rawMats.txtSearchBar.getText();
		
		
		if(rawMats.cbAvailable.getSelectedIndex() == 0) {
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN "
					+ "FROM tblcurrentmonth "
					+ "WHERE MATERIAL_NAME LIKE '%" + MaterialName + "%'";
			rawMatsTable(sql);
		}else {
			String sql = "SELECT DISTINCT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN\r\n"
					+ "FROM tblcurrentmonth\r\n"
					+ "WHERE MATERIAL_NAME LIKE '%" + MaterialName + "%'"
					+ "GROUP BY MATERIAL_NAME, CODE_NAME, SUPPLIER\r\n"
					+ "ORDER BY DATE_TODAY ASC;";
			rawMatsTable(sql);
		}
		
		

	}
	
	// Archive RightClick
	// button archive
	private void archiveItemFunc() {
		
		int[] selectedRows = rawMats.table.getSelectedRows();

		int dia = JOptionPane.showConfirmDialog(null, "You want to Archive the selected item?", "Confirmation", JOptionPane.YES_NO_OPTION);

		if (dia == JOptionPane.YES_OPTION) {
			for (int i = 0; i < selectedRows.length; i++) {
				//"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME","DATE", "CURRENT VOLUME", "APPEARANCE", "RELEASED", "REJECT", "HOLD", "PROD RETURN"
				String todayReleased = rawMats.table.getValueAt(selectedRows[i], 7) + "";
				String MatsName = rawMats.table.getValueAt(selectedRows[i], 2) + "";
				String CodeName = rawMats.table.getValueAt(selectedRows[i], 3) + "";
				String Supplier = rawMats.table.getValueAt(selectedRows[i], 1) + "";
				String dateToday1 = rawMats.table.getValueAt(selectedRows[i], 4) + "";
				String itemID = rawMats.table.getValueAt(rawMats.table.getSelectedRow(), 0) + "";

				String userName = wNav.lblUsername.getText();
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String dateToday = formatter.format(date);
			    
				String sqlInsert = "INSERT INTO tblcurrentmonth_archive \n"
						+ "SELECT * \n"
						+ "FROM tblcurrentmonth \n"
						+ "WHERE itemID = '" + itemID + "';";
				String sqlInsert2 =  "INSERT INTO tblArchiveUser VALUES('" + itemID + "','" + userName + "',NOW());";
				
				
				String sqlUpdate = "UPDATE tblcurrentmonth"
						+ " SET todayCurrentVolume = todayCurrentVolume + " + todayReleased 
						+ " WHERE MATERIAL_NAME = '" + MatsName + "' AND CODE_NAME = '" + CodeName + "' AND SUPPLIER = '" + Supplier + "' AND DATE_TODAY >= '" + dateToday1 + "';";

				String sqlDelete = "DELETE FROM tblcurrentmonth WHERE itemID = '" + itemID + "';";
				
				String sqlArchive =
					    "CREATE PROCEDURE ArchiveAndDeleteItem()\n" +
					    "BEGIN\n" +
					    "    DECLARE EXIT HANDLER FOR SQLEXCEPTION\n" +
					    "    BEGIN\n" +
					    "        ROLLBACK;\n" +
					    "        RESIGNAL;\n" +
					    "    END;\n" +
					    "\n" +
					    "    START TRANSACTION;\n" +
					    sqlInsert + "\n" +
					    sqlInsert2 + "\n" +
					    sqlDelete + "\n" +
					    sqlUpdate + "\n" +
					    "    COMMIT;\n" +
					    "END;";
				
				ArchiveSQL(sqlArchive);
				
				rawMats.main.removeRow(selectedRows[i]);
				rawMats.table.setModel(rawMats.main);
			}

			JOptionPane.showMessageDialog(null, "Item added to Archive");
			rightClickRawMats.setVisible(false);
		} else {
			//cancel
		}
	}
	
	private void ArchiveSQL(String sqlArchive) {
		try {
			st.execute("DROP PROCEDURE IF EXISTS ArchiveAndDeleteItem;");
			st.execute(sqlArchive);
			st.execute("CALL ArchiveAndDeleteItem();");
		} catch (Exception e) {
			printingArchiveList("Error ArchiveSQL: " + e.getMessage());
		}
	}
	
	// Summary
	private void summaryFunc() {
		NavsColor();
		wNav.btnSummary.setBackground(new Color(75, 119, 71));
		wNav.btnSummary.setForeground(Color.WHITE);
		panelVisible();
		summary.setVisible(true);
		wNav.btnCompute.setVisible(true);
		wNav.btnExport.setVisible(true);
		wNav.startingDate.setVisible(true);
		wNav.endDate.setVisible(true);
	}
	
	private void computeSummary() {
		summary.main.setRowCount(0);
		
		String dateFrom1 = df.format(wNav.startingDate.getDate());
		String dateTo1 = df.format(wNav.endDate.getDate());
		
		String sql = "SELECT a.MATERIAL_NAME, a.CODE_NAME, b.CONTROL_NUMBER, a.SUPPLIER, SUM(a.RELEASED_VOLUME) FROM tblcurrentmonth AS a LEFT JOIN tblmonthlysummary AS b ON a.MATERIAL_NAME = b.MATERIAL_NAME AND a.CODE_NAME = b.CODE_NAME AND a.SUPPLIER = b.SUPPLIER WHERE a.CATEGORIES = '" + summary.cbSummaryCategories.getSelectedItem() + "' AND a.DATE_TODAY >= '" + dateFrom1 + "' AND a.DATE_TODAY <= '" + dateTo1 + "' GROUP BY a.MATERIAL_NAME HAVING SUM(a.RELEASED_VOLUME) > 0";
//		summary.main.getDataVector().removeAllElements();
		summary.revalidate();
		try {
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				arrSQLResult.add(rs.getString(1));
				arrSQLResult.add(rs.getString(2));
				arrSQLResult.add(rs.getString(3));
				arrSQLResult.add(rs.getString(4));
				arrSQLResult.add(rs.getString(5));
				summary.main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
			summary.table.setModel(summary.main);		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Table ERROR: \n" + e.getMessage());
		}
	}
	
	private void btnExportFunc() {

        fc = new JFileChooser();
        int option = fc.showSaveDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            String filename = fc.getSelectedFile().getName(); 
            String path = fc.getSelectedFile().getParentFile().getPath();

			int len = filename.length();
			String ext = "";
			String file = "";

			if(len > 4){
				ext = filename.substring(len-4, len);
			}

			if(ext.equals(".xls")){
				file = path + "\\" + filename; 
			}else{
				file = path + "\\" + filename + ".xls"; 
			}
			exportT.toExcel(summary.table, new File(file));
		}
        
	}
	
	// Process OrderPanel
	private void procPanelFunc() {
		NavsColor();
		panelVisible();
			
		wNav.btnProcessOrder.setBackground(new Color(75, 119, 71));
		wNav.btnProcessOrder.setForeground(Color.WHITE);
		procOrder.setVisible(true);

        procOrderData = new ProcessOrderData();
        procOrder.orderListScrollPane.setViewportView(procOrderData);
        
        try {	        
	        String sqlCount = "SELECT COUNT(a.OrderRefNumber) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled';";
	        st.execute(sqlCount);
	        rs = st.getResultSet();
	        if(rs.next())
	        	processOrder = rs.getInt(1);
	        
	        procOrderData.OrderCounter(processOrder);
	        
	        String sql = "SELECT a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status, COUNT(d.OrderRefNumber), SUM(d.Quantity*d.Price) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "JOIN tblOrderCheckoutData AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled' \n"
	        		+ "GROUP BY a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status";
	        
	        
	        st.execute(sql);
	        rs = st.getResultSet();
	        int panelIndex = 0;
	        while(rs.next()) {
	        	procOrderData.lblRef[panelIndex].setText(rs.getString(1));
	        	procOrderData.lblCustName[panelIndex].setText(rs.getString(3));
	        	procOrderData.lblTotalItem[panelIndex].setText(rs.getString(5));
	        	procOrderData.lblTotalAmount[panelIndex].setText(rs.getString(6));
	        	procOrderData.lblApprovedName[panelIndex].setText("Wala pa");
	        	procOrderData.refNumber[panelIndex] = rs.getString(1);
	        	procOrderData.userID[panelIndex] = rs.getString(2);
	        	procOrderData.orderStatus[panelIndex] = rs.getString(4);
	        	panelIndex++;
	        }
	        
	        procPanelActionList();

			if(refNumber.equals(""))
				procOrder.btnProcessOrder.setEnabled(false);
        } catch(Exception e) {
        	printingError("Error wNav.btnProcessOrder: " + e.getMessage());
        }
	}
	
	private void procPanelFuncSearch(String ref) {
        procOrderData = new ProcessOrderData();
        procOrder.orderListScrollPane.setViewportView(procOrderData);
        
        try {	        
	        String sqlCount = "SELECT COUNT(a.OrderRefNumber) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE (c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled') AND c.OrderRefNumber LIKE '%" + ref + "%';";
	        st.execute(sqlCount);
	        rs = st.getResultSet();
	        if(rs.next())
	        	processOrder = rs.getInt(1);
	        
	        procOrderData.OrderCounter(processOrder);
	        
	        String sql = "SELECT a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status, COUNT(d.OrderRefNumber), SUM(d.Quantity*d.Price) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "JOIN tblOrderCheckoutData AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE (c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled') AND a.OrderRefNumber LIKE '%" + ref + "%' \n"
	        		+ "GROUP BY a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status";
	        
	        
	        st.execute(sql);
	        rs = st.getResultSet();
	        int panelIndex = 0;
	        while(rs.next()) {
	        	procOrderData.lblRef[panelIndex].setText(rs.getString(1));
	        	procOrderData.lblCustName[panelIndex].setText(rs.getString(3));
	        	procOrderData.lblTotalItem[panelIndex].setText(rs.getString(5));
	        	procOrderData.lblTotalAmount[panelIndex].setText(rs.getString(6));
	        	procOrderData.lblApprovedName[panelIndex].setText("Wala pa");
	        	procOrderData.refNumber[panelIndex] = rs.getString(1);
	        	procOrderData.userID[panelIndex] = rs.getString(2);
	        	
	        	panelIndex++;
	        }
	        
	        procPanelActionList();
        } catch(Exception e) {
        	printingError("Error wNav.btnProcessOrder: " + e.getMessage());
        }
	}
	
	private void procPanelFuncCategory(String cat) {
        procOrderData = new ProcessOrderData();
        procOrder.orderListScrollPane.setViewportView(procOrderData);
        
        try {	        
	        String sqlCount = "SELECT COUNT(a.OrderRefNumber) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE (c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled') AND c.status = '" + cat + "';";
	        st.execute(sqlCount);
	        rs = st.getResultSet();
	        if(rs.next())
	        	processOrder = rs.getInt(1);
	        
	        procOrderData.OrderCounter(processOrder);
	        
	        String sql = "SELECT a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status, COUNT(d.OrderRefNumber), SUM(d.Quantity*d.Price) \n"
	        		+ "FROM tblOrderCheckout AS a \n"
	        		+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
	        		+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "JOIN tblOrderCheckoutData AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
	        		+ "WHERE (c.status != 'Completed' AND c.status != 'toShip' AND c.status != 'Expired' AND c.status != 'Cancelled') AND c.status = '" + cat + "' \n"
	        		+ "GROUP BY a.OrderRefNumber, a.UserID, CONCAT(b.FirstName, b.LastName), c.Status";
	        
	        
	        st.execute(sql);
	        rs = st.getResultSet();
	        int panelIndex = 0;
	        while(rs.next()) {
	        	procOrderData.lblRef[panelIndex].setText(rs.getString(1));
	        	procOrderData.lblCustName[panelIndex].setText(rs.getString(3));
	        	procOrderData.lblTotalItem[panelIndex].setText(rs.getString(5));
	        	procOrderData.lblTotalAmount[panelIndex].setText(rs.getString(6));
	        	procOrderData.lblApprovedName[panelIndex].setText("Wala pa");
	        	procOrderData.refNumber[panelIndex] = rs.getString(1);
	        	procOrderData.userID[panelIndex] = rs.getString(2);
	        	procOrderData.orderStatus[panelIndex] = rs.getString(4);
	        	panelIndex++;
	        }
	        
	        procPanelActionList();
        } catch(Exception e) {
        	printingError("Error wNav.btnProcessOrder: " + e.getMessage());
        }
	}
	
	private void procSearchFunc(String search) {
		if(search.equals("Search OrderNumber")) {
			procPanelFunc();
		}
		else {
			procPanelFuncSearch(search);
		}
	}
	
	private void procFilterCategory() {
		procPanelFuncCategory(procOrder.delStatus[procOrder.cbCategory.getSelectedIndex()]);
	}
		
		// PanelOrderList
		private void procPanelActionList() {
			for(int i = 0; i < processOrder; i++) {
				procOrderData.panel[i].addMouseListener(this);
			}
		}
		// PanelOrderData
		private void panelOrderData(String refNumber, String uID) {
			String ref = refNumber;
			String userID = uID;
			procOrder.main.setRowCount(0);
			
			try {
				String sql = "SELECT a.OrderRefNumber, CONCAT(c.LastName, ' ', c.FirstName) AS FullName, a.OrderDate, b.ProductName, b.Quantity, b.Price, (b.Quantity*b.Price) As Total, a.Address, c.Discount \n"
						+ "FROM tblordercheckout AS a \n"
						+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "JOIN tblcustomerinformation AS c ON a.UserID = c.UserID \n"
						+ "WHERE a.OrderRefNumber = '" + ref + "'";
				
				st.execute(sql);
				rs = st.getResultSet();
				
				ArrayList arrTemp = new ArrayList<>();
				
				int totalQuantity = 0;
				
				while(rs.next()) {
					
					// Order Info
					procOrder.lblPONumber.setText(rs.getString(1));
					procOrder.lblMarketingName.setText("Wala pa");
					procOrder.lblCustomerName.setText(rs.getString(2));
					procOrder.lblOrderDate.setText(rs.getDate(3) + "");
					procOrder.lblAddres.setText(rs.getString(8));
					
					arrTemp.add(rs.getString(4)); // Prod Name
					arrTemp.add(rs.getString(5)); // Quantity
					arrTemp.add(rs.getString(6)); // Price
					arrTemp.add(rs.getString(9)); // Discount
					arrTemp.add(rs.getString(7)); // Total Price
					
					totalQuantity += rs.getInt(5);
					
					procOrder.main.addRow(arrTemp.toArray());
					arrTemp.clear();
					
				}
				

//				processPanelIndex
				procOrder.lblItemCount.setText("Item: " + procOrderData.lblTotalItem[processPanelIndex].getText());
				procOrder.lblQuantityCount.setText("Total Quantity: " + totalQuantity);
				procOrder.lblDiscount.setText("Discount: 0");
				procOrder.lblTotalAmount.setText("Total Amount: " + procOrderData.lblTotalAmount[processPanelIndex].getText());
				
			} catch (Exception e) {
				printingError("Error panelOrderData: " + e.getMessage());
			}
			
		}
		
		// Default Panel Color
		private void panelColorProcessOrder() {
			for(int i = 0; i < processOrder; i++) {
				procOrderData.panel[i].setBackground(Color.WHITE);
			}
		}
		// Courier
		private void setCourier(String ref) {
			try {
				ArrayList<String> riderName = new ArrayList<>();
				ArrayList<String> courierID = new ArrayList<>();
				String SQL = "SELECT Username,CourierID FROM tblcourieraccount";
				st.execute(SQL);
				rs = st.getResultSet();
				while(rs.next()) {
					riderName.add(rs.getString(1));
					courierID.add(rs.getString(2));
				}
				onDeliver.courierID = new String[courierID.size()];
				onDeliver.courierID = courierID.toArray(onDeliver.courierID);
				
				onDeliver.cbRiderList.setModel(new DefaultComboBoxModel<String>(riderName.toArray(new String[0])));
				onDeliver.lblRefNumber.setText(ref);
				
				onDeliver.setVisible(true);
				riderName.clear();
			} catch (Exception e) {
				printingError("Error setCourier: " + e.getMessage());
			}
		}
		
		private void setDeliveryStatus() {
			
	        int choice = JOptionPane.showConfirmDialog(
	                null, // Parent component (null for default)
	                "The information is correct?", // Message
	                "Confirmation", // Dialog title
	                JOptionPane.YES_NO_OPTION // Option type
	            );
	        if (choice == JOptionPane.NO_OPTION)
	        	return;
	        
			try {
		        
				String courier = onDeliver.cbRiderList.getSelectedItem() + "";
				String courierID = onDeliver.courierID[onDeliver.cbRiderList.getSelectedIndex()] + "";
				String ref = onDeliver.lblRefNumber.getText();
				String SQL = "INSERT INTO tblcourierdelivery(OrderRefNumber,courierID) VALUES('" + ref + "','" + courierID + "')";
				st.execute(SQL);
				
		        String SQLSelectDelID = "SELECT DeliveryID FROM tblcourierdelivery WHERE OrderRefNumber = '" + ref + "' AND courierID = '" + courierID + "'";
		        
		        st.execute(SQLSelectDelID);
		        rs = st.getResultSet();
		        
		        int dID = 0;
		        
		        if(rs.next()) {
		        	dID = rs.getInt(1);
		        }

		        // Format the date and time
				Date currentDate = new Date();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String formattedDate = dateFormat.format(currentDate);
				
				String SQLDeliveryDate = "INSERT INTO tblcourierdeliverydate(DeliveryID, DeliveryDate) VALUES('" + dID + "','" + formattedDate + "');";
				
				
				st.execute(SQLDeliveryDate);
				String SQLUpdate = "UPDATE tblorderstatus SET Status = 'Delivery' WHERE OrderRefNumber = '" + ref + "'";
				st.executeUpdate(SQLUpdate);
				
				printingError("Delivery Updated!");
				
				onDeliver.dispose();
				
				
			} catch (Exception e) {
				printingError("Error setDeliveryStatus: " + e.getMessage());
			}
			
		}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Navs
		if(e.getSource() == wNav.btnRawMats)
			wNavRawMatsFunc();
			
			// QR Code
			if(e.getSource() == wNav.btnQRCode || e.getSource() == rightClickRawMats.btnQRGen)
				generateQRCode();
		
			// Raw Mats 
			if(e.getSource() == rawMats.rawMatsCategory)
				rawMatsCat();
			if(e.getSource() == rawMats.cbAvailable)
				rawMatsAvailable();

			if(e.getSource() == rawMats.btnSearch)
				rawMatsSearch();
				
				// Raw Mats Right Click
				if(e.getSource() == rightClickRawMats.btnArchive)
					archiveItemFunc();
		
		/// Archive List		
		if(e.getSource() == wNav.btnArchiveList)
			wNavArcListFunc();
		
		// Summary
		if(e.getSource() == wNav.btnSummary)
			summaryFunc();
			
			//Navs
			if(e.getSource() == wNav.btnCompute)
				computeSummary();
			if(e.getSource() == wNav.btnExport)
				btnExportFunc();
			
		// ProcessOrder
		if(e.getSource() == wNav.btnProcessOrder)
			procPanelFunc();
		
			// Process Order Search
			if(e.getSource() == procOrder.btnSearch)
			procSearchFunc(procOrder.txtSearchBar.getText());
			
			// Categories
			if(e.getSource() == procOrder.cbCategory)
			procFilterCategory();
			
			// Set Courier
			if(e.getSource() == procOrder.btnProcessOrder)
				setCourier(refNumber);
				
				// on Deliver = Set Status
				if(e.getSource() == onDeliver.btnConfirm)
					setDeliveryStatus();
		
	}
	
	
	
	//MOUSE
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == rawMats.table) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(rightClickRawMats.isVisible()) {
					rightClickRawMats.setVisible(false);
				}
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				rightClickRawMats.setVisible(true);
				rightClickRawMats.setBounds(e.getX() + 265, e.getY() + 115, 200, 90);
			}
		}
		for(int i = 0; i < processOrder; i++) {
			if(e.getSource() == procOrderData.panel[i]) {
				
				//Design
				panelColorProcessOrder();
				procOrderData.panel[i].setBackground(new Color(131, 255, 165));
				
				// Setting up Data
				processPanelIndex = i;
				refNumber = procOrderData.refNumber[i];
				if(procOrderData.orderStatus[i] != null) {
					if(procOrderData.orderStatus[i].equals("Approved"))
						procOrder.btnProcessOrder.setEnabled(true);
					else
						procOrder.btnProcessOrder.setEnabled(false);
				}
				panelOrderData(procOrderData.refNumber[i], procOrderData.userID[i]);
			}
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
	
	
	// Keyboard

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
