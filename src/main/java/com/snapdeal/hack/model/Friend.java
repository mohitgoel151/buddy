package com.snapdeal.hack.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class Friend implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 528906768448660892L;
	private String friendshipDate = StringUtils.EMPTY;

	public String getFriendshipDate() {
		return friendshipDate;
	}

	public void setFriendshipDate(String friendshipDate) {
		this.friendshipDate = friendshipDate;
	}

}
