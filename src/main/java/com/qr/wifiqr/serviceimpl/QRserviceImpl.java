package com.qr.wifiqr.serviceimpl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qr.wifiqr.model.WiFi;

@Service
public class QRserviceImpl implements QRService{

	String strr = "C:\\Users\\Pooja P Polas\\Desktop\\WIFIQR\\";
	
	@Override
	public  String generateQRCodeForWIFI( WiFi fi) throws WriterException, IOException {
		String labelNameString = "Scan_ME";
		int labelHeight = 20;
		int width = 450;
		int height = 550;
//		int width = 450;
//		int height = 450;
		String nwStr = strr + fi.getNetworkname()+"-QR_code.png";
		QRCodeWriter writer = new QRCodeWriter();//
		BitMatrix matrix = writer.encode("WIFI:S:Lynx;T:WPA;P:Lynx#@8@9#*;H:false;;", BarcodeFormat.QR_CODE, width, height,getQRCodeEncodeHints());
		
		//Label
		BitMatrix bitMatrixLabel = new BitMatrix(width, height+labelHeight);
		bitMatrixLabel.clear();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (matrix.get(i, j)) {
					bitMatrixLabel.set(i, j);
				}
			}
		}
		
		//check logic
		MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000, 0XFFFFFFFF);
		int startx=(width -labelNameString.length()*7)/2;//center the label text
		
		for (int i = startx, j= height + 15; i < startx+labelNameString.length()*7; i++) {
			if (labelNameString.charAt((i -startx) /7) ==' ') {
				continue;
			}
			bitMatrixLabel.set(i, j);
		}
		
		
		Path path = FileSystems.getDefault().getPath(nwStr);
//		MatrixToImageWriter.writeToPath(matrix, "PNG", path); //older
		MatrixToImageWriter.writeToPath(bitMatrixLabel, "PNG", path,config);
		
		
		return "QR Code is generated.";
	}
	
	
	
	private static Map<EncodeHintType, Object> getQRCodeEncodeHints(){
		Map<EncodeHintType, Object> hintsMap= new HashMap<>();
		hintsMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hintsMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hintsMap.put(EncodeHintType.MARGIN,1);
		return hintsMap;
	}
	
}
