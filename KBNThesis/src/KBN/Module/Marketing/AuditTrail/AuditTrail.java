package KBN.Module.Marketing.AuditTrail;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class AuditTrail extends JPanel {
	public DefaultTableModel main;
	private JTextField textField;
	private JTable table;
	
	public AuditTrail() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 969, 677);
        add(panel);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 933, 70);
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(Color.WHITE);
        panel.add(panel_1);
        
        textField = new JTextField();
        textField.setText("Search by CourierID or Ref Number");
        textField.setForeground(Color.GRAY);
        textField.setBounds(648, 20, 230, 29);
        panel_1.add(textField);
        
        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(AuditTrail.class.getResource("/KBN/resources/SearchBarUniversal.png")));
        btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSearch.setFocusable(false);
        btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(878, 20, 32, 28);
        panel_1.add(btnSearch);
        
        String Department[] = {"Marketing", "Production", "Warehouse"};
        
        JComboBox comboBox = new JComboBox(Department);
        comboBox.setBounds(10, 20, 177, 29);
        panel_1.add(comboBox);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(225, 20, 161, 28);
        panel_1.add(dateChooser);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 949, 574);
        panel.add(scrollPane);
        
        table = new JTable();
		main = new DefaultTableModel();
        scrollPane.setViewportView(table);
        
        tableSetup();
	}

	private void tableSetup() {
		String[] columnDefaultData = {"Time & Date", "User", "Actions"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		table.setRowHeight(30);
		
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
	    column.setPreferredWidth(20);
	}
}
