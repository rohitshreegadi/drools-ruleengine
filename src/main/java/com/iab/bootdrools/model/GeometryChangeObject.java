package com.iab.bootdrools.model;

public class GeometryChangeObject {

	/*"reasons": [],
    "declaredFriendlyObstructions": 0,
    "onScreenGeometrypixels": 285660,
    "adSessionId": "B9F5ACC3-0C15-4147-B137-3AB3C296CE61",
    "onScreenGeometryheight": 690,
    "type": "geometryChange",
    "onScreenGeometryfriendlyObstructions": [],
    "pixelsInView": 285660,
    "geometrywidth": 414,
    "width": 414,
    "geometrypixels": 285660,
    "geometryheight": 690,
    "onScreenGeometryobstructions": [],
    "onScreenGeometryx": 0,
    "onScreenGeometryy": 172,
    "percentageInView": 100,
    "geometryy": 172,
    "onScreenGeometrywidth": 414,
    "geometryx": 0,
    "timestamp": 1669047662685,
    "height": 896*/
	



	private String type;//done
	private String adSessionId;//done
	private String width;//done
	private String height;//done
	private String percentageInView;//done
	private String onScreenGeometrypixels;//done
	private String onScreenGeometryheight;//Done
	private String onScreenGeometrywidth;//Done
	private String pixelsInView;//Done
	private String geometrywidth;//Done
	private String geometryheight;//Done
	private String geometrypixels;//Done
//	private String onScreenGeometryobstructions;
	private String onScreenGeometryx;//Done
	private String onScreenGeometryy;//DOne
	private String geometryy;
	private String geometryx;
	private String timestamp;
//	private String onScreenGeometryfriendlyObstructions;
	
	public GeometryChangeObject(String type, String adSessionId, String width, String height, String percentageInView,
			String onScreenGeometrypixels, String onScreenGeometryheight, String onScreenGeometrywidth,
			String pixelsInView, String geometrywidth, String geometryheight, String geometrypixels,
			 String onScreenGeometryx, String onScreenGeometryy, String geometryy,
			String geometryx, String timestamp) {
		super();
		this.type = type;
		this.adSessionId = adSessionId;
		this.width = width;
		this.height = height;
		this.percentageInView = percentageInView;
		this.onScreenGeometrypixels = onScreenGeometrypixels;
		this.onScreenGeometryheight = onScreenGeometryheight;
		this.onScreenGeometrywidth = onScreenGeometrywidth;
		this.pixelsInView = pixelsInView;
		this.geometrywidth = geometrywidth;
		this.geometryheight = geometryheight;
		this.geometrypixels = geometrypixels;
//		this.onScreenGeometryobstructions = onScreenGeometryobstructions;
		this.onScreenGeometryx = onScreenGeometryx;
		this.onScreenGeometryy = onScreenGeometryy;
		this.geometryy = geometryy;
		this.geometryx = geometryx;
		this.timestamp = timestamp;
//		this.onScreenGeometryfriendlyObstructions = onScreenGeometryfriendlyObstructions;
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

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPercentageInView() {
		return percentageInView;
	}

	public void setPercentageInView(String percentageInView) {
		this.percentageInView = percentageInView;
	}

	public String getOnScreenGeometrypixels() {
		return onScreenGeometrypixels;
	}

	public void setOnScreenGeometrypixels(String onScreenGeometrypixels) {
		this.onScreenGeometrypixels = onScreenGeometrypixels;
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

//	public String getOnScreenGeometryobstructions() {
//		return onScreenGeometryobstructions;
//	}
//
//	public void setOnScreenGeometryobstructions(String onScreenGeometryobstructions) {
//		this.onScreenGeometryobstructions = onScreenGeometryobstructions;
//	}

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

	public String getGeometryy() {
		return geometryy;
	}

	public void setGeometryy(String geometryy) {
		this.geometryy = geometryy;
	}

	public String getGeometryx() {
		return geometryx;
	}

	public void setGeometryx(String geometryx) {
		this.geometryx = geometryx;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	


}