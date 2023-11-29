package KBN.Module.Marketing.KBNProducts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import KBN.commons.CompositeDocumentFilter;
import KBN.commons.DbConnection;
import KBN.commons.EmailDocumentFilter;
import KBN.commons.NumberOnlyDocumentFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.PlainDocument;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class ProductDetails extends JDialog implements ActionListener {
	
	public JTextField txtProdName;
	public JTextField txtProductCost;
	public JTextField txtVariant;
	public JLabel lblImg;
	
	private boolean btnCategoryChecker;
	
	private DbConnection dbConn;
	private Statement st;
	private ResultSet rs;
	
	private String imgPath = "";
	
	private String prodID = "";
	private JComboBox cbCategory;
	
	private ArrayList<String> arrCb;
	private ArrayList<String> arrCBIdentifier;
	private JTextPane txtDescription;
	public JButton btnSave;
	private JButton btnAddImg;
	
	private String userID = "";
	private JTextField txtCategory;
	private JButton btnAddNew;
	private JTextField txtProfitMargin;
	private JTextField txtProductPrice;
	private JButton btnComputePrice;

	public ProductDetails() {
		setResizable(false);
		setBounds(100, 100, 989, 522);
		setModal(true);
		getContentPane().setLayout(null);
		
		dbConn = new DbConnection();
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: StatementProdDetails: " + e.getMessage());
		}
		arrCb  = new ArrayList<>();
		arrCBIdentifier  = new ArrayList<>();
		
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(new Color(255, 255, 255));
		imgPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgPanel.setBounds(10, 11, 310, 461);
		getContentPane().add(imgPanel);
		imgPanel.setLayout(null);
		
		lblImg = new JLabel("");
		lblImg.setBackground(Color.LIGHT_GRAY);
		lblImg.setBounds(10, 11, 290, 353);
		imgPanel.add(lblImg);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAddImg = new JButton("Upload Product Img");
		btnAddImg.setForeground(Color.WHITE);
		btnAddImg.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnAddImg.setFocusable(false);
		btnAddImg.setBorderPainted(false);
		btnAddImg.setBackground(new Color(8, 104, 0));
		btnAddImg.setBounds(34, 411, 241, 35);
		imgPanel.add(btnAddImg);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setBackground(new Color(255, 255, 255));
		dataPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dataPanel.setBounds(330, 11, 633, 461);
		getContentPane().add(dataPanel);
		dataPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product:");
		lblNewLabel_1.setBounds(10, 84, 140, 28);
		dataPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtProdName = new JTextField();
		txtProdName.setBounds(10, 114, 286, 28);
		dataPanel.add(txtProdName);
		txtProdName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProdName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Cost:");
		lblNewLabel_1_1.setBounds(327, 167, 140, 28);
		dataPanel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtProductCost = new JTextField();
		txtProductCost.setBounds(327, 197, 140, 28);
		dataPanel.add(txtProductCost);
		txtProductCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProductCost.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Variant: (Ex. 100 ml, 1Liter, etc)");
		lblNewLabel_1_1_1.setBounds(10, 167, 286, 28);
		dataPanel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtVariant = new JTextField();
		txtVariant.setBounds(10, 197, 286, 28);
		dataPanel.add(txtVariant);
		txtVariant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVariant.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1_1.setBounds(327, 84, 140, 28);
		dataPanel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Description:");
		lblNewLabel_1_1_1_1_1.setBounds(10, 305, 140, 28);
		dataPanel.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
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
		
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnSave.setFocusable(false);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(8, 104, 0));
		btnSave.setBounds(511, 11, 112, 35);
		dataPanel.add(btnSave);
		
		txtDescription = new JTextPane();
		txtDescription.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		JScrollPane descriptionScrollPane = new JScrollPane(txtDescription);
		descriptionScrollPane.setBounds(10, 335, 286, 78);
		dataPanel.add(descriptionScrollPane);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(327, 114, 286, 28);
		txtCategory.setVisible(false);
		txtCategory.setColumns(10);
		dataPanel.add(txtCategory);
		
		btnAddNew = new JButton("Add New?");
		btnAddNew.setForeground(Color.BLACK);
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddNew.setFocusable(false);
		btnAddNew.setBorderPainted(false);
		btnAddNew.setBackground(Color.WHITE);
		btnAddNew.setBounds(511, 90, 100, 19);
		btnAddNew.addActionListener(this);
		dataPanel.add(btnAddNew);
		
		txtProfitMargin = new JTextField();
		txtProfitMargin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProfitMargin.setColumns(10);
		txtProfitMargin.setBounds(477, 197, 136, 28);
		dataPanel.add(txtProfitMargin);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Profit Margin: (%)");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(477, 167, 157, 28);
		dataPanel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Product Price:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_3.setBounds(10, 236, 286, 28);
		dataPanel.add(lblNewLabel_1_1_3);
		
		txtProductPrice = new JTextField();
		txtProductPrice.setEditable(false);
		txtProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProductPrice.setColumns(10);
		txtProductPrice.setBounds(10, 266, 286, 28);
		txtProductPrice.setFocusable(false);
		dataPanel.add(txtProductPrice);
		
		btnComputePrice = new JButton("Compute Price");
		btnComputePrice.setForeground(Color.WHITE);
		btnComputePrice.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		btnComputePrice.setFocusable(false);
		btnComputePrice.setBorderPainted(false);
		btnComputePrice.setBackground(new Color(8, 104, 0));
		btnComputePrice.setBounds(387, 260, 188, 35);
		btnComputePrice.addActionListener(this);
		dataPanel.add(btnComputePrice);
		
		btnAddImg.addActionListener(this);
		btnSave.addActionListener(this);
		

		NumberOnlyDocumentFilter numberFiler = new NumberOnlyDocumentFilter(10);
        EmailDocumentFilter emailFilter = new EmailDocumentFilter(64);
        CompositeDocumentFilter text = new CompositeDocumentFilter(64);
        
		PlainDocument prodName = (PlainDocument) txtProdName.getDocument();
		PlainDocument prodVariant = (PlainDocument) txtVariant.getDocument();
		PlainDocument cost = (PlainDocument) txtProductCost.getDocument();
		PlainDocument profit = (PlainDocument) txtProfitMargin.getDocument();
		
		prodName.setDocumentFilter(text);
		prodVariant.setDocumentFilter(emailFilter);
		cost.setDocumentFilter(numberFiler);
		profit.setDocumentFilter(numberFiler);
		
	}
	
	public void ProductDetails(String prodID) {
		this.prodID = prodID;
		DataSetters();
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void cbSetter() {
		try {
			String cbSQL = "SELECT * FROM tblproductcategories";
			st.execute(cbSQL);
			rs = st.getResultSet();
			arrCb.clear();
			arrCBIdentifier.clear();
			while(rs.next()) {
				arrCBIdentifier.add(rs.getString(1));
				arrCb.add(rs.getString(2));
			}
	        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbCategory.getModel();
	        model.removeAllElements();
	        
	        for (String item : arrCb) {
	            model.addElement(item);
	        }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cbSetter: " + e.getMessage());
		}
	}

	private void DataSetters() {
		try {
			cbSetter();
			String SQL = "SELECT prodImg, prodName, prodVolume, prodPrice, prodCategory, Description FROM tblproducts WHERE prodID = '" + prodID + "'";
			st.execute(SQL);
			
			rs = st.getResultSet();
			
			if(rs.next()) {
				
				lblImg.setIcon(new ImageIcon(imgLoader(rs.getString(1))));
				txtProdName.setText(rs.getString(2));
				txtVariant.setText(rs.getString(3));
				txtProductCost.setText(rs.getString(4));
//				cbCategory.addItem(rs.getString(5));
				for(int i = 0; i < arrCBIdentifier.size(); i++) {
					if(arrCBIdentifier.get(i).equals(rs.getString(5)))
						cbCategory.setSelectedIndex(i);
				}
				txtDescription.setText(rs.getString(6));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR ProdDetails: " + e.getMessage());
		}
	}
	
	// Img fitter
	private Image imgLoader(String path) {
		Image scaledImage = null;
		try {
			URL imageUrl = new URL("https://kissedbynature.online/Products/resources/" + path);
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
		if(e.getSource() == btnSave) {
			if(btnSave.getText().equals("Save")) {
				addProduct();
			}else if(btnSave.getText().equals("Update")) {
				updateProduct();
			}
		}
		if(e.getSource() == btnAddImg) {
			uploadIMG();
		}
		

		if(e.getSource() == btnAddNew) {
			if(btnAddNew.getText().equals("Add New?")) {
				btnCategoryChecker = true;
				txtCategory.setVisible(true);
				cbCategory.setVisible(false);
				btnAddNew.setText("Back");
			} else if(btnAddNew.getText().equals("Back")) {
				btnCategoryChecker = false; // manual input 
				txtCategory.setVisible(false);
				cbCategory.setVisible(true);
				btnAddNew.setText("Add New?");
			}
		}
		
		if(e.getSource() == btnComputePrice) {
			double cost = Double.parseDouble(txtProductCost.getText());
			double margintoConvert = Double.parseDouble(txtProfitMargin.getText());
			
			double marginConverted = margintoConvert/100;
			double margin = cost * marginConverted;
			
			double price = cost + margin;
			
			txtProductPrice.setText(price + "");
		}
	}
	
	//Save
	private void addProduct() {
		try {
			String img = imgPath;
			String prodName = txtProdName.getText();
			String prodPrice = txtProductPrice.getText();
			String prodVol = txtVariant.getText();
			String prodQuantity = "0";
			String prodSold = "0";
//			btnCategoryChecker = false; // manual input 
			String prodCat = "";
			if(!btnCategoryChecker)
				prodCat = cbCategory.getSelectedItem().toString();
			else
				prodCat = txtCategory.getText();
			String Description = txtDescription.getText();
			
			if(btnCategoryChecker) {
				String AddProdCat = "INSERT INTO tblproductcategories VALUES('" + prodCat + "','" + prodCat + "')";
				st.execute(AddProdCat);
			}
			
			String SQLInsert = "INSERT INTO tblproducts (prodImg,prodName,prodPrice,prodVolume,Quantity,Sold,prodCategory,Description) VALUES('"
					+ img + "','"
					+ prodName + "','"
					+ prodPrice + "','"
					+ prodVol + "','"
					+ prodQuantity + "','"
					+ prodSold + "','"
					+ prodCat + "','"
					+ Description + "');";
			
			st.execute(SQLInsert);
			String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + userID + "','KBN Product Added - " + prodName + "(" + prodVol + ")');";
			st.execute(AuditTrail);
			JOptionPane.showMessageDialog(null, "Product Added!");
			clearInputs();
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error SAVE: " + e.getMessage());
		}
	}
	
	//update
	private void updateProduct() {
		try {
			String productID = prodID;
			String prodName = txtProdName.getText();
			String prodPrice = txtProductPrice.getText();
			String prodVol = txtVariant.getText();
			String Description = txtDescription.getText();
			
			String prodCat = "";
			if(!btnCategoryChecker)
				prodCat = cbCategory.getSelectedItem().toString();
			else
				prodCat = txtCategory.getText();
			
			if(btnCategoryChecker) {
				String AddProdCat = "INSERT INTO tblproductcategories VALUES('" + prodCat + "','" + prodCat + "')";
				st.execute(AddProdCat);
			}
			
			String SQLUpdate = "UPDATE tblproducts \n"
					+ "SET prodName = '" + prodName + "', \n"
					+ "prodPrice = '" + prodPrice +"', \n"
					+ "prodVolume = '" + prodVol + "', \n"
					+ "Quantity = 0, \n"
					+ "Sold = 0, \n"
					+ "prodCategory = '" + prodCat + "', \n"
					+ "Description = '" + Description + "' \n"
					+ "WHERE prodID = '" + productID + "';";
			
			System.out.println(SQLUpdate);
			
			st.execute(SQLUpdate);
			String AuditTrail = "INSERT INTO audittrailmarketing(DateAction,userID,Description) VALUES(NOW(),'" + userID + "','KBN Product - Update " + prodName + "(" + prodVol + ")');";
			st.execute(AuditTrail);
			JOptionPane.showMessageDialog(null, "Product Updated!");
			clearInputs();
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Update: " + e.getMessage());
		}
	}
	
	private void uploadIMG() {
	    int response = JOptionPane.showConfirmDialog(
	            null,
	            "Once you upload the image, any changes will be automatically updated.\nDo you want to proceed?",
	            "Confirmation",
	            JOptionPane.YES_NO_OPTION
	    );

	    if (response == JOptionPane.YES_OPTION) {
	        JFileChooser fileChooser = new JFileChooser();

	        // Create a filter to only accept image files with extensions jpg, jpeg, png, and gif
	        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
	                "Image Files", "jpg", "jpeg", "png", "gif");

	        fileChooser.setFileFilter(imageFilter); // Set the filter on the file chooser

	        int returnValue = fileChooser.showOpenDialog(null);

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            
	            System.out.println(selectedFile);
	            uploadFile(selectedFile);

	            if (btnSave.getText().equals("Update")) {
	                String SQL = "UPDATE tblproducts\r\n"
	                        + "SET prodImg = '" + imgPath + "' \n"
	                        + "WHERE prodID = '" + prodID + "';";

	                try {
	                    st.execute(SQL);
	                } catch (Exception e) {
	                    JOptionPane.showMessageDialog(null, "Update Imgage.");
	                }
	            }
	        } else if (returnValue == JFileChooser.CANCEL_OPTION || returnValue == JFileChooser.ERROR_OPTION) {
	            JOptionPane.showMessageDialog(null, "Image upload canceled.");
	        }
	    } else if (response == JOptionPane.NO_OPTION) {
	    } else if (response == JOptionPane.CLOSED_OPTION) {
	    }
	}
	
	private void uploadFile(File file) {
		
	    try {
	        BufferedImage originalImage = ImageIO.read(file);
	        int newWidth = 300;
	        int newHeight = 350;
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
	        resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

	        // Save the resized image back to the same file
	        ImageIO.write(resizedImage, "png", file);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return; // Handle the exception as needed
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
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and display the response from the PHP script
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lblImg.setIcon(new ImageIcon(imgLoader(line)));
                        imgPath = line;
                    }
                }
            } else {
                System.out.println("Upload failed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void clearInputs() {
		prodID = "";
		imgPath = "";
		txtProdName.setText("");
		txtProductCost.setText("");
		txtVariant.setText("");
		if(cbCategory != null)
			cbCategory.setSelectedIndex(0);
		txtDescription.setText("");
		lblImg.setIcon(null);
	}
}
