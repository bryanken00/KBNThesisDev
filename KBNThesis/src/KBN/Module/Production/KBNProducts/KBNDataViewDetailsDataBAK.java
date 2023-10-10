package KBN.Module.Production.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class KBNDataViewDetailsDataBAK extends JPanel {
	private JLabel lblProductName;
	private JLabel lblVariant;
	private JLabel lblQuantity;
	private JLabel lblProdName;
	private JLabel lblVariant_1;
	private JLabel lblQuantity_1;
	private JButton btnDelete;
	private JPanel panel_1;
	private JLabel lblProdName_1;
	private JLabel lblProductName_1;
	private JLabel lblVariant_2;
	private JLabel lblVariant_3;
	private JLabel lblQuantity_2;
	private JLabel lblQuantity_3;
	private JButton btnDelete_1;
	public KBNDataViewDetailsDataBAK() {
		setBounds(0, 0, 603, 414);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 583, 82);
		add(panel);
		panel.setLayout(null);
		
		lblProdName = new JLabel("Product Name");
		lblProdName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProdName.setBounds(10, 11, 125, 20);
		panel.add(lblProdName);
		
		lblProductName = new JLabel("Kojic");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(10, 44, 125, 20);
		panel.add(lblProductName);
		
		lblVariant_1 = new JLabel("Variant");
		lblVariant_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVariant_1.setBounds(145, 11, 125, 20);
		panel.add(lblVariant_1);
		
		lblVariant = new JLabel("1L");
		lblVariant.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariant.setBounds(145, 44, 125, 20);
		panel.add(lblVariant);
		
		lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity_1.setBounds(280, 11, 125, 20);
		panel.add(lblQuantity_1);
		
		lblQuantity = new JLabel("0");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(280, 44, 125, 20);
		panel.add(lblQuantity);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnDelete.setBackground(new Color(75, 119, 71, 180));
		btnDelete.setBounds(415, 18, 158, 46);
		panel.add(btnDelete);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 104, 583, 82);
		add(panel_1);
		
		lblProdName_1 = new JLabel("Product Name");
		lblProdName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdName_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProdName_1.setBounds(10, 11, 125, 20);
		panel_1.add(lblProdName_1);
		
		lblProductName_1 = new JLabel("Kojic");
		lblProductName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName_1.setBounds(10, 44, 125, 20);
		panel_1.add(lblProductName_1);
		
		lblVariant_2 = new JLabel("Variant");
		lblVariant_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVariant_2.setBounds(145, 11, 125, 20);
		panel_1.add(lblVariant_2);
		
		lblVariant_3 = new JLabel("1L");
		lblVariant_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariant_3.setBounds(145, 44, 125, 20);
		panel_1.add(lblVariant_3);
		
		lblQuantity_2 = new JLabel("Quantity");
		lblQuantity_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity_2.setBounds(280, 11, 125, 20);
		panel_1.add(lblQuantity_2);
		
		lblQuantity_3 = new JLabel("0");
		lblQuantity_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity_3.setBounds(280, 44, 125, 20);
		panel_1.add(lblQuantity_3);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDelete_1.setFocusable(false);
		btnDelete_1.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnDelete_1.setBackground(new Color(75, 119, 71, 180));
		btnDelete_1.setBounds(415, 18, 158, 46);
		panel_1.add(btnDelete_1);
	}
}
