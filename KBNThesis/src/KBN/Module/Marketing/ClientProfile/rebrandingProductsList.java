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

public class rebrandingProductsList extends JPanel {
	
	public JPanel panel[];
	public JButton btnProcessOrder[];
	public JLabel lblProd[];
	public JSeparator separator[];
	
	private int oCount;
	
	public rebrandingProductsList() {
		setBounds(0, 0, 635, 452);
		setLayout(null);
		
		
	}
	
	public void orderCountSetter(int orderCount) {
		oCount = orderCount;
		panel = new JPanel[oCount];
		btnProcessOrder = new JButton[oCount];
		lblProd = new JLabel[oCount];
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
		panel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(panel[i]);
		panel[i].setLayout(null);
		
		lblProd[i] = new JLabel("For Approval");
		lblProd[i].setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProd[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblProd[i].setBounds(10, 10, 218, 77);
		panel[i].add(lblProd[i]);
		
		btnProcessOrder[i] = new JButton();
		btnProcessOrder[i].setText("View Details");
		btnProcessOrder[i].setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		btnProcessOrder[i].setFocusable(false);
		btnProcessOrder[i].setBorderPainted(false);
		btnProcessOrder[i].setBackground(Color.WHITE);
		btnProcessOrder[i].setBounds(360, 25, 127, 51);
		panel[i].add(btnProcessOrder[i]);
		
		separator[i] = new JSeparator();
		separator[i].setBackground(Color.BLACK);
		separator[i].setForeground(Color.BLACK);
		separator[i].setBounds(10, 120+y, 582, 11);
		add(separator[i]);
	}

}
