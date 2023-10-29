package KBNAdminPanel.panels.Courier;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.LineBorder;

import KBNAdminPanel.commons.DbConnection;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class CourierCreateAccount extends JDialog implements ActionListener {
	
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtContact;
	private JButton btnRegister;
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	private JTextField txtUsername;
	private JTextField txtPassword;

	public CourierCreateAccount() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setBounds(0, 0, 568, 458);
		setModal(true);
		getContentPane().setLayout(null);
		
		dbConn = new DbConnection();
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Connection: " + e.getMessage());
		}
		
		// set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 96, 532, 312);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(10, 42, 251, 31);
		panel.add(txtLastName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(10, 11, 106, 20);
		panel.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(271, 11, 106, 20);
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(271, 42, 253, 31);
		panel.add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(10, 115, 251, 31);
		panel.add(txtMiddleName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiddleName.setBounds(10, 84, 106, 20);
		panel.add(lblMiddleName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(271, 115, 251, 31);
		panel.add(txtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(271, 84, 106, 20);
		panel.add(lblAddress);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 188, 253, 31);
		panel.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 157, 106, 20);
		panel.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(271, 157, 106, 20);
		panel.add(lblContact);
		
		txtContact = new JTextField();
		txtContact.setBounds(271, 188, 253, 31);
		panel.add(txtContact);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(10, 261, 253, 31);
		panel.add(txtUsername);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 230, 106, 20);
		panel.add(lblUsername);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(271, 261, 253, 31);
		panel.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(271, 230, 106, 20);
		panel.add(lblPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 532, 74);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Courier Create Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 336, 52);
		panel_1.add(lblNewLabel);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(384, 21, 140, 31);
		btnRegister.setOpaque(false);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(this);
		panel_1.add(btnRegister);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister) {
			String LName = txtLastName.getText();
			String FName = txtFirstName.getText();
			String MName = txtMiddleName.getText();
			String Address = txtAddress.getText();
			String Email = txtEmail.getText();
			String Contact = txtContact.getText();
			String userName = txtUsername.getText();
			String passWord = txtPassword.getText();
			
			if(LName.equals("") || FName.equals("") || MName.equals("") || Address.equals("") || Email.equals("") || Contact.equals("")) {
				JOptionPane.showMessageDialog(null, "Please complete the form.");
				return;
			}

			String userNameCheacker = "SELECT Username FROM tblcourieraccount;";
			String getCourierCount = "SELECT ID FROM tblcourierinformation ORDER BY ID DESC LIMIT 1;";
			int count = 0;
			try {
				st.execute(userNameCheacker);
				rs = st.getResultSet();
				while(rs.next()) {
					if(rs.getString(1).equals(userName)) {
						JOptionPane.showMessageDialog(null, "Username Already exist.");
						return;
					}
				}
				
				st.execute(getCourierCount);
				rs = st.getResultSet();
				if(rs.next())
					count = rs.getInt(1) + 1;
				
				String insertCourierAcc = "INSERT INTO tblcourieraccount VALUES('CourierID" + count + "','" + userName + "','" + passWord + "');";
				String insertCourierInfo = "INSERT INTO tblcourierinformation(courierID, Lastname, Firstname, MI, Address, Email, ContactNo) VALUES('CourierID" + count + "', '" + LName + "', '" + FName + "', '" + MName + "', '" + Address + "', '" + Email + "', '" + Contact + "');";
				
				st.execute(insertCourierAcc);
				st.execute(insertCourierInfo);
				
				JOptionPane.showMessageDialog(null, "Account Created!");
				clearData();
				this.dispose();
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error btnRegister: " + e1.getMessage());
			}
			
		}
	}
	
	private void clearData() {
		txtLastName.setText("");
		txtFirstName.setText("");
		txtMiddleName.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
	}
}
