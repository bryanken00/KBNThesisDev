package KBN.Module.Marketing.Customer;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class CustomerAccount extends JPanel implements MouseListener{
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	public JButton btnCreate; 
	public JLabel lblNewLabel;
	public JLabel lblNotif;
	public JButton btnClientProfile;
	public JButton btnSearch;
	
	private String placeholder;
	
	public CustomerAccount() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 113, 939, 504);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("Search by Account");
		txtSearchBar.setBounds(24, 59, 400, 28);
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.setColumns(10);
		add(txtSearchBar);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(602, 57, 120, 28);
		btnCreate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCreate.setFocusable(false);
//		btnCreate.setBorderPainted(false);
		btnCreate.setBackground(Color.WHITE);
		btnCreate.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnCreate);
		
		lblNotif = new JLabel("icon");
		lblNotif.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification.png")));
		lblNotif.setBounds(917, 11, 32, 32);
		add(lblNotif);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
//		btnClientProfile.setBorderPainted(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(797, 640, 166, 28);
		btnClientProfile.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnClientProfile);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/CustAccount/search.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(424, 59, 32, 28);
		add(btnSearch);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
		lblNewLabel.setBounds(0, 0, 989, 699);
		add(lblNewLabel);

		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
		
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"User ID","Account","Email", "Contact", "Brand", "Account Type"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
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
		if(txtSearchBar.getText().equals("Search by Account"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
		txtSearchBar.setText("Search by Account");
		txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
