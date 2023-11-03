package KBN.Module.Warehouse.RawMatsList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import KBN.commons.DbConnection;

public class addNew extends JDialog implements ActionListener {
	
	private DbConnection dbConn;
	private Statement st;
	
	private JTextField txtMaterialName;
	private JTextField txtCodename;
	private JTextField txtSupplier;
	private JTextField txtCategory;
	private JButton btnSubmit;
	private JTextField txtApperance;
	
	public addNew() {
		setTitle("Add New Raw Material");
		setBounds(100, 100, 449, 537);
		getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        
        dbConn = new DbConnection();
        try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 11, 413, 476);
        getContentPane().add(panel);
        
        JLabel lblAddNewRaw = new JLabel("ADD NEW RAW MATERIAL");
        lblAddNewRaw.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddNewRaw.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAddNewRaw.setBounds(13, 11, 386, 50);
        panel.add(lblAddNewRaw);
        
        JLabel lblMaterialName = new JLabel("Material Name:");
        lblMaterialName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMaterialName.setBounds(10, 72, 122, 14);
        panel.add(lblMaterialName);
        
        txtMaterialName = new JTextField();
        txtMaterialName.setColumns(10);
        txtMaterialName.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtMaterialName.setBounds(37, 97, 339, 34);
        panel.add(txtMaterialName);
        
        txtCodename = new JTextField();
        txtCodename.setColumns(10);
        txtCodename.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtCodename.setBounds(37, 237, 339, 34);
        panel.add(txtCodename);
        
        JLabel lblCodeName = new JLabel("Code Name:");
        lblCodeName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCodeName.setBounds(10, 212, 122, 14);
        panel.add(lblCodeName);
        
        txtSupplier = new JTextField();
        txtSupplier.setColumns(10);
        txtSupplier.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtSupplier.setBounds(37, 307, 339, 34);
        panel.add(txtSupplier);
        
        JLabel lblSupplier = new JLabel("Supplier:");
        lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSupplier.setBounds(10, 282, 122, 14);
        panel.add(lblSupplier);
        
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCategory.setBounds(10, 352, 122, 20);
        panel.add(lblCategory);
        
        txtCategory = new JTextField();
        txtCategory.setColumns(10);
        txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtCategory.setBounds(37, 377, 339, 34);
        panel.add(txtCategory);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSubmit.setFocusable(false);
        btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBounds(254, 430, 122, 35);
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit);
        
        txtApperance = new JTextField();
        txtApperance.setColumns(10);
        txtApperance.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtApperance.setBounds(37, 167, 339, 34);
        panel.add(txtApperance);
        
        JLabel lblApperance = new JLabel("Appearance:");
        lblApperance.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblApperance.setBounds(10, 142, 122, 20);
        panel.add(lblApperance);
		setModal(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSubmit) {
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				try {
					String sqlAddNew = "INSERT INTO tblcurrentmonth(todayCurrentVolume, RECEIVED_VOLUME, APPEARANCE, RELEASED_VOLUME, REJECT_VOLUME, HOLD_VOLUME, PROD_RETURN, DATE_TODAY, MATERIAL_NAME, CODE_NAME, SUPPLIER, CATEGORIES)\r\n"
							+ "VALUES(0, 0, '" + txtApperance.getText() + "', 0, 0, 0, 0, NOW(), '" + txtMaterialName.getText() + "', '" + txtCodename.getText() + "', '" + txtSupplier.getText() + "', '" + txtCategory.getText() + "');";
					st.execute(sqlAddNew);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}else
				return;
		}
		
	}
}
