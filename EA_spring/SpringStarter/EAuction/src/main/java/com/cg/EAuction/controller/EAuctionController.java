package com.cg.EAuction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;
import com.cg.EAuction.service.AdminService;
import com.cg.EAuction.service.CustomerService;

/**
 * @author Aditya
 *
 */

@RestController
@RequestMapping(value = "/ea")
@CrossOrigin(origins = "*")
public class EAuctionController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	

	private static final Logger logger = LoggerFactory.getLogger(EAuctionController.class);
	
	@PostMapping("/additem")
	//@PreAuthorize
	public ResponseEntity<?> addItem(@RequestBody AuctionItem auctionItem){
		
		try {
			adminService.addItem(auctionItem);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("Item Added", HttpStatus.OK);
	}
	
	
	@PostMapping("/updateitem")
	//@PreAuthorize
	public ResponseEntity<?> updateItem(@RequestBody AuctionItem auctionItem){
		
		try {
			adminService.updateItem(auctionItem);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("Item Updated", HttpStatus.OK);
	}
	
	
	@PostMapping("/adduser")
	//@PreAuthorize
	public ResponseEntity<?> addUser(@RequestBody User user){
		
		try {
			adminService.addUser(user);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("User Added", HttpStatus.OK);
	}
	
	
}
