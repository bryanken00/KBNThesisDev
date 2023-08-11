package KBN.Module.Marketing.OrderingPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class OrderPanelPopupInstruction extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public OrderPanelPopupInstruction() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setResizable(false);
		setBounds(264, 57, 174, 144);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OrderPanelPopupInstruction.class.getResource("/KBN/resources/Marketing/OrderList/toPay.png")));
		lblNewLabel.setBounds(10, 11, 46, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(OrderPanelPopupInstruction.class.getResource("/KBN/resources/Marketing/OrderList/toShip.png")));
		lblNewLabel_1.setBounds(10, 37, 46, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(OrderPanelPopupInstruction.class.getResource("/KBN/resources/Marketing/OrderList/toReceive.png")));
		lblNewLabel_2.setBounds(10, 63, 46, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(OrderPanelPopupInstruction.class.getResource("/KBN/resources/Marketing/OrderList/Return.png")));
		lblNewLabel_3.setBounds(10, 89, 46, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(OrderPanelPopupInstruction.class.getResource("/KBN/resources/Marketing/OrderList/Completed.png")));
		lblNewLabel_4.setBounds(10, 115, 46, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("to Pay");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(66, 11, 138, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("to Ship");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(66, 37, 138, 15);
		getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("to Receive");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(66, 63, 138, 15);
		getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Return");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_3.setBounds(66, 89, 138, 15);
		getContentPane().add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Completed");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_4.setBounds(66, 115, 138, 15);
		getContentPane().add(lblNewLabel_5_4);
	}

}
