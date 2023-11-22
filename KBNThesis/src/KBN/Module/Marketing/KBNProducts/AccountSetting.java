package KBN.Module.Marketing.KBNProducts;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class AccountSetting extends JPanel {
	public JButton btnEditPassword;

	public AccountSetting() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 200, 32);
		setLayout(null);
		
		btnEditPassword = new JButton("Change password");
		btnEditPassword.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		btnEditPassword.setFocusable(false);
		btnEditPassword.setBorderPainted(false);
		btnEditPassword.setBackground(Color.WHITE);
		btnEditPassword.setBounds(1, 1, 198, 30);
		add(btnEditPassword);

	}
}
