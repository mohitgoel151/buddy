package com.snapdeal.hack.neo4j;

import com.snapdeal.hack.model.rr.ProductDetailedReviewsResponse;
import com.snapdeal.hack.model.rr.SimilarCategoryPurchaseResponse;

public interface NeoAdapterInterface {
	
//	int startServer(String uriSuffix);
//	void closeServer();
	
	public void callNeo();
	
	public String sendTransactionalCypherQuery(final String query);
}
