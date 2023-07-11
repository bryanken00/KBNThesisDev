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

public class ClientProfile extends JPanel {

	public JScrollPane scrollOrderPanel;
	
	public JLabel lblUserIcon;
	public JLabel lblClientName;
	public JLabel lblBrand;
	public JLabel lblNone;
	
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
	public JPanel panelRate;
	private JPanel panelMonthly;
	private JPanel panelMonthly_1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	
	public ClientProfile() {
		this.setBounds(0, 0, 989, 699);
		setLayout(null);
		
		panelClientProfile = new JPanel();
		panelClientProfile.setBounds(14, 11, 264, 677);
		add(panelClientProfile);
		panelClientProfile.setLayout(null);
		
		lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(10, 11, 244, 181);
		panelClientProfile.add(lblUserIcon);
		
		lblClientName = new JLabel("New label");
		lblClientName.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClientName.setBounds(10, 274, 244, 31);
		panelClientProfile.add(lblClientName);
		
		lblBrand = new JLabel("New label");
		lblBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBrand.setBounds(10, 348, 244, 31);
		panelClientProfile.add(lblBrand);
		
		lblNone = new JLabel("New label");
		lblNone.setHorizontalAlignment(SwingConstants.CENTER);
		lblNone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNone.setBounds(10, 422, 244, 31);
		panelClientProfile.add(lblNone);
		
		panelWeekly = new JPanel();
		panelWeekly.setBounds(292, 11, 160, 109);
		add(panelWeekly);
		panelWeekly.setLayout(null);
		
		JLabel lblWeeklyTitle = new JLabel("Weekly Orders");
		lblWeeklyTitle.setForeground(new Color(255, 255, 255));
		lblWeeklyTitle.setBackground(new Color(8, 104, 0));
		lblWeeklyTitle.setOpaque(true);
		lblWeeklyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeeklyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWeeklyTitle.setBounds(0, 0, 160, 27);
		panelWeekly.add(lblWeeklyTitle);
		
		lblWeeklyPercent = new JLabel("101");
		lblWeeklyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeeklyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeeklyPercent.setBounds(0, 31, 64, 27);
		panelWeekly.add(lblWeeklyPercent);
		
		lblPercentIconWeekly = new JLabel("");
		lblPercentIconWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconWeekly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconWeekly.setBounds(59, 31, 32, 32);
		panelWeekly.add(lblPercentIconWeekly);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/chart.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon.setBounds(88, 38, 64, 64);
		panelWeekly.add(lblIcon);
		
		lblTextWeekly = new JLabel("");
		lblTextWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextWeekly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextWeekly.setBounds(0, 69, 72, 29);
		panelWeekly.add(lblTextWeekly);
		
		panelMonthly = new JPanel();
		panelMonthly.setLayout(null);
		panelMonthly.setBounds(466, 11, 160, 109);
		add(panelMonthly);
		
		JLabel lblMonthlyTitle = new JLabel("Monthly Orders");
		lblMonthlyTitle.setOpaque(true);
		lblMonthlyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonthlyTitle.setForeground(Color.WHITE);
		lblMonthlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonthlyTitle.setBackground(new Color(8, 104, 0));
		lblMonthlyTitle.setBounds(0, 0, 160, 27);
		panelMonthly.add(lblMonthlyTitle);
		
		lblMonthlyPercent = new JLabel("101");
		lblMonthlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthlyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonthlyPercent.setBounds(0, 31, 64, 27);
		panelMonthly.add(lblMonthlyPercent);
		
		lblPercentIconMonthly = new JLabel("");
		lblPercentIconMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconMonthly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconMonthly.setBounds(59, 31, 32, 32);
		panelMonthly.add(lblPercentIconMonthly);
		
		JLabel lblIcon_1 = new JLabel("");
		lblIcon_1.setIcon(new ImageIcon(ClientProfile.class.getResource("/KBN/resources/Marketing/ClientProfile/chart.png")));
		lblIcon_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon_1.setBounds(88, 38, 64, 64);
		panelMonthly.add(lblIcon_1);
		
		lblTextMonthly = new JLabel("");
		lblTextMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMonthly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextMonthly.setBounds(0, 69, 72, 29);
		panelMonthly.add(lblTextMonthly);
		
		panelMonthly_1 = new JPanel();
		panelMonthly_1.setLayout(null);
		panelMonthly_1.setBounds(640, 11, 160, 109);
		add(panelMonthly_1);
		
		JLabel lblYearlyTitle = new JLabel("Yearly Orders");
		lblYearlyTitle.setOpaque(true);
		lblYearlyTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblYearlyTitle.setForeground(Color.WHITE);
		lblYearlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYearlyTitle.setBackground(new Color(8, 104, 0));
		lblYearlyTitle.setBounds(0, 0, 160, 27);
		panelMonthly_1.add(lblYearlyTitle);
		
		lblYearlyPercent = new JLabel("101");
		lblYearlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearlyPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYearlyPercent.setBounds(0, 31, 64, 27);
		panelMonthly_1.add(lblYearlyPercent);
		
		lblPercentIconYearly = new JLabel("");
		lblPercentIconYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIconYearly.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIconYearly.setBounds(59, 31, 32, 32);
		panelMonthly_1.add(lblPercentIconYearly);
		
		JLabel lblIcon_2 = new JLabel("");
		lblIcon_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon_2.setBounds(88, 38, 64, 64);
		panelMonthly_1.add(lblIcon_2);
		
		lblTextYearly = new JLabel("");
		lblTextYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextYearly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTextYearly.setBounds(0, 69, 72, 29);
		panelMonthly_1.add(lblTextYearly);
		
		panelRate = new JPanel();
		panelRate.setBounds(814, 11, 160, 109);
		add(panelRate);
		panelRate.setLayout(null);
		
		panelProducts = new JPanel();
		panelProducts.setBounds(292, 131, 682, 557);
		add(panelProducts);
		panelProducts.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 67, 635, 11);
		panelProducts.add(separator);
		
		lblOrders = new JLabel("Order(s)");
		lblOrders.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrders.setBounds(25, 38, 80, 22);
		panelProducts.add(lblOrders);
		
		lblOrderHistory = new JLabel("Order History");
		lblOrderHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrderHistory.setBounds(158, 38, 80, 22);
		panelProducts.add(lblOrderHistory);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(129, 37, 18, 25);
		panelProducts.add(separator_1);
		
		lblProducts = new JLabel("Own Products");
		lblProducts.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProducts.setBounds(291, 38, 80, 22);
		panelProducts.add(lblProducts);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(262, 37, 18, 25);
		panelProducts.add(separator_2);
		
		scrollOrderPanel = new JScrollPane();
		scrollOrderPanel.setBounds(23, 82, 635, 452);
		panelProducts.add(scrollOrderPanel);
		
	}
}
