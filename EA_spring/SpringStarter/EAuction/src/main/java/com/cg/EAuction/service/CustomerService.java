package com.cg.EAuction.service;

import java.util.List;

import com.cg.EAuction.EAException;
import com.cg.EAuction.dto.AuctionEvent;
import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;

public interface CustomerService {
	
	public int requestBid(AuctionItem auctionItem, Double currentPrice, User currentBidder) throws EAException;
	
	public List<AuctionItem> viewUserItemList(Long userId) throws EAException;
	
	public int completePayment(Long itemId, String paymentType) throws EAException;
	
	public List<AuctionEvent> viewEventList();
}
