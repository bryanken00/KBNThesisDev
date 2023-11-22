package KBN.Module.Warehouse.Packaging;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class ManualAddPackaging extends JDialog implements ActionListener{
	public JTextField txtMaterialName;
	public JTextField txtCategory;
	public JTextField txtVariant;
	public JTextField txtReleasedVolume;
	public JDateChooser dateNow;
	public JButton btnSubmit;
	public JButton btnNew;

	public ManualAddPackaging() {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 449, 539);
		getContentPane().setLayout(null);
		setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel Category = new JPanel();
		Category.setBorder(new LineBorder(new Color(0, 0, 0)));
		Category.setBackground(new Color(255, 255, 255));
		Category.setBounds(10, 11, 413, 478);
		getContentPane().add(Category);
		Category.setLayout(null);
		
		JLabel lblTitle = new JLabel("Packaging Material");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(13, 11, 386, 50);
		Category.add(lblTitle);
		
		JLabel lblMaterialName = new JLabel("Packaging Material Name:");
		lblMaterialName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaterialName.setBounds(10, 72, 191, 14);
		Category.add(lblMaterialName);
		
		txtMaterialName = new JTextField();
		txtMaterialName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaterialName.setBounds(37, 97, 339, 34);
		Category.add(txtMaterialName);
		txtMaterialName.setColumns(10);
		
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCategory.setBounds(37, 167, 339, 34);
		Category.add(txtCategory);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(10, 142, 122, 14);
		Category.add(lblCategory);
		
		txtVariant = new JTextField();
		txtVariant.setColumns(10);
		txtVariant.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtVariant.setBounds(37, 237, 339, 34);
		Category.add(txtVariant);
		
		JLabel lblVariant = new JLabel("Varaint:");
		lblVariant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVariant.setBounds(10, 212, 122, 14);
		Category.add(lblVariant);
		
		JLabel lblDateRelease = new JLabel("Date of Released:");
		lblDateRelease.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateRelease.setBounds(10, 282, 122, 14);
		Category.add(lblDateRelease);
		
		dateNow = new JDateChooser();
//		dateNow.setDate(new Date());
		dateNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateNow.setBounds(37, 307, 339, 34);
		Category.add(dateNow);
		
		JLabel lblReleaseVolume = new JLabel("Add Quantity");
		lblReleaseVolume.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReleaseVolume.setBounds(10, 352, 169, 14);
		Category.add(lblReleaseVolume);
		
		txtReleasedVolume = new JTextField();
		txtReleasedVolume.setColumns(10);
		txtReleasedVolume.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReleasedVolume.setBounds(37, 377, 339, 34);
		Category.add(txtReleasedVolume);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSubmit.setFocusable(false);
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(254, 432, 122, 35);
		btnSubmit.addActionListener(this);
		Category.add(btnSubmit);
		
		btnNew = new JButton("Add New Material");
		btnNew.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnNew.setFocusable(false);
		btnNew.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNew.setBackground(Color.WHITE);
		btnNew.setBounds(13, 432, 135, 35);
		Category.add(btnNew);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//default
		txtMaterialName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtVariant.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReleasedVolume.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		if(e.getSource() == btnSubmit) {
			if(txtMaterialName.getText().equals(""))
				txtMaterialName.setBorder(new LineBorder(new Color(255, 3, 3)));
			
			if(txtCategory.getText().equals(""))
				txtCategory.setBorder(new LineBorder(new Color(255, 3, 3)));
			
			if(txtVariant.getText().equals(""))
				txtVariant.setBorder(new LineBorder(new Color(255, 3, 3)));
			
			if(txtReleasedVolume.getText().equals(""))
				txtReleasedVolume.setBorder(new LineBorder(new Color(255, 3, 3)));
			
			if(txtVariant.getText().equals(""))
				txtVariant.setBorder(new LineBorder(new Color(255, 3, 3)));
			
			if (dateNow.getDate() == null)
				dateNow.setBorder(new LineBorder(new Color(255, 3, 3)));
			
		}
	}
}
