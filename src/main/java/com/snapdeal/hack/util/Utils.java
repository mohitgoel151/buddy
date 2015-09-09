package com.snapdeal.hack.util;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.snapdeal.hack.model.Buyer;
import com.snapdeal.hack.model.Product;
import com.snapdeal.hack.model.ReviewRating;
import com.snapdeal.hack.model.rr.BuyerReviewMap;
import com.snapdeal.hack.model.rr.ProductDetailedReviewsResponse;
import com.snapdeal.hack.model.rr.SimilarCategoryPurchaseResponse;

public class Utils {
	
	public static ProductDetailedReviewsResponse parseProductDetailedReviewsResponse (final String result) {
		ProductDetailedReviewsResponse resposne = new ProductDetailedReviewsResponse();
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(result);
			JSONArray results = (JSONArray) json.get("results"); 
			Iterator result1 = results.iterator(); 
			System.out.println("results: "); 
			while (result1.hasNext()) 
			{ 
				JSONObject o = (JSONObject) result1.next();
				
				if(o.containsKey("data"))
				{
					JSONArray data = (JSONArray) o.get("data"); 
					Iterator dataField = data.iterator(); 
					while (dataField.hasNext()) 
					{ 
						JSONObject oo = (JSONObject) dataField.next();
						
						if(oo.containsKey("row"))
						{
							JSONArray rowdata = (JSONArray) oo.get("row"); 
							Iterator rowDataIterator = rowdata.iterator();
							while(rowDataIterator.hasNext()) {
								JSONObject obj = (JSONObject) rowDataIterator.next();
								JSONObject product = (JSONObject) obj.get("Product");
								resposne.setProduct(convertJsonToProduct(product));
								JSONObject User = (JSONObject) obj.get("User");
								Buyer buyer = convertJsonToBuyer(User);
								JSONObject Review = (JSONObject) obj.get("Review");
								ReviewRating rr = convertJsonToReviewRating(Review);
								resposne.addBuyerRating(new BuyerReviewMap(buyer, rr));
							}
						}
						
					}
				}
				
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resposne;
	}
	
	public static SimilarCategoryPurchaseResponse parseSimilarCategoryPurchaseResponse (final String result) {
		SimilarCategoryPurchaseResponse finalresposne = new SimilarCategoryPurchaseResponse();
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(result);
			JSONArray results = (JSONArray) json.get("results"); 
			Iterator result1 = results.iterator(); 
			System.out.println("results: "); 
			while (result1.hasNext()) 
			{ 
				JSONObject o = (JSONObject) result1.next();
				
				if(o.containsKey("data"))
				{
					JSONArray data = (JSONArray) o.get("data"); 
					Iterator dataField = data.iterator(); 
					while (dataField.hasNext()) 
					{ 
						JSONObject oo = (JSONObject) dataField.next();
						
						if(oo.containsKey("row"))
						{
							JSONArray rowdata = (JSONArray) oo.get("row"); 
							Iterator rowDataIterator = rowdata.iterator();
							while(rowDataIterator.hasNext()) {
								ProductDetailedReviewsResponse response = new ProductDetailedReviewsResponse();
								JSONObject obj = (JSONObject) rowDataIterator.next();
								JSONObject product = (JSONObject) obj.get("Product");
								response.setProduct(convertJsonToProduct(product));
								JSONObject User = (JSONObject) obj.get("User");
								Buyer buyer = convertJsonToBuyer(User);
								JSONObject Review = (JSONObject) obj.get("Review");
								ReviewRating rr = convertJsonToReviewRating(Review);
								response.addBuyerRating(new BuyerReviewMap(buyer, rr));
								finalresposne.addProductBuyersInMap(response);
							}
						}
						
					}
				}
				
			}
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return finalresposne;
	}
	
	public static Buyer convertJsonToBuyer(JSONObject buyerObject) {
		Buyer buyer = new Buyer();
		buyer.setName((String)buyerObject.get("name"));
		buyer.setEmailId((String)buyerObject.get("emailId"));
		buyer.setLastUpdateWithFB((String)buyerObject.get("lastupdatedfb"));
		buyer.setFbId((String)buyerObject.get("fbid"));
		buyer.setImageUrl((String)buyerObject.get("imageurl"));
		
		return buyer;
	}
	
	public static Product convertJsonToProduct(JSONObject jsonProduct) {
		Product product = new Product();
		product.setCategory("");
		product.setDetailedPageUrl((String)jsonProduct.get("detailpageurl"));
		product.setSupcCode(jsonProduct.get("supcCode").toString());
		product.setTitle(jsonProduct.get("title").toString());
		product.setImage(jsonProduct.get("image").toString());
		
		return product;
	}
	
	public static ReviewRating convertJsonToReviewRating(JSONObject reviewRating) {
		ReviewRating rr = new ReviewRating();
		rr.setRating(Integer.parseInt(reviewRating.get("rating").toString()));
		rr.setRecommended(Boolean.parseBoolean(reviewRating.get("isRecommended").toString()));
		rr.setReviewComments((String)reviewRating.get("reviewComments"));
		
		return rr;
	}

}
