package org.ProjetToulouseVeloPieton.openWeatherMap;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OpenWeatherMapTest {
	OpenWeatherMap openWeatherMap;
	@Before
	public void setUp() throws Exception {
		openWeatherMap = new OpenWeatherMap();
	}

	@Test
	public void testChausseePluviometrie() {
		assertTrue(openWeatherMap.chausseePluviometrie("24 Rue Louis Eydoux, 31400 Toulouse") !=null);
	}
	
	@Test
	public void testTempsEstimerApied() {
		assertTrue(openWeatherMap.tempsEstimerApied("24 Rue Louis Eydoux, 31400 Toulouse", 
				"4 Rue Valade, 31000 Toulouse").getTemps() != null);
	}
	
	@Test
	public void testTempsTotalTrajet(){
		assertTrue(openWeatherMap.tempsTotalTrajet("24 Rue Louis Eydoux, 31400 Toulouse", 
				"4 Rue Valade, 31000 Toulouse").getTempstotal() != null);
	}

}
