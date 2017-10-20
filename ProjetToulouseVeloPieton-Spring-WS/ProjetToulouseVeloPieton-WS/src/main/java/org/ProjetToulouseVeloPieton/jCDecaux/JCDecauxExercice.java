package org.ProjetToulouseVeloPieton.jCDecaux;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.ProjetToulouseVeloPieton.arcGIS.ArcGIS;
import org.ProjetToulouseVeloPieton.openStreetMap.OpenStreetMap;
import org.ProjetToulouseVeloPieton.openWeatherMap.OpenWeatherMap;
import org.xml.sax.SAXException;

public class JCDecauxExercice {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
		// TODO Auto-generated method stub
		JCDecaux jcd = new JCDecaux();		
		OpenStreetMap street = new OpenStreetMap();
		ArcGIS gis = new ArcGIS();
		OpenWeatherMap weather = new OpenWeatherMap();
		jcd.userStory1a("118 Route de Narbonne");
		//jcd.userStory1b("118 Route de Narbonne");
		
		weather.chausseePluviometrie("118 Route de Narbonne");
		
		weather.tempsEstimerApied("31 Rue Valade, 31000 Toulouse", "24 Rue Louis Eydoux, 31400 Toulouse");
		
		weather.tempsTotalTrajet("31 Rue Valade, 31000 Toulouse", "24 Rue Louis Eydoux, 31400 Toulouse");
	}

}
