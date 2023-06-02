package com.iab.bootdrools.model;

public class SessionFinishResult {

	private String adSessionId;
	private String eventType;
	private QueryData queryData;
	private String timestamp;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public QueryData getQueryData() {
		return queryData;
	}

	public void setQueryData(QueryData queryData) {
		this.queryData = queryData;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getAdSessionId() {
		return adSessionId;
	}

	public void setAdSessionId(String adSessionId) {
		this.adSessionId = adSessionId;
	}

}
