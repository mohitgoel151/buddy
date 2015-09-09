package com.snapdeal.hack.model.rr;

import com.snapdeal.hack.model.Buyer;
import com.snapdeal.hack.model.ReviewRating;

public class BuyerReviewMap {
	private Buyer buyer;
	private ReviewRating review;
	
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public ReviewRating getReview() {
		return review;
	}

	public void setReview(ReviewRating review) {
		this.review = review;
	}

	public BuyerReviewMap(Buyer b, ReviewRating rr) {
		this.buyer = b;
		this.review = rr;
	}
	
	public BuyerReviewMap() {
		
	}
	
}
