package KBN.Module.Marketing.dashboard;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Dashboard1 extends JPanel {
	
	private JLabel lblDaily;
	public JScrollPane orderList;
	private JLabel lblWeekly;
	private JLabel lblMonthly;
	private JLabel lblYearly;

	public JPanel panelOrderList;
	public JPanel panelGraph;
	public JLabel lblDailyPercent;
	public JLabel lblWeeklyPercent;
	public JLabel lblMonthlyPercent;
	public JLabel lblYearlyPercent;
	public JPanel panelOutofStock;
	public JPanel panelSufficentStock;
	public JPanel panelCritLevel;
	public JLabel lblTimeDiff;

	public Dashboard1() {
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panelDaily = new JPanel();
		panelDaily.setBounds(10, 11, 120, 140);
		add(panelDaily);
		panelDaily.setLayout(null);
		
		lblDaily = new JLabel("Daily Sales");
		lblDaily.setForeground(Color.WHITE);
		lblDaily.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDaily.setBackground(new Color(206,124,0,255));
		lblDaily.setOpaque(true);
		lblDaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily.setBounds(0, 0, 120, 33);
		panelDaily.add(lblDaily);
		
		JLabel label = new JLabel("New label");
		label.setBounds(74, 126, -85, -79);
		panelDaily.add(label);
		
		lblDailyPercent = new JLabel("");
		lblDailyPercent.setBackground(Color.WHITE);
		lblDailyPercent.setOpaque(true);
		lblDailyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/0.png")));
		lblDailyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent.setBounds(0, 33, 120, 107);
		panelDaily.add(lblDailyPercent);
		
		JPanel panelWeekly = new JPanel();
		panelWeekly.setLayout(null);
		panelWeekly.setBounds(140, 11, 120, 140);
		add(panelWeekly);
		
		lblWeekly = new JLabel("Weekly Sales");
		lblWeekly.setForeground(Color.WHITE);
		lblWeekly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWeekly.setBackground(new Color(193,46,0,255));
		lblWeekly.setOpaque(true);
		lblWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekly.setBounds(0, 0, 120, 33);
		panelWeekly.add(lblWeekly);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(74, 126, -85, -79);
		panelWeekly.add(label_1);
		
		lblWeeklyPercent = new JLabel("percentage");
		lblWeeklyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeeklyPercent.setBounds(0, 32, 120, 108);
		panelWeekly.add(lblWeeklyPercent);
		
		JPanel panelMonthly = new JPanel();
		panelMonthly.setLayout(null);
		panelMonthly.setBounds(10, 157, 120, 140);
		add(panelMonthly);
		
		lblMonthly = new JLabel("Monthly Sales");
		lblMonthly.setForeground(Color.WHITE);
		lblMonthly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMonthly.setBackground(new Color(36,0,255,255));
		lblMonthly.setOpaque(true);
		lblMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthly.setBounds(0, 0, 120, 33);
		panelMonthly.add(lblMonthly);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(74, 126, -85, -79);
		panelMonthly.add(label_2);
		
		lblMonthlyPercent = new JLabel("percentage");
		lblMonthlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthlyPercent.setBounds(0, 33, 120, 107);
		panelMonthly.add(lblMonthlyPercent);
		
		JPanel panelYearly = new JPanel();
		panelYearly.setLayout(null);
		panelYearly.setBounds(140, 157, 120, 140);
		add(panelYearly);
		
		lblYearly = new JLabel("Yearly Sales");
		lblYearly.setForeground(Color.WHITE);
		lblYearly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearly.setBackground(new Color(8,104,0,255));
		lblYearly.setOpaque(true);
		lblYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearly.setBounds(0, 0, 120, 33);
		panelYearly.add(lblYearly);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(74, 126, -85, -79);
		panelYearly.add(label_3);
		
		lblYearlyPercent = new JLabel("percentage");
		lblYearlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearlyPercent.setBounds(0, 33, 120, 100);
		panelYearly.add(lblYearlyPercent);
		
		panelGraph = new JPanel();
		panelGraph.setLayout(null);
		panelGraph.setBounds(270, 11, 381, 286);
		add(panelGraph);
		
		panelOrderList = new JPanel();
		panelOrderList.setBounds(661, 11, 318, 677);
		add(panelOrderList);
		panelOrderList.setLayout(null);
		
		lblTimeDiff = new JLabel("New Order 1 Minute ago");
		lblTimeDiff.setBounds(10, 53, 300, 19);
		panelOrderList.add(lblTimeDiff);
		
		JLabel lblNewLabel = new JLabel("Order List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 119, 40);
		panelOrderList.add(lblNewLabel);
		
		JLabel lblInstruction = new JLabel("");
		lblInstruction.setBounds(280, 46, 32, 32);
		panelOrderList.add(lblInstruction);
		
		orderList = new JScrollPane();
		orderList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderList.setBounds(0, 83, 318, 595);
		panelOrderList.add(orderList);
		
		JPanel panelStocks = new JPanel();
		panelStocks.setBounds(10, 308, 641, 380);
		add(panelStocks);
		panelStocks.setLayout(null);
		
		JPanel paneOutofStock = new JPanel();
		paneOutofStock.setBounds(13, 11, 196, 358);
		panelStocks.add(paneOutofStock);
		paneOutofStock.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Out of Stock");
		lblNewLabel_1.setBounds(0, 0, 196, 42);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		paneOutofStock.add(lblNewLabel_1);
		
		panelOutofStock = new JPanel();
		panelOutofStock.setBounds(0, 42, 196, 316);
		paneOutofStock.add(panelOutofStock);
		
		JPanel panelSufficient = new JPanel();
		panelSufficient.setBounds(222, 11, 196, 358);
		panelStocks.add(panelSufficient);
		panelSufficient.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sufficient Stock");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(0, 0, 196, 42);
		panelSufficient.add(lblNewLabel_1_1);
		
		panelSufficentStock = new JPanel();
		panelSufficentStock.setBounds(0, 42, 196, 316);
		panelSufficient.add(panelSufficentStock);
		
		JPanel panelCriticalLevel = new JPanel();
		panelCriticalLevel.setBounds(431, 11, 196, 358);
		panelStocks.add(panelCriticalLevel);
		panelCriticalLevel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Critical Level");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(0, 0, 196, 42);
		panelCriticalLevel.add(lblNewLabel_1_2);
		
		panelCritLevel = new JPanel();
		panelCritLevel.setBounds(0, 42, 196, 316);
		panelCriticalLevel.add(panelCritLevel);
	}
}
