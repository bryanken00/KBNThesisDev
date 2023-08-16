package KBNCashier.panels.productList;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProductList extends JPanel {
	
	private int KBN_PROD_COUNT = 0;
	
	private JPanel[] panel;
	private JLabel[] lblIcon;
	private JLabel[] lblProdName;

	/**
	 * Create the panel.
	 */
	public ProductList() {
		setBounds(0, 0, 803, 564);
		setLayout(null);
		
	}
	
	public void setupProdCount(int count) {
		KBN_PROD_COUNT = count;
		settingUP();
	}
	
	private void settingUP() {
		
		this.setPreferredSize(new Dimension(2, 230*KBN_PROD_COUNT / 4));
		
		panel = new JPanel[KBN_PROD_COUNT];
		lblIcon = new JLabel[KBN_PROD_COUNT];
		lblProdName = new JLabel[KBN_PROD_COUNT];
		setupPanel();
	}
	
	private void setupPanel() {
		int y = 10;
		int x = 10;
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

	}
}
