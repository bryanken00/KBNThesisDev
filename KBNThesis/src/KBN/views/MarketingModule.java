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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.Module.Marketing.AuditTrail;
import KBN.Module.Marketing.CustomerAccount;
import KBN.Module.Marketing.CustomerCreateAccount;
import KBN.Module.Marketing.Dashboard;
import KBN.Module.Marketing.DashboardSalesChartData;
import KBN.Module.Marketing.DeliveryStatus;
import KBN.Module.Marketing.KBNProducts;
import KBN.Module.Marketing.OrderListPanelData;
import KBN.Module.Marketing.OrderPanelPopupInstruction;
import KBN.Module.Marketing.OrderingPanel;
import KBN.Module.Marketing.ProductDetails;
import KBN.Module.Marketing.RebrandingProd;
import KBN.Module.Marketing.RightClick;
import KBN.Module.Marketing.ClientProfile.ClientProfile;
import KBN.Module.Marketing.ClientProfile.ClientProfileScrollablePanel;
import KBN.Module.Marketing.preRegis.Registration;
import KBN.Module.Marketing.preRegis.preRegList;
import KBN.Module.Marketing.preRegis.preRegister;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;


public class MarketingModule extends JFrame implements ActionListener, MouseListener, KeyListener{

	//Class Import
	private DbConnection dbConn;
	private dataSetter dataSet;
	private Dashboard dashboard;
	private KBNProducts kbnProd;
	private RebrandingProd rebrandingProd;
	private CustomerAccount custAccount;
	private AuditTrail auditTrail;
	private DeliveryStatus delStatus;
	private CustomerCreateAccount custCreateAccount;
	private OrderingPanel orderPanel;
	private preRegister preReg;
	private preRegList preRegisList;
	private RightClick rightClick;
	private ProductDetails prodDetails;
	private OrderPanelPopupInstruction orderPanelInstruction;
	private ClientProfile cp;
	private ClientProfileScrollablePanel cpsp;
	
	// Object
	private Statement st;
	private ResultSet rs;
	
	
	//Client Profile
	private String clientProfileChecker = "";
	
	
	private String refNum;
	public static String regID;
	private LocalDate today;
	
	private JPanel contentPane;
	private JPanel panelButton;
	private JButton btnDashboard;
	private JLabel lblUsername;
	private JButton btnKbn;
	private JButton btnRebranding;
	private JButton btnRawMaterials;
	private JButton btnPackingMaterials;
	private JButton btnCustomerAccount;
	private JButton btnClientProfile;
	private JButton btnOrdering;
	private JButton btnDeliveryStatus;
	private JButton btnReturnProducts;
	private JButton btnAuditTrail;
	private JPanel panelTab;
	

	private DashboardSalesChartData dashChartData;
	
	
	private int OrderListIndexClicked;
	
	private int OrderCount; // Order List
	private int rowCount; // Pre - Registration
	private int ClientProfileCounter; // Client Profile

	public MarketingModule() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
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
        
        
        // Declaration
        dbConn = new DbConnection();
		dashboard = new Dashboard();
		kbnProd = new KBNProducts();
		rebrandingProd = new RebrandingProd();
		custAccount = new CustomerAccount();
		auditTrail = new AuditTrail();
		delStatus = new DeliveryStatus();
		custCreateAccount = new CustomerCreateAccount();
		orderPanel = new OrderingPanel();
		preReg = new preRegister();
		// Start Right Click
		rightClick = new RightClick();
			this.add(rightClick);
			rightClick.setVisible(false);
		// End Right Click
		
		// Client Profile Tab
		cp = new ClientProfile();
		cpsp = new ClientProfileScrollablePanel();
			
		prodDetails = new ProductDetails();
		orderPanelInstruction = new OrderPanelPopupInstruction();
		
		today = LocalDate.now();
		
		
        // DefaultSetup
        objComponent();
        setUsername();
//        orderCounter();
        preRegStatus();
        setActionList();
        setVisiblePanel();
        defaultPanel();
        custAccountFunc();
        mostSoldProd();
		chartdataSetter();
	}
	
	private void objComponent() {
		panelButton = new JPanel();
		panelButton.setLayout(null);
		panelButton.setBounds(0, 0, 255, 721);
		contentPane.add(panelButton);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(MarketingModule.class.getResource("/KBN/resources/kbnlogo.png")));
		lblLogo_1.setBounds(10, 11, 241, 65);
		panelButton.add(lblLogo_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(16, 85, 222, 13);
		panelButton.add(separator);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorderPainted(false);
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(10, 98, 241, 35);
		panelButton.add(btnDashboard);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(16, 144, 222, 13);
		panelButton.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setBounds(10, 150, 235, 13);
		panelButton.add(lblNewLabel);
		
		btnKbn = new JButton("KBN");
		btnKbn.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnKbn.setFocusable(false);
		btnKbn.setBorderPainted(false);
		btnKbn.setBackground(Color.WHITE);
		btnKbn.setBounds(10, 168, 241, 35);
		panelButton.add(btnKbn);
		
		btnRebranding = new JButton("Rebranding");
		btnRebranding.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRebranding.setFocusable(false);
		btnRebranding.setBorderPainted(false);
		btnRebranding.setBackground(Color.WHITE);
		btnRebranding.setBounds(10, 214, 241, 35);
		panelButton.add(btnRebranding);
		
		btnRawMaterials = new JButton("Raw Materials");
		btnRawMaterials.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRawMaterials.setFocusable(false);
		btnRawMaterials.setBorderPainted(false);
		btnRawMaterials.setBackground(Color.WHITE);
		btnRawMaterials.setBounds(10, 284, 241, 35);
		panelButton.add(btnRawMaterials);
		
		btnPackingMaterials = new JButton("Packing Materials");
		btnPackingMaterials.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnPackingMaterials.setFocusable(false);
		btnPackingMaterials.setBorderPainted(false);
		btnPackingMaterials.setBackground(Color.WHITE);
		btnPackingMaterials.setBounds(10, 330, 241, 35);
		panelButton.add(btnPackingMaterials);
		
		JLabel lblMaterials = new JLabel("Materials");
		lblMaterials.setBounds(10, 266, 235, 13);
		panelButton.add(lblMaterials);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(16, 260, 222, 13);
		panelButton.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBounds(16, 376, 222, 13);
		panelButton.add(separator_1_1_1);
		
		
		btnCustomerAccount = new JButton("Customer Account");
		btnCustomerAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCustomerAccount.setFocusable(false);
		btnCustomerAccount.setBorderPainted(false);
		btnCustomerAccount.setBackground(Color.WHITE);
		btnCustomerAccount.setBounds(10, 387, 241, 35);
		panelButton.add(btnCustomerAccount);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
		btnClientProfile.setBorderPainted(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(10, 433, 241, 35);
		panelButton.add(btnClientProfile);
		
		btnOrdering = new JButton("Ordering");
		btnOrdering.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnOrdering.setFocusable(false);
		btnOrdering.setBorderPainted(false);
		btnOrdering.setBackground(Color.WHITE);
		btnOrdering.setBounds(10, 479, 241, 35);
		panelButton.add(btnOrdering);
		
		btnDeliveryStatus = new JButton("Delivery Status");
		btnDeliveryStatus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDeliveryStatus.setFocusable(false);
		btnDeliveryStatus.setBorderPainted(false);
		btnDeliveryStatus.setBackground(Color.WHITE);
		btnDeliveryStatus.setBounds(10, 525, 241, 35);
		panelButton.add(btnDeliveryStatus);
		
		btnReturnProducts = new JButton("Return Products");
		btnReturnProducts.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnReturnProducts.setFocusable(false);
		btnReturnProducts.setBorderPainted(false);
		btnReturnProducts.setBackground(Color.WHITE);
		btnReturnProducts.setBounds(10, 571, 241, 35);
		panelButton.add(btnReturnProducts);
		
		btnAuditTrail = new JButton("Audit Trail");
		btnAuditTrail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAuditTrail.setFocusable(false);
		btnAuditTrail.setBorderPainted(false);
		btnAuditTrail.setBackground(Color.WHITE);
		btnAuditTrail.setBounds(10, 617, 241, 35);
		panelButton.add(btnAuditTrail);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 663, 241, 13);
		panelButton.add(separator_2);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(10, 670, 241, 40);
		panelButton.add(lblUsername);
		
		panelTab = new JPanel();
		panelTab.setBounds(265, 11, 989, 699);
		contentPane.add(panelTab);
		panelTab.setLayout(null);
		
	}
	
	
	private void setActionList() {
		btnDashboard.addActionListener(this);
		btnKbn.addActionListener(this);
		btnRebranding.addActionListener(this);
		btnRawMaterials.addActionListener(this);
		btnPackingMaterials.addActionListener(this);
		btnCustomerAccount.addActionListener(this);
		btnClientProfile.addActionListener(this);
		btnOrdering.addActionListener(this);
		btnDeliveryStatus.addActionListener(this);
		btnReturnProducts.addActionListener(this);
		btnAuditTrail.addActionListener(this);
		
		
		//OrderPanel
		orderPanel.btnApproved.addActionListener(this);
		orderPanel.btnDelivery.addActionListener(this);
		orderPanel.btnDeliveryComplete.addActionListener(this);
		orderPanel.btnInvoice.addActionListener(this);
		orderPanel.btnProcessComplete.addActionListener(this);
		orderPanel.btnProductionComplete.addActionListener(this);
		orderPanel.orderLPanel.lblInstruction.addMouseListener(this);
		
		//CustomerAccount Panel
		custAccount.btnCreate.addActionListener(this);
		custAccount.btnClientProfile.addActionListener(this);
		
		//KBN ProdMouseList
		kbnProd.table.addMouseListener(this);
		
		//RightClick
		
		rightClick.btnAddItem.addActionListener(this);
		rightClick.btnEdit.addActionListener(this);
		rightClick.btnArchive.addActionListener(this);
		rightClick.addKeyListener(this);
		kbnProd.table.addKeyListener(this);
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDashboard)
			dashboardPanelFunc();
		if(e.getSource() == btnKbn)
			KBNPanelFunc();
		if(e.getSource() == btnRebranding)
			rebrandProdPanelFunc();
		if(e.getSource() == btnCustomerAccount)
			custAccPanelFunc();
		if(e.getSource() == btnAuditTrail)
			AuditPanelFunc();
		if(e.getSource() == btnDeliveryStatus)
			delStatusPanelFunc();
		if(e.getSource() == btnOrdering)
			orderPanelFunc();
		if(e.getSource() == orderPanel.btnApproved)
			orderPanelBTNAPPROVED();
//		if(e.getSource() == btnPro)
			
		
		//inside Panel 
		if(e.getSource() == custAccount.btnCreate)
			custAccountCreateAccount();
		if(e.getSource() == custAccount.btnClientProfile)
			custAccountClientProfileFunc();
		
		if(e.getSource() == orderPanel.btnApproved)
			System.out.println("APPROVED");
		
		if(e.getSource() == rightClick.btnEdit)
			prodDetailsFunc();
		
		// Client Profile
		
		if(e.getSource() == btnClientProfile)
			clientProfileFunc();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == custAccount.lblNotif) {
			noticListSetter();
			preReg.setVisible(true);
		}
		if(e.getSource() == kbnProd.table) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				rightClick.setVisible(true);
				rightClick.setBounds(e.getX() + 90, e.getY() + 157, 200, 90);
			}
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == orderPanel.orderLPanel.lblInstruction) {
			orderPanelInstruction.setBounds(e.getX() + 910, e.getY() + 250, 174, 144);
			orderPanelInstruction.setVisible(true);
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == orderPanel.orderLPanel.lblInstruction) {
			orderPanelInstruction.setVisible(false);
		}
		
	}
	
	/*
	 * 
	 * 
	 *	KEY 
	 * 
	 * 
	 * 
	 */
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getSource() == kbnProd.table || e.getSource() == rightClick) {
			if(e.getKeyCode() == 27) {
				rightClick.setVisible(false);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Defaults
	
	private void setVisiblePanel() {
		dashboard.setVisible(false);
		kbnProd.setVisible(false);
		rebrandingProd.setVisible(false);
		custAccount.setVisible(false);
		auditTrail.setVisible(false);
		delStatus.setVisible(false);
		orderPanel.setVisible(false);
		cp.setVisible(false);
	}
	
	private void defaultPanel() {
		panelTab.add(dashboard);
		panelTab.add(kbnProd);
		panelTab.add(rebrandingProd);
		panelTab.add(custAccount);
		panelTab.add(auditTrail);
		panelTab.add(delStatus);
		panelTab.add(orderPanel);
		panelTab.add(cp);
		cp.scrollOrderPanel.setViewportView(cpsp);
		dashboard.setVisible(true);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
	}

	
	private void dashboardPanelFunc() {
		setVisiblePanel();
		mostSoldProd();
		chartdataSetter();
		dashboard.setVisible(true);
	}
	
	private void prodDetailsFunc() {
	    if (kbnProd.table.getSelectedRow() != -1) {
	        String ID = kbnProd.table.getValueAt(kbnProd.table.getSelectedRow(), 0) + "";
	        prodDetails.ProductDetails(ID);
	        prodDetails.setVisible(true);
	        // prodDetails.ProductDetails(ID);
	    } else {
	        JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	private void mostSoldProd() {
		try {
			String sqlAllTime = "SELECT ProdName, prodVolume, Sold FROM tblproducts ORDER BY Sold DESC LIMIT 1";
			st.execute(sqlAllTime);
			rs = st.getResultSet();
			if(rs.next())
				dashboard.lblMostSoldProd.setText("<html>" + rs.getString(1) + "(" + rs.getString(2) + ")" + "<br>Sold:" + rs.getString(3) + "</html>");
			
			int currentYear = LocalDate.now().getYear();
			int currentMonth = LocalDate.now().getMonthValue();
			String sqlMonthly = "SELECT a.prodName, a.prodVolume, SUM(c.Quantity) AS Quantity "
					+ "FROM tblproducts AS a "
					+ "JOIN tblordercheckout AS b "
					+ "JOIN tblordercheckoutdata AS c ON c.OrderRefNumber = b.OrderRefNumber AND c.ProductName = a.prodName AND c.volume = a.prodVolume "
					+ "WHERE EXTRACT(YEAR FROM b.OrderDate) = " + currentYear + " "
					+ "AND EXTRACT(MONTH FROM b.OrderDate) = " + currentMonth + " "
					+ "GROUP BY a.prodID, a.prodName, a.prodVolume "
					+ "ORDER BY SUM(c.Quantity) DESC LIMIT 1";
//			System.out.println(sqlMonthly); //debug
			st.execute(sqlMonthly);
			rs = st.getResultSet();
			if(rs.next())
				dashboard.lblMonthlyMostSold.setText("<html>" + rs.getString(1) + "(" + rs.getString(2) + ")" + "<br>Sold:" + rs.getString(3) + "</html>");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR mostSoldProd: " + e.getMessage());
		}
	}
	
	private void preRegStatus() {
		String sql = "SELECT COUNT(ID) FROM tblpreregistration WHERE Status = 'pending'";
		try {
			st.execute(sql);
			rs = st.getResultSet();
			if(rs.next())
				rowCount = rs.getInt(1);
			
			if(rowCount == 0) {
				custAccount.lblNotif.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification.png")));
			}else {
				custAccount.lblNotif.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification-red.png")));
				custAccount.lblNotif.addMouseListener(this);
			}
		} catch (Exception e) {
			
		}
	}
	
	private void preRegCounter() {
		try {
			String sql = "SELECT COUNT(ID) FROM tblpreregistration WHERE Status = 'pending'";
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				rowCount = rs.getInt(1);
			
			preReg.preReg.preRegCount(rowCount);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR preRegCounter: " + e.getMessage());
		}
	}
	
	private void orderCounter() {
		try {
			st = dbConn.getConnection().createStatement();
			String sql = "SELECT COUNT(OrderRefNumber) FROM tblordercheckout";
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				OrderCount = rs.getInt(1);
			
			orderPanel.orderLPanel.opd.iOrderCount(OrderCount);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error OrderCount: " + e.getMessage());
		}
		setOrderListData();
	}
	
	private void setOrderListData() {
		try {
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblOrderCheckout AS a JOIN tblcustomerinformation AS b ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				orderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				orderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				//status indicator
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource("/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png")));
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListData: " + e.getMessage());
		}
	}
	
	
	private void preRegMouseList() {
		for(int i = 0; i < rowCount; i++) {
			this.preReg.preReg.panel[i].addMouseListener(this);
		}
	}
	
	private void orderPanelMouseList() {
		for(int i = 0; i < OrderCount; i++) {
			this.orderPanel.orderLPanel.opd.orderList[i].addMouseListener(this);
		}
	}
	
	
    private void chartdataSetter() {
    	try {
            List<Integer> scores = new ArrayList<Integer>();
            List<String> date = new ArrayList<String>();
            int max = 0;
    		
    		st = dbConn.getConnection().createStatement();

    		String sqlMaxCounterYaxis = "SELECT SUM(a.Quantity), b.OrderDate FROM tblordercheckoutdata AS a "
    				+ "JOIN tblordercheckout AS b ON b.OrderRefNumber = a.OrderRefNumber "
    				+ "GROUP BY b.OrderDate "
    				+ "ORDER BY SUM(a.Quantity) DESC LIMIT 1";
    		
    		st.execute(sqlMaxCounterYaxis);
    		rs = st.getResultSet();
    		
    		if(rs.next())
    			max = rs.getInt(1);
            	
    		String X_axis = "SELECT SUM(a.Quantity), b.OrderDate FROM tblordercheckoutdata AS a "
    				+ "JOIN tblordercheckout AS b ON b.OrderRefNumber = a.OrderRefNumber "
    				+ "GROUP BY b.OrderDate ";
    		
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
            dashChartData.setBounds(20, 25, 563, 383);
            dashboard.chartPanel.add(dashChartData);
            

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ChartData: " + e.getMessage());
		}
    }
	
	private void KBNPanelFunc() {
		setVisiblePanel();
		kbnProd.main.setRowCount(0);
		kbnProd.table.setModel(kbnProd.main);
//        Object[] row2 = {"http://localhost/webdevelopment/thesis1_website/Products/resources/fllotion.png", "Product 1", 10, 5};
        
//        kbnProd
        
        try {
        	String sql = "SELECT prodID, prodName, Quantity, Sold FROM tblproducts";
        	st.execute(sql);
        	rs = st.getResultSet();
        	while(rs.next()) {
            	Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            	kbnProd.main.addRow(data);
//            	System.out.println(rs.getString(1));
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "KBNProducts: " + e.getMessage());
		}
		kbnProd.setVisible(true);
	}
	
	private void rebrandProdPanelFunc() {
		setVisiblePanel();
		rebrandingProd.setVisible(true);
	}
	
	private void custAccPanelFunc() {
		setVisiblePanel();
		custAccount.setVisible(true);
	}
	
	private void AuditPanelFunc() {
		setVisiblePanel();
		auditTrail.setVisible(true);
	}

	private void delStatusPanelFunc() {
		setVisiblePanel();
		delStatus.setVisible(true);
	}

	private void orderPanelFunc() {
		setVisiblePanel();
		orderCounter();
		orderPanelMouseList();
		orderPanel.setVisible(true);
	}
	
	// Client Profile
	private void clientProfileFunc() {
		if("".equals(clientProfileChecker))
			return;
		setVisiblePanel();
		cp.setVisible(true);
	}
	
	private void orderPanelBTNAPPROVED() {
		try {
			orderPanel.main.setRowCount(0);
	        orderPanel.table.setModel(orderPanel.main);
			String sql = "UPDATE tblorderstatus SET Status = 'ProcessComplete' WHERE OrderRefNumber = '" + refNum + "';";
			int i = st.executeUpdate(sql);
			if(i == 1)
				JOptionPane.showMessageDialog(null, "Reference #: " + refNum + " has been Approved");
			else
				JOptionPane.showMessageDialog(null, "Something wrong");
			panelDataSetter();
			orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR btnApproved: " + e1.getMessage());
		}
	}

	
	
	// Other class button
	
	private void custAccountCreateAccount() {
		custCreateAccount.setVisible(true);
	}
	
	private void custAccountFunc() {
		try {
            st = dbConn.getConnection().createStatement();
			String sql = "SELECT userID,Firstname, Lastname, Email, Number, Description, AccountType FROM tblcustomerinformation ORDER BY AccountType DESC";
			st.execute(sql);
			
			rs = st.getResultSet();
			ArrayList SQLResult = new ArrayList<>();
			
			while(rs.next()) {
				SQLResult.add(rs.getString(1));
				SQLResult.add(rs.getString(2) + " " + rs.getString(3));
				SQLResult.add(rs.getString(4));
				SQLResult.add(rs.getString(5));
				SQLResult.add(rs.getString(6));
				SQLResult.add(rs.getString(7));
				custAccount.main.addRow(SQLResult.toArray());
				SQLResult.clear();
			}
			custAccount.table.setModel(custAccount.main);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error CustAccFunc: " + e.getMessage());
		}
	}
	
	private void custAccountClientProfileFunc() {
		
		// {"User ID","Account","Email", "Contact", "Brand", "Account Type"}
		String userID = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 0) + "";
		String AccType = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 5) + "";
		String custName = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 1) + "";
		String custBrand = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 4) + "";
		
		if(!"rebranding".equals(AccType))
			return;
		
		clientProfileChecker = AccType;
		try {
			String RowCount = "SELECT COUNT(*) FROM tblorderstatus AS a "
					+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE b.UserID = '" + userID + "';";
			
			st.execute(RowCount);
			rs = st.getResultSet();
			
			if(rs.next())
				ClientProfileCounter = rs.getInt(1);
			
			cpsp.orderCountSetter(ClientProfileCounter);
			String arr[][] = new String[ClientProfileCounter][4];
			
			String SQLKBN = "SELECT b.OrderRefNumber, b.ProductName, SUM(b.Quantity) AS Quantity , a.Status "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status != 'Completed' AND a.Status != 'Return' "
					+ "GROUP BY b.OrderRefNumber";
			
			String SQLRebranding = "SELECT b.OrderRefNumber, b.ProductName, SUM(b.Quantity) AS Quantity , a.Status "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblrebrandingproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status != 'Completed' AND a.Status != 'Return' "
					+ "GROUP BY b.OrderRefNumber";
			
			st.execute(SQLKBN);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				arr[i][0] = rs.getString(1);
				arr[i][1] = rs.getString(2);
				arr[i][2] = rs.getString(3);
				arr[i][3] = rs.getString(4);
				i++;
			}
			
			st.execute(SQLRebranding);
			rs = st.getResultSet();
			while(rs.next()) {
				arr[i][0] = rs.getString(1);
				arr[i][1] = rs.getString(2);
				arr[i][2] = rs.getString(3);
				arr[i][3] = rs.getString(4);
				i++;
			}
			System.out.println("arrCount: " + i);
			System.out.println("ClientProfileCounter: " + ClientProfileCounter);
			
			for(int j = 0; j < i; j++) {
				cpsp.lblRefNumber[j].setText(arr[j][0]);
				cpsp.lblProdName[j].setText(arr[j][1]);
				cpsp.lblQuantity[j].setText(arr[j][2]);
				cpsp.lblStatus[j].setText(arr[j][3]);
				System.out.println(j);
			}
			

			clientProfileFunc();
			
			//Setting Customer Profile
			cp.lblClientName.setText(custName);
			cp.lblBrand.setText(custBrand);
			cp.lblNone.setText("");
			
			
			//SQL Getting this week Quantity

	        ClientProfileWeekly(userID);
	        

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CustAccountClientProfile ERROR:" + e.getMessage());
		}
	}
	
	private void ClientProfileWeekly(String userID) {
		try {
			
			double thisWeek = 0;
			double lastWeek = 1;
	        LocalDate mondayOfLastWeek = today.minusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	        LocalDate sundayOfLastWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	        LocalDate mondaythisWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
					
			//			String thisWeekCount = "SELECT b.OrderRefNumber, SUM(b.Quantity), a.OrderDate "
			//			+ "FROM tblordercheckout AS a "
			//			+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
			//			+ "WHERE a.OrderDate >= '" + mondaythisWeek + "' AND a.userID = '" + userID + "'"
			//			+ "GROUP BY b.OrderRefNumber";
	        
			//	String lastWeekCount = "SELECT b.OrderRefNumber, SUM(b.Quantity), a.OrderDate "
			//			+ "FROM tblordercheckout AS a "
			//			+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
			//			+ "WHERE a.OrderDate >= '" + mondayOfLastWeek + "'  AND a.OrderDate <= '" + sundayOfLastWeek + "' AND a.userID = '" + userID + "' "
			//			+ "GROUP BY b.OrderRefNumber";
		    
			String thisWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondaythisWeek + "' AND a.userID = '" + userID + "'";
			
			String lastWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondayOfLastWeek + "'  AND a.OrderDate <= '" + sundayOfLastWeek + "' AND a.userID = '" + userID + "'";
			
			// This Week
			st.execute(thisWeekCount);
			rs = st.getResultSet();
			
			if(rs.next())
				thisWeek = rs.getInt(1);
			
			// Last Week
			st.execute(lastWeekCount);
			rs = st.getResultSet();
			
			if(rs.next())
				lastWeek = rs.getInt(1);
			
			// Formula
			double formulaWeekly = ((thisWeek / lastWeek) * 100) - 100;
			cp.lblWeeklyPercent.setText((int)formulaWeekly + "%");
			if(formulaWeekly < 0 || Double.isNaN(formulaWeekly)) {
				cp.lblPercentIconWeekly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/low-price.png")));
				cp.lblTextWeekly.setText("<html><center>Lower Than<br> Last</center></html>");
			}
			else {
				cp.lblPercentIconWeekly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/high-price.png")));
				cp.lblTextWeekly.setText("<html><center>Higher Than<br> Last</center></html>");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CustAccountClientProfileWEEKLY ERROR:" + e.getMessage());
		}// END OF TRY CATCH
	}// END OF WEEKLY
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
        Component clickedComponent = e.getComponent();
        for (int i = 0; i < OrderCount; i++) {
            if (clickedComponent == this.orderPanel.orderLPanel.opd.orderList[i]) {
            	OrderListIndexClicked = i;
                orderPanel.main.setRowCount(0);
                orderPanel.table.setModel(orderPanel.main);
                panelDataSetter();
                break;
            }
        }
        
        for(int i = 0; i < rowCount; i++) {
        	if(clickedComponent == this.preReg.preReg.panel[i]) {
        		preRegDataSetter(i);
        	}
        }
        
	}
	
	private void preRegDataSetter(int index) {
		regID = preReg.preReg.rowID.get(index).toString();
		System.out.println(regID); // debugging
		try {
			String sql = "SELECT Firstname, Middlename, Lastname, Contactnum, Emailadd, Street, Barangay, City, Province, Brand FROM tblpreregistration WHERE ID = '" + regID + "'";
			
			String FName = "";
			String MName = "";
			String LName = "";
			String Contact = "";
			String Email = "";
			String Address = "";
			String Brand = "";
			
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				FName = rs.getString(1);
				MName = rs.getString(2);
				LName = rs.getString(3);
				Contact = rs.getString(4);
				Email = rs.getString(5);
				Address = rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) + ", " + rs.getString(9);
				Brand = rs.getString(10);
			}

			preReg.reg.txtLN.setText(LName);
			preReg.reg.txtFN.setText(FName);
			preReg.reg.txtMI.setText(MName);
			preReg.reg.txtContact.setText(Contact);
			preReg.reg.txtEmail.setText(Email);
			preReg.reg.txtAddress.setText(Address);
			preReg.reg.txtBrand.setText(Brand);

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "preRegDataSetter ERROR: " + e.getMessage());
		}
	}
	
	private void panelDataSetter() {
		try {
			refNum = this.orderPanel.orderLPanel.opd.lblRefNumber[OrderListIndexClicked].getText();
	        orderPanel.lblRefNum.setText(refNum);
	        orderPanel.lblCustName.setText(this.orderPanel.orderLPanel.opd.lblName[OrderListIndexClicked].getText());
	        String sql = "SELECT a.OrderRefNumber, a.OrderDate, b.ProductName, b.Quantity, b.Price, (b.Quantity*b.Price) As Total, a.Address, c.Discount FROM tblordercheckout AS a JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber JOIN tblcustomerinformation AS c ON a.UserID = c.UserID WHERE a.OrderRefNumber = '" + refNum + "'";
	        st.execute(sql);
	        rs = st.getResultSet();
	        ArrayList tableData = new ArrayList<>();

	        int TotalQuantity = 0;
	        int TotalDiscount = 0;
	        int TotalAmount = 0;
	        while(rs.next()) {
	        	orderPanel.lblOrderD.setText(rs.getString(2));
	        	orderPanel.lblAdd.setText(rs.getString(7));
	        	tableData.add(rs.getString(3));
	        	tableData.add(rs.getString(4));
	        	tableData.add(rs.getString(5));
	        	tableData.add(rs.getString(8));
	        	tableData.add(rs.getString(6));
	        	orderPanel.main.addRow(tableData.toArray());
	        	tableData.clear();
	        	TotalQuantity += Integer.parseInt(rs.getString(4));
	        	TotalDiscount += Integer.parseInt(rs.getString(8));
	        	TotalAmount += Integer.parseInt(rs.getString(6));
	        }
	        

	        int TotalItem = orderPanel.table.getRowCount();
	        
	        orderPanel.lblItemCount.setText("Item: " + TotalItem);
	        orderPanel.lblQuantityCount.setText("Total Quantity: " + TotalQuantity);
	        orderPanel.lblDiscount.setText("Total Discount: " + TotalItem);
	        orderPanel.lblTotalAmount.setText("Total Amount: " + TotalAmount);
	  
	        orderStatusSetter();
	        
		}catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR panelDataSetter: " + e.getMessage());
		}
	}
	
	private void orderStatusSetter() {
		try {
			orderPanel.btnApproved.setBackground(Color.white);
			orderPanel.btnDelivery.setBackground(Color.white);
			orderPanel.btnDeliveryComplete.setBackground(Color.white);
			orderPanel.btnInvoice.setBackground(Color.white);
			orderPanel.btnProcessComplete.setBackground(Color.white);
			orderPanel.btnProductionComplete.setBackground(Color.white);
			
			
	        String sqlOrderStatus = "SELECT status FROM tblOrderStatus WHERE OrderRefNumber = '" + refNum + "'";
	        st.execute(sqlOrderStatus);
	        rs = st.getResultSet();
	        String status = "";
	        while(rs.next()) {
	        	status = rs.getString(1);
	        }
	        
	        if(status.equals("toPay")) {
	        	
	        }
	        else if(status.equals("OrderApproved")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        }
	        else if(status.equals("ProcessComplete")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProcessComplete.setBackground(new Color(13, 164, 0));
	        }else if(status.equals("ProductionComplete")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProcessComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProductionComplete.setBackground(new Color(13, 164, 0));
	        }else if(status.equals("Delivery")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProcessComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProductionComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        }else if(status.equals("DeliveryComplete")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProcessComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProductionComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDeliveryComplete.setBackground(new Color(13, 164, 0));
	        }else if(status.equals("Invoice")) {
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProcessComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnProductionComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDeliveryComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnInvoice.setBackground(new Color(13, 164, 0));
	        }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR ORDER STATUS: " + e.getMessage());
		}
	}

	private void noticListSetter() {
		try {
			preReg = new preRegister();
			preRegCounter();
			preRegMouseList();
			String sql = "SELECT ID, FirstName, MiddleName, LastName, Brand, City, Province FROM tblpreregistration WHERE status = 'pending'";
			st.execute(sql);
			rs = st.getResultSet();
			int initialRow = 0;
			while(rs.next()) {
				preReg.preReg.rowID.add(rs.getString(1));
				preReg.preReg.lblName[initialRow].setText(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				preReg.preReg.lblBrand[initialRow].setText(rs.getString(5));
				preReg.preReg.lblAddress[initialRow].setText(rs.getString(6) + ", " + rs.getString(7));
				initialRow++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error NotifSetter: " + e.getMessage());
		}
	}
}
