package KBNAdminPanel.panels.Employee;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class EmployeeCreate extends JPanel {
	
	public JTextField txtLastName;
	public JTextField txtFirstName;
	public JTextField txtMiddleName;
	public JTextField txtContact;
	public JTextField txtAddress;
	public JTextField txtAge;
	public JTextField txtEmailAdd;
	public JPasswordField txtPassword;
	public JPasswordField txtConfirmPassword;
	public JTextField txtUsername;
	
	public JButton btnRegister;
	
	public JDateChooser birthDate;
	public JComboBox cbGender;
	public JComboBox cbDepartment;
	public JComboBox cbAccType;
	public JComboBox cbPosition;
	public JButton btnVerify;
	public JLabel iconLabel;
	public JButton btnShowPassword;
	public JButton btnShowConfirmPassword;
	
	public JLabel dotLastName;
	public JLabel dotFirstName;
	public JLabel dotMiddleName;
	public JLabel dotAddress;
	public JLabel dotBirthdate;
	public JLabel dotAge;
	public JLabel dotEmail;
	public JLabel dotContact;
	public JLabel dotPassword;
	public JLabel dotConfirmPassword;
	
	public AbstractDocument doc;
	public AbstractDocument doc1;
	
	public boolean emailValid;
	
	public EmployeeCreate() {
		setBounds(0, 0, 1009, 721);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 989, 699);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEmployeeList = new JLabel("Employee Account");
		lblEmployeeList.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmployeeList.setBounds(10, 26, 235, 31);
		panel.add(lblEmployeeList);
		
		btnRegister = new JButton("Save");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setOpaque(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setFocusable(false);
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setBounds(856, 26, 103, 31);
		panel.add(btnRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 969, 11);
		panel.add(separator);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(22, 168, 295, 31);
		panel.add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(376, 168, 332, 31);
		panel.add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(728, 168, 231, 31);
		panel.add(txtMiddleName);
		
		txtContact = new JTextField();
		txtContact.setBounds(376, 365, 332, 31);
		panel.add(txtContact);
		
		doc = (AbstractDocument) txtContact.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        // Allow only numeric characters (0-9) to be inserted
		        if (text.matches("[0-9]+")) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }

		    @Override
		    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		        super.remove(fb, offset, length);
		    }
		});
		
		txtAddress = new JTextField();
		txtAddress.setBounds(22, 261, 295, 31);
		panel.add(txtAddress);
		
		txtAge = new JTextField();
		txtAge.setBounds(598, 261, 87, 31);
		panel.add(txtAge);
		
		doc1 = (AbstractDocument) txtAge.getDocument();
		doc1.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        // Allow only numeric characters (0-9) to be inserted
		        if (text.matches("[0-9]+")) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }

		    @Override
		    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		        // Allow removal of text
		        super.remove(fb, offset, length);
		    }
		});
		
		txtEmailAdd = new JTextField();
		txtEmailAdd.setBounds(22, 365, 295, 31);
		panel.add(txtEmailAdd);
		
		txtEmailAdd.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        validateEmail();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        validateEmail();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        // Not used for plain text components
		    }

		    private void validateEmail() {
		        String email = txtEmailAdd.getText();
		        if (isValidEmail(email)) {
		        	dotEmail.setVisible(false);
		        } else {
		        	dotEmail.setVisible(true);
		        }
		    }
		});
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 137, 106, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(376, 137, 106, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Middle Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(728, 137, 106, 20);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_3 = new JLabel("Birthdate");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(376, 230, 106, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(376, 334, 106, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(537, 433, 106, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Account Type");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(376, 433, 106, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 230, 106, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Age");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(598, 230, 87, 20);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(728, 230, 106, 20);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Email Address");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_4.setBounds(22, 334, 106, 20);
		panel.add(lblNewLabel_1_1_4);
		
		birthDate = new JDateChooser();
		birthDate.setBounds(376, 261, 190, 31);
		
		//disable editing
        JTextFieldDateEditor editor = (JTextFieldDateEditor) birthDate.getDateEditor();
        editor.setEditable(false);
        
        //add minimum year
        Calendar minDate = Calendar.getInstance();
        minDate.set(Calendar.YEAR, 1900);
        birthDate.setMinSelectableDate(minDate.getTime());
        
        //add maximum year
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, 2008);
        birthDate.setMaxSelectableDate(maxDate.getTime());
		panel.add(birthDate);

		String[] depAdmin = {"All"};
		cbDepartment = new JComboBox(depAdmin);
		cbDepartment.setBackground(new Color(255, 255, 255));
		cbDepartment.setBounds(537, 464, 171, 31);
		panel.add(cbDepartment);
		
		String[] accType = {"Admin", "Manager","Staff","Cashier"}; 
		cbAccType = new JComboBox(accType);
		cbAccType.setBackground(new Color(255, 255, 255));
		cbAccType.setBounds(376, 464, 151, 31);
		panel.add(cbAccType);

		String[] adminPos = {"All"}; 
		cbPosition = new JComboBox(adminPos);
		cbPosition.setBackground(new Color(255, 255, 255));
		cbPosition.setBounds(728, 464, 231, 31);
		panel.add(cbPosition);
		
		String[] gender = {"Male", "Female"};
		cbGender = new JComboBox(gender);
		cbGender.setBackground(new Color(255, 255, 255));
		cbGender.setBounds(728, 261, 231, 31);
		panel.add(cbGender);
		
		btnShowPassword = new JButton("Show");
		btnShowPassword.setBackground(Color.WHITE);
		btnShowPassword.setBounds(245, 568, 72, 31);
		panel.add(btnShowPassword);
		
		btnShowConfirmPassword = new JButton("Show");
		btnShowConfirmPassword.setBackground(Color.WHITE);
		btnShowConfirmPassword.setBounds(599, 568, 72, 31);
		panel.add(btnShowConfirmPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(22, 568, 225, 31);
		panel.add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(376, 568, 225, 31);
		panel.add(txtConfirmPassword);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(22, 537, 106, 20);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Confirm Password");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(376, 537, 156, 20);
		panel.add(lblNewLabel_4_1_1);
		
		btnVerify = new JButton("Verify");
		btnVerify.setBackground(new Color(255, 255, 255));
		btnVerify.setBounds(245, 464, 73, 31);
		panel.add(btnVerify);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(0, 0, 66, 31);
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(new Color(255, 255, 255));
		
		iconLabel = new JLabel();
		iconLabel.setBounds(76, 0, 24, 31);
		iconLabel.setIcon(new ImageIcon(EmployeeCreate.class.getResource("/KBNAdminPanel/resources/Employee/close.png")));
		labelPanel.setLayout(null);

		labelPanel.add(lblUsername);
		labelPanel.add(iconLabel);
		labelPanel.setBounds(22, 428, 106, 31);
		panel.add(labelPanel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(22, 464, 225, 31);
		panel.add(txtUsername);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Access");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(728, 433, 106, 20);
		panel.add(lblNewLabel_1_1_1_2);
		
		dotLastName = new JLabel("*");
		dotLastName.setForeground(Color.RED);
		dotLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotLastName.setBounds(95, 137, 19, 20);
		panel.add(dotLastName);
		
		dotFirstName = new JLabel("*");
		dotFirstName.setForeground(Color.RED);
		dotFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotFirstName.setBounds(450, 137, 19, 20);
		panel.add(dotFirstName);
		
		dotMiddleName = new JLabel("*");
		dotMiddleName.setForeground(Color.RED);
		dotMiddleName.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotMiddleName.setBounds(815, 137, 19, 20);
		panel.add(dotMiddleName);
		
		dotAddress = new JLabel("*");
		dotAddress.setForeground(Color.RED);
		dotAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotAddress.setBounds(95, 230, 19, 20);
		panel.add(dotAddress);
		
		dotBirthdate = new JLabel("*");
		dotBirthdate.setForeground(Color.RED);
		dotBirthdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotBirthdate.setBounds(450, 230, 19, 20);
		panel.add(dotBirthdate);
		
		dotAge = new JLabel("*");
		dotAge.setForeground(Color.RED);
		dotAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotAge.setBounds(628, 230, 19, 20);
		panel.add(dotAge);
		
		dotEmail = new JLabel("input a valid email");
		dotEmail.setForeground(Color.RED);
		dotEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotEmail.setBounds(115, 334, 202, 20);
		panel.add(dotEmail);
		
		dotContact = new JLabel("*");
		dotContact.setForeground(Color.RED);
		dotContact.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotContact.setBounds(483, 334, 19, 20);
		panel.add(dotContact);
		
		dotPassword = new JLabel("*");
		dotPassword.setForeground(Color.RED);
		dotPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotPassword.setBounds(84, 537, 19, 20);
		panel.add(dotPassword);
		
		dotConfirmPassword = new JLabel("*");
		dotConfirmPassword.setForeground(Color.RED);
		dotConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		dotConfirmPassword.setBounds(494, 537, 19, 20);
		panel.add(dotConfirmPassword);
		
		dotLastName.setVisible(false);
		dotFirstName.setVisible(false);
		dotMiddleName.setVisible(false);
		dotAddress.setVisible(false);
		dotBirthdate.setVisible(false);
		dotAge.setVisible(false);
		dotEmail.setVisible(false);
		dotContact.setVisible(false);
		dotPassword.setVisible(false);
		dotConfirmPassword.setVisible(false);
	}
	
	private boolean isValidEmail(String email) {
	    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	public void setTextfromEdit(String FirstName, String MiddleName, String LastName, String Address, Date birthDate, String Age, String Gender, String Email, String Contact, String username, String AccountType,String Department, String Position, String Password) {
		try {
			txtLastName.setText(LastName);
			txtFirstName.setText(FirstName);
			txtMiddleName.setText(MiddleName);
			
			txtAddress.setText(LastName);
			
			this.birthDate.setDate(birthDate);
			txtAge.setText(Age);
			if(Gender.equals("Male"))
				cbGender.setSelectedIndex(0);
			else
				cbGender.setSelectedIndex(1);
			
			txtEmailAdd.setText(Email);
			txtContact.setText(Contact);
			
			txtUsername.setText(username);
			
			String[] depAdmin = {"Admin", "Staff", "Cashier"};
			DefaultComboBoxModel<String> type = new DefaultComboBoxModel<>(depAdmin);
			cbAccType.setModel(type);
			if(AccountType.equals("Marketing"))
				cbAccType.setSelectedIndex(0);
			if(AccountType.equals("Staff"))
				cbAccType.setSelectedIndex(1);
			if(AccountType.equals("Cashier"))
				cbAccType.setSelectedIndex(2);
			DefaultComboBoxModel<String> dep = new DefaultComboBoxModel<>();
			dep.addElement(Department);
			DefaultComboBoxModel<String> pos = new DefaultComboBoxModel<>();
			pos.addElement(Position);
			txtPassword.setText(Password);
			txtConfirmPassword.setText(Password);
			
		} catch (Exception e) {
		}

	}
}
