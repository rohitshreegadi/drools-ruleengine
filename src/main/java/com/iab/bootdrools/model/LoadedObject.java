package com.iab.bootdrools.model;

public class LoadedObject {

	private String id;
	private String type;
	private String creativeType;
	private String mediaType;
	private String impressionType;
	private String adSessionId;
	private String timestamp;
	public LoadedObject(String type, String creativeType, String mediaType, String impressionType,String adSessionId,String timestamp) {
		super();
		this.type = type;
		this.creativeType = creativeType;
		this.mediaType = mediaType;
		this.impressionType = impressionType;
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
	public String getCreativeType() {
		return creativeType;
	}
	public void setCreativeType(String creativeType) {
		this.creativeType = creativeType;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getImpressionType() {
		return impressionType;
	}
	public void setImpressionType(String impressionType) {
		this.impressionType = impressionType;
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
