package com.qr.wifiqr.serviceimpl;

import java.io.IOException;

import com.google.zxing.WriterException;
import com.qr.wifiqr.model.WiFi;

public interface QRService {

	public String generateQRCodeForWIFI(WiFi fi) throws WriterException, IOException;
}
