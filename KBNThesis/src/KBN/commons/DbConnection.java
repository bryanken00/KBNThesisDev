package KBN.commons;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection {
	private Connection con = null;
	
	//database
//	private static String url = "jdbc:mysql://localhost:3306/kbndatabase";
//	private static String username = "root";
//	private static String password = "";
	
	private static String url = "jdbc:mysql://kbnthesis.c2ezvppz4be9.ap-southeast-1.rds.amazonaws.com:3306/kbndatabase";
//	private static String url = "jdbc:mysql://kbnthesis.c2ezvppz4be9.ap-southeast-1.rds.amazonaws.com:3306/kbndatabase?useSSL=true&requireSSL=true&verifyServerCertificate=true&useLegacyDatetimeCode=false&serverSslCert=/path/to/rds-combined-ca-bundle.pem";
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