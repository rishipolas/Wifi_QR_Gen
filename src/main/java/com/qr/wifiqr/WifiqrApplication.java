package com.qr.wifiqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qr.*")
public class WifiqrApplication {

	public static void main(String[] args) {
		SpringApplication.run(WifiqrApplication.class, args);
	}

}
