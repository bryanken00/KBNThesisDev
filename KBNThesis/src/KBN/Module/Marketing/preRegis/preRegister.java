package KBN.Module.Marketing.preRegis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import KBN.Module.Marketing.OrderingPanel.OrderListPanel;
import KBN.Module.Marketing.OrderingPanel.OrderListPanelData;
import KBN.commons.DbConnection;
import KBN.views.MarketingModule;
import javax.swing.border.LineBorder;

public class preRegister extends JDialog implements ActionListener {
	private JScrollPane scrollPane;
	private JLabel lblTitle;
	private JPanel panel;
	
	private DbConnection dbConn;
	private SendEmail sendMail;
	public Registration reg;
	private MarketingModule mModule;
	
	
	private Statement st;
	private ResultSet rs;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
	private ArrayList arr;
	private int random;
	private String accountID;
	
	public preRegList preReg;
	private JPanel Nav;
	
	public preRegister() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1132, 536);
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		panel = new JPanel();
		panel.setBounds(276, 0, 834, 497);
		getContentPane().add(panel);
		
		
		// Class
		dbConn = new DbConnection();
		sendMail = new SendEmail();
		panel.setLayout(null);
		reg = new Registration();
		reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		reg.setBounds(0, 0, 834, 497);
		reg.setBackground(new Color(255, 255, 255));
        arr = new ArrayList<>();
		panel.add(reg);
		
		Nav = new JPanel();
		Nav.setBorder(new LineBorder(new Color(0, 0, 0)));
		Nav.setBackground(new Color(255, 255, 255));
		Nav.setBounds(0, 0, 277, 497);
		getContentPane().add(Nav);
		Nav.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 72, 263, 425);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		Nav.add(scrollPane);
		
		preReg = new preRegList();
		scrollPane.setViewportView(preReg);
		
		lblTitle = new JLabel("Pre-Registration List");
		lblTitle.setBounds(11, 21, 255, 40);
		Nav.add(lblTitle);
		lblTitle.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/Order.png")));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		Random rand = new Random();
		random = 0;
		while(true) {
			random = rand.nextInt(999);
			if(random > 100)
				break;
			else
				continue;
		}
		
		//default
		settingUpButtons();
	}
	
	private void settingUpButtons() {
		reg.btnGeneratePass.addActionListener(this);
		reg.btnRegister.addActionListener(this);
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
		
		if(e.getSource() == reg.btnGeneratePass) {
			String password = passwordGenerator(8);
			reg.txtPassword.setText(password);
		}
		
		if(e.getSource() == reg.btnRegister) {
			try {
				st = dbConn.getConnection().createStatement();
				//Email checker
		        if (isValidEmail(reg.txtEmail.getText())) {
		        	// Nothing
		        } else {
		        	JOptionPane.showMessageDialog(null, "Invalid Email");
		        	return;
		        }
		        System.out.println(reg.txtContact.getText().charAt(0));
		        System.out.println(reg.txtContact.getText().charAt(1));
		        if(reg.txtContact.getText().charAt(0) != '0' && reg.txtContact.getText().charAt(1) != '9' && reg.txtContact.getText().length() != 11) {
		        	JOptionPane.showMessageDialog(null, "Invalid Contact!");
		        	return;
		        }
		        
		        String SQLEmail = "SELECT Email FROM tblcustomerinformation WHERE Email = '" + reg.txtEmail.getText() + "'";
		        st.execute(SQLEmail);
		        rs = st.getResultSet();
		        int emailVerification = 0;
		        while(rs.next())
		        	emailVerification++;
		        
		        if(emailVerification != 0) {
		        	JOptionPane.showMessageDialog(null, "Email already exist.");
		        	return;
		        }
				
				
				String ID = mModule.regID;
				st.execute("DROP PROCEDURE IF EXISTS `CreateAccountWithRollback`;");
				String sql = "SELECT Username FROM tblcustomeraccount;";
				st.execute(sql);
				rs = st.getResultSet();
				
				while(rs.next())
					arr.add(rs.getString(1));
				
				if(arr.contains(reg.txtUsername.getText())) {
					JOptionPane.showMessageDialog(null, "Username Alaready Exist");
					return;
				}
				
				if(!reg.txtFN.getText().isEmpty() && !reg.txtLN.getText().isEmpty() && !reg.txtAddress.getText().isEmpty() && !reg.txtContact.getText().isEmpty() && !reg.txtUsername.getText().isEmpty() && !reg.txtPassword.getText().isEmpty() && !reg.txtEmail.getText().isEmpty()) {
					// tblCustAccount
//					int ID = getRowID();
					String userID = reg.txtUsername.getText() + "#" + random;
					String Username = reg.txtUsername.getText();
					String Password = reg.txtPassword.getText();
					// tblCustAccountInfo
					String LN = reg.txtLN.getText();
					String FN = reg.txtFN.getText();
					String MI = reg.txtMI.getText();
					String Address = reg.txtAddress.getText();
					String Number = reg.txtContact.getText();
					String Description = reg.txtBrand.getText();
					String Email = reg.txtEmail.getText();
					String accType = "";
					if(Description.equals("KBN") || Description.equals("")) {
						accType = "";
						Description = "";
					}
					else
						accType = "Rebranding";
					
					String createAccount = "CREATE PROCEDURE CreateAccountWithRollback()\r\n"
							+ "BEGIN\r\n"
							+ "  DECLARE EXIT HANDLER FOR SQLEXCEPTION\r\n"
							+ "  BEGIN\r\n"
							+ "    ROLLBACK;\r\n"
							+ "    RESIGNAL;\r\n"
							+ "  END;\r\n"
							+ "\r\n"
							+ "  START TRANSACTION;\r\n"
							+ "  \r\n"
							+ "  INSERT INTO tblcustomeraccount VALUES('" + userID + "','" + Username + "','" + Password + "');\r\n"
							+ "  \r\n"
							+ "  INSERT INTO tblcustomerinformation VALUES('" + userID + "','" + LN + "','" + FN + "','" + MI + "','" + Address + "','" + Number + "','" + Description + "','0','" + Email + "','" + accType +"');\r\n"
							+ "  \r\n"
							+ "  UPDATE tblpreregistration SET Status = 'Completed' WHERE ID = '" + ID + "';\r\n"
							+ "  \r\n"
							+ "  COMMIT;\r\n"
							+ "END;";
					
					st.execute(createAccount);
					st.execute("CALL CreateAccountWithRollback();");
					String sqlUpdatePreReg = "UPDATE tblpreregistration SET Status = 'Completed' WHERE ID = '" + ID + "';";
					st.execute(sqlUpdatePreReg);
					String FullName = FN + " " + MI + " " + LN;
					String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','KBN Manual Create Account - " + FullName + "');";
					st.execute(AuditTrail);
					JOptionPane.showMessageDialog(null, "Pre-Registration Complete");
					sendMail.setDetails(Email, Username, Password);
					sendMail.sendAccountEmail();
				}else {
					JOptionPane.showMessageDialog(null, "Please Complete the form");
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ERROR Register: " + e1.getMessage());
			}
		}
	}
	
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	public void setAccountID(String id) {
		this.accountID = id;
	}
	

}
