package KBN.Module.Marketing.preRegis;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;

import KBN.commons.CompositeDocumentFilter;
import KBN.commons.EmailDocumentFilter;
import KBN.commons.NumberOnlyDocumentFilter;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class Registration extends JPanel implements KeyListener, ActionListener{
	
	public JTextField txtLN;
	public JTextField txtEmail;
	public JTextField txtAddress;
	public JTextField txtContact;
	public JTextField txtUsername;
	public JTextField txtPassword;
	public JTextField txtFN;
	public JTextField txtMI;
	public JButton btnRegister;
	public JTextField txtBrand;
	public JButton btnGeneratePass;
	public JComboBox cbAccType;
	private JLabel lblLN;
	private JLabel lblFN;
	private JLabel lblEM;
	private JLabel lblAD;
	private JLabel lblBR;
	private JLabel lblUN;
	private JLabel lblPW;
	private JLabel lblCN;
	
	public Registration() {
		setBounds(0, 0, 834, 487);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setBounds(24, 37, 134, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel);
		
		txtLN = new JTextField();
		txtLN.setBounds(24, 127, 224, 30);
		txtLN.setColumns(10);
		add(txtLN);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(24, 97, 134, 30);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblLastName);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(24, 198, 224, 30);
		txtEmail.setColumns(10);
		add(txtEmail);
		
		JLabel lblLastName_1 = new JLabel("");
		lblLastName_1.setBounds(24, 168, 134, 30);
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblLastName_1);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(309, 198, 487, 30);
		txtAddress.setColumns(10);
		add(txtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(309, 168, 134, 30);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblAddress);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(309, 239, 134, 30);
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblContactNumber);
		
		txtContact = new JTextField();
		txtContact.setBounds(309, 269, 487, 30);
		txtContact.setColumns(10);
		add(txtContact);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 798, 8);
		add(separator);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(24, 239, 134, 30);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblBrand);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 310, 134, 30);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(24, 340, 224, 30);
		txtUsername.setColumns(10);
		add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(309, 310, 134, 30);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(309, 340, 224, 30);
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setFocusable(false);
		add(txtPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(676, 39, 120, 28);
		btnRegister.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnRegister.setFocusable(false);
		btnRegister.setBackground(Color.WHITE);
		add(btnRegister);
		
		btnGeneratePass = new JButton("Generate Password");
		btnGeneratePass.setBounds(24, 397, 224, 28);
		btnGeneratePass.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnGeneratePass.setFocusable(false);
		btnGeneratePass.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGeneratePass.setBackground(Color.WHITE);
		add(btnGeneratePass);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(24, 168, 134, 30);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblEmail);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(309, 97, 134, 30);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblFirstName);
		
		txtFN = new JTextField();
		txtFN.setBounds(309, 127, 224, 30);
		txtFN.setColumns(10);
		add(txtFN);
		
		txtMI = new JTextField();
		txtMI.setBounds(572, 127, 224, 30);
		txtMI.setColumns(10);
		add(txtMI);
		
		JLabel lblMi = new JLabel("M.I");
		lblMi.setBounds(572, 97, 134, 30);
		lblMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblMi);
		
		txtBrand = new JTextField();
		txtBrand.setBounds(24, 274, 224, 30);
		txtBrand.setColumns(10);
		add(txtBrand);
		
		JLabel lblAccType = new JLabel("Account Type");
		lblAccType.setBounds(572, 310, 134, 30);
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblAccType);
		
		String accType[] = {"KBN","Rebranding"};
		cbAccType = new JComboBox(accType);
		cbAccType.setBounds(572, 340, 224, 30);
		add(cbAccType);
		
		lblAccType.setVisible(false);
		cbAccType.setVisible(false);
        
        PlainDocument LN = (PlainDocument) txtLN.getDocument();
        PlainDocument FN = (PlainDocument) txtFN.getDocument();
        PlainDocument MI = (PlainDocument) txtMI.getDocument();
        PlainDocument emailInput = (PlainDocument) txtEmail.getDocument();
        PlainDocument brand = (PlainDocument) txtBrand.getDocument();
        PlainDocument contactNum = (PlainDocument) txtContact.getDocument();
        

        // Create instances of CompositeDocumentFilter
        CompositeDocumentFilter LNFilter = new CompositeDocumentFilter(20);
        CompositeDocumentFilter FNFilter = new CompositeDocumentFilter(20);
        CompositeDocumentFilter MIFilter = new CompositeDocumentFilter(2);
        EmailDocumentFilter emailFilter = new EmailDocumentFilter(64);
        NumberOnlyDocumentFilter numberFiler = new NumberOnlyDocumentFilter(11);
        
        
        LN.setDocumentFilter(LNFilter);
        FN.setDocumentFilter(FNFilter);
        MI.setDocumentFilter(MIFilter);
        emailInput.setDocumentFilter(emailFilter);
        brand.setDocumentFilter(emailFilter);
        contactNum.setDocumentFilter(numberFiler);
        
        txtEmail.addKeyListener(this);
        
        lblLN = new JLabel("*");
        lblLN.setForeground(Color.RED);
        lblLN.setBounds(129, 97, 29, 19);
        add(lblLN);
        
        lblFN = new JLabel("*");
        lblFN.setForeground(Color.RED);
        lblFN.setBounds(414, 97, 29, 19);
        add(lblFN);
        
        lblEM = new JLabel("*");
        lblEM.setForeground(Color.RED);
        lblEM.setBounds(85, 168, 29, 19);
        add(lblEM);
        
        lblAD = new JLabel("*");
        lblAD.setForeground(Color.RED);
        lblAD.setBounds(391, 168, 29, 19);
        add(lblAD);
        
        lblBR = new JLabel("*");
        lblBR.setForeground(Color.RED);
        lblBR.setBounds(85, 239, 29, 19);
        add(lblBR);
        
        lblUN = new JLabel("*");
        lblUN.setForeground(Color.RED);
        lblUN.setBounds(129, 310, 29, 19);
        add(lblUN);
        
        lblPW = new JLabel("*");
        lblPW.setForeground(Color.RED);
        lblPW.setBounds(414, 310, 29, 19);
        add(lblPW);
        
        lblCN = new JLabel("*");
        lblCN.setForeground(Color.RED);
        lblCN.setBounds(453, 239, 29, 19);
        add(lblCN);
        
        btnRegister.addActionListener(this);
        
        requiredLabel();
	}
	
	private void requiredLabel() {
        lblLN.setVisible(false);
        lblFN.setVisible(false);
        lblEM.setVisible(false);
        lblAD.setVisible(false);
        lblBR.setVisible(false);
        lblUN.setVisible(false);
        lblPW.setVisible(false);
        lblCN.setVisible(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(txtEmail.getText().contains("@")) {
			if(e.getKeyChar() == '@') {
				e.consume();
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		requiredLabel();
        
		if(e.getSource() == btnRegister) {
			
			// Last Name
			if(txtLN.getText().isEmpty() || txtLN.getText().isBlank())
		        lblLN.setVisible(true);
			
			// First Name
			if(txtFN.getText().isEmpty() || txtFN.getText().isBlank())
				lblFN.setVisible(true);
			
			// Email
			if(txtEmail.getText().isEmpty() || txtEmail.getText().isBlank())
				lblEM.setVisible(true);
			
			// Address
			if(txtAddress.getText().isEmpty() || txtAddress.getText().isBlank())
				lblAD.setVisible(true);
			
			if(txtBrand.getText().isEmpty() || txtBrand.getText().isBlank())
				lblBR.setVisible(true);
			
			if(txtUsername.getText().isEmpty() || txtUsername.getText().isBlank())
				lblUN.setVisible(true);
			
			if(txtPassword.getText().isEmpty() || txtPassword.getText().isBlank())
				lblPW.setVisible(true);
			
			if(txtContact.getText().isEmpty() || txtContact.getText().isBlank())
				lblCN.setVisible(true);
				
		}
		
	}
}
