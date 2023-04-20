package KBN.Module.Production;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BacktrackingDetails extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BacktrackingDetails dialog = new BacktrackingDetails();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BacktrackingDetails() {
		setResizable(false);
		setBounds(100, 100, 942, 579);
		getContentPane().setLayout(null);
	}

}
