package KBNAdminPanel.panels.Employee;

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

public class EmployeeCreate extends JPanel {
	
	public JTextField txtLastName;
	public JTextField txtFirstName;
	public JTextField txtMiddleName;
	public JTextField txtContact;
	public JTextField txtAddress;
	public JTextField txtAge;
	public JTextField txtEmailAdd;
	public JButton btnRegister;
	
	public JDateChooser birthDate;
	public JComboBox cbGender;
	public JComboBox cbDepartment;
	public JComboBox cbAccType;

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
		txtLastName.setBounds(22, 168, 332, 31);
		panel.add(txtLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(376, 168, 332, 31);
		panel.add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(728, 168, 231, 31);
		panel.add(txtMiddleName);
		
		txtContact = new JTextField();
		txtContact.setBounds(22, 464, 332, 31);
		panel.add(txtContact);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(556, 261, 403, 31);
		panel.add(txtAddress);
		
		txtAge = new JTextField();
		txtAge.setBounds(267, 360, 87, 31);
		panel.add(txtAge);
		
		txtEmailAdd = new JTextField();
		txtEmailAdd.setBounds(664, 360, 295, 31);
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
		lblNewLabel_3.setBounds(22, 329, 106, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(22, 433, 106, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(22, 230, 106, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Account Type");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(292, 230, 106, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(556, 230, 106, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Age");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(267, 329, 87, 20);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Gender");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(425, 329, 106, 20);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Email Address");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_4.setBounds(664, 329, 106, 20);
		panel.add(lblNewLabel_1_1_4);
		
		birthDate = new JDateChooser();
		birthDate.setBounds(22, 360, 190, 31);
		panel.add(birthDate);
		
		cbDepartment = new JComboBox();
		cbDepartment.setBounds(22, 261, 235, 31);
		panel.add(cbDepartment);
		
		cbAccType = new JComboBox();
		cbAccType.setBounds(292, 261, 190, 31);
		panel.add(cbAccType);
		
		String [] gender = {"Male", "Female"};
		cbGender = new JComboBox(gender);
		cbGender.setBounds(425, 360, 151, 31);
		panel.add(cbGender);
		
	}
}
