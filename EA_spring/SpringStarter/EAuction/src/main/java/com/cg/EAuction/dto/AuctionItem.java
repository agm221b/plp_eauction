package com.cg.EAuction.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

@Entity
@Component("auctionitem")
@Table(name = "auctionitem")
public class AuctionItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long itemId;
	@Column(name = "item_name")
	@Size(min=3, max=20, message = "Name should be between 3-20 characters")
	private String itemName;
	@Column(name = "init_price")
	private Double initPrice;
	@Column(name = "current_price")
	private Double currentPrice;
	
	@Column(name = "current_bidder")
	@ManyToOne
	private User currentBidder;
	
	@Column(name = "final_price")
	private Double finalPrice;
	@Column(name = "final_owner")
	private String finalOwner;
	@Column(name = "sold_flag")
	private Integer soldFlag;
	
	@Column(name = "auction_event")
	@ManyToOne
	private AuctionEvent auctionEvent;
	
	@Column(name = "delete_flag")
	private Integer deleteFlag;
	
	@CreatedBy
    protected String createdBy;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDate;
    @LastModifiedBy
    protected String lastModifiedBy;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
	public AuctionItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuctionItem(Long itemId,
			@Size(min = 3, max = 20, message = "Name should be between 3-20 characters") String itemName,
			Double initPrice, Double currentPrice, User currentBidder, Double finalPrice, String finalOwner,
			Integer soldFlag, AuctionEvent auctionEvent, Integer deleteFlag) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.initPrice = initPrice;
		this.currentPrice = currentPrice;
		this.currentBidder = currentBidder;
		this.finalPrice = finalPrice;
		this.finalOwner = finalOwner;
		this.soldFlag = soldFlag;
		this.auctionEvent = auctionEvent;
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "AuctionItem [itemId=" + itemId + ", itemName=" + itemName + ", initPrice=" + initPrice
				+ ", currentPrice=" + currentPrice + ", currentBidder=" + currentBidder + ", finalPrice=" + finalPrice
				+ ", finalOwner=" + finalOwner + ", soldFlag=" + soldFlag + ", auctionEvent=" + auctionEvent
				+ ", deleteFlag=" + deleteFlag + "]";
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getInitPrice() {
		return initPrice;
	}
	public void setInitPrice(Double initPrice) {
		this.initPrice = initPrice;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public User getCurrentBidder() {
		return currentBidder;
	}
	public void setCurrentBidder(User currentBidder) {
		this.currentBidder = currentBidder;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getFinalOwner() {
		return finalOwner;
	}
	public void setFinalOwner(String finalOwner) {
		this.finalOwner = finalOwner;
	}
	public Integer getSoldFlag() {
		return soldFlag;
	}
	public void setSoldFlag(Integer soldFlag) {
		this.soldFlag = soldFlag;
	}
	public AuctionEvent getAuctionEvent() {
		return auctionEvent;
	}
	public void setAuctionEvent(AuctionEvent auctionEvent) {
		this.auctionEvent = auctionEvent;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
    
    
    

}
