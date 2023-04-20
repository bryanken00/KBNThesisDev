package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Dashboard extends JPanel {
	public JLabel lblTemp1;
	public JLabel lblTemp2;
	public JLabel lblTemp3;
	public JLabel lblTemp4;
	public Dashboard() {
		this.setBounds(0, 0, 1066, 647);
		setLayout(null);
		
		lblTemp1 = new JLabel("");
		lblTemp1.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
		lblTemp1.setBounds(38, 33, 274, 109);
		add(lblTemp1);
		
		lblTemp2 = new JLabel("");
		lblTemp2.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
		lblTemp2.setBounds(38, 175, 274, 109);
		add(lblTemp2);
		
		lblTemp3 = new JLabel("");
		lblTemp3.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
		lblTemp3.setBounds(371, 33, 274, 109);
		add(lblTemp3);
		
		lblTemp4 = new JLabel("");
		lblTemp4.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
		lblTemp4.setBounds(738, 33, 274, 478);
		add(lblTemp4);
	}
}
