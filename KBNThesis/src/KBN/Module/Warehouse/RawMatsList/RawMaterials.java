package KBN.Module.Warehouse.RawMatsList;

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

public class RawMaterials extends JPanel implements MouseListener{
	
	public JTextField txtSearchBar;
	public JComboBox rawMatsCategory;
	public JDateChooser dateChooser;
	
	public DefaultTableModel main;
	public JTable table;
	public JButton btnSearch;
	

	private TableRowSorter<TableModel> sorter;

	public RawMaterials() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 969, 83);
		add(panel);
		panel.setLayout(null);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(10, 11, 400, 28);
		txtSearchBar.addMouseListener(this);
		panel.add(txtSearchBar);
		txtSearchBar.setText("Search by Material Name");
		txtSearchBar.setForeground(Color.GRAY);
		
		btnSearch = new JButton("");
		btnSearch.setBounds(410, 11, 32, 28);
		panel.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(RawMaterials.class.getResource("/KBN/resources/SearchBarUniversal.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(452, 11, 161, 28);
		panel.add(dateChooser);
		
		rawMatsCategory = new JComboBox();
		rawMatsCategory.setBounds(10, 50, 236, 22);
		panel.add(rawMatsCategory);
		
		JPanel tableContainer = new JPanel();
		tableContainer.setBackground(new Color(255, 255, 255));
		tableContainer.setBounds(10, 105, 969, 583);
		add(tableContainer);
		tableContainer.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 969, 583);
		tableContainer.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel();
		String[] columnDefaultData = new String[] {"ID", "SUPPLIER", "MATERIAL NAME", "CODE NAME","DATE", "CURRENT VOLUME", "APPEARANCE", "RELEASED", "REJECT", "HOLD", "PROD RETURN"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		for(int i = 0; i < 4; i++) {
			if(i == 2) {
				continue;
			}else {
				table.getColumnModel().getColumn(i).setMinWidth(0);
				table.getColumnModel().getColumn(i).setMaxWidth(0);
				table.getColumnModel().getColumn(i).setWidth(0);
			}
		}
		tableSorter();
	}

	private void tableSorter() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		sorter = new TableRowSorter<>(main);
	    sorter.setComparator(2, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
	        }
	    });

	    sorter.setComparator(4, new Comparator<String>() {
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

	    sorter.setComparator(5, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            return s1.compareTo(s2);
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
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(8, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(9, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            Integer int1 = Integer.parseInt(s1);
	            Integer int2 = Integer.parseInt(s2);
	            return int1.compareTo(int2);
	        }
	    });
	    
	    sorter.setComparator(10, new Comparator<String>() {
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
