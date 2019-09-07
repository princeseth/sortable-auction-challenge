package com.sortable.auction.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sortable.auction.model.Bid;
import com.sortable.auction.request.Config;
import com.sortable.auction.request.InputConfig;
import com.sortable.auction.request.SiteConfig;
import com.sortable.auction.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {

	/* @return List of winning {Bid}`s
	 * @param config - configuration for auction
	 * @param inputConfig - input configuration for bids placed
	 */
	public Collection<Optional<Bid>> getAuctionResult(Config config, InputConfig inputConfig) {

		Map<String, Optional<Bid>> winnerBids = new HashMap<String, Optional<Bid>>();

		// Comparator to compare bid Value
		Comparator<Bid> byBidValue = new Comparator<Bid>() {
			@Override
			public int compare(Bid e1, Bid e2) {
				if (e1.getFinalBidValue() < e2.getFinalBidValue()) {
					return -1;
				} else if (e1.getFinalBidValue() > e2.getFinalBidValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		/*
		 * Iterate over sites and if site is recognized find the winner of bids
		 */
		for (SiteConfig site : config.getSites()) {
			if (site.getName().equalsIgnoreCase(inputConfig.getSite())) {
				// Get list of Valid bids
				List<Bid> validBids = getValidBids(site, config, inputConfig);
				winnerBids = validBids.stream().collect(
						Collectors.groupingBy(Bid::getUnit, Collectors.reducing(BinaryOperator.maxBy(byBidValue))));

			}
		}

		return new ArrayList<Optional<Bid>>(winnerBids.values());

	}

	/* @return List of valid {Bid}`s
	 * @param siteConfig - configuration for sites
	 * @param config - configuration for auctions
	 * @param inputConfig - input configuration for bids placed
	 */
	private List<Bid> getValidBids(SiteConfig siteConfig, Config config, InputConfig inputConfig) {
		//Track valid bid
		List<Bid> validbidTracker = new ArrayList<Bid>();

		inputConfig.getBids().forEach(inputBid -> {
			// check bidder is known & bid is on allowed ad unit
			if (siteConfig.getBidders().contains(inputBid.getBidder())
					&& inputConfig.getUnits().contains(inputBid.getUnit())) {

				// Check bidder is allowed to bid
				config.getBidders().forEach(bidder -> {
					if (bidder.getName().equalsIgnoreCase(inputBid.getBidder())) {

						Double finalBid = inputBid.getBid() + (bidder.getAdjustment() * inputBid.getBid());
						
						// Adjusted bid should be greater than floor
						if (finalBid > siteConfig.getFloor()) {
							inputBid.setFinalBidValue(finalBid);
							validbidTracker.add(inputBid);
						}
					}
				});
			}
		});
		return validbidTracker;

	}

}