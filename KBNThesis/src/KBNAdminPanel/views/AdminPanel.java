package KBNAdminPanel.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import KBNAdminPanel.commons.dataSetter;
import KBNAdminPanel.commons.DbConnection;
import KBNAdminPanel.panels.GraphTest;
import KBNAdminPanel.panels.Navs;
import KBNAdminPanel.panels.AuditTrail.AuditTrail;
import KBNAdminPanel.panels.Courier.CourierCreateAccount;
import KBNAdminPanel.panels.Courier.CourierPanel;
import KBNAdminPanel.panels.Courier.RightClick;
import KBNAdminPanel.panels.Employee.EmployeeCreate;
import KBNAdminPanel.panels.Employee.EmployeeList;
import KBNAdminPanel.panels.Employee.EmployeeListGenerator;
import KBNAdminPanel.panels.Employee.EmployeePanel;
import KBNAdminPanel.panels.Forecast.ForecastGraphs;
import KBNAdminPanel.panels.Forecast.ForecastingPanel;
import KBNAdminPanel.panels.Forecast.barGen;
import KBNAdminPanel.panels.ForecastGraph.ForecastPanel;
import KBNAdminPanel.panels.Price.ProductPrice;
import KBNAdminPanel.panels.SalesReport.SalesReportPanel;
import KBNAdminPanel.panels.dashboard.Dashboard;
import KBNAdminPanel.panels.dashboard.DashboardSalesChartData;
import KBNAdminPanel.panels.dashboard.OrderListPanelData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminPanel extends JFrame implements ActionListener , ItemListener, MouseListener, KeyListener{
	
	private dataSetter dataSet;
	
	//Class
	private Navs navs;
	private SalesReportPanel salesPanel;
	
	//Forecast Class
	private ForecastingPanel forecast;
	private ForecastGraphs forecastgraph;
	private barGen bar1;
	private barGen bar2;
	
	private AuditTrail auditTrail;
	
	//Price
	private ProductPrice prodPrice;
	
	//Forecast
	private ForecastPanel forecastPanel;
	private GraphTest graphTest;
	
	// Employee
	private EmployeePanel empPanel;
	private EmployeeList empList;
	private EmployeeListGenerator empGen;
	private EmployeeCreate empCreate;
	private String verifyEmployeeRegister = "Not Verified";
	
	private int empCount = 0;
	
	private boolean EmpCreateCheck;
	private String accoudIdEmpUpdate = "";
	private boolean isUpdateEmpInfo = false;
	
	private JButton btnChecker;
	
	// Courier
	private CourierPanel courierPanel;
	private RightClick courierRightClick;
	private CourierCreateAccount courierCreate;
	
	// Dashboard
	private Dashboard dashboard1;
	private DashboardSalesChartData dashChartData;
	private OrderListPanelData opdDashboard;
	private LocalDate today;
	
	
	// Dashboard
	private int OrderCountDash = 0; // Order List
	private String sqlTimeDiff;
	
	//Database
	private DbConnection dbConn;
	private ResultSet rs;
	private Statement st;
	
	//Array
	private ArrayList products;
	
	//Date
	private LocalDate currentDate;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel container;

	public AdminPanel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);

		
        // Class
        navs = new Navs();
        salesPanel = new SalesReportPanel();
        
        // Dashboard
        dashboard1 = new Dashboard();
        opdDashboard = new OrderListPanelData();
        today = LocalDate.now();
        
        sqlTimeDiff = "SELECT TIMESTAMPDIFF(HOUR, NOW(), a.OrderDate) AS HoursDifference, TIMESTAMPDIFF(MINUTE, a.OrderDate, NOW()) AS MinutesDifference\r\n"
        		+ "FROM tblordercheckout AS a\r\n"
        		+ "JOIN tblorderstatus As b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
        		+ "WHERE b.Status = 'toPay'\r\n"
        		+ "ORDER BY OrderDate DESC LIMIT 1;";
        
        setUsername();
        
        // Forecast
        forecast = new ForecastingPanel();
        forecastgraph = new ForecastGraphs();
        bar1 = new barGen();
        bar2 = new barGen();
        
        auditTrail = new AuditTrail();
        
        // Forecast New
        forecastPanel = new ForecastPanel();
        
        //Employee
        empPanel = new EmployeePanel();
        empList = new EmployeeList();
        empCreate = new EmployeeCreate();
        
        courierPanel = new CourierPanel();
        courierRightClick = new RightClick();
        courierCreate = new CourierCreateAccount();
        
        
        
        // Database
        dbConn = new DbConnection();
        try {
			st = dbConn.getConnection().createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(navs, "ERROR Statement: " + e.getMessage());
		}
        
        // Array
        products = new ArrayList<>();
        
        // Date
		currentDate = LocalDate.now();

        contentPane.add(courierRightClick);
        courierRightClick.setVisible(false);
        
        // Components
		components();
		
        actList();
        
		panel.add(navs);
		
		panelVisible();
		
		//Container
		container.add(salesPanel);
		container.add(forecast);
		container.add(forecastPanel);
		container.add(empPanel);
		container.add(empCreate);
		container.add(courierPanel);
		container.add(dashboard1);
			dashboard1.orderList.setViewportView(opdDashboard);
		container.add(auditTrail);
		
		empPanel.container.add(empList);
		
		forecast.graph.add(forecastgraph);
		forecastgraph.graph1.add(bar1);
		forecastgraph.graph2.add(bar2);
		

		dashboard1();
		dashboard1.setVisible(true);
		
		btnChecker = navs.btnDashboard;
	}
	
	private void panelVisible() {
		dashboard1.setVisible(false);
		salesPanel.setVisible(false);
		forecast.setVisible(false);
		empPanel.setVisible(false);
		empCreate.setVisible(false);
		courierPanel.setVisible(false);
		forecastPanel.setVisible(false);
		auditTrail.setVisible(false);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		navs.lblUsername.setText(dataSet.getUsername());
	}
	
	private void actList() {
		navs.btnDashboard.addActionListener(this);
		navs.btnSalesReport.addActionListener(this);
		navs.btnAudit.addActionListener(this);
		navs.btnForecasting.addActionListener(this);
		navs.btnEmployeeList.addActionListener(this);
		navs.btnListOfCourier.addActionListener(this);
		navs.btnProductPrice.addActionListener(this);
		
		// Mouse Right Click
		courierPanel.table.addMouseListener(this);
		// Courier Right Click
		courierRightClick.btnEdit.addActionListener(this);
		courierRightClick.btnView.addActionListener(this);
		
		// Sales Report
		salesPanel.btnPrint.addActionListener(this);
		
		
		// Key Listener
		courierPanel.table.addKeyListener(this);
		
		courierPanel.btnCreate.addActionListener(this);
		
		//Forecast
		forecast.product1.addItemListener(this);
		forecast.product2.addItemListener(this);
		forecast.product3.addItemListener(this);
		forecast.product4.addItemListener(this);
		forecast.product5.addItemListener(this);
		forecastPanel.btnForecast.addActionListener(this);
		
		forecast.btnCompareToDate.addActionListener(this);
		
		//Employee
		empPanel.btnCreate.addActionListener(this);
		empCreate.btnRegister.addActionListener(this);
		empCreate.btnVerify.addActionListener(this);
		empCreate.btnShowPassword.addActionListener(this);
		empCreate.btnShowConfirmPassword.addActionListener(this);
		
		empCreate.cbAccType.addItemListener(this);
		empCreate.cbDepartment.addItemListener(this);
		empCreate.cbPosition.addItemListener(this);
		
		// Audit Trail
		auditTrail.btnSearch.addActionListener(this);
		auditTrail.cbCategory.addItemListener(this);
		
	}
	
	private void components() {
		panel = new JPanel();
		panel.setBounds(0, 0, 255, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		container = new JPanel();
		container.setBounds(255, 0, 1009, 721);
		contentPane.add(container);
		container.setLayout(null);
	}
	
	private void SalesReportPanel(int year_, int month_) {
        try {
        	
        	salesPanel.main.setRowCount(0);
        	
			panelVisible();
			
			int year = year_;
			int month = month_;
	
			
	        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1); // October 2023
	        LocalDate currentMonday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
	        LocalDate currentSunday = firstDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
	        int weekIndex = 1;
	        
	        ArrayList arrTemp = new ArrayList<>();
	        ArrayList arrRebranding = new ArrayList<>();
	        String KBNBrand = "";
	        String Rebranding = "";
	
	        while (currentMonday.getMonth() == firstDayOfMonth.getMonth()) {
	            if (currentSunday.isBefore(currentMonday)) {
	                currentSunday = currentSunday.plusWeeks(1);
	            }
	            
		   		 KBNBrand = "SELECT DISTINCT CONCAT(a.prodName, ' (', a.prodVolume, ')') AS Product, \n"
		 				+ "       COALESCE(SUM(b.Quantity), 0) AS TotalQuantity \n"
		 				+ "FROM tblproducts AS a \n"
		 				+ "LEFT JOIN ( \n"
		 				+ "    SELECT ocd.ProductName, ocd.volume, ocd.OrderRefNumber, SUM(ocd.Quantity) AS Quantity \n"
		 				+ "    FROM tblordercheckoutdata AS ocd \n"
		 				+ "    JOIN tblordercheckout AS oc ON ocd.OrderRefNumber = oc.OrderRefNumber \n"
		 				+ "    JOIN tblorderstatus AS os ON ocd.OrderRefNumber = os.OrderRefNumber \n"
		 				+ "    WHERE os.Status = 'Completed' AND oc.OrderDate >= '" + currentMonday + "' AND oc.OrderDate <= '" + currentSunday + "' \n"
		 				+ "    GROUP BY ocd.ProductName, ocd.volume, ocd.OrderRefNumber \n"
		 				+ ") AS b ON a.prodName = b.ProductName AND a.prodVolume = b.volume \n"
		 				+ "GROUP BY Product \n"
		 				+ "ORDER BY Product ASC;";
		   		 
		   		 Rebranding = "SELECT DISTINCT CONCAT(a.prodName, ' (', a.prodVolume, ')') AS Product, \n"
		 				+ "       COALESCE(SUM(b.Quantity), 0) AS TotalQuantity \n"
		 				+ "FROM tblrebrandingproducts AS a \n"
		 				+ "LEFT JOIN ( \n"
		 				+ "    SELECT ocd.ProductName, ocd.volume, ocd.OrderRefNumber, SUM(ocd.Quantity) AS Quantity \n"
		 				+ "    FROM tblordercheckoutdata AS ocd \n"
		 				+ "    JOIN tblordercheckout AS oc ON ocd.OrderRefNumber = oc.OrderRefNumber \n"
		 				+ "    JOIN tblorderstatus AS os ON ocd.OrderRefNumber = os.OrderRefNumber \n"
		 				+ "    WHERE os.Status = 'Completed' AND oc.OrderDate >= '" + currentMonday + "' AND oc.OrderDate <= '" + currentSunday + "' \n"
		 				+ "    GROUP BY ocd.ProductName, ocd.volume, ocd.OrderRefNumber \n"
		 				+ ") AS b ON a.prodName = b.ProductName AND a.prodVolume = b.volume \n"
		 				+ "GROUP BY Product \n"
		 				+ "ORDER BY Product ASC;";
		   		 
		   		arrTemp.add(KBNBrand);
		   		arrRebranding.add(Rebranding);
		   		
	            currentMonday = currentMonday.plusWeeks(1);
	            currentSunday = currentSunday.plusWeeks(1);
	            
	            weekIndex++;
	        }
	        
	        if(weekIndex == 5) {
	        	String[] columnidentifier = {"Products", "Week 1","Week 2","Week 3", "Week 4", "Total"}; // Default
	        	salesPanel.main.setColumnIdentifiers(columnidentifier);
	        } else if(weekIndex == 6) {
	        	String[] columnidentifier = {"Products", "Week 1","Week 2","Week 3", "Week 4", "Week 5", "Total"}; // Default
	        	salesPanel.main.setColumnIdentifiers(columnidentifier);
	        }
	        
			TableColumn column = salesPanel.table.getColumnModel().getColumn(0); // This is the first column
	        column.setPreferredWidth(400);
	        
	   		String ProductList = "SELECT DISTINCT CONCAT(a.prodName, ' (', a.prodVolume, ')') AS Product \n"
	 				+ "FROM tblproducts AS a \n"
	 				+ "LEFT JOIN ( \n"
	 				+ "    SELECT ocd.ProductName, ocd.volume, ocd.OrderRefNumber, SUM(ocd.Quantity) AS Quantity \n"
	 				+ "    FROM tblordercheckoutdata AS ocd \n"
	 				+ "    JOIN tblordercheckout AS oc ON ocd.OrderRefNumber = oc.OrderRefNumber \n"
	 				+ "    JOIN tblorderstatus AS os ON ocd.OrderRefNumber = os.OrderRefNumber \n"
	 				+ "    WHERE os.Status = 'Completed' AND oc.OrderDate >= '" + currentMonday + "' AND oc.OrderDate <= '" + currentSunday + "' \n"
	 				+ "    GROUP BY ocd.ProductName, ocd.volume, ocd.OrderRefNumber \n"
	 				+ ") AS b ON a.prodName = b.ProductName AND a.prodVolume = b.volume \n"
	 				+ "GROUP BY Product \n"
	 				+ "ORDER BY Product ASC;";
	   		
	   		String RebrandingList = "SELECT DISTINCT CONCAT(a.prodName, ' (', a.prodVolume, ')') AS Product \n"
	 				+ "FROM tblrebrandingproducts AS a \n"
	 				+ "LEFT JOIN ( \n"
	 				+ "    SELECT ocd.ProductName, ocd.volume, ocd.OrderRefNumber, SUM(ocd.Quantity) AS Quantity \n"
	 				+ "    FROM tblordercheckoutdata AS ocd \n"
	 				+ "    JOIN tblordercheckout AS oc ON ocd.OrderRefNumber = oc.OrderRefNumber \n"
	 				+ "    JOIN tblorderstatus AS os ON ocd.OrderRefNumber = os.OrderRefNumber \n"
	 				+ "    WHERE os.Status = 'Completed' AND oc.OrderDate >= '" + currentMonday + "' AND oc.OrderDate <= '" + currentSunday + "' \n"
	 				+ "    GROUP BY ocd.ProductName, ocd.volume, ocd.OrderRefNumber \n"
	 				+ ") AS b ON a.prodName = b.ProductName AND a.prodVolume = b.volume \n"
	 				+ "GROUP BY Product \n"
	 				+ "ORDER BY Product ASC;";
	   			

	        ArrayList product = new ArrayList<>();
	        ArrayList product1 = new ArrayList<>();
	        ArrayList product2 = new ArrayList<>();
	        ArrayList product3 = new ArrayList<>();
	        ArrayList product4 = new ArrayList<>();
	        ArrayList product5 = new ArrayList<>();
	        
	   		st.execute(ProductList);
	   		
	   		rs = st.getResultSet();
	   		while(rs.next())
	   			product.add(rs.getString(1));
	   		
	   		st.execute(RebrandingList);
	   		rs = st.getResultSet();
	   		while(rs.next())
	   			product.add(rs.getString(1));
	        
            for(int i = 0; i < arrTemp.size(); i++) {
            	
            	if(i == 0) {
                	st.execute(arrTemp.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product1.add(rs.getString(2));
                	}
                	
                	st.execute(arrRebranding.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product1.add(rs.getString(2));
                	}
            	}
            	
            	if(i == 1) {
                	st.execute(arrTemp.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product2.add(rs.getString(2));
                	}
                	
                	st.execute(arrRebranding.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product2.add(rs.getString(2));
                	}
            	}
            	
            	if(i == 2) {
                	st.execute(arrTemp.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product3.add(rs.getString(2));
                	}
                	
                	st.execute(arrRebranding.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product3.add(rs.getString(2));
                	}
            	}
            	
            	if(i == 3) {
                	st.execute(arrTemp.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product4.add(rs.getString(2));
                	}
                	
                	st.execute(arrRebranding.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product4.add(rs.getString(2));
                	}
            	}
            	if(i == 4) {
                	st.execute(arrTemp.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product5.add(rs.getString(2));
                	}
                	
                	st.execute(arrRebranding.get(i).toString());
                	rs = st.getResultSet();
                	while(rs.next()) {
                		product5.add(rs.getString(2));
                	}
            	}
            }
            if(weekIndex == 5) {
                int maxRowCount = Math.max(
                        Math.max(product.size(), product1.size()),
                        Math.max(product2.size(), Math.max(product3.size(), product4.size()))
                    );
                
                for (int i = 0; i < maxRowCount; i++) {
                    Object[] rowData = {
                        i < product.size() ? product.get(i) : "",
                        i < product1.size() ? product1.get(i) : "",
                        i < product2.size() ? product2.get(i) : "",
                        i < product3.size() ? product3.get(i) : "",
                        i < product4.size() ? product4.get(i) : ""
                    };
                    salesPanel.main.addRow(rowData);
                }
            }
            else if(weekIndex == 6) {
                int maxRowCount = Math.max(
                	    Math.max(product.size(), product1.size()),
                	    Math.max(product2.size(), Math.max(product3.size(), Math.max(product4.size(), product5.size())))
                	);

                	for (int i = 0; i < maxRowCount; i++) {
                	    Object[] rowData = {
                	        i < product.size() ? product.get(i) : "",
                	        i < product1.size() ? product1.get(i) : "",
                	        i < product2.size() ? product2.get(i) : "",
                	        i < product3.size() ? product3.get(i) : "",
                	        i < product4.size() ? product4.get(i) : "",
                	        i < product5.size() ? product5.get(i) : "" // Include data from product5
                	    };
                	    salesPanel.main.addRow(rowData);
                	}
            }
            

			salesPanel.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error SalesReportPanel: " + e.getMessage());
		}
	}
	
	private void renderingKBNProducts() {
		try {
			forecast.product1.addItem("None");
			forecast.product2.addItem("None");
			forecast.product3.addItem("None");
			forecast.product4.addItem("None");
			forecast.product5.addItem("None");
			
			String SQL = "SELECT prodName, prodVolume FROM tblproducts";
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next())
				products.add(rs.getString(1) + "-" + rs.getString(2));
			
			for(int i = 0; i < products.size(); i++) {
				forecast.product1.addItem(products.get(i));
				forecast.product2.addItem(products.get(i));
				forecast.product3.addItem(products.get(i));
				forecast.product4.addItem(products.get(i));
				forecast.product5.addItem(products.get(i));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(navs, "Error ProductsRendering: " + e.getMessage());
		}
	}
	
	private void getSoldQuantityPresent(String itemName) {
		try {
			int quantity = 0;
			String prodName = itemName.split("-")[0];
			String prodVariant = itemName.split("-")[1];
			int barNumber = Integer.parseInt(itemName.split("-")[2]);
			String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) As total "
					+ "FROM tblordercheckoutdata AS a "
					+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = a.OrderRefNumber "
					+ "WHERE a.ProductName = '" + prodName +"' AND a.volume = '" + prodVariant + "' AND b.Status = 'Completed';";
			
			st.execute(gettingTotalQuantity);
			rs = st.getResultSet();
			while(rs.next()) {
				if(rs.getString(3) == null)
					quantity = 0;
				else
					quantity = rs.getInt(3);
			}
			
			if(barNumber == 1) {
				bar1.bar1.setBounds(18, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 2) {
				bar1.bar2.setBounds(80, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 3) {
				bar1.bar3.setBounds(142, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 4) {
				bar1.bar4.setBounds(204, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 5) {
				bar1.bar5.setBounds(266, 508 - quantity, 44, 0 + quantity);
			}else {
				return;
			}
			quantity = 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error getSoldQuantityPresent: " + e.getMessage());
		}
	}
	
	private void getSoldQuantityPrev(String itemName, String dateStart, String dateEnd) {
		try {
			int quantity = 0;
			String prodName = itemName.split("-")[0];
			String prodVariant = itemName.split("-")[1];
			int barNumber = Integer.parseInt(itemName.split("-")[2]);
			String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) As total "
					+ "FROM tblordercheckoutdata AS a "
					+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = a.OrderRefNumber "
					+ "WHERE a.ProductName = '" + prodName +"' AND a.volume = '" + prodVariant + "' AND b.Status = 'Completed' AND c.OrderDate >= '" + dateStart + "' AND c.OrderDate <= '" + dateEnd + "';";
			
			
			System.out.println(gettingTotalQuantity);
			st.execute(gettingTotalQuantity);
			rs = st.getResultSet();
			while(rs.next()) {
				if(rs.getString(3) == null)
					quantity = 0;
				else
					quantity = rs.getInt(3);
			}
			
			if(barNumber == 1) {
				bar2.bar1.setBounds(18, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 2) {
				bar2.bar2.setBounds(80, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 3) {
				bar2.bar3.setBounds(142, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 4) {
				bar2.bar4.setBounds(204, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 5) {
				bar2.bar5.setBounds(266, 508 - quantity, 44, 0 + quantity);
			}else {
				return;
			}
			
			quantity = 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error getSoldQuantityPresent: " + e.getMessage());
		}
	}
	
	// Forecast
	private void getForecastGraph() {
		try {

			forecastPanel.Graph.removeAll();
			forecastPanel.Graph.revalidate();
			forecastPanel.Graph.repaint();
			
			String product = forecastPanel.comboBox.getSelectedItem() + "";

	        
	        String prodName = "";
	        String prodVariant = "";

	        String[] parts = product.split("\\(|\\)");

	        // Ensure that there are at least two parts
	        if (parts.length >= 2) {
	            // Trim to remove leading and trailing whitespaces
	            prodName = parts[0].trim();
	            prodVariant = parts[1].trim();
	        } else {
	            System.out.println("Invalid format");
	        }
			
			List<String> date = new ArrayList<>();
            int max = 0;
            
			int year = forecastPanel.yearChooser.getYear();
			int month = forecastPanel.monthChooser.getMonth() + 1;
			
			String getScoreDate = "";
	        
            List<String> dates = new ArrayList<>();
            List<Integer> firstDataset = new ArrayList<>();
            
	        LocalDate firstDayOfMonthFirst = LocalDate.of(year-1, month, 1); // October 2023
	        LocalDate currentMondayFirst = firstDayOfMonthFirst.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
	        LocalDate currentSundayFirst = firstDayOfMonthFirst.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
	        int FirstIndex = 0;
	        
	        List<Integer> week1 = new ArrayList<>();
	        List<Integer> week2 = new ArrayList<>();
	        List<Integer> week3 = new ArrayList<>();
	        List<Integer> week4 = new ArrayList<>();
	        List<Integer> week5 = new ArrayList<>();
	        int dateCounter = 1;
	        
	        while (currentMondayFirst.getMonth() == firstDayOfMonthFirst.getMonth()) {
	        	
		        for(int j =  5; j > 0; j--) {
		        	
			        ArrayList<Integer> arrTemp = new ArrayList<>();
		            if (currentSundayFirst.isBefore(currentMondayFirst)) {
		                currentSundayFirst = currentSundayFirst.plusWeeks(1);
		            }
		            
					getScoreDate = "SELECT a.OrderRefNumber, CONCAT(b.ProductName, ' (', b.volume, ')') AS ProductName, round(AVG(b.Quantity)) AS AVGMonthh, DATE(a.OrderDate) \n"
							+ "FROM tblordercheckout AS a \n"
							+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
							+ "WHERE b.ProductName = '" + prodName + "' AND volume = '" + prodVariant + "' \n"
							+ "AND (a.OrderDate >= '" + currentMondayFirst + "' AND a.OrderDate <= '" + currentSundayFirst + "' )"
							+ "GROUP BY a.OrderRefNumber \n"
							+ "order by a.OrderDate DESC;";
					
					System.out.println(getScoreDate);
					
					st.execute(getScoreDate);
					
					rs = st.getResultSet();
					
					while(rs.next()) {
						arrTemp.add(rs.getInt(3));
					}
					
					int divider = arrTemp.size();
					
					if(divider == 0)
						divider = 1;
					
					int tempAdd = 0;
					
					for(int i = 0; i < arrTemp.size(); i++) {
						if(arrTemp.get(i) == 0)
							tempAdd += 1;
						else
							tempAdd += arrTemp.get(i);
					}
					
					int finalAverage = Math.round(tempAdd / divider);
					
					FirstIndex++;
		            firstDataset.add(finalAverage);
		            
		            if(j == 5)
		            	week1.add(finalAverage);
		            else if(j == 4)
		            	week2.add(finalAverage);
		            else if(j == 3)
		            	week3.add(finalAverage);
		            else if(j == 2)
		            	week4.add(finalAverage);
		            else if(j == 1)
		            	week5.add(finalAverage);
		            
		            System.out.println(j + ". " + finalAverage);
		            	
		        	
		        	currentMondayFirst = currentMondayFirst.minusYears(1);
		        	currentSundayFirst = currentSundayFirst.minusYears(1);
		        }

				System.out.println("----------------------------------------------");

	        	currentMondayFirst = currentMondayFirst.plusYears(5);
	        	currentSundayFirst = currentSundayFirst.plusYears(5);
		        
	            currentMondayFirst = currentMondayFirst.plusWeeks(1);
	            currentSundayFirst = currentSundayFirst.plusWeeks(1);
	            dates.add("week" + dateCounter);
	            dateCounter++;
	        }
//
//            List<Integer> secondDataset = new ArrayList<>();
//	        
//	        LocalDate firstDayOfMonthSecond = LocalDate.of(year, month-1, 1);
//	        LocalDate currentMondaySecond = firstDayOfMonthSecond.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
//	        LocalDate currentSundaySecond = firstDayOfMonthSecond.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
//
//	        int secondindex = 0;
//	        while (currentMondaySecond.getMonth() == firstDayOfMonthSecond.getMonth()) {
//	        	ArrayList<Integer> arrTemp = new ArrayList<>();
//	        	if (currentSundaySecond.isBefore(currentMondaySecond)) {
//	        		currentSundaySecond = currentSundaySecond.plusWeeks(1);
//	        	}
//	        	
//	        	getScoreDate = "SELECT a.OrderRefNumber, CONCAT(b.ProductName, ' (', b.volume, ')') AS ProductName, round(AVG(b.Quantity)) AS AVGMonthh, DATE(a.OrderDate) \n"
//	        			+ "FROM tblordercheckout AS a \n"
//	        			+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
//	        			+ "WHERE b.ProductName = '" + prodName + "' AND volume = '" + prodVariant + "' \n"
//	        			+ "AND (a.OrderDate > '" + currentMondaySecond + "' AND a.OrderDate <= '" + currentSundaySecond + "' )"
//	        			+ "GROUP BY a.OrderRefNumber \n"
//	        			+ "order by a.OrderDate DESC;";
//	        	
//	        	st.execute(getScoreDate);
//	        	
//	        	rs = st.getResultSet();
//	        	
//	        	while(rs.next()) {
//	        		arrTemp.add(rs.getInt(3));
//	        	}
//	        	
//	        	
//	        	int divider = arrTemp.size();
//	        	
//	        	if(divider == 0)
//	        		divider = 1;
//	        	
//	        	int tempAdd = 0;
//	        	
//	        	for(int i = 0; i < arrTemp.size(); i++) {
//					if(arrTemp.get(i) == 0)
//						tempAdd += 1;
//					else
//						tempAdd += arrTemp.get(i);
//	        	}
//	        	
//	        	int finalAverage = Math.round(tempAdd / divider);
//	        	
//	        	secondDataset.add(finalAverage);
//	        	
//	        	currentMondaySecond = currentMondaySecond.plusWeeks(1);
//	        	currentSundaySecond = currentSundaySecond.plusWeeks(1);
//
//	        	secondindex++;
//
//	            System.out.println("2." + finalAverage);
//	        }
	        
            List<Integer> AverageFuture = new ArrayList<>();
            
            
//			int minVal = 0;
//			if(FirstIndex < secondindex)
//				minVal = FirstIndex;
//			else
//				minVal = secondindex;
//			
//	        for (int i = firstDataset.size() - 1; i >= minVal; i--) {
//	            firstDataset.remove(i);
//	        }
//	        
//	        for (int i = secondDataset.size() - 1; i >= minVal; i--) {
//	        	secondDataset.remove(i);
//	        }
//
//			for(int i = 0; i < minVal; i++) {
//				date.add("week " + (i+1));
//			}
//            
            for(int i = 0; i < 4; i++) {
            	int sum = Math.round((Integer.parseInt(week1.get(i).toString()) + Integer.parseInt(week2.get(i).toString()) + Integer.parseInt(week3.get(i).toString()) + Integer.parseInt(week4.get(i).toString()) + Integer.parseInt(week4.get(i).toString()))/5);
            	AverageFuture.add(sum);
            	System.out.println("week" + i + ": "+ sum);
            }

            List<List<Integer>> datasets = new ArrayList<>();
            datasets.add(week1);
            datasets.add(week2);
            datasets.add(week3);
            datasets.add(week4);
            datasets.add(week5);
//            datasets.add(secondDataset);
            datasets.add(AverageFuture);
            
    		JLabel graphLegend = new JLabel("Red - Previous     Blue - Present     Green - Possible Future");
    		graphLegend.setHorizontalAlignment(SwingConstants.CENTER);
    		
    		int a = findMaxValue(firstDataset);
//    		int b = findMaxValue(secondDataset);
    		

//    		if (a > b) {
//    		    max = a;
//    		} else {
//    		    max = b;
//    		}
    		
//    		if(max <= 20)
//    			max = 50;
    		
    		max = a;
    		
    		
			
            graphTest = new GraphTest(datasets, max, dates);
			graphTest.revalidate();
            
			forecastPanel.Graph.add(graphTest);
            graphTest.setBounds(0, 0, 969, 537);
            
            forecastPanel.Graph.add(forecastPanel.Graph.add(graphLegend));
    		graphLegend.setBounds(529, 11, 430, 14);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Forcast: " + e.getMessage());
		}
	}
	
    private static int findMaxValue(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        // Initialize max to the first element of the list
        int max = list.get(0);

        // Iterate through the list to find the maximum value
        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
	
	//Employee
	private void setEmployeeCount() {
		try {
			String SQL = "Select COUNT(a.AccountID) FROM tblaccount AS a JOIN tblaccountinfo AS b ON b.AccountID = a.AccountID;";
			st.execute(SQL);
			rs = st.getResultSet();
			
			if(rs.next())
				empCount = rs.getInt(1);
			
			empGen.setEmpCount(empCount);
			
			empGenRemoveButtons();
			
			String getEmpInfo = "SELECT a.accType, CONCAT(b.FirstName, \", \", b.LastName) AS Name, a.Department, b.EmailAdd, b.Contact, a.AccountID\r\n"
					+ "FROM tblaccount AS a\r\n"
					+ "JOIN tblaccountinfo AS b ON b.AccountID = a.AccountID";
			
			st.execute(getEmpInfo);
			rs = st.getResultSet();
			
			int i = 0;
			while(rs.next()) {
				empGen.lblaccType[i].setText(rs.getString(1));
				empGen.lblName[i].setText(rs.getString(2));
				empGen.lblDepartment[i].setText(rs.getString(3));
				empGen.lblContact[i].setText("<html><center>" + rs.getString(5) + "<br>" + rs.getString(4) + "</center></html>");
				empGen.accountID[i] = rs.getString(6);
				i++;
			}

			empGenSetButtons();
				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error SetEmployeeCount + " + e.getMessage());
		}
	}
	
	private void empGenRemoveButtons() {
		for(int i = 0; i < empCount; i++) {
			empGen.btnAction[i].removeActionListener(this);
		}
	}
	
	private void empGenSetButtons() {
		for(int i = 0; i < empCount; i++) {
			empGen.btnAction[i].addActionListener(this);
		}
	}
	
	private void empCreateChecker() {
		
		empCreate.dotLastName.setVisible(false);
		empCreate.dotFirstName.setVisible(false);
		empCreate.dotMiddleName.setVisible(false);
		
		empCreate.dotAddress.setVisible(false);
		empCreate.dotBirthdate.setVisible(false);
		empCreate.dotAge.setVisible(false);
		
		empCreate.dotEmail.setVisible(false);
		empCreate.dotContact.setVisible(false);
		
		empCreate.dotPassword.setVisible(false);
		empCreate.dotConfirmPassword.setVisible(false);
		
		if(empCreate.txtLastName.getText().equals(""))
			empCreate.dotLastName.setVisible(true);
		if(empCreate.txtFirstName.getText().equals(""))
			empCreate.dotFirstName.setVisible(true);
		if(empCreate.txtMiddleName.getText().equals(""))
			empCreate.dotMiddleName.setVisible(true);
		
		if(empCreate.txtAddress.getText().equals(""))
			empCreate.dotAddress.setVisible(true);
		if(empCreate.birthDate.getDate() == null)
			empCreate.dotBirthdate.setVisible(true);
		if(empCreate.txtAge.getText().equals(""))
			empCreate.dotAge.setVisible(true);
		
		if(empCreate.txtEmailAdd.getText().equals(""))
			empCreate.dotEmail.setVisible(true);
		if(empCreate.txtContact.getText().equals(""))
			empCreate.dotContact.setVisible(true);
		
		char[] passwordChars = empCreate.txtPassword.getPassword();
		if (passwordChars.length < 8)
		    empCreate.dotPassword.setVisible(true);

		char[] confirmPasswordChars = empCreate.txtConfirmPassword.getPassword();
		if (confirmPasswordChars.length < 8)
		    empCreate.dotConfirmPassword.setVisible(true);
		
		if(empCreate.dotLastName.isVisible() || empCreate.dotFirstName.isVisible() || empCreate.dotMiddleName.isVisible()
		|| empCreate.dotAddress.isVisible() || empCreate.dotBirthdate.isVisible() || empCreate.dotAge.isVisible()
		|| empCreate.dotEmail.isVisible() || empCreate.dotContact.isVisible() || empCreate.dotPassword.isVisible() || empCreate.dotConfirmPassword.isVisible())
			EmpCreateCheck = true;
		else
			EmpCreateCheck = false;
	}
	
	private void clearInputFields() {
		try {
			verifyEmployeeRegister = "Not Verified";
			empCreate.iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/close.png")));
		    empCreate.txtFirstName.setText("");
		    empCreate.txtLastName.setText("");
		    empCreate.txtMiddleName.setText("");
		    empCreate.txtAddress.setText("");
		    empCreate.birthDate.setDate(null);
		    empCreate.doc1.remove(0, empCreate.doc1.getLength());
		    empCreate.cbGender.setSelectedIndex(0); // Reset to the first item
		    empCreate.txtEmailAdd.setText("");
		    empCreate.doc.remove(0, empCreate.doc.getLength());
		    empCreate.txtUsername.setText("");
		    empCreate.txtPassword.setText("");
		    empCreate.txtConfirmPassword.setText("");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error ClearTextField: " + e.getMessage());
		}
	}
	
	// Register Employee
	private void registerEmployee() {
		try {
			String FirstName = empCreate.txtFirstName.getText();
			String LastName = empCreate.txtLastName.getText();
			String MiddleName = empCreate.txtMiddleName.getText();
			String Address = empCreate.txtAddress.getText();
			
//			//convertion
			Date inputdate = empCreate.birthDate.getDate();
			String Birthdate = "";
			if(inputdate != null) {
			    SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Birthdate = outputDateFormat.format(inputdate);
			}
		    
		    String Age = empCreate.txtAge.getText();
		    String Gender = empCreate.cbGender.getSelectedItem().toString();
		    String Email = empCreate.txtEmailAdd.getText();
		    String Contact = empCreate.txtContact.getText();
		    
		    String Username = empCreate.txtUsername.getText();
		    char[] passwordChars = empCreate.txtPassword.getPassword();
		    String password = new String(passwordChars);
		    char[] confirmPasswordChars = empCreate.txtConfirmPassword.getPassword();
		    String ConfirmPassword = new String(confirmPasswordChars);
		    String Type = empCreate.cbAccType.getSelectedItem().toString();
		    String Department = empCreate.cbDepartment.getSelectedItem().toString();
		    String Position = empCreate.cbPosition.getSelectedItem().toString();
		    
		    // Checking username if exist
		    if(verifyEmployeeRegister.equals("Not Verified")) {
		    	JOptionPane.showMessageDialog(null, "Please verify Username first");
		    	return;
		    }
		    
		    // check inputs if have null value
		    empCreateChecker();
		    if(EmpCreateCheck)
		    	return;
		    
		    if(!password.equals(ConfirmPassword)) {
		    	JOptionPane.showMessageDialog(null, "Password not match!");
		    	return;
		    }
		    if(!isUpdateEmpInfo) {
		    	st.execute("DROP PROCEDURE IF EXISTS createEmpAccount;");
			    String getAccountID = "SELECT COUNT(AccountID) FROM tblaccount";
			    st.execute(getAccountID);
			    rs = st.getResultSet();
			    int accID = 0;
			    if(rs.next())
			    	accID = rs.getInt(1) + 1;
			    String insertAcc = "INSERT INTO tblaccount(Username, Password, accType, Department, Position) VALUES('" + Username + "','" + password + "','" + Type + "','" + Department + "','" + Position + "');";
			    String insertAccInfo = "INSERT INTO tblaccountinfo(AccountID,FirstName,MiddleName,LastName,Address,Birthdate,Age,Gender,EmailAdd,Contact) VALUES('" + accID + "','" + FirstName + "','" + MiddleName + "','" + LastName + "','" + Address + "','" + Birthdate + "','" + Age + "','" + Gender + "','" + Email + "','" + Contact + "');";
			    
			    ArrayList arrTemp = new ArrayList<>();
			    
			    arrTemp.add(insertAcc);
			    arrTemp.add(insertAccInfo);
			    
				String Procedures = "CREATE PROCEDURE createEmpAccount()\r\n"
						+ "BEGIN\r\n"
						+ "    DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n"
						+ "    BEGIN\r\n"
						+ "        ROLLBACK;\r\n"
						+ "        RESIGNAL;\r\n"
						+ "    END;\r\n"
						+ "\r\n"
						+ "    START TRANSACTION;\r\n"
						+ "";
				
				for(int i = 0; i < arrTemp.size(); i++) {
					Procedures = Procedures + arrTemp.get(i);
				}
				
				Procedures = Procedures + "    -- If successful, commit the transaction\r\n"
						+ "    COMMIT;\r\n"
						+ "END;";
			    
				st.execute(Procedures);
				st.execute("CALL createEmpAccount();");
				JOptionPane.showMessageDialog(null, "Account registered successfully.", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
		    } else {
		    	st.execute("DROP PROCEDURE IF EXISTS updateEmpAccount;");
		    	String accID = accoudIdEmpUpdate;
		    	
		    	String SQLUpdateAccInfo = "Update tblaccountinfo\r\n"
		    			+ "SET FirstName = '" + FirstName + "',\r\n"
		    			+ "MiddleName = '" + MiddleName + "',\r\n"
		    			+ "LastName = '" + LastName + "',\r\n"
		    			+ "Address = '" + Address + "',\r\n"
		    			+ "Birthdate = '" + Birthdate + "',\r\n"
		    			+ "Age = '" + Age + "',\r\n"
		    			+ "Gender = '" + Gender + "',\r\n"
		    			+ "EmailAdd = '" + Email + "',\r\n"
		    			+ "Contact = '" + Contact + "'\r\n"
		    			+ "WHERE AccountID = '" + accID + "';";
		    	
		    	String SQLUpdateAcc = "UPDATE tblaccount\r\n"
		    			+ "SET Username = '" + Username + "',\r\n"
		    			+ "Password = '" + password + "',\r\n"
		    			+ "accType = '" + Type + "',\r\n"
		    			+ "Department = '" + Department + "',\r\n"
		    			+ "Position = '" + Position + "'\r\n"
		    			+ "WHERE AccountID = '" + accID + "';";
		    	
			    ArrayList arrTemp = new ArrayList<>();
			    
			    arrTemp.add(SQLUpdateAccInfo);
			    arrTemp.add(SQLUpdateAcc);
			    
				String Procedures = "CREATE PROCEDURE updateEmpAccount()\r\n"
						+ "BEGIN\r\n"
						+ "    DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n"
						+ "    BEGIN\r\n"
						+ "        ROLLBACK;\r\n"
						+ "        RESIGNAL;\r\n"
						+ "    END;\r\n"
						+ "\r\n"
						+ "    START TRANSACTION;\r\n"
						+ "";
				
				for(int i = 0; i < arrTemp.size(); i++) {
					Procedures = Procedures + arrTemp.get(i);
				}
				
				Procedures = Procedures + "    -- If successful, commit the transaction\r\n"
						+ "    COMMIT;\r\n"
						+ "END;";
			    
				st.execute(Procedures);
				st.execute("CALL updateEmpAccount();");
		    	JOptionPane.showMessageDialog(null, "Account Update successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
		    	
		        empGen = new EmployeeListGenerator();
				empList.scrollPane.setViewportView(empGen);
				panelVisible();
				setEmployeeCount();
				empPanel.setVisible(true);
		    }
	    	isUpdateEmpInfo = false;
		    clearInputFields();
		    
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR empCreate.btnRegister: " + e2.getMessage());
		}
	}

	// Verify Username
	private void verifyUsername() {
		try {
			String Username = empCreate.txtUsername.getText();
			
			if(Username.length() < 6) {
				JOptionPane.showMessageDialog(null, "The username must be 6 to 20 letters.");
				return;
			}
			
			ArrayList arrAccount = new ArrayList<>();
			String SQL = "SELECT Username FROM tblaccount";
			
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next())
				arrAccount.add(rs.getString(1));
			
			if(arrAccount.contains(Username))
				verifyEmployeeRegister = "Already Exist";
			else
				verifyEmployeeRegister = "Verified";
			
			if(verifyEmployeeRegister.equals("Verified")) {
				empCreate.iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/check-mark.png")));
			}else {
				empCreate.iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/close.png")));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "ERROR empCreate.btnVerify: " + e2.getMessage());
		}
	}
	
	private void AuditPanelFunc() {
		panelVisible();
		auditTrail.setVisible(true);
		
		try {
			auditTrail.main.setRowCount(0);
			String SQL = "SELECT DATE_FORMAT(a.DateAction, '%Y-%m-%d') AS formatted_date, \n"
					+ "       DATE_FORMAT(a.DateAction, '%h:%i %p') AS formatted_time, \n"
					+ "       CONCAT(b.FirstName, ' ', b.LastName) AS FullName, \n"
					+ "       a.Description \n"
					+ "FROM audittrailmarketing As a \n"
					+ "JOIN tblaccountinfo AS b ON a.UserID = b.AccountID \n"
					+ "ORDER BY a.DateAction DESC;";
			st.execute(SQL);
			ArrayList temp = new ArrayList<>();
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				String formattedText = "<html><center>" + rs.getString(1) + "<br>" + rs.getString(2) + "</center></html>";
//				temp.add(rs.getString(1) + ", " + rs.getString(2));
				temp.add(formattedText);
				temp.add(rs.getString(3));
				
				String[] splitted = rs.getString(4).split(" - ");
				temp.add("<html><b>" + splitted[0] + "</b> - " + splitted[1] + "</html>");
				auditTrail.main.addRow(temp.toArray());
				temp.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error AuditPanelFunc: " + e.getMessage());
		}
	}
	
	private void AuditPanelFuncCategory(String Cat) {
		panelVisible();
		auditTrail.setVisible(true);
		
		try {
			auditTrail.main.setRowCount(0);
			String SQL = "SELECT DATE_FORMAT(a.DateAction, '%Y-%m-%d') AS formatted_date, \n"
					+ "       DATE_FORMAT(a.DateAction, '%h:%i %p') AS formatted_time, \n"
					+ "       CONCAT(b.FirstName, ' ', b.LastName) AS FullName, \n"
					+ "       a.Description \n"
					+ "FROM " + Cat + " As a \n"
					+ "JOIN tblaccountinfo AS b ON a.UserID = b.AccountID \n"
					+ "ORDER BY a.DateAction DESC;";
			
			System.out.println(SQL);
			st.execute(SQL);
			ArrayList temp = new ArrayList<>();
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				String formattedText = "<html><center>" + rs.getString(1) + "<br>" + rs.getString(2) + "</center></html>";
//				temp.add(rs.getString(1) + ", " + rs.getString(2));
				temp.add(formattedText);
				temp.add(rs.getString(3));
				
				String[] splitted = rs.getString(4).split(" - ");
				temp.add("<html><b>" + splitted[0] + "</b> - " + splitted[1] + "</html>");
				auditTrail.main.addRow(temp.toArray());
				temp.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error AuditPanelFunc: " + e.getMessage());
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == navs.btnDashboard) {
			panelVisible();
			dashboard1.setVisible(true);
		}
		
		if(e.getSource() == navs.btnSalesReport) {
	        LocalDate currentDate = LocalDate.now();

	        // Extract the year and month as integers
	        int currentYear = currentDate.getYear();
	        int currentMonth = currentDate.getMonthValue();
	        
			SalesReportPanel(currentYear,currentMonth);
			
		}
		
		if(e.getSource() == navs.btnAudit) {
			AuditPanelFunc();
		}
		
		// Sales Print
		if(e.getSource() == salesPanel.btnPrint) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Sheet1");
			
			// Create the header row
			XSSFRow headerRow = sheet.createRow(0);

			// Define your column headers
			ArrayList<String> headers = new ArrayList<>();
			
			int columnCount = salesPanel.main.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
			    headers.add(salesPanel.main.getColumnName(i));
			}

			// Populate the header row with column names
			for (int col = 0; col < headers.size(); col++) {
			    XSSFCell cell = headerRow.createCell(col);
			    cell.setCellValue(headers.get(col));
			    System.out.println(headers.get(col));
			}

			// Optionally, format the header row for styling
			XSSFCellStyle headerCellStyle = workbook.createCellStyle();
			XSSFFont headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerCellStyle.setFont(headerFont);

			for (int col = 0; col < headers.size(); col++) {
			    headerRow.getCell(col).setCellStyle(headerCellStyle);
			}
			
			for (int row = 0; row < salesPanel.main.getRowCount(); row++) {
			    XSSFRow excelRow = sheet.createRow(row);
			    for (int col = 0; col < salesPanel.main.getColumnCount(); col++) {
			        Object cellValue = salesPanel.main.getValueAt(row, col);
			        if (cellValue != null) {
			            XSSFCell cell = excelRow.createCell(col);
			            if(col == 0) {
			            	cell.setCellValue(cellValue.toString());
			            }
			            
			            else {
			            	cell.setCellValue(Integer.parseInt(cellValue.toString()));
			            }
			        } else {
			            XSSFCell cell = excelRow.createCell(col);
			            cell.setCellValue(0);
			        }
			    }
			}
			
			
			JFileChooser fc = new JFileChooser();
			String file = "";
	        int option = fc.showSaveDialog(this);
	        if(option == JFileChooser.APPROVE_OPTION){
	            String filename = fc.getSelectedFile().getName(); 
	            String path = fc.getSelectedFile().getParentFile().getPath();

				int len = filename.length();
				String ext = "";

				if(len > 4){
					ext = filename.substring(len-4, len);
				}

				if(ext.equals(".xlsx")){
					file = path + "\\" + filename; 
				}else{
					file = path + "\\" + filename + ".xlsx"; 
				}
			}
	        
			try (FileOutputStream fileOut = new FileOutputStream(file)) {
			    workbook.write(fileOut);
			}catch (Exception e1) {
				// TODO: handle exception
			}
		}
		
		
		if(e.getSource() == navs.btnForecasting) {
            try {
				panelVisible();
				forecastPanel.comboBox.removeAllItems();
				String SQLKBN = "SELECT \n"
						+ "	CONCAT(a.prodName, ' (', a.prodVolume, ')') AS Product \n"
						+ "FROM tblproducts AS a;";
				
				String SQLRebrand = "SELECT \n"
						+ "	CONCAT(a.prodName, ' (', a.prodVolume, ')') AS reBrand \n"
						+ "FROM tblrebrandingproducts AS a;";
				
				st.execute(SQLKBN);
				rs = st.getResultSet();
				while(rs.next()) 
					forecastPanel.comboBox.addItem(rs.getString(1));
				
				st.execute(SQLRebrand);
				rs = st.getResultSet();
				while(rs.next())
					forecastPanel.comboBox.addItem(rs.getString(1));
				
				forecastPanel.setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error navs.btnForecasting: " + e2.getMessage());
			}
		}
		
		if(e.getSource() == forecastPanel.btnForecast) {
			getForecastGraph();
		}
		
		if(e.getSource() == forecast.btnCompareToDate) {
			
			int month = forecast.monthChooser.getMonth() + 1;
			int year = forecast.yearChooser.getYear();
			String prodName = forecast.product1.getSelectedItem().toString();
			String prodName1 = forecast.product2.getSelectedItem().toString();
			String prodName2 = forecast.product3.getSelectedItem().toString();
			String prodName3 = forecast.product4.getSelectedItem().toString();
			String prodName4 = forecast.product5.getSelectedItem().toString();
	        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
	        LocalDate lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1);

	        if(!forecast.product1.getSelectedItem().equals("None"))
	        	getSoldQuantityPrev(prodName + "-1",firstDayOfMonth + "",lastDayOfMonth + "");
	        if(!forecast.product2.getSelectedItem().equals("None"))
	        	getSoldQuantityPrev(prodName1 + "-2",firstDayOfMonth + "",lastDayOfMonth + "");
	        if(!forecast.product3.getSelectedItem().equals("None"))
	        	getSoldQuantityPrev(prodName2 + "-3",firstDayOfMonth + "",lastDayOfMonth + "");
	        if(!forecast.product4.getSelectedItem().equals("None"))
	        	getSoldQuantityPrev(prodName3 + "-4",firstDayOfMonth + "",lastDayOfMonth + "");
	        if(!forecast.product5.getSelectedItem().equals("None"))
	        	getSoldQuantityPrev(prodName4 + "-5",firstDayOfMonth + "",lastDayOfMonth + "");
		}
		
		if(e.getSource() == navs.btnEmployeeList) {
			isUpdateEmpInfo = false;
	        empGen = new EmployeeListGenerator();
			empList.scrollPane.setViewportView(empGen);
			
			panelVisible();
			setEmployeeCount();
			empPanel.setVisible(true);
		}
		
		//Employee
		if(e.getSource() == empPanel.btnCreate) {
		    clearInputFields();
			panelVisible();
			empCreate.setVisible(true);
		}
		if(e.getSource() == empCreate.btnVerify) {
			verifyUsername();
		}
		
		if(e.getSource() == empCreate.btnRegister) {
			registerEmployee();
		}
		
		if(e.getSource() == empCreate.btnShowPassword) {
		    if (empCreate.txtPassword.getEchoChar() == 0) {
		        empCreate.txtPassword.setEchoChar('*');
		        empCreate.btnShowPassword.setText("Show");
		    } else {
		        empCreate.txtPassword.setEchoChar((char) 0);
		        empCreate.btnShowPassword.setText("Hide");
		    }
		}
		
		if(e.getSource() == empCreate.btnShowConfirmPassword) {
		    if (empCreate.txtConfirmPassword.getEchoChar() == 0) {
		        empCreate.txtConfirmPassword.setEchoChar('*');
		        empCreate.btnShowConfirmPassword.setText("Show");
		    } else {
		        empCreate.txtConfirmPassword.setEchoChar((char) 0);
		        empCreate.btnShowConfirmPassword.setText("Hide");
		    }
		}
		
		//Employe List Edit/Update
	    for (int i = 0; i < empCount; i++) {
			try {
		        if (e.getSource() == empGen.btnAction[i]) {
					empCreate.iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/close.png")));
				    clearInputFields();
					panelVisible();
					empCreate.setVisible(true);
		        	accoudIdEmpUpdate = empGen.accountID[i];
		        	isUpdateEmpInfo = true;
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					Date date = null;
						date = sdf.parse("01/05/2000");
		
					
					String SQLSEelect = "SELECT b.FirstName, b.MiddleName, b.LastName, b.Address, b.Birthdate, b.Age, b.Gender, b.EmailAdd, b.Contact, a.Username, a.accType, a.Department, a.Position, a.Password\r\n"
							+ "FROM tblaccount AS a\r\n"
							+ "JOIN tblaccountinfo AS b ON b.AccountID = a.AccountID\r\n"
							+ "WHERE a.AccountID = '" + accoudIdEmpUpdate + "';";
					st.execute(SQLSEelect);
					rs = st.getResultSet();
					if(rs.next()) {
						empCreate.setTextfromEdit(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));	
					}
					verifyEmployeeRegister = "Verified";
					empCreate.iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/check-mark.png")));
		            break;
		        }
	        } catch (Exception e1) {
	        	JOptionPane.showMessageDialog(null, "Error EmpListEdit: " + e1.getMessage());
			}
	    }
	    
	    // Courier List
	    if(e.getSource() == navs.btnListOfCourier) {
			panelVisible();
			courierPanel.setVisible(true);
			try {
				courierPanel.main.setRowCount(0);
				String courierCount = "SELECT COUNT(CourierID) FROM tblcourierinformation;";
				String sql = "SELECT CourierID, CONCAT(Firstname, ' ',  LastName) AS FullName, Address, Email, ContactNo FROM tblcourierinformation;";
				
				st.execute(sql);
				
				rs = st.getResultSet();
				
				ArrayList temp = new ArrayList<>();
				while(rs.next()) {
					temp.add(rs.getString(1));
					temp.add(rs.getString(2));
					temp.add(rs.getString(3));
					temp.add(rs.getString(4));
					temp.add(rs.getString(5));
					courierPanel.main.addRow(temp.toArray());
					temp.clear();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error navs.btnListOfCourier: " + e2.getMessage());
			}
	    }
	    	//Courier Register
	    	if(e.getSource() == courierPanel.btnCreate) {
	    		courierCreate.setVisible(true);
	    	}
	    	
	    if(e.getSource() == navs.btnProductPrice) {
	    	prodPrice = new ProductPrice();
	    	prodPrice.setVisible(true);
	    }
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
	    	
	        if (e.getSource() == forecast.product1) {
	        	if(forecast.product1.getSelectedItem().equals("None")) {
	        		bar1.bar1.setVisible(false);
	        		bar2.bar1.setVisible(false);
	        	}else {
	        		bar1.bar1.setVisible(true);
	        		bar2.bar1.setVisible(true);
	        		getSoldQuantityPresent(forecast.product1.getSelectedItem() + "-1");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product2) {
	        	if(forecast.product2.getSelectedItem().equals("None")) {
	        		bar1.bar2.setVisible(false);
	        		bar2.bar2.setVisible(false);
	        	}else {
	        		bar1.bar2.setVisible(true);
	        		bar2.bar2.setVisible(true);
	        		getSoldQuantityPresent(forecast.product2.getSelectedItem() + "-2");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product3) {
	        	if(forecast.product3.getSelectedItem().equals("None")) {
	        		bar1.bar3.setVisible(false);
	        		bar2.bar3.setVisible(false);
	        	}else {
	        		bar1.bar3.setVisible(true);
	        		bar2.bar3.setVisible(true);
	        		getSoldQuantityPresent(forecast.product3.getSelectedItem() + "-3");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product4) {
	        	if(forecast.product4.getSelectedItem().equals("None")) {
	        		bar1.bar4.setVisible(false);
	        		bar2.bar4.setVisible(false);
	        	}else {
	        		bar1.bar4.setVisible(true);
	        		bar2.bar4.setVisible(true);
	        		getSoldQuantityPresent(forecast.product4.getSelectedItem() + "-4");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product5) {
	        	if(forecast.product5.getSelectedItem().equals("None")) {
	        		bar1.bar5.setVisible(false);
	        		bar2.bar5.setVisible(false);
	        	}else {
	        		bar1.bar5.setVisible(true);
	        		bar2.bar5.setVisible(true);
	        		getSoldQuantityPresent(forecast.product5.getSelectedItem() + "-5");
	        	}
	        }
	        
	        //Employee
        	String accType = empCreate.cbAccType.getSelectedItem() + "";
        	String department = empCreate.cbDepartment.getSelectedItem() + "";
        	String position = empCreate.cbPosition.getSelectedItem() + "";
        	
        	DefaultComboBoxModel<String> nullmodel = new DefaultComboBoxModel<>(new String[] {""});
        	DefaultComboBoxModel<String> adminPosition = new DefaultComboBoxModel<>(new String[] {"All"});
        	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        	DefaultComboBoxModel<String> modelPost = new DefaultComboBoxModel<>();
        	
	        if (e.getSource() == empCreate.cbAccType) {

	        	empCreate.cbPosition.setModel(nullmodel);
	        	
	        	String[] depAdmin = {"Marketing", "Production", "Warehouse"};
	        	String[] Staff = {"Marketing", "Warehouse"};
	        	String[] depCashier = {"Cashier"};
	        	String[] marketingStaffPosition = {"Inventory and Ordering"};
	        	
	        	if (accType.equals("Admin")) {
	        	    model.addElement("All");
	        	    empCreate.cbPosition.setModel(adminPosition);
	        	    empCreate.cbDepartment.setModel(model);
	        	} else if(accType.equals("Manager")) {
	        	    for (String item : depAdmin) {
	        	        model.addElement(item);
	        	    }
	        	    empCreate.cbPosition.setModel(adminPosition);
	        	    empCreate.cbDepartment.setModel(model);
	        	} else if (accType.equals("Cashier")) {
	        	    for (String item : depCashier) {
	        	        model.addElement(item);
	        	    }
	        	    empCreate.cbDepartment.setModel(model);
	        	    empCreate.cbPosition.setModel(model);
	        	} else if(accType.equals("Staff")) {
	        	    for (String item : Staff) {
	        	        model.addElement(item);
	        	    }
	        	    empCreate.cbDepartment.setModel(model);
	        	    
	        	    for (String item : marketingStaffPosition) {
	        	    	modelPost.addElement(item);
	        	    }
	        		empCreate.cbPosition.setModel(modelPost);
	        	}
	        }
	        
	        if (e.getSource() == empCreate.cbDepartment) {
	        	String[] marketingStaffPosition = {"Inventory and Ordering"};
	        	String[] warehouseStaffPosition = {"Materials Inventory"};
	        	
	        	if(accType.equals("Staff") && department.equals("Marketing")) {
	        	    for (String item : marketingStaffPosition) {
	        	    	modelPost.addElement(item);
	        	    }
	        		empCreate.cbPosition.setModel(modelPost);
	        	} else if(accType.equals("Staff") && department.equals("Warehouse")) {
	        	    for (String item : warehouseStaffPosition) {
	        	    	modelPost.addElement(item);
	        	    }
	        		empCreate.cbPosition.setModel(modelPost);
	        	} else if(accType.equals("Staff") && department.equals("Production")) {
	        		empCreate.cbPosition.setModel(nullmodel);
	        	}
	        }
	        
	        if(e.getSource() == auditTrail.cbCategory) {
	        	String cat = "";
	        	if(auditTrail.cbCategory.getSelectedIndex() == 0)
	        		cat = "audittrailmarketing";
	        	if(auditTrail.cbCategory.getSelectedIndex() == 1)
	        		cat = "audittrailproduction";
	        	if(auditTrail.cbCategory.getSelectedIndex() == 2)
	        		cat = "audittrailwarehouse";
	        	AuditPanelFuncCategory(cat);
	        }
	        
	    }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			if(e.getSource() == courierPanel.table) {
				courierRightClick.setVisible(true);
				int x = 265 + e.getX();
				int y = 110 + e.getY();
				courierRightClick.setBounds(x, y, 150, 61);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 27) {
			courierRightClick.setVisible(false);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Dashboard
	private void dashboard1() {
		chartdataSetter();
		orderCounterDashboard(); // get orderCount
		setOrderListDataDashboard(); // set data in Dashboard
		timeDiff();
		dailyDashboard();
		weeklyDashboard();
		monthlyDashboard();
		yearlyDashboard();
		outStock();
		lowStock();
		
		topSell();
		leastSell();
	}
	
	// chart
    private void chartdataSetter() {
    	try {
            List<Integer> scores = new ArrayList<Integer>();
            List<String> date = new ArrayList<String>();
            int max = 0;

    		String sqlMaxCounterYaxis = "SELECT SUM(a.Quantity), b.OrderDate FROM tblordercheckoutdata AS a "
    				+ "JOIN tblordercheckout AS b ON b.OrderRefNumber = a.OrderRefNumber "
    				+ "GROUP BY b.OrderDate "
    				+ "ORDER BY SUM(a.Quantity) DESC LIMIT 1";
    		
    		st.execute(sqlMaxCounterYaxis);
    		rs = st.getResultSet();
    		
    		if(rs.next())
    			max = rs.getInt(1);
            	
            LocalDate currentDate = LocalDate.now();

            LocalDate mondayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate sundayOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            	
    		String X_axis = "SELECT SUM(a.Quantity) AS Score, b.OrderDate AS Order_Date \r\n"
    				+ "FROM tblordercheckoutdata AS a \r\n"
    				+ "JOIN tblordercheckout AS b ON b.OrderRefNumber = a.OrderRefNumber \r\n"
    				+ "JOIN tblorderstatus AS c ON c.OrderRefNumber = a.OrderRefNumber \r\n"
    				+ "WHERE c.Status = 'Completed' AND (OrderDate >= '" + mondayOfWeek + "' AND OrderDate <= '" +  sundayOfWeek + "')\r\n"
    				+ "GROUP BY DATE(Order_Date) \n"
    				+ "ORDER BY Score DESC;";
    		
    		st.execute(X_axis);
    		rs = st.getResultSet();
    		
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd");
    		
    		while(rs.next()) {
                scores.add(rs.getInt(1));
        	    Date orderDate = rs.getDate(2);
        	    String formattedDate = dateFormat.format(orderDate);
                date.add(formattedDate);
    		}

            dashChartData = new DashboardSalesChartData(scores, max, date);
            dashChartData.setBounds(0, 0, 381, 286);
            dashboard1.panelGraph.add(dashChartData);
            

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ChartData: " + e.getMessage());
		}
    }
    
	private void orderCounterDashboard() {
		try {
			String sql = "SELECT COUNT(OrderRefNumber) FROM tblorderstatus WHERE status = 'toPay'";
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				OrderCountDash = rs.getInt(1);
			
			opdDashboard.iOrderCount(OrderCountDash);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error OrderCount: " + e.getMessage());
		}
	}
	
	private void setOrderListDataDashboard() {
		try {
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a JOIN tblcustomerinformation AS b ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber WHERE c.status = 'toPay'";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				opdDashboard.lblRefNumber[i].setText(rs.getString(1));
				opdDashboard.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				opdDashboard.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBNAdminPanel/resources/orderPanel/" + rs.getString(5) + ".png";
				opdDashboard.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				opdDashboard.lblOrderStatusColor[i].revalidate();
				opdDashboard.lblOrderStatusColor[i].repaint();
				i++;
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListData: " + e.getMessage());
		}
	}
	
	private void timeDiff() {
		try {
			st.execute(sqlTimeDiff);
			rs = st.getResultSet();
			double min = 0;
			if(rs.next()) {
				min = rs.getDouble(2);
			}
			
			double hour = min / 60;
			
			double day;
			
			
			if(hour > 0) {
				day = hour / 24;
				double remainingHours = day - (int)day; // get hours in decimal
				double getHour = 24 * remainingHours; // to get hours
				double remainingMinutes = getHour - (int) getHour; // get mins in decimal
				double getMin = 60 * remainingMinutes; // to get mins
				
				String hr_ = (getHour > 1)? "Hours" : "Hour"; // check if the getHour value if more than 1
				String min_ = (getMin > 1)? "Minutes" : "Minute"; // same with hr_
				
				String label = "New Order " + (int)day + " days, " + (int)getHour + " " + hr_ + ", and " + (int)getMin + " " + min_ + " ago";
				dashboard1.lblTimeDiff.setText(label);
			} else {
			    String min_ = (min > 1) ? "Minutes" : "Minute";
			    String label = "New Order " + min + " " + min_ + " ago";
			    dashboard1.lblTimeDiff.setText(label);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "timeDiff ERROR: " + e.getMessage());
		}
	}
	
	private void dailyDashboard() {
		try {
			double today = 0;
			double lastDay = 1;
			
			String thisDayCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= CURDATE()";
			
			st.execute(thisDayCount);
			rs = st.getResultSet();
			
			if(rs.next())
				today = rs.getInt(1);
			
			String lastDayCount = "SELECT SUM(b.Quantity) FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= SUBDATE(CURDATE(),1) AND a.OrderDate <= CURDATE();";

			st.execute(lastDayCount);
			rs = st.getResultSet();
			
			if(rs.next())
				lastDay = rs.getInt(1);
			
			if(lastDay == 0)
				lastDay = 1;
			
			double percentage = (today / lastDay) * 100;
			int randOFF = (int)Math.round(percentage);
			
			if(randOFF < 0)
				randOFF = 0;
			
			if(randOFF > 100)
				randOFF = 100;
			
			dashboard1.lblDailyPercent.setIcon(new ImageIcon(Dashboard.class.getResource("/KBNAdminPanel/resources/dashboard/PercentagePNG/" + randOFF + ".png")));
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "dailyDashboard ERROR: " + e.getMessage());
		}
	}
	
	private void weeklyDashboard() {
		try {
			double thisWeek = 0;
			double lastWeek = 1;
			
	        LocalDate mondayOfLastWeek = today.minusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	        LocalDate sundayOfLastWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	        LocalDate mondaythisWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	        
			String thisWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondaythisWeek + "'";
//			System.out.println("Present: " + thisWeekCount);
			
			st.execute(thisWeekCount);
			rs = st.getResultSet();
			
			if(rs.next())
				thisWeek = rs.getInt(1);
			
			String lastWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondayOfLastWeek + "'  AND a.OrderDate <= '" + sundayOfLastWeek + "'";
//			System.out.println("Last: " + lastWeekCount);

			st.execute(lastWeekCount);
			rs = st.getResultSet();
			
			if(rs.next())
				lastWeek = rs.getInt(1);
			
			if(lastWeek == 0)
				lastWeek = 1;
			
			
			double percentage = (thisWeek / lastWeek) * 100;
			int randOFF = (int)Math.round(percentage);
			
			if(randOFF < 0)
				randOFF = 0;
			
			if(randOFF > 100)
				randOFF = 100;
			
			dashboard1.lblWeeklyPercent.setIcon(new ImageIcon(Dashboard.class.getResource("/KBNAdminPanel/resources/dashboard/PercentagePNG/" + randOFF + ".png")));
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "weeklyDashboard ERROR: " + e.getMessage());
		}
	}
	
	private void monthlyDashboard() {
		try {
			double thisMonth = 0;
			double lastMonth = 1;
			
			LocalDate firstDayOfLastMonth = today.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
			LocalDate lastDayOfLastMonth = today.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
			LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
	        
			String thisMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfThisMonth + "'";
//			System.out.println(thisMonthCount);
			
			st.execute(thisMonthCount);
			rs = st.getResultSet();
			
			if(rs.next())
				thisMonth = rs.getInt(1);
			
			String lastMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfLastMonth + "'  AND a.OrderDate <= '" + lastDayOfLastMonth + "'";
//			System.out.println("Last: " + lastMonthCount);

			st.execute(lastMonthCount);
			rs = st.getResultSet();
			
			if(rs.next())
				lastMonth = rs.getInt(1);
			
			if(lastMonth == 0)
				lastMonth = 1;
			
			
			double percentage = (thisMonth / lastMonth) * 100;
			int randOFF = (int)Math.round(percentage);
			
			if(randOFF < 0)
				randOFF = 0;
			
			if(randOFF > 100)
				randOFF = 100;
			
			
			
			dashboard1.lblMonthlyPercent.setIcon(new ImageIcon(Dashboard.class.getResource("/KBNAdminPanel/resources/dashboard/PercentagePNG/" + randOFF + ".png")));
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "dailyDashboard ERROR: " + e.getMessage());
		}
	}
	
	private void yearlyDashboard() {
		try {
			double thisYear = 0;
			double lastYear = 1;
			
			LocalDate firstDayOfLastYear = today.minusYears(1).with(TemporalAdjusters.firstDayOfYear());
			LocalDate lastDayOfLastYear = today.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
			LocalDate firstDayOfThisYear = today.with(TemporalAdjusters.firstDayOfYear());
		    
			String thisYearCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfThisYear + "'";
//			System.out.println(thisYearCount);
			
			st.execute(thisYearCount);
			rs = st.getResultSet();
			
			if(rs.next())
				thisYear = rs.getInt(1);
			
			String lastYearCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfLastYear + "'  AND a.OrderDate <= '" + lastDayOfLastYear + "'";
//			System.out.println("Last: " + lastYearCount);

			st.execute(lastYearCount);
			rs = st.getResultSet();
			
			if(rs.next())
				lastYear = rs.getInt(1);
			
			if(lastYear == 0)
				lastYear = 1;
			
			
			double percentage = (thisYear / lastYear) * 100;
			int randOFF = (int)Math.round(percentage);
			
			if(randOFF < 0)
				randOFF = 0;
			
			if(randOFF > 100)
				randOFF = 100;
			
			dashboard1.lblYearlyPercent.setIcon(new ImageIcon(Dashboard.class.getResource("/KBNAdminPanel/resources/dashboard/PercentagePNG/" + randOFF + ".png")));
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "dailyDashboard ERROR: " + e.getMessage());
		}
	}
	
	private void outStock() {
		try {
			String sql = "SELECT a.MATERIAL_NAME, a.CODE_NAME, a.SUPPLIER, CONCAT(a.todayCurrentVolume / 1000, 'kg') AS kilo "
			+ "FROM tblcurrentmonth AS a WHERE a.todayCurrentVolume < 1 LIMIT 5";
			
			st.execute(sql);
			rs = st.getResultSet();
			ArrayList lowStock = new ArrayList<>();
			while(rs.next()) {
				lowStock.add(rs.getString(1));
				dashboard1.tLow.addRow(lowStock.toArray());
				lowStock.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "out of Stock ERROR: " + e.getMessage());
		}
	}
	
	private void lowStock() {
		try {
			String sql = "SELECT a.MATERIAL_NAME, a.CODE_NAME, a.SUPPLIER, CONCAT(a.todayCurrentVolume / 1000, 'kg') AS kilo "
			+ "FROM tblcurrentmonth AS a WHERE a.todayCurrentVolume > 0 AND todayCurrentVolume < 20000 LIMIT 5";
			
			st.execute(sql);
			rs = st.getResultSet();
			ArrayList lowStock = new ArrayList<>();
			while(rs.next()) {
				lowStock.add(rs.getString(1));
				dashboard1.tMid.addRow(lowStock.toArray());
				lowStock.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "lowStock ERROR: " + e.getMessage());
		}
	}
	
	private void topSell() {
		
		// Specific Date;
		String SQL = "SELECT CONCAT(a.ProductName, ' (', a.volume, ')') AS product, SUM(a.Quantity) AS Sold\r\n"
				+ "FROM tblordercheckoutdata AS a\r\n"
				+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
				+ "WHERE b.OrderDate >= '2023/09/01'\r\n"
				+ "GROUP BY a.OrderRefNumber, product\r\n"
				+ "ORDER BY Quantity DESC\r\n"
				+ "LIMIT 5";
		
		try {
			st.execute(SQL);
			rs = st.getResultSet();
			ArrayList temp = new ArrayList<>();
			while(rs.next()) {
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				dashboard1.maintableTopSelling.addRow(temp.toArray());
				temp.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error topSell: " + e.getMessage());
		}
	}
	private void leastSell() {
		
		// All Time
		String SQL = "SELECT CONCAT(a.ProductName, ' (', a.volume, ')') AS product, SUM(a.Quantity) AS Quantity\r\n"
				+ "FROM tblordercheckoutdata AS a\r\n"
				+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
				+ "GROUP BY a.OrderRefNumber, product\r\n"
				+ "ORDER BY Quantity ASC\r\n"
				+ "LIMIT 5";
		
		try {
			st.execute(SQL);
			rs = st.getResultSet();
			ArrayList temp = new ArrayList<>();
			while(rs.next()) {
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				dashboard1.maintableLeastSelling.addRow(temp.toArray());
				temp.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error topSell: " + e.getMessage());
		}
	}
	
}
