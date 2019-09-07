package com.sortable.auction.request;

import java.util.List;

import com.sortable.auction.model.Bid;

public class InputConfig {
	private String site;
	private List<String> units;
	private List<Bid> bids;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<String> getUnits() {
		return units;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
