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
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class ForecastPanel extends JPanel {
	public JScrollPane Graph;
	public JButton btnForecast;
	public JComboBox comboBox;
	public JMonthChooser monthChooser;
	public JYearChooser yearChooser;
	public JLabel lblInfo;
	
	public ForecastPanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 11, 969, 58);
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setBackground(Color.WHITE);
		panel.add(header);
		header.setLayout(null);
		
		JLabel lblEmployeeList = new JLabel("Time Series: Simple Moving Average (SMA)");
		lblEmployeeList.setBounds(10, 5, 829, 47);
		lblEmployeeList.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 28));
		header.add(lblEmployeeList);
		
		lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setIcon(new ImageIcon(ForecastPanel.class.getResource("/KBNAdminPanel/resources/info.png")));
		lblInfo.setBounds(913, 5, 46, 47);
		header.add(lblInfo);
		
		Graph = new JScrollPane();
//		Graph.setLayout(null);
		Graph.setBorder(new LineBorder(new Color(0, 0, 0)));
		Graph.setBounds(10, 151, 969, 537);
		panel.add(Graph);
		
		JPanel panel_ = new JPanel();
		panel_.setBackground(new Color(255, 255, 255));
		panel_.setBounds(10, 75, 969, 58);
		panel.add(panel_);
		panel_.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_.setLayout(null);
		
		monthChooser = new JMonthChooser();
		monthChooser.setBounds(630, 13, 103, 31);
		panel_.add(monthChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.setBounds(743, 13, 103, 31);
		panel_.add(yearChooser);
		
		btnForecast = new JButton("Forecast");
		btnForecast.setForeground(Color.WHITE);
		btnForecast.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnForecast.setFocusable(false);
		btnForecast.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnForecast.setBackground(new Color(8, 104, 0));
		btnForecast.setBounds(856, 13, 103, 31);
		panel_.add(btnForecast);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(10, 7, 587, 43);
		panel_.add(comboBox);
	}
}
