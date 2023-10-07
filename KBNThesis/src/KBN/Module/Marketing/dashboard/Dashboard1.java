package KBN.Module.Marketing.dashboard;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Dashboard1 extends JPanel {
	
	private JLabel lblDaily;
	public JScrollPane orderList;
	private JLabel lblWeekly;
	private JLabel lblMonthly;
	private JLabel lblYearly;

	public JPanel panelOrderList;
	public JPanel panelGraph;
	public JLabel lblDailyPercent;
	public JLabel lblWeeklyPercent;
	public JLabel lblMonthlyPercent;
	public JLabel lblYearlyPercent;
	public JScrollPane panelOutofStock;
	public JScrollPane panelSufficentStock;
	public JLabel lblTimeDiff;
	public JTable tableLow;
	public JTable tableMid;
	public DefaultTableModel tLow;
	public DefaultTableModel tMid;
	public DefaultTableModel tHigh;
	
	private JScrollBar verticalScrollbar;
	public JTable tableTopSelling;
	public JTable tableLeastSelling;
	public DefaultTableModel maintableTopSelling;
	public DefaultTableModel maintableLeastSelling;

	public Dashboard1() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(Color.WHITE);
		setBounds(0, 0, 989, 699);
		setLayout(null);
		
		JPanel panelDaily = new JPanel();
		panelDaily.setBackground(Color.WHITE);
		panelDaily.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaily.setBounds(10, 11, 120, 140);
		add(panelDaily);
		panelDaily.setLayout(null);
		
		LineBorder border = new LineBorder(new Color(0, 0, 0), 1, true);
		
		lblDaily = new JLabel("Daily Sales");
		lblDaily.setForeground(Color.WHITE);
		lblDaily.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDaily.setBackground(new Color(206,124,0,255));
		lblDaily.setOpaque(true);
		lblDaily.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaily.setBounds(2, 2, 115, 32);
		panelDaily.add(lblDaily);
		
		lblDailyPercent = new JLabel("");
		lblDailyPercent.setBackground(Color.WHITE);
		lblDailyPercent.setOpaque(true);
		lblDailyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/82.png")));
		lblDailyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyPercent.setBounds(5, 38, 110, 96);
		panelDaily.add(lblDailyPercent);
		
		JPanel panelWeekly = new JPanel();
		panelWeekly.setBackground(Color.WHITE);
		panelWeekly.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelWeekly.setLayout(null);
		panelWeekly.setBounds(140, 11, 120, 140);
		add(panelWeekly);
		
		lblWeekly = new JLabel("Weekly Sales");
		lblWeekly.setForeground(Color.WHITE);
		lblWeekly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWeekly.setBackground(new Color(193,46,0,255));
		lblWeekly.setOpaque(true);
		lblWeekly.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekly.setBounds(2, 2, 115, 32);
		panelWeekly.add(lblWeekly);
		
		lblWeeklyPercent = new JLabel("");
		lblWeeklyPercent.setBackground(Color.WHITE);
		lblWeeklyPercent.setOpaque(true);
		lblWeeklyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/100.png")));
		lblWeeklyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeeklyPercent.setBounds(5, 38, 110, 96);
		panelWeekly.add(lblWeeklyPercent);
		
		JPanel panelMonthly = new JPanel();
		panelMonthly.setBackground(Color.WHITE);
		panelMonthly.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMonthly.setLayout(null);
		panelMonthly.setBounds(10, 157, 120, 140);
		add(panelMonthly);
		
		lblMonthly = new JLabel("Monthly Sales");
		lblMonthly.setForeground(Color.WHITE);
		lblMonthly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMonthly.setBackground(new Color(36,0,255,255));
		lblMonthly.setOpaque(true);
		lblMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthly.setBounds(2, 2, 115, 32);
		panelMonthly.add(lblMonthly);
		
		lblMonthlyPercent = new JLabel("");
		lblMonthlyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/13.png")));
		lblMonthlyPercent.setBackground(Color.WHITE);
		lblMonthlyPercent.setOpaque(true);
		lblMonthlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthlyPercent.setBounds(5, 38, 110, 96);
		panelMonthly.add(lblMonthlyPercent);
		
		JPanel panelYearly = new JPanel();
		panelYearly.setBackground(Color.WHITE);
		panelYearly.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelYearly.setLayout(null);
		panelYearly.setBounds(140, 157, 120, 140);
		add(panelYearly);
		
		lblYearly = new JLabel("Yearly Sales");
		lblYearly.setForeground(Color.WHITE);
		lblYearly.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearly.setBackground(new Color(8,104,0,255));
		lblYearly.setOpaque(true);
		lblYearly.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearly.setBounds(2, 2, 115, 32);
		panelYearly.add(lblYearly);
		
		lblYearlyPercent = new JLabel("");
		lblYearlyPercent.setIcon(new ImageIcon(Dashboard1.class.getResource("/KBN/resources/Marketing/dashboard/PercentagePNG/13.png")));
		lblYearlyPercent.setBackground(Color.WHITE);
		lblYearlyPercent.setOpaque(true);
		lblYearlyPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearlyPercent.setBounds(5, 38, 110, 96);
		panelYearly.add(lblYearlyPercent);
		
		panelGraph = new JPanel();
		panelGraph.setLayout(null);
		panelGraph.setBounds(270, 11, 381, 286);
		add(panelGraph);
		
		panelOrderList = new JPanel();
		panelOrderList.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOrderList.setBackground(Color.WHITE);
		panelOrderList.setBounds(661, 11, 318, 677);
		add(panelOrderList);
		panelOrderList.setLayout(null);
		
		lblTimeDiff = new JLabel("New Order 1 Minute ago");
		lblTimeDiff.setBounds(10, 53, 300, 19);
		panelOrderList.add(lblTimeDiff);
		
		JLabel lblNewLabel = new JLabel("Order List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 119, 40);
		panelOrderList.add(lblNewLabel);
		
		JLabel lblInstruction = new JLabel("");
		lblInstruction.setBounds(280, 46, 32, 32);
		panelOrderList.add(lblInstruction);
		
		orderList = new JScrollPane();
		orderList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		orderList.setBounds(0, 82, 318, 594);
		verticalScrollbar = orderList.getVerticalScrollBar();
        verticalScrollbar.setUI(new CustomScrollBarUI());
		panelOrderList.add(orderList);
		
		JPanel panelStocks = new JPanel();
		panelStocks.setBackground(Color.WHITE);
		panelStocks.setBorder(border);
		panelStocks.setBounds(10, 308, 641, 380);
		add(panelStocks);
		panelStocks.setLayout(null);
		
		JPanel paneOutofStock = new JPanel();
		paneOutofStock.setBounds(435, 192, 196, 180);
		paneOutofStock.setBackground(Color.WHITE);
		paneOutofStock.setBorder(border);
		panelStocks.add(paneOutofStock);
		paneOutofStock.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Currently Unavailable");
		lblNewLabel_1.setBounds(0, 0, 196, 42);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		paneOutofStock.add(lblNewLabel_1);
		
		panelOutofStock = new JScrollPane();
		panelOutofStock.setBorder(border);
		panelOutofStock.setBounds(0, 42, 196, 138);
		verticalScrollbar = panelOutofStock.getVerticalScrollBar();
        verticalScrollbar.setUI(new CustomScrollBarUI());
		paneOutofStock.add(panelOutofStock);
		
		tableLow = new JTable();
		panelOutofStock.setViewportView(tableLow);
		
		JPanel panelSufficient = new JPanel();
		panelSufficient.setBounds(435, 6, 196, 180);
		panelSufficient.setBackground(Color.WHITE);
		panelSufficient.setBorder(border);
		panelStocks.add(panelSufficient);
		panelSufficient.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Running Low");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(0, 0, 196, 42);
		panelSufficient.add(lblNewLabel_1_1);
		
		panelSufficentStock = new JScrollPane();
		panelSufficentStock.setBorder(border);
		panelSufficentStock.setBounds(0, 42, 196, 138);
		verticalScrollbar = panelSufficentStock.getVerticalScrollBar();
        verticalScrollbar.setUI(new CustomScrollBarUI());
		panelSufficient.add(panelSufficentStock);
		
		tableMid = new JTable();
		panelSufficentStock.setViewportView(tableMid);
        verticalScrollbar.setUI(new CustomScrollBarUI());
		
		tLow = new DefaultTableModel(tableLow.getRowCount(), tableLow.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
		tMid = new DefaultTableModel(tableMid.getRowCount(), tableMid.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
        

    	maintableTopSelling = new DefaultTableModel(tableLow.getRowCount(), tableLow.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
    	maintableLeastSelling = new DefaultTableModel(tableLow.getRowCount(), tableLow.getColumnCount()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                return false;
            }
        };
    	
		tableLow.setTableHeader(null);
		tableMid.setTableHeader(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 6, 397, 180);
		panelStocks.add(panel);
		panel.setLayout(null);
		
		JPanel title = new JPanel();
		title.setBackground(new Color(255, 255, 255));
		title.setBorder(new LineBorder(new Color(0, 0, 0)));
		title.setBounds(0, 0, 397, 42);
		panel.add(title);
		title.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Top-Selling Product");
		lblNewLabel_1_1_1.setBounds(0, 0, 397, 42);
		title.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 41, 397, 139);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(scrollPane);
		
		tableTopSelling = new JTable();
		scrollPane.setViewportView(tableTopSelling);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 192, 397, 180);
		panelStocks.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel title2 = new JPanel();
		title2.setBackground(new Color(255, 255, 255));
		title2.setBorder(new LineBorder(new Color(0, 0, 0)));
		title2.setBounds(0, 0, 397, 42);
		panel_1.add(title2);
		title2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Least Popular Product");
		lblNewLabel_1_2.setBounds(0, 0, 397, 42);
		title2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setBounds(0, 41, 397, 139);
		panel_1.add(scrollPane_1);
		
		tableLeastSelling = new JTable();
		scrollPane_1.setViewportView(tableLeastSelling);
		
		table();
	}
	
	private void table() {
		String[] column = {"Materials"};
		tLow.setColumnIdentifiers(column);
		tableLow.setModel(tLow);
		tMid.setColumnIdentifiers(column);
		tableMid.setModel(tMid);
		
        Font cellFont = new Font("Arial", Font.PLAIN, 14);
        tableLow.setFont(cellFont);
        tableMid.setFont(cellFont);
        tableLow.setRowHeight(30);
        tableMid.setRowHeight(30);
        
        //Top and Least
        String [] ColumnTopLeast = {"Product Name", "Sold"};
        maintableTopSelling.setColumnIdentifiers(ColumnTopLeast);
    	maintableLeastSelling.setColumnIdentifiers(ColumnTopLeast);
    	tableTopSelling.setModel(maintableTopSelling);
    	tableLeastSelling.setModel(maintableLeastSelling);
	}
	
	static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            // Set the thumb (scrollbar slider) color
            thumbColor = new Color(192, 192, 192); // Green in this example
            trackColor = Color.white;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }
}
