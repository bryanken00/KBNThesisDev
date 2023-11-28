package KBNAdminPanel.panels.Price;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;

import KBN.commons.NumberOnlyDocumentFilter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class ProductPrice extends JDialog {
	private JTextField txtProfitMargin;
	public ProductPrice() {
		setTitle("Product Price");
		setBounds(0, 0, 408, 287);
		setModal(true);
		getContentPane().setLayout(null);
		
		// set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 372, 226);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Price");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setBounds(10, 11, 352, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Profit Margin (%):");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 101, 150, 25);
		panel.add(lblNewLabel_1_1);
		
		txtProfitMargin = new JTextField();
		txtProfitMargin.setColumns(10);
		txtProfitMargin.setBounds(170, 99, 192, 27);
		panel.add(txtProfitMargin);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setVerticalTextPosition(SwingConstants.CENTER);
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 32));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(10, 151, 352, 64);
		panel.add(btnUpdate);
		
		PlainDocument profit = (PlainDocument) txtProfitMargin.getDocument();
		
		NumberOnlyDocumentFilter numberFiler = new NumberOnlyDocumentFilter(10);
		
		profit.setDocumentFilter(numberFiler);
		
	}
}
