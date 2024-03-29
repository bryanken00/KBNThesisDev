package KBN.views;

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
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
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

import KBN.Module.Marketing.ModuleSelectionMarketing;
import KBN.Module.Marketing.AuditTrail.AuditTrail;
import KBN.Module.Marketing.ClientProfile.AddProduct;
import KBN.Module.Marketing.ClientProfile.ClientProfile;
import KBN.Module.Marketing.ClientProfile.ClientProfileScrollablePanel;
import KBN.Module.Marketing.ClientProfile.OrderHistory;
import KBN.Module.Marketing.ClientProfile.UpdateProduct;
import KBN.Module.Marketing.ClientProfile.rebrandingProductsList;
import KBN.Module.Marketing.ConfirmationProduct.ConfirmationListPanel;
import KBN.Module.Marketing.ConfirmationProduct.ConfirmationListPanelData;
import KBN.Module.Marketing.ConfirmationProduct.ConfirmationPanel;
import KBN.Module.Marketing.Customer.CustomerAccount;
import KBN.Module.Marketing.Customer.CustomerCreateAccount;
import KBN.Module.Marketing.Delivery.DeliveryDetails;
import KBN.Module.Marketing.Delivery.DeliveryStatus;
import KBN.Module.Marketing.Delivery.DeliveryStatusTable1;
import KBN.Module.Marketing.Delivery.DeliveryStatusTable2;
import KBN.Module.Marketing.KBNProducts.AccountSetting;
import KBN.Module.Marketing.KBNProducts.KBNProducts;
import KBN.Module.Marketing.KBNProducts.ProductDetails;
import KBN.Module.Marketing.KBNProducts.RightClick;
import KBN.Module.Marketing.OrderingPanel.OrderListPanelData;
import KBN.Module.Marketing.OrderingPanel.OrderPanelPopupInstruction;
import KBN.Module.Marketing.OrderingPanel.OrderingCancel;
import KBN.Module.Marketing.OrderingPanel.OrderingPanel;
import KBN.Module.Marketing.OrderingPanel.onDelivery;
import KBN.Module.Marketing.RebrandingNew.RebrandingNew;
import KBN.Module.Marketing.RebrandingNew.RebrandingRightClick;
import KBN.Module.Marketing.RebrandingProducts.ClientProducts;
import KBN.Module.Marketing.RebrandingProducts.RebrandingProd;
import KBN.Module.Marketing.RebrandingProducts.panelGenerator;
import KBN.Module.Marketing.ReturnProducts.ReturnDetails;
import KBN.Module.Marketing.ReturnProducts.ReturnProductPanel;
import KBN.Module.Marketing.ReturnProducts.Status;
import KBN.Module.Marketing.dashboard.Dashboard;
import KBN.Module.Marketing.dashboard.Dashboard1;
import KBN.Module.Marketing.dashboard.DashboardSalesChartData;
import KBN.Module.Marketing.preRegis.Registration;
import KBN.Module.Marketing.preRegis.preRegList;
import KBN.Module.Marketing.preRegis.preRegister;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;


public class MarketingModule extends JFrame implements ActionListener, MouseListener, KeyListener, ItemListener, PropertyChangeListener{

	//Class Import
	private DbConnection dbConn;
	private dataSetter dataSet;
	
	// Dashboard
	private Dashboard1 dashboard1;
	private OrderListPanelData opdDashboard;

	// Module
	private ProductionModule productionModule;
	private WarehouseModule_1 warehouseModule;
	private ModuleSelectionMarketing moduleSelection;
	
	//KBN Products
	private KBNProducts kbnProd;
	private String kbnProdButtonChecker = "Products";
	private String rebrandingProdButtonChecker = "Products";
	
	//Rebranding new
	private RebrandingNew rebrandingNew;
		
	// Return Products
	private ReturnProductPanel returnProd;
	private ReturnDetails returnDetails;
	
	private CustomerAccount custAccount;
	private AuditTrail auditTrail;
	private CustomerCreateAccount custCreateAccount;
	private OrderingPanel orderPanel;
	private OrderingCancel cancelOrderPanel;
	private preRegister preReg;
	private RightClick rightClick;
	private RebrandingRightClick rRightClick;
	private ProductDetails prodDetails;
	private OrderPanelPopupInstruction orderPanelInstruction;
	private onDelivery onDeliver;
	
	//Client Profile
	private ClientProfile cp;
	private ClientProfileScrollablePanel cpsp;
	private OrderHistory orderHistory;
	private rebrandingProductsList rp;
	private AddProduct addProduct;
	private UpdateProduct updateProduct;
	
	//deliveries
	private DeliveryStatus delStatus;
	private DeliveryDetails delDetails;
	private DeliveryStatusTable1 dTB1;
	private DeliveryStatusTable2 dTB2;
	private String TableChecher = "dTB1";
	
	//prod Confirmation
	private ConfirmationPanel confirmationPanel;
	private ConfirmationListPanel confirmListPanel;
	private ConfirmationListPanelData confirmListPanelData;
	
	private int confirmationCounter = 0;
	
	// Object
	private Statement st;
	private ResultSet rs;
	
	// Date Formatter
	private SimpleDateFormat inputFormat;
	private SimpleDateFormat outputFormat;
	
	// Righclick Change password
	private AccountSetting accSetting;
	private Changepassword changepassPanel;
	
	
	//Client Profile
	private String clientProfileChecker = "";
	private String uID = ""; // User ID
	private String custN = ""; // Name
	private String custB = ""; // Brand
	
	private JButton btnChecker;
	
	
	private String refNum;
	public static String regID;
	private LocalDate today;
	
	//Time diff
	String sqlTimeDiff;
	
	// Account Level
	private String AccountLevel = "";
	private String accountID = "";
	
	private JPanel contentPane;
	private JPanel panelButton;
	private JButton btnDashboard;
	private JLabel lblUsername;
	private JButton btnKbn;
	private JButton btnRebranding;
	private JButton btnCanncelledOrder;
	private JButton btnConfirmation;
	private JButton btnCustomerAccount;
	private JButton btnClientProfile;
	private JButton btnOrdering;
	private JButton btnDeliveryStatus;
	private JButton btnReturnProducts;
	private JButton btnAuditTrail;
	private JPanel panelTab;
	
	//Client profile
	private int orderCountClickIndex = 0;
	private int orderhistoryClickIndex = 0;
	private int ownProductClickIndex = 0;
	

	private DashboardSalesChartData dashChartData;
	
	
	private int OrderListIndexClicked;
	private int CancelOrderListIndexClicked;
	private int ConfirmProductList;
	private String orderClickIdentifier = "";
	private String cancelorderClickIdentifier = "";
	
	private int OrderCount = 0; // Order List	
	private int CancelOrderCount = 0; // Cancel Order List
	private int OrderCountDash = 0; // Order List
	private int orderBTNClickCount = 0;
	private int cancelorderBTNClickCount = 0;
	private int rowCount = 0; // Pre - Registration
	private int ClientProfileCounter; // Client Profile OrderList
	private int ClientProfileCounterHistory; // Client Profile HistoryList
	private int OwnProdCount;

	public MarketingModule() {
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
        
        // Modules
    	moduleSelection = new ModuleSelectionMarketing();
		getContentPane().add(moduleSelection);
		moduleSelection.setVisible(false);
    	
        
        // Date Formatter
        inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        outputFormat = new SimpleDateFormat("yyyy-MM-dd");
//        sqlTimeDiff = "SELECT TIMESTAMPDIFF(HOUR, NOW(), OrderDate) AS HoursDifference, TIMESTAMPDIFF(MINUTE, OrderDate, NOW()) AS MinutesDifference FROM tblordercheckout ORDER BY OrderDate DESC LIMIT 1";
        sqlTimeDiff = "SELECT TIMESTAMPDIFF(HOUR, NOW(), a.OrderDate) AS HoursDifference, TIMESTAMPDIFF(MINUTE, a.OrderDate, NOW()) AS MinutesDifference\r\n"
        		+ "FROM tblordercheckout AS a\r\n"
        		+ "JOIN tblorderstatus As b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
        		+ "WHERE b.Status = 'toPay'\r\n"
        		+ "ORDER BY OrderDate DESC LIMIT 1;";
        
//        System.out.println(sqlTimeDiff);
        
        
        // Declaration
        dbConn = new DbConnection();
        try {
            st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error ST: " + e.getMessage());
		}
		dashboard1 = new Dashboard1();
		opdDashboard = new OrderListPanelData();
		dashboard1.orderList.setViewportView(opdDashboard);
		// KBNProducts
		kbnProd = new KBNProducts();
		
		// Rebranding New
		rebrandingNew = new RebrandingNew();
		
    	// Return Products
    	returnProd = new ReturnProductPanel();
    	returnDetails = new ReturnDetails();
		
		custAccount = new CustomerAccount();
		auditTrail = new AuditTrail();
		custCreateAccount = new CustomerCreateAccount();
		
		//Deliveries
		delStatus = new DeliveryStatus();
		delDetails = new DeliveryDetails();
		dTB1 = new DeliveryStatusTable1();
		dTB2 = new DeliveryStatusTable2();
		
		// orderingPanel
		orderPanel = new OrderingPanel();
		cancelOrderPanel = new OrderingCancel();
		onDeliver = new onDelivery();
		
		// Confirmation Panel
		confirmationPanel = new ConfirmationPanel();
		confirmListPanel = new ConfirmationListPanel();
		confirmationPanel.confirmPanel.add(confirmListPanel);
		
		preReg = new preRegister();
		// Start Right Click
		rightClick = new RightClick();
			getContentPane().add(rightClick);
			rightClick.setVisible(false);
		
		accSetting = new AccountSetting();
		changepassPanel = new Changepassword();
			getContentPane().add(accSetting);
			accSetting.setVisible(false);
			
		rRightClick = new RebrandingRightClick();
			getContentPane().add(rRightClick);
			rRightClick.setVisible(false);
		// End Right Click
		
		// Client Profile Tab
		cp = new ClientProfile();
		cpsp = new ClientProfileScrollablePanel();
		orderHistory = new OrderHistory();
		rp = new rebrandingProductsList();
		addProduct = new AddProduct();
			
		prodDetails = new ProductDetails();
		orderPanelInstruction = new OrderPanelPopupInstruction();
		
		today = LocalDate.now();
		
		
        // DefaultSetup
        objComponent();
        setUsername();
//        orderCounter();
        setActionList();
        setVisiblePanel();
        defaultPanel();
//        mostSoldProd();
		dashboard1();
		btnChecker = btnDashboard;
		
		marketingButtons();
		
	}
	
	private void objComponent() {
		panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelButton.setBackground(Color.WHITE);
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
		btnDashboard.setBackground(new Color(75, 119, 71));
		btnDashboard.setHorizontalTextPosition(JLabel.CENTER);
		btnDashboard.setVerticalTextPosition(JLabel.CENTER);
		btnDashboard.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDashboard.setFocusable(false);
		btnDashboard.setForeground(Color.WHITE);
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
		btnKbn.setEnabled(false);
		btnKbn.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnKbn.setFocusable(false);
		btnKbn.setBackground(Color.WHITE);
		btnKbn.setBounds(10, 168, 241, 35);
		panelButton.add(btnKbn);
		
		btnRebranding = new JButton("Rebranding");
		btnRebranding.setEnabled(false);
		btnRebranding.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRebranding.setFocusable(false);
		btnRebranding.setBackground(Color.WHITE);
		btnRebranding.setBounds(10, 214, 241, 35);
		panelButton.add(btnRebranding);
		
		btnCanncelledOrder = new JButton("Cancelled Order");
		btnCanncelledOrder.setEnabled(false);
		btnCanncelledOrder.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCanncelledOrder.setFocusable(false);
		btnCanncelledOrder.setBackground(Color.WHITE);
		btnCanncelledOrder.setBounds(10, 508, 241, 35);
		panelButton.add(btnCanncelledOrder);
		
		btnConfirmation = new JButton("Confirmation Products");
		btnConfirmation.setEnabled(false);
		btnConfirmation.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnConfirmation.setFocusable(false);
		btnConfirmation.setBackground(Color.WHITE);
		btnConfirmation.setBounds(10, 370, 241, 35);
		panelButton.add(btnConfirmation);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(16, 260, 222, 7);
		panelButton.add(separator_1_1);
		
		
		btnCustomerAccount = new JButton("Customer Account");
		btnCustomerAccount.setEnabled(false);
		btnCustomerAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCustomerAccount.setFocusable(false);
		btnCustomerAccount.setBackground(Color.WHITE);
		btnCustomerAccount.setBounds(10, 278, 241, 35);
		panelButton.add(btnCustomerAccount);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setEnabled(false);
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(10, 324, 241, 35);
		panelButton.add(btnClientProfile);
		
		btnOrdering = new JButton("Ordering");
		btnOrdering.setEnabled(false);
		btnOrdering.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnOrdering.setFocusable(false);
		btnOrdering.setBackground(Color.WHITE);
		btnOrdering.setBounds(10, 416, 241, 35);
		panelButton.add(btnOrdering);
		
		btnDeliveryStatus = new JButton("Delivery Status");
		btnDeliveryStatus.setEnabled(false);
		btnDeliveryStatus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDeliveryStatus.setFocusable(false);
		btnDeliveryStatus.setBackground(Color.WHITE);
		btnDeliveryStatus.setBounds(10, 462, 241, 35);
		panelButton.add(btnDeliveryStatus);
		
		btnReturnProducts = new JButton("Return Products");
		btnReturnProducts.setEnabled(false);
		btnReturnProducts.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnReturnProducts.setFocusable(false);
		btnReturnProducts.setBackground(Color.WHITE);
		btnReturnProducts.setBounds(10, 554, 241, 35);
		panelButton.add(btnReturnProducts);
		
		btnAuditTrail = new JButton("Audit Trail");
		btnAuditTrail.setEnabled(false);
		btnAuditTrail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAuditTrail.setFocusable(false);
		btnAuditTrail.setBackground(Color.WHITE);
		btnAuditTrail.setBounds(10, 600, 241, 35);
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

		btnDashboard.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnKbn.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRebranding.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCanncelledOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConfirmation.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCustomerAccount.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnClientProfile.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOrdering.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeliveryStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnReturnProducts.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAuditTrail.setBorder(new LineBorder(new Color(0, 0, 0)));
		
	}
	
	private void marketingButtons() {
		
		if(AccountLevel.equals("Staff-Marketing-Inventory and Ordering")) {
			btnOrdering.setEnabled(true);
			
		}else if(AccountLevel.equals("Admin--") || AccountLevel.equals("Manager-Marketing-All") || AccountLevel.equals("SuperAdmin--")) {
			btnKbn.setEnabled(true);
			btnRebranding.setEnabled(true);
			
			btnConfirmation.setEnabled(true);
			btnCanncelledOrder.setEnabled(true);
			
			btnCustomerAccount.setEnabled(true);
			btnClientProfile.setEnabled(true);
			btnOrdering.setEnabled(true);
			btnDeliveryStatus.setEnabled(true);
			btnReturnProducts.setEnabled(true);
			btnAuditTrail.setEnabled(true);
		}
	}
	
	private void setActionList() {
		btnDashboard.addActionListener(this);
		btnKbn.addActionListener(this);
		btnRebranding.addActionListener(this);
		btnCanncelledOrder.addActionListener(this);
		btnConfirmation.addActionListener(this);
		btnCustomerAccount.addActionListener(this);
		btnClientProfile.addActionListener(this);
		btnOrdering.addActionListener(this);
		btnDeliveryStatus.addActionListener(this);
		btnReturnProducts.addActionListener(this);
		btnAuditTrail.addActionListener(this);
		
		btnDashboard.addMouseListener(this);
		btnKbn.addMouseListener(this);
		btnRebranding.addMouseListener(this);
		btnCanncelledOrder.addMouseListener(this);
		btnConfirmation.addMouseListener(this);
		btnCustomerAccount.addMouseListener(this);
		btnClientProfile.addMouseListener(this);
		btnOrdering.addMouseListener(this);
		btnDeliveryStatus.addMouseListener(this);
		btnReturnProducts.addMouseListener(this);
		btnAuditTrail.addMouseListener(this);
		
		// Audit Trail
		auditTrail.btnSearch.addActionListener(this);
		auditTrail.dateChooser.getDateEditor().addPropertyChangeListener(this);
		
		//OrderPanel
		orderPanel.btnApproved.addActionListener(this);
		orderPanel.btnToShip.addActionListener(this);
//		orderPanel.btnDelivery.addActionListener(this);
		orderPanel.btnDeliveryComplete.addActionListener(this);
		orderPanel.btnInvoice.addActionListener(this);
		orderPanel.orderLPanel.lblInstruction.addMouseListener(this);
		onDeliver.btnConfirm.addActionListener(this);
		orderPanel.orderLPanel.btnSearch.addActionListener(this);
		orderPanel.cbCategory.addItemListener(this);
		
		//Cancel
		cancelOrderPanel.orderLPanel.btnSearch.addActionListener(this);
		cancelOrderPanel.cbCategory.addItemListener(this);
		
		//CustomerAccount Panel
		custAccount.btnCreate.addActionListener(this);
		custAccount.btnClientProfile.addActionListener(this);
		custAccount.btnSearch.addActionListener(this);
		
		//KBN ProdMouseList
		kbnProd.table.addMouseListener(this);
		rebrandingNew.table.addMouseListener(this);
		
		//Return Products
		returnProd.btnUpdateStatus.addActionListener(this);
		returnProd.btnView.addActionListener(this);
		
		//KBNProducts Panel
		kbnProd.btnProducts.addActionListener(this);
		kbnProd.btnArchive.addActionListener(this);
		kbnProd.btnSearch.addActionListener(this);
		
		kbnProd.btnAddNewProduct.addActionListener(this);
		kbnProd.btnEditDetails.addActionListener(this);
		kbnProd.btnArchive_1.addActionListener(this);
		
		//Rebranding Panel
		rebrandingNew.btnProducts.addActionListener(this);
		rebrandingNew.btnArchive.addActionListener(this);
		rebrandingNew.btnSearch.addActionListener(this);
		rebrandingNew.btnArchiveProduct.addActionListener(this);
		
		//RightClick
		rightClick.btnAddItem.addActionListener(this);
		rightClick.btnEdit.addActionListener(this);
		rightClick.btnArchive.addActionListener(this);
		rightClick.addKeyListener(this);
		kbnProd.table.addKeyListener(this);

		rRightClick.btnArchive.addActionListener(this);
		rRightClick.addKeyListener(this);
		rebrandingNew.table.addKeyListener(this);
		
		
			// Module Selection
		lblUsername.addMouseListener(this);
		lblUsername.addKeyListener(this);
		moduleSelection.addKeyListener(this);
		moduleSelection.btnProductionModule.addActionListener(this);
		moduleSelection.btnWarehouseModule.addActionListener(this);
		moduleSelection.btnChange.addActionListener(this);
		accSetting.btnEditPassword.addActionListener(this);
		
		
		// Client Profile
		cp.lblOrderHistory.addMouseListener(this);
		cp.lblOrders.addMouseListener(this);
		cp.lblProducts.addMouseListener(this);
		cp.lblAddProduct.addMouseListener(this);
		
		//Delivery
		delStatus.btnListOfDelivery.addActionListener(this);
		delStatus.btnCompleted.addActionListener(this);
		delStatus.btnSearch.addActionListener(this);
		delStatus.btnDeliveryDetails.addActionListener(this);
		
		// Confirmation Product
		confirmationPanel.btnConfirm.addActionListener(this);
		confirmListPanel.comboBox.addItemListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		rightClick.setVisible(false);
		rRightClick.setVisible(false);
		moduleSelection.setVisible(false);
		
		if(e.getSource() == btnDashboard)
			dashboardPanelFunc();
		
		//KBN Products
		if(e.getSource() == btnKbn)
			KBNPanelFunc();
		if(e.getSource() == kbnProd.btnProducts)
			KBNPanelFunc();
		if(e.getSource() == kbnProd.btnArchive)
			KBNPanelFuncArchive();
		if(e.getSource() == kbnProd.btnSearch)
			KBNPanelFuncSearch(kbnProd.txtSearchBar.getText());
			
		if(e.getSource() == btnRebranding)
			rebrandingNewPanelFunc();
		if(e.getSource() == rebrandingNew.btnProducts)
			rebrandingNewPanelFunc();
		if(e.getSource() == rebrandingNew.btnArchive)
			rebrandingNewPanelFuncArchive();
		if(e.getSource() == rebrandingNew.btnSearch)
			RebrandingPanelFuncSearch(rebrandingNew.txtSearchBar.getText());
		
		
		if(e.getSource() == btnCustomerAccount)
			custAccPanelFunc();
		
		// Audit Trail
		if(e.getSource() == btnAuditTrail)
			AuditPanelFunc();
		if(e.getSource() == auditTrail.btnSearch)
			auditButton(auditTrail.txtSearchBar.getText());
		
		//Delivery
		if(e.getSource() == btnDeliveryStatus)
			DeliveryFuncDefault();
		if(e.getSource() == delStatus.btnListOfDelivery)
			DeliveryFuncDefault();
		if(e.getSource() == delStatus.btnCompleted)
			DeliveryFuncCompleted();
		if(e.getSource() == delStatus.btnSearch)
			DeliveryFuncSearch(delStatus.txtSearchbar.getText());
		if(e.getSource() == delStatus.btnDeliveryDetails)
			DeliveryDetailsFunc();
		
		//Ordering
		if(e.getSource() == btnOrdering)
			orderPanelFunc();
		if(e.getSource() == btnCanncelledOrder)
			cancelOrderPanelFunc();
		if(e.getSource() == orderPanel.btnApproved)
			orderPanelBTNAPPROVED();
		if(e.getSource() == orderPanel.btnToShip)
			orderpanelBTNTOSHIP();
		if(e.getSource() == orderPanel.btnDelivery)
			orderPanelBTNDELIVERY(refNum);
		if(e.getSource() == onDeliver.btnConfirm)
			setDeliveryRider();
		if(e.getSource() == orderPanel.orderLPanel.btnSearch)
			orderPanelSearch();
		if(e.getSource() == cancelOrderPanel.orderLPanel.btnSearch)
			cancelorderPanelFuncSearch();
		
		// Return Products
		if(e.getSource() == btnReturnProducts)
			returnProductFunc();
		
		if(e.getSource() == returnProd.btnView)
			returnViewDetails();
		if(e.getSource() == returnProd.btnUpdateStatus)
			returnUpdateStatus();
		
		//inside Panel 
		if(e.getSource() == custAccount.btnCreate)
			custAccountCreateAccount();
		if(e.getSource() == custAccount.btnClientProfile)
			custAccountClientProfileFunc();
		if(e.getSource() == custAccount.btnSearch) {
			if(!custAccount.txtSearchBar.getText().equals("Search by Account"))
				custAccountSearchFunc(custAccount.txtSearchBar.getText());
			else
				custAccPanelFunc();
		}
		
		
		// Module Selection
		if(e.getSource() == moduleSelection.btnProductionModule) {
			productionModule = new ProductionModule();
			productionModule.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == moduleSelection.btnWarehouseModule) {
			warehouseModule = new WarehouseModule_1();
			warehouseModule.setVisible(true);
			this.dispose();
		}
		
		//Right Click
		if(e.getSource() == rightClick.btnEdit || e.getSource() == kbnProd.btnEditDetails)
			prodDetailsFunc();
		if(e.getSource() == rightClick.btnArchive || e.getSource() == kbnProd.btnArchive_1)
			archiveKBNProducts();
		if(e.getSource() == rightClick.btnAddItem || e.getSource() == kbnProd.btnAddNewProduct)
			addItem();
		
		if(e.getSource() == moduleSelection.btnChange || e.getSource() == accSetting.btnEditPassword) {
			changepassPanel.setAccID(accountID);
			changepassPanel.setVisible(true);
		}
		
		if(e.getSource() == rRightClick.btnArchive || e.getSource() == rebrandingNew.btnArchiveProduct)
			rebrandingarchiveKBNProducts();
		
		
		// Confirmation Panel
		if(e.getSource() == btnConfirmation)
			confrimationPanelFunc();
		if(e.getSource() == confirmationPanel.btnConfirm)
			confirmButtonFunc();
		
		// Client Profile
		if(e.getSource() == btnClientProfile)
			clientProfileFunc();
		
		if(cpsp.btnProcessOrder != null) {
			orderPanel.table.removeAll();
			for (int i = 0; i < cpsp.btnProcessOrder.length; i++) {
				if (e.getSource() == cpsp.btnProcessOrder[i]) {
					refNum = cpsp.lblRefNumber[i].getText();
					orderPanelFunc();
                    orderPanel.main.setRowCount(0);
                    orderPanel.table.setModel(orderPanel.main);
                    orderClickIdentifier = "cust";
                    panelDataSetter();
                    orderClickIdentifier = "";
			        break;
			    }
			}
		}else {
			orderPanel.table.removeAll();
		}
		
		if(orderHistory.btnProcessOrder != null) {
			orderPanel.table.removeAll();
			for (int i = 0; i < orderHistory.btnProcessOrder.length; i++) {
				if (e.getSource() == orderHistory.btnProcessOrder[i]) {
					refNum = orderHistory.lblRefNumber[i].getText();
					orderPanelFunc();
                    orderPanel.main.setRowCount(0);
                    orderPanel.table.setModel(orderPanel.main);
                    orderClickIdentifier = "cust";
                    panelDataSetter();
                    orderClickIdentifier = "";
			        break;
			    }
			}
		}
		
		if(rp.btnProcessOrder != null) {
			for(int i = 0; i < rp.btnProcessOrder.length; i++) {
				if(e.getSource() == rp.btnProcessOrder[i]) {
					updateProduct = new UpdateProduct();
					updateProduct.setUserID(uID);
					updateProduct.renderCategories();
					updateProduct.setProductID(rp.prodID[i]);
					updateProduct.setdata();
					updateProduct.setVisible(true);
					break;
				}
			}
		}
	}
	

	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == kbnProd.table) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				rightClick.setVisible(true);
				rightClick.setBounds(e.getX() + 90, e.getY() + 157, 200, 90);
			}
		}
		
		if(e.getSource() == rebrandingNew.table) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				rRightClick.setVisible(true);
				rRightClick.setBounds(e.getX() + 90, e.getY() + 157, 200, 90);
			}
		}
		
		if(e.getSource() == cp.lblOrders) {
			cpsp = new ClientProfileScrollablePanel();
			cp.scrollOrderPanel.setViewportView(cpsp);
			
			// OrderList printing
			clientProfileOrderListRefresher(uID, custN,custB);
			clientProfileOrderListActionList();
		}
		if(e.getSource() == cp.lblOrderHistory) {
			orderHistory = new OrderHistory();
			cp.scrollOrderPanel.setViewportView(orderHistory);
			clientProfileOrderHistoryRefresher(uID, custN,custB);
			clientProfileOrderHistoryActionlist();
		}
		if(e.getSource() == cp.lblProducts) {
			clientProfileOwnProductsRefresher(uID);
			
			if(rp.btnProcessOrder != null)
				clientProfileProductListRemove();
			
			clientProfileProductListAdd();
			cp.scrollOrderPanel.setViewportView(rp);
		}
		if(e.getSource() == cp.lblAddProduct) {
			addProduct.setUserID(uID);
			addProduct.renderCategories();
			addProduct.setVisible(true);
		}
		
		if(e.getComponent() instanceof JButton) {
			if(e.getComponent().isEnabled()) {
				NavBTNDefault();
				Component c = e.getComponent();
				btnChecker = (JButton) e.getComponent();
				if(btnChecker == c) {
					((JButton)c).setBackground(new Color(75, 119, 71));
					((JButton)c).setForeground(Color.WHITE);
				}
			}
		}else
			return;
	}
	
	private void NavBTNDefault() {
		btnDashboard.setBackground(Color.WHITE);
		btnKbn.setBackground(Color.WHITE);
		btnRebranding.setBackground(Color.WHITE);
		btnCanncelledOrder.setBackground(Color.WHITE);
		btnConfirmation.setBackground(Color.WHITE);
		btnCustomerAccount.setBackground(Color.WHITE);
		btnClientProfile.setBackground(Color.WHITE);
		btnOrdering.setBackground(Color.WHITE);
		btnDeliveryStatus.setBackground(Color.WHITE);
		btnReturnProducts.setBackground(Color.WHITE);
		btnAuditTrail.setBackground(Color.WHITE);
		
		
		btnDashboard.setForeground(Color.BLACK);
		btnKbn.setForeground(Color.BLACK);
		btnRebranding.setForeground(Color.BLACK);
		btnCanncelledOrder.setForeground(Color.BLACK);
		btnConfirmation.setForeground(Color.BLACK);
		btnCustomerAccount.setForeground(Color.BLACK);
		btnClientProfile.setForeground(Color.BLACK);
		btnOrdering.setForeground(Color.BLACK);
		btnDeliveryStatus.setForeground(Color.BLACK);
		btnReturnProducts.setForeground(Color.BLACK);
		btnAuditTrail.setForeground(Color.BLACK);
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
		
		if(e.getComponent() instanceof JButton) {
			Component c = e.getComponent();
			((JButton)c).setBackground(new Color(75, 119, 71));
			((JButton)c).setForeground(Color.WHITE);
		}else
			return;

	}


	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == orderPanel.orderLPanel.lblInstruction) {
			orderPanelInstruction.setVisible(false);
		}
		
		if(e.getComponent() instanceof JButton) {
			Component c = e.getComponent();

			if(btnChecker == c) {
				((JButton)c).setBackground(new Color(75, 119, 71));
				((JButton)c).setForeground(Color.WHITE);
			}else {
				((JButton)c).setBackground(Color.WHITE);
				((JButton)c).setForeground(Color.BLACK);
			}
		}else
			return;
	}
	
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
		
		if(e.getSource() == rebrandingNew.table || e.getSource() == rebrandingNew) {
			if(e.getKeyCode() == 27) {
				rRightClick.setVisible(false);
			}
		}
		
		if(e.getSource() == lblUsername) {
			if(e.getKeyCode() == 27 || e.getSource() == moduleSelection) {
				moduleSelection.setVisible(false);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Defaults
	
	private void setVisiblePanel() {
		dashboard1.setVisible(false);
		kbnProd.setVisible(false);
		rebrandingNew.setVisible(false);
		custAccount.setVisible(false);
		auditTrail.setVisible(false);
		delStatus.setVisible(false);
		orderPanel.setVisible(false);
		cancelOrderPanel.setVisible(false);
		cp.setVisible(false);
		confirmationPanel.setVisible(false);
		returnProd.setVisible(false);
	}
	
	private void defaultPanel() {
		panelTab.add(dashboard1);
		panelTab.add(kbnProd);
		panelTab.add(rebrandingNew);
		panelTab.add(custAccount);
		panelTab.add(auditTrail);
		panelTab.add(delStatus);
		panelTab.add(orderPanel);
		panelTab.add(cancelOrderPanel);
		panelTab.add(cp);
		panelTab.add(confirmationPanel);
		panelTab.add(returnProd);
		dashboard1.setVisible(true);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
		AccountLevel = dataSet.getAccLevel();
		accountID = dataSet.getAccountID();
	}

	
	private void dashboardPanelFunc() {
		setVisiblePanel();
//		mostSoldProd();
		timeDiff();
		chartdataSetter();
		dashboard1();
		dashboard1.setVisible(true);
	}
	
	private void addItem() {
		prodDetails.btnSave.setText("Save");
		prodDetails.cbSetter();
        prodDetails.setUserID(accountID);
        prodDetails.clearInputs();
        prodDetails.setVisible(true);
	}
	
	private void prodDetailsFunc() {
		prodDetails.btnSave.setText("Update");
        prodDetails.setUserID(accountID);
//        prodDetails.clearInputs();
	    if (kbnProd.table.getSelectedRow() != -1) {
	        String ID = kbnProd.table.getValueAt(kbnProd.table.getSelectedRow(), 0) + "";
	        prodDetails.ProductDetails(ID);
	        prodDetails.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	private void archiveKBNProducts() {
		String dropDelimiter = "DROP PROCEDURE IF EXISTS InsertAndDeleteWithRollback;";
		if(kbnProd.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			String ID = kbnProd.table.getValueAt(kbnProd.table.getSelectedRow(), 0) + "";
			String prodName = kbnProd.table.getValueAt(kbnProd.table.getSelectedRow(), 1) + "";
			String Archive = "";
			String Restore = "";
			Archive = "CREATE PROCEDURE InsertAndDeleteWithRollback()\n"
			        + "BEGIN\n"
			        + "  DECLARE EXIT HANDLER FOR SQLEXCEPTION\n"
			        + "  BEGIN\n"
			        + "    ROLLBACK;\n"
			        + "    RESIGNAL;\n"
			        + "  END;\n"
			        + "\n"
			        + "  START TRANSACTION;\n"
			        + "\n"
			        + "  INSERT INTO tblproductsarchive\n"
			        + "  (prodID, prodImg, prodName, prodPrice, prodVolume, Quantity, Sold, prodCategory, Description)\n"
			        + "  SELECT\n"
			        + "    prodID,\n"
			        + "    prodImg,\n"
			        + "    prodName,\n"
			        + "    prodPrice,\n"
			        + "    prodVolume,\n"
			        + "    Quantity,\n"
			        + "    Sold,\n"
			        + "    prodCategory,\n"
			        + "    Description \n"
			        + "  FROM tblproducts\n"
			        + "  WHERE prodID = " + ID + ";\n"
			        + "\n"
			        + "  -- Delete the inserted rows from tblproducts\n"
			        + "  DELETE FROM tblproducts WHERE prodID IN (SELECT prodID FROM tblproductsarchive);\n"
			        + "\n"
			        + "  COMMIT;\n"
			        + "END;";
			

			Restore = "CREATE PROCEDURE InsertAndDeleteWithRollback()\n"
			        + "BEGIN\n"
			        + "  DECLARE EXIT HANDLER FOR SQLEXCEPTION\n"
			        + "  BEGIN\n"
			        + "    ROLLBACK;\n"
			        + "    RESIGNAL;\n"
			        + "  END;\n"
			        + "\n"
			        + "  START TRANSACTION;\n"
			        + "\n"
			        + "  INSERT INTO tblproducts\n"
			        + "  (prodID, prodImg, prodName, prodPrice, prodVolume, Quantity, Sold, prodCategory, Description)\n"
			        + "  SELECT\n"
			        + "    prodID,\n"
			        + "    prodImg,\n"
			        + "    prodName,\n"
			        + "    prodPrice,\n"
			        + "    prodVolume,\n"
			        + "    Quantity,\n"
			        + "    Sold,\n"
			        + "    prodCategory,\n"
			        + "    Description \n"
			        + "  FROM tblproductsarchive\n"
					+ "  WHERE prodID = " + ID + ";\n"
			        + "\n"
			        + "  DELETE FROM tblproductsarchive WHERE prodID IN (SELECT prodID FROM tblproducts);\n"
			        + "\n"
			        + "  COMMIT;\n"
			        + "END;";
			
			String proccessIfNoError = "CALL InsertAndDeleteWithRollback();";

			st.execute(dropDelimiter);
			if(kbnProdButtonChecker.equals("Products")) {
				st.execute(Archive);
				String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','KBN Product Archive - " + prodName + "');";
				st.execute(AuditTrail);
			}
			if(kbnProdButtonChecker.equals("Archive")) {
				st.execute(Restore);
				String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','KBN Product Restore - " + prodName + "');";
				st.execute(AuditTrail);
			}
			
			//final execute if 2 query is no error
			st.execute(proccessIfNoError);
			JOptionPane.showMessageDialog(null, "Product Archive Successfully!");

			if(kbnProdButtonChecker.equals("Products")) {
				KBNPanelFunc();
				rightClick.setVisible(false);
			}else {
				KBNPanelFuncArchive();
				rightClick.setVisible(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ErrorArchiveKBN: " + e.getMessage());
		}
	}
	
	private void rebrandingarchiveKBNProducts() {
		String dropDelimiter = "DROP PROCEDURE IF EXISTS InsertAndDeleteWithRollbackRebranding;";
		if(rebrandingNew.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			String ID = rebrandingNew.table.getValueAt(rebrandingNew.table.getSelectedRow(), 0) + "";
			String prodName = rebrandingNew.table.getValueAt(rebrandingNew.table.getSelectedRow(), 3) + "";
			String Archive = "";
			String Restore = "";
			Archive = "CREATE PROCEDURE InsertAndDeleteWithRollbackRebranding()\r\n"
					+ "BEGIN\r\n"
					+ "  DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n"
					+ "  BEGIN\r\n"
					+ "    ROLLBACK;\r\n"
					+ "    RESIGNAL;\r\n"
					+ "  END;\r\n"
					+ "\r\n"
					+ "  START TRANSACTION;\r\n"
					+ "\r\n"
					+ "INSERT INTO tblrebrandingproductsarchive\r\n"
					+ "SELECT * FROM tblrebrandingproducts\r\n"
					+ "WHERE prodID = '" + ID + "';\r\n"
					+ "\r\n"
					+ "  -- Delete the inserted rows from tblproducts\r\n"
					+ "  DELETE FROM tblrebrandingproducts WHERE prodID IN (SELECT prodID FROM tblrebrandingproductsarchive);\r\n"
					+ "\r\n"
					+ "  COMMIT;\r\n"
					+ "END;";
			

			Restore = "CREATE PROCEDURE InsertAndDeleteWithRollbackRebranding()\r\n"
					+ "BEGIN\r\n"
					+ "  DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n"
					+ "  BEGIN\r\n"
					+ "    ROLLBACK;\r\n"
					+ "    RESIGNAL;\r\n"
					+ "  END;\r\n"
					+ "\r\n"
					+ "  START TRANSACTION;\r\n"
					+ "\r\n"
					+ "INSERT INTO tblrebrandingproducts\r\n"
					+ "SELECT * FROM tblrebrandingproductsarchive\r\n"
					+ "WHERE prodID = '" + ID + "';\r\n"
					+ "\r\n"
					+ "  -- Delete the inserted rows from tblproducts\r\n"
					+ "  DELETE FROM tblrebrandingproductsarchive WHERE prodID IN (SELECT prodID FROM tblrebrandingproducts);\r\n"
					+ "\r\n"
					+ "  COMMIT;\r\n"
					+ "END;";
			
			String proccessIfNoError = "CALL InsertAndDeleteWithRollbackRebranding();";

			st.execute(dropDelimiter);
			if(rebrandingProdButtonChecker.equals("Products")) {
				st.execute(Archive);
				String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','Rebranding Product Archive - " + prodName + "');";
				st.execute(AuditTrail);
			}
			if(rebrandingProdButtonChecker.equals("Archive")) {
				st.execute(Restore);
				String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','Rebranding Product Restore - " + prodName + "');";
				st.execute(AuditTrail);
			}
			
			//final execute if 2 query is no error
			st.execute(proccessIfNoError);
			
			JOptionPane.showMessageDialog(null, "Product Archive Successfully!");

			if(rebrandingProdButtonChecker.equals("Products")) {
				rebrandingNewPanelFunc();
				rightClick.setVisible(false);
			}else {
				rebrandingNewPanelFuncArchive();
				rightClick.setVisible(false);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ErrorArchiveKBN: " + e.getMessage());
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
			
			if(rowCount != 0)
				custAccount.btnCreate.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification-red.png")));
			else
				custAccount.btnCreate.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification.png")));
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR preRegCounter: " + e.getMessage());
		}
	}
	
	private void orderCounterDashboard() {
		try {
//			String sql = "SELECT COUNT(OrderRefNumber) FROM tblordercheckout";
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
//			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a JOIN tblcustomerinformation AS b ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber WHERE c.status != 'Cancelled' AND c.status != 'Expired'";
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a JOIN tblcustomerinformation AS b ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber WHERE c.status = 'toPay'";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				opdDashboard.lblRefNumber[i].setText(rs.getString(1));
				opdDashboard.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				opdDashboard.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
//				System.out.println(rs.getString(1) + ", " + rs.getString(5));
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
			    if(min == 0.0)
			    	label = "No new order.";
			    dashboard1.lblTimeDiff.setText(label);
//			    System.out.println(label);
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
			
			dashboard1.lblDailyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/" + randOFF + ".png")));
			
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
			
			dashboard1.lblWeeklyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/" + randOFF + ".png")));
			
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
			
			
			
			dashboard1.lblMonthlyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/" + randOFF + ".png")));
			
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
			
			dashboard1.lblYearlyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/" + randOFF + ".png")));
			
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
	
	private void orderCounterSearch(String search) {
		try {
			orderBTNClickCount++;
			String sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \r\n"
					+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
					+ "WHERE a.OrderRefNumber LIKE '%" + search + "%' AND (b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled');";
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				OrderCount = rs.getInt(1);
			orderPanel.orderLPanel.opd = new OrderListPanelData();
			orderPanel.orderLPanel.scrollPane.setViewportView(orderPanel.orderLPanel.opd);
			orderPanel.orderLPanel.opd.iOrderCount(OrderCount);
			setOrderListDataSearch(search);
			orderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error OrderCount: " + e.getMessage());
		}
	}
	
	
	private void setOrderListDataSearch(String search) {
		try {
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
					+ "FROM tblordercheckout AS a \n"
					+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
					+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
					+ "WHERE a.OrderRefNumber LIKE '%" + search + "%' AND (c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled');";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				orderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				orderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				orderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListData: " + e.getMessage());
		}
	}
	
	private void cancelorderCounterSearch(String search) {
		try {
			cancelorderBTNClickCount++;
			String sql = "";
			
			if(cancelOrderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
					+ "FROM tblorderarchive AS a \n"
					+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE (b.status = 'Cancelled' OR b.status = 'Expired') AND a.OrderRefNumber LIKE '%" + search + "%';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
						+ "FROM tblorderarchive AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
						+ "WHERE b.status = 'Expired' AND a.OrderRefNumber LIKE '%" + search + "%';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
						+ "FROM tblorderarchive AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
						+ "WHERE b.status = 'Cancelled' AND a.OrderRefNumber LIKE '%" + search + "%';";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				CancelOrderCount = rs.getInt(1);
			cancelOrderPanel.orderLPanel.opd = new OrderListPanelData();
			cancelOrderPanel.orderLPanel.scrollPane.setViewportView(cancelOrderPanel.orderLPanel.opd);
			cancelOrderPanel.orderLPanel.opd.iOrderCount(CancelOrderCount);
			cancelsetOrderListDataSearch(search);
			cancelorderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cancelorderCounterSearch: " + e.getMessage());
		}
	}
	
	
	private void cancelsetOrderListDataSearch(String search) {
		try {
			String sql = " ";
			if(cancelOrderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE (c.status = 'Cancelled' OR c.status = 'Expired') AND  a.OrderRefNumber LIKE '%" + search + "%';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE c.status = 'Expired' AND  a.OrderRefNumber LIKE '%" + search + "%';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE c.status = 'Cancelled' AND  a.OrderRefNumber LIKE '%" + search + "%';";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				cancelOrderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				cancelOrderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				cancelOrderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR cancelsetOrderListDataSearch: " + e.getMessage());
		}
	}
	
	private void cancelorderCounterCB() {
		try {
			cancelorderBTNClickCount++;
			String sql = "";
			
			if(cancelOrderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
					+ "FROM tblorderarchive AS a \n"
					+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE (b.status = 'Cancelled' OR b.status = 'Expired');";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
						+ "FROM tblorderarchive AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
						+ "WHERE b.status = 'Expired';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT COUNT(a.OrderRefNumber) \n"
						+ "FROM tblorderarchive AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
						+ "WHERE b.status = 'Cancelled';";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				CancelOrderCount = rs.getInt(1);
			cancelOrderPanel.orderLPanel.opd = new OrderListPanelData();
			cancelOrderPanel.orderLPanel.scrollPane.setViewportView(cancelOrderPanel.orderLPanel.opd);
			cancelOrderPanel.orderLPanel.opd.iOrderCount(CancelOrderCount);
			cancelsetOrderListDataCB();
			cancelorderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cancelorderCounterSearch: " + e.getMessage());
		}
	}
	
	
	private void cancelsetOrderListDataCB() {
		try {
			String sql = " ";
			if(cancelOrderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE (c.status = 'Cancelled' OR c.status = 'Expired');";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE c.status = 'Expired';";
			} else if(cancelOrderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
				+ "FROM tblorderarchive AS a \n"
				+ "JOIN tblcustomerinformation AS b \n"
				+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
				+ "WHERE c.status = 'Cancelled';";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				cancelOrderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				cancelOrderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				cancelOrderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR cancelsetOrderListDataSearch: " + e.getMessage());
		}
	}

	
	private void orderCounter() {
		try {
			orderBTNClickCount++;
			String sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
					+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
					+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled';";
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				OrderCount = rs.getInt(1);
			orderPanel.orderLPanel.opd = new OrderListPanelData();
			orderPanel.orderLPanel.scrollPane.setViewportView(orderPanel.orderLPanel.opd);
			orderPanel.orderLPanel.opd.iOrderCount(OrderCount);
			setOrderListData();
			orderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error OrderCount: " + e.getMessage());
		}
	}
	
	private void orderCounterCB() {
		try {
			orderBTNClickCount++;
			String sql = "";
			
			if(orderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled';";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled' AND b.status = 'toPay';";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled' AND b.status = 'toShip';";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 3) {
				sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled' AND b.status = 'toReceived';";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 4) {
				sql = "SELECT COUNT(a.OrderRefNumber) FROM tblordercheckout AS a \n"
						+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
						+ "WHERE b.status != 'Return' AND b.status != 'Expired' AND b.status != 'Cancelled' AND b.status = 'Completed';";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				OrderCount = rs.getInt(1);
			orderPanel.orderLPanel.opd = new OrderListPanelData();
			orderPanel.orderLPanel.scrollPane.setViewportView(orderPanel.orderLPanel.opd);
			orderPanel.orderLPanel.opd.iOrderCount(OrderCount);
			setOrderListDataCB();
			orderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error orderCounterCB: " + e.getMessage());
		}
	}
	
	private void setOrderListDataCB() {
		try {
			String sql = " ";
			if(orderPanel.cbCategory.getSelectedIndex() == 0) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
						+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
						+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
						+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' \n"
						+ "ORDER BY a.OrderDate DESC;";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 1) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
						+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
						+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
						+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' AND c.status = 'toPay' \n"
						+ "ORDER BY a.OrderDate DESC;";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 2) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
						+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
						+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
						+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' AND c.status = 'toShip' \n"
						+ "ORDER BY a.OrderDate DESC;";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 3) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
						+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
						+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
						+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' AND c.status = 'toReceived' \n"
						+ "ORDER BY a.OrderDate DESC;";
			} else if(orderPanel.cbCategory.getSelectedIndex() == 4) {
				sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
						+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
						+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
						+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' AND c.status = 'Completed' \n"
						+ "ORDER BY a.OrderDate DESC;";
			} else {
				System.out.println("Error");
			}
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				orderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				orderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				orderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListDataCB: " + e.getMessage());
		}
	}
	
	private void setOrderListData() {
		try {
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status FROM tblordercheckout AS a \n"
					+ "JOIN tblcustomerinformation AS b ON a.UserID = b.UserID \n"
					+ "JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
					+ "WHERE c.status != 'Return' AND c.status != 'Expired' AND c.status != 'Cancelled' \n"
					+ "ORDER BY a.OrderDate DESC;";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				orderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				orderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				orderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				orderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListData: " + e.getMessage());
		}
	}
	
	
	private void CancelorderCounter() {
		try {
			cancelorderBTNClickCount++;
			String sql = "SELECT COUNT(a.OrderRefNumber) \n"
					+ "FROM tblorderarchive AS a \n"
					+ "JOIN tblorderstatus AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE b.status = 'Cancelled' OR b.status = 'Expired';";

			
			st.execute(sql);
			rs = st.getResultSet();
			
			if(rs.next())
				CancelOrderCount = rs.getInt(1);
			cancelOrderPanel.orderLPanel.opd = new OrderListPanelData();
			cancelOrderPanel.orderLPanel.scrollPane.setViewportView(cancelOrderPanel.orderLPanel.opd);
			cancelOrderPanel.orderLPanel.opd.iOrderCount(CancelOrderCount);
			cancelsetOrderListData();
			cancelorderPanelMouseList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error CancelOrderCount: " + e.getMessage());
		}
	}
	
	private void cancelsetOrderListData() {
		try {
			String sql = "SELECT a.OrderRefNumber, a.UserID, b.FirstName, b.LastName, c.Status \n"
					+ "FROM tblorderarchive AS a \n"
					+ "JOIN tblcustomerinformation AS b \n"
					+ "ON a.UserID = b.UserID JOIN tblorderstatus As c ON c.OrderRefNumber = a.OrderRefNumber \n"
					+ "WHERE c.status = 'Cancelled' OR c.status = 'Expired';";
			
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				cancelOrderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				cancelOrderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				cancelOrderPanel.orderLPanel.opd.lblStatus[i].setText(rs.getString(5));
				//status indicator
				String path = "/KBN/resources/Marketing/OrderList/" + rs.getString(5) + ".png";
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].setIcon(new ImageIcon(OrderListPanelData.class.getResource(path)));
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].revalidate();
				cancelOrderPanel.orderLPanel.opd.lblOrderStatusColor[i].repaint();
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR cancelsetOrderListData: " + e.getMessage());
		}
	}
	
	
	private void preRegMouseList() {
		for(int i = 0; i < rowCount; i++) {
			this.preReg.preReg.panel[i].addMouseListener(this);
		}
	}
	
	private void clientProfileOrderListActionList() {
		for(int i = 0; i < ClientProfileCounter; i++) {
			cpsp.btnProcessOrder[i].addActionListener(this);
		}
	}
	
	private void clientProfileProductListAdd() {
		for(int i = 0; i < rp.btnProcessOrder.length; i++) {
			rp.btnProcessOrder[i].addActionListener(this);
		}
	}
	
	private void clientProfileProductListRemove() {
		for(int i = 0; i < rp.btnProcessOrder.length; i++) {
			rp.btnProcessOrder[i].removeActionListener(this);
		}
	}
	
	private void clientProfileOrderHistoryActionlist() {
		for(int i = 0; i < ClientProfileCounterHistory; i++) {
			orderHistory.btnProcessOrder[i].addActionListener(this);
		}
	}
	
	private void clearOrderPanelMouseListeners() {
		if(orderBTNClickCount > 0) {
		    for (int i = 0; i < OrderCount; i++) {
		    	this.orderPanel.orderLPanel.opd.orderList[i].removeMouseListener(this);
		    }
		}
	}
	
	private void cancelclearOrderPanelMouseListeners() {
		if(cancelorderBTNClickCount > 0) {
		    for (int i = 0; i < CancelOrderCount; i++) {
		    	this.cancelOrderPanel.orderLPanel.opd.orderList[i].removeMouseListener(this);
		    }
		}
	}
	
	private void orderPanelMouseList() {
		for(int i = 0; i < OrderCount; i++) {
			this.orderPanel.orderLPanel.opd.orderList[i].addMouseListener(this);
		}
	}
	
	private void cancelorderPanelMouseList() {
		for(int i = 0; i < CancelOrderCount; i++) {
			this.cancelOrderPanel.orderLPanel.opd.orderList[i].addMouseListener(this);
		}
	}
	
	// chart
    private void chartdataSetter() {
    	try {
            List<Integer> scores = new ArrayList<Integer>();
            List<String> date = new ArrayList<String>();
            int max = 0;
            
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
    		
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
    		
    	    int index_ = 0;
    		while(rs.next()) {
    			if(index_ == 0)
    				max = rs.getInt(1);
    			index_++;
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
    
	private void KBNPanelFuncArchive() {
		rightClick.btnArchive.setText("Restore");
		kbnProdButtonChecker = "Archive";
		kbnProd.btnArchive.setBackground(new Color(75, 119, 71));
		kbnProd.btnArchive.setForeground(Color.WHITE);
		kbnProd.btnProducts.setBackground(Color.WHITE);
		kbnProd.btnProducts.setForeground(Color.BLACK);
		setVisiblePanel();
		kbnProd.main.setRowCount(0);
		kbnProd.table.setModel(kbnProd.main);
        
        try {
        	String sql = "SELECT prodID, prodName, prodVolume, prodCategory, Quantity, Sold FROM tblproductsarchive";
        	st.execute(sql);
        	rs = st.getResultSet();
        	while(rs.next()) {
            	Object[] data = {rs.getString(1), (rs.getString(2) + "(" + rs.getString(3) + ")"), rs.getString(4), rs.getString(5), rs.getString(6)};
            	kbnProd.main.addRow(data);
//            	System.out.println(rs.getString(1));
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "KBNProducts: " + e.getMessage());
		}
		kbnProd.setVisible(true);
	}
	
	private void KBNPanelFuncSearch(String search) {
		String checker__ = "";
		if(kbnProdButtonChecker.equals("Archive"))
			checker__ = "tblproductsarchive";
		else
			checker__ = "tblproducts";
		setVisiblePanel();
		kbnProd.main.setRowCount(0);
		kbnProd.table.setModel(kbnProd.main);
		String sql = "";
		if(!kbnProd.txtSearchBar.getText().equals(""))
			sql = "SELECT prodID, prodName, prodVolume, prodCategory, Quantity, Sold FROM " + checker__ + " WHERE prodName LIKE '%" + search + "%'";
		else
			sql = "SELECT prodID, prodName, prodVolume, prodCategory, Quantity, Sold FROM " + checker__ + ";";
        
        try {
        	
        	st.execute(sql);
        	rs = st.getResultSet();
        	while(rs.next()) {
            	Object[] data = {rs.getString(1), (rs.getString(2) + "(" + rs.getString(3) + ")"), rs.getString(4), rs.getString(5), rs.getString(6)};
            	kbnProd.main.addRow(data);
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "ERROR KBNProductsSearch: " + e.getMessage());
		}
		kbnProd.setVisible(true);
	}
	
	private void KBNPanelFunc() {
		rightClick.btnArchive.setText("Archive");
		kbnProdButtonChecker = "Products";
		kbnProd.btnProducts.setBackground(new Color(75, 119, 71));
		kbnProd.btnProducts.setForeground(Color.WHITE);
		kbnProd.btnArchive.setBackground(Color.WHITE);
		kbnProd.btnArchive.setForeground(Color.BLACK);
		setVisiblePanel();
		kbnProd.main.setRowCount(0);
		kbnProd.table.setModel(kbnProd.main);
        
        try {
        	String sql = "SELECT prodID, prodName, prodVolume, prodCategory, Quantity, Sold FROM tblproducts";
        	st.execute(sql);
        	rs = st.getResultSet();
        	while(rs.next()) {
            	Object[] data = {rs.getString(1), (rs.getString(2) + "(" + rs.getString(3) + ")"), rs.getString(4), rs.getString(5), rs.getString(6)};
            	kbnProd.main.addRow(data);
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "KBNProducts: " + e.getMessage());
		}
		kbnProd.setVisible(true);
	}
	
	private void rebrandingNewPanelFunc() {
		rRightClick.btnArchive.setText("Archive");
		rebrandingProdButtonChecker = "Products";
		
		rebrandingNew.btnProducts.setBackground(new Color(75, 119, 71));
		rebrandingNew.btnProducts.setForeground(Color.WHITE);
		rebrandingNew.btnArchive.setBackground(Color.WHITE);
		rebrandingNew.btnArchive.setForeground(Color.BLACK);
		
		setVisiblePanel();
		
		rebrandingNew.main.setRowCount(0);
        try {

        	String sql = "SELECT a.prodID, a.userID, CONCAT(b.Firstname, ' ', b.Lastname) AS FullName, \n"
        			+ "CONCAT(a.prodName, ' (', a.prodVolume,')') AS Product, \n"
        			+ "COALESCE(SUM(a.Sold), 0) AS TotalSold, \n"
        			+ "COALESCE(SUM(c.FinishProduct - a.sold), 0) AS Available, \n"
        			+ "COALESCE(c.FinishProduct, 0) AS FinishProduct, \n"
        			+ "COALESCE((SELECT SUM(a1.Quantity) FROM tblordercheckoutdata AS a1 \n"
        			+ "JOIN tblorderstatus AS b1 ON a1.OrderRefNumber = b1.OrderRefNumber \n"
        			+ "WHERE a1.ProductName = a.prodName AND a1.volume = a.prodVolume AND b1.status = 'Return'),0) AS Returna \n"
        			+ "FROM tblrebrandingproducts AS a \n"
        			+ "JOIN tblcustomerinformation AS b ON a.userID = b.UserID \n"
        			+ "LEFT JOIN tblrebrandingfinishproduct AS c ON a.prodID = c.ID \n"
        			+ "WHERE b.AccountType = 'Rebranding' \n"
        			+ "GROUP BY a.userID, Product ORDER BY TotalSold DESC;";
        	
        	st.execute(sql);
        	rs = st.getResultSet();
        	ArrayList temp = new ArrayList<>();
        	while(rs.next()) {
        		temp.add(rs.getString(1)); //prodID
        		temp.add(rs.getString(2)); // userID
        		temp.add(rs.getString(3)); // FullName
        		temp.add(rs.getString(4)); // ProductName
        		temp.add(rs.getString(5));// Total Sold
        		temp.add(rs.getInt(6)); // Available
        		temp.add(rs.getString(7)); // Return
        		temp.add(rs.getString(8)); // Total
        		rebrandingNew.main.addRow(temp.toArray());
        		temp.clear();
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error rebrandingNewPanelFunc: " + e.getMessage());
		}
		
		rebrandingNew.setVisible(true);
	}
	
	private void rebrandingNewPanelFuncArchive() {
		
		rRightClick.btnArchive.setText("Restore");
		rebrandingProdButtonChecker = "Archive";
		
		setVisiblePanel();
		
		rebrandingNew.main.setRowCount(0);
		
		rebrandingNew.btnArchive.setBackground(new Color(75, 119, 71));
		rebrandingNew.btnArchive.setForeground(Color.WHITE);
		rebrandingNew.btnProducts.setBackground(Color.WHITE);
		rebrandingNew.btnProducts.setForeground(Color.BLACK);
		
        try {
        	
        	String sql = "SELECT a.prodID, a.userID, CONCAT(b.Firstname, ' ', b.Lastname) AS FullName, \n"
        			+ "CONCAT(a.prodName, ' (', a.prodVolume,')') AS Product, \n"
        			+ "COALESCE(SUM(a.Sold), 0) AS TotalSold, \n"
        			+ "COALESCE(SUM(c.FinishProduct - a.sold), 0) AS Available, \n"
        			+ "COALESCE(c.FinishProduct, 0) AS FinishProduct, \n"
        			+ "COALESCE((SELECT SUM(a1.Quantity) FROM tblordercheckoutdata AS a1 \n"
        			+ "JOIN tblorderstatus AS b1 ON a1.OrderRefNumber = b1.OrderRefNumber \n"
        			+ "WHERE a1.ProductName = a.prodName AND a1.volume = a.prodVolume AND b1.status = 'Return'),0) AS Returna \n"
        			+ "FROM tblrebrandingproductsarchive AS a \n"
        			+ "JOIN tblcustomerinformation AS b ON a.userID = b.UserID \n"
        			+ "LEFT JOIN tblrebrandingfinishproduct AS c ON a.prodID = c.ID \n"
        			+ "WHERE b.AccountType = 'Rebranding' \n"
        			+ "GROUP BY a.userID, Product ORDER BY TotalSold DESC;";
        	
        	st.execute(sql);
        	rs = st.getResultSet();
        	ArrayList temp = new ArrayList<>();
        	while(rs.next()) {
        		temp.add(rs.getString(1)); //prodID
        		temp.add(rs.getString(2)); // userID
        		temp.add(rs.getString(3)); // FullName
        		temp.add(rs.getString(4)); // ProductName
        		temp.add(rs.getString(5));// Total Sold
        		temp.add(rs.getInt(6)); // Available
        		temp.add(rs.getString(7)); // Return
        		temp.add(rs.getString(8)); // Total
        		rebrandingNew.main.addRow(temp.toArray());
        		temp.clear();
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error rebrandingNewPanelFunc: " + e.getMessage());
		}
		
		rebrandingNew.setVisible(true);
	}
	
	private void RebrandingPanelFuncSearch(String search) {
		String checker__ = "";
		if(rebrandingProdButtonChecker.equals("Archive"))
			checker__ = "tblrebrandingproductsarchive";
		else
			checker__ = "tblrebrandingproducts";
		setVisiblePanel();
		rebrandingNew.main.setRowCount(0);
		rebrandingNew.table.setModel(rebrandingNew.main);
		String sql = "";
		
		if(!search.equals("Search by Product Name, Client Name"))
    		sql = "SELECT a.prodID, a.userID, CONCAT(b.Firstname, ' ', b.Lastname) AS FullName, \n"
    			+ "CONCAT(a.prodName, ' (', a.prodVolume,')') AS Product, \n"
    			+ "COALESCE(SUM(a.Sold), 0) AS TotalSold, \n"
    			+ "COALESCE(SUM(c.FinishProduct - a.sold), 0) AS Available, \n"
    			+ "COALESCE(c.FinishProduct, 0) AS FinishProduct, \n"
    			+ "COALESCE((SELECT SUM(a1.Quantity) FROM tblordercheckoutdata AS a1 \n"
    			+ "JOIN tblorderstatus AS b1 ON a1.OrderRefNumber = b1.OrderRefNumber \n"
    			+ "WHERE a1.ProductName = a.prodName AND a1.volume = a.prodVolume AND b1.status = 'Return'),0) AS Returna \n"
    			+ "FROM " + checker__ + " AS a \n"
    			+ "JOIN tblcustomerinformation AS b ON a.userID = b.UserID \n"
    			+ "LEFT JOIN tblrebrandingfinishproduct AS c ON a.prodID = c.ID \n"
    			+ "WHERE b.AccountType = 'Rebranding' AND (a.prodName LIKE '%" + search + "%' OR CONCAT(b.Firstname, ' ', b.Lastname) LIKE '%" + search + "%') \n"
    			+ "GROUP BY a.userID, Product ORDER BY TotalSold DESC;";
		else
			sql = "SELECT a.prodID, a.userID, CONCAT(b.Firstname, ' ', b.Lastname) AS FullName, \n"
	    			+ "CONCAT(a.prodName, ' (', a.prodVolume,')') AS Product, \n"
	    			+ "COALESCE(SUM(a.Sold), 0) AS TotalSold, \n"
	    			+ "COALESCE(SUM(c.FinishProduct - a.sold), 0) AS Available, \n"
	    			+ "COALESCE(c.FinishProduct, 0) AS FinishProduct, \n"
	    			+ "COALESCE((SELECT SUM(a1.Quantity) FROM tblordercheckoutdata AS a1 \n"
	    			+ "JOIN tblorderstatus AS b1 ON a1.OrderRefNumber = b1.OrderRefNumber \n"
	    			+ "WHERE a1.ProductName = a.prodName AND a1.volume = a.prodVolume AND b1.status = 'Return'),0) AS Returna \n"
	    			+ "FROM " + checker__ + " AS a \n"
	    			+ "JOIN tblcustomerinformation AS b ON a.userID = b.UserID \n"
	    			+ "LEFT JOIN tblrebrandingfinishproduct AS c ON a.prodID = c.ID \n"
	    			+ "WHERE b.AccountType = 'Rebranding' \n"
	    			+ "GROUP BY a.userID, Product ORDER BY TotalSold DESC;";
        
        try {
        	
        	st.execute(sql);
        	rs = st.getResultSet();
        	ArrayList temp = new ArrayList<>();
        	while(rs.next()) {
        		temp.add(rs.getString(1)); //prodID
        		temp.add(rs.getString(2)); // userID
        		temp.add(rs.getString(3)); // FullName
        		temp.add(rs.getString(4)); // ProductName
        		temp.add(rs.getString(5));// Total Sold
        		temp.add(rs.getInt(6)); // Available
        		temp.add(rs.getString(7)); // Return
        		temp.add(rs.getString(8)); // Total
        		rebrandingNew.main.addRow(temp.toArray());
        		temp.clear();
        	}
        }catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "ERROR RebrandingPanelFuncSearch: " + e.getMessage());
		}
        rebrandingNew.setVisible(true);
	}
	
	private void custAccPanelFunc() {
		setVisiblePanel();
		preRegCounter();
        custAccountFunc();
		custAccount.setVisible(true);
	}
	
	private void AuditPanelFunc() {
		setVisiblePanel();
		auditTrail.setVisible(true);
		
		try {
			auditTrail.main.setRowCount(0);
			String SQL = "SELECT DATE_FORMAT(a.DateAction, '%Y-%m-%d') AS formatted_date, \n"
					+ "       DATE_FORMAT(a.DateAction, '%h:%i %p') AS formatted_time, \n"
					+ "       CONCAT(b.FirstName, ' ', b.LastName) AS FullName, \n"
					+ "       a.Description \n"
					+ "FROM audittrailmarketing As a \n"
					+ "JOIN tblaccountinfo AS b ON a.UserID = b.AccountID \n"
					+ "WHERE a.DateAction > DATE_SUB(NOW(), INTERVAL 2 MONTH) \n"
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
	
	private void auditButton(String search) {
		setVisiblePanel();
		auditTrail.setVisible(true);
		
		try {
			auditTrail.main.setRowCount(0);
			String SQL = "SELECT DATE_FORMAT(a.DateAction, '%Y-%m-%d') AS formatted_date, \n"
					+ "       DATE_FORMAT(a.DateAction, '%h:%i %p') AS formatted_time, \n"
					+ "       CONCAT(b.FirstName, ' ', b.LastName) AS FullName, \n"
					+ "       a.Description \n"
					+ "FROM audittrailmarketing As a \n"
					+ "JOIN tblaccountinfo AS b ON a.UserID = b.AccountID \n"
					+ "WHERE a.Description LIKE '%" + search + "%' OR CONCAT(b.FirstName, ' ', b.LastName) LIKE '%" + search + "%';";
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
			JOptionPane.showMessageDialog(null, "Error auditButton: " + e.getMessage());
		}
	}
	
	private void returnProductFunc() {
		setVisiblePanel();
		returnProd.setVisible(true);
		returnTable();

	}
	
	private void returnTable() {
		try {
			returnProd.main.setRowCount(0);
			String SQL = "SELECT a.OrderRefNumber, a.DateAdded,  CONCAT(c.Firstname, ' ', c.Lastname), d.Status \n"
					+ "FROM tblreturndetails AS a \n"
					+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
					+ "JOIN tblcustomerinformation AS c ON b.UserID = c.UserID \n"
					+ "JOIN tblreturnstatus AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
					+ "GROUP BY a.OrderRefNumber;";
			
			st.execute(SQL);
			rs = st.getResultSet();
			
			ArrayList temp = new ArrayList<>();
			
			while(rs.next()) {
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				returnProd.main.addRow(temp.toArray());
				temp.clear();
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error returnProductFunc: " + e.getMessage());
		}
	}
	
	private void returnViewDetails(){
		if(returnProd.table.getSelectedRow() != -1) {
			String ref = returnProd.table.getValueAt(returnProd.table.getSelectedRow(), 0) + "";
			returnViewDetailsTable(ref);
			returnDetails.setVisible(true);
		}

	}
	
	private void returnViewDetailsTable(String ref) {
		try {
			returnDetails.main.setRowCount(0);
			String sql = "SELECT a.prodName, a.prodVariant, a.Quantity \n"
					+ "FROM tblreturnproduct AS a \n"
					+ "WHERE a.OrderRefNumber = '" + ref + "';";
			st.execute(sql);
			rs = st.getResultSet();
			
			ArrayList temp = new ArrayList<>();
			
			while(rs.next()) {
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getInt(3));
				returnDetails.main.addRow(temp.toArray());
				temp.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error returnViewDetails: " + e.getMessage());
		}
	}
	
	private void returnUpdateStatus() {
		if(returnDetails.table.getSelectedRow() != -1) {
			try {
				String status = returnProd.table.getValueAt(returnProd.table.getSelectedRow(), 3) + "";
				String ref__ = returnProd.table.getValueAt(returnProd.table.getSelectedRow(), 0) + "";
				
				int response = 0;
				
				if(status.equals("Pending")) {
					status = "In-process";
					
					String SQLUpdate = "UPDATE tblreturnstatus "
							+ "SET Status = '" + status + "' "
							+ "WHERE OrderRefNumber = '" + ref__ + "'";
					
					 response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
				        if (response == JOptionPane.YES_OPTION)
							st.execute(SQLUpdate);
				        else if (response == JOptionPane.NO_OPTION)
							return;
					returnTable();
					
					return;
				}
				
				if(status.equals("In-process")) {
					Status status_ = new Status();
					status_.ref = ref__;
					status_.setVisible(true);
					returnTable();
					
					return;
				}
		        	
				

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error returnUpdateStatus: " + e.getMessage());
			}	
		}
	}

	private void orderPanelFunc() {
		setVisiblePanel();
		orderPanel.setVisible(true);
		clearOrderPanelMouseListeners();
		orderCounter();
		orderPanelMouseList();
	}
	
	private void orderPanelFuncSearch() {
		setVisiblePanel();
		orderPanel.setVisible(true);
		clearOrderPanelMouseListeners();
		orderCounterSearch(orderPanel.orderLPanel.txtSearchBar.getText());
	}
	
	
	private void cancelOrderPanelFunc() {
		setVisiblePanel();
		cancelOrderPanel.setVisible(true);
		cancelclearOrderPanelMouseListeners();
		CancelorderCounter();
	}
	
	private void cancelorderPanelFuncSearch() {
		setVisiblePanel();
		cancelOrderPanel.setVisible(true);
		cancelclearOrderPanelMouseListeners();
		cancelorderCounterSearch(cancelOrderPanel.orderLPanel.txtSearchBar.getText());
	}
	
	//Confirmation Panel Func
	private void confrimationPanelFunc(){
		setVisiblePanel();
		confirmationPanel.btnConfirm.setVisible(false);
		confirmationPanel.setVisible(true);
		ConfirmProductPanelMouseListeners();
		confirmationCounter();
	}
	
	private void ConfirmProductPanelMouseListeners() {
		if(confirmationCounter > 0) {
		    for (int i = 0; i < confirmationCounter; i++) {
		    	this.confirmListPanelData.confirmList[i].addMouseListener(this);
		    }
		}
	}
	
	private void confirmationCounter() {
		try {
			String SQLCounter = "SELECT COUNT(a.TrackingID)\n"
					+ "FROM tblconfirmationtracking AS a;";
			
			st.execute(SQLCounter);
			rs = st.getResultSet();
			
			if(rs.next())
				confirmationCounter = rs.getInt(1);
			
			confirmListPanelData = new ConfirmationListPanelData();
			confirmListPanel.scrollPane.setViewportView(confirmListPanelData);
			
			confirmListPanelData.iConfirmationCount(confirmationCounter);
			
			ConfirmPanelSetData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error confirmationCounter: " + e.getMessage());
		}
	}
	
	private void ConfirmPanelSetData() {
		try {
			String SQL = "SELECT \r\n"
					+ "    a.TrackingID, \r\n"
					+ "    a.DateAdded, \r\n"
					+ "    a.Status, \r\n"
					+ "    COALESCE(NULLIF(COUNT(b.TrackingID), 0), COUNT(c.TrackingID)) AS CountResult,\r\n"
					+ "     COALESCE(NULLIF(SUM(b.ProductQuantity), 0), SUM(c.ProductQuantity)) AS SumResult,\r\n"
					+ "    a.ProductType \r\n"
					+ "FROM tblconfirmationtracking AS a\r\n"
					+ "LEFT JOIN tblconfirmationproduct AS b ON a.TrackingID = b.TrackingID\r\n"
					+ "LEFT JOIN tblconfirmationproductRebranding AS c ON a.TrackingID = c.TrackingID\r\n"
					+ "GROUP BY a.TrackingID;";
			
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				confirmListPanelData.TrackingID[i] = rs.getString(1);
				confirmListPanelData.ProductType[i] = rs.getString(6);
				confirmListPanelData.Status[i] = rs.getString(3);
				
				confirmListPanelData.lblDate[i].setText(rs.getString(2));
				confirmListPanelData.lblOrderStatus[i].setText(rs.getString(6) + " | " + rs.getString(3));
				confirmListPanelData.lblTotalProducts[i].setText(rs.getString(4));
				confirmListPanelData.lblTotalItems[i].setText(rs.getString(5));
				i++;
			}

			ConfirmPanelAddActionlist();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error ConfirmPanelSetData: " + e.getMessage());
		}
	}
	
	private void confirmationCounterCategory() {
		try {
			String cat = "";
			if(confirmListPanel.comboBox.getSelectedIndex() == 0){
				confrimationPanelFunc();
				return;
			}
			else
				cat = confirmListPanel.comboBox.getSelectedItem() + "";
			String SQLCounter = "SELECT COUNT(a.TrackingID) \n"
					+ "FROM tblconfirmationtracking AS a \n"
					+ "WHERE a.Status = '" + cat + "';";
			
			st.execute(SQLCounter);
			rs = st.getResultSet();
			
			if(rs.next())
				confirmationCounter = rs.getInt(1);
			
			confirmListPanelData = new ConfirmationListPanelData();
			confirmListPanel.scrollPane.setViewportView(confirmListPanelData);
			
			confirmListPanelData.iConfirmationCount(confirmationCounter);
			
			ConfirmPanelSetDataCategory(cat);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error confirmationCounter: " + e.getMessage());
		}
	}
	
	private void ConfirmPanelSetDataCategory(String cat) {
		try {
			String SQL = "SELECT a.TrackingID, a.DateAdded, a.Status, COUNT(b.TrackingID), SUM(b.ProductQuantity) \n"
					+ "FROM tblconfirmationtracking AS a \n"
					+ "JOIN tblconfirmationproduct AS b ON a.TrackingID = b.TrackingID \n"
					+ "WHERE a.Status = '" + cat + "' \n"
					+ "GROUP BY a.TrackingID;";
			
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				confirmListPanelData.TrackingID[i] = rs.getString(1);
				confirmListPanelData.lblDate[i].setText(rs.getString(2));
				confirmListPanelData.lblOrderStatus[i].setText(rs.getString(3));
				confirmListPanelData.lblTotalProducts[i].setText(rs.getString(4));
				confirmListPanelData.lblTotalItems[i].setText(rs.getString(5));
				i++;
			}

			ConfirmPanelAddActionlist();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error confirmationCounter: " + e.getMessage());
		}
	}
	
	private void ConfirmPanelAddActionlist() {
		for(int i = 0; i < confirmListPanelData.confirmList.length; i++)
			this.confirmListPanelData.confirmList[i].addMouseListener(this);
	};
	
	private void confirmClickData() {
		String TrackingID = confirmListPanelData.TrackingID[ConfirmProductList];
		String ProductType = confirmListPanelData.ProductType[ConfirmProductList];
		try {
			String[] columnDefaultDataKBN = new String[] {"Product Name", "Variant", "Quantity"};
			String[] columnDefaultDataRebranding = new String[] {"UserID","Product Name", "Variant", "Quantity"};
			if(confirmListPanelData.ProductType[ConfirmProductList].equals("KBN")) {
				confirmationPanel.main.setColumnIdentifiers(columnDefaultDataKBN);
				String SQL = "SELECT a.AddedBy, a.DateAdded, b.ProductName, b.ProductVariant, b.ProductQuantity \n"
						+ "FROM tblconfirmationtracking AS a \n"
						+ "JOIN tblconfirmationproduct AS b ON a.TrackingID = b.TrackingID \n"
						+ "WHERE a.TrackingID = '" + TrackingID + "';";
				confirmationPanel.lblTrackingID.setText(TrackingID);
				confirmationPanel.lblTotalQuantity.setText("Total Quantity: " + confirmListPanelData.lblTotalItems[ConfirmProductList].getText());
				confirmationPanel.lblTotalItem.setText("Total Item: " + confirmListPanelData.lblTotalItems[ConfirmProductList].getText());
				
				st.execute(SQL);
				rs = st.getResultSet();
				
				ArrayList temp = new ArrayList<>();
				while(rs.next()) {
					confirmationPanel.lblInputted.setText(rs.getString(1));
					confirmationPanel.lblDateInputted.setText(rs.getString(2));
					temp.add(rs.getString(3));
					temp.add(rs.getString(4));
					temp.add(rs.getString(5));
					confirmationPanel.main.addRow(temp.toArray());
					temp.clear();
				}	
			} else if(confirmListPanelData.ProductType[ConfirmProductList].equals("REBRANDING")) {
				confirmationPanel.main.setColumnIdentifiers(columnDefaultDataRebranding);
				String SQL = "SELECT a.AddedBy, a.DateAdded, b.ProductName, b.ProductVariant, b.ProductQuantity, b.UserID \n"
						+ "FROM tblconfirmationtracking AS a \n"
						+ "JOIN tblconfirmationproductRebranding AS b ON a.TrackingID = b.TrackingID \n"
						+ "WHERE a.TrackingID = '" + TrackingID + "';";
				
				confirmationPanel.lblTrackingID.setText(TrackingID);
				confirmationPanel.lblTotalQuantity.setText("Total Quantity: " + confirmListPanelData.lblTotalItems[ConfirmProductList].getText());
				confirmationPanel.lblTotalItem.setText("Total Item: " + confirmListPanelData.lblTotalItems[ConfirmProductList].getText());
				
				st.execute(SQL);
				rs = st.getResultSet();
				
				ArrayList temp = new ArrayList<>();
				while(rs.next()) {
					confirmationPanel.lblInputted.setText(rs.getString(1));
					confirmationPanel.lblDateInputted.setText(rs.getString(2));
					temp.add(rs.getString(6));
					temp.add(rs.getString(3));
					temp.add(rs.getString(4));
					temp.add(rs.getString(5));
					confirmationPanel.main.addRow(temp.toArray());
					temp.clear();
				}
			} 
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error confirmClickData: " + e.getMessage());
		}
	}

	
	// Confirm Button - ConfirmationPanel
	private void confirmButtonFunc() {
		String TrackingID = confirmListPanelData.TrackingID[ConfirmProductList];
		String ProductType = confirmListPanelData.ProductType[ConfirmProductList];

		int dialogResult = JOptionPane.showConfirmDialog(null, "The data in the table is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if(ProductType.equals("KBN")) {
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					st.execute("DROP PROCEDURE IF EXISTS confirmProduct;");
					ArrayList arrTemp = new ArrayList<>();
					String UpdateSQL = "UPDATE tblconfirmationtracking \n"
							+ "SET Status = 'COMPLETED' \n"
							+ "WHERE TrackingID = '" + TrackingID + "';\n";
					arrTemp.add(UpdateSQL);
					
					for(int i = 0; i < confirmationPanel.table.getRowCount(); i++) {
						String SQLUpdateProduct = "UPDATE tblproducts \n"
								+ "SET Quantity = Quantity + " + confirmationPanel.table.getValueAt(i, 2) + " \n"
								+ "WHERE prodName = '" + confirmationPanel.table.getValueAt(i, 0) + "' AND prodVolume = '" + confirmationPanel.table.getValueAt(i, 1) + "';\n";
						arrTemp.add(SQLUpdateProduct);
							
					}
					
					String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','Confirm Stock - TrackingID: " + TrackingID + "');\n";
					arrTemp.add(AuditTrail);
					
					String Procedures = "CREATE PROCEDURE confirmProduct()\r\n"
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
					st.execute("CALL confirmProduct();");
					JOptionPane.showMessageDialog(null, "Stock Added!");
					confirmationPanel.btnConfirm.setVisible(false);
					confrimationPanelFunc();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error confirmButtonFunc KBN: " + e.getMessage());
				}
			}
		} else if(ProductType.equals("REBRANDING")) {
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					st.execute("DROP PROCEDURE IF EXISTS confirmProduct;");
					ArrayList arrTemp = new ArrayList<>();
					String UpdateSQL = "UPDATE tblconfirmationtracking \n"
							+ "SET Status = 'COMPLETED' \n"
							+ "WHERE TrackingID = '" + TrackingID + "';\n";
					arrTemp.add(UpdateSQL);
					
					for(int i = 0; i < confirmationPanel.table.getRowCount(); i++) {
						
						String sqlUpdate = "UPDATE tblrebrandingfinishproduct AS a \n"
								+ "JOIN tblrebrandingproducts AS b ON b.prodID = a.ID \n"
								+ "SET a.FinishProduct = a.FinishProduct + '" + confirmationPanel.table.getValueAt(i, 3) + "' \n"
								+ "WHERE b.prodName = '" + confirmationPanel.table.getValueAt(i, 1) + "' AND prodVolume = '" + confirmationPanel.table.getValueAt(i, 2) + "';";
						arrTemp.add(sqlUpdate);
							
					}
					
					String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','Confirm Stock - TrackingID: " + TrackingID + "');\n";
					arrTemp.add(AuditTrail);
					
					String Procedures = "CREATE PROCEDURE confirmProduct()\r\n"
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
					st.execute("CALL confirmProduct();");
					JOptionPane.showMessageDialog(null, "Stock Added!");
					confirmationPanel.btnConfirm.setVisible(false);
					confrimationPanelFunc();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error confirmButtonFunc KBN: " + e.getMessage());
				}
			}
		}

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
			String sql = "UPDATE tblorderstatus SET Status = 'Approved' WHERE OrderRefNumber = '" + refNum + "';";
			int i = st.executeUpdate(sql);
			if(i == 1) {
				String SQLApprovedBy = "INSERT INTO tblorderapproved(OrderRefNumber,ApprovedBy) VALUES('" + refNum + "','" + accountID + "');";
				st.execute(SQLApprovedBy);
				String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','Approved Order - Reference #: " + refNum + "');";
				st.execute(AuditTrail);
				JOptionPane.showMessageDialog(null, "Reference #: " + refNum + " has been Approved");
			}
			else
				JOptionPane.showMessageDialog(null, "Something wrong");
			panelDataSetter();
			orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR btnApproved: " + e1.getMessage());
		}
	}
	
	private void orderpanelBTNTOSHIP() {
		try {
			orderPanel.main.setRowCount(0);
	        orderPanel.table.setModel(orderPanel.main);
			String sql = "UPDATE tblorderstatus SET Status = 'toShip' WHERE OrderRefNumber = '" + refNum + "';";
			int i = st.executeUpdate(sql);
			if(i == 1)
				JOptionPane.showMessageDialog(null, "Reference #: " + refNum + " is ready to Ship");
			else
				JOptionPane.showMessageDialog(null, "Something wrong");
			panelDataSetter();
			orderPanel.btnToShip.setBackground(new Color(13, 164, 0));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "orderpanelBTNTOSHIP ERROR: " + e.getMessage());
		}
	}
	
	private void orderPanelBTNDELIVERY(String refNumber) {
		try {
			ArrayList<String> riderName = new ArrayList<>();
			String SQL = "SELECT Username,CourierID FROM tblcourieraccount";
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next())
				riderName.add(rs.getString(1) + "-" + rs.getString(1));
			onDeliver.cbRiderList.setModel(new DefaultComboBoxModel<String>(riderName.toArray(new String[0])));
			onDeliver.lblRefNumber.setText(refNumber);
			onDeliver.setVisible(true);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error BTNDELIVERY: " + e.getMessage());
		}
	}
	
	private void setDeliveryRider() {
		try {
	        int choice = JOptionPane.showConfirmDialog(
	                null, // Parent component (null for default)
	                "The information is correct?", // Message
	                "Confirmation", // Dialog title
	                JOptionPane.YES_NO_OPTION // Option type
	            );
	        if (choice == JOptionPane.NO_OPTION) {
	        	return;
	        }
	        
			String courier = onDeliver.cbRiderList.getSelectedItem() + "";
			String courierID[] = courier.split("-");
			String ref = refNum;
			String SQL = "INSERT INTO tblcourierdelivery(OrderRefNumber,courierID) VALUES('" + ref + "','" + courierID[1] + "')";
			st.execute(SQL);
	        Date currentDate = new Date();
	        
	        String SQLSelectDelID = "SELECT DeliveryID FROM tblcourierdelivery WHERE OrderRefNumber = '" + ref + "' AND courierID = '" + courierID[1] + "'";
	        
	        st.execute(SQLSelectDelID);
	        rs = st.getResultSet();
	        
	        int dID = 0;
	        
	        if(rs.next()) {
	        	dID = rs.getInt(1);
	        }

	        // Format the date and time
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String formattedDate = dateFormat.format(currentDate);
			
			String SQLDeliveryDate = "INSERT INTO tblcourierdeliverydate(OrderRefNumber, DeliveryDate) VALUES('" + ref + "','" + formattedDate + "');";
			
//			System.out.println(SQLDeliveryDate);
			
			//
			
			st.execute(SQLDeliveryDate);
			onDeliver.dispose();
			String SQLUpdate = "UPDATE tblorderstatus SET Status = 'Delivery' WHERE OrderRefNumber = '" + ref + "'";
//			System.out.println(SQLUpdate);
			st.executeUpdate(SQLUpdate);
			orderStatusSetter();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error setDeliveryRider: " + e.getMessage());
		}
	}
	
	private void orderPanelSearch() {
		if(orderPanel.orderLPanel.txtSearchBar.getText().equals("Search OrderNumber"))
			orderPanelFunc();
		else {
			orderPanelFuncSearch();
		}
	}

	
	
	// Other class button
	
	private void custAccountCreateAccount() {
		preReg = new preRegister();
		preRegCounter();
		noticListSetter();
		preReg.setAccountID(accountID);
		preReg.setVisible(true);
	}
	
	private void custAccountFunc() {
		try {
			custAccount.main.setRowCount(0);
			String sql = "SELECT userID, Firstname, Lastname, Email, Number, Description, AccountType FROM tblcustomerinformation ORDER BY AccountType DESC";
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
		try {
			// {"UserID","Account","Email", "Contact", "Brand", "Account Type"}
			uID = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 0) + "";
			String AccType = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 5) + "";
			custN = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 1) + "";
			custB = custAccount.table.getValueAt(custAccount.table.getSelectedRow(), 4) + "";
			
			if(!"Rebranding".equals(AccType))
				return;
			
			clientProfileChecker = AccType;
			clientProfileFunc();

			cpsp = new ClientProfileScrollablePanel();
			cp.scrollOrderPanel.setViewportView(cpsp);
			
			// OrderList printing
			clientProfileOrderListRefresher(uID, custN,custB);
			clientProfileOrderListActionList();
			
			String SQLAccountInfo = "SELECT Email, Number, Address, Discount FROM tblcustomerinformation WHERE userID = '" + uID + "'";
			st.execute(SQLAccountInfo);
			rs = st.getResultSet();
			String data = "";
			while(rs.next()) {
				data = rs.getString(1) + "<br>" + rs.getString(2) + "<br>" + rs.getString(3);
				imgResizer(rs.getInt(4));
			}
			
			//Setting Customer Profile
			cp.lblClientName.setText(custN);
			cp.lblBrand.setText(custB);
			cp.lblDetails.setText("<html>" + data + "</html>");
			
			
			//SQL Getting this week Quantity

	        ClientProfileWeekly(uID);
	        
	        ClientProfileMonthly(uID);
	        
	        ClientProfileYearly(uID);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error custAccountClientProfileFunc: " + e.getMessage());
		}
	}
	
	private void custAccountSearchFunc(String search) {
		try {
			custAccount.main.setRowCount(0);
			String sql = "SELECT userID, Firstname, Lastname, Email, Number, Description, AccountType FROM tblcustomerinformation WHERE CONCAT(Firstname, Lastname) LIKE '%" + search + "%';";
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
			JOptionPane.showMessageDialog(null, "ERROR custAccountSearchFunc: " + e.getMessage());
		}
	}
	
	private void imgResizer(int percent) {
	    try {
	    	//Class Path
	        URL imageUrl = ClientProfile.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/" + percent + ".png");

	        if (imageUrl != null) {
	            Image originalImage = ImageIO.read(imageUrl);
	            Image resizedImage = originalImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	            cp.lblDiscount.setIcon(new ImageIcon(resizedImage));
	        } else {
	            this.dispose();
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "ProductIMG ERROR: " + e.getMessage());
	    }
	}
	
	private void clientProfileOrderListRefresher(String userID, String custBrand, String custName) {
		try {
			String RowCount = "SELECT COUNT(*) FROM tblorderstatus AS a "
					+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE b.UserID = '" + userID + "' AND a.Status != 'Completed';";
			
			st.execute(RowCount);
			rs = st.getResultSet();
			
			if(rs.next())
				ClientProfileCounter = rs.getInt(1);
			cpsp.orderCountSetter(ClientProfileCounter);
			String arr[][] = new String[ClientProfileCounter+1][4];
			
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
				if(i != ClientProfileCounter)
					i++;
			}
			
			for(int j = 0; j < i; j++) {
				cpsp.lblRefNumber[j].setText(arr[j][0]);
				cpsp.lblProdName[j].setText(arr[j][1]);
				cpsp.lblQuantity[j].setText(arr[j][2]);
				cpsp.lblStatus[j].setText(arr[j][3]);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CustAccountClientProfile ERROR:" + e.getMessage());
		}
	}
	
	private void clientProfileOrderHistoryRefresher(String userID, String custBrand, String custName) {
		try {
			String RowCount = "SELECT COUNT(b.OrderRefNumber) "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status = 'Completed'"
					+ "GROUP BY b.OrderRefNumber;";
			
//			String RowCount = "SELECT COUNT(*) FROM tblorderstatus AS a "
//					+ "JOIN tblordercheckout AS b ON a.OrderRefNumber = b.OrderRefNumber "
//					+ "WHERE b.UserID = '" + userID + "' AND a.Status = 'Completed';";
			
			String SQLRebrandingCount = "SELECT b.OrderRefNumber, b.ProductName, SUM(b.Quantity) AS Quantity , a.Status "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblrebrandingproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status = 'Completed' "
					+ "GROUP BY b.OrderRefNumber";
			
			System.out.println();
			
			st.execute(RowCount);
			rs = st.getResultSet();
			
			while(rs.next())
				ClientProfileCounterHistory++;
			
			st.execute(SQLRebrandingCount);
			rs = st.getResultSet();
			while(rs.next())
				ClientProfileCounterHistory++;
			
			orderHistory.orderCountSetter(ClientProfileCounterHistory);
			String arr[][] = new String[ClientProfileCounterHistory][4];
			
			String SQLKBN = "SELECT b.OrderRefNumber, b.ProductName, SUM(b.Quantity) AS Quantity , a.Status "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status = 'Completed' "
					+ "GROUP BY b.OrderRefNumber";
			
			
			String SQLRebranding = "SELECT b.OrderRefNumber, b.ProductName, SUM(b.Quantity) AS Quantity , a.Status "
					+ "FROM tblorderstatus AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber "
					+ "JOIN tblrebrandingproducts AS d ON b.ProductName = d.prodName AND b.volume = d.prodVolume "
					+ "WHERE c.UserID = '" + userID + "' AND a.Status = 'Completed' "
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
			
			for(int j = 0; j < i; j++) {
				orderHistory.lblRefNumber[j].setText(arr[j][0]);
				orderHistory.lblProdName[j].setText(arr[j][1]);
				orderHistory.lblQuantity[j].setText(arr[j][2]);
				orderHistory.lblStatus[j].setText(arr[j][3]);
			}

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CustAccountClientProfile ERROR:" + e.getMessage());
		}
	}
	
	private void clientProfileOwnProductsRefresher(String userID) {
		try {
			rp = new rebrandingProductsList();
			String OrderCount = "SELECT COUNT(prodID) FROM tblrebrandingproducts WHERE userID = '" + userID + "'";
			st.execute(OrderCount);
			rs = st.getResultSet();
			if(rs.next())
				OwnProdCount = rs.getInt(1);
			rp.orderCountSetter(OwnProdCount);
			
			String SQLProdList = "SELECT prodName, prodID FROM tblrebrandingproducts WHERE userID = '" + userID + "'";
			st.execute(SQLProdList);
			rs = st.getResultSet();
			int counter = 0;
			while(rs.next()) {
				rp.lblProd[counter].setText(rs.getString(1));
				rp.prodID[counter] = rs.getString(2);
				counter++;
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: ClientProfile OwnProdList: " + e.getMessage());
		}
	}
	
	private int SQLDateCount(String SQL) {
		int count = 0;
		try {
			st.execute(SQL);
			rs = st.getResultSet();
			if(rs.next())
				count = rs.getInt(1);
			if(count == 0)
				count = 1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error SQLDATECOUNT: " + e.getMessage());
		}
		return count;
	}
	
	private void ClientProfileWeekly(String userID) {
			double thisWeek = 0;
			double lastWeek = 1;
	        LocalDate mondayOfLastWeek = today.minusWeeks(1).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	        LocalDate sundayOfLastWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	        LocalDate mondaythisWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	        
			String thisWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondaythisWeek + "' AND a.userID = '" + userID + "'";
			
			String lastWeekCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + mondayOfLastWeek + "'  AND a.OrderDate <= '" + sundayOfLastWeek + "' AND a.userID = '" + userID + "'";
			
			// This Week
			thisWeek = SQLDateCount(thisWeekCount);
			
			// Last Week
			lastWeek = SQLDateCount(lastWeekCount);
			
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
	}// END OF WEEKLY
	
	private void ClientProfileMonthly(String userID) {
			double thisMonth = 0;
			double lastMonth = 1;
			LocalDate firstDayOfLastMonth = today.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
			LocalDate lastDayOfLastMonth = today.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
			LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
		    
			String thisMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfThisMonth + "' AND a.userID = '" + userID + "'";
			
			String lastMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfLastMonth + "'  AND a.OrderDate <= '" + lastDayOfLastMonth + "' AND a.userID = '" + userID + "'";
			
			// This Month
			thisMonth = SQLDateCount(thisMonthCount);
			
			// Last Month
			lastMonth = SQLDateCount(lastMonthCount);
			
			// Formula
			double formulaWeekly = ((thisMonth / lastMonth) * 100) - 100;
			cp.lblMonthlyPercent.setText((int)formulaWeekly + "%");
			if(formulaWeekly < 0 || Double.isNaN(formulaWeekly)) {
				cp.lblPercentIconMonthly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/low-price.png")));
				cp.lblTextMonthly.setText("<html><center>Lower Than<br> Last</center></html>");
			}
			else {
				cp.lblPercentIconMonthly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/high-price.png")));
				cp.lblTextMonthly.setText("<html><center>Higher Than<br> Last</center></html>");
			}
	}// END OF WEEKLY
	
	private void ClientProfileYearly(String userID) {
			double thisYear = 0;
			double lastYear = 1;
			LocalDate firstDayOfLastYear = today.minusYears(1).with(TemporalAdjusters.firstDayOfYear());
			LocalDate lastDayOfLastYear = today.minusYears(1).with(TemporalAdjusters.lastDayOfYear());
			LocalDate firstDayOfThisYear = today.with(TemporalAdjusters.firstDayOfYear());
		    
			String thisMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfThisYear + "' AND a.userID = '" + userID + "'";
			
			String lastMonthCount = "SELECT SUM(b.Quantity) "
					+ "FROM tblordercheckout AS a "
					+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber "
					+ "WHERE a.OrderDate >= '" + firstDayOfLastYear + "'  AND a.OrderDate <= '" + lastDayOfLastYear + "' AND a.userID = '" + userID + "'";
			
			// This Year
			thisYear = SQLDateCount(thisMonthCount);
			
			// Last Year
			lastYear = SQLDateCount(lastMonthCount);
			
			// Formula
			double formulaWeekly = ((thisYear / lastYear) * 100) - 100;
			cp.lblYearlyPercent.setText((int)formulaWeekly + "%");
			if(formulaWeekly < 0 || Double.isNaN(formulaWeekly)) {
				cp.lblPercentIconYearly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/low-price.png")));
				cp.lblTextYearly.setText("<html><center>Lower Than<br> Last</center></html>");
			}
			else {
				cp.lblPercentIconYearly.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/high-price.png")));
				cp.lblTextYearly.setText("<html><center>Higher Than<br> Last</center></html>");
			}
	}// END OF WEEKLY
	
	
	private void resetColorOrdering() {
		for(int i = 0; i < OrderCount; i++) {
			orderPanel.orderLPanel.opd.orderList[i].setBackground(Color.WHITE);
		}
	}
	
	private void resetColorCancel() {
		for(int i = 0; i < CancelOrderCount; i++) {
			cancelOrderPanel.orderLPanel.opd.orderList[i].setBackground(Color.WHITE);
		}
	}
	
	private void resetColorConfirm() {
		for(int i = 0; i < confirmationCounter; i++) {
			confirmListPanelData.confirmList[i].setBackground(Color.WHITE);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getSource() == lblUsername) {
			
			if(AccountLevel.equals("Admin--") || AccountLevel.equals("Manager-Marketing-All") || AccountLevel.equals("SuperAdmin--")) {
				moduleSelection.setBounds(lblUsername.getX() + 30, lblUsername.getY() - 80, 270, 105);
				moduleSelection.setVisible(true);
			} else {
				accSetting.setBounds(lblUsername.getX() + 30, lblUsername.getY() - 50, 200, 32);
				accSetting.setVisible(true);
			}
		}
		
        Component clickedComponent = e.getComponent();
        Component clickedComponent1 = e.getComponent();
        Component clickedComponent2 = e.getComponent();
        Component clickedComponent3 = e.getComponent();
        Component clickedComponent4 = e.getComponent();

        // Pre Reg
        if(preReg.preReg.panel != null) {
            if (clickedComponent instanceof JPanel) {
                for (int i = 0; i < rowCount; i++) {
                    if (clickedComponent == preReg.preReg.panel[i]) {
                        preRegDataSetter(i);
                        return;
                    }
                }
            }
        }

    	// OrderList
        if(clickedComponent1 instanceof JPanel) {
            for (int i = 0; i < OrderCount; i++) {
                if (clickedComponent == orderPanel.orderLPanel.opd.orderList[i]) {
                    OrderListIndexClicked = i;
                    resetColorOrdering();
                    orderPanel.orderLPanel.opd.orderList[i].setBackground(new Color(131,255,165));
                    orderPanel.main.setRowCount(0);
                    orderPanel.table.setModel(orderPanel.main);
                    panelDataSetter();
                    return;
                }
            }
        }

    	// CancelOrderList
        if(clickedComponent2 instanceof JPanel) {
            for (int i = 0; i < CancelOrderCount; i++) {
                if (clickedComponent == cancelOrderPanel.orderLPanel.opd.orderList[i]) {
                    CancelOrderListIndexClicked = i;
                    resetColorCancel();
                    cancelOrderPanel.orderLPanel.opd.orderList[i].setBackground(new Color(131,255,165));
                    cancelOrderPanel.main.setRowCount(0);
                    cancelOrderPanel.table.setModel(cancelOrderPanel.main);
                    cancelpanelDataSetter();
                    return;
                }
            }
        }
        
        // ConfirmPanel
        if(clickedComponent3 instanceof JPanel) {
            for (int i = 0; i < confirmationCounter; i++) {
                if (clickedComponent == confirmListPanelData.confirmList[i]) {
                	ConfirmProductList = i;
                    resetColorConfirm();
                    confirmListPanelData.confirmList[i].setBackground(new Color(131,255,165));
                	confirmationPanel.main.setRowCount(0);
                	confirmationPanel.btnConfirm.setVisible(true);
                	if(confirmListPanelData.Status[ConfirmProductList].equals("COMPLETED"))
                    	confirmationPanel.btnConfirm.setVisible(false);
                	confirmClickData();
                    return;
                }
            }
        }

        
//        for (int i = 0; i < OrderCount; i++) {
//            if ((JPanel)clickedComponent == orderPanel.orderLPanel.opd.orderList[i]) {
//            	OrderListIndexClicked = i;
//                orderPanel.main.setRowCount(0);
//                orderPanel.table.setModel(orderPanel.main);
//                panelDataSetter();
//                break;
//            }
//        }

        
	}
	
//	private void preRegList() {
//		try {
//			preReg.preReg.lblAddress
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error PreRegList: " + e.getMessage());
//		}
//	}
	
	private void preRegDataSetter(int index) {
		regID = preReg.preReg.rowID.get(index).toString();
//		System.out.println(regID); // debugging
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
			preReg.reg.txtUsername.setText(Email);

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "preRegDataSetter ERROR: " + e.getMessage());
		}
	}
	
	private void panelDataSetter() {
		try {
			if(!orderClickIdentifier.equals("cust"))
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
	            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
	            Date date = inputFormat.parse(rs.getString(2));
	            String outputDate = outputFormat.format(date);
	        	orderPanel.lblOrderD.setText(outputDate);
	        	orderPanel.lblAdd.setText(rs.getString(7));
	        	tableData.add(rs.getString(3));
	        	tableData.add(rs.getString(4));
	        	tableData.add(rs.getString(5));
	        	tableData.add(rs.getString(8));
	        	tableData.add(rs.getString(6));
	        	orderPanel.main.addRow(tableData.toArray());
	        	tableData.clear();
	        	TotalQuantity += Integer.parseInt(rs.getString(4));
	        	double discount = Double.parseDouble(rs.getString(8));
	        	TotalDiscount += discount;
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
	
	private void cancelpanelDataSetter() {
		try {
			refNum = this.cancelOrderPanel.orderLPanel.opd.lblRefNumber[CancelOrderListIndexClicked].getText();
			cancelOrderPanel.lblRef.setText(refNum);
			cancelOrderPanel.lblCustName.setText(this.cancelOrderPanel.orderLPanel.opd.lblName[CancelOrderListIndexClicked].getText());
	        String sql = "SELECT a.OrderRefNumber, a.OrderDate, b.ProductName, b.Quantity, b.Price, (b.Quantity*b.Price) As Total, a.Address, c.Discount, d.CancelDate, d.Reason "
	        		+ "FROM tblorderarchive AS a "
	        		+ "JOIN tblordercheckoutdataarchive AS b ON a.OrderRefNumber = b.OrderRefNumber "
	        		+ "JOIN tblcustomerinformation AS c ON a.UserID = c.UserID "
	        		+ "JOIN tblcancelledorder AS d ON d.OrderRefNumber = a.OrderRefNumber "
	        		+ "WHERE a.OrderRefNumber = '" + refNum + "'";
	        st.execute(sql);
	        rs = st.getResultSet();
	        ArrayList tableData = new ArrayList<>();

	        int TotalQuantity = 0;
	        int TotalDiscount = 0;
	        int TotalAmount = 0;
	        while(rs.next()) {
	            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
	            Date date = inputFormat.parse(rs.getString(2));
	            String outputDate = outputFormat.format(date);
	            cancelOrderPanel.lblOrderD.setText(outputDate);
	            cancelOrderPanel.lblAdd.setText(rs.getString(7));
	            date = inputFormat.parse(rs.getString(9));
	            outputDate = outputFormat.format(date);
	            cancelOrderPanel.lblCancelledDate.setText(outputDate);
	            cancelOrderPanel.cancelReason.setText("Cancellation Reason: "+ rs.getString(10));
	        	tableData.add(rs.getString(3));
	        	tableData.add(rs.getString(4));
	        	tableData.add(rs.getString(5));
	        	tableData.add(rs.getString(8));
	        	tableData.add(rs.getString(6));
	        	cancelOrderPanel.main.addRow(tableData.toArray());
	        	tableData.clear();
	        	TotalQuantity += Integer.parseInt(rs.getString(4));
	        	double discount = Double.parseDouble(rs.getString(8));
	        	TotalDiscount += discount;
	        	TotalAmount += Integer.parseInt(rs.getString(6));
	        }
	        

	        int TotalItem = cancelOrderPanel.table.getRowCount();
	        
	        cancelOrderPanel.lblItemCount.setText("Item: " + TotalItem);
	        cancelOrderPanel.lblQuantityCount.setText("Total Quantity: " + TotalQuantity);
	        cancelOrderPanel.lblDiscount.setText("Total Discount: " + TotalItem);
	        cancelOrderPanel.lblTotalAmount.setText("Total Amount: " + TotalAmount);
	        
		}catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR cancelpanelDataSetter: " + e.getMessage());
		}
	}
	
	private void orderStatusSetter() {
		try {
			

        	orderPanel.btnApproved.removeActionListener(this);
        	orderPanel.btnToShip.removeActionListener(this);
        	orderPanel.btnDelivery.removeActionListener(this);
        	orderPanel.btnDeliveryComplete.removeActionListener(this);
        	orderPanel.btnInvoice.removeActionListener(this);
			
			orderPanel.btnApproved.setBackground(Color.white);
			orderPanel.btnToShip.setBackground(Color.white);
			orderPanel.btnDelivery.setBackground(Color.white);
			orderPanel.btnDeliveryComplete.setBackground(Color.white);
			orderPanel.btnInvoice.setBackground(Color.white);
			
			
	        String sqlOrderStatus = "SELECT status FROM tblorderstatus WHERE OrderRefNumber = '" + refNum + "'";
	        st.execute(sqlOrderStatus);
	        rs = st.getResultSet();
	        String status = "";
	        while(rs.next()) {
	        	status = rs.getString(1);
	        }
	        
	        if(status.equalsIgnoreCase("toPay")) {
	        	orderPanel.btnApproved.addActionListener(this);
	        } else if(status.equals("Approved")) {
	        	orderPanel.btnApproved.removeActionListener(this);
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        }
	        else if(status.equalsIgnoreCase("toship")) {
	        	orderPanel.btnApproved.removeActionListener(this);
	        	orderPanel.btnToShip.removeActionListener(this);
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnToShip.setBackground(new Color(13, 164, 0));
	        }else if(status.equalsIgnoreCase("Delivery")) {
	        	orderPanel.btnApproved.removeActionListener(this);
	        	orderPanel.btnToShip.removeActionListener(this);
	        	orderPanel.btnDelivery.removeActionListener(this);
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnToShip.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        }else if(status.equalsIgnoreCase("Completed")) {
	        	orderPanel.btnApproved.removeActionListener(this);
	        	orderPanel.btnToShip.removeActionListener(this);
	        	orderPanel.btnDelivery.removeActionListener(this);
	        	orderPanel.btnDeliveryComplete.removeActionListener(this);
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnToShip.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDeliveryComplete.setBackground(new Color(13, 164, 0));
	        }else if(status.equalsIgnoreCase("Invoice")) {
	        	orderPanel.btnApproved.removeActionListener(this);
	        	orderPanel.btnToShip.removeActionListener(this);
	        	orderPanel.btnDelivery.removeActionListener(this);
	        	orderPanel.btnDeliveryComplete.removeActionListener(this);
	        	orderPanel.btnInvoice.removeActionListener(this);
	        	orderPanel.btnApproved.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnToShip.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDelivery.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnDeliveryComplete.setBackground(new Color(13, 164, 0));
	        	orderPanel.btnInvoice.setBackground(new Color(13, 164, 0));
	        }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR ORDER STATUS: " + e.getMessage());
		}
	}
	
	private void DeliveryFuncDefault() {
		TableChecher = "dTB1";
		setVisiblePanel();
		delStatus.setVisible(true);
		delStatus.panel1.add(dTB1);
		delStatus.panel1.remove(dTB2);
		delStatus.btnListOfDelivery.setBackground(new Color(75, 119, 71));
		delStatus.btnListOfDelivery.setForeground(Color.WHITE);
		delStatus.btnCompleted.setBackground(Color.WHITE);
		delStatus.btnCompleted.setForeground(Color.BLACK);
		try {
			dTB1.main.setRowCount(0);
			ArrayList arrDelList = new ArrayList<>();
			String SQL = "SELECT DATE(a.OrderDate), a.OrderRefNumber, b.deliveryID, DATE(c.DeliveryDate), a.address, d.Status, b.courierID \r\n"
					+ "FROM tblordercheckout AS a \r\n"
					+ "JOIN tblcourierdelivery AS b ON b.OrderRefNumber = a.OrderRefNumber \r\n"
					+ "JOIN tblcourierdeliverydate AS c ON b.OrderRefNumber = c.OrderRefNumber \r\n"
					+ "JOIN tblorderstatus AS d ON d.OrderRefNumber = a.OrderRefNumber\r\n"
					+ "WHERE d.Status = 'Delivery'";
			
//			System.out.println(SQL);
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next()) {
				arrDelList.add(rs.getString(1));
				
				arrDelList.add(rs.getString(2));
				arrDelList.add(rs.getString(3));
				

				arrDelList.add(rs.getString(4));
				arrDelList.add(rs.getString(5));
				
				arrDelList.add(rs.getString(6));
				arrDelList.add(rs.getString(7));
				dTB1.main.addRow(arrDelList.toArray());
				arrDelList.clear();
			}
			dTB1.table.setModel(dTB1.main);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DeliveryFuncERROR: " + e.getMessage());
		}
	}
	
	private void DeliveryFuncCompleted() {
		TableChecher = "dTB2";
		delStatus.panel1.add(dTB2);
		delStatus.panel1.remove(dTB1);
		delStatus.btnCompleted.setBackground(new Color(75, 119, 71));
		delStatus.btnCompleted.setForeground(Color.WHITE);
		delStatus.btnListOfDelivery.setBackground(Color.WHITE);
		delStatus.btnListOfDelivery.setForeground(Color.BLACK);
		
		try {
			dTB2.main.setRowCount(0);
			ArrayList arrDelList = new ArrayList<>();
			String SQL = "SELECT DATE(a.OrderDate), a.OrderRefNumber, b.deliveryID, DATE(c.DeliveryDate), DATE(e.DeliveryDate), a.address, CONCAT(f.Firstname, ' ', f.Lastname) AS Fullname \n"
					+ "FROM tblordercheckout AS a \n"
					+ "JOIN tblcourierdelivery AS b ON b.OrderRefNumber = a.OrderRefNumber \n"
					+ "JOIN tblcourierdeliverydate AS c ON b.OrderRefNumber = c.OrderRefNumber \n"
					+ "JOIN tblorderstatus AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
					+ "JOIN tblcourierdeliverycompleted AS e ON e.deliveryID = b.deliveryID \n"
					+ "JOIN tblcourierinformation AS f ON f.courierID = b.courierID \n"
					+ "WHERE d.Status = 'Completed';";
			System.out.println(SQL);
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next()) {
				
				arrDelList.add(rs.getString(1));
				
				arrDelList.add(rs.getString(2));
				arrDelList.add(rs.getString(3));
				
				arrDelList.add(rs.getString(4));
				arrDelList.add(rs.getString(5));
				
				arrDelList.add(rs.getString(6));
				arrDelList.add(rs.getString(7));
				dTB2.main.addRow(arrDelList.toArray());
				arrDelList.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DeliveryFuncCompletedERROR: " + e.getMessage());
		}
	}
	
	private void DeliveryFuncSearch(String search) {
		try {
			dTB1.main.setRowCount(0);
			ArrayList arrDelList = new ArrayList<>();
			String SQL = "SELECT DATE(a.OrderDate), a.OrderRefNumber, b.deliveryID, DATE(c.DeliveryDate), a.address, d.Status, b.courierID \n"
					+ "FROM tblordercheckout AS a\r\n"
					+ "JOIN tblcourierdelivery AS b ON b.OrderRefNumber = a.OrderRefNumber \n"
					+ "JOIN tblcourierdeliverydate AS c ON b.OrderRefNumber = c.OrderRefNumber \n"
					+ "JOIN tblorderstatus AS d ON d.OrderRefNumber = a.OrderRefNumber \n"
					+ "JOIN tblcourierinformation AS e ON e.courierID = b.courierID \n"
					+ "WHERE d.Status = 'Delivery' AND (b.CourierID LIKE '%" + search + "%' OR a.OrderRefNumber LIKE '%" + search + "%')";
//			System.out.println(SQL);
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next()) {
				arrDelList.add(rs.getString(1));
				
				arrDelList.add(rs.getString(2));
				arrDelList.add(rs.getString(3));
				
				arrDelList.add(rs.getString(4));
				arrDelList.add(rs.getString(5));
				
				arrDelList.add(rs.getString(6));
				arrDelList.add(rs.getString(7));
				dTB1.main.addRow(arrDelList.toArray());
				arrDelList.clear();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR DeliveryFuncSearch: " + e.getMessage());
		}
	}
	
	private void DeliveryDetailsFunc() {
		if(TableChecher == "dTB1") {
			if(dTB1.table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		if(TableChecher == "dTB2") {
			if(dTB2.table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Please select a row in the table.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		try {
			delDetails.main.setRowCount(0);
			String DelDetailRef = "";
			if(TableChecher.equals("dTB1"))
				DelDetailRef = dTB1.table.getValueAt(dTB1.table.getSelectedRow(), 1) + "";
			if(TableChecher.equals("dTB2"))
				DelDetailRef = dTB2.table.getValueAt(dTB2.table.getSelectedRow(), 1) + "";
			
			delDetails.lblRef.setText(DelDetailRef);
	        String sql = "SELECT CONCAT(b.ProductName, ' (', b.volume, ')') AS Product, b.Quantity, b.Price, (b.Quantity*b.Price) As Total, CONCAT(c.Firstname, ' ', c.Lastname) AS CustomerName, DATE(a.OrderDate), a.address \n"
	        		+ "FROM tblordercheckout AS a \n"
	        		+ "JOIN tblordercheckoutdata AS b ON a.OrderRefNumber = b.OrderRefNumber \n"
	        		+ "JOIN tblcustomerinformation AS c ON a.UserID = c.UserID\n"
	        		+ "WHERE a.OrderRefNumber = '" + DelDetailRef + "';";
	        st.execute(sql);
	        rs = st.getResultSet();
	        ArrayList temp = new ArrayList<>();
	        
	        int TotalQuantity = 0;
	        int TotalDiscount = 0;
	        int TotalAmount = 0;

	        while(rs.next()) {
	        	temp.add(rs.getString(1)); // Product Name
	        	temp.add(rs.getString(2)); // Quantity
	        	temp.add(rs.getString(3)); // Price
	        	temp.add(0); // Discount
	        	temp.add(rs.getString(4)); // Total Price
	        	delDetails.main.addRow(temp.toArray());
	        	delDetails.lblCustName.setText(rs.getString(5));
	        	delDetails.lblOrderD.setText(rs.getString(6));
	        	delDetails.lblAdd.setText(rs.getString(7));
	        	
	        	TotalQuantity += Integer.parseInt(rs.getString(2));
	        	double discount = 0.0;
	        	TotalDiscount += discount;
	        	TotalAmount += Integer.parseInt(rs.getString(4));
	        }
	        
	        int TotalItem = delDetails.table.getRowCount();
	        delDetails.lblItemCount.setText("Item: " + TotalItem);
	        delDetails.lblQuantityCount.setText("Total Quantity: " + TotalQuantity);
	        delDetails.lblDiscount.setText("Total Discount: " + TotalDiscount);
	        delDetails.lblTotalAmount.setText("Total Amount: " + TotalAmount);
		}catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR cancelpanelDataSetter: " + e.getMessage());
		}
		
		delDetails.setVisible(true);
	}

	private void noticListSetter() {
		try {
//			preReg = new preRegister();
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cancelOrderPanel.cbCategory) {
			try {
				setVisiblePanel();
				cancelOrderPanel.setVisible(true);
				cancelclearOrderPanelMouseListeners();
				cancelorderCounterCB();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error cancelOrderPanel.cbCategory: " + e2.getMessage());
			}
		}
		if(e.getSource() == orderPanel.cbCategory)
			try {
				setVisiblePanel();
				orderPanel.setVisible(true);
				clearOrderPanelMouseListeners();
				orderCounterCB();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error orderPanel.cbCategory: " + e2.getMessage());
			}
		if(e.getSource() == confirmListPanel.comboBox){
			setVisiblePanel();
			confirmationPanel.setVisible(true);
			ConfirmProductPanelMouseListeners();
			confirmationCounterCategory();
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            Date selectedDate = auditTrail.dateChooser.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(selectedDate);
            
    		setVisiblePanel();
    		auditTrail.setVisible(true);
    		
    		try {
    			auditTrail.main.setRowCount(0);
    			String SQL = "SELECT DATE_FORMAT(a.DateAction, '%Y-%m-%d') AS formatted_date, \n"
    					+ "       DATE_FORMAT(a.DateAction, '%h:%i %p') AS formatted_time, \n"
    					+ "       CONCAT(b.FirstName, ' ', b.LastName) AS FullName, \n"
    					+ "       a.Description \n"
    					+ "FROM audittrailmarketing As a \n"
    					+ "JOIN tblaccountinfo AS b ON a.UserID = b.AccountID \n"
    					+ "WHERE DATE(a.DateAction) = '" + formattedDate + "' \n"
    					+ "ORDER BY a.DateAction DESC;";
    			
    			st.execute(SQL);
    			ArrayList temp = new ArrayList<>();
    			rs = st.getResultSet();
    			int i = 0;
    			while(rs.next()) {
    				String formattedText = "<html><center>" + rs.getString(1) + "<br>" + rs.getString(2) + "</center></html>";
//    				temp.add(rs.getString(1) + ", " + rs.getString(2));
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
		
	}
}
