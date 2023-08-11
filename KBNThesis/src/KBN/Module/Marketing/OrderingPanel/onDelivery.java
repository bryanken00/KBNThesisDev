package KBN.Module.Marketing.OrderingPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class onDelivery extends JDialog {
	public JLabel lblRefNumber;
	public JComboBox cbRiderList;
	public JButton btnConfirm;

	public onDelivery() {
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
//		setUndecorated(true);
		this.setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JLabel lblNewLabel = new JLabel("Select Rider");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 11, 335, 86);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Reference Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 108, 198, 28);
		getContentPane().add(lblNewLabel_1);
		
		lblRefNumber = new JLabel("ref1");
		lblRefNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRefNumber.setBounds(10, 150, 164, 28);
		getContentPane().add(lblRefNumber);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rider:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 189, 198, 28);
		getContentPane().add(lblNewLabel_1_1);
		
		cbRiderList = new JComboBox();
		cbRiderList.setBounds(10, 228, 198, 28);
		getContentPane().add(cbRiderList);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnConfirm.setFocusable(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setBounds(25, 279, 305, 68);
		getContentPane().add(btnConfirm);
		setResizable(false);
		setBounds(100, 100, 371, 413);
		

        
        
	}
}
