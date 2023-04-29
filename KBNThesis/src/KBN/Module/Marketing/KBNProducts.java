package KBN.Module.Marketing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class KBNProducts extends JPanel {

	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	private JTextField txtSearchBar;
	private JComboBox cbSoldProd;
	private JComboBox cbCategories;
	private JComboBox cbSort;
	private JLabel lblNewLabel_1;
	
	public KBNProducts() {
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 146, 933, 511);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		String [] soldProd = {"Sold Products"};
		cbSoldProd = new JComboBox(soldProd);
		cbSoldProd.setBounds(63, 61, 197, 33);
		add(cbSoldProd);
		
		String [] categories = {"Categories"};
		cbCategories = new JComboBox(categories);
		cbCategories.setBounds(270, 61, 197, 33);
		add(cbCategories);

		String [] sort = {"Sort"};
		cbSort = new JComboBox(sort);
		cbSort.setBounds(477, 61, 197, 33);
		add(cbSort);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("search bar");
		txtSearchBar.setBounds(684, 61, 260, 33);
		add(txtSearchBar);
		txtSearchBar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(KBNProducts.class.getResource("/KBN/resources/Marketing/menuKBN.png")));
		lblNewLabel.setBounds(26, 38, 933, 78);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(KBNProducts.class.getResource("/KBN/resources/Marketing/marketingPanelBG.png")));
		lblNewLabel_1.setBounds(0, 0, 989, 699);
		add(lblNewLabel_1);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"BASTA ITO KBN PRODUCTS TO (MARKETING)"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
