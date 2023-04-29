package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Dashboard extends JPanel {
	public JLabel lblNewLabel_1_1_2;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_1_1;
	public JLabel lblNewLabel_1_1_1;
	public JLabel lblNewLabel;
	private JLabel lblBackground;

    public Dashboard() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel.setBounds(10, 11, 969, 84);
        add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1.setBounds(10, 123, 285, 84);
        add(lblNewLabel_1);
        
        lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1_1.setBounds(318, 123, 285, 84);
        add(lblNewLabel_1_1);
        
        lblNewLabel_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1_1_1.setBounds(641, 123, 327, 565);
        add(lblNewLabel_1_1_1);
        
        lblNewLabel_1_1_2 = new JLabel("");
        lblNewLabel_1_1_2.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1_1_2.setBounds(10, 234, 593, 454);
        add(lblNewLabel_1_1_2);
        
        lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
        lblBackground.setBounds(0, 0, 989, 699);
        add(lblBackground);
        
        
        
    }
}