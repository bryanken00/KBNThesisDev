package KBN.Module.Marketing;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSeparator;

public class OrderListPanelData extends JPanel {
	public JPanel[] orderList;
	public JLabel[] lblRefNumber;
	public JLabel[] lblName;
	public JLabel[] lblStatus;
	public JLabel[] lblTextAmount;
	public JLabel[] lblTotalAmmount;
	public JSeparator[] separator;
	
	public int OrderCount;
	
	public OrderListPanelData() {
		setBounds(0, 0, 320, 1000);
		setLayout(null);

	}
	
	public void iOrderCount(int count) {
		OrderCount = count;
		settingUp();
	}
	
	private void settingUp() {
		this.setPreferredSize(new Dimension(2, 100*OrderCount));
		orderList = new JPanel[OrderCount];
		lblRefNumber = new JLabel[OrderCount];
		lblName = new JLabel[OrderCount];
		lblStatus = new JLabel[OrderCount];
		lblTextAmount = new JLabel[OrderCount];
		lblTotalAmmount = new JLabel[OrderCount];
		separator = new JSeparator[OrderCount];
		
		for(int i = 0; i < OrderCount; i++) {
			panelSetup(i);
		}
	}
	
	public void panelSetup(int i) {

		
		int y = 0;
		if(i > 0)
			y = 100*i;
		
		orderList[i] = new JPanel();
		orderList[i].setBounds(0, y, 302, 100);
		orderList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderList[i].setLayout(null);
		add(orderList[i]);
		
		lblRefNumber[i] = new JLabel();
		lblRefNumber[i].setText("Ref Number " + i);
		lblRefNumber[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRefNumber[i].setBounds(10, 11, 101, 14);
		orderList[i].add(lblRefNumber[i]);
		
		lblName[i] = new JLabel();
		lblName[i].setText("Username " + i);
		lblName[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName[i].setBounds(10, 36, 136, 22);
		orderList[i].add(lblName[i]);
		
		lblStatus[i] = new JLabel();
		lblStatus[i].setText("Order Status " + i);
		lblStatus[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus[i].setBounds(182, 36, 108, 22);
		orderList[i].add(lblStatus[i]);
		
		lblTextAmount[i] = new JLabel();
		lblTextAmount[i].setText("Total Amount ");
		lblTextAmount[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTextAmount[i].setBounds(10, 69, 108, 22);
		orderList[i].add(lblTextAmount[i]);
		
		lblTotalAmmount[i] = new JLabel();
		lblTotalAmmount[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalAmmount[i].setBounds(182, 69, 108, 22);
		orderList[i].add(lblTotalAmmount[i]);
		
		separator[i] = new JSeparator();
		separator[i].setBounds(10, 63, 280, 7);
		orderList[i].add(separator[i]);
		
	}
}
