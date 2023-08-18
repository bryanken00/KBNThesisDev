package KBNCashier.panels.orderList;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class OrderListViewPanel extends JPanel {

	private int orderCount = 0;
	
	private JPanel[] orders;
	private JLabel[] lblProdName;
	private JLabel[] lblPrice;
	private JLabel[] lblQuantity;
	private JLabel[] lblTotal;
	private JSeparator[] separator;
	
	public OrderListViewPanel() {

	}
	
	public void settingUpCount(int count) {
		
		orderCount = count;
		settingUp();
		
	}
	
	private void settingUp() {
		orders = new JPanel[orderCount];
		lblProdName = new JLabel[orderCount];
		lblPrice = new JLabel[orderCount];
		lblQuantity = new JLabel[orderCount];
		lblTotal = new JLabel[orderCount];
		separator = new JSeparator[orderCount];
		finalSetup();
	}
	
	private void finalSetup() {
		
		for(int i = 0; i < orderCount; i++) {
			int yPos = i * 43;
			
			orders[i] = new JPanel();
			orders[i].setLayout(null);
			orders[i].setBounds(0, yPos, 373, 41);
			add(orders[i]);
			
			lblProdName[i] = new JLabel("Name " + i);
			lblProdName[i].setBounds(19, 0, 125, 41);
			orders[i].add(lblProdName[i]);
			
			lblPrice[i] = new JLabel("Price");
			lblPrice[i].setBounds(154, 0, 54, 41);
			orders[i].add(lblPrice[i]);
			
			lblQuantity[i] = new JLabel("Quantity");
			lblQuantity[i].setBounds(227, 0, 54, 41);
			orders[i].add(lblQuantity[i]);
			
			lblTotal[i] = new JLabel("Total");
			lblTotal[i].setBounds(300, 0, 63, 41);
			orders[i].add(lblTotal[i]);
			
			separator[i] = new JSeparator();
			separator[i].setForeground(Color.LIGHT_GRAY);
			separator[i].setBounds(10, 45+yPos, 344, 2);
			add(separator[i]);
		}
		
		this.setPreferredSize(new Dimension(2, (orderCount * 43) + 10));
	}

}
