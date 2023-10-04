package KBN.Module.Warehouse.ProcessOrder;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class ProcessOrderData extends JPanel {
	
	public JLabel[] lblRef;
	public JLabel[] lblApproved;
	public JLabel[] lblApprovedName;
	private JSeparator[] separator;
	public JLabel[] lblCustName;
	public JLabel[] lblTotalAmount;
	public JLabel[] lblTotal;
	public JLabel[] lblItem;
	public JLabel[] lblTotalItem;
	public JPanel[] panel;
	
	public String[] refNumber;
	public String[] userID;
	public String[] orderStatus;
	public int orderCount = 0;

	public ProcessOrderData() {
		setBounds(0, 0, 275, 554);
		setBackground(Color.WHITE);
		setLayout(null);
	}
	
	
	public void OrderCounter(int Order) {
		orderCount = Order;
		setUp();
	}
	
	private void setUp() {
		
		this.setPreferredSize(new Dimension(2, 100*orderCount));
		panel = new JPanel[orderCount];
		lblRef = new JLabel[orderCount];
		lblApproved = new JLabel[orderCount];
		lblCustName = new JLabel[orderCount];
		lblApprovedName = new JLabel[orderCount];
		separator = new JSeparator[orderCount];
		lblItem = new JLabel[orderCount];
		lblTotalItem = new JLabel[orderCount];
		lblTotalAmount = new JLabel[orderCount];
		lblTotal = new JLabel[orderCount];
		
		refNumber = new String[orderCount];
		userID = new String[orderCount];
		orderStatus = new String[orderCount];
		
		for(int i = 0; i < orderCount; i++) {
			panelSetup(i);
		}
	}
	
	private void panelSetup(int i) {
		
		int y = 0;
		if(i > 0)
			y = 100*i;
		
		panel[i] = new JPanel();
		panel[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		panel[i].setBackground(Color.WHITE);
		panel[i].setBounds(1, y, 250, 95);
		panel[i].setLayout(null);
		add(panel[i]);
		
		lblRef[i] = new JLabel();
		lblRef[i].setText("" + i);
		lblRef[i].setBounds(5, 5, 100, 20);
		panel[i].add(lblRef[i]);
		
		lblApproved[i] = new JLabel("Approved By");
		lblApproved[i].setHorizontalAlignment(SwingConstants.RIGHT);
		lblApproved[i].setBounds(143, 5, 100, 20);
		panel[i].add(lblApproved[i]);
		
		lblCustName[i] = new JLabel();
		lblCustName[i].setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustName[i].setBounds(5, 25, 100, 20);
		panel[i].add(lblCustName[i]);
		
		lblApprovedName[i] = new JLabel();
		lblApprovedName[i].setHorizontalAlignment(SwingConstants.RIGHT);
		lblApprovedName[i].setBounds(143, 25, 100, 20);
		panel[i].add(lblApprovedName[i]);
		
		separator[i] = new JSeparator();
		separator[i].setBounds(12, 45, 225, 1);
		panel[i].add(separator[i]);
		
		lblItem[i] = new JLabel("Items");
		lblItem[i].setBounds(5, 50, 100, 20);
		panel[i].add(lblItem[i]);
		
		lblTotalItem[i] = new JLabel();
		lblTotalItem[i].setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalItem[i].setBounds(143, 50, 100, 20);
		panel[i].add(lblTotalItem[i]);
		
		lblTotalAmount[i] = new JLabel();
		lblTotalAmount[i].setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount[i].setBounds(143, 70, 100, 20);
		panel[i].add(lblTotalAmount[i]);
		
		lblTotal[i] = new JLabel("Total Amount");
		lblTotal[i].setBounds(5, 70, 100, 20);
		panel[i].add(lblTotal[i]);
		
	}
}
