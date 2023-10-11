package KBN.Module.Marketing.RebrandingProducts;

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

public class RebrandingProd extends JPanel implements MouseListener {
	
	public JScrollPane scrollPane;
	public JTextField txtSearchBar;
	
	public JButton btnProducts;
	public JButton btnArchive;
	public JButton btnSearch;
	
	public RebrandingProd() {
		setBackground(new Color(255, 255, 255));
        this.setBounds(0, 0, 989, 699);
		setLayout(null);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 146, 933, 511);
		add(scrollPane);
		
		txtSearchBar = new JTextField();
		txtSearchBar.setBounds(684, 61, 200, 32);
		txtSearchBar.setText("Search by Product Name");
		txtSearchBar.setForeground(Color.GRAY);
		txtSearchBar.addMouseListener(this);
		txtSearchBar.setColumns(10);
		add(txtSearchBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(26, 38, 933, 78);
		lblNewLabel.setIcon(new ImageIcon(RebrandingProd.class.getResource("/KBN/resources/Marketing/menuKBN.png")));
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
		btnSearch.setIcon(new ImageIcon(RebrandingProd.class.getResource("/KBN/resources/CustAccount/search.png")));
		btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(884, 61, 32, 32);
		add(btnSearch);
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
		if(txtSearchBar.getText().equals("Search by Product Name"))
			txtSearchBar.setText("");
		txtSearchBar.setForeground(Color.BLACK);
		txtSearchBar.setFocusable(true);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(txtSearchBar.getText().equals("")) {
			txtSearchBar.setText("Search by Product Name");
			txtSearchBar.setForeground(Color.GRAY);
		}
		txtSearchBar.setFocusable(false);
	}
}
