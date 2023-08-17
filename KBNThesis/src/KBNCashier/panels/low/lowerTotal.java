package KBNCashier.panels.low;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class lowerTotal extends JPanel {
	private JLabel lblSubTotal;
	private JLabel lblDiscount;
	private JLabel lblTotal;
	private JButton btnPay;

	/**
	 * Create the panel.
	 */
	public lowerTotal() {
		setBounds(0, 0, 373, 178);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sub Total:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 97, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Discount:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 52, 97, 30);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 93, 97, 30);
		add(lblNewLabel_3);
		
		btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPay.setFocusable(false);
		btnPay.setBorderPainted(false);
		btnPay.setBackground(Color.WHITE);
		btnPay.setBounds(43, 134, 286, 33);
		add(btnPay);
		
		lblTotal = new JLabel("0");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(117, 93, 246, 30);
		add(lblTotal);
		
		lblDiscount = new JLabel("0");
		lblDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiscount.setBounds(117, 52, 246, 30);
		add(lblDiscount);
		
		lblSubTotal = new JLabel("0");
		lblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubTotal.setBounds(117, 11, 246, 30);
		add(lblSubTotal);
	}

}
