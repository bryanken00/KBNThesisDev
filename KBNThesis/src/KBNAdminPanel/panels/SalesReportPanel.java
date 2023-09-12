package KBNAdminPanel.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SalesReportPanel extends JPanel {
	
	public JLabel lblTodaySales;
	public JLabel lblDateSelectedSales;
	public JDateChooser dateChooser;
	public JLabel lblPercent;
	public JLabel lblPercentLabel;
	public JButton btnCompareToDate;

	public SalesReportPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new LineBorder(new Color(0, 0, 0)));
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Overview");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 235, 31);
		header.add(lblNewLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(535, 10, 161, 33);
		header.add(dateChooser);
		
		btnCompareToDate = new JButton("Compare to Date Selected");
		btnCompareToDate.setVerticalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompareToDate.setFocusable(false);
		btnCompareToDate.setBorderPainted(false);
		btnCompareToDate.setBackground(Color.WHITE);
		btnCompareToDate.setBounds(718, 9, 241, 35);
		header.add(btnCompareToDate);
		
		JPanel component = new JPanel();
		component.setBorder(new LineBorder(new Color(0, 0, 0)));
		component.setBounds(10, 75, 969, 613);
		panel.add(component);
		component.setLayout(null);
		
		JPanel data = new JPanel();
		data.setBorder(new LineBorder(new Color(0, 0, 0)));
		data.setBounds(10, 11, 949, 89);
		component.add(data);
		data.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Today Sales");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 11, 128, 29);
		data.add(lblNewLabel_1);
		
		lblTodaySales = new JLabel("₱50,000");
		lblTodaySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodaySales.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTodaySales.setBounds(76, 49, 128, 29);
		data.add(lblTodaySales);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date Selected");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(251, 11, 128, 29);
		data.add(lblNewLabel_1_2);
		
		lblDateSelectedSales = new JLabel("₱40,000");
		lblDateSelectedSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateSelectedSales.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDateSelectedSales.setBounds(251, 49, 128, 29);
		data.add(lblDateSelectedSales);
		
		lblPercent = new JLabel("10%");
		lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPercent.setBounds(585, 10, 128, 29);
		data.add(lblPercent);
		
		lblPercentLabel = new JLabel("Higher Compared to the Previous day ");
		lblPercentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentLabel.setBounds(574, 49, 285, 29);
		data.add(lblPercentLabel);
		
		JPanel graph = new JPanel();
		graph.setBorder(new LineBorder(new Color(0, 0, 0)));
		graph.setBounds(10, 111, 949, 491);
		component.add(graph);
	}
}
