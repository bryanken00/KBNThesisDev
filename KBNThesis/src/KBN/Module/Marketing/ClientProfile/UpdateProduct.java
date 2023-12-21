package KBN.Module.Marketing.ClientProfile;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.PlainDocument;

import KBN.commons.DbConnection;
import KBN.commons.EmailDocumentFilter;
import KBN.commons.NumberOnlyDocumentFilter;
import KBN.commons.dataSetter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextPane;

public class UpdateProduct extends JDialog implements ActionListener {
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	private dataSetter dataSet;
	
	private String productID = "";
	
	private JTextField txtProduct;
	private JTextField txtVariant;
	private JButton btnAddImg;
	private JButton btnSave;
	private JLabel lblImg;
	
	private String imgPath = "";
	private JTextField txtNewCat;
	private JButton btnAddNew;
	private JComboBox cbCategory;
	
	private boolean addNew;
	private String rebrandingID = "";
	private JTextField txtProductCost;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField txtProfitMargin;
	private JTextField txtPrice;
	private JLabel lblNewLabel_1_1_1;
	private JButton btnComputePrice;
	
	private ArrayList<String> categoryProduct;
	
	private boolean imgUpdateChecker = false;

	public UpdateProduct() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setBounds(100, 100, 989, 522);
		setModal(true);
		getContentPane().setLayout(null);
		
		dbConn = new DbConnection();
		dataSet = new dataSetter();
		
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setLayout(null);
		imgPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgPanel.setBackground(Color.WHITE);
		imgPanel.setBounds(10, 11, 310, 461);
		getContentPane().add(imgPanel);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBackground(Color.LIGHT_GRAY);
		lblImg.setBounds(10, 11, 290, 353);
		imgPanel.add(lblImg);
		
		btnAddImg = new JButton("Upload Product Img");
		btnAddImg.setForeground(Color.WHITE);
		btnAddImg.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnAddImg.setFocusable(false);
		btnAddImg.setBorderPainted(false);
		btnAddImg.setBackground(new Color(8, 104, 0));
		btnAddImg.setBounds(34, 411, 241, 35);
		imgPanel.add(btnAddImg);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(null);
		dataPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dataPanel.setBackground(Color.WHITE);
		dataPanel.setBounds(330, 11, 633, 461);
		getContentPane().add(dataPanel);
		
		JLabel lblProductName = new JLabel("Product:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(10, 84, 140, 28);
		dataPanel.add(lblProductName);
		
		txtProduct = new JTextField();
		txtProduct.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProduct.setColumns(10);
		txtProduct.setBounds(10, 114, 286, 28);
		dataPanel.add(txtProduct);
		
		JLabel lblVariant = new JLabel("Variant:");
		lblVariant.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVariant.setBounds(10, 167, 140, 28);
		dataPanel.add(lblVariant);
		
		txtVariant = new JTextField();
		txtVariant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVariant.setColumns(10);
		txtVariant.setBounds(10, 197, 286, 28);
		dataPanel.add(txtVariant);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory.setBounds(327, 84, 140, 28);
		dataPanel.add(lblCategory);
		
		cbCategory = new JComboBox();
		cbCategory.setBounds(327, 114, 286, 28);
		dataPanel.add(cbCategory);
		
		JLabel lblTitle = new JLabel("Add Product");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(10, 11, 170, 39);
		dataPanel.add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 53, 613, 19);
		dataPanel.add(separator);
		
		btnSave = new JButton("Update");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnSave.setFocusable(false);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(8, 104, 0));
		btnSave.setBounds(511, 11, 112, 35);
		dataPanel.add(btnSave);
		
		btnAddNew = new JButton("Add New?");
		btnAddNew.setForeground(new Color(0, 0, 0));
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddNew.setFocusable(false);
		btnAddNew.setBorderPainted(false);
		btnAddNew.setBackground(new Color(255, 255, 255));
		btnAddNew.setBounds(511, 93, 100, 19);
		dataPanel.add(btnAddNew);
		
		txtNewCat = new JTextField();
		txtNewCat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNewCat.setColumns(10);
		txtNewCat.setBounds(327, 114, 286, 28);
		dataPanel.add(txtNewCat);
		
		txtProductCost = new JTextField();
		txtProductCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProductCost.setColumns(10);
		txtProductCost.setBounds(327, 197, 140, 28);
		dataPanel.add(txtProductCost);
		
		lblNewLabel_1 = new JLabel("Production Cost:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(327, 167, 140, 28);
		dataPanel.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("Profit Margin: (%)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(477, 167, 157, 28);
		dataPanel.add(lblNewLabel_1_1);
		
		txtProfitMargin = new JTextField();
		txtProfitMargin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProfitMargin.setColumns(10);
		txtProfitMargin.setBounds(477, 197, 136, 28);
		dataPanel.add(txtProfitMargin);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPrice.setFocusable(false);
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(10, 266, 286, 28);
		dataPanel.add(txtPrice);
		
		lblNewLabel_1_1_1 = new JLabel("Product Price:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 236, 286, 28);
		dataPanel.add(lblNewLabel_1_1_1);
		
		btnComputePrice = new JButton("Compute Price");
		btnComputePrice.setForeground(Color.WHITE);
		btnComputePrice.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnComputePrice.setFocusable(false);
		btnComputePrice.setBorderPainted(false);
		btnComputePrice.setBackground(new Color(8, 104, 0));
		btnComputePrice.setBounds(375, 259, 188, 35);
		btnComputePrice.addActionListener(this);
		dataPanel.add(btnComputePrice);
		
		btnAddImg.addActionListener(this);
		btnAddNew.addActionListener(this);
		btnSave.addActionListener(this);
		txtNewCat.setVisible(false);
		
		NumberOnlyDocumentFilter numberFiler = new NumberOnlyDocumentFilter(10);
        EmailDocumentFilter emailFilter = new EmailDocumentFilter(64);
        
		PlainDocument prodName = (PlainDocument) txtProduct.getDocument();
		PlainDocument prodVariant = (PlainDocument) txtVariant.getDocument();
		PlainDocument cost = (PlainDocument) txtProductCost.getDocument();
		PlainDocument profit = (PlainDocument) txtProfitMargin.getDocument();
		
		
		prodName.setDocumentFilter(emailFilter);
		prodVariant.setDocumentFilter(emailFilter);
		cost.setDocumentFilter(numberFiler);
		profit.setDocumentFilter(numberFiler);
	}
	
	public void setProductID(String prodID) {
		this.productID = prodID;
	}
	
	public void renderCategories() {
		try {
			cbCategory.removeAllItems();
			String SQL = "SELECT DISTINCT prodcategory FROM tblrebrandingproducts WHERE userID = '" + rebrandingID + "'";
			categoryProduct = new ArrayList<>();
			
			st.execute(SQL);
			rs = st.getResultSet();
			while(rs.next()) {
				categoryProduct.add(rs.getString(1));
			}
			 DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(categoryProduct.toArray(new String[0]));
			 cbCategory.setModel(model);
			 categoryProduct.clear();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error renderCategories: " + e.getMessage());
		}
	}
	
	public void setdata() {
		try {
			String sql = "SELECT prodName, prodVolume, prodPrice, prodCategory, prodImg FROM tblrebrandingproducts WHERE prodID = '" + productID + "';";
			st.execute(sql);
			rs = st.getResultSet();
			String productName = "";
			String price = "";
			String imagePATH = "";
			String vol = "";
			
			String category = "";
			
			ArrayList temp = new ArrayList<>();
			
			for(int i = 0; i < cbCategory.getItemCount(); i++) {
				temp.add(cbCategory.getItemAt(i));
			}
			
			while(rs.next()) {
				productName = rs.getString(1);
				vol = rs.getString(2);
				price = rs.getString(3);
				category = rs.getString(4);
				imagePATH = rs.getString(5);
			}
			
	        for (int i = 0; i < temp.size(); i++) {
	            if (temp.get(i).equals(category)) {
	            	cbCategory.setSelectedIndex(i);
	            }
	        }
			txtProduct.setText(productName);
			txtVariant.setText(vol);
			txtPrice.setText(price);
			lblImg.setIcon(new ImageIcon(imgLoader(imagePATH)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error setdata: " + e.getMessage());
		}
	}
	
	private void uploadIMG() {
        JFileChooser fileChooser = new JFileChooser();
        
        // Create a filter to only accept image files with extensions jpg, jpeg, png, and gif
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
            "Image Files", "jpg", "jpeg", "png", "gif");
        
        fileChooser.setFileFilter(imageFilter); // Set the filter on the file chooser
        
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            uploadFile(selectedFile);
        }
	}
	
	private void uploadFile(File file) {
		
		try {
		    BufferedImage originalImage = ImageIO.read(file);

		    int originalWidth = originalImage.getWidth();
		    int originalHeight = originalImage.getHeight();

		    BufferedImage resizedImage = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_RGB);

		    resizedImage.getGraphics().drawImage(originalImage, 0, 0, originalWidth, originalHeight, null);

		    ImageIO.write(resizedImage, "png", file);
		} catch (IOException e) {
		    e.printStackTrace();
		    return;
		}

	    
        String targetURL = "https://kissedbynature.online/Products/upload.php";

        try {
            URL url = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            String boundary = Long.toHexString(System.currentTimeMillis());
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(("--" + boundary + "\r\n").getBytes());
                os.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n").getBytes());
                os.write(("Content-Type: application/octet-stream\r\n\r\n").getBytes());

                byte[] fileBytes = java.nio.file.Files.readAllBytes(file.toPath());
                os.write(fileBytes);
                os.write(("\r\n--" + boundary + "--\r\n").getBytes());
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and display the response from the PHP script
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lblImg.setIcon(new ImageIcon(imgLoader(line)));
                        imgPath = line;
                        imgUpdateChecker = true;
                    }
                }
            } else {
                System.out.println("Upload failed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private Image imgLoader(String path) {
		Image scaledImage = null;
		try {
			String encodedPath = URLEncoder.encode(path, "UTF-8");
			URL imageUrl = new URL("https://kissedbynature.online/Products/resources/" + encodedPath);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAddImg)
			uploadIMG();
		
		if(e.getSource() == btnAddNew) {
			if(btnAddNew.getText().equals("Add New?")) {
				addNew = true;
				btnAddNew.setText("Back");
				txtNewCat.setVisible(true);
				cbCategory.setVisible(false);
			}else if(btnAddNew.getText().equals("Back")) {
				addNew = false;
				btnAddNew.setText("Add New?");
				txtNewCat.setText("");
				txtNewCat.setVisible(false);
				cbCategory.setVisible(true);
			}
		}
		if(e.getSource() == btnSave)
			btnSaveFunc();
		
		if(e.getSource() == btnComputePrice) {
			double cost = Double.parseDouble(txtProductCost.getText());
			double margintoConvert = Double.parseDouble(txtProfitMargin.getText());
			
			double marginConverted = margintoConvert/100;
			double margin = cost * marginConverted;
			
			double price = cost + margin;
			
			txtPrice.setText(price + "");
		}
	}
	
	public void clearFields() {
		lblImg.setIcon(null);
		txtProduct.setText("");
		txtVariant.setText("");
		txtPrice.setText("");
		txtNewCat.setText("");
		txtProductCost.setText("");
		txtProfitMargin.setText("");
		if(cbCategory.getItemCount() > 0)
			cbCategory.setSelectedIndex(0);
	}
	
	public void setUserID(String rUID) {
		rebrandingID = rUID;
	}
	
	private void btnSaveFunc() {
		try {
			String prodName = txtProduct.getText();
			String prodCategory = "";
			if(txtNewCat.getText().isBlank() || txtNewCat.getText().isBlank())
				prodCategory = cbCategory.getSelectedItem() + "";
			else
				prodCategory = txtNewCat.getText();
			String prodVariant = txtVariant.getText();
			String price = "";
			price = txtPrice.getText();
//			imgUpdateChecker
			String SQL = "";
			if(imgUpdateChecker)
				SQL = "UPDATE tblrebrandingproducts "
						+ "SET prodName = '" + prodName + "', "
						+ "prodCategory = '" + prodCategory + "', "
						+ "prodVolume = '" + prodVariant + "', "
						+ "prodPrice = '" + price + "' "
						+ "WHERE prodID = '" + productID + "';";
			else
				SQL = "UPDATE tblrebrandingproducts "
						+ "SET prodName = '" + prodName + "', "
						+ "prodCategory = '" + prodCategory + "', "
						+ "prodVolume = '" + prodVariant + "', "
						+ "prodPrice = '" + price + "', "
						+ "prodImg = '" + imgPath + "' "
						+ "WHERE prodID = '" + productID + "';";
			
			st.executeUpdate(SQL);
			

			String sqlProdName = prodName + " (" + prodVariant + ")";
			
			String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + dataSet.getAccountID() + "','Rebranding Update Product " + rebrandingID + " - " + sqlProdName + "');";
			
			st.execute(AuditTrail);
			
			JOptionPane.showMessageDialog(null, "Product Updated!");
			
			
			clearFields();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error btnSaveFunc: " + e.getMessage());
		}
	}
}
