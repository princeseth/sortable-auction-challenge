package com.sortable.auction.request;

import java.util.List;

public class Config {

	private List<SiteConfig> sites;
	private List<BidderConfig> bidders;
	
	public List<SiteConfig> getSites() {
		return sites;
	}
	public void setSites(List<SiteConfig> sites) {
		this.sites = sites;
	}
	public List<BidderConfig> getBidders() {
		return bidders;
	}
	public void setBidders(List<BidderConfig> bidders) {
		this.bidders = bidders;
	}
	@Override
	public String toString() {
		return "Config [sites=" + sites + ", bidders=" + bidders + "]";
	}
	
	
}
