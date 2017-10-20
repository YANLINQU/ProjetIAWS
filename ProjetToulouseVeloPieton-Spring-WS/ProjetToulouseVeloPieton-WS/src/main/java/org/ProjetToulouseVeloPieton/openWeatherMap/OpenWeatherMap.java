package org.ProjetToulouseVeloPieton.openWeatherMap;

import java.io.IOException;
import java.util.HashMap;

import javax.json.JsonObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ProjetToulouseVeloPieton.arcGIS.ArcGIS;
import org.ProjetToulouseVeloPieton.bean.userstory2.MeteoType;
import org.ProjetToulouseVeloPieton.bean.userstory2.ObjectFactoryUserStory2;
import org.ProjetToulouseVeloPieton.bean.userstory3.ObjectFactoryUserStory3;
import org.ProjetToulouseVeloPieton.bean.userstory3.TrajetPiedType;
import org.ProjetToulouseVeloPieton.bean.userstory4.ObjectFactoryUserStory4;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetPiedArrType;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetPiedDepType;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetPiedsType;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetType;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetVeloType;
import org.ProjetToulouseVeloPieton.jCDecaux.JCDecaux;
import org.ProjetToulouseVeloPieton.openStreetMap.OpenStreetMap;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class OpenWeatherMap {
	
	/*
	 * meteo recupere la pluviométrie
	 * @param adresse est l'addesse de lieu où on verifie la pluviometrie
	 * @return la precipitation et l'humidité
	 * 
	 */
	public MeteoType  chausseePluviometrie(String adressedepart) {
		ObjectFactoryUserStory2 of = new ObjectFactoryUserStory2();
		MeteoType meteo = of.createMeteoType();	
		String url = "http://api.openweathermap.org/data/2.5/weather?mode=xml&q="+adressedepart+"&appid=8c49c2845dfd04052bf88664de7ad984";
		System.out.println(url);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(url);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String humidity = "current/humidity/@value";
			String precipitation = "current/precipitation/@mode";

			meteo.setAdresse(adressedepart);
			meteo.setHumidite(xPath.compile(humidity).evaluate(document));

			meteo.setAdresse(adressedepart);
			meteo.setHumidite(xPath.compile(humidity).evaluate(document));

			meteo.setPrecipitation(xPath.compile(precipitation).evaluate(document));
			
			if(xPath.compile(precipitation).evaluate(document).equals("rain")){
				meteo.setChausseMouillee("oui");
			}else{
				meteo.setChausseMouillee("non");
			}
	
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return meteo;
	}		
	
	/*
	 * tempsEstimer calcule le temps estimer entre deux adresses à pied en 
	 * fonction du contexte ci-dessous.
	 * contexte: 
	 * @param adresseDepart est l'adresse de depart
	 * @param adresseArrivee est l'adresse d'arrivee
	 * @return le temps estimer
	 * 
	 * Une fonction pluviometrie qui reçoit en parametre une adresse et retourne une HashMap
	 *          contenant la precipitation, l'humidité, le latitude et la longitude
	 * 
	 * Cette methode est utilisé pour la user story 3
	 */	
	public TrajetPiedType tempsEstimerApied(String adresseDepart, String adresseArrivee) {
		ObjectFactoryUserStory3 of = new ObjectFactoryUserStory3();
		TrajetPiedType trajetPied = of.createTrajetPiedType();
		HashMap<String, String> pluviometrieDepart = new HashMap<String, String>(pluviometrie(adresseDepart));;
		HashMap<String, String> pluviometrieArrivee = new HashMap<String, String>(pluviometrie(adresseArrivee));
	
		trajetPied.setAdresseDepart(adresseDepart);
		trajetPied.setAdresseArrivee(adresseArrivee);
		//convertion de la durrée
		double temps = tempsEnFonctionPluviometrieApied(pluviometrieDepart, pluviometrieArrivee)*60;
		int heure = ((int)(temps/60));
		int min = (int)(temps - (heure*60));
		trajetPied.setTemps(heure +"h:"+ min+"mn");

		return trajetPied;
	}
	
	private double tempsEnFonctionPluviometrieApied(HashMap<String, String> pluviometrieDepart,
			HashMap<String, String> pluviometrieArrivee) {
		ArcGIS arcGIS = new ArcGIS(); 
		// TODO Auto-generated method stub
		double distance  = arcGIS.getDistance(Double.parseDouble(pluviometrieDepart.get("lon")), 
				Double.parseDouble(pluviometrieDepart.get("lat")), 
				Double.parseDouble(pluviometrieArrivee.get("lon")), 
				Double.parseDouble(pluviometrieArrivee.get("lat")));
		
		if((pluviometrieDepart.get("precipitation").equals("no")) 
				&& (pluviometrieArrivee.get("precipitation").equals("no"))){
			return (distance/3.93);
		}
			
		else if((pluviometrieDepart.get("precipitation").equals("no")) 
				&& (pluviometrieArrivee.get("precipitation").equals("rain"))){
			return ((distance/3.93) + 0.125);
		}else if((pluviometrieDepart.get("precipitation").equals("rain")) 
				&& (pluviometrieArrivee.get("precipitation").equals("no"))){
			return ((distance/3.93) + 0.125);
		}else{
			return ((distance/3.93) + 0.25);
		}
		
	}

	/*
	 * tempsTotalTrajet retourne le estimer entre deux adresses en fonction des contextes ci-dessous:
	 * contexte1: 3.63Km/h
	 * contexte2: à velo 16km/h
	 * 
	 * @param adresseDepart est l'adresse de depart
	 * @param adresseArrivee est l'adresse d'arrivée
	 * @return le temps estimer en double
	 * 
	 * Une fonction pluviometrie qui reçoit en parametre une adresse et retourne une HashMap
	 *          contenant la precipitation, l'humidité, le latitude et la longitude
	 */
	/*
	 adresseDepart:118 Route de Narbonne, 31062 Toulouse France 
	 adresseArrivee:4 avenue des herbettes, 31400 Toulouse France
	 */
	public TrajetType tempsTotalTrajet(String adresseDepart, String adresseArrivee){
		System.out.println("entrer tempsTotalTrajet");
		ObjectFactoryUserStory4 of = new ObjectFactoryUserStory4();
		JCDecaux jcDecaux = new JCDecaux();		
		
		TrajetType trajet= of.createTrajetType();
		TrajetPiedsType trajet_pieds= of.createTrajetPiedsType();
		TrajetPiedDepType trajet_piedDep= of.createTrajetPiedDepType();
		TrajetPiedArrType trajet_piedArr= of.createTrajetPiedArrType();
		TrajetVeloType trajet_velo = of.createTrajetVeloType();
		
		//recuperer les stations les plus proches		
		JsonObject stationDepartProche = jcDecaux.stationsAvecVelos(adresseDepart).get(0);
		JsonObject stationArriveeProche = jcDecaux.stationsAvecPlaces(adresseArrivee).get(0);
		
		//recuperation des informations du trajet de depart à pied
		trajet_piedDep.setAdresseDepart(adresseDepart);
		trajet_piedDep.setAdresseStationDepart(stationDepartProche.getString("address"));

		HashMap<String, String> pluviometrieDepart = new HashMap<String, String>(pluviometrie(adresseDepart));
		HashMap<String, String> pluviometrieStationDep = new HashMap<String, String>(pluviometrie(stationDepartProche.getString("address")));
		
		//convertion en heurre et mn
		double tempsDepp = tempsEnFonctionPluviometrieApied(pluviometrieDepart, pluviometrieStationDep)*60;
		int heureDep = ((int)(tempsDepp/60));
		int minDep = (int)(tempsDepp - (heureDep*60));	
		trajet_piedDep.setTemps(heureDep+"h:"+minDep+"mn");

		//recuperation des informations du trajet d'arrivee à pied
		trajet_piedArr.setAdresseStationArrivee(stationArriveeProche.getString("address"));
		trajet_piedArr.setAdresseArrivee(adresseArrivee);
		
		HashMap<String, String> pluviometrieArriveeProch = new HashMap<String, String>(pluviometrie(stationArriveeProche.getString("address")));
		HashMap<String, String> pluviometrieArrive = new HashMap<String, String>(pluviometrie(adresseArrivee));	
		
		double tempsArr = tempsEnFonctionPluviometrieApied(pluviometrieArriveeProch,pluviometrieArrive)*60;
		int heureArr = ((int)(tempsArr/60));
		int minArr = (int)(tempsArr - (heureArr*60));	
		System.out.println("Arrivee: "+heureArr+"h:"+minArr+"mn");
		trajet_piedArr.setTemps(heureArr+"h:"+minArr+"mn");
				
		//informations sur le trajets à pied total
		trajet_pieds.setTrajetPiedDep(trajet_piedDep);
		trajet_pieds.setTrajetPiedArr(trajet_piedArr);
		double tmpTotalPied = tempsDepp + tempsArr;
		int heureTotalPied = ((int)(tmpTotalPied/60));
		int minTotalPied = (int)(tmpTotalPied - (heureTotalPied*60));
		trajet_pieds.setTemps(heureTotalPied+"h:"+minTotalPied+"mn");
		                              
		//informations sur le trajet à velo
		trajet_velo.setAdresseStationDepart(stationDepartProche.getString("address"));
		trajet_velo.setAdresseStationArrive(stationArriveeProche.getString("address"));
		//convertion en hh et mm
		double tempsVelo = tempsEnFonctionPluviometrieAvelo(stationDepartProche.getString("address"),
       			stationArriveeProche.getString("address"))*60;
		int heureVelo = ((int)(tempsVelo/60));
		int minVelo = (int)(tempsVelo - (heureVelo*60));
		
		trajet_velo.setTemps(heureVelo+"h:"+minVelo+"mn");
		//informations sur le trajet
		trajet.setTrajetPieds(trajet_pieds);
		trajet.setTrajetVelo(trajet_velo);
		double tmpTotal = tmpTotalPied + tempsVelo;
		int heureTotal = ((int)(tmpTotal/60));
		int minTotal =(int)(tmpTotal - (heureTotal*60));	

		trajet.setTempstotal(String.valueOf(heureTotal+"h:"+minTotal+"mn"));
		System.out.println("finir tempsTotalTrajet");

		return trajet;
	}
	
	private double tempsEnFonctionPluviometrieAvelo(String adresseDepart, String adresseArrivee)  {
		// TODO Auto-generated method stub
		ArcGIS arcGIS = new ArcGIS();
		HashMap<String, String> pluviometrieDepart = new HashMap<String, String>(pluviometrie(adresseDepart));
		HashMap<String, String> pluviometrieArrivee = new HashMap<String, String>(pluviometrie(adresseArrivee));
		
		double distance = arcGIS.getDistance(Double.parseDouble(pluviometrieDepart.get("lon")), 
											 Double.parseDouble(pluviometrieDepart.get("lat")), 
											 Double.parseDouble(pluviometrieArrivee.get("lon")), 
											 Double.parseDouble(pluviometrieArrivee.get("lat")));
		
		if((pluviometrieDepart.get("precipitation").equals("no")) 
				&& (pluviometrieArrivee.get("precipitation").equals("no"))){
			return (distance/16);
		}
			
		else if((pluviometrieDepart.get("precipitation").equals("no")) 
				&& (pluviometrieArrivee.get("precipitation").equals("rain"))){
			return ((distance/16) +0.125);
		}else if((pluviometrieDepart.get("precipitation").equals("rain")) 
				&& (pluviometrieArrivee.get("precipitation").equals("no"))){
			return ((distance/16) +0.125);
		}else{
			return ((distance/16) +0.25);
		}
	
	}

	private HashMap<String, String> pluviometrie(String adresse) {
		HashMap<String, String> resultat = new HashMap<String, String>();
		String preci, humidite;
		OpenStreetMap openStreetMap = new OpenStreetMap();		
		HashMap<String, String> latLong = new HashMap<String, String>(openStreetMap.recupererLonLat(adresse));
		String url = "http://api.openweathermap.org/data/2.5/weather?mode=xml&q="+adresse+"&appid=8c49c2845dfd04052bf88664de7ad984";
		System.out.println(url);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			
			document = builder.parse(url);
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		String humidity = "current/humidity/@value";
		String precipitation = "current/precipitation/@mode";
		
		try {
			preci = xPath.compile(precipitation).evaluate(document);
			humidite = xPath.compile(humidity).evaluate(document);
			resultat.put("precipitation", preci);
			resultat.put("humidite", humidite);
			
			resultat.put("lat", latLong.get("lat"));
			resultat.put("lon", latLong.get("lon"));
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return resultat;
	}
	public static void main(String args[]) {
		OpenWeatherMap openWeatherMap = new OpenWeatherMap();
		openWeatherMap.tempsTotalTrajet("31 Rue Valade, 31000 Toulouse", "24 Rue Louis Eydoux, 31400 Toulouse");
		
	}
	
}
