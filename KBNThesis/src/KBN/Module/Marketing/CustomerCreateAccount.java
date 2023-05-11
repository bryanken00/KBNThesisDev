package KBN.Module.Marketing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;

public class CustomerCreateAccount extends JDialog implements ActionListener{
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	private ArrayList arr;
	
	
	//password
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
	private JTextField txtLN;
	private JTextField txtFN;
	private JTextField txtMI;
	private JTextField textField_3;
	private JTextField txtAddress;
	private JTextField txtContact;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnRegister;
	private JEditorPane paneText;
	private JButton btnGeneratePass;
	
	public CustomerCreateAccount() {
		setResizable(false);
        setBounds(100, 100, 834, 487);
		this.setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Create Account");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(24, 24, 134, 30);
        getContentPane().add(lblNewLabel);
        
        txtLN = new JTextField();
        txtLN.setBounds(24, 114, 224, 30);
        getContentPane().add(txtLN);
        txtLN.setColumns(10);
        
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLastName.setBounds(24, 84, 134, 30);
        getContentPane().add(lblLastName);
        
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFirstName.setBounds(309, 84, 134, 30);
        getContentPane().add(lblFirstName);
        
        txtFN = new JTextField();
        txtFN.setColumns(10);
        txtFN.setBounds(309, 114, 224, 30);
        getContentPane().add(txtFN);
        
        JLabel lblMi = new JLabel("M.I");
        lblMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMi.setBounds(572, 84, 134, 30);
        getContentPane().add(lblMi);
        
        txtMI = new JTextField();
        txtMI.setColumns(10);
        txtMI.setBounds(572, 114, 224, 30);
        getContentPane().add(txtMI);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(24, 185, 224, 30);
        getContentPane().add(textField_3);
        
        JLabel lblLastName_1 = new JLabel("");
        lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLastName_1.setBounds(24, 155, 134, 30);
        getContentPane().add(lblLastName_1);
        
        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(309, 185, 487, 30);
        getContentPane().add(txtAddress);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAddress.setBounds(309, 155, 134, 30);
        getContentPane().add(lblAddress);
        
        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblContactNumber.setBounds(309, 226, 134, 30);
        getContentPane().add(lblContactNumber);
        
        txtContact = new JTextField();
        txtContact.setColumns(10);
        txtContact.setBounds(309, 256, 487, 30);
        getContentPane().add(txtContact);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 65, 798, 8);
        getContentPane().add(separator);
        
        paneText = new JEditorPane();
        paneText.setBounds(24, 256, 224, 172);
        getContentPane().add(paneText);
        
        JLabel lblDescription = new JLabel("Description");
        lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDescription.setBounds(24, 226, 134, 30);
        getContentPane().add(lblDescription);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(309, 297, 134, 30);
        getContentPane().add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(309, 327, 224, 30);
        getContentPane().add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(572, 297, 134, 30);
        getContentPane().add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setEditable(false);
        txtPassword.setColumns(10);
        txtPassword.setBounds(572, 327, 224, 30);
        getContentPane().add(txtPassword);
        
        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnRegister.setFocusable(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setBounds(676, 31, 120, 28);
        getContentPane().add(btnRegister);
        
        btnGeneratePass = new JButton("Generate Password");
        btnGeneratePass.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnGeneratePass.setFocusable(false);
        btnGeneratePass.setBorderPainted(false);
        btnGeneratePass.setBackground(Color.WHITE);
        btnGeneratePass.setBounds(572, 368, 224, 28);
        getContentPane().add(btnGeneratePass);
        
        dbConn = new DbConnection();
        arr = new ArrayList<>();
        btnRegister.addActionListener(this);
        btnGeneratePass.addActionListener(this);
        
	}
	
    private String passwordGenerator(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }
        
        return sb.toString();
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
		int random = 0;
		
		if(e.getSource() == btnGeneratePass) {
			String password = passwordGenerator(8);
			txtPassword.setText(password);
		}
		
		if(e.getSource() == btnRegister) {
			try {
				st = dbConn.getConnection().createStatement();
				String sql = "SELECT Username FROM tblCustomerAccount";
				st.execute(sql);
				rs = st.getResultSet();
				
				while(rs.next())
					arr.add(rs.getString(1));
				
				if(arr.contains(txtUsername.getText()))
					JOptionPane.showMessageDialog(null, "Username Alaready Exist");
				else if(!txtFN.getText().isEmpty() && !txtLN.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtContact.getText().isEmpty() && !txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
					while(true) {
						random = rand.nextInt(999);
						if(random > 100)
							break;
						else
							continue;
					}
					// tblCustAccount
					String userID = txtUsername.getText() + "#" + random;
					String Username = txtUsername.getText();
					String Password = txtPassword.getText();
					// tblCustAccountInfo
					String LN = txtLN.getText();
					String FN = txtFN.getText();
					String MI = txtMI.getText();
					String Address = txtAddress.getText();
					String Number = txtContact.getText();
					String Description = paneText.getText();
					
					String sqlCustAcc = "INSERT INTO tblcustomeraccount VALUES('" + userID + "','" + Username + "','" + Password + "')";
					String sqlCustAccInfo = "INSERT INTO tblcustomerinformation VALUES('" + userID + "','" + LN + "','" + FN + "','" + MI + "','" + Address + "','" + Number + "','" + Description + "');";
					String sqlOrders = "INSERT INTO tblorders VALUES('" + userID + "', '')";
					
					System.out.println(sqlCustAccInfo);
					
					st.execute(sqlCustAcc);
					st.execute(sqlCustAccInfo);
					st.execute(sqlOrders);
					
				}else {
					JOptionPane.showMessageDialog(null, "Please complete the form");
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
			}


		}
	}
}
