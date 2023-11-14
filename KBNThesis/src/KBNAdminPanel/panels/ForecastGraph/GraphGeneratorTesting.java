package KBNAdminPanel.panels.ForecastGraph;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class GraphGeneratorTesting extends JPanel {
	private JLabel lblProductName;

	public GraphGeneratorTesting() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(10, 75, 969, 613);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 938, 591);
		add(panel);
		panel.setLayout(null);
		
		lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(10, 11, 123, 43);
		panel.add(lblProductName);
		
		JPanel last = new JPanel();
		last.setBorder(new LineBorder(new Color(0, 0, 0)));
		last.setLayout(null);
		last.setBounds(10, 65, 918, 164);
		panel.add(last);
		
		JPanel present = new JPanel();
		present.setBorder(new LineBorder(new Color(0, 0, 0)));
		present.setLayout(null);
		present.setBounds(10, 240, 918, 164);
		panel.add(present);
		
		JPanel future = new JPanel();
		future.setBorder(new LineBorder(new Color(0, 0, 0)));
		future.setLayout(null);
		future.setBounds(10, 415, 918, 164);
		panel.add(future);
	}
}
