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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.Module.Warehouse.RawMatsList.ArchiveRightClick;
import KBN.Module.Warehouse.RawMatsList.RawMaterials;
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
	private DbConnection dbConn;
	
	// Account
	private dataSetter dataSet;
	private String accLevel = "";
	
	//SQL
	Statement st;
	ResultSet rs;
	
	// Date
	private Date date;
	private SimpleDateFormat inputFormat;
	private SimpleDateFormat outputFormat;
	
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
        
        // Class Declaration
        wNav = new WarehouseNav();
        rawMats = new RawMaterials();
        dbConn = new DbConnection();
        try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			printingError("Statement ERROR: " + e.getMessage());
		}
        
        // Nav Panel
        panelNav.add(wNav);
        
        
        // Container Panel
        container.add(rawMats);//Raw Mats
        
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
		
		
	}
	
	private void panelVisible() {
		rawMats.setVisible(false);
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Categories \n" + e.getMessage());
		}
	}

	
	// Raw Materials
	private void rawMatsTable(String sql) {
		rawMats.main.setRowCount(0);
		revalidate();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Navs
		if(e.getSource() == wNav.btnRawMats) {
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth";
			rawMatsTable(sql);
	        panelVisible();
	        rawMats.setVisible(true);
		}
		
		
		// Raw Mats 
		if(e.getSource() == rawMats.rawMatsCategory) {
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE CATEGORIES = '" + rawMats.rawMatsCategory.getSelectedItem() + "'";
			rawMatsTable(sql);
		}
		if(e.getSource() == rawMats.btnSearch) {
			String MaterialName = "";
			if(rawMats.txtSearchBar.getText().equals("Search by Material Name"))
				MaterialName = "";
			else
				MaterialName = rawMats.txtSearchBar.getText();
			
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE MATERIAL_NAME LIKE '%" + MaterialName + "%'";
			rawMatsTable(sql);
		}
		
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
