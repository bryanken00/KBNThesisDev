package KBNAdminPanel.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import KBN.views.MarketingModule;

public class Navs extends JPanel implements MouseListener{
	
	public JButton btnSalesReport;
	public JButton btnAudit;
	public JButton btnForecasting;
	public JButton btnEmployeeList;
	public JLabel lblUsername;
	public JButton btnListOfCourier;
	
	private JButton btnChecker;

	public Navs() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 255, 721);
		setLayout(null);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(Navs.class.getResource("/KBN/resources/kbnlogo.png")));
		lblLogo_1.setBounds(10, 11, 241, 65);
		add(lblLogo_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(16, 85, 222, 13);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 221, 255, 339);
		add(panel);
		panel.setLayout(null);
		
		btnSalesReport = new JButton("Sales Report");
		btnSalesReport.setIcon(new ImageIcon(Navs.class.getResource("/KBN/resources/Marketing/marketingButton.png")));
		btnSalesReport.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSalesReport.setFocusable(false);
		btnSalesReport.setBorderPainted(false);
		btnSalesReport.setBackground(new Color(255, 255, 255));
		btnSalesReport.setBounds(10, 27, 241, 35);
		panel.add(btnSalesReport);
		
		btnAudit = new JButton("Audit Trail");
		btnAudit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAudit.setFocusable(false);
		btnAudit.setBorderPainted(false);
		btnAudit.setBackground(new Color(255, 255, 255));
		btnAudit.setBounds(10, 89, 241, 35);
		panel.add(btnAudit);
		
		btnForecasting = new JButton("Forecasting");
		btnForecasting.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnForecasting.setFocusable(false);
		btnForecasting.setBorderPainted(false);
		btnForecasting.setBackground(new Color(255, 255, 255));
		btnForecasting.setBounds(10, 151, 241, 35);
		panel.add(btnForecasting);
		
		btnEmployeeList = new JButton("List of Employee");
		btnEmployeeList.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnEmployeeList.setFocusable(false);
		btnEmployeeList.setBorderPainted(false);
		btnEmployeeList.setBackground(new Color(255, 255, 255));
		btnEmployeeList.setBounds(10, 213, 241, 35);
		panel.add(btnEmployeeList);
		
		btnEmployeeList.setHorizontalTextPosition(JLabel.CENTER);
		btnEmployeeList.setVerticalTextPosition(JLabel.CENTER);
		
		btnForecasting.setHorizontalTextPosition(JLabel.CENTER);
		btnForecasting.setVerticalTextPosition(JLabel.CENTER);
		
		btnAudit.setHorizontalTextPosition(JLabel.CENTER);
		btnAudit.setVerticalTextPosition(JLabel.CENTER);
		
		btnSalesReport.setHorizontalTextPosition(JLabel.CENTER);
		btnSalesReport.setVerticalTextPosition(JLabel.CENTER);
		
		btnListOfCourier = new JButton("List of Courier Rider ");
		btnListOfCourier.setVerticalTextPosition(SwingConstants.CENTER);
		btnListOfCourier.setHorizontalTextPosition(SwingConstants.CENTER);
		btnListOfCourier.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnListOfCourier.setFocusable(false);
		btnListOfCourier.setBorderPainted(false);
		btnListOfCourier.setBackground(Color.WHITE);
		btnListOfCourier.setBounds(10, 275, 241, 35);
		panel.add(btnListOfCourier);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 663, 241, 13);
		add(separator_2);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(10, 670, 241, 40);
		add(lblUsername);
		
		btnSalesReport.addMouseListener(this);
		btnAudit.addMouseListener(this);
		btnForecasting.addMouseListener(this);
		btnEmployeeList.addMouseListener(this);
		btnListOfCourier.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getComponent() instanceof JButton) {
			
			btnSalesReport.setIcon(null);
			btnAudit.setIcon(null);
			btnForecasting.setIcon(null);
			btnEmployeeList.setIcon(null);
			btnListOfCourier.setIcon(null);
			
			Component c = e.getComponent();
			btnChecker = (JButton) e.getComponent();
			if(btnChecker == c)
				((JButton)c).setIcon(new ImageIcon(MarketingModule.class.getResource("/KBN/resources/Marketing/marketingButton.png")));
			
		}else
			return;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
