package KBNAdminPanel.panels.Forecast;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class ForecastGraphs extends JPanel {
	
	public JPanel graph1;
	public JPanel graph2;
	
	public JLabel lblPresent;
	public JLabel lblPrevious;

	public ForecastGraphs() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(1, 1, 722, 589);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Q<br>U<br>A<br>N<br>T<br>I<br>T<br>Y</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 11, 36, 569);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 11, 658, 509);
		add(panel);
		panel.setLayout(null);
		
		graph1 = new JPanel();
		graph1.setBounds(0, 0, 328, 509);
		panel.add(graph1);
		graph1.setLayout(null);
		
		graph2 = new JPanel();
		graph2.setBounds(329, 0, 329, 509);
		panel.add(graph2);
		graph2.setLayout(null);
		
		lblPrevious = new JLabel("02");
		lblPrevious.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevious.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPrevious.setBounds(426, 531, 162, 27);
		add(lblPrevious);
		
		lblPresent = new JLabel("01");
		lblPresent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresent.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPresent.setBounds(132, 531, 162, 27);
		add(lblPresent);
	}
}
