package KBNAdminPanel.panels;

import javax.swing.JPanel;
import java.awt.Color;

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
		
		JPanel component = new JPanel();
		component.setBounds(10, 75, 969, 613);
		panel.add(component);
		component.setLayout(null);
		
		JPanel data = new JPanel();
		data.setBounds(10, 11, 949, 89);
		component.add(data);
		data.setLayout(null);
		
		JPanel graph = new JPanel();
		graph.setBounds(10, 111, 949, 491);
		component.add(graph);
	}
}
