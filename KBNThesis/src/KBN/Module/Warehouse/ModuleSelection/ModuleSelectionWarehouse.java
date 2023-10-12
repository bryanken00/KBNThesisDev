package KBN.Module.Warehouse.ModuleSelection;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class ModuleSelectionWarehouse extends JPanel {
	public JButton btnMarketingModule;
	public JButton btnProductionModule;
	public ModuleSelectionWarehouse() {
		setLayout(null);
		
		btnMarketingModule = new JButton("Marketing Module");
		btnMarketingModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnMarketingModule.setFocusable(false);
		btnMarketingModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnMarketingModule.setBackground(Color.WHITE);
		btnMarketingModule.setBounds(0, 0, 270, 33);
		add(btnMarketingModule);
		
		btnProductionModule = new JButton("Production Module");
		btnProductionModule.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnProductionModule.setFocusable(false);
		btnProductionModule.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnProductionModule.setBackground(Color.WHITE);
		btnProductionModule.setBounds(0, 34, 270, 33);
		add(btnProductionModule);

	}
}
