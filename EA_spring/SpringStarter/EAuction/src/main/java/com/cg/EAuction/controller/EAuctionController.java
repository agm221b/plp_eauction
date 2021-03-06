package com.cg.EAuction.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dto.AuctionEvent;
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
	
	/*******Item**********/	
	
	@PostMapping("/additem")
	//@PreAuthorize
	public ResponseEntity<?> addItem(@RequestBody AuctionItem auctionItem, @RequestParam("eventId") Long eventId){
		
		try {
			adminService.addItem(auctionItem, eventId);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("Item Added"), HttpStatus.OK);
	}
	
	
	@PutMapping("/updateitem")
	//@PreAuthorize
	public ResponseEntity<?> updateItem(@RequestBody AuctionItem auctionItem){
		
		try {
			adminService.updateItem(auctionItem);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("Item Updated"), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeitem")
	//@PreAuthorize
	public ResponseEntity<?> removeItem(@RequestParam("itemId") Long itemId){
		
		try {
			adminService.removeItem(itemId);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("Item Removed"), HttpStatus.OK);
	}
	
	@GetMapping("/viewallitems")
	//@PreAuthorize
	public ResponseEntity<?> viewAllItems(){
		logger.info("Viewing List of Items");
		return new ResponseEntity<List<AuctionItem>>(adminService.viewAllItems(), HttpStatus.OK);
	}
	
	@GetMapping("/viewalluseritems")
	//@PreAuthorize
	public ResponseEntity<?> viewAllUserItems(@RequestParam("userId") Long userId){
		logger.info("Viewing List of User's Items");
		try {
			return new ResponseEntity<List<AuctionItem>>(customerService.viewUserItemList(userId), HttpStatus.OK);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}
	
	
	
	/*
	 * 
	 * Request Bid left
	 * Synchronized method
	 */
	@GetMapping("/checkbid")
	public ResponseEntity<?> checkBid(@RequestParam("itemId") Long itemId){
		logger.info("Checking if item is biddable");
		return new ResponseEntity<Boolean>(customerService.checkBid(itemId), HttpStatus.OK);
		
		
	}
	
	
	/*
	 * Start event at a fixed time
	 */
	@GetMapping("/viewalleventitems")
	//@PreAuthorize
	public ResponseEntity<?> viewAllEventItems(@RequestParam("eventId") Long eventId){
		
		logger.info("Viewing List of Event's Items");
		return new ResponseEntity<List<AuctionItem>>(adminService.viewAllEventItems(eventId), HttpStatus.OK);
	}
	
	
	/*******User**********/	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		
		try {
			adminService.addUser(user);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("User Added"), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeuser")
	//@PreAuthorize
	public ResponseEntity<?> removeUser(@RequestParam("userId") Long userId){
		
		try {
			adminService.removeUser(userId);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("User Removed"), HttpStatus.OK);
	}
	
	@GetMapping("/viewallusers")
	//@PreAuthorize
	public ResponseEntity<?> viewAllUsers(){
		logger.info("Viewing List of Users");
		return new ResponseEntity<List<User>>(adminService.viewAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/checklogin")
	//@PreAuthorize
	public ResponseEntity<?> checkLogin(@RequestParam("username")String username, @RequestParam("pass")String pass){
		logger.info("Checking Login");
		return new ResponseEntity<Boolean>(customerService.checkLogin(username, pass), HttpStatus.OK);
	}
	
	@GetMapping("/getrole")
	//@PreAuthorize
	public ResponseEntity<?> getRole(@RequestParam("username")String username){
		logger.info("Fetching role");
		return new ResponseEntity<User>(customerService.getRole(username), HttpStatus.OK);
	}
	
	/*******Event**********/
	
	
	@PostMapping("/addevent")
	//@PreAuthorize
	public ResponseEntity<?> addEvent(@RequestBody AuctionEvent auctionEvent){
		
		try {
			adminService.addEvent(auctionEvent);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("Event Added"), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeevent")
	//@PreAuthorize
	public ResponseEntity<?> removeEvent(@RequestParam ("eventId") Long eventId){
		
		try {
			adminService.removeEvent(eventId);
		} catch (EAException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(JSONObject.quote("Event Removed"), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewallevents")
	//@PreAuthorize
	public ResponseEntity<?> viewAllEvents(){
		logger.info("Viewing List of events");
		return new ResponseEntity<List<AuctionEvent>>(adminService.viewAllEvents(), HttpStatus.OK);
	}
	
	@GetMapping("/viewalleventNames")
	//@PreAuthorize
	public ResponseEntity<?> viewAllEventNames(){
		logger.info("Viewing List of events");
		return new ResponseEntity<String>(adminService.viewAllEvents().toString(), HttpStatus.OK);
	}
	
	@GetMapping("/viewitemsinevent")
	//@PreAuthorize
	public ResponseEntity<?> viewItemsInEvent(@RequestParam ("eventId") Long eventId){
		logger.info("Viewing List of items in event");
		
		return new ResponseEntity<List<AuctionItem>>(adminService.viewAllItemsInEvent(eventId), HttpStatus.OK);
	}
	
	@GetMapping("/viewanevent")
	//@PreAuthorize
	public ResponseEntity<?> viewAnEvent(@RequestParam("eventId")Long eventId){
		logger.info("Viewing particular event");
		return new ResponseEntity<AuctionEvent>(adminService.viewAnEvent(eventId), HttpStatus.OK);
	}
	
	
	
	
	
}
