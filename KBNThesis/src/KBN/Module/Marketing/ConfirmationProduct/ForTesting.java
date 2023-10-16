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
import javax.swing.SwingConstants;

public class ForTesting extends JPanel {

	public JSeparator separator;
	public JPanel orderList;
	public JLabel lblOrderStatusColor;
	public JLabel lblTotalProducts;
	public JLabel lblTotalItems;
	public JLabel lblDate;
	private JLabel lblTotalProduct;
	private JLabel lblTotalItem;

	public int OrderCount;
	
	public ForTesting() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 320, 1000);
		setLayout(null);

		separator = new JSeparator();
		orderList = new JPanel();
		
		lblOrderStatusColor = new JLabel();
		lblTotalProducts = new JLabel();
		lblTotalItems = new JLabel();
		lblDate = new JLabel();
		lblTotalProduct = new JLabel();
		lblTotalItem = new JLabel();
		
		orderList.setBackground(Color.WHITE);
		orderList.setBounds(0, 0, 302, 100);
		orderList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderList.setLayout(null);
		add(orderList);
		
		lblDate.setText("10/08/2023");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDate.setBounds(10, 11, 101, 14);
		orderList.add(lblDate);
		
		lblTotalProduct.setText("Total Products ");
		lblTotalProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalProduct.setBounds(10, 47, 136, 22);
		orderList.add(lblTotalProduct);
		
		lblTotalProducts.setText("Order Status ");
		lblTotalProducts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalProducts.setBounds(182, 47, 108, 22);
		orderList.add(lblTotalProducts);

		lblTotalItem.setText("Total Item:");
		lblTotalItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalItem.setBounds(10, 69, 108, 22);
		orderList.add(lblTotalItem);
		
		lblTotalItems.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalItems.setBounds(182, 69, 108, 22);
		orderList.add(lblTotalItems);

		lblOrderStatusColor.setBounds(98, 11, 192, 22);
		orderList.add(lblOrderStatusColor);
		
		separator.setBounds(11, 36, 280, 7);
		orderList.add(separator);
	}

}