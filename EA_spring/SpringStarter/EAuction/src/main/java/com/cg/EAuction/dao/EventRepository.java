package com.cg.EAuction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EAuction.dto.AuctionEvent;

public interface EventRepository extends JpaRepository<AuctionEvent, Integer> {

	public List<AuctionEvent> findAllByDeleteFlag(Integer deleteFlag);
	
	public AuctionEvent findByDeleteFlag(Integer deleteFlag);
	
	public AuctionEvent findByEventIdAndDeleteFlag(Long eventId, Integer deleteFlag);
	
}
