package KBN.Module.Warehouse.ProcessOrder;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ProcessOrderDataBackup extends JPanel {
	private JLabel lblRef;
	private JLabel lblApproved;
	private JLabel lblApprovedName;
	private JLabel lblTotalAmount;
	private JLabel lblTotal;
	private JLabel lblItem;
	private JLabel lblTotalItem;

	public ProcessOrderDataBackup() {
		setBounds(0, 0, 275, 554);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(1, 1, 250, 95);
		add(panel);
		panel.setLayout(null);
		
		lblRef = new JLabel("RefNumber");
		lblRef.setBounds(5, 5, 100, 20);
		panel.add(lblRef);
		
		lblApproved = new JLabel("Approved By");
		lblApproved.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApproved.setBounds(143, 5, 100, 20);
		panel.add(lblApproved);
		
		JLabel lblCustName = new JLabel("Miguel Besa");
		lblCustName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustName.setBounds(5, 25, 100, 20);
		panel.add(lblCustName);
		
		lblApprovedName = new JLabel("Raven Rose");
		lblApprovedName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApprovedName.setBounds(143, 25, 100, 20);
		panel.add(lblApprovedName);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 45, 225, 1);
		panel.add(separator_1);
		
		lblItem = new JLabel("Items");
		lblItem.setBounds(5, 50, 100, 20);
		panel.add(lblItem);
		
		lblTotalItem = new JLabel("7");
		lblTotalItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalItem.setBounds(143, 50, 100, 20);
		panel.add(lblTotalItem);
		
		lblTotalAmount = new JLabel("10000");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount.setBounds(143, 70, 100, 20);
		panel.add(lblTotalAmount);
		
		lblTotal = new JLabel("Total Amount");
		lblTotal.setBounds(5, 70, 100, 20);
		panel.add(lblTotal);
	}
}
