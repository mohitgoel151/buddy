package com.snapdeal.hack.model.rr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.snapdeal.hack.model.Buyer;
import com.snapdeal.hack.model.Product;
import com.snapdeal.hack.model.ReviewRating;

public class ProductDetailedReviewsResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4643525798798348778L;
	
	private Product product;
	private List<BuyerReviewMap> buyerReviewsMap;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<BuyerReviewMap> getBuyerReviewsMap() {
		return buyerReviewsMap;
	}

	public void setBuyerReviewsMap(List<BuyerReviewMap> buyerReviewsMap) {
		this.buyerReviewsMap = buyerReviewsMap;
	}

	public ProductDetailedReviewsResponse () {
		product = new Product();
		buyerReviewsMap = new ArrayList<BuyerReviewMap>();
	}
	
	public void addBuyerRating(BuyerReviewMap map) {
		buyerReviewsMap.add(map);
	}

}
