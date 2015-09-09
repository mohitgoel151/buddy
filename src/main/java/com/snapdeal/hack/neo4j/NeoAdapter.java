package com.snapdeal.hack.neo4j;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import static com.snapdeal.messaging.config.Constants.SERVER_ROOT_URI;

@Service
public abstract class NeoAdapter implements NeoAdapterInterface {

	private ClientResponse response;
	
	protected int startServer(String uriSuffix) {
		if(response == null) {
			WebResource resource = Client.create().resource(SERVER_ROOT_URI + uriSuffix);
			response = resource.get(ClientResponse.class);
			System.out.println( String.format( "GET on [%s], status code [%d]", SERVER_ROOT_URI+uriSuffix, response.getStatus()));
		} else {
			System.out.println("Server already running");
		}
		return response.getStatus();
	}

	protected void closeServer() {
		if(response != null) {
			response.close();
		}
		
	}
	
//	public void checkDatabaseIsRunning()
//    {
//        // START SNIPPET: checkServer
//        WebResource resource = Client.create()
//                .resource( SERVER_ROOT_URI );
//        ClientResponse response = resource.get( ClientResponse.class );
//
//        System.out.println( String.format( "GET on [%s], status code [%d]",
//                SERVER_ROOT_URI, response.getStatus() ) );
//        response.close();
//        // END SNIPPET: checkServer
//    }



}
