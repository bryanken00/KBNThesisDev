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
import javax.swing.text.PlainDocument;

import KBN.commons.NumberOnlyDocumentFilter;

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
	public JTextField txtSF;
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
		lblRef.setBounds(10, 11, 178, 28);
		containerDetails.add(lblRef);
		
		JLabel lblRider = new JLabel("Rider:");
		lblRider.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRider.setBounds(10, 50, 71, 28);
		containerDetails.add(lblRider);
		
		lblRefNumber = new JLabel("ref1");
		lblRefNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRefNumber.setBounds(198, 10, 107, 28);
		containerDetails.add(lblRefNumber);
		
		cbRiderList = new JComboBox();
		cbRiderList.setBounds(101, 51, 204, 28);
		containerDetails.add(cbRiderList);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnConfirm.setFocusable(false);
		btnConfirm.setBackground(new Color(75, 119, 71));
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnConfirm.setBounds(32, 170, 251, 45);
		containerDetails.add(btnConfirm);
		
		JLabel lblShipeeFee = new JLabel("Shipee Fee: ");
		lblShipeeFee.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblShipeeFee.setBounds(10, 89, 95, 28);
		containerDetails.add(lblShipeeFee);
		
		txtSF = new JTextField();
		txtSF.setBounds(101, 90, 204, 28);
		containerDetails.add(txtSF);
		txtSF.setColumns(10);
		
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
		
		PlainDocument sfee = (PlainDocument) txtSF.getDocument();
		NumberOnlyDocumentFilter numberFiler = new NumberOnlyDocumentFilter(11);
		sfee.setDocumentFilter(numberFiler);
        
	}
}
