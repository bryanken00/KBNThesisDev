package KBNCashier.panels.orderList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class orderListPanel extends JPanel {

	public orderListPanel() {
		setBounds(0, 0, 373, 437);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 373, 34);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(9, 0, 82, 34);
		panel.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(100, 0, 82, 34);
		panel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(191, 0, 82, 34);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(282, 0, 82, 34);
		panel.add(lblTotal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 373, 403);
		add(panel_1);
		panel_1.setLayout(null);
	}
}
