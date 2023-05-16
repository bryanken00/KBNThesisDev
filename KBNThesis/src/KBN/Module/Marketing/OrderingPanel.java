package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class OrderingPanel extends JPanel {
	
	public OrderListPanel orderLPanel;
	
	private JPanel PanelOrderList;
	private JPanel panel_1;

    public OrderingPanel() {
        setBounds(0, 0, 989, 699);
        setLayout(null);
        
        PanelOrderList = new JPanel();
        PanelOrderList.setBounds(10, 11, 320, 677);
        PanelOrderList.setLayout(null);
        add(PanelOrderList);
        
        panel_1 = new JPanel();
        panel_1.setBounds(363, 11, 616, 677);
        add(panel_1);
        panel_1.setLayout(null);
        
        // Setter
        orderLPanel = new OrderListPanel();
        PanelOrderList.add(orderLPanel);

        orderLPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Set border here
    }
}