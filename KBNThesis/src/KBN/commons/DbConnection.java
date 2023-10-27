package KBN.commons;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection {
	private Connection con = null;
	
	//database Local Host
//	private static String url = "jdbc:mysql://localhost:3306/kbndatabase";
//	private static String username = "root";
//	private static String password = "";
	
	// Amazon
	private static String url = "jdbc:mysql://admin.cqkzw4o58odp.ap-southeast-1.rds.amazonaws.com:3306/kbndatabase?useSSL=false";
	private static String username = "admin";
	private static String password = "KENKENken0011";
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			//debugger
			System.out.println("Connected");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error Message: " + e.getMessage());
		}
		return con;
	}

}