package com.sortable.auction.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sortable.auction.request.Config;
import com.sortable.auction.request.InputConfig;
import com.sortable.auction.service.ConfigService;
import com.sortable.auction.util.JsonHelper;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	JsonHelper jsonHelper;
	
	/*
	 *  @return configuration for auction, using config.json
	 */
	public Config readConfigData() {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try {
			FileReader reader = new FileReader("src/main/resources/config.json");

			Object obj = jsonParser.parse(reader);

			Config config = jsonHelper.fromJson(((JSONObject) obj).toJSONString(), Config.class);

			return config;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 *  @return configuration for Input bids, using input.json
	 */
	public List<InputConfig> readInputData() {

		JSONParser jsonParser = new JSONParser();

		try {
			FileReader reader = new FileReader("src/main/resources/input.json");

			Object obj = jsonParser.parse(reader);

			JSONArray inputList = (JSONArray) obj;

			List<InputConfig> inputConfig = jsonHelper.fromJson(inputList.toJSONString(),
					new TypeReference<List<InputConfig>>() {
					});

			return inputConfig;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
