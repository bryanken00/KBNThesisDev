package KBN.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.Module.Marketing.AuditTrail;
import KBN.Module.Marketing.CustomerAccount;
import KBN.Module.Marketing.Dashboard;
import KBN.Module.Marketing.DeliveryStatus;
import KBN.Module.Marketing.KBNProducts;
import KBN.Module.Marketing.RebrandingProd;
import KBN.commons.DbConnection;
import KBN.commons.dataSetter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;


public class MarketingModule extends JFrame implements ActionListener{

	//Class Import
	private DbConnection dbConn;
	private dataSetter dataSet;
	private Dashboard dashboard;
	private KBNProducts kbnProd;
	private RebrandingProd rebrandingProd;
	private CustomerAccount custAccount;
	private AuditTrail auditTrail;
	private DeliveryStatus delStatus;
	
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
        
        
        //declaration
        dbConn = new DbConnection();
		dashboard = new Dashboard();
		kbnProd = new KBNProducts();
		rebrandingProd = new RebrandingProd();
		custAccount = new CustomerAccount();
		auditTrail = new AuditTrail();
		delStatus = new DeliveryStatus();
        
        //defaultSetup
        objComponent();
        setUsername();
        setActionList();
        setVisiblePanel();
        defaultPanel();
        
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
	}
	
	private void setVisiblePanel() {
		dashboard.setVisible(false);
		kbnProd.setVisible(false);
		rebrandingProd.setVisible(false);
		custAccount.setVisible(false);
		auditTrail.setVisible(false);
		delStatus.setVisible(false);
	}
	
	private void defaultPanel() {
		panelTab.add(dashboard);
		panelTab.add(kbnProd);
		panelTab.add(rebrandingProd);
		panelTab.add(custAccount);
		panelTab.add(auditTrail);
		panelTab.add(delStatus);
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

}
