package KBN.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import KBN.Module.Warehouse.AddDataWarehouse;
import KBN.Module.Warehouse.AddItemWarehouse;
import KBN.Module.Warehouse.ArchiveList;
import KBN.Module.Warehouse.ArchiveRightClick;
import KBN.Module.Warehouse.FinishProductTable;
import KBN.Module.Warehouse.FirstInFirstOut;
import KBN.Module.Warehouse.PackingMatsTable;
import KBN.Module.Warehouse.RestoreRightClick;
import KBN.Module.Warehouse.SummaryTable;
import KBN.Module.Warehouse.exportTable;
import KBN.Module.Warehouse.genQRCode;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;

public class WarehouseModule extends JFrame implements ActionListener, PropertyChangeListener, MouseListener, KeyListener{

	

	//class
	private DbConnection dbConn;
	
	//
	private dataSetter dataSet;
	private String accLevel = "";
	
	private AddItemWarehouse addWarehouse;
	private AddDataWarehouse adw;
	private FinishProductTable fpt;
	private PackingMatsTable pmt;
	private FirstInFirstOut fifo;
	private ArchiveList arc;
	private genQRCode genQR;
	private SummaryTable sumTable;
	private exportTable exportT;
	private ArchiveRightClick archiveRC;
	private RestoreRightClick restoreRC;
	
	private String columnDefaultData[];
	private DefaultTableModel main;
	private Statement st;
	private ResultSet rs;
	private Statement st1;
	private ResultSet rs1;
	private ArrayList arrSQLResult;
	private List<String> categoryData;
	private String SortData;
	private DateFormat df;
	private JFileChooser fc;
	
	// Date
	
	private SimpleDateFormat inputFormat;
	private SimpleDateFormat outputFormat;
	
	private JPanel contentPane;
	private JButton btnRawMats;
	private JButton btnPackMats;
	private JButton btnFinishProduct;
	private JLabel lblUsername;
	private JComboBox cbCategories;
	private JTextField txtSearchBar;
	private JButton btnSearch;
	private JPanel tablePanel;
	private JScrollPane scrollPane;
	
	private JTable table;
	private TableRowSorter<TableModel> sorter;
	
	private JButton btnfirstinFirstout;
	private JComboBox cbSort;
	private JButton btnSummary;
	private JButton btnArchiveList;
	private JSeparator separator_2;
	private JDateChooser dateChooser;
	private JComboBox cbArchiveCat;
	private JButton btnRestore;
	private JComboBox cbFIFO;
	private JButton btnItemOut;
	private JButton btnItemIn;
	private JDateChooser dateFrom;
	private JDateChooser dateTo;
	private JButton btnExportSummary;
	private JButton btnCompute;
	

	public WarehouseModule() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Warehouse Inventory");
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);

		dbConn = new DbConnection();
		genQR = new genQRCode();
		exportT = new exportTable();
		archiveRC = new ArchiveRightClick();
		restoreRC = new RestoreRightClick();
		
		
		// Date formatter
        inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		

        //Component
        objComponents();
        
        //class
        fpt = new FinishProductTable();
        fpt.setLocation(0, 0);
		tablePanel.add(fpt);
		pmt = new PackingMatsTable();
		pmt.setLocation(0, 0);
		tablePanel.add(pmt);
		fifo = new FirstInFirstOut();
		fifo.setLocation(0, 0);
		tablePanel.add(fifo);
		df = new SimpleDateFormat("yyyy-MM-dd");
		arc = new ArchiveList();
		tablePanel.add(arc);
		arc.table.addMouseListener(this);
		arc.table.addKeyListener(this);
		sumTable = new SummaryTable();
		tablePanel.add(sumTable);
		

		
        //defaultData
		tableSetup();
        setUsername();
        mouseList();
        buttonList();
        
        tableDisable();
		scrollPane.setVisible(true);
        
        
		tableData();
		tableSorter();
		categoriesSetup();
		
		warehouseButtonsDefault();
		warehouseButtons();
	}
	
	private void warehouseButtonsDefault() {
		
		btnRawMats.setEnabled(false);
		btnPackMats.setEnabled(false);
		btnFinishProduct.setEnabled(false);
		btnfirstinFirstout.setEnabled(false);
		btnArchiveList.setEnabled(false);
		btnSummary.setEnabled(false);
		
//		table.addMouseListener(this);
		archiveRC.btnArchive.setEnabled(false);
		archiveRC.btnAddItem.setEnabled(false);
		archiveRC.btnQRGen.setEnabled(false);
	}
	
	private void warehouseButtons() {
		if(accLevel.equals("Admin--") || accLevel.equals("Admin-Warehouse-All")) {
			
			btnRawMats.setEnabled(true);
			btnPackMats.setEnabled(true);
			btnFinishProduct.setEnabled(true);
			btnfirstinFirstout.setEnabled(true);
			btnArchiveList.setEnabled(true);
			btnSummary.setEnabled(true);
			
			table.addMouseListener(this);
			archiveRC.btnArchive.setEnabled(true);
			archiveRC.btnAddItem.setEnabled(true);
			archiveRC.btnQRGen.setEnabled(true);

		} else if(accLevel.equals("Staff-Warehouse-GenerateQR-Inventory")) {
//			btnQRCode.setEnabled(true);
			
			table.addMouseListener(this);
			archiveRC.btnQRGen.setEnabled(true);
		} else if(accLevel.equals("Staff-Warehouse-First-inFirst-out")) {
			btnfirstinFirstout.setEnabled(true);
		} else {
			warehouseButtonsDefault();
		}
	}
	
	private void objComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 255, 721);
		contentPane.add(panel);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(WarehouseModule.class.getResource("/KBN/resources/kbnlogo.png")));
		lblLogo_1.setBounds(10, 11, 241, 65);
		panel.add(lblLogo_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 87, 241, 13);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 273, 241, 13);
		panel.add(separator_1);
		
		btnRawMats = new JButton("Raw Materials");
		btnRawMats.setBounds(10, 297, 241, 46);
		panel.add(btnRawMats);
		btnRawMats.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRawMats.setFocusable(false);
		btnRawMats.setBorderPainted(false);
		btnRawMats.setBackground(Color.WHITE);
		
		btnPackMats = new JButton("<html><center>Packaging <br/> Materials</center></html>");
		btnPackMats.setBounds(10, 354, 241, 46);
		panel.add(btnPackMats);
		btnPackMats.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnPackMats.setFocusable(false);
		btnPackMats.setBorderPainted(false);
		btnPackMats.setBackground(Color.WHITE);
		
		btnFinishProduct = new JButton("Finish Products");
		btnFinishProduct.setBounds(10, 411, 241, 46);
		btnFinishProduct.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnFinishProduct.setFocusable(false);
		btnFinishProduct.setBorderPainted(false);
		btnFinishProduct.setBackground(Color.WHITE);
		panel.add(btnFinishProduct);
		
		btnfirstinFirstout = new JButton("<html><center>First-In<br/> First-Out</center></html>");
		btnfirstinFirstout.setBounds(10, 468, 241, 46);
		btnfirstinFirstout.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnfirstinFirstout.setFocusable(false);
		btnfirstinFirstout.setBorderPainted(false);
		btnfirstinFirstout.setBackground(Color.WHITE);
		panel.add(btnfirstinFirstout);
		
		btnArchiveList = new JButton("Archive List");
		btnArchiveList.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchiveList.setFocusable(false);
		btnArchiveList.setBorderPainted(false);
		btnArchiveList.setBackground(Color.WHITE);
		btnArchiveList.setBounds(10, 525, 241, 46);
		panel.add(btnArchiveList);
		
		btnSummary = new JButton("Summary");
		btnSummary.setBounds(10, 582, 241, 46);
		panel.add(btnSummary);
		btnSummary.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSummary.setFocusable(false);
		btnSummary.setBorderPainted(false);
		btnSummary.setBackground(Color.WHITE);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 646, 241, 13);
		panel.add(separator_2);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setBounds(10, 670, 241, 40);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		String archiveCat[] = {"Archive Categories", "Raw Materials", "Packing Materials", "Finish Products"};
		cbArchiveCat = new JComboBox(archiveCat);
		cbArchiveCat.setBounds(10, 159, 241, 46);
		cbArchiveCat.setVisible(false);
		panel.add(cbArchiveCat);
		
		btnRestore = new JButton("Restore");
		btnRestore.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRestore.setFocusable(false);
		btnRestore.setBorderPainted(false);
		btnRestore.setBackground(Color.WHITE);
		btnRestore.setBounds(10, 102, 241, 46);
		btnRestore.setVisible(false);
		panel.add(btnRestore);
		
		String fifo[] = {"FIFO Categories" , "Raw Materials", "Packing Materials", "Finished Products"};
		cbFIFO = new JComboBox(fifo);
		cbFIFO.setBounds(10, 216, 241, 46);
		panel.add(cbFIFO);
		
		btnItemOut = new JButton("Item Out");
		btnItemOut.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnItemOut.setFocusable(false);
		btnItemOut.setBorderPainted(false);
		btnItemOut.setBackground(Color.WHITE);
		btnItemOut.setBounds(10, 159, 241, 46);
		panel.add(btnItemOut);
		
		btnItemIn = new JButton("Item In");
		btnItemIn.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnItemIn.setFocusable(false);
		btnItemIn.setBorderPainted(false);
		btnItemIn.setBackground(Color.WHITE);
		btnItemIn.setBounds(10, 102, 241, 46);
		panel.add(btnItemIn);
		
		dateFrom = new JDateChooser();
		dateFrom.setBounds(10, 146, 241, 33);
		panel.add(dateFrom);
		
		dateTo = new JDateChooser();
		dateTo.setBounds(10, 190, 241, 33);
		panel.add(dateTo);
		
		btnExportSummary = new JButton("Export Summary");
		btnExportSummary.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnExportSummary.setFocusable(false);
		btnExportSummary.setBorderPainted(false);
		btnExportSummary.setBackground(Color.WHITE);
		btnExportSummary.setBounds(10, 102, 241, 33);
		panel.add(btnExportSummary);
		

		dateFrom.setVisible(false);
		dateTo.setVisible(false);
		btnExportSummary.setVisible(false);
		
		btnCompute = new JButton("Compute Data");
		btnCompute.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompute.setFocusable(false);
		btnCompute.setBorderPainted(false);
		btnCompute.setBackground(Color.WHITE);
		btnCompute.setBounds(10, 229, 241, 33);
		btnCompute.setVisible(false);
		panel.add(btnCompute);
		
		dateFrom.setVisible(false);
		dateTo.setVisible(false);
		btnExportSummary.setVisible(false);
		
		btnItemOut.setVisible(false);
		btnItemIn.setVisible(false);
		cbFIFO.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(259, 0, 1005, 163);
		contentPane.add(panel_1);

		String sort[] = {"Sort (Default)", "DATE", "CATEGORIES"};
		cbSort = new JComboBox(sort);
		cbSort.setBounds(10, 100, 200, 46);
		cbSort.setFocusable(false);
		cbSort.setOpaque(false);
		panel_1.add(cbSort);
		
		cbCategories = new JComboBox();
		cbCategories.setOpaque(false);
		cbCategories.setFocusable(false);
		cbCategories.setBounds(220, 100, 200, 46);
		cbCategories.setVisible(true);
		panel_1.add(cbCategories);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(WarehouseModule.class.getResource("/KBN/resources/searchIcon.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(251, 11, 39, 33);
		btnSearch.setOpaque(false);
		panel_1.add(btnSearch);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(10, 11, 280, 33);
		panel_1.add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(302, 11, 161, 33);
		dateChooser.addPropertyChangeListener("date", this);
		panel_1.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(557, 11, 240, 134);
		panel_1.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(807, 11, 188, 134);
		panel_1.add(panel_2_1);
		
		archiveRC.setVisible(false);
		contentPane.add(archiveRC);
		
		restoreRC.setVisible(false);
		contentPane.add(restoreRC);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(259, 174, 1005, 547);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1005, 547);
		tablePanel.add(scrollPane);
		
		table = new JTable();
//		table.addMouseListener(this);
		table.addKeyListener(this);
		scrollPane.setViewportView(table);
	}
	
	private void mouseList() {
		btnRawMats.addMouseListener(this);
		btnPackMats.addMouseListener(this);
		btnFinishProduct.addMouseListener(this);
		btnfirstinFirstout.addMouseListener(this);
		btnArchiveList.addMouseListener(this);
		btnSummary.addMouseListener(this);
	}
	
	private void buttonList() {
		btnRawMats.addActionListener(this);
		btnFinishProduct.addActionListener(this);
		btnPackMats.addActionListener(this);
		btnfirstinFirstout.addActionListener(this);
		btnArchiveList.addActionListener(this);
		btnSummary.addActionListener(this);
		btnRestore.addActionListener(this);
		btnExportSummary.addActionListener(this);
		btnCompute.addActionListener(this);
		cbSort.addActionListener(this);
		cbCategories.addActionListener(this);
		btnSearch.addActionListener(this);
		
		// Class Archive Right Click
		archiveRC.btnArchive.addActionListener(this);
		archiveRC.btnAddItem.addActionListener(this);
		archiveRC.btnQRGen.addActionListener(this);
		
		// Class Restore Right Click
		restoreRC.btnRestore.addActionListener(this);
	}
	
	
	private void setUsername() {
		dataSet = new dataSetter();
		accLevel = dataSet.getAccLevel();
		lblUsername.setText(dataSet.getUsername());
	}
	
	private void tableData() {
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth";
		printingTableData(sql);
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME","DATE", "CURRENT VOLUME", "APPEARANCE", "RELEASED", "REJECT", "HOLD", "PROD RETURN"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		for(int i = 0; i < 4; i++) {
			if(i == 2) {
				continue;
			}else {
				table.getColumnModel().getColumn(i).setMinWidth(0);
				table.getColumnModel().getColumn(i).setMaxWidth(0);
				table.getColumnModel().getColumn(i).setWidth(0);
			}
		}
	}
	
	private void tableSorter() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		sorter = new TableRowSorter<>(main);
	    sorter.setComparator(2, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	        }
	    });

	    sorter.setComparator(4, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            try {
	                Date date1 = dateFormat.parse(s1);
	                Date date2 = dateFormat.parse(s2);
	                return date1.compareTo(date2);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                return 0;
	            }
	        }
	    });

	    sorter.setComparator(5, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	        }
	    });
	    
	    sorter.setComparator(6, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	        }
	    });
	    
	    sorter.setComparator(7, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(8, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(9, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(10, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    
		table.setRowSorter(sorter);
	    table.getTableHeader().addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            int columnIndex = table.columnAtPoint(e.getPoint());
	            sorter.toggleSortOrder(columnIndex);
	        }
	    });
	}
	
	private void addItem() {
		addWarehouse = new AddItemWarehouse();
		addWarehouse.setVisible(true);
	}

	//categories
	private void disableCat() {
		cbCategories.setVisible(false);
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
			cbCategories.setModel(new DefaultComboBoxModel<String>(categoryData.toArray(new String[0])));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Categories \n" + e.getMessage());
		}
	}
	
	private void tableDisable() {
		fpt.setVisible(false);
		scrollPane.setVisible(false);
		pmt.setVisible(false);
		fifo.setVisible(false);
		arc.setVisible(false);
		sumTable.setVisible(false);
	}
	
	private void buttonVisible() {
		
		//btnFIFO
		cbFIFO.setVisible(false);
		btnItemIn.setVisible(false);
		btnItemOut.setVisible(false);
		
		//btnArchive
		btnRestore.setVisible(false);
		cbArchiveCat.setVisible(false);
		
		dateFrom.setVisible(false);
		dateTo.setVisible(false);
		btnExportSummary.setVisible(false);
		btnCompute.setVisible(false);
		
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource() == dateChooser) {
			String date = df.format(dateChooser.getDate());
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE DATE_TODAY = '" + date + "';";
			printingTableData(sql);
			System.out.println(sql);
		}
		
	}
	
	
	//function
	private void rawMatsFunction() {
		setTitle("Warehouse Inventory");
		fpt.setVisible(false);
		scrollPane.setVisible(true);
		tableData();

	}
	
	private void FinishProductFunc() {
		setTitle("Warehouse Inventory - Finish Product");
		tableDisable();
		fpt.setVisible(true);
		disableCat();
	}
	
	private void PackingMatsFunc() {
		setTitle("Warehouse Inventory - Packing Materials");
		tableDisable();
		pmt.setVisible(true);
		disableCat();
		
	}
	
	private void FirstInFunc() {
		setTitle("Warehouse Inventory - First In First Out");
		tableDisable();
		fifo.setVisible(true);
		disableCat();
	}
	
	private void sumTableFunc() {
		setTitle("Warehouse Inventory - Summary");
		tableDisable();
		sumTable.setVisible(true);
	}
	
	private void sortingFunc() {
		if(cbSort.getSelectedItem().equals("Sort (Default)")) {
			
		}else if(cbSort.getSelectedItem().equals("DATE")) {
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth ORDER BY DATE_TODAY";
			printingTableData(sql);
			SortData = cbSort.getSelectedItem() + "";
		}else if(cbSort.getSelectedItem().equals("CATEGORIES")){
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth ORDER BY CATEGORIES";
			printingTableData(sql);
			SortData = cbSort.getSelectedItem() + "";
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR: SOMETHING WRONG");
		}
	}
	
	private void searchFunc() {
		String searchData = txtSearchBar.getText();
		String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE APPEARANCE = '" + searchData + "' OR CATEGORIES = '" + searchData + "'";
		printingTableData(sql);
	}
	
	private void printingTableData(String sql) {
		main.setRowCount(0);
		revalidate();
		arrSQLResult = new ArrayList<>();
		try {

			st = dbConn.getConnection().createStatement();
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				arrSQLResult.add(rs.getString(1));
				arrSQLResult.add(rs.getString(2));
				arrSQLResult.add(rs.getString(3));
				arrSQLResult.add(rs.getString(4));
				
				//Date
	            Date date = inputFormat.parse(rs.getString(5));
	            String outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				// END OF DATE
				
				arrSQLResult.add(rs.getString(6));
				arrSQLResult.add(rs.getString(7));
				arrSQLResult.add(rs.getString(8));
				arrSQLResult.add(rs.getString(9));
				main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
//			table.setModel(main);
		}catch (Exception e) {
			//Debugger
			JOptionPane.showMessageDialog(null, "Table ERROR: \n" + e.getMessage());
		}
	}

	

	
	
	//button archive
	private void archiveItemFunc() {
		
		int[] selectedRows = table.getSelectedRows();

		int dia = JOptionPane.showConfirmDialog(null, "You want to Archive the selected item?", "Confirmation", JOptionPane.YES_NO_OPTION);

		if (dia == JOptionPane.YES_OPTION) {
			for (int i = 0; i < selectedRows.length; i++) {
				//"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME","DATE", "CURRENT VOLUME", "APPEARANCE", "RELEASED", "REJECT", "HOLD", "PROD RETURN"
				String todayReleased = table.getValueAt(selectedRows[i], 7) + "";
				String MatsName = table.getValueAt(selectedRows[i], 2) + "";
				String CodeName = table.getValueAt(selectedRows[i], 3) + "";
				String Supplier = table.getValueAt(selectedRows[i], 1) + "";
				String dateToday1 = table.getValueAt(selectedRows[i], 4) + "";
				String itemID = table.getValueAt(table.getSelectedRow(), 0) + "";

				String userName = lblUsername.getText();
				Date date = new Date();
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String dateToday = formatter.format(date);
			    
				String sqlInsert = "INSERT INTO tblcurrentmonth_archive \n"
						+ "SELECT * \n"
						+ "FROM tblcurrentmonth \n"
						+ "WHERE itemID = '" + itemID + "';";
				String sqlInsert2 =  "INSERT INTO tblArchiveUser VALUES('" + itemID + "','" + userName + "',NOW());";
				
				
				String sqlUpdate = "UPDATE tblcurrentmonth"
						+ " SET todayCurrentVolume = todayCurrentVolume + " + todayReleased 
						+ " WHERE MATERIAL_NAME = '" + MatsName + "' AND CODE_NAME = '" + CodeName + "' AND SUPPLIER = '" + Supplier + "' AND DATE_TODAY >= '" + dateToday1 + "'";
				
				System.out.println(sqlInsert);
				
				archiveInsert(sqlInsert);
				
				archiveInsert(sqlInsert2);
				
				
				String sqlDelete = "DELETE FROM tblcurrentmonth WHERE itemID = '" + itemID + "';";
				archiveDelete(sqlDelete);

				updateTableData(sqlUpdate);
				
				main.removeRow(selectedRows[i]);
				table.setModel(main);
			}

			JOptionPane.showMessageDialog(null, "Item added to Archive");
			archiveRC.setVisible(false);
		} else {
			//cancel
		}
	}
	
	private void updateTableData(String sql) {
		try {
			st.execute(sql);
		} catch (Exception e) {
			System.out.println("ERROR Update: " + e.getMessage());
		}
	}
	
	private void archiveInsert(String sql) {
		try {
			
			int i = st.executeUpdate(sql);
			if(i == 1) {
				System.out.println("Added");
			}else {
				System.out.println("INSERT : Something wrong");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}
	}
	private void archiveDelete(String sql) {
		try {

			int i = st.executeUpdate(sql);
//			if(i != 0) {
//				JOptionPane.showMessageDialog(null, "Item " + message);
//			}else {
//				JOptionPane.showMessageDialog(null, "DELETE: SOMETHING WRONG");
//			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}
	}
	
	//table archive
	private void ArchiveListFunc() {
		setTitle("Warehouse Inventory - Archive List");
		tableDisable();
		arc.setVisible(true);
//		"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME", "RELEASED VOLUME", "PRODUCT DATE","USER - Archive", "ARCHIVE DATE"
		String sql = "SELECT a.itemID, a.SUPPLIER, a.MATERIAL_NAME, a.CODE_NAME, a.RELEASED_VOLUME, a.DATE_TODAY, tblarchiveuser.userAccount, tblarchiveuser.ArchiveDate FROM tblcurrentmonth_archive AS a INNER JOIN tblarchiveuser ON a.itemID = tblarchiveuser.itemID";
		printingArchiveList(sql);
	}
	
	private void printingArchiveList(String sql) {
		arc.main.getDataVector().removeAllElements();
		arc.revalidate();
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
	            Date date = inputFormat.parse(rs.getString(6));
	            String outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				
				arrSQLResult.add(rs.getString(7));
				
//				//Date
				date = inputFormat.parse(rs.getString(8));
				outputDate = outputFormat.format(date);
				arrSQLResult.add(outputDate);
				
				arc.main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
			arc.table.setModel(arc.main);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Table ERROR: \n" + e.getMessage());
		}
	}
	
	
	private void restoreItemFunc() {
		
		int[] selectedRows = arc.table.getSelectedRows();
		
		int dia = JOptionPane.showConfirmDialog(null, "You want to Restore the selected item?", "Confirmation", JOptionPane.YES_NO_OPTION);
		
		if (dia == JOptionPane.YES_OPTION) {
			for (int i = 0; i < selectedRows.length; i++) {
				
				String Supplier = arc.table.getValueAt(selectedRows[i], 1) + "";
				String MatsName = arc.table.getValueAt(selectedRows[i], 2) + "";
				String CodeName = arc.table.getValueAt(selectedRows[i], 3) + "";
				String todayReleased = arc.table.getValueAt(selectedRows[i], 4) + "";
				String dateToday1 = arc.table.getValueAt(selectedRows[i], 5) + "";
	
	
					
					String itemID = arc.table.getValueAt(selectedRows[i], 0) + "";
					
					String sqlInsert = "INSERT INTO tblcurrentmonth "
							+ "SELECT * "
							+ "FROM tblcurrentmonth_archive "
							+ "WHERE itemID = '" + itemID + "'";
	//				System.out.println("INSERT: " + sqlInsert);
					
					String sqlDelete = "DELETE tblcurrentmonth_archive, tblarchiveuser "
							+ "FROM tblcurrentmonth_archive "
							+ "INNER JOIN tblarchiveuser ON tblcurrentmonth_archive.itemID = tblarchiveuser.itemID "
							+ "WHERE tblcurrentmonth_archive.itemID = '" + itemID + "';";
	
	//				"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME", "RELEASED VOLUME", "PRODUCT DATE", "USER - Archive", "ARCHIVE DATE"
	
	
					
					
					String sqlUpdate = "UPDATE tblcurrentmonth"
							+ " SET todayCurrentVolume = todayCurrentVolume - " + todayReleased 
							+ " WHERE MATERIAL_NAME = '" + MatsName + "' AND CODE_NAME = '" + CodeName + "' AND SUPPLIER = '" + Supplier + "' AND DATE_TODAY > '" + dateToday1 + "'";
	
					archiveInsert(sqlInsert);
					archiveDelete(sqlDelete);
					
					updateTableData(sqlUpdate);
					
					arc.main.removeRow(selectedRows[i]);
					arc.table.setModel(arc.main);
					
	
			}
		} else {
			//cancel
		}
	}
	
	private void qrcodeFunc() {			
		
//		{"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME","DATE", "CURRENT VOLUME", "APPEARANCE", "RELEASED", "REJECT", "HOLD", "PROD RETURN"};

		
		String MN = table.getValueAt(table.getSelectedRow(), 2) + "";
		String CN = table.getValueAt(table.getSelectedRow(), 3) + "";
		String S = table.getValueAt(table.getSelectedRow(), 1) + "";
		String itemDate = table.getValueAt(table.getSelectedRow(), 4) + "";
		String Volume = table.getValueAt(table.getSelectedRow(), 5) + "";
		
		String QRCodeName = MN + " " + itemDate +".png";
		String url = "localhost/KBNTHESIS/?MN=" + MN + "&CN=" + CN + "&S=" + S + "&date=" + itemDate+"&tv=" + Volume;
		try {
			genQR.gettingURL(url, QRCodeName);
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR QRCODE: " + e1.getMessage());
		}
		
	}
	
	private void computeSummary() {
//		END OF DATE - TOTAL USED

		sumTable.table.removeAll();
		
//		String sql = "SELECT MATERIAL_NAME,CODE_NAME, CONTROL_NUMBER, SUPPLIER FROM tblmonthlysummary WHERE CATEGORIES = '" + cbCategories.getSelectedItem() +"'";
		String dateFrom1 = df.format(dateFrom.getDate());
		String dateTo1 = df.format(dateTo.getDate());
		
//		String sql = "SELECT MATERIAL_NAME, CODE_NAME, SUPPLIER, SUM(RELEASED_VOLUME) FROM tblcurrentmonth WHERE CATEGORIES = '" + cbCategories.getSelectedItem() + "' AND DATE_TODAY >= '" + dateFrom1 + "' AND DATE_TODAY <= '" + dateTo1 + "' GROUP BY MATERIAL_NAME HAVING SUM(RELEASED_VOLUME) > 0";
		String sql = "SELECT a.MATERIAL_NAME, a.CODE_NAME, b.CONTROL_NUMBER, a.SUPPLIER, SUM(a.RELEASED_VOLUME) FROM tblcurrentmonth AS a LEFT JOIN tblmonthlysummary AS b ON a.MATERIAL_NAME = b.MATERIAL_NAME AND a.CODE_NAME = b.CODE_NAME AND a.SUPPLIER = b.SUPPLIER WHERE a.CATEGORIES = '" + cbCategories.getSelectedItem() + "' AND a.DATE_TODAY >= '" + dateFrom1 + "' AND a.DATE_TODAY <= '" + dateTo1 + "' GROUP BY a.MATERIAL_NAME HAVING SUM(a.RELEASED_VOLUME) > 0";
		System.out.println(sql);
		sumTable.main.getDataVector().removeAllElements();
		sumTable.revalidate();
		try {
			st = dbConn.getConnection().createStatement();
			st1 = dbConn.getConnection().createStatement();
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				arrSQLResult.add(rs.getString(1));
				arrSQLResult.add(rs.getString(2));
				arrSQLResult.add(rs.getString(3));
				arrSQLResult.add(rs.getString(4));
				arrSQLResult.add(rs.getString(5));
				sumTable.main.addRow(arrSQLResult.toArray());
				arrSQLResult.clear();
			}
			sumTable.table.setModel(sumTable.main);
			
//			for(int i = 0; i < sumTable.table.getRowCount(); i++) {
//				
//				String matsName = sumTable.table.getValueAt(1, 0) + "";
//				String codeName = sumTable.table.getValueAt(1, 1) + "";
//				String Supplier = sumTable.table.getValueAt(1, 3) + "";
//				String sql1 = "SELECT CONTROL_NUMBER FROM tblmonthlysummary WHERE MATERIAL_NAME = '" + matsName + "' AND CODE_NAME = '" + codeName + "' AND SUPPLIER = '" + Supplier + "'";
//				System.out.println(sql1);
//
//				st1.execute(sql1);
//				rs1 = st1.getResultSet();
//				while(rs1.next()) {
//					sumTable.table.setValueAt(rs1.getString(1), i, 2);
//				}
//			}			
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
			exportT.toExcel(sumTable.table, new File(file));
		}
        
	}
	
	private void disableRightclick() {
		archiveRC.setVisible(false);
		restoreRC.setVisible(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == table) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(archiveRC.isVisible()) {
					archiveRC.setVisible(false);
				}
			}
			else if(e.getButton() == MouseEvent.BUTTON3) {
				archiveRC.setVisible(true);
				archiveRC.setBounds(e.getX() + 266, e.getY() + 176, 200, 90);
			}
		}
		
		if(e.getSource() == arc.table) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				System.out.println("test");
				restoreRC.setVisible(true);
				restoreRC.setBounds(e.getX() + 266, e.getY() + 176, 120, 30);
//				restoreRC.setAlignmentX(e.getX());
//				restoreRC.setAlignmentY(e.getY());
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
		
		if(e.getComponent() instanceof JButton) {
			Component c = e.getComponent();
			((JButton)c).setIcon(new ImageIcon(WarehouseModule.class.getResource("/KBN/resources/warehouse/warehouseButton.png")));
			((JButton)c).setHorizontalTextPosition(JLabel.CENTER);
			((JButton)c).setVerticalTextPosition(JLabel.CENTER);
		}
		else
			return;
		
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if(e.getComponent() instanceof JButton) {
			Component c = e.getComponent();
			((JButton)c).setIcon(null);
			((JButton)c).setBackground(Color.white);
		}
		
		else
			return;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 27) {
			disableRightclick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRawMats) {
			
			rawMatsFunction();
			
		}else if(e.getSource() == archiveRC.btnAddItem) {
			
			addItem();
			
		}else if(e.getSource() == btnFinishProduct) {
			
			FinishProductFunc();
			
		}else if(e.getSource() == btnPackMats) {
			
			PackingMatsFunc();
			
		}else if(e.getSource() == btnfirstinFirstout) {
			
			FirstInFunc();
			
		}else if(e.getSource() == cbCategories) {
			
			String sql = "SELECT itemID, SUPPLIER, MATERIAL_NAME, CODE_NAME, DATE_TODAY, todayCurrentVolume, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN FROM tblcurrentmonth WHERE CATEGORIES = '" + cbCategories.getSelectedItem() + "'";
			printingTableData(sql);
			
		}else if(e.getSource() == btnSearch) {
			
			searchFunc();
			
		}else if(e.getSource() == cbSort) {
			
			sortingFunc();
			
		}else if(e.getSource() == btnArchiveList) {
			
			ArchiveListFunc();
			disableRightclick();
			
		}else if(e.getSource() == archiveRC.btnArchive) {
			
			archiveItemFunc();
			
		}else if(e.getSource() == restoreRC.btnRestore) {
			
			restoreItemFunc();
			
		}else if(e.getSource() == archiveRC.btnQRGen) {
			
			qrcodeFunc();
			disableRightclick();
			
		}else if(e.getSource() == btnSummary) {
			
			sumTableFunc();
			disableRightclick();
			
		}else if(e.getSource() == btnCompute) {
			
			computeSummary();
			
		}else if(e.getSource() == btnExportSummary) {
			
			btnExportFunc();
			
		}
		
		
		
		
		if(this.getTitle().equals("Warehouse Inventory")) {
			cbCategories.setVisible(true);
		}else {
			cbCategories.setVisible(false);
		}
		
		
		buttonVisible();
		
		if(this.getTitle().equals("Warehouse Inventory - Archive List")){
			cbArchiveCat.setVisible(true);
			btnRestore.setVisible(true);
		}else if(this.getTitle().equals("Warehouse Inventory")) {
			
		}else if(this.getTitle().equals("Warehouse Inventory - First In First Out")) {
			cbFIFO.setVisible(true);
			btnItemIn.setVisible(true);
			btnItemOut.setVisible(true);
		}else if(this.getTitle().equals("Warehouse Inventory - Summary")) {
			dateFrom.setVisible(true);
			dateTo.setVisible(true);
			btnExportSummary.setVisible(true);
			btnCompute.setVisible(true);
			cbCategories.setVisible(true);
		}
	}

}
