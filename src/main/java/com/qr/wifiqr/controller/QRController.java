package com.qr.wifiqr.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.qr.wifiqr.model.WiFi;
import com.qr.wifiqr.serviceimpl.QRService;

@RestController
@RequestMapping("/v1")
public class QRController {
	
	@Autowired
	QRService qService;

	@GetMapping(value = "/test")
	public String gen() {
		System.out.println("called........................");
		return "Hello world >>>>>>>>>>>>>>>>>>>>>>>>";
	}
	
	
	@GetMapping(value = "/wifi")
	public String genWifi() throws WriterException, IOException {
		System.out.println("called........................");
		qService.
				generateQRCodeForWIFI
									(new WiFi("Network name Lynx", 
											  "Password ******Lynx#@8@999#*************",
											  "Network type WPA/WPA2"));
		return "QR Code Generated >>>>>>>>>>>>>>>>>>>>>>>>";
	}
}
