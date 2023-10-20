package KBN.Module.Production.ArchiveList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ArchiveData extends JPanel {
	
	private JPanel[] panel;
	
	public JLabel[] lblTrackingID;
	public JLabel[] lblDate;
	public JLabel[] lblStatus;
	public JButton[] btnViewDetails;
	private JLabel[] lblTracking;
	private JLabel[] lblDateAdded;
	private JLabel[] lblStatus_;
	
	private int counter = 0;

	public ArchiveData() {
		setBounds(0, 0, 969, 616);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
	}
	
	public void iCountKBNProducts(int count) {
		counter = count;
		settingUp();
	}
	
	private void settingUp() {
		this.setPreferredSize(new Dimension(2, 80*counter));
		panel = new JPanel[counter];
		lblTrackingID = new JLabel[counter];
		lblDate = new JLabel[counter];
		lblStatus = new JLabel[counter];
		btnViewDetails = new JButton[counter];
		lblTracking = new JLabel[counter];
		lblDateAdded = new JLabel[counter];
		lblStatus_ = new JLabel[counter];
		
		for(int i = 0; i < counter; i++)
			setData(i);
	}
	
	private void setData(int index) {
		int y = 11;
		if(index > 0)
			y = 102*index;
		
		panel[index] = new JPanel();
		panel[index].setBackground(new Color(255, 255, 255));
		panel[index].setBorder(new LineBorder(new Color(0, 0, 0)));
		panel[index].setBounds(10, y, 949, 80);
		panel[index].setLayout(null);
		add(panel[index]);
		
		lblTracking[index] = new JLabel("Tracking ID");
		lblTracking[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblTracking[index].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTracking[index].setBounds(62, 13, 125, 20);
		panel[index].add(lblTracking[index]);
		
		lblDateAdded[index] = new JLabel("Date Added");
		lblDateAdded[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblDateAdded[index].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateAdded[index].setBounds(247, 13, 125, 20);
		panel[index].add(lblDateAdded[index]);
		
		lblStatus_[index] = new JLabel("Status");
		lblStatus_[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus_[index].setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus_[index].setBounds(445, 13, 125, 20);
		panel[index].add(lblStatus_[index]);
		
		btnViewDetails[index] = new JButton("View Details");
		btnViewDetails[index].setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnViewDetails[index].setFocusable(false);
		btnViewDetails[index].setBorder(new LineBorder(new Color(123,156,121), 1, true));
		btnViewDetails[index].setBackground(new Color(123,156,121));
		btnViewDetails[index].setBounds(662, 17, 235, 46);
		panel[index].add(btnViewDetails[index]);
		
		lblTrackingID[index] = new JLabel("001");
		lblTrackingID[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingID[index].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingID[index].setBounds(62, 46, 125, 20);
		panel[index].add(lblTrackingID[index]);
		
		lblDate[index] = new JLabel("10/10/2023");
		lblDate[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblDate[index].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate[index].setBounds(247, 46, 125, 20);
		panel[index].add(lblDate[index]);
		
		lblStatus[index] = new JLabel("Pending");
		lblStatus[index].setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus[index].setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus[index].setBounds(445, 46, 125, 20);
		panel[index].add(lblStatus[index]);
	}

}