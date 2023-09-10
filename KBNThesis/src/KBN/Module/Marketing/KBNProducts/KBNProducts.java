package KBN.Module.Marketing.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class KBNProducts extends JPanel {

	public String columnDefaultData[];
	public DefaultTableModel main;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	public JComboBox cbSoldProd;
	public JComboBox cbCategories;
	public JComboBox cbSort;
	
	public KBNProducts() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 146, 933, 511);
		add(scrollPane);
		
		table = new JTable(){
		public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;
			}
		};
		table.setDefaultEditor(getClass(), null);
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
		lblNewLabel.setIcon(new ImageIcon(KBNProducts.class.getResource("/KBN/resources/Marketing/menuKBN.png")));
		lblNewLabel.setBounds(26, 38, 933, 78);
		add(lblNewLabel);
		
		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
        String columnIdentifiers[] = {"ProdID", "Product Name", "Quantity", "Sold"};
        main.setColumnIdentifiers(columnIdentifiers);
		table.setModel(main);
		
		// hide 1st column
		table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        
		// set 2nd Column width
        table.getColumnModel().getColumn(1).setPreferredWidth(400);;
	}
}
