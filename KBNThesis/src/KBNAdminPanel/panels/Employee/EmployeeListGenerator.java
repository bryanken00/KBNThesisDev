package KBNAdminPanel.panels.Employee;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class EmployeeListGenerator extends JPanel {

	public JPanel[] panel;
	public JLabel[] lblaccType;
	public JLabel[] lblName;
	public JLabel[] lblDepartment;
	public JLabel[] lblContact;
	public JButton[] btnAction;
	public JSeparator[] separator;
	
	public String[] accountID;
	
	
	private int EmpCount = 0;
	
//	private JLabel lblaccType;
//	private JLabel lblName;
//	private JLabel lblDepartment;
//	private JLabel lblContact;
//	private JButton btnAction;
//	private JSeparator separator;
//	private JPanel panel;
	
//	private JPanel panel_1;
//	private JLabel lblaccType_1;
//	private JLabel lblName_1;
//	private JLabel lblDepartment_1;
//	private JLabel lblContact_1;
//	private JButton btnAction_1;
//	private JSeparator separator_1;

	public EmployeeListGenerator() {
		setBounds(0, 66, 967, 258);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
//		panel = new JPanel();
//		panel.setBounds(0, 1, 967, 77);
//		panel.setLayout(null);
//		add(panel);
//		
//		lblaccType = new JLabel("Admin");
//		lblaccType.setBounds(81, 10, 167, 46);
//		lblaccType.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panel.add(lblaccType);
//		
//		lblName = new JLabel("Name");
//		lblName.setBounds(267, 10, 158, 46);
//		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panel.add(lblName);
//		
//		lblDepartment = new JLabel("Name");
//		lblDepartment.setBounds(444, 10, 158, 46);
//		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panel.add(lblDepartment);
//		
//		lblContact = new JLabel("Contact");
//		lblContact.setBounds(628, 10, 158, 46);
//		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panel.add(lblContact);
//		
//		btnAction = new JButton(".");
//		btnAction.setBounds(802, 11, 37, 45);
//		btnAction.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		btnAction.setFocusable(false);
//		btnAction.setBorderPainted(false);
//		btnAction.setBackground(Color.WHITE);
//		panel.add(btnAction);
//		
//		separator = new JSeparator();
//		separator.setBounds(10, 65, 947, 7);
//		panel.add(separator);
//		
//		panel_1 = new JPanel();
//		panel_1.setLayout(null);
//		panel_1.setBounds(0, 78, 967, 77);
//		add(panel_1);
//		
//		lblaccType_1 = new JLabel("Admin");
//		lblaccType_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblaccType_1.setBounds(81, 10, 167, 46);
//		panel_1.add(lblaccType_1);
//		
//		lblName_1 = new JLabel("Name");
//		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblName_1.setBounds(267, 10, 158, 46);
//		panel_1.add(lblName_1);
//		
//		lblDepartment_1 = new JLabel("Name");
//		lblDepartment_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblDepartment_1.setBounds(444, 10, 158, 46);
//		panel_1.add(lblDepartment_1);
//		
//		lblContact_1 = new JLabel("Contact");
//		lblContact_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblContact_1.setBounds(628, 10, 158, 46);
//		panel_1.add(lblContact_1);
//		
//		btnAction_1 = new JButton("Edit");
//		btnAction_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		btnAction_1.setFocusable(false);
//		btnAction_1.setBorderPainted(false);
//		btnAction_1.setBackground(Color.WHITE);
//		btnAction_1.setBounds(802, 11, 65, 45);
//		add(btnAction_1);
//		
//		separator_1 = new JSeparator();
//		separator_1.setBounds(10, 65, 947, 7);
//		panel_1.add(separator_1);
	}
	
	public void setEmpCount(int count) {
		EmpCount = count;
		this.setPreferredSize(new Dimension(2, 77*this.EmpCount));
		panel = new JPanel[EmpCount];
		lblaccType = new JLabel[EmpCount];
		lblName = new JLabel[EmpCount];
		lblDepartment = new JLabel[EmpCount];
		lblContact = new JLabel[EmpCount];
		btnAction = new JButton[EmpCount];
		separator = new JSeparator[EmpCount];
		
		accountID = new String[EmpCount];
		
		GenerateEmployee();
	}
	
	private void GenerateEmployee() {
		int x = 1;
		for(int i = 0; i < EmpCount; i++) {
			if(i != 0)
				x += 77;
			panel[i] = new JPanel();
			panel[i].setBounds(0, x, 967, 77);
			panel[i].setBackground(new Color(255, 255, 255));
			panel[i].setLayout(null);
			add(panel[i]);
			
			lblaccType[i] = new JLabel("Admin");
			lblaccType[i].setBounds(81, 10, 167, 46);
			lblaccType[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel[i].add(lblaccType[i]);
			
			lblName[i] = new JLabel("Name");
			lblName[i].setBounds(267, 10, 158, 46);
			lblName[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel[i].add(lblName[i]);
			
			lblDepartment[i] = new JLabel("Name");
			lblDepartment[i].setBounds(444, 10, 158, 46);
			lblDepartment[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel[i].add(lblDepartment[i]);
			
			lblContact[i] = new JLabel("Contact");
			lblContact[i].setBounds(628, 10, 158, 46);
			lblContact[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
			panel[i].add(lblContact[i]);
			
			btnAction[i] = new JButton("Edit");
			btnAction[i].setBounds(802, 11, 65, 45);
			btnAction[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
//			btnAction[i].setIcon(new ImageIcon(EmployeeListGenerator.class.getResource("/KBNAdminPanel/resources/Employee/dots.png")));
			btnAction[i].setFocusable(false);
//			btnAction[i].setBorderPainted(false);
			btnAction[i].setBackground(Color.WHITE);
			btnAction[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panel[i].add(btnAction[i]);
			
			separator[i] = new JSeparator();
			separator[i].setBounds(10, 65, 947, 7);
			separator[i].setForeground(Color.BLACK);
			panel[i].add(separator[i]);
		}
	}
}
