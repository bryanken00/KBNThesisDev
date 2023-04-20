package KBN.commons;

import java.awt.EventQueue;

import javax.swing.JFrame;

import KBN.views.KBNMainFrame;

public class KBNMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KBNMainFrame KBNMF = new KBNMainFrame();
					KBNMF.setVisible(true);
					
					//Test Push
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
