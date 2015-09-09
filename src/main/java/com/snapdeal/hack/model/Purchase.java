package com.snapdeal.hack.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Purchase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6537006418266004224L;
	private String date = StringUtils.EMPTY;
	private boolean visibility = false;
	private boolean isReturned = false;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public Purchase() {
		
	}

}
