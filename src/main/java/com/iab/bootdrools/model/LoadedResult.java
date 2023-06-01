package com.iab.bootdrools.model;

public class LoadedResult {

	private String adSessionId;
	private String impressionType;
	private String mediaType;
	private String creativeType;
	private String eventType;
	private String timestamp;
	private QueryData queryData;
	
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

	public String getImpressionType() {
		return impressionType;
	}

	public void setImpressionType(String impressionType) {
		this.impressionType = impressionType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getCreativeType() {
		return creativeType;
	}

	public void setCreativeType(String creativeType) {
		this.creativeType = creativeType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
