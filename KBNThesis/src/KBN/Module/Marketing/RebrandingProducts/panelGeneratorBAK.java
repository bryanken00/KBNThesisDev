package KBN.Module.Marketing.RebrandingProducts;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class panelGeneratorBAK extends JPanel {
	
	public JLabel lblOwnerName;
	public JLabel lblProductBrand;
	public JLabel lblProductTotal;
	public JButton btnView;
	
	private JLabel lblOwner;
	private JLabel lblBrand;
	private JLabel lblProductNumber;
	private JPanel panel_1;
	private JLabel lblOwner_1;
	private JLabel lblProductNumber_1;
	private JLabel lblBrand_1;
	private JButton btnView_1;
	private JLabel lblOwnerName_1;
	private JLabel lblProductBrand_1;
	private JLabel lblProductTotal_1;
	
	public panelGeneratorBAK() {
		setBackground(new Color(255, 255, 255));
		setBounds(26, 146, 933, 511);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 913, 92);
		add(panel);
		panel.setLayout(null);
		
		lblOwner = new JLabel("Product Owner");
		lblOwner.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOwner.setBounds(94, 11, 161, 31);
		panel.add(lblOwner);
		
		lblProductNumber = new JLabel("Total Products");
		lblProductNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductNumber.setBounds(478, 11, 161, 31);
		panel.add(lblProductNumber);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrand.setBounds(324, 11, 85, 31);
		panel.add(lblBrand);
		
		btnView = new JButton("View Products");
		btnView.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnView.setFocusable(false);
		btnView.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnView.setBackground(new Color(75, 119, 71, 180));
		btnView.setBounds(708, 20, 161, 46);
		panel.add(btnView);
		
		lblOwnerName = new JLabel("Product Owner");
		lblOwnerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnerName.setBounds(94, 53, 161, 31);
		panel.add(lblOwnerName);
		
		lblProductBrand = new JLabel("BrandX");
		lblProductBrand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductBrand.setBounds(324, 53, 85, 31);
		panel.add(lblProductBrand);
		
		lblProductTotal = new JLabel("0");
		lblProductTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductTotal.setBounds(478, 53, 161, 31);
		panel.add(lblProductTotal);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 114, 913, 92);
		add(panel_1);
		
		lblOwner_1 = new JLabel("Product Owner");
		lblOwner_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOwner_1.setBounds(10, 11, 161, 31);
		panel_1.add(lblOwner_1);
		
		lblProductNumber_1 = new JLabel("Total Products");
		lblProductNumber_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductNumber_1.setBounds(478, 11, 161, 31);
		panel_1.add(lblProductNumber_1);
		
		lblBrand_1 = new JLabel("Brand");
		lblBrand_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrand_1.setBounds(215, 11, 69, 31);
		panel_1.add(lblBrand_1);
		
		btnView_1 = new JButton("View Products");
		btnView_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnView_1.setFocusable(false);
		btnView_1.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnView_1.setBackground(new Color(75, 119, 71, 180));
		btnView_1.setBounds(708, 20, 161, 46);
		panel_1.add(btnView_1);
		
		lblOwnerName_1 = new JLabel("Product Owner");
		lblOwnerName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnerName_1.setBounds(10, 53, 195, 31);
		panel_1.add(lblOwnerName_1);
		
		lblProductBrand_1 = new JLabel("BrandX");
		lblProductBrand_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductBrand_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductBrand_1.setBounds(215, 53, 195, 31);
		panel_1.add(lblProductBrand_1);
		
		lblProductTotal_1 = new JLabel("0");
		lblProductTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductTotal_1.setBounds(478, 53, 161, 31);
		panel_1.add(lblProductTotal_1);
	}
}
