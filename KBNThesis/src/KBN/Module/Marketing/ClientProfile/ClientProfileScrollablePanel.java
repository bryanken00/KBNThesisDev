package KBN.Module.Marketing.ClientProfile;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class ClientProfileScrollablePanel extends JPanel {
	private JButton btnProcessOrder;
	private JLabel lblQuantity;
	private JLabel lblProdName;
	private JLabel lblRefNumber;
	private JLabel lblStatus;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public ClientProfileScrollablePanel() {
		setBounds(0, 0, 635, 452);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 615, 102);
		add(panel);
		panel.setLayout(null);
		
		lblRefNumber = new JLabel("New label");
		lblRefNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRefNumber.setBounds(5, 10, 189, 20);
		panel.add(lblRefNumber);
		
		lblProdName = new JLabel("New label");
		lblProdName.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProdName.setBounds(5, 40, 189, 20);
		panel.add(lblProdName);
		
		lblQuantity = new JLabel("New label");
		lblQuantity.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuantity.setBounds(5, 70, 189, 20);
		panel.add(lblQuantity);
		
		lblStatus = new JLabel("For Approval");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(198, 12, 218, 77);
		panel.add(lblStatus);
		
		btnProcessOrder = new JButton("Process Order");
		btnProcessOrder.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		btnProcessOrder.setFocusable(false);
		btnProcessOrder.setBorderPainted(false);
		btnProcessOrder.setBackground(Color.WHITE);
		btnProcessOrder.setBounds(478, 37, 127, 28);
		panel.add(btnProcessOrder);
		
		separator = new JSeparator();
		separator.setBounds(10, 120, 615, 11);
		add(separator);
	}
}
