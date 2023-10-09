package KBN.Module.Marketing.ConfirmationProduct;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSeparator;

public class ConfirmationListPanelData extends JPanel {
	
	public JSeparator[] separator;
	public JPanel[] orderList;
	public JLabel[] lblOrderStatusColor;
	public JLabel[] lblTotalProducts;
	public JLabel[] lblTotalItems;
	public JLabel[] lblDate;
	
	private JLabel[] lblTotalProduct;
	private JLabel[] lblTotalItem;

	public int ConfirmationCount;
	
	public ConfirmationListPanelData() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 320, 1000);
		setLayout(null);
	}
	
	public void iConfirmationCount(int count) {
		ConfirmationCount = count;
		settingUp();
	}
	
	private void settingUp() {
		
		this.setPreferredSize(new Dimension(2, 100*ConfirmationCount));
		separator = new JSeparator[ConfirmationCount];
		orderList = new JPanel[ConfirmationCount];
		lblOrderStatusColor = new JLabel[ConfirmationCount];
		lblTotalProducts = new JLabel[ConfirmationCount];
		lblTotalItems = new JLabel[ConfirmationCount];
		lblDate = new JLabel[ConfirmationCount];
		lblTotalProduct = new JLabel[ConfirmationCount];
		lblTotalItem = new JLabel[ConfirmationCount];
		
		for(int i = 0; i < ConfirmationCount; i++) {
			panelSetup(i);
		}
		
	}
	
	private void panelSetup(int i) {
		int y = 0;
		if(i > 0)
			y = 100*i;
		
		orderList[i] = new JPanel();
		orderList[i].setBackground(Color.WHITE);
		orderList[i].setBounds(0, y, 302, 100);
		orderList[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderList[i].setLayout(null);
		add(orderList[i]);
		
		lblDate[i] = new JLabel();
		lblDate[i].setText("10/08/2023");
		lblDate[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate[i].setBounds(10, 11, 101, 14);
		orderList[i].add(lblDate[i]);

		lblTotalProduct[i] = new JLabel();
		lblTotalProduct[i].setText("Total Products ");
		lblTotalProduct[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalProduct[i].setBounds(10, 47, 136, 22);
		orderList[i].add(lblTotalProduct[i]);

		lblTotalProducts[i] = new JLabel();
		lblTotalProducts[i].setText("Order Status ");
		lblTotalProducts[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalProducts[i].setBounds(182, 47, 108, 22);
		orderList[i].add(lblTotalProducts[i]);

		lblTotalItem[i] = new JLabel();
		lblTotalItem[i].setText("Total Item:");
		lblTotalItem[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalItem[i].setBounds(10, 69, 108, 22);
		orderList[i].add(lblTotalItem[i]);

		lblTotalItems[i] = new JLabel();
		lblTotalItems[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalItems[i].setBounds(182, 69, 108, 22);
		orderList[i].add(lblTotalItems[i]);

		lblOrderStatusColor[i] = new JLabel();
		lblOrderStatusColor[i].setBounds(246, 11, 46, 15);
		orderList[i].add(lblOrderStatusColor[i]);
		
		separator[i] = new JSeparator();
		separator[i].setBounds(11, 36, 280, 7);
		orderList[i].add(separator[i]);
		
	}
}