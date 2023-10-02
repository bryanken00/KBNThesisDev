package KBN.Module.Warehouse.Archive;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
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

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class ArchiveList extends JPanel implements MouseListener{
	
	public DefaultTableModel main;
	private TableRowSorter<TableModel> sorter;
	
	public JTextField txtSearchBar;
	public JButton btnSearch;
	public JDateChooser dateChooser;
	public JComboBox rawMatsCategory;
	private JScrollPane scrollPane;
	public JTable table;
	
	public ArchiveList() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 969, 60);
		add(panel);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setText("Search by Material Name");
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.setBounds(618, 16, 307, 28);
		panel.add(txtSearchBar);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(ArchiveList.class.getResource("/KBN/resources/SearchBarUniversal.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(925, 16, 32, 28);
		panel.add(btnSearch);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(447, 16, 161, 28);
		panel.add(dateChooser);
		
		rawMatsCategory = new JComboBox();
		rawMatsCategory.setBounds(10, 19, 236, 22);
		panel.add(rawMatsCategory);
		
		JPanel tableContainer = new JPanel();
		tableContainer.setLayout(null);
		tableContainer.setBackground(Color.WHITE);
		tableContainer.setBounds(10, 82, 969, 606);
		add(tableContainer);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 969, 606);
		tableContainer.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		String[] columnDefaultData = new String[] {"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME", "RELEASED VOLUME", "PRODUCT DATE","USER - Archive", "ARCHIVE DATE"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		tableSorter();
	}

	private void tableSorter() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
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
	    
	    sorter.setComparator(6, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	        }
	    });
	    
	    sorter.setComparator(7, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
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
