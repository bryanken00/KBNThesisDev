package KBN.Module.Marketing.OrderingPanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class OrderListPanel extends JPanel implements MouseListener{
	
	// Class Import
	public OrderListPanelData opd;
	
	public JTextField txtSearchBar;
	public JLabel lblInstruction;
	public JLabel lblTimeDiff;
	public JButton btnSearch;
	public JScrollPane scrollPane;
	
	public OrderListPanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 320, 677);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 320, 595);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(scrollPane);
		
		opd = new OrderListPanelData();
		scrollPane.setViewportView(opd);
		
		lblInstruction = new JLabel("");
		lblInstruction.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/informationMarketing.png")));
		lblInstruction.setBounds(280, 45, 32, 32);
		add(lblInstruction);
		
		JLabel lblNewLabel = new JLabel("Order List");
		lblNewLabel.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/Order.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 119, 40);
		add(lblNewLabel);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("Search OrderNumber");
		txtSearchBar.setBounds(139, 15, 139, 30);
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setColumns(10);
		add(txtSearchBar);
		
		lblTimeDiff = new JLabel("New Order 1 Minute ago");
		lblTimeDiff.setBounds(10, 52, 300, 19);
		add(lblTimeDiff);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/CustAccount/search.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(278, 15, 32, 30);
		add(btnSearch);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(txtSearchBar.getText().equals("Search OrderNumber"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
			txtSearchBar.setText("Search OrderNumber");
			txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
