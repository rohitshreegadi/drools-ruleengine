package com.iab.bootdrools.model;

/**
 * @author rohit.shreegadi
 *
 */
public class SessionStartResult {

	private String adSessionIdExists;
	private String adSessionTypeExists;
	private String accessModeExists;
	private String mediaTypeExists;
	private String creativeTypeExists;
	private String verificationParametersExists;
	private String environmentExists;
	private String omidNativeInfoExists;  //Remove AND condition from Excel and take the separate values for each value 
	private String omidJsInfoExists;      //Remove AND condition from Excel and take the separate values for each value 
	private String appExists;				//Remove AND condition from Excel and take the separate values for each value 
	private String deviceInfoExists;		//Remove AND condition from Excel and take the separate values for each value 
	private String adLoadedExists;				//Remove AND condition from Excel and take the separate values for each value 
	private String supportsLoadedEventExists;
	private String pageUrlExists;
	private String contentUrlExists;

	public String getAdSessionIdExists() {
		return adSessionIdExists;
	}

	public void setAdSessionIdExists(String adSessionIdExists) {
		this.adSessionIdExists = adSessionIdExists;
	}

	public String getAdSessionTypeExists() {
		return adSessionTypeExists;
	}

	public void setAdSessionTypeExists(String adSessionTypeExists) {
		this.adSessionTypeExists = adSessionTypeExists;
	}

	public String getAccessModeExists() {
		return accessModeExists;
	}

	public void setAccessModeExists(String accessModeExists) {
		this.accessModeExists = accessModeExists;
	}

	public String getMediaTypeExists() {
		return mediaTypeExists;
	}

	public void setMediaTypeExists(String mediaTypeExists) {
		this.mediaTypeExists = mediaTypeExists;
	}

	public String getCreativeTypeExists() {
		return creativeTypeExists;
	}

	public void setCreativeTypeExists(String creativeTypeExists) {
		this.creativeTypeExists = creativeTypeExists;
	}

	public String getVerificationParametersExists() {
		return verificationParametersExists;
	}

	public void setVerificationParametersExists(String verificationParametersExists) {
		this.verificationParametersExists = verificationParametersExists;
	}

	public String getEnvironmentExists() {
		return environmentExists;
	}

	public void setEnvironmentExists(String environmentExists) {
		this.environmentExists = environmentExists;
	}

	public String getOmidNativeInfoExists() {
		return omidNativeInfoExists;
	}

	public void setOmidNativeInfoExists(String omidNativeInfoExists) {
		this.omidNativeInfoExists = omidNativeInfoExists;
	}

	public String getOmidJsInfoExists() {
		return omidJsInfoExists;
	}

	public void setOmidJsInfoExists(String omidJsInfoExists) {
		this.omidJsInfoExists = omidJsInfoExists;
	}

	public String getAppExists() {
		return appExists;
	}

	public void setAppExists(String appExists) {
		this.appExists = appExists;
	}

	public String getDeviceInfoExists() {
		return deviceInfoExists;
	}

	public void setDeviceInfoExists(String deviceInfoExists) {
		this.deviceInfoExists = deviceInfoExists;
	}

	public String getAdLoadedExists() {
		return adLoadedExists;
	}

	public void setAdLoadedExists(String adLoadedExists) {
		this.adLoadedExists = adLoadedExists;
	}

	public String getSupportsLoadedEventExists() {
		return supportsLoadedEventExists;
	}

	public void setSupportsLoadedEventExists(String supportsLoadedEventExists) {
		this.supportsLoadedEventExists = supportsLoadedEventExists;
	}

	public String getPageUrlExists() {
		return pageUrlExists;
	}

	public void setPageUrlExists(String pageUrlExists) {
		this.pageUrlExists = pageUrlExists;
	}

	public String getContentUrlExists() {
		return contentUrlExists;
	}

	public void setContentUrlExists(String contentUrlExists) {
		this.contentUrlExists = contentUrlExists;
	}

	}
