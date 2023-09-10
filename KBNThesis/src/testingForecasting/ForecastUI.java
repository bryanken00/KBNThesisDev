package testingForecasting;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class ForecastUI extends JFrame {

	// Class
	private static DbConnection dbConn;
	private static Statement st;
	private static Statement st1;
	private static ResultSet rs;
	private static ResultSet rs1;
	
	private barGenerator barGen;
	
	private JPanel contentPane;

	public ForecastUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Class
		barGen = new barGenerator();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 779, 546);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(barGen);
		
		//Methods
		productCount();
	}
	
	private void productCount() {
		try {
			dbConn = new DbConnection();
			st = dbConn.getConnection().createStatement();
			st1 = dbConn.getConnection().createStatement();
			
			// Count
			String sqlCount = "SELECT COUNT(a.prodName)"
					+ "FROM tblproducts AS a\r\n"
					+ "WHERE a.prodName IN (SELECT b.ProductName FROM tblordercheckoutdata AS b\r\n"
					+ "JOIN tblorderstatus AS c ON c.OrderRefNumber = b.OrderRefNumber\r\n"
					+ "WHERE c.Status = 'Completed')";
			st.execute(sqlCount);
			rs = st.getResultSet();
			while(rs.next()) {
				barGen.setProductCount(rs.getInt(1));
			System.out.println("Count: " + rs.getInt(1));	
			}
			
			String SQL = "SELECT prodName, prodVolume FROM tblproducts\r\n"
					+ "Where prodName IN(\r\n"
					+ "SELECT a.ProductName FROM tblordercheckoutdata AS a\r\n"
					+ "JOIN tblorderstatus as b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
					+ "WHERE b.Status ='Completed');";
			st.execute(SQL);
			rs = st.getResultSet();
			int i = 0;
			while(rs.next()) {
				String name = rs.getString(1);
				String variant = rs.getString(2);
				String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) As total "
						+ "FROM tblordercheckoutdata AS a "
						+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
						+ "WHERE a.ProductName = '" + name +"' AND a.volume = '" + variant + "' AND b.Status = 'Completed';";
				st1.execute(gettingTotalQuantity);
				rs1 = st1.getResultSet();
				while(rs1.next()) {
					if(rs1.getString(1) == null)
						continue;
					else {
						int quantity = rs1.getInt(3);
						barGen.lblProdNameQuantity[i].setText("Product: " + rs.getString(1) + " | Variant: " + rs.getString(2) + " | Count: " + quantity);
						barGen.bar[i].setBounds(10, 35, quantity, 22);
						i++;
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR Cause: " + e.getCause() + "\nMessage: " + e.getMessage());
		}
	}
}
