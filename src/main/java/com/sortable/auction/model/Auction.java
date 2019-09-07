package com.sortable.auction.model;

import java.util.List;

public class Auction {
 private final String site;
 private final List<String> units;
 
 
public Auction(String site, List<String> units) {
	super();
	this.site = site;
	this.units = units;
}

public String getSite() {
	return site;
}
public List<String> getUnits() {
	return units;
}
 
 
}
