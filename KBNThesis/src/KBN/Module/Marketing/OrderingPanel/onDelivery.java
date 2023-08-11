package KBN.Module.Marketing.OrderingPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class onDelivery extends JDialog {

	public onDelivery() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setResizable(false);
		setBounds(100, 100, 498, 430);
		getContentPane().setLayout(new BorderLayout());
//		setUndecorated(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        
	}

}
