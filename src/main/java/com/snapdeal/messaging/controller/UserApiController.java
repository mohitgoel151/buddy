package com.snapdeal.messaging.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.snapdeal.hack.model.rr.ProductDetailedReviewsResponse;
import com.snapdeal.hack.model.rr.PurchaseResponse;
import com.snapdeal.hack.model.rr.SimilarCategoryPurchaseResponse;
import com.snapdeal.messaging.service.UserApiService;


@RestController
public class UserApiController {
	
	@Autowired
	private UserApiService userApiService;
	
	private static Logger LOG = LoggerFactory.getLogger(UserApiController.class);
	
	//@ResponseBody
	//@RequestMapping(value = "/addpurchase", method = RequestMethod.POST, produces="application/json")
	@RequestMapping(value = "/purchase", method = RequestMethod.GET, produces="application/json")
	public PurchaseResponse addPurchaseEntry() {
//		if((addPurchaseRequest == null) || (addPurchaseRequest.isValid() == false)) {
//			System.out.println("addPurchaseRequest is invalid");
//			throw new IllegalArgumentException("addPurchaseRequest is invalid");
//		}
		return userApiService.addPurchaseEntry();

	}
	
	@RequestMapping(value = "/user/{fbid}/productdetail/{supcCode}/{bol}", method = RequestMethod.GET, produces="application/json")
	ProductDetailedReviewsResponse getProductDetailedReviews(@PathVariable String fbid, @PathVariable String supcCode
			, @PathVariable String bol) {
		if(StringUtils.isBlank(supcCode)) {
			System.out.println("getProductDetailedReviews supc code is blank");
			throw new IllegalArgumentException("supc code is blank");
		}
		System.out.println("getProductDetailedReviews"+supcCode + " ##" + bol);
		ProductDetailedReviewsResponse response = userApiService.getProductDetailedReviews(fbid, supcCode, bol);
		return response;
	}
	
	@RequestMapping(value ="/user/{fbid}/similarcategory/{supcCode}", method = RequestMethod.GET, produces="application/json")
	SimilarCategoryPurchaseResponse getSimilarCategoryPurchase(@PathVariable String fbid, 
			@PathVariable String supcCode,
			HttpServletRequest request,
			 HttpServletResponse response) throws Exception {
//		if(StringUtils.isBlank(supcCode)) {
//			System.out.println("getSimilarCategoryPurchase supc code is blank");
//			throw new IllegalArgumentException("supc code is blank");
//		}
//		System.out.println("getSimilarCategoryPurchase");
//		return userApiService.getSimilarCategoryPurchase(fbid, supcCode);
		int i = 3;
		if(i == 3) {
			//throw new Exception("my");
		}
		
		Enumeration<String> reIterator = request.getAttributeNames();
		while (reIterator.hasMoreElements()) {
			String string = (String) reIterator.nextElement();
			System.out.print("*****" + string);
			System.out.println("  = " + request.getAttribute(string));
		}
		
		return new SimilarCategoryPurchaseResponse();
	}


	
//	@ResponseBody
//	@RequestMapping(value = "/addfriend", method = RequestMethod.POST, produces="application/json")
//	public AddFriendsResponse addFriends(@RequestBody @Valid AddFriendRequest addFriendRequest) {
//		return new AddFriendsResponse();
//
//	}


}
