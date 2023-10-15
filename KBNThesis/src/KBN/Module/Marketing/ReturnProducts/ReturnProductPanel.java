package KBN.Module.Marketing.ReturnProducts;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ReturnProductPanel extends JPanel {
	
	public JTextField txtSearchBar;
	public DefaultTableModel main;
	public JTable table;
	public JButton btnView;
	public JButton btnUpdateStatus;
	
	public ReturnProductPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
        setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(10, 11, 969, 70);
        add(panel_1);
        
        txtSearchBar = new JTextField();
        txtSearchBar.setText("Search by User, Actions");
        txtSearchBar.setForeground(Color.GRAY);
        txtSearchBar.setBounds(697, 20, 230, 29);
        panel_1.add(txtSearchBar);
        
        JButton btnSearch = new JButton("");
        btnSearch.setIcon(new ImageIcon(ReturnProductPanel.class.getResource("/KBN/resources/SearchBarUniversal.png")));
        btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSearch.setFocusable(false);
        btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(927, 21, 32, 28);
        panel_1.add(btnSearch);
        
        JButton btnReturnProductList = new JButton("Return Product List");
        btnReturnProductList.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnReturnProductList.setFocusable(false);
        btnReturnProductList.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnReturnProductList.setBackground(Color.WHITE);
        btnReturnProductList.setBounds(10, 21, 158, 28);
        panel_1.add(btnReturnProductList);
        
        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(178, 20, 15, 29);
        panel_1.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(291, 20, 15, 29);
        panel_1.add(separator_1);
        
        JButton btnDisposed = new JButton("Disposed");
        btnDisposed.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnDisposed.setFocusable(false);
        btnDisposed.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnDisposed.setBackground(Color.WHITE);
        btnDisposed.setBounds(203, 21, 78, 28);
        panel_1.add(btnDisposed);
        
        JButton btnAbsorb = new JButton("Absorb");
        btnAbsorb.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnAbsorb.setFocusable(false);
        btnAbsorb.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnAbsorb.setBackground(Color.WHITE);
        btnAbsorb.setBounds(316, 21, 78, 28);
        panel_1.add(btnAbsorb);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 969, 557);
        add(scrollPane);
        
        btnView = new JButton("View Details");
        btnView.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnView.setFocusable(false);
        btnView.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnView.setBackground(Color.WHITE);
        btnView.setBounds(839, 660, 140, 28);
        add(btnView);
        

        table = new JTable();
        main = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane.setViewportView(table);
        
        btnUpdateStatus = new JButton("Update Status");
        btnUpdateStatus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnUpdateStatus.setFocusable(false);
        btnUpdateStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnUpdateStatus.setBackground(Color.WHITE);
        btnUpdateStatus.setBounds(10, 660, 140, 28);
        add(btnUpdateStatus);
        
        tableSetup();
	}
	
	private void tableSetup() {
		String[] columnDefaultData = {"Reference Number", "Date Return", "Client Name", "Status"};
		main.setColumnIdentifiers(columnDefaultData);
		table.setModel(main);
		table.setRowHeight(50);
	}
}
