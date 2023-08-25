package KBN.Module.Marketing.Delivery;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class DeliveryStatus extends JPanel {
	public JPanel panel1;
	public JTextField txtSearchbar;
	public JButton btnListOfDelivery;
	public JButton btnCompleted;
	
	public DeliveryStatus() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        panel1 = new JPanel();
        panel1.setBounds(26, 107, 933, 550);
		add(panel1);
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 11, 933, 70);
		add(panel);
		panel.setLayout(null);
		
		txtSearchbar = new JTextField();
		txtSearchbar.setBounds(687, 31, 191, 29);
		panel.add(txtSearchbar);
		txtSearchbar.setText("searchbar");
		txtSearchbar.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(203, 15, 13, 39);
		panel.add(separator);
		
		btnListOfDelivery = new JButton("List of Delivery");
		btnListOfDelivery.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnListOfDelivery.setFocusable(false);
		btnListOfDelivery.setBorderPainted(false);
		btnListOfDelivery.setBackground(Color.WHITE);
		btnListOfDelivery.setBounds(10, 20, 174, 29);
		btnListOfDelivery.setOpaque(true);
		panel.add(btnListOfDelivery);
		
		btnCompleted = new JButton("Completed");
		btnCompleted.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompleted.setFocusable(false);
		btnCompleted.setBorderPainted(false);
		btnCompleted.setBackground(Color.WHITE);
		btnCompleted.setBounds(226, 20, 174, 29);
		btnCompleted.setOpaque(true);
		panel.add(btnCompleted);
		
	}
}
