package com.cg.EAuction.service;

import java.util.List;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dto.AuctionEvent;
import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;

public interface AdminService {
	
	/*******Event**********/
	
	public AuctionEvent addEvent(AuctionEvent auctionEvent) throws EAException;
	
	public int removeEvent(Long eventId) throws EAException;

	public List<AuctionEvent> viewAllEvents();
	
	/*******Item**********/
	
	public AuctionItem addItem(AuctionItem auctionItem) throws EAException;
	
	public AuctionItem updateItem(AuctionItem auctionItem) throws EAException;
	
	public int removeItem(Long itemId) throws EAException;
	
	public List<AuctionItem> viewAllItems();
	
	public int addItemToEvent(Long itemId, Long eventId) throws EAException;
	
	/*******User**********/
	
	public User addUser(User user) throws EAException;
	
	public List<User> viewAllUser();
	
	public int removeUser(Long userId) throws EAException;
}
