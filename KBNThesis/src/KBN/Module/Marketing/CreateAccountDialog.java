package KBN.Module.Marketing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreateAccountDialog extends JDialog {

	public CreateAccountDialog() {
		setResizable(false);
		setBounds(100, 100, 859, 548);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
	}
}
