package KBN.Module.Marketing.dashboard;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Dashboard1 extends JPanel {
	
	private JLabel lblDailyPercent;
	private JLabel lblDaily;
	public JPanel panelOrderList;
	public JPanel panelGraph;
	public JScrollPane orderList;

	public Dashboard1() {
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panelDaily = new JPanel();
		panelDaily.setBounds(10, 11, 120, 140);
		add(panelDaily);
		panelDaily.setLayout(null);
		
		lblDaily = new JLabel("Title Bar");
		lblDaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily.setBounds(0, 0, 120, 33);
		panelDaily.add(lblDaily);
		
		JLabel label = new JLabel("New label");
		label.setBounds(74, 126, -85, -79);
		panelDaily.add(label);
		
		lblDailyPercent = new JLabel("percentage");
		lblDailyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent.setBounds(0, 44, 120, 96);
		panelDaily.add(lblDailyPercent);
		
		JPanel panelWeekly = new JPanel();
		panelWeekly.setLayout(null);
		panelWeekly.setBounds(140, 11, 120, 140);
		add(panelWeekly);
		
		JLabel lblDaily_1 = new JLabel("Title Bar");
		lblDaily_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily_1.setBounds(0, 0, 120, 33);
		panelWeekly.add(lblDaily_1);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(74, 126, -85, -79);
		panelWeekly.add(label_1);
		
		JLabel lblDailyPercent_1 = new JLabel("percentage");
		lblDailyPercent_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent_1.setBounds(0, 44, 120, 96);
		panelWeekly.add(lblDailyPercent_1);
		
		JPanel panelMonthly = new JPanel();
		panelMonthly.setLayout(null);
		panelMonthly.setBounds(10, 157, 120, 140);
		add(panelMonthly);
		
		JLabel lblDaily_2 = new JLabel("Title Bar");
		lblDaily_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily_2.setBounds(0, 0, 120, 33);
		panelMonthly.add(lblDaily_2);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(74, 126, -85, -79);
		panelMonthly.add(label_2);
		
		JLabel lblDailyPercent_2 = new JLabel("percentage");
		lblDailyPercent_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent_2.setBounds(0, 44, 120, 96);
		panelMonthly.add(lblDailyPercent_2);
		
		JPanel panelYearly = new JPanel();
		panelYearly.setLayout(null);
		panelYearly.setBounds(140, 157, 120, 140);
		add(panelYearly);
		
		JLabel lblDaily_3 = new JLabel("Title Bar");
		lblDaily_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily_3.setBounds(0, 0, 120, 33);
		panelYearly.add(lblDaily_3);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(74, 126, -85, -79);
		panelYearly.add(label_3);
		
		JLabel lblDailyPercent_3 = new JLabel("percentage");
		lblDailyPercent_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent_3.setBounds(0, 44, 120, 96);
		panelYearly.add(lblDailyPercent_3);
		
		panelGraph = new JPanel();
		panelGraph.setLayout(null);
		panelGraph.setBounds(270, 11, 381, 286);
		add(panelGraph);
		
		panelOrderList = new JPanel();
		panelOrderList.setBounds(661, 11, 318, 677);
		add(panelOrderList);
		panelOrderList.setLayout(null);
		
		JLabel lblNewlabel = new JLabel("New Order 1 Minute ago");
		lblNewlabel.setBounds(10, 53, 300, 19);
		panelOrderList.add(lblNewlabel);
		
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
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(10, 308, 641, 380);
		add(panel_4_2);
	}
}
