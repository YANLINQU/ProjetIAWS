package org.ProjetToulouseVeloPieton.openStreetMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class OpenStreetMapTest {
	OpenStreetMap openStreetMap;
	@Before
	public void setUp() throws Exception {
		openStreetMap = new OpenStreetMap();
	}

	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
		assertTrue(openStreetMap.recupererCoordonnee("Rue Valade, 31000 Toulouse").length()!=0);
	}
	
	@Test
	public void testRecupererCoordonnee(){
		try {
			assertEquals(openStreetMap.recupererCoordonnee("118 Route de Narbonne, Toulouse France"), "[43.5563945,1.4670984560632]");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
