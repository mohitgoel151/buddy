package com.snapdeal.hack.neo4j;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import static com.snapdeal.messaging.config.Constants.SERVER_ROOT_URI;

@Service
public class NeoAdapterImpl extends NeoAdapter {

	@Override
	public void callNeo() {
		System.out.println("Neo called");
		
	}
	
	public String sendTransactionalCypherQuery(String query) {

		String result = StringUtils.EMPTY;
//        query = "match(x:Product {supcCode:100})-[r:ReviewRatings]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'3'}) return x,u,r";
//        query = "match(x:Product {supcCode:100})-[r:ReviewRatings]-(u:Buyer)-[f:friend]-(us:Buyer {fbid:'3'}) return distinct {Product: x, User: u , Review: r}";
        final String txUri = SERVER_ROOT_URI + "transaction/commit";
        WebResource resource = Client.create().resource( txUri );

        String payload = "{\"statements\" : [ {\"statement\" : \"" +query + "\"} ]}";
        ClientResponse response = resource
                .accept( MediaType.APPLICATION_JSON )
                .type( MediaType.APPLICATION_JSON )
                .entity( payload )
                .post( ClientResponse.class );
        
//        System.out.println( String.format(
//                "POST [%s] to [%s], status code [%d], returned data: "
//                        + System.getProperty( "line.separator" ) + "%s",
//                payload, txUri, response.getStatus(),
//                response.getEntity( String.class ) ) );
        result = response.getEntity( String.class );
        response.close();

        return result;
    }


}
