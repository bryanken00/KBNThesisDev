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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CustomerCreateAccount extends JDialog {
	private JTextField txtUsername;
	private JButton btnCreateAccount;
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	private ArrayList arr;
	
	
	//password
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
	private JTextField txtYourPassword;
	
	public CustomerCreateAccount() {
		setResizable(false);
		setBounds(100, 100, 418, 206);
		this.setModal(true);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        getContentPane().setLayout(null);
        
        dbConn = new DbConnection();
        
        
        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 11, 112, 28);
        getContentPane().add(lblNewLabel);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(132, 17, 211, 22);
        getContentPane().add(txtUsername);
        txtUsername.setColumns(10);
        
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			arr = new ArrayList<>();
        			st = dbConn.getConnection().createStatement();
        			String sql = "SELECT Username FROM tblCustomerAccount";
        			st.execute(sql);
        			rs = st.getResultSet();

        			while(rs.next())
        				arr.add(rs.getString(1));
        			
        			if(arr.contains(txtUsername.getText())) {
        				JOptionPane.showMessageDialog(null, "Account already exist.");
        			}else {
            			Random rand = new Random();
            			int random;
            			while(true) {
            				random = rand.nextInt(999);
            				if(random > 100) {
            					break;
            				}else {
            					continue;
            				}
            			}
            			String userID = txtUsername.getText() + "#" + random;
            			String password = passwordGenerator(8);
            			sql = "INSERT INTO tblCustomerAccount VALUES('" + userID + "','" + txtUsername.getText() + "','" + password + "');";
            			st.execute(sql);
            			sql = "INSERT INTO tblOrders VALUES('" + userID + "', '')";
            			st.execute(sql);
            			
            			txtYourPassword.setText(txtYourPassword.getText() + password);
        			}
        			

        			
        		}catch (Exception e1) {
        			JOptionPane.showMessageDialog(null, "ERROR CREATE ACCOUNT: " + e1.getMessage());
				}
        		
        	}
        });
        btnCreateAccount.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
        btnCreateAccount.setFocusable(false);
        btnCreateAccount.setBorderPainted(false);
        btnCreateAccount.setBackground(Color.WHITE);
        btnCreateAccount.setBounds(132, 50, 211, 44);
        getContentPane().add(btnCreateAccount);
        
        txtYourPassword = new JTextField();
        txtYourPassword.setText("Your password:");
        txtYourPassword.setEditable(false);
        txtYourPassword.setBounds(10, 102, 382, 54);
        getContentPane().add(txtYourPassword);
        txtYourPassword.setColumns(10);
        
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
}
