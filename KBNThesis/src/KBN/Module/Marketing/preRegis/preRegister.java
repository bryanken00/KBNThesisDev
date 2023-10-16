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
	public Registration reg;
	private MarketingModule mModule;
	
	
	private Statement st;
	private ResultSet rs;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz1234567890";
	private ArrayList arr;
	private int random;
	private String accountID;
	
	public preRegList preReg;
	
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 263, 425);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		getContentPane().add(scrollPane);
		
		lblTitle = new JLabel("Pre-Registration List");
		lblTitle.setIcon(new ImageIcon(OrderListPanel.class.getResource("/KBN/resources/Marketing/OrderList/Order.png")));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 11, 255, 40);
		getContentPane().add(lblTitle);
		
		preReg = new preRegList();
		scrollPane.setViewportView(preReg);
		
		panel = new JPanel();
		panel.setBounds(276, 0, 834, 497);
		getContentPane().add(panel);
		
		
		// Class
		dbConn = new DbConnection();
		panel.setLayout(null);
		reg = new Registration();
		reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		reg.setBounds(0, 0, 834, 497);
		reg.setBackground(new Color(255, 255, 255));
        arr = new ArrayList<>();
		panel.add(reg);
		
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
				String ID = mModule.regID;
				st = dbConn.getConnection().createStatement();
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
					String accType = reg.cbAccType.getSelectedItem().toString();
					if(!accType.equals("Rebranding"))
						accType = "";
					
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
					
//					String sqlCustAcc = "INSERT INTO tblcustomeraccount VALUES('" + userID + "','" + Username + "','" + Password + "');";
//					String sqlCustAccInfo = "INSERT INTO tblcustomerinformation VALUES('" + userID + "','" + LN + "','" + FN + "','" + MI + "','" + Address + "','" + Number + "','" + Description + "','0','" + Email + "','" + accType +"');";
					String sqlUpdatePreReg = "UPDATE tblpreregistration SET Status = 'Completed' WHERE ID = '" + ID + "';";
//					st.execute(sqlCustAcc);
//					st.execute(sqlCustAccInfo);
					st.execute(sqlUpdatePreReg);
//					st.execute(sqlOrders);
					String FullName = FN + " " + MI + " " + LN;
					String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + accountID + "','KBN Manual Create Account - " + FullName + "');";
					st.execute(AuditTrail);
					JOptionPane.showMessageDialog(null, "Pre-Registration Complete");
				}else {
					JOptionPane.showMessageDialog(null, "Please Complete the form");
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ERROR Register: " + e1.getMessage());
			}
		}
	}
	
	public void setAccountID(String id) {
		this.accountID = id;
	}
	

}
