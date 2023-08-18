package KBNCashier.panels.productList;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProductList extends JPanel {
	
	private int KBN_PROD_COUNT = 0;
	
	public JPanel[] panel;
	public JLabel[] lblIcon;
	public JLabel[] lblProdName;
	public String[] prodPrice;
	public String[] prodVolume;
	public String[] prodQuantity;


	public ProductList() {
		setBounds(0, 0, 803, 564);
		setLayout(null);
		
	}
	
	public void setupProdCount(int count) {
		KBN_PROD_COUNT = count;
		settingUP();
	}
	
	private void settingUP() {
		
		
		
		panel = new JPanel[KBN_PROD_COUNT];
		lblIcon = new JLabel[KBN_PROD_COUNT];
		lblProdName = new JLabel[KBN_PROD_COUNT];
		prodPrice = new String[KBN_PROD_COUNT];
		prodVolume = new String[KBN_PROD_COUNT];
		prodQuantity = new String[KBN_PROD_COUNT];
		setupPanel();
	}
	
	private void setupPanel() {
		int x = 10;
		int y = 10;
		
		for(int i = 0; i < KBN_PROD_COUNT; i++) {
			if(i != 0) {
				x += 196;
				if(i%4 == 0) {
					y += (10 + 215);
					x = 10;
				}
			}
			
			panel[i] = new JPanel();
			panel[i].setBounds(x, y, 180, 215);
			panel[i].setBackground(Color.WHITE);
			add(panel[i]);
			panel[i].setLayout(null);
			
			lblIcon[i] = new JLabel("Icon");
			lblIcon[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblIcon[i].setBounds(0, 0, 180, 175);
			panel[i].add(lblIcon[i]);

			lblProdName[i] = new JLabel("ProdName");
			lblProdName[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblProdName[i].setBounds(0, 176, 180, 40);
			panel[i].add(lblProdName[i]);
		}
		int yy = 225;
		int mod_ = KBN_PROD_COUNT/4;
		if(KBN_PROD_COUNT%4 != 0)
			mod_ += 1;
		this.setPreferredSize(new Dimension(2, (yy * mod_) + 10));
	}
	
}
