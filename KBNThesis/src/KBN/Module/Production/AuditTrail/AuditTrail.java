package KBN.Module.Production.AuditTrail;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class AuditTrail extends JPanel implements MouseListener {
	public DefaultTableModel main;
	private JTextField txtSearchBar;
	public JTable table;
	
	public AuditTrail() {
		setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 989, 699);
        add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 969, 70);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(Color.WHITE);
        panel.add(panel_1);
        
        txtSearchBar = new JTextField();
        txtSearchBar.setText("Search by User, Actions");
        txtSearchBar.setForeground(Color.GRAY);
        txtSearchBar.setBounds(681, 20, 230, 29);
        txtSearchBar.addMouseListener(this);
        panel_1.add(txtSearchBar);
        
        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(AuditTrail.class.getResource("/KBN/resources/SearchBarUniversal.png")));
        btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSearch.setFocusable(false);
        btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(911, 20, 32, 28);
        panel_1.add(btnSearch);
        
        String Department[] = {"Marketing", "Production", "Warehouse"};
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(225, 20, 161, 28);
        panel_1.add(dateChooser);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 969, 596);
        panel.add(scrollPane);
        
        table = new JTable();
        main = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        scrollPane.setViewportView(table);
        
        tableSetup();
	}

	private void tableSetup() {
		String[] columnDefaultData = {"Time & Date", "User", "Actions"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		table.setRowHeight(50);
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column2 = columnModel.getColumn(2);
		column2.setPreferredWidth(400);
		TableColumn column0 = columnModel.getColumn(0);
		column0.setCellRenderer(new CenteredTableCellRenderer());

		TableColumn column1 = columnModel.getColumn(1);
		column1.setCellRenderer(new CustomTableCellRenderer());
	    
	    Font tableFont = new Font("Arial", Font.PLAIN, 14);
	    table.setFont(tableFont);
	    
        int headerRowHeight = 40;
        table.getTableHeader().setPreferredSize(new java.awt.Dimension(100, headerRowHeight));

        Font headerFont = new Font("Arial", Font.BOLD, 14); // Customize the font as needed
        table.getTableHeader().setFont(headerFont);
        
        table.getTableHeader().setBackground(Color.WHITE);
        
        table.getColumnModel().getColumn(2).setCellRenderer(new CustomFontTableCellRenderer());
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
		if(txtSearchBar.getText().equals("Search by User, Actions"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
			txtSearchBar.setText("Search by User, Actions");
			txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
	
    // Custom cell renderer for changing the font of specific text using HTML
    static class CustomFontTableCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value != null) {
                String cellText = value.toString();
                // Change the font of the first part (splitted[0])
                String[] splitted = cellText.split(" - ", 2);
                if (splitted.length == 2) {
                    // Wrap the first part in HTML tags with a custom font
                    setText("<html><font face='Arial' size='5'>" + splitted[0] + "</font> - " + splitted[1] + "</html>");
                } else {
                    setText(cellText);
                }
            }
            return c;
        }
    }
}
