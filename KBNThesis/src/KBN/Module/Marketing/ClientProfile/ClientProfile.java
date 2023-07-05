package KBN.Module.Marketing.ClientProfile;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ClientProfile extends JPanel {
	private JPanel panel_1_4;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_1_1;
	private JPanel panel_1_2;
	private JPanel panel_1_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JSeparator separator_1;
	private JLabel lblNewLabel_6;
	private JSeparator separator_2;

	/**
	 * Create the panel.
	 */
	public ClientProfile() {
		this.setBounds(0, 0, 989, 699);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(14, 11, 264, 677);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(292, 11, 160, 109);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 160, 27);
		panel_1.add(lblNewLabel);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBounds(466, 11, 160, 109);
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 160, 27);
		panel_1_1.add(lblNewLabel_1);
		
		panel_1_2 = new JPanel();
		panel_1_2.setBounds(640, 11, 160, 109);
		add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 160, 27);
		panel_1_2.add(lblNewLabel_2);
		
		panel_1_3 = new JPanel();
		panel_1_3.setBounds(814, 11, 160, 109);
		add(panel_1_3);
		panel_1_3.setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 160, 27);
		panel_1_3.add(lblNewLabel_3);
		
		panel_1_4 = new JPanel();
		panel_1_4.setBounds(292, 131, 682, 557);
		add(panel_1_4);
		panel_1_4.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 67, 635, 11);
		panel_1_4.add(separator);
		
		lblNewLabel_4 = new JLabel("Order(s)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(25, 38, 80, 22);
		panel_1_4.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Order History");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(158, 38, 80, 22);
		panel_1_4.add(lblNewLabel_5);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(129, 37, 18, 25);
		panel_1_4.add(separator_1);
		
		lblNewLabel_6 = new JLabel("Own Products");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(291, 38, 80, 22);
		panel_1_4.add(lblNewLabel_6);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(262, 37, 18, 25);
		panel_1_4.add(separator_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 82, 635, 452);
		panel_1_4.add(scrollPane);
	}
}
