package KBN.views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.commons.dataSetter;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSeparator;

public class Modules extends JFrame implements ActionListener{

	//class
	private dataSetter dataSet;
	private WarehouseModule rm;
	private MarketingModule mm;
	private WarehouseModule_1 rm1;
	
	private ProductionModule pm;
	
	private JPanel contentPane;
	private JLabel lblUsername;
	private JButton btnMarketing;
	private JButton btnWarehouse;
	private JButton btnProduction;
	

	
	public Modules() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Select Module");
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 884, 75);
		contentPane.add(panel);
		
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(739, 11, 135, 40);
		panel.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("KBN SKIN ESSENTIALS");
		lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 21));
		lblNewLabel_1.setBounds(10, 11, 272, 53);
		panel.add(lblNewLabel_1);
		
		JLabel lblMarketingLogo = new JLabel("");
		lblMarketingLogo.setIcon(new ImageIcon(Modules.class.getResource("/KBN/resources/Marketing.png")));
		lblMarketingLogo.setBounds(33, 168, 250, 200);
		contentPane.add(lblMarketingLogo);
		
		JLabel lblProductionLogo = new JLabel("");
		lblProductionLogo.setIcon(new ImageIcon(Modules.class.getResource("/KBN/resources/Production.png")));
		lblProductionLogo.setBounds(316, 168, 250, 200);
		contentPane.add(lblProductionLogo);
		
		JLabel lblWarehouseLogo = new JLabel("");
		lblWarehouseLogo.setIcon(new ImageIcon(Modules.class.getResource("/KBN/resources/Warehouse.png")));
		lblWarehouseLogo.setBounds(599, 168, 250, 200);
		contentPane.add(lblWarehouseLogo);
		
		btnWarehouse = new JButton("Warehouse");
		btnWarehouse.setEnabled(false);
		btnWarehouse.addActionListener(this);
		btnWarehouse.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnWarehouse.setFocusable(false);
		btnWarehouse.setBorderPainted(false);
		btnWarehouse.setBackground(Color.WHITE);
		btnWarehouse.setBounds(599, 391, 250, 46);
		contentPane.add(btnWarehouse);
		
		btnProduction = new JButton("Production");
		btnProduction.setEnabled(false);
		btnProduction.addActionListener(this);
		btnProduction.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnProduction.setFocusable(false);
		btnProduction.setBorderPainted(false);
		btnProduction.setBackground(Color.WHITE);
		btnProduction.setBounds(316, 391, 250, 46);
		contentPane.add(btnProduction);
		
		btnMarketing = new JButton("Marketing and Sales");
		btnMarketing.setEnabled(false);
		btnMarketing.addActionListener(this);
		btnMarketing.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnMarketing.setFocusable(false);
		btnMarketing.setBorderPainted(false);
		btnMarketing.setBackground(Color.WHITE);
		btnMarketing.setBounds(33, 391, 250, 46);
		contentPane.add(btnMarketing);
		setUsername();
	}
	
	
	private void setUsername() {
		dataSet = new dataSetter();
		lblUsername.setText(dataSet.getUsername());
	}
	
	public void accLevelIdentifier(String accLevel, String name) {
//		System.out.println(accLevel);
		lblUsername.setText(name);
		if(accLevel.equals("Manager-Marketing-All") || accLevel.equals("Staff-Marketing-Inventory and Ordering")) //Marketing
			btnMarketing.setEnabled(true);
		else if(accLevel.equals("Manager-Warehouse-All") || accLevel.equals("Staff-Warehouse-Materials Inventory")) //Warehouse
			btnWarehouse.setEnabled(true);
		else if(accLevel.equals("Manager-Production-All")) //Production
			btnProduction.setEnabled(true);
		else if(accLevel.equals("Admin--") || accLevel.equals("SuperAdmin--")) {
			btnMarketing.setEnabled(true);
			btnWarehouse.setEnabled(true);
			btnProduction.setEnabled(true);
		}else {
			btnMarketing.setEnabled(false);
			btnWarehouse.setEnabled(false);
			btnProduction.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnWarehouse) {
//			rm = new WarehouseModule();
//			rm.setVisible(true);
			
			rm1 = new WarehouseModule_1();
			rm1.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == btnProduction) {
			pm = new ProductionModule();
			pm.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == btnMarketing) {
			mm = new MarketingModule();
			mm.setVisible(true);
			this.dispose();
		}
	}
}
