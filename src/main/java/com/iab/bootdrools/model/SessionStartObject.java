package com.iab.bootdrools.model;

public class SessionStartObject {

	// {"adSessionId":"B9F5ACC3-0C15-4147-B137-3AB3C296CE61","timestamp":1669047658904,"type":"sessionStart","data":{"context":{"apiVersion":"1.0","accessMode":"limited","environment":"app","omidJsInfo":{"omidImplementer":"omsdk","serviceVersion":"1.4.2-iab3703"},"omidNativeInfo":{"partnerName":"Adsbynimbus","partnerVersion":"2.1.2"},"app":{"appId":"com.adsbynimbus.ios.NimbusDemo","libraryVersion":"1.4.2-Adsbynimbus"},"supports":["clid","vlid"],"deviceCategory":"mobile","adSessionType":"native","deviceInfo":{"deviceType":"iPhone12,1","os":"iOS","osVersion":"16.0"},"canMeasureVisibility":true},"impressionType":"onePixel","mediaType":"display","creativeType":"nativeDisplay","lastActivity":{"timestamp":1669047619436},"supportsLoadedEvent":true,"pageUrl":null,"contentUrl":null,"verificationParameters":"iabtechlab-Adsbynimbus"}}

	private String id;

	private String adSessionId;
	private int adSessionIdLength;
	private String adSessionIdExists;
	private String partner;
	private String accessMode;
	private String apiVersion;
	private String adSessionType;
	private String mediaType;

	private String creativeType;
	private String appId;
	private String libraryVersion;
	private String platform;
	private String deviceType;
	private String platformVersion;
	private String type;
	private String timestamp;
	private String verificationParameters;
	private String environment;
	private String partnerVersion;
	private String partnerName;
	private String serviceVersion;
	private String omidImplementer;
	private String os;
	private String osVersion;
	private String impressionType;
	private boolean	supportsLoadedEvent;
	private String pageUrl;
	private String contentUrl;
	private String[] supports;
	

	public SessionStartObject(String adSessionId, int adSessionIdLength, String adSessionIdExists, String partner,
			String accessMode, String apiVersion, String adSessionType, String mediaType, String creativeType,
			String appId, String libraryVersion, String platform, String deviceType, String platformVersion,
			String type, String timestamp, String verificationParameters , String environment ,String partnerVersion,String partnerName ,String serviceVersion,String omidImplementer,String os,String osVersion, String impressionType,Boolean supportsLoadedEvent, String pageUrl, String contentUrl,String[] supports) {
		super();
		this.adSessionId = adSessionId;
		this.adSessionIdLength = adSessionIdLength;
		this.adSessionIdExists = adSessionIdExists;
		this.partner = partner;
		this.accessMode = accessMode;
		this.apiVersion = apiVersion;
		this.adSessionType = adSessionType;
		this.mediaType = mediaType;
		this.creativeType = creativeType;
		this.appId = appId;
		this.libraryVersion = libraryVersion;
		this.platform = platform;
		this.deviceType = deviceType;
		this.platformVersion = platformVersion;
		this.type = type;
		this.timestamp = timestamp;
		this.verificationParameters = verificationParameters;
		this.environment = environment;
		this.partnerName = partnerName;
		this.partnerVersion = partnerVersion;
		this.serviceVersion = serviceVersion;
		this.omidImplementer = omidImplementer;
		this.os = os;
		this.osVersion = osVersion;
		this.impressionType = impressionType;
		this.supportsLoadedEvent = supportsLoadedEvent;
		this.pageUrl = pageUrl;
		this.contentUrl = contentUrl;
		this.supports = supports;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAdSessionIdLength() {
		return adSessionIdLength;
	}

	public void setAdSessionIdLength(int adSessionIdLength) {
		this.adSessionIdLength = adSessionIdLength;
	}

	public String getAdSessionId() {
		return adSessionId;
	}

	public void setAdSessionId(String adSessionId) {
		this.adSessionId = adSessionId;
	}

	public String getAccessMode() {
		return accessMode;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getVerificationParameters() {
		return verificationParameters;
	}

	public void setVerificationParameters(String verificationParameters) {
		this.verificationParameters = verificationParameters;
	}

	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	public String getAdSessionIdExists() {
		return adSessionIdExists;
	}

	public void setAdSessionIdExists(String adSessionIdExists) {
		this.adSessionIdExists = adSessionIdExists;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAdSessionType() {
		return adSessionType;
	}

	public void setAdSessionType(String adSessionType) {
		this.adSessionType = adSessionType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getLibraryVersion() {
		return libraryVersion;
	}

	public void setLibraryVersion(String libraryVersion) {
		this.libraryVersion = libraryVersion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getCreativeType() {
		return creativeType;
	}

	public void setCreativeType(String creativeType) {
		this.creativeType = creativeType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPartnerVersion() {
		return partnerVersion;
	}

	public void setPartnerVersion(String partnerVersion) {
		this.partnerVersion = partnerVersion;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
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

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getImpressionType() {
		return impressionType;
	}

	public void setImpressionType(String impressionType) {
		this.impressionType = impressionType;
	}

	public boolean isSupportsLoadedEvent() {
		return supportsLoadedEvent;
	}

	public void setSupportsLoadedEvent(boolean supportsLoadedEvent) {
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

	public String[] getSupports() {
		return supports;
	}

	public void setSupports(String[] supports) {
		this.supports = supports;
	}
	
}
