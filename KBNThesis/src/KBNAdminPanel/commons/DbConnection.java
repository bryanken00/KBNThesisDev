package KBNAdminPanel.commons;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection {
	private Connection con = null;
	
	//database
//	private static String url = "jdbc:mysql://localhost:3306/kbndatabase";
//	private static String username = "root";
//	private static String password = "";
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/kbndatabase";
	private static String username = "root";
	private static String password = "KENKENken0011@";
	
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