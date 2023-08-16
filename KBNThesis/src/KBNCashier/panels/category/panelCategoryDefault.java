package KBNCashier.panels.category;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class panelCategoryDefault extends JPanel {
	private JLabel lblIcon;

	/**
	 * Create the panel.
	 */
	public panelCategoryDefault() {
		setBounds(0, 0, 821, 51);
		setLayout(null);
		
		lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(panelCategoryDefault.class.getResource("/KBNCashier/resources/category.png")));
		lblIcon.setBounds(298, 1, 32, 48);
		add(lblIcon);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(340, 1, 183, 48);
		add(lblNewLabel_1);
	}

}
