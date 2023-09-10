package testingForecasting;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class forecasting {
	
	// Class
	private static DbConnection dbConn;
	private static Statement st;
	private static Statement st1;
	private static ResultSet rs;
	private static ResultSet rs1;
	
	public static void main(String[] args) {
		try {
			dbConn = new DbConnection();
			st = dbConn.getConnection().createStatement();
			st1 = dbConn.getConnection().createStatement();
			String SQL = "SELECT prodName, prodVolume FROM tblproducts;";
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				String name = rs.getString(1);
				String variant = rs.getString(2);
				String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) "
						+ "FROM tblordercheckoutdata AS a "
						+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
						+ "WHERE a.ProductName = '" + name +"' AND a.volume = '" + variant + "' AND b.Status = 'Completed';";
				st1.execute(gettingTotalQuantity);
				rs1 = st1.getResultSet();
				while(rs1.next()) {
					if(rs1.getString(1) == null)
						continue;
					else {
//						System.out.println(gettingTotalQuantity);
						System.out.println(i);
						System.out.println("Product Name: " + rs1.getString(1));
						System.out.println("Variant : " + rs1.getString(2));
						System.out.println("Total Sold: " + rs1.getString(3));
						System.out.println();
						i++;
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR Cause: " + e.getCause() + "\nMessage: " + e.getMessage());
		}
	}

}
