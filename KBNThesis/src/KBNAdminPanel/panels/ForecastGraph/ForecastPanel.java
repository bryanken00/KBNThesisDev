package KBNAdminPanel.panels.ForecastGraph;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ForecastPanel extends JPanel {
	public JScrollPane container;
	public ForecastPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBackground(Color.WHITE);
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		
		JLabel lblEmployeeList = new JLabel("Time Series: ARIMA");
		lblEmployeeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmployeeList.setBounds(10, 11, 253, 31);
		header.add(lblEmployeeList);
		
		container = new JScrollPane();
		container.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		container.setBackground(Color.WHITE);
		container.setBounds(10, 75, 969, 613);
		panel.add(container);
	}
}
