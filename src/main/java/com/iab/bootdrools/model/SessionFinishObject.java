package com.iab.bootdrools.model;

public class SessionFinishObject {
	private String id;
	private String type;
	private String adSessionId;
	private String timestamp;
	public SessionFinishObject(String type, String adSessionId, String timestamp) {
		super();
		this.type = type;
		this.adSessionId = adSessionId;
		this.timestamp = timestamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdSessionId() {
		return adSessionId;
	}
	public void setAdSessionId(String adSessionId) {
		this.adSessionId = adSessionId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
