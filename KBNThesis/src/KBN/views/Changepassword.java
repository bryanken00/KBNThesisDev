package KBN.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import KBNAdminPanel.commons.DbConnection;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Changepassword extends JDialog implements ActionListener {
	private JPasswordField pwOld;
	private JPasswordField pwNew;
	private JPasswordField pwConfirm;
	private JButton btnChange;
	private JLabel lblConfirm;
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;

	private String accID = "";
	
	public Changepassword() {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 424, 431);
		this.setModal(true);
		
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
		panel.setBounds(10, 11, 384, 368);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 364, 98);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 11, 344, 76);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Old Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 131, 187, 15);
		panel.add(lblNewLabel_1);
		
		pwOld = new JPasswordField();
		pwOld.setBounds(10, 153, 364, 30);
		panel.add(pwOld);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 194, 187, 15);
		panel.add(lblNewLabel_1_1);
		
		pwNew = new JPasswordField();
		pwNew.setBounds(10, 216, 364, 30);
		panel.add(pwNew);
		
		lblConfirm = new JLabel("Confirm Password:");
		lblConfirm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirm.setBounds(10, 257, 187, 15);
		panel.add(lblConfirm);
		
		pwConfirm = new JPasswordField();
		pwConfirm.setBounds(10, 279, 364, 30);
		panel.add(pwConfirm);
		
		btnChange = new JButton("Change");
		btnChange.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnChange.setFocusable(false);
		btnChange.setBackground(Color.WHITE);
		btnChange.setBounds(176, 320, 198, 29);
		btnChange.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(btnChange);
		btnChange.addActionListener(this);
		dbConn = new DbConnection();
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnChange) {
			try {
				String SQL = "SELECT Password FROM tblaccount WHERE AccountID = " + accID + ";";
				System.out.println(SQL);
				st.execute(SQL);
				rs = st.getResultSet();
				String oldPass = "";
				if(rs.next())
					oldPass = rs.getString(1);
				
				if(pwOld.getText().equals("") || pwConfirm.getText().equals("") || pwNew.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the form.");
				}
				
				if(oldPass.equals(pwOld.getText())) {
					if(pwNew.getText().equals(pwConfirm.getText())) {
						String updatePass = "UPDATE tblaccount\r\n"
								+ "SET Password = '" + pwNew.getText() + "'\r\n"
								+ "WHERE AccountID = '" + accID + "';";
						st.execute(updatePass);
						JOptionPane.showMessageDialog(null, "Change Password Completed!");
					}else {
						JOptionPane.showMessageDialog(null, "Password not match!");
					}
				}else
					JOptionPane.showMessageDialog(null, "Invalid old password");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error Change Pass: " + e2.getMessage());
			}
		}
		
	}
	
	public void setAccID(String accountID) {
		accID = accountID;
	}
}
