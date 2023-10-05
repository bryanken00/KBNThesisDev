package KBN.Module.Warehouse.RawMatsList;

import java.io.File;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  
public class genQRCode {
	
	private static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
		
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
		MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
		
	}
	
	public void gettingURL(String url, String Filename)throws NotFoundException, WriterException, IOException {
		generateQQQRRR(url, Filename);
	}
	
	private static void generateQQQRRR(String data, String Filename) throws WriterException, IOException, NotFoundException {
		
		//QRCODE Link
		String str= data;
		
		//Destination of QRCODE
		String path = "" + Filename;
		
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		//width height
		generateQRcode(str, path, charset, hashMap, 200, 200);
		
		//check kung nag generate na yung qr
		JOptionPane.showMessageDialog(null, "QR Code created");
		System.out.println("QR Code created successfully.");
		
	}
}  