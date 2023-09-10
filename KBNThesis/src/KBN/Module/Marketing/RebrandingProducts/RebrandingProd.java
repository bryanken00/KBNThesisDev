package KBN.Module.Marketing.RebrandingProducts;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;

public class RebrandingProd extends JPanel {

	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	private JTextField txtSearchBar;
	private JComboBox cbSoldProd;
	private JComboBox cbCategories;
	private JComboBox cbSort;
	
	public RebrandingProd() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 146, 933, 511);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
		
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
		lblNewLabel.setIcon(new ImageIcon(RebrandingProd.class.getResource("/KBN/resources/Marketing/menuKBN.png")));
		lblNewLabel.setBounds(26, 38, 933, 78);
		add(lblNewLabel);
		
		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);   
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		columnDefaultData = new String[] {"BASTA ITO REBRANDING PRODUCTS TO (MARKETING)"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
	}
}
