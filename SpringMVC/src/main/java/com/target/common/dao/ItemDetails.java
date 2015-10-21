package com.target.common.dao;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetails {
	private Long id;
	private String partNumber;
	private Double mapPrice;
	private String ppu;
	private String soiFlag;
	private String mapPriceFlag;	
	private Date lastUpdate;
	private Price listPrice;
	private Price offerPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Double getMapPrice() {
		return mapPrice;
	}

	public void setMapPrice(Double mapPrice) {
		this.mapPrice = mapPrice;
	}

	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getSoiFlag() {
		return soiFlag;
	}

	public void setSoiFlag(String soiFlag) {
		this.soiFlag = soiFlag;
	}

	public String getMapPriceFlag() {
		return mapPriceFlag;
	}

	public void setMapPriceFlag(String mapPriceFlag) {
		this.mapPriceFlag = mapPriceFlag;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Price getListPrice() {
		return listPrice;
	}

	public void setListPrice(Price listPrice) {
		this.listPrice = listPrice;
	}

	public Price getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Price offerPrice) {
		this.offerPrice = offerPrice;
	}

}
