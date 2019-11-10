package com.cg.EAuction.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dao.EventRepository;
import com.cg.EAuction.dao.ItemRepository;
import com.cg.EAuction.dao.UserRepository;
import com.cg.EAuction.dto.AuctionEvent;
import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Override
	public AuctionEvent addEvent(AuctionEvent auctionEvent) throws EAException {
		// TODO Auto-generated method stub
		auctionEvent.setDeleteFlag(0);
		AuctionEvent saveEvent = eventRepository.save(auctionEvent);
		if (saveEvent == null) {
			throw new EAException("Event Not Found");
		}
		logger.info("Event saved:" + saveEvent);
		logger.info("Created by: " + saveEvent.getCreatedBy() + ", created on: " + saveEvent.getCreationDate()
				+ ", modified by: " + saveEvent.getLastModifiedBy() + ", modified on: "
				+ saveEvent.getLastModifiedDate());

		return saveEvent;
	}

	@Override
	public int removeEvent(Long eventId) throws EAException {
		// TODO Auto-generated method stub

		AuctionEvent auctionEvent = eventRepository.findByDeleteFlag(0);
		if (auctionEvent == null) {
			throw new EAException("Event Not Found");
		} else
			auctionEvent.setDeleteFlag(1);
		logger.info("Event deleted:" + auctionEvent);
		logger.info("Created by: " + auctionEvent.getCreatedBy() + ", created on: " + auctionEvent.getCreationDate()
				+ ", modified by: " + auctionEvent.getLastModifiedBy() + ", modified on: "
				+ auctionEvent.getLastModifiedDate());

		return 1;
	}

	@Override
	public List<AuctionEvent> viewAllEvents() {
		// TODO Auto-generated method stub
		return eventRepository.findAllByDeleteFlag(0);
	}
	
	
	
	@Override
	public List<AuctionItem> viewAllItemsInEvent(Long eventId) {
		// TODO Auto-generated method stub
		
			
		
		return eventRepository.findByEventIdAndDeleteFlag(eventId, 0).getItemList();
		
		
	}

	/*******Item**********/

	@Override
	public AuctionItem addItem(AuctionItem auctionItem, Long eventId) throws EAException {
		// TODO Auto-generated method stub
		auctionItem.setDeleteFlag(0);

		
		auctionItem.setAuctionEvent(eventRepository.findByEventIdAndDeleteFlag(eventId, 0));

		auctionItem.setSoldFlag(0);
		AuctionItem saveItem = itemRepository.save(auctionItem);
		if (saveItem == null) {
			throw new EAException("Item Not Found");
		}
		logger.info("Item saved:" + saveItem);
		logger.info("Created by: " + saveItem.getCreatedBy() + ", created on: " + saveItem.getCreationDate()
				+ ", modified by: " + saveItem.getLastModifiedBy() + ", modified on: "
				+ saveItem.getLastModifiedDate());

		return saveItem;
	}

	@Override
	public AuctionItem updateItem(AuctionItem auctionItem) throws EAException {
		// TODO Auto-generated method stub

		AuctionItem modifyItem = itemRepository.findByItemIdAndDeleteFlag(auctionItem.getItemId(), 0);
		if (modifyItem == null) {
			logger.error("Item Not Found");
			throw new EAException("Item Not Found");
		} else if (modifyItem.getSoldFlag() == 1) {
			logger.error("Item Not Updatable");
			throw new EAException("Item is not updatable");
		} else {
			modifyItem.setItemName(auctionItem.getItemName());
			modifyItem.setInitPrice(auctionItem.getInitPrice());
			modifyItem.setAuctionEvent(auctionItem.getAuctionEvent());

		}

		logger.info("Item modified:" + modifyItem);
		logger.info("Created by: " + modifyItem.getCreatedBy() + ", created on: " + modifyItem.getCreationDate()
				+ ", modified by: " + modifyItem.getLastModifiedBy() + ", modified on: "
				+ modifyItem.getLastModifiedDate());

		return modifyItem;
	}

	@Override
	public int removeItem(Long itemId) throws EAException {
		// TODO Auto-generated method stub
		AuctionItem auctionItem = itemRepository.findByItemIdAndDeleteFlag(itemId, 0);
		if (auctionItem == null) {
			throw new EAException("Item Not Found");
		} else
			auctionItem.setDeleteFlag(1);
		logger.info("Item deleted:" + auctionItem);
		logger.info("Created by: " + auctionItem.getCreatedBy() + ", created on: " + auctionItem.getCreationDate()
				+ ", modified by: " + auctionItem.getLastModifiedBy() + ", modified on: "
				+ auctionItem.getLastModifiedDate());

		return 1;
	}

	@Override
	public List<AuctionItem> viewAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findByDeleteFlag(0);
	}
	
	
	@Override
	public int addItemToEvent(Long itemId, Long eventId) throws EAException {
		// TODO Auto-generated method stub
		AuctionEvent saveAuctionEvent = eventRepository.findByEventIdAndDeleteFlag(eventId, 0);
		if (saveAuctionEvent == null) {
			throw new EAException("Event not found");
		} else {
			AuctionItem saveAuctionItem = itemRepository.findByItemIdAndDeleteFlag(itemId, 0);
			if (saveAuctionItem == null) {
				throw new EAException("Item not found");
			} else {
				if(saveAuctionItem.getAuctionEvent()!=null)
				{
					logger.error("Item already present in an event");
					throw new EAException("Item already present in an event");
				}
				
				List<AuctionItem> itemList = saveAuctionEvent.getItemList();
				itemList.add(saveAuctionItem);
				saveAuctionEvent.setItemList(itemList);
				
				eventRepository.save(saveAuctionEvent);
				saveAuctionItem.setAuctionEvent(saveAuctionItem.getAuctionEvent());
				itemRepository.save(saveAuctionItem);
				logger.info("Item :" + saveAuctionItem + ", added to event: " + saveAuctionEvent);
				logger.info("Created by: " + saveAuctionItem.getCreatedBy() + ", created on: "
						+ saveAuctionItem.getCreationDate() + ", modified by: " + saveAuctionItem.getLastModifiedBy()
						+ ", modified on: " + saveAuctionItem.getLastModifiedDate());

			}
		}

		return 1;
	}
	
	
	/*******User**********/

	@Override
	public User addUser(User user) throws EAException {
		// TODO Auto-generated method stub
		if(user.getUserType()=='C')
		{
			user.setRoles("ROLE_CUSTOMER");
		}
		else
		{
			user.setRoles("ROLE_ADMIN");
		}
		user.setActive(true);
		if(userRepository.save(user)==null)
		{
			logger.error("User Not Added");
			throw new EAException("User Not Added");
		}
		logger.info("User saved: " +user);
		
		
		return user;
	}

	@Override
	public List<User> viewAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findByActive(true);
	}

	@Override
	public int removeUser(Long userId) throws EAException {
		// TODO Auto-generated method stub
		User saveUser = userRepository.findByUserIdAndActive(userId, true);
		if (saveUser == null) {
			throw new EAException("User Not Found");
		} else
			saveUser.setActive(false);
		logger.info("User deleted:" + saveUser);
		

		return 1;
	}

}
