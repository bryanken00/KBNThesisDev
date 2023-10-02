package KBN.Module.Warehouse.nav;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class WarehouseNav extends JPanel {
	
	public JButton btnAddItem;
	public JButton btnQRCode;
	public JLabel lblUsername;
	public JButton btnRawMats;
	public JButton btnPackMats;
	public JButton btnFinishProduct;
	public JButton btnArchiveList;
	public JButton btnSummary;
	public JButton btnProcessOrder;
	
	public WarehouseNav() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 255, 721);
		setLayout(null);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(10, 670, 241, 40);
		add(lblUsername);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(10, 646, 241, 13);
		add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(10, 212, 241, 13);
		add(separator_1);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(WarehouseNav.class.getResource("/KBN/resources/kbnlogo.png")));
		lblLogo_1.setBounds(10, 11, 241, 65);
		add(lblLogo_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 87, 241, 13);
		add(separator);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAddItem.setFocusable(false);
		btnAddItem.setEnabled(false);
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(10, 98, 241, 46);
		add(btnAddItem);
		
		btnQRCode = new JButton("QR Code");
		btnQRCode.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnQRCode.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnQRCode.setFocusable(false);
		btnQRCode.setEnabled(false);
		btnQRCode.setBackground(Color.WHITE);
		btnQRCode.setBounds(10, 155, 241, 46);
		add(btnQRCode);
		
		btnRawMats = new JButton("Raw Materials");
		btnRawMats.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRawMats.setFocusable(false);
		btnRawMats.setEnabled(false);
		btnRawMats.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRawMats.setBackground(Color.WHITE);
		btnRawMats.setBounds(10, 236, 241, 46);
		add(btnRawMats);
		
		btnPackMats = new JButton("<html><center>Packaging <br/> Materials</center></html>");
		btnPackMats.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnPackMats.setFocusable(false);
		btnPackMats.setEnabled(false);
		btnPackMats.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnPackMats.setBackground(Color.WHITE);
		btnPackMats.setBounds(10, 302, 241, 46);
		add(btnPackMats);
		
		btnFinishProduct = new JButton("Finish Products");
		btnFinishProduct.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnFinishProduct.setFocusable(false);
		btnFinishProduct.setEnabled(false);
		btnFinishProduct.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFinishProduct.setBackground(Color.WHITE);
		btnFinishProduct.setBounds(10, 368, 241, 46);
		add(btnFinishProduct);
		
		btnArchiveList = new JButton("Archive List");
		btnArchiveList.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchiveList.setFocusable(false);
		btnArchiveList.setEnabled(false);
		btnArchiveList.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnArchiveList.setBackground(Color.WHITE);
		btnArchiveList.setBounds(10, 434, 241, 46);
		add(btnArchiveList);
		
		btnSummary = new JButton("Summary");
		btnSummary.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSummary.setFocusable(false);
		btnSummary.setEnabled(false);
		btnSummary.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSummary.setBackground(Color.WHITE);
		btnSummary.setBounds(10, 500, 241, 46);
		add(btnSummary);
		
		btnProcessOrder = new JButton("Process Order");
		btnProcessOrder.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnProcessOrder.setFocusable(false);
		btnProcessOrder.setEnabled(false);
		btnProcessOrder.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnProcessOrder.setBackground(Color.WHITE);
		btnProcessOrder.setBounds(10, 566, 241, 46);
		add(btnProcessOrder);

	}
}
