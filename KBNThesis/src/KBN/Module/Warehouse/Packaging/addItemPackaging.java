package KBN.Module.Warehouse.Packaging;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
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
import javax.swing.JComboBox;

public class addItemPackaging extends JDialog implements ActionListener, MouseListener {

	private String userID = "";
	private boolean newCat = false;
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	
	private JTextField txtPackagingName;
	private JTextField txtVariant;
	private JTextField txtCategory;
	private JButton btnSubmit;
	private JLabel lblNewCat;
	private JComboBox cbCategory;
	
	
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
        txtVariant.setBounds(37, 237, 339, 34);
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
        txtCategory.setBounds(37, 167, 339, 34);
        txtCategory.setVisible(false);
        panel.add(txtCategory);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnSubmit.setFocusable(false);
        btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBounds(254, 301, 122, 35);
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit);
        
        cbCategory = new JComboBox();
        cbCategory.setBounds(37, 167, 339, 34);
        panel.add(cbCategory);
        
        lblNewCat = new JLabel("add new?");
        lblNewCat.setBounds(316, 147, 57, 14);
        lblNewCat.addMouseListener(this);
        panel.add(lblNewCat);
		setModal(true);

		renderCategory();
	}
	
	private void renderCategory() {
		try {
			String sql = "SELECT CATEGORIES FROM tblcurrentmonthPackaging;";
			st.execute(sql);
			ArrayList<String> cat = new ArrayList<>();
			
			rs = st.getResultSet();
			while(rs.next())
				cat.add(rs.getString(1));
			
	        cbCategory.removeAllItems();

	        for (String category : cat) {
	            cbCategory.addItem(category);
	        }
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error renderCategory: " + e.getMessage());
		}
	}
	
	public void setUserID(String uID) {
		userID = uID;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		txtPackagingName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtVariant.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		boolean PMN_ = false;
		boolean CT_ = false;
		boolean VR_ = false;

		String PMN = txtPackagingName.getText();
		String CT = txtCategory.getText();
		String VR = txtVariant.getText();
		

		
		if(e.getSource() == btnSubmit) {
			

			if(PMN.isBlank() || PMN.isEmpty()) {
				txtPackagingName.setBorder(new LineBorder(new Color(255, 0, 0)));
				PMN_ = true;
			}
			
			if(VR.isBlank() || VR.isEmpty()) {
				txtVariant.setBorder(new LineBorder(new Color(255, 0, 0)));
				VR_ = true;
			}
			
			JOptionPane.showMessageDialog(null, newCat);
			
			if(newCat) {
				if(CT.isBlank() || CT.isEmpty()) {
					txtCategory.setBorder(new LineBorder(new Color(255, 0, 0)));
					CT_ = true;
				}
			}
			else
				CT = cbCategory.getSelectedItem().toString();
			
			if(PMN_ || CT_ || VR_) {
				JOptionPane.showMessageDialog(null, "Please fill the form.");
				return;
			}
			
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				try {
					String drop = "DROP PROCEDURE IF EXISTS packagingAdd;";
					st.execute(drop);
					
					String SQL = "INSERT INTO tblcurrentmonthPackaging(MATERIAL_NAME, VARIANT, CATEGORIES, DATE_TODAY) VALUES('" + PMN + "','" + VR + "','" + CT + "', NOW());";
					String AuditTrail = "INSERT INTO audittrailwarehouse(DateAction,userID,Description) VALUES(NOW(),'" + userID + "','Add Item: Packaging - " + txtPackagingName.getText() + "');";
					
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
						    AuditTrail + "\n" +
						    "    COMMIT;\n" +
						    "END;";
					
					st.execute(packagingProcedure);
					st.execute("CALL packagingAdd();");
					
					JOptionPane.showMessageDialog(null, "Packaging Material Added.");
					
					txtPackagingName.setText("");
					txtCategory.setText("");
					txtVariant.setText("");
					cbCategory.setSelectedIndex(0);
					
					newCatFalse();

					renderCategory();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}else
				return;
		}
		
	}
	
	private void newCatTrue() {
		newCat = true;
		cbCategory.setVisible(false);
		txtCategory.setVisible(true);
		lblNewCat.setText("back");
	}
	private void newCatFalse() {
		newCat = false;
		cbCategory.setVisible(true);
		txtCategory.setVisible(false);
		lblNewCat.setText("add new?");
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblNewCat) {
			if(lblNewCat.getText().equals("add new?")) {
				newCatTrue();
			} else if(lblNewCat.getText().equals("back")) {
				newCatFalse();
			}
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
