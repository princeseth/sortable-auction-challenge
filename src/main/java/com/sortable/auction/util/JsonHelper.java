package com.sortable.auction.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sortable.auction.request.InputConfig;

@Component
public class JsonHelper {

	@Autowired
	private ObjectMapper objectMapper;	

	public <T> T fromJson(String json, TypeReference<List<InputConfig>> typeReference) throws Exception {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public <T> T fromJson(String json, Class<T> clazz) throws Exception {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw e;
		}
	}
}
