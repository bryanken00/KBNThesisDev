package KBN.Module.Production.Navs;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class ProductionNav extends JPanel {
	public JLabel lblUsername;
	
	public JButton btnAddItem;
	public JButton btnKBNProduct;
	public JButton btnRebrandingProduct;
	public JButton btnArchiveList;
	
	public ProductionNav() {
		setBounds(0, 0, 255, 721);
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(ProductionNav.class.getResource("/KBN/resources/kbnlogo.png")));
		lblLogo_1.setBounds(10, 11, 241, 65);
		add(lblLogo_1);
		
		lblUsername = new JLabel((String) null);
		lblUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		lblUsername.setBounds(10, 670, 241, 40);
		add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 87, 235, 10);
		add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(10, 154, 235, 10);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBounds(10, 646, 235, 10);
		add(separator_3);
		
		btnKBNProduct = new JButton("KBN Product");
		btnKBNProduct.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnKBNProduct.setFocusable(false);
		btnKBNProduct.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnKBNProduct.setBackground(Color.WHITE);
		btnKBNProduct.setBounds(10, 175, 235, 46);
		add(btnKBNProduct);
		
		btnRebrandingProduct = new JButton("Rebranding Product");
		btnRebrandingProduct.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRebrandingProduct.setFocusable(false);
		btnRebrandingProduct.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnRebrandingProduct.setBackground(Color.WHITE);
		btnRebrandingProduct.setBounds(10, 232, 235, 46);
		add(btnRebrandingProduct);
		
		btnArchiveList = new JButton("Archive List");
		btnArchiveList.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnArchiveList.setFocusable(false);
		btnArchiveList.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnArchiveList.setBackground(Color.WHITE);
		btnArchiveList.setBounds(10, 289, 235, 46);
		add(btnArchiveList);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setFocusable(false);
		btnAddItem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setBounds(10, 97, 235, 46);
		add(btnAddItem);
		
	}
}
