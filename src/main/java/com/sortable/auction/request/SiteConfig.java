package com.sortable.auction.request;

import java.util.List;

public class SiteConfig {
 
	private String name;
	private Double floor;
	private List<String> units;
	private List<String> bidders;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFloor() {
		return floor;
	}
	public void setFloor(Double floor) {
		this.floor = floor;
	}
	public List<String> getBidders() {
		return bidders;
	}
	public void setBidder(List<String> bidder) {
		this.bidders = bidder;
	}
	
	public List<String> getUnits() {
		return units;
	}
	public void setUnits(List<String> units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "Site [name=" + name + ", floor=" + floor + ", units=" + units + ", bidders=" + bidders + "]";
	}
	
}
