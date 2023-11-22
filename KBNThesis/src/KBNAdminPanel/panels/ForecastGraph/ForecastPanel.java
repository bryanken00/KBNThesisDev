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

public class ForecastPanel extends JPanel {
	public JPanel Graph;
	public JButton btnForecast;
	public JComboBox comboBox;
	public JMonthChooser monthChooser;
	public JYearChooser yearChooser;
	
	public ForecastPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
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
		lblEmployeeList.setBounds(10, 5, 949, 47);
		lblEmployeeList.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 28));
		header.add(lblEmployeeList);
		
		JPanel past = new JPanel();
		past.setBorder(new LineBorder(new Color(0, 0, 0)));
		past.setBounds(692, 11, 61, 26);
		header.add(past);
		past.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Past");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 61, 26);
		past.add(lblNewLabel);
		
		Graph = new JPanel();
		Graph.setLayout(null);
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
		
		
		past.setBackground(Color.red);
		
		JPanel present = new JPanel();
		present.setLayout(null);
		present.setBorder(new LineBorder(new Color(0, 0, 0)));
		present.setBackground(Color.BLUE);
		present.setBounds(763, 11, 61, 26);
		header.add(present);
		
		JLabel lblPresent = new JLabel("Present");
		lblPresent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresent.setForeground(Color.WHITE);
		lblPresent.setBounds(0, 0, 61, 26);
		present.add(lblPresent);
		
		JPanel future = new JPanel();
		future.setLayout(null);
		future.setBorder(new LineBorder(new Color(0, 0, 0)));
		future.setBackground(Color.GREEN);
		future.setBounds(834, 11, 61, 26);
		header.add(future);
		
		JLabel lblFuture = new JLabel("Future");
		lblFuture.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuture.setForeground(Color.WHITE);
		lblFuture.setForeground(Color.BLACK);
		lblFuture.setBounds(0, 0, 61, 26);
		future.add(lblFuture);
	}
}
