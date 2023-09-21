package KBN.Module.Marketing.KBNProducts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KBN.commons.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ProductDetails extends JDialog {
	
	public JTextField txtProdName;
	public JTextField txtPrice;
	public JTextField txtVariant;
	public JTextField txtDescription;
	public JTextField txtIngredients;
	public JTextField txtManual;
	public JLabel lblImg;
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	
	private String prodID = "";
	private JTextField txtCategory;
	
	public void ProductDetails(String prodID) {
		this.prodID = prodID;
		DataSetters();
	}

	public ProductDetails() {
		setResizable(false);
		setBounds(100, 100, 842, 554);
		setModal(true);
		getContentPane().setLayout(null);
		
		dbConn = new DbConnection();
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(10, 11, 310, 493);
		getContentPane().add(lblImg);
		
		JLabel lblNewLabel_1 = new JLabel("Product:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(330, 23, 140, 28);
		getContentPane().add(lblNewLabel_1);
		
		txtProdName = new JTextField();
		txtProdName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProdName.setBounds(518, 23, 286, 28);
		getContentPane().add(txtProdName);
		txtProdName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(330, 83, 140, 28);
		getContentPane().add(lblNewLabel_1_1);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPrice.setColumns(10);
		txtPrice.setBounds(518, 83, 286, 28);
		getContentPane().add(txtPrice);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Variant:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(330, 143, 140, 28);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtVariant = new JTextField();
		txtVariant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVariant.setColumns(10);
		txtVariant.setBounds(518, 143, 286, 28);
		getContentPane().add(txtVariant);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(330, 203, 140, 28);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Description:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(330, 263, 140, 28);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescription.setBounds(518, 263, 286, 28);
		getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Ingredients:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(330, 353, 140, 28);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		txtIngredients = new JTextField();
		txtIngredients.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIngredients.setColumns(10);
		txtIngredients.setBounds(518, 353, 286, 28);
		getContentPane().add(txtIngredients);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Manual:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(330, 443, 140, 28);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1);
		
		txtManual = new JTextField();
		txtManual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtManual.setColumns(10);
		txtManual.setBounds(518, 443, 286, 28);
		getContentPane().add(txtManual);
		
		txtCategory = new JTextField();
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCategory.setColumns(10);
		txtCategory.setBounds(518, 203, 286, 28);
		getContentPane().add(txtCategory);
	}
	
	private void DataSetters() {
		try {
			st = dbConn.getConnection().createStatement();
			
			String SQL = "SELECT prodImg, prodName, prodVolume, prodPrice, prodCategory, Description, Ingredients, Howtouse FROM tblproducts WHERE prodID = '" + prodID + "'";
			st.execute(SQL);
			
			rs = st.getResultSet();
			
			if(rs.next()) {
				
				lblImg.setIcon(new ImageIcon(imgLoader(rs.getString(1))));
				txtProdName.setText(rs.getString(2));
				txtVariant.setText(rs.getString(3));
				txtPrice.setText(rs.getString(4));
				txtCategory.setText(rs.getString(5));
				txtDescription.setText(rs.getString(6));
				txtIngredients.setText(rs.getString(7));
				txtManual.setText(rs.getString(8));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR ProdDetails: " + e.getMessage());
		}
	}
	
	// Img fitter
	private Image imgLoader(String path) {
		Image scaledImage = null;
		try {
			URL imageUrl = new URL("http://localhost/webdevelopment/thesis1_website/Products/resources/" + path);
			ImageIcon imageIcon = new ImageIcon(imageUrl);
			Image image = imageIcon.getImage();

			// Calculate the scaled dimensions to fit the label
			int labelWidth = lblImg.getWidth();
			int labelHeight = lblImg.getHeight();
			scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR IMGLoader: " + e.getMessage());
		}
		
		return scaledImage;
	}
	
}
