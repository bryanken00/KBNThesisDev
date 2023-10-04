package KBN.Module.Warehouse.ProcessOrder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class onDelivery extends JDialog {
	
	public String[] courierID;
	public JLabel lblRefNumber;
	public JComboBox cbRiderList;
	public JButton btnConfirm;
	private JPanel containerDetails;
	private JPanel panel;
	private JLabel lblSelectRider;

	public onDelivery() {
		setBounds(100, 100, 371, 413);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		setResizable(false);
		this.setModal(true);
		
		JPanel container = new JPanel();
		container.setBackground(new Color(255, 255, 255));
		container.setBorder(new LineBorder(new Color(0, 0, 0)));
		container.setBounds(10, 11, 335, 352);
		getContentPane().add(container);
		container.setLayout(null);
		
		containerDetails = new JPanel();
		containerDetails.setBackground(new Color(255, 255, 255));
		containerDetails.setBorder(new LineBorder(new Color(0, 0, 0)));
		containerDetails.setBounds(10, 90, 315, 251);
		container.add(containerDetails);
		containerDetails.setLayout(null);
		
		JLabel lblRef = new JLabel("Order Reference Number:");
		lblRef.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRef.setBounds(10, 11, 295, 28);
		containerDetails.add(lblRef);
		
		JLabel lblRider = new JLabel("Rider:");
		lblRider.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRider.setBounds(10, 92, 295, 28);
		containerDetails.add(lblRider);
		
		lblRefNumber = new JLabel("ref1");
		lblRefNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRefNumber.setBounds(10, 53, 295, 28);
		containerDetails.add(lblRefNumber);
		
		cbRiderList = new JComboBox();
		cbRiderList.setBounds(10, 131, 295, 28);
		containerDetails.add(cbRiderList);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(new Color(75, 119, 71));
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConfirm.setBounds(32, 170, 251, 45);
		containerDetails.add(btnConfirm);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 315, 68);
		panel.setBackground(new Color(75, 119, 71));
		container.add(panel);
		panel.setLayout(null);
		
		lblSelectRider = new JLabel("Select Rider");
		lblSelectRider.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectRider.setForeground(Color.WHITE);
		lblSelectRider.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSelectRider.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSelectRider.setBounds(0, 0, 315, 68);
		panel.add(lblSelectRider);
        
	}
}
