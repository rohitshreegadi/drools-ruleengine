package com.iab.bootdrools.model;

/**
 * @author rohit.shreegadi
 *
 */
public class SessionStartResult {

	private String adSessionId;
    private String adSessionType;
    private String accessMode;
    private String mediaType;
    private String creativeType;
    private String verificationParameters;
    private String environment;
    private String omidNativeInfo;  //Remove AND condition from Excel and take the separate values for each value 
    private String omidJsInfo;      //Remove AND condition from Excel and take the separate values for each value 
    private String app;                //Remove AND condition from Excel and take the separate values for each value 
    private String deviceInfo;        //Remove AND condition from Excel and take the separate values for each value 
    private String adLoaded;                //Remove AND condition from Excel and take the separate values for each value 
    private String supportsLoadedEvent;
    private String pageUrl;
    private String contentUrl;
    private String partnerName;
    private String partnerVersion;
    private String serviceVersion;
    private String omidImplementer;
    private String library;
    private String deviceType;
	private String osVersion;
	private String os;
	private String impressionType;
	private String eventType;
	private QueryData queryData;
	private String timestamp;
	
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
	public String getAdSessionType() {
		return adSessionType;
	}
	public void setAdSessionType(String adSessionType) {
		this.adSessionType = adSessionType;
	}
	public String getAccessMode() {
		return accessMode;
	}
	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
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
	public String getVerificationParameters() {
		return verificationParameters;
	}
	public void setVerificationParameters(String verificationParameters) {
		this.verificationParameters = verificationParameters;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getOmidNativeInfo() {
		return omidNativeInfo;
	}
	public void setOmidNativeInfo(String omidNativeInfo) {
		this.omidNativeInfo = omidNativeInfo;
	}
	public String getOmidJsInfo() {
		return omidJsInfo;
	}
	public void setOmidJsInfo(String omidJsInfo) {
		this.omidJsInfo = omidJsInfo;
	}

	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getAdLoaded() {
		return adLoaded;
	}
	public void setAdLoaded(String adLoaded) {
		this.adLoaded = adLoaded;
	}
	public String getSupportsLoadedEvent() {
		return supportsLoadedEvent;
	}
	public void setSupportsLoadedEvent(String supportsLoadedEvent) {
		this.supportsLoadedEvent = supportsLoadedEvent;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerVersion() {
		return partnerVersion;
	}
	public void setPartnerVersion(String partnerVersion) {
		this.partnerVersion = partnerVersion;
	}
	public String getServiceVersion() {
		return serviceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}
	public String getOmidImplementer() {
		return omidImplementer;
	}
	public void setOmidImplementer(String omidImplementer) {
		this.omidImplementer = omidImplementer;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getImpressionType() {
		return impressionType;
	}
	public void setImpressionType(String impressionType) {
		this.impressionType = impressionType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
		
	}
