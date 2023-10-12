package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ModuleSelectionMarketing extends JPanel {
	public JButton btnProductionModule;
	public JButton btnWarehouseModule;
	public ModuleSelectionMarketing() {
		setLayout(null);
		
		btnProductionModule = new JButton("Production Module");
		btnProductionModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnProductionModule.setFocusable(false);
		btnProductionModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnProductionModule.setBackground(Color.WHITE);
		btnProductionModule.setBounds(0, 0, 270, 33);
		add(btnProductionModule);
		
		btnWarehouseModule = new JButton("Warehouse Module");
		btnWarehouseModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnWarehouseModule.setFocusable(false);
		btnWarehouseModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnWarehouseModule.setBackground(Color.WHITE);
		btnWarehouseModule.setBounds(0, 34, 270, 33);
		add(btnWarehouseModule);

	}
}
