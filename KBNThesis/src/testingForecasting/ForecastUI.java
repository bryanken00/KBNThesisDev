package testingForecasting;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

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
	
	private ArrayList startedDate;
	private ArrayList endedDate;
	private ArrayList temp;
	private ArrayList HighestThisMonth;
	
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
		
		//Array
		startedDate = new ArrayList<>();
		endedDate = new ArrayList<>();
		temp = new ArrayList<>();
		HighestThisMonth = new ArrayList<>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 779, 546);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(barGen);
		
		//Methods
		getAllMonths();
		productCount();
		
		setMonthlyForecast();
	}
	
	private void getAllMonths() {
        for (Month month : Month.values()) {
            YearMonth yearMonth = YearMonth.of(2023, month);
            LocalDate startDate = yearMonth.atDay(1);
            LocalDate endDate = yearMonth.atEndOfMonth();
            
            startedDate.add(startDate);
            endedDate.add(endDate);
        }
	}
	
	private void getHighestValue() {
		int arrSize = temp.size();
		int highest = Integer.MIN_VALUE;
		int indexOfHighest = -1; // Initialize with an invalid index

		for (int i = 0; i < arrSize; i++) {
		    String[] parts = temp.get(i).toString().split("~");
		    if (parts.length >= 3) {
		        int currentValue = Integer.parseInt(parts[2]);
		        if (currentValue > highest) {
		            highest = currentValue;
		            indexOfHighest = i; // Update the index of the highest value
		        }
		    }
		}

		if (indexOfHighest != -1) {
//		    System.out.println("The highest value is: " + highest);
//		    System.out.println("Index of the highest value: " + indexOfHighest);
		    HighestThisMonth.add(temp.get(indexOfHighest));
		    temp.clear();
		} else {
//		    System.out.println("No valid data found in the ArrayList.");
		}

	}
	
	private void setMonthlyForecast() {
		int arrSize = HighestThisMonth.size();
		barGen.setProductCount(arrSize);
		for(int i = 0; i < arrSize; i++) {
			String[] parts = HighestThisMonth.get(i).toString().split("~");
			barGen.lblProdNameQuantity[i].setText("Product: " + parts[0] + " | Variant: " + parts[1] + " | Count: " + parts[2] + " | Date: " + parts[3] + " - " + parts[4]);
		}
	}
	
	private void productCount() {
		try {
			dbConn = new DbConnection();
			st = dbConn.getConnection().createStatement();
			st1 = dbConn.getConnection().createStatement();
			for(int i = 0; i < startedDate.size(); i++) {
				// Count
				String sqlCount = "SELECT COUNT(a.prodName) FROM tblproducts AS a\r\n"
						+ "WHERE (a.prodName, a.prodVolume) IN (SELECT b.ProductName, b.volume FROM tblordercheckoutdata AS b\r\n"
						+ "JOIN tblorderstatus AS c ON c.OrderRefNumber = b.OrderRefNumber\r\n"
						+ "JOIN tblordercheckout AS d ON d.OrderRefNumber = b.OrderRefNumber\r\n"
						+ "WHERE c.Status = 'Completed' AND d.OrderDate >= '" + startedDate.get(i) + "' AND d.OrderDate <= '" + endedDate.get(i) + "')";
				System.out.println(sqlCount);
				st.execute(sqlCount);
				rs = st.getResultSet();
				while(rs.next()) {
//					barGen.setProductCount(rs.getInt(1));
				}
				
				String SQL = "SELECT prodName, prodVolume FROM tblproducts\r\n"
						+ "Where (prodName, prodVolume) IN(\r\n"
						+ "SELECT a.ProductName, a.volume FROM tblordercheckoutdata AS a\r\n"
						+ "JOIN tblorderstatus as b ON a.OrderRefNumber = b.OrderRefNumber\r\n"
						+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = b.OrderRefNumber\r\n"
						+ "WHERE b.Status ='Completed' AND c.OrderDate >= '" + startedDate.get(i) + "' AND c.OrderDate <= '" + endedDate.get(i) + "');";
//				System.out.println(SQL);
//				System.out.println();
				st.execute(SQL);
				rs = st.getResultSet();
//				int iCount = 0;
				while(rs.next()) {
					String name = rs.getString(1);
					String variant = rs.getString(2);
					String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) As total "
							+ "FROM tblordercheckoutdata AS a "
							+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
							+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = a.OrderRefNumber "
							+ "WHERE a.ProductName = '" + name +"' AND a.volume = '" + variant + "' AND b.Status = 'Completed' AND c.OrderDate >= '" + startedDate.get(i) + "' AND c.OrderDate <= '" + endedDate.get(i) + "';";
					System.out.println(gettingTotalQuantity);
//					System.out.println(gettingTotalQuantity);
					st1.execute(gettingTotalQuantity);
					rs1 = st1.getResultSet();
					while(rs1.next()) {
						if(rs1.getString(1) == null)
							continue;
						else {
//							int quantity = rs1.getInt(3);
//							barGen.lblProdNameQuantity[iCount].setText("Product: " + rs1.getString(1) + " | Variant: " + rs1.getString(2) + " | Count: " + quantity + " | Date: " + startedDate.get(i) + " - " + endedDate.get(i));
//							barGen.bar[iCount].setBounds(10, 35, quantity, 22);
//							iCount++;
							temp.add(rs1.getString(1) + "~" + rs1.getString(2) + "~" + rs1.getInt(3) + "~" + startedDate.get(i) + "~" + endedDate.get(i));
						}
					}
				}
				getHighestValue();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR Cause: " + e.getCause() + "\nMessage: " + e.getMessage());
		}
	}
}
