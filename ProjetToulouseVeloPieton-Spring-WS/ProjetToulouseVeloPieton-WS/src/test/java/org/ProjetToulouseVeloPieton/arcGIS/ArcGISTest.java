package org.ProjetToulouseVeloPieton.arcGIS;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArcGISTest {

ArcGIS distance;
	
	@Before
	public void setUp(){
		distance = new ArcGIS();
	}
	
	@Test
	public void testGetDistance() {
		assertTrue(distance.getDistance(115, 36, -117, 34)!= 0.0);
	}

}
