package KBNAdminPanel.commons;

import java.awt.EventQueue;

import javax.swing.JFrame;

import KBNAdminPanel.views.AdminPanel;

public class MyMainAdminPanel {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel admin = new AdminPanel();
					admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
