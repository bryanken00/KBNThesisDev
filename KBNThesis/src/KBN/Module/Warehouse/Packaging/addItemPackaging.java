package KBN.Module.Warehouse.Packaging;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

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

public class addItemPackaging extends JDialog implements ActionListener {
	
	private DbConnection dbConn;
	private Statement st;
	
	private JTextField txtPackagingName;
	private JTextField txtVariant;
	private JTextField txtCategory;
	private JButton btnSubmit;
	
	public addItemPackaging() {
		setTitle("Add New Raw Material");
		setBounds(100, 100, 449, 411);
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
        panel.setBounds(10, 11, 413, 347);
        getContentPane().add(panel);
        
        JLabel lblAddNewRaw = new JLabel("ADD PACKAGING MATERIAL");
        lblAddNewRaw.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddNewRaw.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAddNewRaw.setBounds(13, 11, 386, 50);
        panel.add(lblAddNewRaw);
        
        JLabel lblMaterialName = new JLabel("Packaging Material Name:");
        lblMaterialName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMaterialName.setBounds(10, 72, 184, 14);
        panel.add(lblMaterialName);
        
        txtPackagingName = new JTextField();
        txtPackagingName.setColumns(10);
        txtPackagingName.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtPackagingName.setBounds(37, 97, 339, 34);
        panel.add(txtPackagingName);
        
        txtVariant = new JTextField();
        txtVariant.setColumns(10);
        txtVariant.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtVariant.setBounds(40, 237, 339, 34);
        panel.add(txtVariant);
        
        JLabel lblVariant = new JLabel("Variant:");
        lblVariant.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblVariant.setBounds(13, 212, 122, 14);
        panel.add(lblVariant);
        
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCategory.setBounds(13, 142, 122, 20);
        panel.add(lblCategory);
        
        txtCategory = new JTextField();
        txtCategory.setColumns(10);
        txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtCategory.setBounds(40, 167, 339, 34);
        panel.add(txtCategory);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSubmit.setFocusable(false);
        btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBounds(254, 301, 122, 35);
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit);
		setModal(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		txtPackagingName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtVariant.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		if(e.getSource() == btnSubmit) {
			String PMN = txtPackagingName.getText();
			String CT = txtCategory.getText();
			String VR = txtVariant.getText();
			
			if(PMN.isBlank() || PMN.isEmpty()) {
				txtPackagingName.setBorder(new LineBorder(new Color(255, 0, 0)));
			}
			
			if(CT.isBlank() || CT.isEmpty()) {
				txtCategory.setBorder(new LineBorder(new Color(255, 0, 0)));
			}
			
			if(VR.isBlank() || VR.isEmpty()) {
				txtVariant.setBorder(new LineBorder(new Color(255, 0, 0)));
			}
			
			if(PMN.isBlank() || PMN.isEmpty() || CT.isBlank() || CT.isEmpty() || VR.isBlank() || VR.isEmpty())
				return;
			
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				try {
					String drop = "DROP PROCEDURE IF EXISTS packagingAdd;";
					st.execute(drop);
					
					String SQL = "INSERT INTO tblcurrentmonthPackaging(MATERIAL_NAME, VARIANT, CATEGORIES) VALUES('" + PMN + "','" + CT + "','" + VR + "');";
					String audTrailSQL = "";
					
					String packagingProcedure =
						    "CREATE PROCEDURE packagingAdd()\n" +
						    "BEGIN\n" +
						    "    DECLARE EXIT HANDLER FOR SQLEXCEPTION\n" +
						    "    BEGIN\n" +
						    "        ROLLBACK;\n" +
						    "        RESIGNAL;\n" +
						    "    END;\n" +
						    "\n" +
						    "    START TRANSACTION;\n" +
						    SQL + "\n" +
						    audTrailSQL + "\n" +
						    "    COMMIT;\n" +
						    "END;";
					
					st.execute(packagingProcedure);
					st.execute("CALL packagingProcedure();");
					
					JOptionPane.showMessageDialog(null, "Packaging Material Added.");
					
					txtPackagingName.setText("");
					txtCategory.setText("");
					txtVariant.setText("");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}else
				return;
		}
		
	}
}
