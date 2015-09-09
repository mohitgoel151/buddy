package com.snapdeal.hack.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class ReviewRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187827188795810686L;
	private String reviewComments = StringUtils.EMPTY;
	private int rating = 0;
	private boolean isRecommended = false;
	
	public String getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public ReviewRating() {
		
	}
}
