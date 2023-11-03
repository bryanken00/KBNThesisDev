package KBN.Module.Marketing.preRegis;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class Registration extends JPanel {
	
	public JTextField txtLN;
	public JTextField txtEmail;
	public JTextField txtAddress;
	public JTextField txtContact;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public JTextField txtFN;
	public JTextField txtMI;
	public JLabel lblWarning;
	public JButton btnRegister;
	public JTextField txtBrand;
	public JButton btnGeneratePass;
	public JComboBox cbAccType;
	
	public Registration() {
		setBounds(0, 0, 834, 487);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(24, 37, 134, 30);
		add(lblNewLabel);
		
		txtLN = new JTextField();
		txtLN.setColumns(10);
		txtLN.setBounds(24, 127, 224, 30);
		add(txtLN);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(24, 97, 134, 30);
		add(lblLastName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(24, 198, 224, 30);
		add(txtEmail);
		
		JLabel lblLastName_1 = new JLabel("");
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName_1.setBounds(24, 168, 134, 30);
		add(lblLastName_1);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(309, 198, 487, 30);
		add(txtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(309, 168, 134, 30);
		add(lblAddress);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber.setBounds(309, 239, 134, 30);
		add(lblContactNumber);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(309, 269, 487, 30);
		add(txtContact);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 798, 8);
		add(separator);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBrand.setBounds(24, 239, 134, 30);
		add(lblBrand);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(24, 310, 134, 30);
		add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(24, 340, 224, 30);
		add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(309, 310, 134, 30);
		add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBounds(309, 340, 224, 30);
		add(txtPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRegister.setFocusable(false);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(676, 39, 120, 28);
		add(btnRegister);
		
		btnGeneratePass = new JButton("Generate Password");
		btnGeneratePass.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnGeneratePass.setFocusable(false);
		btnGeneratePass.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGeneratePass.setBackground(Color.WHITE);
		btnGeneratePass.setBounds(24, 397, 224, 28);
		add(btnGeneratePass);
		
        lblWarning = new JLabel("*Number Only! press number to enable*");
        lblWarning.setForeground(new Color(255, 0, 0));
        lblWarning.setBounds(453, 248, 343, 19);
        lblWarning.setVisible(false);
        add(lblWarning);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(24, 168, 134, 30);
		add(lblEmail);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(309, 97, 134, 30);
		add(lblFirstName);
		
		txtFN = new JTextField();
		txtFN.setColumns(10);
		txtFN.setBounds(309, 127, 224, 30);
		add(txtFN);
		
		txtMI = new JTextField();
		txtMI.setColumns(10);
		txtMI.setBounds(572, 127, 224, 30);
		add(txtMI);
		
		JLabel lblMi = new JLabel("M.I");
		lblMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMi.setBounds(572, 97, 134, 30);
		add(lblMi);
		
		txtBrand = new JTextField();
		txtBrand.setColumns(10);
		txtBrand.setBounds(24, 274, 224, 30);
		add(txtBrand);
		
		JLabel lblAccType = new JLabel("Account Type");
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(572, 310, 134, 30);
		add(lblAccType);
		
		String accType[] = {"KBN","Rebranding"};
		cbAccType = new JComboBox(accType);
		cbAccType.setBounds(572, 340, 224, 30);
		add(cbAccType);
		
		lblAccType.setVisible(false);
		cbAccType.setVisible(false);
	}
}
