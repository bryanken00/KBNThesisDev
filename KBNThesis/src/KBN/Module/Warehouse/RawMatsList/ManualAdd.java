package KBN.Module.Warehouse.RawMatsList;

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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class ManualAdd extends JDialog {
	public JTextField txtMaterialName;
	public JTextField txtCodeName;
	public JTextField txtSupplier;
	public JTextField txtReleasedVolume;
	public JDateChooser dateNow;

	public ManualAdd() {
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 413, 478);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("KBN RELEASING PRODUCT");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(13, 11, 386, 50);
		panel.add(lblTitle);
		
		JLabel lblMaterialName = new JLabel("Material Name:");
		lblMaterialName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaterialName.setBounds(10, 72, 122, 14);
		panel.add(lblMaterialName);
		
		txtMaterialName = new JTextField();
		txtMaterialName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMaterialName.setBounds(37, 97, 339, 34);
		panel.add(txtMaterialName);
		txtMaterialName.setColumns(10);
		
		txtCodeName = new JTextField();
		txtCodeName.setColumns(10);
		txtCodeName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCodeName.setBounds(37, 167, 339, 34);
		panel.add(txtCodeName);
		
		JLabel lblCodeName = new JLabel("Code Name:");
		lblCodeName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodeName.setBounds(10, 142, 122, 14);
		panel.add(lblCodeName);
		
		txtSupplier = new JTextField();
		txtSupplier.setColumns(10);
		txtSupplier.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSupplier.setBounds(37, 237, 339, 34);
		panel.add(txtSupplier);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSupplier.setBounds(10, 212, 122, 14);
		panel.add(lblSupplier);
		
		JLabel lblDateRelease = new JLabel("Date of Released:");
		lblDateRelease.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateRelease.setBounds(10, 282, 122, 14);
		panel.add(lblDateRelease);
		
		dateNow = new JDateChooser();
		dateNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateNow.setBounds(37, 307, 339, 34);
		panel.add(dateNow);
		
		JLabel lblReleaseVolume = new JLabel("Released Volume:");
		lblReleaseVolume.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReleaseVolume.setBounds(10, 352, 122, 14);
		panel.add(lblReleaseVolume);
		
		txtReleasedVolume = new JTextField();
		txtReleasedVolume.setColumns(10);
		txtReleasedVolume.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReleasedVolume.setBounds(37, 377, 339, 34);
		panel.add(txtReleasedVolume);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnSubmit.setFocusable(false);
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(254, 432, 122, 35);
		panel.add(btnSubmit);
	}
}