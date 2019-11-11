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
	
	public List<AuctionItem> viewAllItemsInEvent(Long eventId);
	
	public AuctionEvent viewAnEvent(Long eventId);
	
	/*******Item**********/
	
	public AuctionItem addItem(AuctionItem auctionItem, Long eventId) throws EAException;
	
	public AuctionItem updateItem(AuctionItem auctionItem) throws EAException;
	
	public int removeItem(Long itemId) throws EAException;
	
	public List<AuctionItem> viewAllItems();
	
	public List<AuctionItem> viewAllEventItems(Long eventId);
	
	public int addItemToEvent(Long itemId, Long eventId) throws EAException;
	
	/*******User**********/
	
	public User addUser(User user) throws EAException;
	
	public List<User> viewAllUser();
	
	public int removeUser(Long userId) throws EAException;

	
}
