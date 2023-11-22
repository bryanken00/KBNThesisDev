package KBNAdminPanel.commons;

import java.awt.EventQueue;

import javax.swing.JFrame;

import KBNAdminPanel.views.AdminPanel;
import KBNAdminPanel.views.KBNMainFrame;

public class MyMainAdminPanel {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KBNMainFrame admin = new KBNMainFrame();
					admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
