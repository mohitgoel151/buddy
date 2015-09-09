package com.snapdeal.messaging.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.snapdeal.hack.model.rr.AddFriendRequest;
import com.snapdeal.hack.model.rr.AddFriendsResponse;
import com.snapdeal.hack.model.rr.AddPurchaseRequest;
import com.snapdeal.hack.model.rr.ProductDetailedReviewsResponse;
import com.snapdeal.hack.model.rr.PurchaseResponse;
import com.snapdeal.hack.model.rr.SimilarCategoryPurchaseResponse;


public interface UserApiService {
	
	public PurchaseResponse addPurchaseEntry();
	
	//public AddFriendsResponse addFriends(AddFriendRequest addFriendRequest);
	
	public SimilarCategoryPurchaseResponse getSimilarCategoryPurchase(final String fbid, final String supcCode);
	
	public ProductDetailedReviewsResponse getProductDetailedReviews(final String fbid, final String supcCode, final String bol);

}
