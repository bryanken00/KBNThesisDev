package testingForecasting;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class FileUploader {
    private JFrame frame;
    private File selectedFile;

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

        JButton btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(150, 30, 150, 30);
        frame.getContentPane().add(btnBrowse);

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                }
            }
        });

        JButton btnUpload = new JButton("Upload");
        btnUpload.setBounds(150, 70, 150, 30);
        frame.getContentPane().add(btnUpload);

        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedFile != null) {
                    uploadFile(selectedFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a file to upload.");
                }
            }
        });
    }

    private void uploadFile(File file) {
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("http://localhost/webdevelopment/thesis1_website/Products/upload.php");

            // Prepare the file to be uploaded
            EntityBuilder entityBuilder = EntityBuilder.create();
            entityBuilder.setFile(file);
            HttpEntity entity = entityBuilder.build();

            // Set up the request parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("uploadfile", file.getName()));
            httppost.setEntity(entity);

            // Execute the request
            HttpResponse response = httpclient.execute(httppost);

            // Handle the response (you can add more error handling here)
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                JOptionPane.showMessageDialog(null, "File uploaded successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "File upload failed. Status Code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
