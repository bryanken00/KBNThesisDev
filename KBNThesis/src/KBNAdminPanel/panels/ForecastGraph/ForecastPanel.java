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
import javax.swing.JComboBox;

public class ForecastPanel extends JPanel {
	public JButton btnForecast;
	public JPanel Graph;
	public JComboBox comboBox;
	
	public ForecastPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 11, 969, 129);
		header.setLayout(null);
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		JLabel lblEmployeeList = new JLabel("Time Series: Simple Moving Average (SMA):");
		lblEmployeeList.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmployeeList.setBounds(10, 11, 352, 31);
		header.add(lblEmployeeList);
		
		btnForecast = new JButton("Forecast");
		btnForecast.setForeground(Color.WHITE);
		btnForecast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnForecast.setFocusable(false);
		btnForecast.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnForecast.setBackground(new Color(8, 104, 0));
		btnForecast.setBounds(856, 71, 103, 31);
		header.add(btnForecast);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(372, 5, 587, 43);
		header.add(comboBox);
		
		Graph = new JPanel();
		Graph.setLayout(null);
		Graph.setBorder(new LineBorder(new Color(0, 0, 0)));
		Graph.setBounds(10, 151, 969, 537);
		panel.add(Graph);
		
	}
}
