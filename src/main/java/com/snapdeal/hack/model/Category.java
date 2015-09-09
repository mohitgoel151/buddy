package com.snapdeal.hack.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7765086298484375863L;
	private String name = StringUtils.EMPTY;
	private Set<String> productList = new HashSet<String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getProductList() {
		return productList;
	}

	public void setProductList(Set<String> productList) {
		this.productList = productList;
	}

	public Category () {
		
	}
	
	public void addProduct(String product) {
		this.productList.add(product);
	}
	
}
