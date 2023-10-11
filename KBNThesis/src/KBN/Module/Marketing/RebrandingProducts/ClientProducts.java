package KBN.Module.Marketing.RebrandingProducts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

public class ClientProducts extends JDialog {
	
	public DefaultTableModel main;
	private JTable table;
	
	public ClientProducts() {
		setResizable(false);
		setBounds(100, 100, 828, 565);
		getContentPane().setLayout(null);
		setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 792, 419);
		getContentPane().add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(104,140,92));
		panel.setBounds(10, 11, 792, 71);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Products:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(10, 11, 168, 49);
		panel.add(lblNewLabel);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableSetup();
	}
	
	private void tableSetup() {
		main = new DefaultTableModel(table.getRowCount(), table.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		String[] columidentifier = {"Product Name", "Variant", "Total Order"};
		main.setColumnIdentifiers(columidentifier);
		table.setModel(main);
		
        Font cellFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(cellFont);
        table.setRowHeight(30);
		

	}
}
