package testingForecasting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileUploader {
    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FileUploader window = new FileUploader();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FileUploader() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(10, 10, 414, 142);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnUpload = new JButton("Upload File");
        btnUpload.setBounds(10, 10, 150, 30);
        panel.add(btnUpload);

        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                
                // Create a filter to only accept image files with extensions jpg, jpeg, png, and gif
                FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                    "Image Files", "jpg", "jpeg", "png", "gif");
                
                fileChooser.setFileFilter(imageFilter); // Set the filter on the file chooser
                
                int returnValue = fileChooser.showOpenDialog(null);
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    uploadFile(selectedFile);
                }
            }
        });
        
    }


    private void uploadFile(File file) {
        String targetURL = "http://localhost/webdevelopment/thesis1_website/Products/upload.php";

        try {
            URL url = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            String boundary = Long.toHexString(System.currentTimeMillis());
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(("--" + boundary + "\r\n").getBytes());
                os.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n").getBytes());
                os.write(("Content-Type: application/octet-stream\r\n\r\n").getBytes());

                byte[] fileBytes = java.nio.file.Files.readAllBytes(file.toPath());
                os.write(fileBytes);
                os.write(("\r\n--" + boundary + "--\r\n").getBytes());
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and display the response from the PHP script
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Response: " + line);
                    }
                }
            } else {
                System.out.println("Upload failed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
