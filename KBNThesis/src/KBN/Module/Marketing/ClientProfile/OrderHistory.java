package KBN.Module.Marketing.ClientProfile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class OrderHistory extends JPanel {
	
	public JPanel panel[];
	public JButton btnProcessOrder[];
	public JLabel lblQuantity[];
	public JLabel lblProdName[];
	public JLabel lblRefNumber[];
	public JLabel lblStatus[];
	public JSeparator separator[];
	
	private int oCount;
	
	public OrderHistory() {
		setBounds(0, 0, 635, 452);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	}
	
	public void orderCountSetter(int orderCount) {
		oCount = orderCount;
		panel = new JPanel[oCount];
		lblRefNumber = new JLabel[oCount];
		lblProdName = new JLabel[oCount];
		lblQuantity =  new JLabel[oCount];
		lblStatus =  new JLabel[oCount];
		btnProcessOrder = new JButton[oCount];
		separator = new JSeparator[oCount];
		this.setPreferredSize(new Dimension(2, 130*oCount));
		for(int i = 0; i < oCount; i++) {
			orderHistoryPanelMaker(i);
		}
	}
	
	public  void orderHistoryPanelMaker(int i) {
		
		int y = 10;
		if(i > 0)
			y = (130*i)+10;
		
		panel[i] = new JPanel();
		panel[i].setBounds(10, y, 582, 100);
		panel[i].setBackground(new Color(255, 255, 255));
		panel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(panel[i]);
		panel[i].setLayout(null);
		
		lblRefNumber[i] = new JLabel("New label");
		lblRefNumber[i].setFont(new Font("Dialog", Font.BOLD, 16));
		lblRefNumber[i].setBounds(12, 10, 189, 20);
		panel[i].add(lblRefNumber[i]);
		
		lblProdName[i] = new JLabel("New label");
		lblProdName[i].setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProdName[i].setBounds(12, 40, 189, 20);
		panel[i].add(lblProdName[i]);
		
		lblQuantity[i] = new JLabel("New label");
		lblQuantity[i].setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuantity[i].setBounds(12, 70, 189, 20);
		panel[i].add(lblQuantity[i]);
		
		lblStatus[i] = new JLabel("For Approval");
		lblStatus[i].setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus[i].setBounds(213, 12, 218, 77);
		panel[i].add(lblStatus[i]);
		
		btnProcessOrder[i] = new JButton("Process Order");
		btnProcessOrder[i].setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		btnProcessOrder[i].setFocusable(false);
		btnProcessOrder[i].setBorderPainted(false);
		btnProcessOrder[i].setBackground(Color.WHITE);
		btnProcessOrder[i].setBounds(443, 37, 127, 28);
		panel[i].add(btnProcessOrder[i]);
		
		separator[i] = new JSeparator();
		separator[i].setBackground(Color.BLACK);
		separator[i].setForeground(Color.BLACK);
		separator[i].setBounds(10, 120+y, 582, 11);
		add(separator[i]);
	}

}
