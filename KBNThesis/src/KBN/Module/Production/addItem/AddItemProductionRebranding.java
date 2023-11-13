package KBN.Module.Production.addItem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;

import KBN.commons.CompositeDocumentFilter;
import KBN.commons.DbConnection;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class AddItemProductionRebranding extends JDialog {
	
	private DbConnection dbConn;
	private ResultSet rs;
	private Statement st;
	public JComboBox cbVariant;
	public JTextField txtQuantity;
	public JButton btnAddItem;
	
	public String checker = "Not-Verified";
	public JCheckBox closeChecker;
	
	public String btnChecker;
	public JComboBox cbClientName;
	public JComboBox cbProductName;
	private JPanel panel_3;
	
	public ArrayList<String> userID;
	
	public AddItemProductionRebranding() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 483, 563);
		getContentPane().setLayout(null);
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
        

		dbConn = new DbConnection();
		
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JPanel container = new JPanel();
		container.setBackground(new Color(255, 255, 255));
		container.setBorder(new LineBorder(new Color(0, 0, 0)));
		container.setBounds(10, 11, 447, 502);
		getContentPane().add(container);
		container.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Item");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 196, 49);
		container.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 427, 1);
		container.add(separator);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setForeground(new Color(255, 255, 255));
		btnAddItem.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnAddItem.setFocusable(false);
		btnAddItem.setBorder(new LineBorder(new Color(8, 104, 0), 1, true));
		btnAddItem.setBackground(new Color(8, 104, 0));
		btnAddItem.setBounds(268, 25, 117, 29);
		container.add(btnAddItem);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 170, 427, 88);
		container.add(panel);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(new Color(8, 104, 0));
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblProductName.setBounds(19, 11, 157, 29);
		panel.add(lblProductName);
		
		cbProductName = new JComboBox();
		cbProductName.setBounds(19, 51, 388, 29);
		panel.add(cbProductName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 269, 427, 88);
		container.add(panel_1);
		
		JLabel lblVariant = new JLabel("Variant");
		lblVariant.setForeground(new Color(8, 104, 0));
		lblVariant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVariant.setBounds(19, 11, 157, 29);
		panel_1.add(lblVariant);
		
		cbVariant = new JComboBox();
		cbVariant.setBounds(19, 51, 388, 29);
		panel_1.add(cbVariant);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 368, 427, 88);
		container.add(panel_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(8, 104, 0));
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQuantity.setBounds(19, 11, 157, 29);
		panel_2.add(lblQuantity);
		
		txtQuantity = new JTextField("1");
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(19, 51, 388, 29);
		txtQuantity.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        String text = txtQuantity.getText();
		        
		        if(!text.equals("")) {
			        if (text.charAt(0) == '0') {
			            e.consume();
			        }
		        }
		        else if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		panel_2.add(txtQuantity);
		
		closeChecker = new JCheckBox("Close after Add?");
		closeChecker.setBackground(new Color(255, 255, 255));
		closeChecker.setBounds(268, 467, 169, 23);
		closeChecker.setFocusable(false);
		closeChecker.setBorder(new LineBorder(new Color(8, 104, 0), 1, true));
		container.add(closeChecker);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 71, 427, 88);
		container.add(panel_3);
		
		JLabel lblClientName = new JLabel("Client Name");
		lblClientName.setForeground(new Color(8, 104, 0));
		lblClientName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblClientName.setBounds(19, 11, 157, 29);
		panel_3.add(lblClientName);

		cbClientName = new JComboBox();
		cbClientName.setBounds(10, 51, 388, 29);
		panel_3.add(cbClientName);
		
		userID = new ArrayList<>();
		
		PlainDocument QuantityPlainDocu = (PlainDocument) txtQuantity.getDocument();
		
		CompositeDocumentFilter QuantityFilter = new CompositeDocumentFilter(20);
		
		QuantityPlainDocu.setDocumentFilter(QuantityFilter);
	}
	
	public void getClientName() {
		try {
			cbClientName.removeAllItems();
	        userID.clear();
			String SQL = "SELECT UserID, CONCAT(FirstName, ' ', Lastname) AS FullName FROM tblcustomerinformation WHERE AccountType = 'rebranding'";
			st.execute(SQL);
			rs = st.getResultSet();
			ArrayList<String> temp = new ArrayList<>();
	        cbClientName.removeAll();
			while(rs.next()) {
				userID.add(rs.getString(1));
				cbClientName.addItem(rs.getString(1) + " - " + rs.getString(2));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error getClientName: " + e.getMessage());
		}
	}
}
