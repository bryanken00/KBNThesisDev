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
	
	public JButton[] btnView;
	
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
		
		btnView = new JButton[prodCount];
		
		userID = new String[prodCount];
		for(int i = 0; i < prodCount; i++)
			Generator(i);
	}
	
	private void Generator(int i) {
		
		int y = 11;
		if(i > 0)
			y = 114*i;
		
		panel[i] = new JPanel();
		panel[i].setBackground(new Color(255, 255, 255));
		panel[i].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel[i].setBounds(10, y, 913, 92);
		add(panel[i]);
		panel[i].setLayout(null);
		
		lblOwner[i] = new JLabel("Product Owner");
		lblOwner[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOwner[i].setBounds(10, 11, 161, 31);
		panel[i].add(lblOwner[i]);
		
		lblProductNumber[i] = new JLabel("Total Products");
		lblProductNumber[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductNumber[i].setBounds(478, 11, 161, 31);
		panel[i].add(lblProductNumber[i]);
		
		lblBrand[i] = new JLabel("Brand");
		lblBrand[i].setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBrand[i].setBounds(215, 11, 69, 31);
		panel[i].add(lblBrand[i]);
		
		btnView[i] = new JButton("View Products");
		btnView[i].setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnView[i].setFocusable(false);
		btnView[i].setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnView[i].setBackground(new Color(104,140,92));
		btnView[i].setForeground(new Color(255, 255, 255));
		btnView[i].setBounds(708, 20, 161, 46);
		panel[i].add(btnView[i]);
		
		lblOwnerName[i] = new JLabel("Product Owner");
		lblOwnerName[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOwnerName[i].setBounds(10, 53, 195, 31);
		panel[i].add(lblOwnerName[i]);
		
		lblProductBrand[i] = new JLabel("BrandX");
		lblProductBrand[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductBrand[i].setBounds(215, 53, 195, 31);
		panel[i].add(lblProductBrand[i]);
		
		lblProductTotal[i] = new JLabel("0");
		lblProductTotal[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductTotal[i].setBounds(478, 53, 161, 31);
		panel[i].add(lblProductTotal[i]);
	}
}
