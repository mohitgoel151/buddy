package com.snapdeal.hack.model.rr;

import com.snapdeal.hack.model.Buyer;
import com.snapdeal.hack.model.Product;

public class AddPurchaseRequest {
	
	private Product product;
	private Buyer buyer;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public AddPurchaseRequest() {
		
	}
	
	public boolean isValid() {
		boolean isValid = true;
		
		if(product == null || buyer == null || product.isValid() == false || buyer.isValid() == false) {
			isValid = false;
		}
		
		return isValid;
		
	}

}
