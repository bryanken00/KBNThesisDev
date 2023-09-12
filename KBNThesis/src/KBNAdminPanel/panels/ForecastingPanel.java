package KBNAdminPanel.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class ForecastingPanel extends JPanel {
	private JDateChooser dateChooser;
	private JButton btnCompareToDate;
	private JPanel color1;
	private JComboBox product1;
	private JPanel graph;

	public ForecastingPanel() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		header.setLayout(null);
		header.setBounds(10, 11, 969, 53);
		panel.add(header);
		
		JLabel lblNewLabel = new JLabel("Sales Overview");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 235, 31);
		header.add(lblNewLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(535, 10, 161, 33);
		header.add(dateChooser);
		
		btnCompareToDate = new JButton("Compare to Date Selected");
		btnCompareToDate.setVerticalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCompareToDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnCompareToDate.setFocusable(false);
		btnCompareToDate.setBorderPainted(false);
		btnCompareToDate.setBackground(Color.WHITE);
		btnCompareToDate.setBounds(718, 9, 241, 35);
		header.add(btnCompareToDate);
		
		JPanel container = new JPanel();
		container.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		container.setBounds(10, 75, 969, 613);
		panel.add(container);
		container.setLayout(null);
		
		JPanel products = new JPanel();
		products.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		products.setBounds(10, 11, 215, 591);
		container.add(products);
		products.setLayout(null);
		
		product1 = new JComboBox();
		product1.setBounds(10, 102, 155, 30);
		products.add(product1);
		
		color1 = new JPanel();
		color1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		color1.setBackground(new Color(151, 4, 136));
		color1.setBounds(175, 102, 30, 30);
		products.add(color1);
		
		JComboBox product2 = new JComboBox();
		product2.setBounds(10, 143, 155, 30);
		products.add(product2);
		
		JPanel color2 = new JPanel();
		color2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		color2.setBackground(new Color(13, 164, 0));
		color2.setBounds(175, 143, 30, 30);
		products.add(color2);
		
		JComboBox product3 = new JComboBox();
		product3.setBounds(10, 184, 155, 30);
		products.add(product3);
		
		JPanel color3 = new JPanel();
		color3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		color3.setBackground(new Color(36, 0, 255));
		color3.setBounds(175, 184, 30, 30);
		products.add(color3);
		
		JComboBox product4 = new JComboBox();
		product4.setBounds(10, 225, 155, 30);
		products.add(product4);
		
		JPanel color4 = new JPanel();
		color4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		color4.setBackground(new Color(255, 199, 1));
		color4.setBounds(175, 225, 30, 30);
		products.add(color4);
		
		JComboBox product5 = new JComboBox();
		product5.setBounds(10, 266, 155, 30);
		products.add(product5);
		
		JPanel color5 = new JPanel();
		color5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		color5.setBackground(new Color(193, 46, 0));
		color5.setBounds(175, 266, 30, 30);
		products.add(color5);
		
		graph = new JPanel();
		graph.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		graph.setBounds(235, 11, 724, 591);
		container.add(graph);
		graph.setLayout(null);

	}
}
