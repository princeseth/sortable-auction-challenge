package com.sortable.auction.model;

public class Bidder {
	private final String name;
	private final Double adjustment;
	
	public Bidder(String name, Double adjustment) {		
		this.name = name;
		this.adjustment = adjustment;
	}
	
	public String getName() {
		return name;
	}
	public Double getAdjustment() {
		return adjustment;
	}
	
	
}
