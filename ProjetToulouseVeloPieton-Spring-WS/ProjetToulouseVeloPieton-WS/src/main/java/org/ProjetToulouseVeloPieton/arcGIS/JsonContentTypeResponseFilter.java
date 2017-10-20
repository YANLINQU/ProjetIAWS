package org.ProjetToulouseVeloPieton.arcGIS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MediaType;

public class JsonContentTypeResponseFilter implements ClientResponseFilter{

	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		List<String> contentType = new ArrayList<String>(1);
		contentType.add(MediaType.APPLICATION_JSON);
		responseContext.getHeaders().put("Content-Type", contentType);
	}
	
}