package com.iab.bootdrools.model;

import java.util.Map;

public class QueryData {
	private String query;
	private int count;
	private Map<String,String> errorMessage;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Map<String, String> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Map<String, String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
