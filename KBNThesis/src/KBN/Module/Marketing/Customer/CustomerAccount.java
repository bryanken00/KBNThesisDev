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
import javax.swing.SwingConstants;

public class CustomerAccount extends JPanel implements MouseListener{
	
	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	public JButton btnCreate; 
	public JButton btnClientProfile;
	public JButton btnSearch;
	
	private String placeholder;
	private JPanel topNav;
	
	public CustomerAccount() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
		topNav = new JPanel();
		topNav.setBorder(new LineBorder(new Color(0, 0, 0)));
		topNav.setBackground(new Color(255, 255, 255));
		topNav.setBounds(26, 11, 933, 70);
		add(topNav);
		topNav.setLayout(null);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(10, 17, 400, 28);
		topNav.add(txtSearchBar);
		txtSearchBar.setText("Search by Account");
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setForeground(Color.GRAY);
		
		btnCreate = new JButton("   Create");
		btnCreate.setBounds(487, 13, 166, 35);
		topNav.add(btnCreate);
		btnCreate.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreate.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/Marketing/notification.png")));
		btnCreate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCreate.setFocusable(false);
		//		btnCreate.setBorderPainted(false);
				btnCreate.setBackground(Color.WHITE);
				btnCreate.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				btnSearch = new JButton("");
				btnSearch.setBounds(410, 17, 32, 28);
				topNav.add(btnSearch);
				btnSearch.setIcon(new ImageIcon(CustomerAccount.class.getResource("/KBN/resources/CustAccount/search.png")));
				btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
				btnSearch.setFocusable(false);
				btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
				btnSearch.setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 107, 933, 532);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnClientProfile = new JButton("Client Profile");
		btnClientProfile.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnClientProfile.setFocusable(false);
//		btnClientProfile.setBorderPainted(false);
		btnClientProfile.setBackground(Color.WHITE);
		btnClientProfile.setBounds(793, 660, 166, 28);
		btnClientProfile.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnClientProfile);

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
		
        Font cellFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(cellFont);
		table.setRowHeight(30);
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
