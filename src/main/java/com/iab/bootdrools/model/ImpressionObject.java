package com.iab.bootdrools.model;

public class ImpressionObject {

	private String id;
	private String adSessionId;
	private String type;
	private String mediaType;
	
	private String onScreenGeometryheight;
	private String onScreenGeometrywidth;
	private String pixelsInView;
	private String creativeType;
	private String geometrywidth;
	private String geometryheight;
	private String geometrypixels;
	private String height;
	private String width;
	private String onScreenGeometryx;
	private String onScreenGeometryy;
	private String geometryx;
	private String geometryy;
	private String percentageInView;
	private String impressionType;
	private String timestamp;
	private String declaredFriendlyObstructions;
	private String onScreenGeometryPixels;
	public ImpressionObject(String adSessionId, String type, String mediaType, 
			String onScreenGeometryheight, String onScreenGeometrywidth, String pixelsInView, String creativeType,
			String geometrywidth, String geometryheight, String geometrypixels, String height, String width,
			String onScreenGeometryx, String onScreenGeometryy, String geometryx, String geometryy,
			String percentageInView, String impressionType, String timestamp, String declaredFriendlyObstructions,String onScreenGeometryPixels) {
		super();
		this.adSessionId = adSessionId;
		this.type = type;
		this.mediaType = mediaType;
		this.onScreenGeometryheight = onScreenGeometryheight;
		this.onScreenGeometrywidth = onScreenGeometrywidth;
		this.pixelsInView = pixelsInView;
		this.creativeType = creativeType;
		this.geometrywidth = geometrywidth;
		this.geometryheight = geometryheight;
		this.geometrypixels = geometrypixels;
		this.height = height;
		this.width = width;
		this.onScreenGeometryx = onScreenGeometryx;
		this.onScreenGeometryy = onScreenGeometryy;
		this.geometryx = geometryx;
		this.geometryy = geometryy;
		this.percentageInView = percentageInView;
		this.impressionType = impressionType;
		this.timestamp = timestamp;
		this.declaredFriendlyObstructions = declaredFriendlyObstructions;
		this.onScreenGeometryPixels = onScreenGeometryPixels;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdSessionId() {
		return adSessionId;
	}
	public void setAdSessionId(String adSessionId) {
		this.adSessionId = adSessionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getOnScreenGeometryheight() {
		return onScreenGeometryheight;
	}
	public void setOnScreenGeometryheight(String onScreenGeometryheight) {
		this.onScreenGeometryheight = onScreenGeometryheight;
	}
	public String getOnScreenGeometrywidth() {
		return onScreenGeometrywidth;
	}
	public void setOnScreenGeometrywidth(String onScreenGeometrywidth) {
		this.onScreenGeometrywidth = onScreenGeometrywidth;
	}
	public String getPixelsInView() {
		return pixelsInView;
	}
	public void setPixelsInView(String pixelsInView) {
		this.pixelsInView = pixelsInView;
	}
	public String getCreativeType() {
		return creativeType;
	}
	public void setCreativeType(String creativeType) {
		this.creativeType = creativeType;
	}
	public String getGeometrywidth() {
		return geometrywidth;
	}
	public void setGeometrywidth(String geometrywidth) {
		this.geometrywidth = geometrywidth;
	}
	public String getGeometryheight() {
		return geometryheight;
	}
	public void setGeometryheight(String geometryheight) {
		this.geometryheight = geometryheight;
	}
	public String getGeometrypixels() {
		return geometrypixels;
	}
	public void setGeometrypixels(String geometrypixels) {
		this.geometrypixels = geometrypixels;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getOnScreenGeometryx() {
		return onScreenGeometryx;
	}
	public void setOnScreenGeometryx(String onScreenGeometryx) {
		this.onScreenGeometryx = onScreenGeometryx;
	}
	public String getOnScreenGeometryy() {
		return onScreenGeometryy;
	}
	public void setOnScreenGeometryy(String onScreenGeometryy) {
		this.onScreenGeometryy = onScreenGeometryy;
	}
	public String getGeometryx() {
		return geometryx;
	}
	public void setGeometryx(String geometryx) {
		this.geometryx = geometryx;
	}
	public String getGeometryy() {
		return geometryy;
	}
	public void setGeometryy(String geometryy) {
		this.geometryy = geometryy;
	}
	public String getPercentageInView() {
		return percentageInView;
	}
	public void setPercentageInView(String percentageInView) {
		this.percentageInView = percentageInView;
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
	public String getDeclaredFriendlyObstructions() {
		return declaredFriendlyObstructions;
	}
	public void setDeclaredFriendlyObstructions(String declaredFriendlyObstructions) {
		this.declaredFriendlyObstructions = declaredFriendlyObstructions;
	}
	public String getOnScreenGeometryPixels() {
		return onScreenGeometryPixels;
	}
	public void setOnScreenGeometryPixels(String onScreenGeometryPixels) {
		this.onScreenGeometryPixels = onScreenGeometryPixels;
	}
		
}
