package KBNAdminPanel.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBNAdminPanel.commons.DbConnection;
import KBNAdminPanel.commons.dataSetter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class KBNMainFrame extends JFrame implements ActionListener, MouseListener, KeyListener{

	//Class
	public dataSetter dataSet;
	private DbConnection dbCon;
	
	private Statement st;
	private ResultSet rs;
	private int logSuccess = 0;
	
	private String accLevel;
	private String accID;
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogIn;
	private JLabel lblPicture;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	

	public KBNMainFrame() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(217, 217, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Page");

		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		lblPicture = new JLabel("");
		lblPicture.setIcon(new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/banner.png")));
		lblPicture.setBounds(378, 0, 506, 511);
		contentPane.add(lblPicture);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/logo.png")));
		lblNewLabel.setBounds(107, 39, 165, 92);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(217, 217, 217));
		panel.setBounds(39, 142, 301, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 25));
		lblNewLabel_1.setBounds(30, 11, 128, 56);
		panel.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setText("admin");
//		txtUsername.setBounds(22, 111, 256, 30);
		txtUsername.addKeyListener(this);
		txtUsername.setBorder(null);
//		panel.add(txtUsername);
		
		JLabel label = new JLabel( new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/txtfieldBG.png")));
		label.setBounds(22, 136, 256, 30);
		label.setLayout(new BorderLayout());
		txtUsername.setOpaque(false);
		panel.add(label);
		label.add(txtUsername);
		
		txtPassword = new JPasswordField("admin");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBackground(SystemColor.activeCaptionBorder);
//		txtPassword.setBounds(22, 173, 256, 30);
		txtPassword.setOpaque(false);
		txtPassword.addKeyListener(this);
		txtPassword.setBorder(null);
//		panel.add(txtPassword);
		
		JLabel label1 = new JLabel( new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/txtfieldBG.png")));
		label1.setBounds(22, 173, 256, 30);
		panel.add(label1);
		label1.setLayout(new BorderLayout());
		label1.add(txtPassword);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setIcon(new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/LoginbtnBG.png")));
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.addActionListener(this);
		btnLogIn.addMouseListener(this);
		btnLogIn.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		btnLogIn.setBounds(71, 247, 159, 43);
		btnLogIn.setBorderPainted(false);
		btnLogIn.setFocusable(false);
		btnLogIn.setOpaque(false);
		btnLogIn.setHorizontalTextPosition(JLabel.CENTER);
		btnLogIn.setVerticalTextPosition(JLabel.CENTER);
		panel.add(btnLogIn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(KBNMainFrame.class.getResource("/KBN/resources/login/LoginPanelBG.png")));
		lblNewLabel_2.setBounds(0, 0, 301, 326);
		panel.add(lblNewLabel_2);
		

		
		//methods
		dbSetup();
	}
	
	
	private void dbSetup() {
		try {
			dbCon = new DbConnection();
			st = dbCon.getConnection().createStatement();
		}catch(Exception e1) {}
	}
	
	private void loginChecker() {
		
		//Check if user and password are match
		try {
			String user = txtUsername.getText();
			String pass = txtPassword.getText();
			String sql = "SELECT * FROM tblaccount WHERE username = '" + user + "' AND " + "password = '" + pass + "' AND accType = 'superadmin';";
			//debugger
//			System.out.println(sql);
			st.execute(sql);
			rs = st.getResultSet();
			while(rs.next()) {
				logSuccess += 1;
				accID = rs.getString(1);
				accLevel = rs.getString(4) + "-" + rs.getString(5) + "-" + rs.getString(6);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void btnLoginSetup() {
		dataSet = new dataSetter();
		loginChecker();
		if(logSuccess == 1) {
			dataSet.setUsername(txtUsername.getText());
			dataSet.setAccLevel(accLevel);
			dataSet.setAccountID(accID);
			AdminPanel admin = new AdminPanel();
			admin.setVisible(true);
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "<html>No Access<br/>Incorrect Password</html>");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogIn) {
			btnLoginSetup();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		btnLogIn.setBackground(Color.green);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btnLogIn.setBackground(Color.white);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		/*debugger
		System.out.println(e.getKeyCode());*/
		
		if(e.getKeyCode() == 10) {
			btnLoginSetup();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
