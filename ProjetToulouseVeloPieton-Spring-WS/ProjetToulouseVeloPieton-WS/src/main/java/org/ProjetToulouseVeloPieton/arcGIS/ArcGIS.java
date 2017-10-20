package org.ProjetToulouseVeloPieton.arcGIS;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class ArcGIS {
	
	private JsonObject jsonCoord(double x, double y) {
        return Json.createObjectBuilder().add("geometryType", "esriGeometryPoint")
                .add("geometry", Json.createObjectBuilder().add("x", x).add("y", y)).build();
    }
	
	public double getDistance(double xDepart, double yDepart, double xArrivee, double yArrivee){
		Client client = ClientBuilder.newClient();
		final WebTarget wt = client.target("http://sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/Geometry/GeometryServer/distance");
		MultivaluedMap<String, String> data = new MultivaluedHashMap<String, String>();
	        data.putSingle("f", "json");
	        data.putSingle("sr", "4326");
	        data.putSingle("geodesic", "true");
	        data.putSingle("distanceUnit", "9036");
	        data.putSingle("geometry1", jsonCoord(xDepart, yDepart).toString());
	        data.putSingle("geometry2", jsonCoord(xArrivee, yArrivee).toString());

	     JsonObject resultat = wt.register(JsonContentTypeResponseFilter.class)
	    		 .request(MediaType.APPLICATION_JSON)
	             .post(Entity.form(data), JsonObject.class);
	     return resultat.getJsonNumber("distance").doubleValue();
	}
	
	public JsonArray getLengths(String coordonneesStations){
		Client client = ClientBuilder.newClient();
		final WebTarget wt = client.target("http://sampleserver6.arcgisonline.com/ArcGIS/"
				+ "rest/services/Utilities/Geometry/GeometryServer/lengths");
		System.out.println(wt);
		MultivaluedMap<String, String> data = new MultivaluedHashMap<String, String>();
	        data.putSingle("f", "json");
	        data.putSingle("sr", "4326");
	        data.putSingle("polylines", coordonneesStations);
	        data.putSingle("lengthUnit", "9036");
	        data.putSingle("calculationType", "preserveShape");

	        JsonObject resultat = wt.register(JsonContentTypeResponseFilter.class)
		    		 .request(MediaType.APPLICATION_JSON)
		             .post(Entity.form(data), JsonObject.class);	
	        
	        JsonArray lengths = resultat.getJsonArray("lengths");
	        System.out.println("JsonArrayLengths:"+lengths);
	     return lengths;
	}
}
