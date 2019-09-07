package com.sortable.auction.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sortable.auction.model.Bid;
import com.sortable.auction.service.AuctionService;
import com.sortable.auction.service.ConfigService;

@RestController
public class AuctionController {

	@Autowired
	private AuctionService auctionService;

	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAuctionResults() throws Exception{
	
		Collection<Collection<Optional<Bid>>> winnerList =  new ArrayList< Collection<Optional<Bid>>>();
		
			configService.readInputData().forEach(inputConfig -> {
				winnerList.add((auctionService.getAuctionResult(configService.readConfigData(),inputConfig)));
			});				
		return ResponseEntity.ok(winnerList);
	}
}
