package KBN.Module.Production.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

public class KBNDataViewDetailsData extends JPanel {
	private JPanel[] panel;
	
	public JLabel[] lblProductName;
	public JLabel[] lblVariant;
	public JLabel[] lblQuantity;
	public JButton[] btnDelete;
	
	public String[] productID;
	
	private JLabel[] lblProdName;
	private JLabel[] lblVariant_1;
	private JLabel[] lblQuantity_1;
	
	private int iCount;
	
	public KBNDataViewDetailsData() {
		setBounds(0, 0, 603, 414);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	}
	
	public void prodCount(int count) {
		iCount = count;
		settingUP();
	}
	
	private void settingUP() {
		
		this.setPreferredSize(new Dimension(2, 102*iCount));
		panel = new JPanel[iCount];
		
		lblProductName = new JLabel[iCount];
		lblVariant = new JLabel[iCount];
		lblQuantity = new JLabel[iCount];
		btnDelete = new JButton[iCount];
		
		productID = new String[iCount];
		
		lblProdName = new JLabel[iCount];
		lblVariant_1 = new JLabel[iCount];
		lblQuantity_1 = new JLabel[iCount];
		
		
		for(int i = 0; i < iCount; i++)
			GeneratePanel(i);
	}
	
	private void GeneratePanel(int i) {
		int y = 11;
		if(i > 0)
			y = 102*i;
		
		panel[i] = new JPanel();
		panel[i].setBounds(10, y, 583, 82);
		panel[i].setBackground(new Color(255, 255, 255));
		panel[i].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel[i]);
		panel[i].setLayout(null);
		
		lblProdName[i] = new JLabel("Product Name");
		lblProdName[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblProdName[i].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProdName[i].setBounds(10, 11, 125, 20);
		panel[i].add(lblProdName[i]);
		
		lblProductName[i] = new JLabel("Kojic " + i);
		lblProductName[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName[i].setBounds(10, 44, 125, 20);
		panel[i].add(lblProductName[i]);
		
		lblVariant_1[i] = new JLabel("Variant");
		lblVariant_1[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant_1[i].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVariant_1[i].setBounds(145, 11, 125, 20);
		panel[i].add(lblVariant_1[i]);
		
		lblVariant[i] = new JLabel("1L");
		lblVariant[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblVariant[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariant[i].setBounds(145, 44, 125, 20);
		panel[i].add(lblVariant[i]);
		
		lblQuantity_1[i] = new JLabel("Quantity");
		lblQuantity_1[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1[i].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity_1[i].setBounds(280, 11, 125, 20);
		panel[i].add(lblQuantity_1[i]);
		
		lblQuantity[i] = new JLabel("0");
		lblQuantity[i].setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity[i].setBounds(280, 44, 125, 20);
		panel[i].add(lblQuantity[i]);
		
		btnDelete[i] = new JButton("Delete");
		btnDelete[i].setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnDelete[i].setFocusable(false);
		btnDelete[i].setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnDelete[i].setBackground(new Color(123,156,121));
		btnDelete[i].setBounds(415, 18, 158, 46);
		panel[i].add(btnDelete[i]);
	}
}
