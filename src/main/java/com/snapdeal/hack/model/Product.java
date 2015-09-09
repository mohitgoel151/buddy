package com.snapdeal.hack.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1218494147347080302L;
	private String supcCode = StringUtils.EMPTY;
	private String category = StringUtils.EMPTY;
	private String title = StringUtils.EMPTY;
	private String detailedPageUrl = StringUtils.EMPTY;
	private String image = StringUtils.EMPTY;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product() {
		
	}
	
	public String getSupcCode() {
		return supcCode;
	}

	public void setSupcCode(String supcCode) {
		this.supcCode = supcCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailedPageUrl() {
		return detailedPageUrl;
	}

	public void setDetailedPageUrl(String detailedPageUrl) {
		this.detailedPageUrl = detailedPageUrl;
	}
	
	public boolean isValid() {
		boolean isValid = true;

		if(StringUtils.isBlank(supcCode) || StringUtils.isBlank(category) || 
		   StringUtils.isBlank(title) || StringUtils.isBlank(detailedPageUrl)) {
			isValid = false;
		}
	
		return isValid;
	}
}
