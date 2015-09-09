package com.snapdeal.hack.model.rr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.snapdeal.hack.model.Buyer;
import com.snapdeal.hack.model.Product;

public class SimilarCategoryPurchaseResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6288406007219366244L;
	
	private String category = StringUtils.EMPTY;
	private List<ProductDetailedReviewsResponse> similarProductReviewList = new ArrayList<ProductDetailedReviewsResponse>();
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<ProductDetailedReviewsResponse> getProductBuyerMap() {
		return similarProductReviewList;
	}

	public void setProductBuyerMap(List<ProductDetailedReviewsResponse> productBuyerMap) {
		this.similarProductReviewList = productBuyerMap;
	}
	
	public SimilarCategoryPurchaseResponse() {
		
	}
	
	public void addProductBuyersInMap(ProductDetailedReviewsResponse res) {
		this.similarProductReviewList.add(res);
	}
}
