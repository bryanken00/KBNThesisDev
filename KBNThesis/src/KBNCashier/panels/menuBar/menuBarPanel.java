package KBNCashier.panels.menuBar;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class menuBarPanel extends JPanel {
	public JLabel lblCal;
	public JLabel lblDate;

	/**
	 * Create the panel.
	 */
	public menuBarPanel() {
		setBounds(0, 0, 821, 40);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblMenuIcon = new JLabel("");
		lblMenuIcon.setIcon(new ImageIcon(menuBarPanel.class.getResource("/KBNCashier/resources/menu.png")));
		lblMenuIcon.setBounds(10, 4, 32, 32);
		add(lblMenuIcon);
		
		lblCal = new JLabel("");
		lblCal.setIcon(new ImageIcon(menuBarPanel.class.getResource("/KBNCashier/resources/cal.png")));
		lblCal.setBounds(779, 4, 32, 32);
		add(lblCal);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(495, 4, 274, 32);
		add(lblDate);
		
		JLabel lblMenuIcon_2 = new JLabel("");
		lblMenuIcon_2.setIcon(new ImageIcon(menuBarPanel.class.getResource("/KBNCashier/resources/clock.png")));
		lblMenuIcon_2.setBounds(461, 8, 24, 24);
		add(lblMenuIcon_2);
		
		JLabel lblNewLabel_1 = new JLabel("KBN Cashier");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 4, 210, 32);
		add(lblNewLabel_1);
	}

}
