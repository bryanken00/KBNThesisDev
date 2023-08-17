package KBNCashier.panels.orderList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class prodDetails extends JPanel {
	public JLabel lblIcon;
	public JLabel lblProdName;
	public JLabel lblVariant;
	public JLabel lblPrice;
	public JLabel lblStock;
	public prodDetails() {
		setBounds(0, 0, 373, 437);
		setLayout(null);
		
		lblIcon = new JLabel("");
		lblIcon.setBounds(10, 11, 353, 310);
		add(lblIcon);
		
		lblProdName = new JLabel("Name");
		lblProdName.setBounds(10, 332, 209, 34);
		add(lblProdName);
		
		lblVariant = new JLabel("Variant");
		lblVariant.setBounds(10, 377, 209, 34);
		add(lblVariant);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(229, 332, 134, 34);
		add(lblPrice);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(229, 377, 134, 34);
		add(lblStock);
	}
}
