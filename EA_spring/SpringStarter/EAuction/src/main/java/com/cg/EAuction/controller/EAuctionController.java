package com.cg.EAuction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aditya
 *
 */

@RestController
@RequestMapping(value = "/ea")
@CrossOrigin(origins = "*")
public class EAuctionController {

	private static final Logger logger = LoggerFactory.getLogger(EAuctionController.class);
	
	
	
}
