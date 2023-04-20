package KBN.Module.Marketing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.commons.dataSetter;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MarketingModule extends JFrame implements ActionListener{

	//class
	private dataSetter dataSet;
	private Dashboard dash;
	private CustomerAccount cust;
	private CreateAccountDialog cad;
	
	private JPanel contentPane;
	private JLabel lblUsername;
	private JButton btnDashboard;
	private JButton btnKBN;
	private JButton btnRebranding;
	private JButton btnRawMaterials;
	private JButton btnPackagingMaterials;
	private JButton btnAudit;
	private JButton btnClientProfile;
	private JButton btnOrdering;
	private JButton btnCustomerAccount;
	private JButton btnReturnProducts;
	private JButton btnDeliveryStatus;
	private JPanel panelDisplay;
	private JSeparator separator_2;

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
        
		//Object Declaration
		dash = new Dashboard();
		cust = new CustomerAccount();
		cad = new CreateAccountDialog();
		
        ObjComponents();
        buttonActionLister();
        
		//SetterDefault
        setUsername();
        disablePanel();
        setDefaultPanel();
	}
	
	private void buttonActionLister() {
		//ThisModule
		btnAudit.addActionListener(this);
		btnClientProfile.addActionListener(this);
		btnCustomerAccount.addActionListener(this);
		btnDashboard.addActionListener(this);
		btnDeliveryStatus.addActionListener(this);
		btnKBN.addActionListener(this);
		btnOrdering.addActionListener(this);
		btnPackagingMaterials.addActionListener(this);
		btnRawMaterials.addActionListener(this);
		btnRebranding.addActionListener(this);
		btnReturnProducts.addActionListener(this);
		
		//CustomersAccount
		cust.btnCreateAccount.addActionListener(this);
		cust.btnSearch.addActionListener(this);
	}
	
	private void ObjComponents() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 75);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MarketingModule.class.getResource("/KBN/resources/tempPicture.png")));
		lblLogo.setBounds(29, 11, 99, 53);
		panel.add(lblLogo);
		
		JLabel lblNewLabel_1 = new JLabel("KBN SKIN ESSENTIALS");
		lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 21));
		lblNewLabel_1.setBounds(138, 11, 272, 53);
		panel.add(lblNewLabel_1);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(1033, 17, 135, 40);
		panel.add(lblUsername);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(MarketingModule.class.getResource("/KBN/resources/tempPicture.png")));
		lblLogo_1.setBounds(1178, 11, 61, 53);
		panel.add(lblLogo_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 74, 198, 647);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 178, 15);
		panel_1.add(separator);
		
		JLabel lblNewLabel = new JLabel("Products");
		lblNewLabel.setBounds(10, 68, 65, 14);
		panel_1.add(lblNewLabel);
		
		btnRebranding = new JButton("Rebranding");
		btnRebranding.setHorizontalAlignment(SwingConstants.LEFT);
		btnRebranding.setOpaque(false);
		btnRebranding.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRebranding.setFocusable(false);
		btnRebranding.setBorderPainted(false);
		btnRebranding.setBackground(Color.WHITE);
		btnRebranding.setBounds(10, 139, 178, 35);
		panel_1.add(btnRebranding);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 185, 178, 15);
		panel_1.add(separator_1);
		
		btnKBN = new JButton("KBN");
		btnKBN.setHorizontalAlignment(SwingConstants.LEFT);
		btnKBN.setOpaque(false);
		btnKBN.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnKBN.setFocusable(false);
		btnKBN.setBorderPainted(false);
		btnKBN.setBackground(Color.WHITE);
		btnKBN.setBounds(10, 93, 178, 35);
		panel_1.add(btnKBN);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setOpaque(false);
		btnDashboard.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorderPainted(false);
		btnDashboard.setBackground(Color.WHITE);
		btnDashboard.setBounds(10, 11, 178, 35);
		panel_1.add(btnDashboard);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 328, 178, 15);
		panel_1.add(separator_1_1);
		
		btnPackagingMaterials = new JButton("Packaging Materials");
		btnPackagingMaterials.setHorizontalAlignment(SwingConstants.LEFT);
		btnPackagingMaterials.setOpaque(false);
		btnPackagingMaterials.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnPackagingMaterials.setFocusable(false);
		btnPackagingMaterials.setBorderPainted(false);
		btnPackagingMaterials.setBackground(Color.WHITE);
		btnPackagingMaterials.setBounds(10, 282, 178, 35);
		panel_1.add(btnPackagingMaterials);
		
		btnRawMaterials = new JButton("Raw Materials");
		btnRawMaterials.setHorizontalAlignment(SwingConstants.LEFT);
		btnRawMaterials.setOpaque(false);
		btnRawMaterials.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRawMaterials.setFocusable(false);
		btnRawMaterials.setBorderPainted(false);
		btnRawMaterials.setBackground(Color.WHITE);
		btnRawMaterials.setBounds(10, 236, 178, 35);
		panel_1.add(btnRawMaterials);
		
		JLabel lblMaterials = new JLabel("Materials");
		lblMaterials.setBounds(10, 211, 65, 14);
		panel_1.add(lblMaterials);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientProfile.setOpaque(false);
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
		btnClientProfile.setBorderPainted(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(10, 400, 178, 35);
		panel_1.add(btnClientProfile);
		
		btnAudit = new JButton("Audit Trail");
		btnAudit.setHorizontalAlignment(SwingConstants.LEFT);
		btnAudit.setOpaque(false);
		btnAudit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAudit.setFocusable(false);
		btnAudit.setBorderPainted(false);
		btnAudit.setBackground(Color.WHITE);
		btnAudit.setBounds(10, 354, 178, 35);
		panel_1.add(btnAudit);
		
		btnCustomerAccount = new JButton("Customer Account");
		btnCustomerAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomerAccount.setOpaque(false);
		btnCustomerAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCustomerAccount.setFocusable(false);
		btnCustomerAccount.setBorderPainted(false);
		btnCustomerAccount.setBackground(Color.WHITE);
		btnCustomerAccount.setBounds(10, 492, 178, 35);
		panel_1.add(btnCustomerAccount);
		
		btnOrdering = new JButton("Ordering");
		btnOrdering.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdering.setOpaque(false);
		btnOrdering.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnOrdering.setFocusable(false);
		btnOrdering.setBorderPainted(false);
		btnOrdering.setBackground(Color.WHITE);
		btnOrdering.setBounds(10, 446, 178, 35);
		panel_1.add(btnOrdering);
		
		btnDeliveryStatus = new JButton("Delivery Status");
		btnDeliveryStatus.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeliveryStatus.setOpaque(false);
		btnDeliveryStatus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDeliveryStatus.setFocusable(false);
		btnDeliveryStatus.setBorderPainted(false);
		btnDeliveryStatus.setBackground(Color.WHITE);
		btnDeliveryStatus.setBounds(10, 584, 178, 35);
		panel_1.add(btnDeliveryStatus);
		
		btnReturnProducts = new JButton("Return Products");
		btnReturnProducts.setHorizontalAlignment(SwingConstants.LEFT);
		btnReturnProducts.setOpaque(false);
		btnReturnProducts.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnReturnProducts.setFocusable(false);
		btnReturnProducts.setBorderPainted(false);
		btnReturnProducts.setBackground(Color.WHITE);
		btnReturnProducts.setBounds(10, 538, 178, 35);
		panel_1.add(btnReturnProducts);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(197, 0, 11, 647);
		panel_1.add(separator_2);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		
		panelDisplay = new JPanel();
		panelDisplay.setBounds(198, 74, 1066, 647);
		contentPane.add(panelDisplay);
		panelDisplay.setLayout(null);
	}
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
	}
	
	private void setDefaultPanel() {
		panelDisplay.add(dash);
		panelDisplay.add(cust);
		dash.setVisible(true);
	}
	
	private void disablePanel() {
		dash.setVisible(false);
		cust.setVisible(false);
	}
	
	private void btnDashboardFunc() {
		disablePanel();
		dash.setVisible(true);
	}
	
	private void btnCustomerAccountFunc() {
		disablePanel();
		cust.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDashboard) {
			btnDashboardFunc();
		}
		else if(e.getSource() == btnCustomerAccount) {
			btnCustomerAccountFunc();
		}
		if(e.getSource() == cust.btnCreateAccount) {
			cad.setVisible(true);
		}
	}
}
