package KBNAdminPanel.panels.Employee;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class EmployeeCreate extends JPanel {
	
	public JTextField txtLastName;
	public JTextField txtFirstName;
	public JTextField txtMiddleName;
	public JTextField txtContact;
	public JTextField txtAddress;
	public JTextField txtAge;
	public JTextField txtEmailAdd;
	public JTextField txtPassword;
	public JTextField txtConfirmPassword;
	public JTextField txtUsername;
	
	public JButton btnRegister;
	
	public JDateChooser birthDate;
	public JComboBox cbGender;
	public JComboBox cbDepartment;
	public JComboBox cbAccType;
	public JComboBox cbPosition;
	public JButton btnVerify;
	public JLabel iconLabel;
	
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
		
		txtAddress = new JTextField();
		txtAddress.setBounds(22, 261, 295, 31);
		panel.add(txtAddress);
		
		txtAge = new JTextField();
		txtAge.setBounds(598, 261, 87, 31);
		panel.add(txtAge);
		
		txtEmailAdd = new JTextField();
		txtEmailAdd.setBounds(22, 365, 295, 31);
		panel.add(txtEmailAdd);
		
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
		panel.add(birthDate);

		cbDepartment = new JComboBox();
		cbDepartment.setBackground(new Color(255, 255, 255));
		cbDepartment.setBounds(537, 464, 171, 31);
		panel.add(cbDepartment);
		
		String[] accType = {"Admin","Staff","Cashier"}; 
		cbAccType = new JComboBox(accType);
		cbAccType.setBackground(new Color(255, 255, 255));
		cbAccType.setBounds(376, 464, 151, 31);
		panel.add(cbAccType);
		
		cbPosition = new JComboBox();
		cbPosition.setBackground(new Color(255, 255, 255));
		cbPosition.setBounds(728, 464, 231, 31);
		panel.add(cbPosition);
		
		String[] gender = {"Male", "Female"};
		cbGender = new JComboBox(gender);
		cbGender.setBackground(new Color(255, 255, 255));
		cbGender.setBounds(728, 261, 231, 31);
		panel.add(cbGender);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(22, 568, 295, 31);
		panel.add(txtPassword);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(22, 537, 106, 20);
		panel.add(lblNewLabel_4_1);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBounds(376, 568, 332, 31);
		panel.add(txtConfirmPassword);
		
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
		
	}
}
