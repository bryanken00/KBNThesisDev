package KBNAdminPanel.panels.ForecastGraph;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;

import KBN.views.KBNMainFrame;

import javax.swing.JLabel;
import java.awt.Font;

public class GraphGenerator extends JPanel {
	public JLabel lblProductName[];
	public JPanel panel[];
	public JPanel last[];
	public JPanel present[];
	public JPanel future[];
		
	private int prodCount = 0;

	public GraphGenerator() {
		setBounds(0, 0, 969, 613);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		setCount(10);
	}
	
	public void setCount(int count) {
		
		this.setPreferredSize(new Dimension(2, 601*count));
		
		lblProductName = new JLabel[count];
		panel = new JPanel[count];
			last = new JPanel[count];
			present = new JPanel[count];
			future = new JPanel[count];
			
		for(int i = 0; i < count; i++)
			generatePanel(i);
	}
	
	private void generatePanel(int i) {
		
		int y = 0;
		
		if(i == 0)
			y = 10;
		else
			y = i*601;
		
		System.out.println("i: " + i + ", value: " + y);
		
		panel[i] = new JPanel();
		panel[i].setBackground(new Color(255, 255, 255));
		panel[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		panel[i].setBounds(10, y, 938, 591);
		panel[i].setLayout(null);
		add(panel[i]);
		
		lblProductName[i] = new JLabel("Product Name" + i);
		lblProductName[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName[i].setBounds(10, 11, 123, 43);
		panel[i].add(lblProductName[i]);
		
		last[i] = new JPanel();
		last[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		last[i].setLayout(null);
		last[i].setBounds(10, 65, 918, 164);
		panel[i].add(last[i]);
		
		present[i] = new JPanel();
		present[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		present[i].setLayout(null);
		present[i].setBounds(10, 240, 918, 164);
		panel[i].add(present[i]);
		
		future[i] = new JPanel();
		future[i].setBorder(new LineBorder(new Color(0, 0, 0)));
		future[i].setLayout(null);
		future[i].setBounds(10, 415, 918, 164);
		panel[i].add(future[i]);
	}
}
