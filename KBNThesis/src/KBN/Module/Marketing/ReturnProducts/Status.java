package KBN.Module.Marketing.ReturnProducts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import KBN.commons.DbConnection;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Status extends JDialog {
	
	private DbConnection dbConn;
	private JComboBox comboBox;
	private Statement st;
	public String ref = "";
	public Status() {
		setBounds(0, 0, 450, 210);
		getContentPane().setLayout(null);
		setModal(true);
		
		dbConn = new DbConnection();
		//set UI to center of screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        this.setLocation(x, y);
		try {
			st = dbConn.getConnection().createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		JLabel lblNewLabel = new JLabel("Select Status:");
		lblNewLabel.setBounds(10, 11, 195, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		getContentPane().add(lblNewLabel);
		
		String status[] = {"Disposal", "Completed"};
		
		comboBox = new JComboBox(status);
		comboBox.setBounds(15, 61, 404, 39);
		getContentPane().add(comboBox);
		
		JButton btnUpdateStatus = new JButton("Update Status");
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQLUpdate = "UPDATE tblreturnstatus "
						+ "SET Status = '" + comboBox.getSelectedItem() + "' "
						+ "WHERE OrderRefNumber = '" + ref + "'";
					try {
						 int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
					        if (response == JOptionPane.YES_OPTION) {
								st.execute(SQLUpdate);
								dispose();
					        }
					        else if (response == JOptionPane.NO_OPTION)
								return;
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error class Status: " + e1.getMessage());
					}
			}
		});
		btnUpdateStatus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		btnUpdateStatus.setFocusable(false);
		btnUpdateStatus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdateStatus.setBackground(Color.WHITE);
		btnUpdateStatus.setBounds(281, 118, 143, 39);
		getContentPane().add(btnUpdateStatus);
	}
}
