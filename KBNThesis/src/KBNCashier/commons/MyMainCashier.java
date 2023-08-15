package KBNCashier.commons;

import java.awt.EventQueue;

import javax.swing.JFrame;

import KBNCashier.views.Cashier;

public class MyMainCashier {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashier cashier = new Cashier();
					cashier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
