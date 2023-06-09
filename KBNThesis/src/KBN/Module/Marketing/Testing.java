package KBN.Module.Marketing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

public class Testing extends JDialog {

	public Testing() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 613, 469);
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(47, 36, 270, 142);
		getContentPane().add(lblNewLabel);
		
		
	}

}
