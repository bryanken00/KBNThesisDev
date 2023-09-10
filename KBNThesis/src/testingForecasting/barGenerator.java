package testingForecasting;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;

public class barGenerator extends JPanel {
	//Test
//	public JLabel lblProdNameQuantity;
//	public JPanel panel;
//	private JSeparator separator;
//	private JPanel panelContainer;
	
	//Auto
	public JLabel lblProdNameQuantity[];
	public JPanel bar[];
	private JSeparator separator[];
	public JPanel panelContainer[];
	
	private int count;

	public barGenerator() {
		setLayout(null);
//		
//		panelContainer = new JPanel();
//		panelContainer.setBounds(10, 10, 617, 86);
//		add(panelContainer);
//		panelContainer.setLayout(null);
		
//		lblProdNameQuantity = new JLabel("New label");
//		lblProdNameQuantity.setBounds(10, 11, 600, 14);
//		panelContainer.add(lblProdNameQuantity);
//		
//		panel = new JPanel();
//		panel.setBounds(10, 36, 600, 22);
//		panelContainer.add(panel);
//		panel.setBackground(Color.LIGHT_GRAY);
//		
//		separator = new JSeparator();
//		separator.setBounds(10, 71, 600, 7);
//		panelContainer.add(separator);
	}
	
	public void setProductCount(int count) {
		this.setPreferredSize(new Dimension(2, 86*count));
		this.count = count;
		panelContainer = new JPanel[count];
		lblProdNameQuantity = new JLabel[count];
		bar = new JPanel[count];
		separator = new JSeparator[count];
		generateBar();
	}
	
	private void generateBar() {
		int y = 10;
		for(int i = 0; i < count; i++) {
			if(i == 0)
				y = 10;
			else
				y += 86;
			
			panelContainer[i] = new JPanel();
			panelContainer[i].setBounds(10, y, 617, 86);
			add(panelContainer[i]);
			panelContainer[i].setLayout(null);
			
			lblProdNameQuantity[i] = new JLabel("New label " + i);
			lblProdNameQuantity[i].setBounds(10, 10, 600, 14);
			panelContainer[i].add(lblProdNameQuantity[i]);
			
			bar[i] = new JPanel();
			bar[i].setBounds(10, 35, 600, 22);
			bar[i].setBackground(Color.LIGHT_GRAY);
			panelContainer[i].add(bar[i]);
			
			separator[i] = new JSeparator();
			separator[i].setBounds(10, 76, 600, 7);
			panelContainer[i].add(separator[i]);
		}

	}
}
