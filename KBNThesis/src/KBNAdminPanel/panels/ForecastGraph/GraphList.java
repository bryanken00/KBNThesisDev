package KBNAdminPanel.panels.ForecastGraph;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GraphList extends JPanel {
	public JPanel futureTrend;
	public JPanel History;

	/**
	 * Create the panel.
	 */
	public GraphList() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 969, 1074);
		setLayout(null);
		
		JPanel con1 = new JPanel();
		con1.setBackground(new Color(255, 255, 255));
		con1.setBorder(new LineBorder(new Color(0, 0, 0)));
		con1.setBounds(0, 0, 959, 537);
		con1.setLayout(null);
		add(con1);
		
		JPanel con2 = new JPanel();
		con2.setBackground(new Color(255, 255, 255));
		con2.setBorder(new LineBorder(new Color(0, 0, 0)));
		con2.setBounds(0, 537, 959, 537);
		con2.setLayout(null);
		add(con2);
		
		futureTrend = new JPanel();
		futureTrend.setBorder(new LineBorder(new Color(0, 0, 0)));
		futureTrend.setBounds(10, 72, 939, 454);
		con1.add(futureTrend);
		futureTrend.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Average sales from Week 1 to Week 4 in the selected month over the past five years.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 939, 60);
		con1.add(lblNewLabel);
		
		History = new JPanel();
		History.setBorder(new LineBorder(new Color(0, 0, 0)));
		History.setBounds(10, 72, 939, 454);
		con2.add(History);
		History.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sales History over five years.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 11, 939, 60);
		con2.add(lblNewLabel_1);
		
		this.setPreferredSize(new Dimension(2, 1074));
	}
}
