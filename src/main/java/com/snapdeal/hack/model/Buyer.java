package com.snapdeal.hack.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Buyer implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2005576387673890377L;


	
	private String name = StringUtils.EMPTY;
	private String fbId = StringUtils.EMPTY;
	private String emailId = StringUtils.EMPTY;
	private String lastUpdateWithFB = StringUtils.EMPTY;
	private String imageUrl = StringUtils.EMPTY;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLastUpdateWithFB() {
		return lastUpdateWithFB;
	}
	public void setLastUpdateWithFB(String lastUpdate) {
		lastUpdateWithFB = lastUpdate;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Buyer() {
		
	}
	
	public boolean isValid() {
		boolean isValid = true;

		if(StringUtils.isBlank(name) || StringUtils.isBlank(fbId) || 
		   StringUtils.isBlank(imageUrl)) {
			isValid = false;
		}
	
		return isValid;
	}

}
