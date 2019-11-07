package com.cg.EAuction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.EAuction.service.AdminServiceImpl;

@SpringBootApplication
public class EAuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAuctionApplication.class, args);
		
		final Logger logger = LoggerFactory.getLogger(EAuctionApplication.class);
		logger.info("E Auction App Started");
	}

}
