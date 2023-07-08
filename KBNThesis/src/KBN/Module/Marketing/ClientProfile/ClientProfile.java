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
	
	public JLabel lblUserIcon;
	public JLabel lblClientName;
	public JLabel lblBrand;
	public JLabel lblNone;
	
	public JLabel lblProducts;
	public JLabel lblOrders;
	public JLabel lblOrderHistory;
	
	public JLabel lblPercent;
	public JLabel lblPercentIcon;
	public JLabel lblIcon;
	public JLabel lblText;
	

	public JPanel panelClientProfile;
	public JPanel panelProducts;
	public JPanel panelWeekly;
	public JPanel panelMonthly;
	public JPanel panelYearly;
	public JPanel panelRate;
	private JLabel lblNewLabel_3;
	private JSeparator separator_1;
	private JSeparator separator_2;
	public JScrollPane scrollOrderPanel;
	

	/**
	 * Create the panel.
	 */
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
		
		lblPercent = new JLabel("101");
		lblPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent.setBounds(0, 31, 46, 27);
		panelWeekly.add(lblPercent);
		
		lblPercentIcon = new JLabel("%");
		lblPercentIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPercentIcon.setBounds(45, 31, 33, 27);
		panelWeekly.add(lblPercentIcon);
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIcon.setBounds(88, 38, 72, 60);
		panelWeekly.add(lblIcon);
		
		lblText = new JLabel("");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblText.setBounds(0, 69, 72, 29);
		panelWeekly.add(lblText);
		
		panelMonthly = new JPanel();
		panelMonthly.setBounds(466, 11, 160, 109);
		add(panelMonthly);
		panelMonthly.setLayout(null);
		
		JLabel lblMonthlyTitle = new JLabel("Monthly Orders");
		lblMonthlyTitle.setForeground(new Color(255, 255, 255));
		lblMonthlyTitle.setBackground(new Color(206, 124, 0));
		lblMonthlyTitle.setOpaque(true);
		lblMonthlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonthlyTitle.setBounds(0, 0, 160, 27);
		panelMonthly.add(lblMonthlyTitle);
		
		panelYearly = new JPanel();
		panelYearly.setBounds(640, 11, 160, 109);
		add(panelYearly);
		panelYearly.setLayout(null);
		
		JLabel lblYearlyTitle = new JLabel("Yearly Orders");
		lblYearlyTitle.setForeground(new Color(255, 255, 255));
		lblYearlyTitle.setBackground(new Color(36, 0, 255));
		lblYearlyTitle.setOpaque(true);
		lblYearlyTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYearlyTitle.setBounds(0, 0, 160, 27);
		panelYearly.add(lblYearlyTitle);
		
		panelRate = new JPanel();
		panelRate.setBounds(814, 11, 160, 109);
		add(panelRate);
		panelRate.setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 160, 27);
		panelRate.add(lblNewLabel_3);
		
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
