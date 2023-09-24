package KBN.Module.Marketing.ClientProfile;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class ClientProfile extends JPanel {

	public JScrollPane scrollOrderPanel;
	public JLabel lblClientName;
	public JLabel lblBrand;
	public JLabel lblDetails;
	
	public JLabel lblProducts;
	public JLabel lblOrders;
	public JLabel lblOrderHistory;
	
	public JLabel lblWeeklyPercent;
	public JLabel lblPercentIconWeekly;
	public JLabel lblTextWeekly;
	
	public JLabel lblMonthlyPercent;
	public JLabel lblPercentIconMonthly;
	public JLabel lblTextMonthly;
	
	public JLabel lblYearlyPercent;
	public JLabel lblTextYearly;
	public JLabel lblPercentIconYearly;

	public JPanel panelClientProfile;
	public JPanel panelProducts;
	public JPanel panelWeekly;
	private JPanel panelMonthly;
	private JPanel panelYearly;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JPanel orderPanelContainer;
	public JButton btnUpdate;
	public JLabel lblDiscount;
	
	public ClientProfile() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 989, 699);
		setLayout(null);
		
		orderPanelContainer = new JPanel();
		orderPanelContainer.setBackground(new Color(151, 175, 149));
		orderPanelContainer.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		orderPanelContainer.setBounds(14, 167, 250, 521);
		add(orderPanelContainer);
		orderPanelContainer.setLayout(null);
		
		panelWeekly = new JPanel();
		panelWeekly.setBackground(new Color(255, 255, 255));
		panelWeekly.setBounds(25, 72, 200, 110);
		orderPanelContainer.add(panelWeekly);
		panelWeekly.setLayout(null);
		
		JLabel lblWeeklyTitle = new JLabel("Weekly Orders");
		lblWeeklyTitle.setForeground(new Color(255, 255, 255));
		lblWeeklyTitle.setBackground(new Color(8, 104, 0));
		lblWeeklyTitle.setOpaque(true);
		lblWeeklyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeeklyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWeeklyTitle.setBounds(0, 0, 200, 27);
		panelWeekly.add(lblWeeklyTitle);
		
		lblWeeklyPercent = new JLabel("101");
		lblWeeklyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeeklyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeeklyPercent.setBounds(0, 31, 91, 27);
		panelWeekly.add(lblWeeklyPercent);
		
		lblPercentIconWeekly = new JLabel("");
		lblPercentIconWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconWeekly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconWeekly.setBounds(84, 31, 32, 32);
		panelWeekly.add(lblPercentIconWeekly);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/chart.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon.setBounds(126, 34, 64, 64);
		panelWeekly.add(lblIcon);
		
		lblTextWeekly = new JLabel("");
		lblTextWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextWeekly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextWeekly.setBounds(19, 69, 72, 29);
		panelWeekly.add(lblTextWeekly);
		
		panelMonthly = new JPanel();
		panelMonthly.setBackground(new Color(255, 255, 255));
		panelMonthly.setBounds(25, 229, 200, 110);
		orderPanelContainer.add(panelMonthly);
		panelMonthly.setLayout(null);
		
		JLabel lblMonthlyTitle = new JLabel("Monthly Orders");
		lblMonthlyTitle.setOpaque(true);
		lblMonthlyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonthlyTitle.setForeground(Color.WHITE);
		lblMonthlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonthlyTitle.setBackground(new Color(206, 124, 0));
		lblMonthlyTitle.setBounds(0, 0, 200, 27);
		panelMonthly.add(lblMonthlyTitle);
		
		lblMonthlyPercent = new JLabel("101");
		lblMonthlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthlyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonthlyPercent.setBounds(0, 31, 91, 27);
		panelMonthly.add(lblMonthlyPercent);
		
		lblPercentIconMonthly = new JLabel("");
		lblPercentIconMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconMonthly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconMonthly.setBounds(84, 31, 32, 32);
		panelMonthly.add(lblPercentIconMonthly);
		
		JLabel lblIcon_1 = new JLabel("");
		lblIcon_1.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/chart.png")));
		lblIcon_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon_1.setBounds(126, 34, 64, 64);
		panelMonthly.add(lblIcon_1);
		
		lblTextMonthly = new JLabel("");
		lblTextMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMonthly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextMonthly.setBounds(19, 69, 72, 29);
		panelMonthly.add(lblTextMonthly);
		
		panelYearly = new JPanel();
		panelYearly.setBackground(new Color(255, 255, 255));
		panelYearly.setBounds(25, 386, 200, 110);
		orderPanelContainer.add(panelYearly);
		panelYearly.setLayout(null);
		
		JLabel lblYearlyTitle = new JLabel("Yearly Orders");
		lblYearlyTitle.setOpaque(true);
		lblYearlyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblYearlyTitle.setForeground(Color.WHITE);
		lblYearlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYearlyTitle.setBackground(new Color(36, 0, 255));
		lblYearlyTitle.setBounds(0, 0, 200, 27);
		panelYearly.add(lblYearlyTitle);
		
		lblYearlyPercent = new JLabel("101");
		lblYearlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearlyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYearlyPercent.setBounds(0, 31, 91, 27);
		panelYearly.add(lblYearlyPercent);
		
		lblPercentIconYearly = new JLabel("");
		lblPercentIconYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconYearly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconYearly.setBounds(84, 31, 32, 32);
		panelYearly.add(lblPercentIconYearly);
		
		JLabel lblIcon_2 = new JLabel("");
		lblIcon_2.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/chart.png")));
		lblIcon_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon_2.setBounds(126, 34, 64, 64);
		panelYearly.add(lblIcon_2);
		
		lblTextYearly = new JLabel("");
		lblTextYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextYearly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextYearly.setBounds(19, 69, 72, 29);
		panelYearly.add(lblTextYearly);
		
		JLabel lblOrderReport = new JLabel("Orders Report");
		lblOrderReport.setForeground(new Color(8, 104, 0));
		lblOrderReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderReport.setBackground(new Color(255, 255, 255));
		lblOrderReport.setOpaque(true);
		lblOrderReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderReport.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblOrderReport.setBounds(25, 11, 200, 30);
		orderPanelContainer.add(lblOrderReport);
		
		panelClientProfile = new JPanel();
		panelClientProfile.setBackground(new Color(255, 255, 255));
		panelClientProfile.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClientProfile.setBounds(14, 11, 960, 145);
		add(panelClientProfile);
		panelClientProfile.setLayout(null);
		
		lblClientName = new JLabel("Client Name");
		lblClientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClientName.setBounds(10, 11, 244, 31);
		panelClientProfile.add(lblClientName);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBrand.setBounds(264, 11, 244, 31);
		panelClientProfile.add(lblBrand);
		
		lblDetails = new JLabel("Client Details");
		lblDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDetails.setBounds(10, 53, 244, 81);
		panelClientProfile.add(lblDetails);
		
		JPanel panelDiscount = new JPanel();
		panelDiscount.setLayout(null);
		panelDiscount.setBackground(Color.WHITE);
		panelDiscount.setBounds(743, 11, 207, 123);
		panelClientProfile.add(panelDiscount);
		
		JLabel lblClientRate = new JLabel("Cleint Rate");
		lblClientRate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientRate.setBounds(5, 5, 73, 22);
		panelDiscount.add(lblClientRate);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBounds(105, 5, 92, 22);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		btnNewButton.setOpaque(false);
		btnUpdate.setBackground(new Color(8, 104, 0));
		btnUpdate.setBorderPainted(false);
		btnUpdate.setFocusable(false);
		panelDiscount.add(btnUpdate);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(5, 31, 192, 9);
		panelDiscount.add(separator_3);
		
		lblDiscount = new JLabel("");
		lblDiscount.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/0.png")));
		lblDiscount.setBounds(68, 38, 74, 74);
		panelDiscount.add(lblDiscount);
		
		panelProducts = new JPanel();
		panelProducts.setBackground(new Color(255, 255, 255));
		panelProducts.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelProducts.setBounds(292, 167, 682, 521);
		add(panelProducts);
		panelProducts.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 40, 635, 11);
		panelProducts.add(separator);
		
		lblOrders = new JLabel("Order(s)");
		lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrders.setBorder(new LineBorder(new Color(8, 104, 0), 1, true));
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrders.setBounds(25, 11, 94, 22);
		panelProducts.add(lblOrders);
		
		lblOrderHistory = new JLabel("Order History");
		lblOrderHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderHistory.setBorder(new LineBorder(new Color(8, 104, 0), 1, true));
		lblOrderHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrderHistory.setBounds(158, 11, 94, 22);
		panelProducts.add(lblOrderHistory);
		
		lblProducts = new JLabel("Own Products");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setBorder(new LineBorder(new Color(8, 104, 0), 1, true));
		lblProducts.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProducts.setBounds(291, 11, 102, 22);
		panelProducts.add(lblProducts);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(129, 11, 18, 23);
		panelProducts.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(262, 11, 18, 23);
		panelProducts.add(separator_2);
		
		scrollOrderPanel = new JScrollPane();
		scrollOrderPanel.setBounds(23, 55, 635, 452);
		panelProducts.add(scrollOrderPanel);
		
	}
}
