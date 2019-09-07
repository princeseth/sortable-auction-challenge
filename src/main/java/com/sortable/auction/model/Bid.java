package com.sortable.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bid {
 String bidder;
 String unit;
 private double bid;
 private double finalBidValue;
 
@JsonIgnore
public double getFinalBidValue() {
	return finalBidValue;
}
public void setFinalBidValue(double finalBidValue) {
	this.finalBidValue = finalBidValue;
}
public String getBidder() {
	return bidder;
}
public void setBidder(String bidder) {
	this.bidder = bidder;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public double getBid() {
	return bid;
}
public void setBid(double bid) {
	this.bid = bid;
}
 
public Bid(String bidder, String unit, double bid) {
	this.bidder = bidder;
	this.unit = unit;
	this.bid = bid;
}

public Bid() {
	
}
@Override
public String toString() {
	return "Bid [bidder=" + bidder + ", unit=" + unit + ", bid=" + bid + "]";
}

}
