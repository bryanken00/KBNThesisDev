package KBN.Module.Marketing.KBNProducts;

import java.awt.EventQueue;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class PopUpPRODIMG extends JFrame {

	private JLabel lblImg;
	public JButton btnExit;


	public PopUpPRODIMG() {
		setBounds(100, 100, 416, 442);
		setResizable(false);
//		setUndecorated(true);
		getContentPane().setLayout(null);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(0, 0, 400, 400);
		getContentPane().add(lblImg);
		
	}
	
	public void setLink(String link) {
       try {
           
    	   URL imageUrl = new URL(link);
           
           Image originalImage = ImageIO.read(imageUrl);
           Image resizedImage = originalImage.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
           
           lblImg.setIcon(new ImageIcon(resizedImage));
           
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "ProductIMG ERROR: " + e.getMessage());
        }
	}
}
