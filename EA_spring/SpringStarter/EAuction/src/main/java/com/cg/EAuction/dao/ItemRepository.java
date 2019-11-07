package com.cg.EAuction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EAuction.dto.AuctionItem;
import com.cg.EAuction.dto.User;

public interface ItemRepository extends JpaRepository<AuctionItem, Integer> {

	
	public List<AuctionItem> findByDeleteFlag(Integer deleteFlag);
	
	public List<AuctionItem> findByFinalOwnerAndDeleteFlag(User finalOwner, Integer deleteFlag);
	
	public AuctionItem findByItemIdAndDeleteFlag(Long itemId, Integer deleteFlag);

}
