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
import KBN.Module.Warehouse.RawMatsList.ArchiveRightClick;
import KBN.Module.Warehouse.RawMatsList.RawMaterials;
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
	
	//Array
	private ArrayList arrSQLResult;
	private List<String> categoryData;
	
	
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
        

        
        // Nav Panel
        panelNav.add(wNav);
        
        // Container Panel
        container.add(rawMats); //Raw Mats
        container.add(arcList); //Archive
        container.add(summary);
        
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
	}
	
	private void panelVisible() {
		rawMats.setVisible(false);
		arcList.setVisible(false);
		summary.setVisible(false);
		
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
		wNav.btnAddItem.setText("Add Item");
        panelVisible();
		wNav.btnAddItem.setVisible(true);
		wNav.btnQRCode.setVisible(true);
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth";
		rawMatsTable(sql);
        rawMats.setVisible(true);
	}
	
	// Archive List Panel
	private void wNavArcListFunc() {
        panelVisible();
		wNav.btnAddItem.setText("Restore");
        arcList.setVisible(true);
		String sql = "SELECT a.itemID, a.SUPPLIER, a.MATERIAL_NAME, a.CODE_NAME, a.RELEASED_VOLUME, a.DATE_TODAY, tblarchiveuser.userAccount, tblarchiveuser.ArchiveDate FROM tblcurrentmonth_archive AS a INNER JOIN tblarchiveuser ON a.itemID = tblarchiveuser.itemID";
		printingArchiveList(sql);
	}
	
	
	// Search
	private void rawMatsCat() {
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE CATEGORIES = '" + rawMats.rawMatsCategory.getSelectedItem() + "'";
		rawMatsTable(sql);
	}
	
	private void rawMatsSearch() {
		String MaterialName = "";
		if(rawMats.txtSearchBar.getText().equals("Search by Material Name"))
			MaterialName = "";
		else
			MaterialName = rawMats.txtSearchBar.getText();
		
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE MATERIAL_NAME LIKE '%" + MaterialName + "%'";
		rawMatsTable(sql);
	}
	
	// Archive RightClick
	// button archive
	private void archiveItemFunc() {
		
		int[] selectedRows = rawMats.table.getSelectedRows();
		System.out.println(selectedRows.length);

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
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Navs
		if(e.getSource() == wNav.btnRawMats)
			wNavRawMatsFunc();
		
			// Raw Mats 
			if(e.getSource() == rawMats.rawMatsCategory)
				rawMatsCat();
			if(e.getSource() == rawMats.btnSearch)
				rawMatsSearch();
				
				// Raw Mats Right Click
				if(e.getSource() == rightClickRawMats.btnArchive)
					archiveItemFunc();
			
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
