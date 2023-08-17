package KBNCashier.panels.productList;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class addCart extends JPanel {
	public JLabel btnaddToCart;

	public addCart() {
		setBounds(0, 0, 180, 215);
		setLayout(null);
		
		btnaddToCart = new JLabel("");
		btnaddToCart.setIcon(new ImageIcon(addCart.class.getResource("/KBNCashier/resources/cart.png")));
		btnaddToCart.setBounds(10, 11, 160, 193);
		add(btnaddToCart);
	}

}
