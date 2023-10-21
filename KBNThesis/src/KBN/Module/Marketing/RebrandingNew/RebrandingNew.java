package KBN.Module.Marketing.RebrandingNew;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RebrandingNew extends JPanel implements MouseListener {

	public String columnDefaultData[];
	public DefaultTableModel main;
	private TableRowSorter<TableModel> sorter;
	public JTable table;
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	
	public JButton btnProducts;
	public JButton btnArchive;
	public JButton btnSearch;
	
	public RebrandingNew() {
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
		
		String [] categories = {"Categories"};

		String [] sort = {"Sort"};
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(614, 61, 270, 32);
		txtSearchBar.setText("Search by Product Name, Client Name");
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setColumns(10);
		add(txtSearchBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(26, 38, 933, 78);
		lblNewLabel.setIcon(new ImageIcon(RebrandingNew.class.getResource("/KBN/resources/Marketing/menuKBN.png")));
		add(lblNewLabel);
		
		btnProducts = new JButton("Products");
		btnProducts.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnProducts.setFocusable(false);
		btnProducts.setBackground(Color.WHITE);
		btnProducts.setBounds(113, 61, 114, 33);
		btnProducts.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnProducts);
		
		btnArchive = new JButton("Archive");
		btnArchive.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchive.setFocusable(false);
		btnArchive.setBackground(Color.WHITE);
		btnArchive.setBounds(250, 59, 114, 35);
		btnArchive.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(btnArchive);
		
		JLabel lblNewLabel_1 = new JLabel("List:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(55, 61, 55, 33);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(238, 61, 48, 33);
		add(separator);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(RebrandingNew.class.getResource("/KBN/resources/CustAccount/search.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(884, 61, 32, 32);
		add(btnSearch);
		
		tableSetup();
		
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE); // Background
        header.setForeground(Color.BLACK); // Text
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
        String columnIdentifiers[] = {"Product ID", "User ID", "Client Name", "Product Name", "Sold", "Available", "Return", "Total"};
        main.setColumnIdentifiers(columnIdentifiers);
		table.setModel(main);
        Font cellFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(cellFont);
		table.setRowHeight(30);
		
		sorter = new TableRowSorter<>(main);

	    sorter.setComparator(1, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	        	return s1.compareTo(s2);
	        }
	    });

	    
	    sorter.setComparator(2, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	        	return s1.compareTo(s2);
	        }
	    });
	    
	    sorter.setComparator(3, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	        	return s1.compareTo(s2);
	        }
	    });
	    
	    sorter.setComparator(4, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(5, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
		table.setRowSorter(sorter);

	    table.getTableHeader().addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            int columnIndex = table.columnAtPoint(e.getPoint());

	            sorter.toggleSortOrder(columnIndex);
	        }
	    });
		
		// hide 1st column
		table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        
		// set 2nd Column width
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(txtSearchBar.getText().equals("Search by Product Name, Client Name"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
			txtSearchBar.setText("Search by Product Name, Client Name");
			txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
