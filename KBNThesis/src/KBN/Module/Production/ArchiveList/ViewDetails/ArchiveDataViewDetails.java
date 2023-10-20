package KBN.Module.Production.ArchiveList.ViewDetails;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

public class ArchiveDataViewDetails extends JDialog {
	public JLabel lblTrackingID;
	public JScrollPane scrollPane;
	

	public ArchiveDataViewDetails() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 709, 576);
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 673, 515);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new LineBorder(new Color(123,156,121), 1, true));
		panelTop.setBounds(10, 11, 653, 68);
		panel.add(panelTop);
		panelTop.setBackground(new Color(123,156,121));
		panelTop.setLayout(null);
		
		lblTrackingID = new JLabel("Tracking ID: ");
		lblTrackingID.setForeground(new Color(255, 255, 255));
		lblTrackingID.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTrackingID.setBounds(10, 11, 236, 46);
		panelTop.add(lblTrackingID);
		
		JLabel lblAddedProduct = new JLabel("Added Product");
		lblAddedProduct.setForeground(new Color(255, 255, 255));
		lblAddedProduct.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddedProduct.setBounds(424, 11, 219, 46);
		panelTop.add(lblAddedProduct);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 653, 414);
		panel.add(scrollPane);
	}
}
