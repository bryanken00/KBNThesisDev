package KBNAdminPanel.panels.Forecast;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class barGen extends JPanel {
	
	public JPanel bar1;
	public JPanel bar2;
	public JPanel bar3;
	public JPanel bar4;
	public JPanel bar5;

	public barGen() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 328, 509);
		setLayout(null);
		
		bar1 = new JPanel();
		bar1.setBounds(18, 508, 44, 0);
		bar1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bar1.setBackground(new Color(151, 4, 136));
		add(bar1);
		bar1.setLayout(null);
		
		bar2 = new JPanel();
		bar2.setBounds(80, 508, 44, 0);
		bar2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bar2.setBackground(new Color(13, 164, 0));
		add(bar2);
		bar2.setLayout(null);
		
		bar3 = new JPanel();
		bar3.setBounds(142, 508, 44, 0);
		bar3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bar3.setBackground(new Color(36, 0, 255));
		add(bar3);
		bar3.setLayout(null);
		
		bar4 = new JPanel();
		bar4.setBounds(204, 508, 44, 0);
		bar4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bar4.setBackground(new Color(255, 199, 1));
		add(bar4);
		bar4.setLayout(null);
		
		bar5 = new JPanel();
		bar5.setBounds(266, 508, 44, 0);
		bar5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bar5.setBackground(new Color(193, 46, 0));
		add(bar5);
		bar5.setLayout(null);
		
		
		bar1.setVisible(false);
		bar2.setVisible(false);
		bar3.setVisible(false);
		bar4.setVisible(false);
		bar5.setVisible(false);
	}
}
