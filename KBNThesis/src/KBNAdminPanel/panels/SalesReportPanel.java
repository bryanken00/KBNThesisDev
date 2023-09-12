package KBNAdminPanel.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class SalesReportPanel extends JPanel {

	public SalesReportPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		header.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Overview");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 235, 31);
		header.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(535, 10, 161, 33);
		header.add(dateChooser);
		
		JButton btnCompareToDate = new JButton("Compare to Date Selected");
		btnCompareToDate.setVerticalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompareToDate.setFocusable(false);
		btnCompareToDate.setBorderPainted(false);
		btnCompareToDate.setBackground(Color.WHITE);
		btnCompareToDate.setBounds(718, 9, 241, 35);
		header.add(btnCompareToDate);
		
		JPanel component = new JPanel();
		component.setBounds(10, 75, 969, 613);
		panel.add(component);
		component.setLayout(null);
		
		JPanel data = new JPanel();
		data.setBounds(10, 11, 949, 89);
		component.add(data);
		data.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Today Sales");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 11, 128, 29);
		data.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("₱50,000");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(76, 49, 128, 29);
		data.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date Selected");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(251, 11, 128, 29);
		data.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("₱40,000");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(251, 49, 128, 29);
		data.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("10%");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(585, 10, 128, 29);
		data.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Higher Compared to the Previous day ");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(574, 49, 285, 29);
		data.add(lblNewLabel_1_1_1_1);
		
		JPanel graph = new JPanel();
		graph.setBounds(10, 111, 949, 491);
		component.add(graph);
	}
}
