package KBN.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.Module.Marketing.AuditTrail;
import KBN.Module.Marketing.CustomerAccount;
import KBN.Module.Marketing.CustomerCreateAccount;
import KBN.Module.Marketing.Dashboard;
import KBN.Module.Marketing.DeliveryStatus;
import KBN.Module.Marketing.KBNProducts;
import KBN.Module.Marketing.OrderListPanelData;
import KBN.Module.Marketing.OrderingPanel;
import KBN.Module.Marketing.RebrandingProd;
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


public class MarketingModule extends JFrame implements ActionListener, MouseListener{

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
	
	// Object
	private Statement st;
	private ResultSet rs;
	
	
	private String refNum;
	
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
	
	
	private int OrderListIndexClicked;
	
	private int OrderCount;

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
		
        // DefaultSetup
        objComponent();
        setUsername();
        orderCounter();
        setActionList();
        setVisiblePanel();
        defaultPanel();
        custAccountFunc();
        
	}
	
	private void orderCounter() {
		try {
			st = dbConn.getConnection().createStatement();
			String sql = "SELECT COUNT(OrderRefNumber) FROM tblordercheckout";
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next())
				OrderCount = rs.getInt(1);
			orderPanel.orderLPanel.opd.iOrderCount(OrderCount);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error OrderCount: " + e.getMessage());
		}
		setOrderListData();
	}
	
	private void setOrderListData() {
		try {
			String sql = "SELECT a.`OrderRefNumber`, a.UserID, b.FirstName, b.LastName FROM tblOrderCheckout AS a JOIN tblcustomerinformation AS b ON a.UserID = b.UserID";
			st.execute(sql);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				orderPanel.orderLPanel.opd.lblRefNumber[i].setText(rs.getString(1));
				orderPanel.orderLPanel.opd.lblName[i].setText(rs.getString(3) + " " + rs.getString(4));
				i++;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR setOrderListData: " + e.getMessage());
		}
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
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
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
		
		//CustomerAccount Panel
		custAccount.btnCreate.addActionListener(this);
		
		//Mouse
		for(int i = 0; i < OrderCount; i++) {
			this.orderPanel.orderLPanel.opd.orderList[i].addMouseListener(this);
		}
		
	}
	
	private void setVisiblePanel() {
		dashboard.setVisible(false);
		kbnProd.setVisible(false);
		rebrandingProd.setVisible(false);
		custAccount.setVisible(false);
		auditTrail.setVisible(false);
		delStatus.setVisible(false);
		orderPanel.setVisible(false);
	}
	
	private void defaultPanel() {
		panelTab.add(dashboard);
		panelTab.add(kbnProd);
		panelTab.add(rebrandingProd);
		panelTab.add(custAccount);
		panelTab.add(auditTrail);
		panelTab.add(delStatus);
		panelTab.add(orderPanel);
		dashboard.setVisible(true);
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
			
		
		//inside Panel 
		if(e.getSource() == custAccount.btnCreate)
			custAccountCreateAccount();
		
		if(e.getSource() == orderPanel.btnApproved)
			System.out.println("APPROVED");
	}
	
	private void dashboardPanelFunc() {
		setVisiblePanel();
		dashboard.setVisible(true);
	}
	
	private void KBNPanelFunc() {
		setVisiblePanel();
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
		orderPanel.setVisible(true);
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
			String sql = "SELECT Firstname, Lastname, Email, Number FROM tblcustomerinformation";
			st.execute(sql);
			
			rs = st.getResultSet();
			ArrayList SQLResult = new ArrayList<>();
			
			while(rs.next()) {
				SQLResult.add(rs.getString(1) + " " + rs.getString(2));
				SQLResult.add(rs.getString(3));
				SQLResult.add(rs.getString(4));
				custAccount.main.addRow(SQLResult.toArray());
				SQLResult.clear();
			}
			custAccount.table.setModel(custAccount.main);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error CustAccFunc: " + e.getMessage());
		}
	}
	
	private void tableOrderList() {
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
        Component clickedComponent = e.getComponent();
        for (int i = 0; i < OrderCount; i++) {
            if (clickedComponent == this.orderPanel.orderLPanel.opd.orderList[i]) {
            	OrderListIndexClicked = i;
                break;
            }
        }
        orderPanel.main.setRowCount(0);
        orderPanel.table.setModel(orderPanel.main);
        panelDataSetter();
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

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
