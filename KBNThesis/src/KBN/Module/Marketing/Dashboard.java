package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class Dashboard extends JPanel {
	private JLabel lblBackground;
	public JLabel lblNewLabel_1_1_2;
	public JLabel lblNewLabel_1_1_1;
	public JLabel lblNewLabel;
	public JPanel panelSoldProd;
	public JLabel lblTitleMostSold;
	public JLabel lblMostSoldProd;
	public JPanel panelMonthlyMostSold;
	public JLabel lblTitleMostSoldMonthly;
	public JLabel lblMonthlyMostSold;

    public Dashboard() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel.setBounds(10, 11, 969, 84);
        add(lblNewLabel);
        
        lblNewLabel_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1_1_1.setBounds(641, 123, 327, 565);
        add(lblNewLabel_1_1_1);
        
        lblNewLabel_1_1_2 = new JLabel("");
        lblNewLabel_1_1_2.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/tempPicture.png")));
        lblNewLabel_1_1_2.setBounds(10, 234, 593, 454);
        add(lblNewLabel_1_1_2);
        
        panelSoldProd = new JPanel();
        panelSoldProd.setBounds(318, 123, 285, 84);
        add(panelSoldProd);
        panelSoldProd.setLayout(null);
        
        lblTitleMostSold = new JLabel("Most Sold Product all the Time:");
        lblTitleMostSold.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTitleMostSold.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitleMostSold.setBounds(0, 0, 285, 30);
        lblTitleMostSold.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelSoldProd.add(lblTitleMostSold);
        
        panelMonthlyMostSold = new JPanel();
        panelMonthlyMostSold.setLayout(null);
        panelMonthlyMostSold.setBounds(10, 123, 285, 84);
        add(panelMonthlyMostSold);
        
        lblTitleMostSoldMonthly = new JLabel("This Month Most Sold:");
        lblTitleMostSoldMonthly.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitleMostSoldMonthly.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTitleMostSoldMonthly.setBorder(new EmptyBorder(10, 10, 10, 10));
        lblTitleMostSoldMonthly.setBounds(0, 0, 285, 30);
        panelMonthlyMostSold.add(lblTitleMostSoldMonthly);
        
        lblMonthlyMostSold = new JLabel("");
        lblMonthlyMostSold.setHorizontalAlignment(SwingConstants.LEFT);
        lblMonthlyMostSold.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMonthlyMostSold.setBorder(new EmptyBorder(10, 10, 10, 10));
        lblMonthlyMostSold.setBounds(0, 34, 285, 50);
        panelMonthlyMostSold.add(lblMonthlyMostSold);
        
        lblMostSoldProd = new JLabel("");
        lblMostSoldProd.setHorizontalAlignment(SwingConstants.LEFT);
        lblMostSoldProd.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMostSoldProd.setBounds(0, 34, 285, 50);
        lblMostSoldProd.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelSoldProd.add(lblMostSoldProd);
        
        lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon(Dashboard.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
        lblBackground.setBounds(0, 0, 989, 699);
        add(lblBackground);
        

        
        
        
    }
}