package com.sortable.auction.service;

import java.util.Collection;
import java.util.Optional;

import com.sortable.auction.model.Bid;
import com.sortable.auction.request.Config;
import com.sortable.auction.request.InputConfig;

public interface AuctionService {
	
	Collection<Optional<Bid>> getAuctionResult( Config config, InputConfig inputConfig);
}
