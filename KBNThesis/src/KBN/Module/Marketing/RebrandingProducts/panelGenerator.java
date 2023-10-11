package KBN.Module.Marketing.RebrandingProducts;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class panelGenerator extends JPanel {

	public JPanel[] panel;
	
	public JLabel[] lblOwnerName;
	public JLabel[] lblProductBrand;
	public JLabel[] lblProductTotal;
	
	private JLabel[] lblOwner;
	private JLabel[] lblBrand;
	private JLabel[] lblProductNumber;
	
	private int prodCount = 0;
	public String[] userID;
	
	public panelGenerator() {
		setBackground(new Color(255, 255, 255));
		setBounds(26, 146, 933, 511);
		setLayout(null);
	}
	
	public void setCount(int count) {
		prodCount = count;
		settingUP();
	}
	
	private void settingUP() {
		this.setPreferredSize(new Dimension(2, 114*prodCount));

		panel = new JPanel[prodCount];

		lblOwnerName = new JLabel[prodCount];
		lblProductBrand = new JLabel[prodCount];
		lblProductTotal = new JLabel[prodCount];
		lblOwner = new JLabel[prodCount];
		lblBrand = new JLabel[prodCount];
		lblProductNumber = new JLabel[prodCount];
		
		userID = new String[prodCount];
		for(int i = 0; i < prodCount; i++)
			Generator(i);
	}
	
	private void Generator(int i) {
		
		int y = 11;
		if(i > 0)
			y = 114*i;
		
		panel[i] = new JPanel();
		panel[i].setBackground(new Color(75, 119, 71));
		panel[i].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel[i].setBounds(10, y, 913, 92);
		panel[i].setLayout(null);
		add(panel[i]);
		
		lblOwner[i] = new JLabel("Product Owner");
		lblOwner[i].setForeground(new Color(255, 255, 255));
		lblOwner[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOwner[i].setBounds(100, 11, 187, 31);
		panel[i].add(lblOwner[i]);
		
		lblProductNumber[i] = new JLabel("Total Products");
		lblProductNumber[i].setForeground(new Color(255, 255, 255));
		lblProductNumber[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductNumber[i].setBounds(624, 11, 161, 31);
		panel[i].add(lblProductNumber[i]);
		
		lblBrand[i] = new JLabel("Brand");
		lblBrand[i].setForeground(new Color(255, 255, 255));
		lblBrand[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrand[i].setBounds(378, 11, 85, 31);
		panel[i].add(lblBrand[i]);
		
		lblOwnerName[i] = new JLabel("Product Owner");
		lblOwnerName[i].setForeground(new Color(255, 255, 255));
		lblOwnerName[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnerName[i].setBounds(104, 53, 221, 31);
		panel[i].add(lblOwnerName[i]);
		
		lblProductBrand[i] = new JLabel("BrandX");
		lblProductBrand[i].setForeground(new Color(255, 255, 255));
		lblProductBrand[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductBrand[i].setBounds(378, 53, 187, 31);
		panel[i].add(lblProductBrand[i]);
		
		lblProductTotal[i] = new JLabel("0");
		lblProductTotal[i].setForeground(new Color(255, 255, 255));
		lblProductTotal[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductTotal[i].setBounds(624, 53, 126, 31);
		panel[i].add(lblProductTotal[i]);
		
	}
}
