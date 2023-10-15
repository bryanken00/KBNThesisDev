package KBN.Module.Production.RebrandingProducts;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class KBNDataBak extends JPanel {
	
	public JLabel lblTrackingID;
	public JLabel lblDate;
	public JLabel lblStatus;
	private JButton btnViewDetails;
	private JLabel lblTracking;
	private JLabel lblDateAdded;
	private JLabel lblStatus_1;
	private JPanel panel_1;
	private JLabel lblTracking_1;
	private JLabel lblDateAdded_1;
	private JLabel lblStatus_2;
	private JButton btnViewDetails_1;
	private JLabel lblTrackingID_1;
	private JLabel lblDate_1;
	private JLabel lblStatus_3;

	public KBNDataBak() {
		setBounds(0, 0, 969, 616);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 949, 80);
		add(panel);
		panel.setLayout(null);
		
		lblTracking = new JLabel("Tracking ID");
		lblTracking.setHorizontalAlignment(SwingConstants.CENTER);
		lblTracking.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTracking.setBounds(62, 13, 125, 20);
		panel.add(lblTracking);
		
		lblDateAdded = new JLabel("Date Added");
		lblDateAdded.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateAdded.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateAdded.setBounds(247, 13, 125, 20);
		panel.add(lblDateAdded);
		
		lblStatus_1 = new JLabel("Status");
		lblStatus_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus_1.setBounds(445, 13, 125, 20);
		panel.add(lblStatus_1);
		
		btnViewDetails = new JButton("View Details");
		btnViewDetails.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnViewDetails.setFocusable(false);
		btnViewDetails.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnViewDetails.setBackground(new Color(75, 119, 71, 180));
		btnViewDetails.setBounds(662, 17, 235, 46);
		panel.add(btnViewDetails);
		
		lblTrackingID = new JLabel("001");
		lblTrackingID.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingID.setBounds(62, 46, 125, 20);
		panel.add(lblTrackingID);
		
		lblDate = new JLabel("10/10/2023");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(247, 46, 125, 20);
		panel.add(lblDate);
		
		lblStatus = new JLabel("Pending");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(445, 46, 125, 20);
		panel.add(lblStatus);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 102, 949, 80);
		add(panel_1);
		
		lblTracking_1 = new JLabel("Tracking ID");
		lblTracking_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTracking_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTracking_1.setBounds(62, 13, 125, 20);
		panel_1.add(lblTracking_1);
		
		lblDateAdded_1 = new JLabel("Date Added");
		lblDateAdded_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateAdded_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateAdded_1.setBounds(247, 13, 125, 20);
		panel_1.add(lblDateAdded_1);
		
		lblStatus_2 = new JLabel("Status");
		lblStatus_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus_2.setBounds(445, 13, 125, 20);
		panel_1.add(lblStatus_2);
		
		btnViewDetails_1 = new JButton("View Details");
		btnViewDetails_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnViewDetails_1.setFocusable(false);
		btnViewDetails_1.setBorder(new LineBorder(new Color(75, 119, 71, 180), 1, true));
		btnViewDetails_1.setBackground(new Color(75, 119, 71, 180));
		btnViewDetails_1.setBounds(662, 17, 235, 46);
		panel_1.add(btnViewDetails_1);
		
		lblTrackingID_1 = new JLabel("001");
		lblTrackingID_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingID_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingID_1.setBounds(62, 46, 125, 20);
		panel_1.add(lblTrackingID_1);
		
		lblDate_1 = new JLabel("10/10/2023");
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate_1.setBounds(247, 46, 125, 20);
		panel_1.add(lblDate_1);
		
		lblStatus_3 = new JLabel("Pending");
		lblStatus_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus_3.setBounds(445, 46, 125, 20);
		panel_1.add(lblStatus_3);
	}

}