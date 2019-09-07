package com.sortable.auction.request;

public class BidderConfig {
	private String name;
	private Double adjustment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}
	
		@Override
	public String toString() {
		return "Bidder [name=" + name + ", adjustment=" + adjustment + "]";
	}
}
