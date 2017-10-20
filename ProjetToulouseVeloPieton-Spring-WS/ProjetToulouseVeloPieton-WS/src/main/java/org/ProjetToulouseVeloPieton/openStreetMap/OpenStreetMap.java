package org.ProjetToulouseVeloPieton.openStreetMap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ProjetToulouseVeloPieton.openWeatherMap.OpenWeatherMap;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;



public class OpenStreetMap {
	
	public String recupererCoordonnee(String adresse) throws ParserConfigurationException, SAXException, IOException, URISyntaxException{
		String lat = null, longi = null;
		String url = "http://nominatim.openstreetmap.org/search?q="+adresse+"&format=xml";
		System.out.println("recupererCoordonnee:"+url);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(url);
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		String latitude = "searchresults/place/@lat";
		String longitude = "searchresults/place/@lon";
		try {
			lat = xPath.compile(latitude).evaluate(document);
			longi = xPath.compile(longitude).evaluate(document);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( lat + "+" + longi );
		return "[" + lat + "," + longi + "]";
	}
	
	public HashMap<String, String> recupererLonLat(String adresse) {
		HashMap<String, String> resultat = new HashMap<String, String>();
		String url = "http://nominatim.openstreetmap.org/search?q="+adresse+"&format=xml";
		System.out.println("recupererLonLat:"+url);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document;
			
			document = builder.parse(url);
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			resultat.put("lat", xPath.compile("searchresults/place/@lat").evaluate(document));
			resultat.put("lon", xPath.compile("searchresults/place/@lon").evaluate(document)); 
			
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	
}
