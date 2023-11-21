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
	
	public JPanel container;
	public JPanel Graph;
	public JLabel lblProductName;
	private JButton btnForecast;
	
	public ForecastPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 11, 969, 53);
		header.setLayout(null);
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		JLabel lblEmployeeList = new JLabel("Time Series: Simple Moving Average (SMA)");
		lblEmployeeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmployeeList.setBounds(10, 11, 356, 31);
		header.add(lblEmployeeList);
		
		btnForecast = new JButton("Forecast");
		btnForecast.setForeground(Color.WHITE);
		btnForecast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnForecast.setFocusable(false);
		btnForecast.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnForecast.setBackground(new Color(8, 104, 0));
		btnForecast.setBounds(856, 11, 103, 31);
		header.add(btnForecast);
		
		container = new JPanel();
		container.setBounds(10, 75, 969, 613);
		container.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		container.setBackground(Color.WHITE);
		panel.add(container);
		container.setLayout(null);
		
		lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(10, 11, 949, 43);
		container.add(lblProductName);
		
		Graph = new JPanel();
		Graph.setBorder(new LineBorder(new Color(0, 0, 0)));
		Graph.setBounds(10, 65, 949, 537);
		container.add(Graph);
		Graph.setLayout(null);
	}
}
