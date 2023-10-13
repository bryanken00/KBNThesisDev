package KBN.Module.Marketing.preRegis;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class preRegList extends JPanel {
	
	public JPanel panel[];
	public JLabel lblName[];
	public JLabel lblBrand[];
	public JLabel lblAddress[];
	
	public static ArrayList rowID;
	public int rowCount = 0;
	
	public preRegList() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(0, 0, 260, 1000);
	}
	
	
	public void preRegCount(int count) {
		rowCount = count;
		settingUp();
	}
	
	private void settingUp() {
		this.setPreferredSize(new Dimension(2, 100*rowCount));
		panel = new JPanel[rowCount];
		lblName = new JLabel[rowCount];
		lblBrand = new JLabel[rowCount];
		lblAddress = new JLabel[rowCount];
		rowID = new ArrayList<>();
		
		
		for(int i = 0; i < rowCount; i++) {
			panelSetup(i);
		}
	}
	
	public void panelSetup(int i) {
		
		int y = 0;
		if(i > 0)
			y = 100*i;
		panel[i] = new JPanel();
		panel[i].setBackground(Color.WHITE);
		panel[i].setBounds(0, y, 240, 100);
		panel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel[i].setLayout(null);
		add(panel[i]);
		
		lblName[i] = new JLabel("Name: ");
		lblName[i].setBounds(10, 8, 136, 22);
		panel[i].add(lblName[i]);
		
		lblBrand[i] = new JLabel("Brand:");
		lblBrand[i].setBounds(10, 38, 136, 22);
		panel[i].add(lblBrand[i]);
		
		lblAddress[i] = new JLabel("Address:");
		lblAddress[i].setBounds(10, 68, 136, 22);
		panel[i].add(lblAddress[i]);
	}
}
