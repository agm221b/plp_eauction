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
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public int requestBid(AuctionItem auctionItem, Double currentPrice, User currentBidder) throws EAException {
		// TODO Auto-generated method stub
		AuctionItem saveAuctionItem = itemRepository.findByItemIdAndDeleteFlag(auctionItem.getItemId(), 0);
		if(saveAuctionItem==null) {
			logger.error("Item Not Found");
			throw new EAException("Item Not Found");
		}
		else
		{
			saveAuctionItem.setCurrentPrice(currentPrice);
			saveAuctionItem.setCurrentBidder(currentBidder);
			//itemRepository.save(saveAuctionItem);
		}
		return 0;
	}

	@Override
	public List<AuctionItem> viewUserItemList(Long userId) throws EAException {
		// TODO Auto-generated method stub
		User finalOwner = userRepository.findByUserIdAndActive(userId, true);
		if(finalOwner ==null) {
			logger.error("User doesn't exist");
			throw new EAException("User doesn't exist");
		}
		return itemRepository.findByFinalOwnerAndDeleteFlag(finalOwner, 0);
	}

	@Override
	public int completePayment(Long itemId, String paymentType) throws EAException {
		// TODO Auto-generated method stub
		AuctionItem saveItem = itemRepository.findByItemIdAndDeleteFlag(itemId, 0);
		if(saveItem==null) {
			logger.error("Item doesn't exist");
			throw new EAException("Item doesn't exist");
		}
		saveItem.setPaymentType(paymentType);		
		return 1;
	}

	@Override
	public List<AuctionEvent> viewEventList() {
		// TODO Auto-generated method stub
		return eventRepository.findAllByDeleteFlag(0);
	}

	@Override
	public Boolean checkBid(Long itemId) {
		// TODO Auto-generated method stub
		AuctionItem itemSave= itemRepository.findByItemIdAndDeleteFlag(itemId, 0);
		if(itemSave.getSoldFlag()!=2)
		{
			itemSave.setSoldFlag(2);
			itemSave.setCurrentPrice(itemSave.getInitPrice()+100);
			return true;
		}
		else
		return false;
	}

	@Override
	public Boolean checkLogin(String username, String pass) {
		// TODO Auto-generated method stub
		if(userRepository.findByUsernameAndPassAndActive(username, pass, true)!=null) {
			return true;
		}
		return false;	
	}

	@Override
	public User getRole(String username) {
		// TODO Auto-generated method stub
		User findUser = userRepository.findByUsernameAndActive(username, true);
		return findUser;
	}
	
	
	
	
	

}
