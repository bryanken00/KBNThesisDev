package KBN.Module.Marketing.Delivery;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class DeliveryStatus extends JPanel implements MouseListener{
	public JPanel panel1;
	public JTextField txtSearchbar;
	public JButton btnListOfDelivery;
	public JButton btnCompleted;
	public JButton btnSearch;
	public JButton btnDeliveryDetails;
	
	public DeliveryStatus() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        panel1 = new JPanel();
        panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel1.setBackground(new Color(255, 255, 255));
        panel1.setBounds(26, 107, 933, 532);
		add(panel1);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(26, 11, 933, 70);
		add(panel);
		panel.setLayout(null);
		
		txtSearchbar = new JTextField();
		txtSearchbar.setBounds(648, 20, 230, 29);
		txtSearchbar.setText("Search by CourierID or Ref Number");
		txtSearchbar.addMouseListener(this);
		txtSearchbar.setForeground(Color.GRAY);
		panel.add(txtSearchbar);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(203, 15, 13, 39);
		panel.add(separator);
		
		btnListOfDelivery = new JButton("List of Delivery");
		btnListOfDelivery.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnListOfDelivery.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnListOfDelivery.setFocusable(false);
		btnListOfDelivery.setBackground(Color.WHITE);
		btnListOfDelivery.setBounds(10, 20, 174, 29);
		btnListOfDelivery.setOpaque(true);
		panel.add(btnListOfDelivery);
		
		btnCompleted = new JButton("Completed");
		btnCompleted.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompleted.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCompleted.setFocusable(false);
		btnCompleted.setBackground(Color.WHITE);
		btnCompleted.setBounds(226, 20, 174, 29);
		btnCompleted.setOpaque(true);
		panel.add(btnCompleted);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(DeliveryStatus.class.getResource("/KBN/resources/CustAccount/search.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(878, 20, 32, 28);
		panel.add(btnSearch);
		
		btnDeliveryDetails = new JButton("View Details");
		btnDeliveryDetails.setBounds(845, 650, 114, 38);
		btnDeliveryDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeliveryDetails.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDeliveryDetails.setBackground(Color.WHITE);
		btnDeliveryDetails.setFocusable(false);
		add(btnDeliveryDetails);
		
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
		if(txtSearchbar.getText().equals("Search by CourierID or Ref Number"))
			txtSearchbar.setText("");
		txtSearchbar.setForeground(Color.BLACK);
		txtSearchbar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchbar.getText().equals("")) {
			txtSearchbar.setText("Search by CourierID or Ref Number");
			txtSearchbar.setForeground(Color.GRAY);
		}
		txtSearchbar.setFocusable(false);
	}
}
