package KBNCashier.panels.orderList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class orderListPanel extends JPanel {
	
	private int orderCount = 0;
	
	public JPanel orderListView;
	
	private JSeparator[] separator;
	public JPanel[] orders;
	
	public String[] prodVolume;

	public JLabel[] lblMinus;
	public JLabel[] lblAdd;
	public JLabel[] lblDelete;
	public JLabel[] lblProdName;
	public JLabel[] lblPrice;
	public JLabel[] lblQuantity;
	public JLabel[] lblTotal;
	
	private JPanel orders1;
	private JLabel lblProdName1;
	private JLabel lblPrice1;
	private JLabel lblQuantity1;
	private JLabel lblTotal1;
	private JLabel lblMinus1;
	private JLabel lblAdd1;
	private JLabel lblDelete1;

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
		
		orderListView = new JPanel();
		orderListView.setBounds(0, 34, 373, 9999);
		add(orderListView);
		orderListView.setLayout(null);
		
//		testing();
	}
	
	private void testing() {
		orders1 = new JPanel();
		orders1.setLayout(null);
		orders1.setBounds(0, 0, 373, 41);
		orderListView.add(orders1);
		
		lblProdName1 = new JLabel();
		lblProdName1.setBounds(19, 0, 125, 41);
		orders1.add(lblProdName1);
		
		lblPrice1 = new JLabel("Price");
		lblPrice1.setBounds(154, 0, 54, 41);
		orders1.add(lblPrice1);
		
		lblQuantity1 = new JLabel("1");
		lblQuantity1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity1.setBounds(218, 0, 43, 41);
		orders1.add(lblQuantity1);
		
		lblTotal1 = new JLabel("Total");
		lblTotal1.setBounds(300, 0, 63, 41);
		orders1.add(lblTotal1);
		
		lblMinus1 = new JLabel("-");
		lblMinus1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMinus1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinus1.setBounds(179, 0, 43, 41);
		orders1.add(lblMinus1);
		
		lblAdd1 = new JLabel("+");
		lblAdd1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdd1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdd1.setBounds(258, 0, 54, 41);
		orders1.add(lblAdd1);
		
		lblDelete1 = new JLabel("");
		lblDelete1.setIcon(new ImageIcon(orderListPanel.class.getResource("/KBNCashier/resources/delete.png")));
		lblDelete1.setBounds(339, 8, 24, 24);
		orders1.add(lblDelete1);
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
		lblMinus = new JLabel[orderCount];
		lblAdd = new JLabel[orderCount];
		lblTotal = new JLabel[orderCount];
		lblDelete = new JLabel[orderCount];
		separator = new JSeparator[orderCount];
		prodVolume = new String[orderCount];
		finalSetup();
	}
	
	private void finalSetup() {
		int totalHeight = 0;
		
		for(int i = 0; i < orderCount; i++) {
			int yPos = i * 41;
			
			orders[i] = new JPanel();
			orders[i].setLayout(null);
			orders[i].setBounds(0, yPos, 373, 41);
			
			Color alternateColor = new Color(200, 201, 210);
			Color whiteColor = Color.WHITE;
			
			if(i%2 == 0) {
				orders[i].setBackground(alternateColor);
			}else {
				orders[i].setBackground(whiteColor);
			}
			orderListView.add(orders[i]);
			
			lblProdName[i] = new JLabel();
			lblProdName[i].setBounds(19, 0, 125, 41);
			orders[i].add(lblProdName[i]);
			
			lblPrice[i] = new JLabel("Price");
			lblPrice[i].setBounds(154, 0, 54, 41);
			orders[i].add(lblPrice[i]);
			
			lblQuantity[i] = new JLabel("1");
			lblQuantity[i].setBounds(218, 0, 43, 41);
			lblQuantity[i].setHorizontalAlignment(SwingConstants.CENTER);
			orders[i].add(lblQuantity[i]);
			
			lblMinus[i] = new JLabel("-");
			lblMinus[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMinus[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblMinus[i].setBounds(179, 0, 43, 41);
			orders[i].add(lblMinus[i]);
			
			lblAdd[i] = new JLabel("+");
			lblAdd[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAdd[i].setHorizontalAlignment(SwingConstants.LEFT);
			lblAdd[i].setBounds(258, 0, 54, 41);
			orders[i].add(lblAdd[i]);
			
			lblTotal[i] = new JLabel("Total");
			lblTotal[i].setBounds(300, 0, 63, 41);
			orders[i].add(lblTotal[i]);
			
			lblDelete[i] = new JLabel("");
			lblDelete[i].setIcon(new ImageIcon(orderListPanel.class.getResource("/KBNCashier/resources/delete.png")));
			lblDelete[i].setBounds(339, 8, 24, 24);
			orders[i].add(lblDelete[i]);
			
//			separator[i] = new JSeparator();
//			separator[i].setForeground(Color.LIGHT_GRAY);
////			separator[i].setBounds(10, 45+yPos, 344, 2);
//			separator[i].setBounds(0, 41+yPos, 373, 2);
//			orderListView.add(separator[i]);
			totalHeight = Math.max(totalHeight, yPos + 43);
		}
		this.setPreferredSize(new Dimension(2, (orderCount * 43) + 53));
	}
}
