package KBNAdminPanel.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.views.MarketingModule;
import KBNAdminPanel.commons.DbConnection;
import KBNAdminPanel.panels.Navs;
import KBNAdminPanel.panels.SalesReportPanel;
import KBNAdminPanel.panels.Forecast.ForecastGraphs;
import KBNAdminPanel.panels.Forecast.ForecastingPanel;
import KBNAdminPanel.panels.Forecast.barGen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminPanel extends JFrame implements ActionListener, MouseListener, ItemListener{
	
	//Class
	private Navs navs;
	private SalesReportPanel salesPanel;
	
	//Forecast Class
	private ForecastingPanel forecast;
	private ForecastGraphs forecastgraph;
	private barGen bar1;
	private barGen bar2;
	
	private JButton btnChecker;
	
	//Database
	private DbConnection dbConn;
	private ResultSet rs;
	private Statement st;
	
	//Array
	private ArrayList products;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel container;

	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);

		
        // Class
        navs = new Navs();
        salesPanel = new SalesReportPanel();
        
        // Forecast
        forecast = new ForecastingPanel();
        forecastgraph = new ForecastGraphs();
        bar1 = new barGen();
        bar2 = new barGen();
        
        // Database
        dbConn = new DbConnection();
        try {
			st = dbConn.getConnection().createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(navs, "ERROR Statement: " + e.getMessage());
		}
        
        // Array
        products = new ArrayList<>();
        
        // Components
		components();
		
        actList();
        
		panel.add(navs);
		
		panelVisible();
		salesPanel.setVisible(true);
		container.add(salesPanel);
		container.add(forecast);
		forecast.graph.add(forecastgraph);
		forecastgraph.graph1.add(bar1);
		forecastgraph.graph2.add(bar2);
		
		btnChecker = navs.btnSalesReport;
	}
	
	private void panelVisible() {
		salesPanel.setVisible(false);
		forecast.setVisible(false);
	}
	
	private void actList() {
		navs.btnSalesReport.addActionListener(this);
		navs.btnAudit.addActionListener(this);
		navs.btnForecasting.addActionListener(this);
		navs.btnEmployeeList.addActionListener(this);
		
		//Mouse
		navs.btnSalesReport.addMouseListener(this);
		navs.btnAudit.addMouseListener(this);
		navs.btnForecasting.addMouseListener(this);
		navs.btnEmployeeList.addMouseListener(this);
		
		
		//Forecast
		forecast.product1.addItemListener(this);
		forecast.product2.addItemListener(this);
		forecast.product3.addItemListener(this);
		forecast.product4.addItemListener(this);
		forecast.product5.addItemListener(this);
	}
	
	private void components() {
		panel = new JPanel();
		panel.setBounds(0, 0, 255, 721);
		contentPane.add(panel);
		panel.setLayout(null);
		
		container = new JPanel();
		container.setBounds(255, 0, 1009, 721);
		contentPane.add(container);
		container.setLayout(null);
	}
	
	private void renderingKBNProducts() {
		try {
			forecast.product1.addItem("None");
			forecast.product2.addItem("None");
			forecast.product3.addItem("None");
			forecast.product4.addItem("None");
			forecast.product5.addItem("None");
			
			String SQL = "SELECT prodName, prodVolume FROM tblproducts";
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next())
				products.add(rs.getString(1) + "-" + rs.getString(2));
			
			for(int i = 0; i < products.size(); i++) {
				forecast.product1.addItem(products.get(i));
				forecast.product2.addItem(products.get(i));
				forecast.product3.addItem(products.get(i));
				forecast.product4.addItem(products.get(i));
				forecast.product5.addItem(products.get(i));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(navs, "Error ProductsRendering: " + e.getMessage());
		}
	}
	
	private void getSoldQuantityPresent(String itemName) {
		try {
			int quantity = 0;
			String prodName = itemName.split("-")[0];
			String prodVariant = itemName.split("-")[1];
			int barNumber = Integer.parseInt(itemName.split("-")[2]);
			String gettingTotalQuantity = "SELECT a.ProductName, a.volume, SUM(a.Quantity) As total "
					+ "FROM tblordercheckoutdata AS a "
					+ "JOIN tblorderstatus AS b ON b.OrderRefNumber = a.OrderRefNumber "
					+ "JOIN tblordercheckout AS c ON c.OrderRefNumber = a.OrderRefNumber "
					+ "WHERE a.ProductName = '" + prodName +"' AND a.volume = '" + prodVariant + "' AND b.Status = 'Completed';";
			
			st.execute(gettingTotalQuantity);
			rs = st.getResultSet();
			while(rs.next()) {
				if(rs.getString(3) == null)
					quantity = 0;
				else
					quantity = rs.getInt(3);
			}
			
			if(barNumber == 1) {
				bar1.bar1.setBounds(18, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 2) {
				bar1.bar2.setBounds(80, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 3) {
				bar1.bar3.setBounds(142, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 4) {
				bar1.bar4.setBounds(204, 508 - quantity, 44, 0 + quantity);
			} else if(barNumber == 5) {
				bar1.bar5.setBounds(266, 508 - quantity, 44, 0 + quantity);
			}else {
				return;
			}
			quantity = 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error getSoldQuantityPresent: " + e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == navs.btnSalesReport) {
			panelVisible();
			salesPanel.setVisible(true);
		}
		if(e.getSource() == navs.btnForecasting) {
			panelVisible();
			forecast.setVisible(true);
			renderingKBNProducts();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getComponent() instanceof JButton) {
			
			navs.btnSalesReport.setIcon(null);
			navs.btnAudit.setIcon(null);
			navs.btnForecasting.setIcon(null);
			navs.btnEmployeeList.setIcon(null);
			
			Component c = e.getComponent();
			btnChecker = (JButton) e.getComponent();
			if(btnChecker == c)
				((JButton)c).setIcon(new ImageIcon(MarketingModule.class.getResource("/KBN/resources/Marketing/marketingButton.png")));
			
		}else
			return;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
	    	
	        if (e.getSource() == forecast.product1) {
	        	if(forecast.product1.getSelectedItem().equals("None")) {
	        		bar1.bar1.setVisible(false);
	        		bar2.bar1.setVisible(false);
	        	}else {
	        		bar1.bar1.setVisible(true);
	        		bar2.bar1.setVisible(true);
	        		getSoldQuantityPresent(forecast.product1.getSelectedItem() + "-1");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product2) {
	        	if(forecast.product2.getSelectedItem().equals("None")) {
	        		bar1.bar2.setVisible(false);
	        		bar2.bar2.setVisible(false);
	        	}else {
	        		bar1.bar2.setVisible(true);
	        		bar2.bar2.setVisible(true);
	        		getSoldQuantityPresent(forecast.product2.getSelectedItem() + "-2");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product3) {
	        	if(forecast.product3.getSelectedItem().equals("None")) {
	        		bar1.bar3.setVisible(false);
	        		bar2.bar3.setVisible(false);
	        	}else {
	        		bar1.bar3.setVisible(true);
	        		bar2.bar3.setVisible(true);
	        		getSoldQuantityPresent(forecast.product3.getSelectedItem() + "-3");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product4) {
	        	if(forecast.product4.getSelectedItem().equals("None")) {
	        		bar1.bar4.setVisible(false);
	        		bar2.bar4.setVisible(false);
	        	}else {
	        		bar1.bar4.setVisible(true);
	        		bar2.bar4.setVisible(true);
	        		getSoldQuantityPresent(forecast.product4.getSelectedItem() + "-4");
	        	}
	        }
	        
	        if (e.getSource() == forecast.product5) {
	        	if(forecast.product5.getSelectedItem().equals("None")) {
	        		bar1.bar5.setVisible(false);
	        		bar2.bar5.setVisible(false);
	        	}else {
	        		bar1.bar5.setVisible(true);
	        		bar2.bar5.setVisible(true);
	        		getSoldQuantityPresent(forecast.product5.getSelectedItem() + "-5");
	        	}
	        }
	    }
	}
}
