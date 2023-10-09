package KBN.Module.Production.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class KBNPanelMain extends JPanel implements MouseListener {
	
	public JTextField txtSearchBar;
	public JDateChooser dateChooser;
	public JComboBox cbStatus;
	public JButton btnSearch;
	public JScrollPane container;

	public KBNPanelMain() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel top = new JPanel();
		top.setBorder(new LineBorder(new Color(0, 0, 0)));
		top.setBounds(10, 11, 969, 50);
		top.setLayout(null);
		top.setBackground(new Color(75, 119, 71));
		add(top);
		
		String[] Status = {"PENDING", "COMPLETED"};
		
		cbStatus = new JComboBox(Status);
		cbStatus.setBounds(278, 11, 161, 28);
		top.add(cbStatus);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(449, 11, 161, 28);
		top.add(dateChooser);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("Search by Tracking ID");
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.setBounds(620, 11, 307, 28);
		txtSearchBar.addMouseListener(this);
		top.add(txtSearchBar);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(KBNPanelMain.class.getResource("/KBN/resources/SearchBarUniversal.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(927, 11, 32, 28);
		top.add(btnSearch);
		
		container = new JScrollPane();
		container.setBorder(new LineBorder(new Color(0, 0, 0)));
		container.setBackground(new Color(255, 255, 255));
		container.setBounds(10, 72, 969, 616);
		add(container);
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
		if(txtSearchBar.getText().equals("Search by Tracking ID"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
		txtSearchBar.setText("Search by Tracking ID");
		txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
