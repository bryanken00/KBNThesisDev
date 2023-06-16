package KBN.Module.Marketing.preRegis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import KBN.Module.Marketing.OrderListPanel;
import KBN.Module.Marketing.OrderListPanelData;
import KBN.commons.DbConnection;

public class preRegister extends JDialog {
	private JScrollPane scrollPane;
	private JLabel lblTitle;
	public preRegList preReg;
	private JPanel panel;
	
	private DbConnection dbConn;
	private Registration reg;
	
	
	private Statement st;
	private ResultSet rs;
	
	public preRegister() {
		setModal(true);
		setBounds(100, 100, 1132, 536);
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 263, 425);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		getContentPane().add(scrollPane);
		
		lblTitle = new JLabel("Pre-Registration List");
		lblTitle.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/Order.png")));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 11, 255, 40);
		getContentPane().add(lblTitle);
		
		preReg = new preRegList();
		scrollPane.setViewportView(preReg);
		
		panel = new JPanel();
		panel.setBounds(276, 5, 834, 487);
		getContentPane().add(panel);
		
		
		
		// Class
		dbConn = new DbConnection();
		panel.setLayout(null);
		reg = new Registration();
		panel.add(reg);
		
		
	}
}
