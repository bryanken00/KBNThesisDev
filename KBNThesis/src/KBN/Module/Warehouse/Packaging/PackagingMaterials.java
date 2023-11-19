package KBN.Module.Warehouse.Packaging;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PackagingMaterials extends JPanel implements MouseListener{

	public DefaultTableModel main;
	private TableRowSorter<TableModel> sorter;
	
	public JTextField txtSearchBar;
	public JComboBox rawMatsCategory;
	public JDateChooser dateChooser;
	
	public JTable table;
	public JButton btnSearch;
	public JComboBox cbAvailable;
	

	

	public PackagingMaterials() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 969, 60);
		add(panel);
		panel.setLayout(null);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(618, 16, 307, 28);
		txtSearchBar.addMouseListener(this);
		panel.add(txtSearchBar);
		txtSearchBar.setText("Search by Material Name");
		txtSearchBar.setForeground(Color.GRAY);
		
		btnSearch = new JButton("");
		btnSearch.setBounds(925, 16, 32, 28);
		panel.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(PackagingMaterials.class.getResource("/KBN/resources/SearchBarUniversal.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(428, 16, 161, 28);
		panel.add(dateChooser);
		
		rawMatsCategory = new JComboBox();
		rawMatsCategory.setBounds(228, 19, 172, 22);
		panel.add(rawMatsCategory);
		
		String [] cb = {"Use History","Available Materials"};
		cbAvailable = new JComboBox(cb);
		cbAvailable.setBounds(28, 19, 172, 22);
		panel.add(cbAvailable);
		
		JPanel tableContainer = new JPanel();
		tableContainer.setBackground(new Color(255, 255, 255));
		tableContainer.setBounds(10, 82, 969, 606);
		add(tableContainer);
		tableContainer.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 969, 606);
		tableContainer.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		String[] columnDefaultData = new String[] {"ID","MATERIAL NAME", "VARIANT", "DATE", "CURRENT VOLUME", "RELEASED", "REJECT", "HOLD", "PROD RETURN"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);
		tableSorter();
	}

	private void tableSorter() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		sorter = new TableRowSorter<>(main);
		
		
		// "ID","MATERIAL NAME", "VARIANT", "DATE", "CURRENT VOLUME", "RELEASED", "REJECT", "HOLD", "PROD RETURN"
		
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
	    
	    sorter.setComparator(4, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            try {
	                Date date1 = dateFormat.parse(s1);
	                Date date2 = dateFormat.parse(s2);
	                return date1.compareTo(date2);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                return 0;
	            }
	        }
	    });
	    
	    sorter.setComparator(5, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            int int1 = Integer.parseInt(s1);
	            int int2 = Integer.parseInt(s2);
	            
	            return Integer.compare(int1, int2);
	        }
	    });
	    
	    sorter.setComparator(6, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            int int1 = Integer.parseInt(s1);
	            int int2 = Integer.parseInt(s2);
	            
	            return Integer.compare(int1, int2);
	        }
	    });
	    
	    sorter.setComparator(7, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            int int1 = Integer.parseInt(s1);
	            int int2 = Integer.parseInt(s2);
	            
	            return Integer.compare(int1, int2);
	        }
	    });
	    
	    sorter.setComparator(6, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            int int1 = Integer.parseInt(s1);
	            int int2 = Integer.parseInt(s2);
	            
	            return Integer.compare(int1, int2);
	        }
	    });
	    
	    sorter.setComparator(7, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            int int1 = Integer.parseInt(s1);
	            int int2 = Integer.parseInt(s2);
	            
	            return Integer.compare(int1, int2);
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
		if(txtSearchBar.getText().equals("Search by Material Name"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
		txtSearchBar.setText("Search by Material Name");
		txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
