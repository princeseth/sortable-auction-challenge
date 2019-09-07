package com.sortable.auction.service;

import java.util.List;

import com.sortable.auction.request.Config;
import com.sortable.auction.request.InputConfig;

public interface ConfigService {

	Config readConfigData(); 
	
	List<InputConfig> readInputData();
	
}
