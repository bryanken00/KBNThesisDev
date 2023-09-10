package testingForecasting;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class ForecastMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForecastUI forecast = new ForecastUI();
					forecast.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
