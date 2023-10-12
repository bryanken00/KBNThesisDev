package KBN.Module.Production;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ModuleSelectionProduction extends JPanel {
	public JButton btnMarketingModule;
	public JButton btnWarehouseModule;
	public ModuleSelectionProduction() {
		setLayout(null);
		
		btnMarketingModule = new JButton("Marketing Module");
		btnMarketingModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnMarketingModule.setFocusable(false);
		btnMarketingModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMarketingModule.setBackground(Color.WHITE);
		btnMarketingModule.setBounds(0, 0, 270, 33);
		add(btnMarketingModule);
		
		btnWarehouseModule = new JButton("Warehouse Module");
		btnWarehouseModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnWarehouseModule.setFocusable(false);
		btnWarehouseModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnWarehouseModule.setBackground(Color.WHITE);
		btnWarehouseModule.setBounds(0, 34, 270, 33);
		add(btnWarehouseModule);

	}
}
