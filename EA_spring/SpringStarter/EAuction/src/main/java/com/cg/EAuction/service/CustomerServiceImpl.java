package com.cg.EAuction.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dao.EventRepository;
import com.cg.EAuction.dao.ItemRepository;
import com.cg.EAuction.dao.UserRepository;
import com.cg.EAuction.dto.AuctionEvent;
import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;

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
	public List<AuctionItem> viewUserItemList(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int completePayment() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuctionEvent> viewEventList() {
		// TODO Auto-generated method stub
		return null;
	}

}
