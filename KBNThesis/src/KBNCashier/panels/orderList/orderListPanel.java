package KBNCashier.panels.orderList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;

public class orderListPanel extends JPanel {
	
	private int orderCount = 0;
	
	public JScrollPane orderListView;
	
	
	private JPanel[] orders;
	private JLabel[] lblProdName;
	private JLabel[] lblPrice;
	private JLabel[] lblQuantity;
	private JLabel[] lblTotal;
	private JSeparator[] separator;

	public orderListPanel() {
		setBounds(0, 0, 373, 437);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 373, 34);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(19, 0, 125, 34);
		panel.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(154, 0, 54, 34);
		panel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(227, 0, 54, 34);
		panel.add(lblQuantity);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(300, 0, 63, 34);
		panel.add(lblTotal);
		
		orderListView = new JScrollPane();
		orderListView.setBounds(0, 34, 373, 403);
		add(orderListView);
		
	}
	
//	public void settingUpCount(int count) {
//		
//		orderCount = count;
//		settingUp();
//		
//	}
//	
//	private void settingUp() {
//		orders = new JPanel[orderCount];
//		lblProdName = new JLabel[orderCount];
//		lblPrice = new JLabel[orderCount];
//		lblQuantity = new JLabel[orderCount];
//		lblTotal = new JLabel[orderCount];
//		separator = new JSeparator[orderCount];
//		finalSetup();
//	}
//	
//	private void finalSetup() {
//		
//		for(int i = 0; i < orderCount; i++) {
//			int yPos = i * 43;
//			
//			orders[i] = new JPanel();
//			orders[i].setLayout(null);
//			orders[i].setBounds(0, yPos, 373, 41);
//			orderListView.add(orders[i]);
//			
//			lblProdName[i] = new JLabel("Name " + i);
//			lblProdName[i].setBounds(19, 0, 125, 41);
//			orders[i].add(lblProdName[i]);
//			
//			lblPrice[i] = new JLabel("Price");
//			lblPrice[i].setBounds(154, 0, 54, 41);
//			orders[i].add(lblPrice[i]);
//			
//			lblQuantity[i] = new JLabel("Quantity");
//			lblQuantity[i].setBounds(227, 0, 54, 41);
//			orders[i].add(lblQuantity[i]);
//			
//			lblTotal[i] = new JLabel("Total");
//			lblTotal[i].setBounds(300, 0, 63, 41);
//			orders[i].add(lblTotal[i]);
//			
//			separator[i] = new JSeparator();
//			separator[i].setForeground(Color.LIGHT_GRAY);
//			separator[i].setBounds(10, 45+yPos, 344, 2);
//			orderListView.add(separator[i]);
//		}
//		
//		orderListView.setPreferredSize(new Dimension(2, (orderCount * 43) + 10));
//	}
}
