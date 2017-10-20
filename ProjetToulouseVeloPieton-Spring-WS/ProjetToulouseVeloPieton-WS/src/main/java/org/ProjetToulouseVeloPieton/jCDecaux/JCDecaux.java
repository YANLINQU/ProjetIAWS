package org.ProjetToulouseVeloPieton.jCDecaux;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;

import org.ProjetToulouseVeloPieton.arcGIS.ArcGIS;
import org.ProjetToulouseVeloPieton.bean.userstory1a.ObjectFactoryUserStory1A;
import org.ProjetToulouseVeloPieton.bean.userstory1a.StationType;
import org.ProjetToulouseVeloPieton.bean.userstory1a.StationsAvecVelosType;
import org.ProjetToulouseVeloPieton.bean.userstory1a.StationsUserStory1AType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.ObjectFactoryUserStory1B;
import org.ProjetToulouseVeloPieton.bean.userstory1b.StationBType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.StationsAvecPlacesType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.StationsUserStory1BType;
import org.ProjetToulouseVeloPieton.openStreetMap.OpenStreetMap;
import org.xml.sax.SAXException;

public class JCDecaux {
	ArcGIS argGIS = new ArcGIS();
	OpenStreetMap openStreetMap = new OpenStreetMap();

	public JCDecaux() {
		argGIS = new ArcGIS();
		openStreetMap = new OpenStreetMap();
	}

	/**
	 * Cette fonction permet de trouver les coordonn閑s de toutes les stations
	 * v閘os de Toulouse (lat, long)
	 * 
	 * @param coordonneeDepart
	 * exemple de coordonneeDepart: "[43.580795461338795,1.449135738584587]"
	 */
	public String recupererCoordonnees(String coordonneeDepart) {
		Client client = ClientBuilder.newClient();
		final String API_URI = "https://api.jcdecaux.com/vls/v1/stations?apiKey="
				+ "24e2c24b97f9edd467876b1cf72c79b4c723c65c&contract=Toulouse";
		WebTarget wt;
		JsonArray tabStations = null;
		String cordonneesStations = ("[{\"paths\":[[");
		int i;

		wt = client.target(API_URI);
		try {
			tabStations = wt.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		} catch (InternalServerErrorException e) {
			e.printStackTrace();
			System.err.println("R閜onse HTTP " + e.getResponse().getStatus());
			tabStations = Json.createArrayBuilder().build();
		}
		System.out.println(tabStations.size());
		for (i = 0; i < tabStations.size(); ++i) {
			cordonneesStations += "[" + tabStations.getJsonObject(i).getJsonObject("position").get("lat") + ","
					+ tabStations.getJsonObject(i).getJsonObject("position").get("lng") + "]," + coordonneeDepart
					+ "]]}";

			if (i != (tabStations.size() - 1)) {
				cordonneesStations += ",{\"paths\":[[";
			} else {
				cordonneesStations += "]";
			}
		}
		return cordonneesStations;
	}

	/**
	 * Cette fonction permet de trouver toutes les stations de v閘os �
	 * Toulouse
	 */
	public JsonArray rechercherStation() {
		Client client = ClientBuilder.newClient();
		final String API_URI = "https://api.jcdecaux.com/vls/v1/stations?apiKey="
				+ "24e2c24b97f9edd467876b1cf72c79b4c723c65c&contract=Toulouse";
		WebTarget wt;
		JsonArray tabStations = null;

		wt = client.target(API_URI);
		try {
			tabStations = wt.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		} catch (InternalServerErrorException e) {
			e.printStackTrace();
			System.err.println("R閜onse HTTP " + e.getResponse().getStatus());
			tabStations = Json.createArrayBuilder().build();
		}

		return tabStations;
	}

	/**
	 * Renvoie une listes de stations de v閘os trier par les plus proches (qui
	 * ont au moins un v閘o disponible)
	 *
	 * @param stations
	 * @param coordonnesStations
	 */
	public ArrayList<JsonObject> troisMeuilleurStations(JsonArray stations, JsonArray coordonnesStations) {
		boolean ordonee = false;
		int taille = stations.size();

		ArrayList<JsonObject> stationsList = new ArrayList<JsonObject>(taille);
		ArrayList<JsonNumber> lengthsStationsList = new ArrayList<JsonNumber>(taille);
		for (int i = 0; i <= taille - 1; i++) {
			stationsList.add(stations.getJsonObject(i));
			lengthsStationsList.add(coordonnesStations.getJsonNumber(i));
		}

		// Trier les stations de v�los (du plus proche au plus loin)
		while (!ordonee) {
			ordonee = true;
			for (int i = 0; i < taille - 2; i++) {
				if (lengthsStationsList.get(i).doubleValue() > lengthsStationsList.get(i + 1).doubleValue()) {
					JsonNumber temp = lengthsStationsList.get(i);
					lengthsStationsList.set(i, lengthsStationsList.get(i + 1));
					lengthsStationsList.set(i + 1, temp);

					JsonObject temp2 = stationsList.get(i);
					stationsList.set(i, stationsList.get(i + 1));
					stationsList.set(i + 1, temp2);

					ordonee = false;
				}
			}
			taille--;
		}

		return stationsList;
	}

	/**
	 * Affiche les trois stations de v閘os les plus proches non vide (qui ont
	 * au moins un v閘o disponible)
	 *
	 * @param adresseDepart
	 */
	public ArrayList<JsonObject> stationsAvecVelos(String adresseDepart) {
		
		JsonArray stations = this.rechercherStation();
		ArrayList<JsonObject> stationsList = new ArrayList<JsonObject>(stations.size());
		
		try {
			stationsList = troisMeuilleurStations(stations, this.argGIS.getLengths(this.recupererCoordonnees(this.openStreetMap.recupererCoordonnee(adresseDepart))));			
			System.out.println("stationsList:"+stationsList);
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

		// Afficher les 3 stations non vides qui sont op閞ationnelle
		ArrayList<JsonObject> troisStations = new ArrayList<JsonObject>(3);
		int nbStation = 3;
		for (int i = 0; i < stationsList.size(); ++i) {
			if ((stationsList.get(i).getInt("available_bikes") > 0)
					&& (stationsList.get(i).getString("status").equals("OPEN"))) {
				
				troisStations.add(stationsList.get(i));
				nbStation--;
				if (nbStation == 0) {
					i = stationsList.size();
				}
			}
		}
		
		return troisStations;
	}
	
	/**
	 * Permet de tester le UserStory1a
	 * @param adresseDepart
	 * @return tois stations de v�los non vide
	 */
	public StationsUserStory1AType userStory1a(String adresseDepart) {
		//cree un factory
		ObjectFactoryUserStory1A of = new ObjectFactoryUserStory1A();		
		
		StationsUserStory1AType stationsA = of.createStationsType();//ROOT
		StationsAvecVelosType stationsAvecVelos = of.createStationsAvecVelosType();
		
		List<StationType> stationXML = stationsAvecVelos.getStation();
		

		ArrayList<JsonObject> troisStations = new ArrayList<JsonObject>(3);
		troisStations = this.stationsAvecVelos(adresseDepart);

		StationType station_velo1 = of.createStationType();
		StationType station_velo2 = of.createStationType();
		StationType station_velo3 = of.createStationType();

		station_velo1.setName(troisStations.get(0).getString("name"));
		station_velo1.setAdresse(troisStations.get(0).getString("address"));
		station_velo1.setAvailableBickes(troisStations.get(0).getInt("available_bikes"));
		stationXML.add(station_velo1);

		station_velo2.setName(troisStations.get(1).getString("name"));
		station_velo2.setAdresse(troisStations.get(1).getString("address"));
		station_velo2.setAvailableBickes(troisStations.get(1).getInt("available_bikes"));
		stationXML.add(station_velo2);

		station_velo3.setName(troisStations.get(2).getString("name"));
		station_velo3.setAdresse(troisStations.get(2).getString("address"));
		station_velo3.setAvailableBickes(troisStations.get(2).getInt("available_bikes"));
		stationXML.add(station_velo3);
		stationsA.setStationsAvecVelos(stationsAvecVelos);
		
		stationsA.setVille("Toulouse");//Attribute
		
		return stationsA;
	}

	/**
	 * Affiche les trois stations de v閘os les plus proches qui ont des places
	 * disponibles (qui ont au moins un point d'attache disponible)
	 *
	 * @param adresseDepart
	 */
	public ArrayList<JsonObject> stationsAvecPlaces(String adresseDepart) {
		
		JsonArray stations = this.rechercherStation();
		ArrayList<JsonObject> stationsList = new ArrayList<JsonObject>(stations.size());
		
		try {
			stationsList = troisMeuilleurStations(stations, this.argGIS
					.getLengths(this.recupererCoordonnees(this.openStreetMap.recupererCoordonnee(adresseDepart))));
			System.out.println("stationsList:"+stationsList);
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

		// Afficher les 3 stations non vides qui sont op閞ationnelle
		ArrayList<JsonObject> troisStations = new ArrayList<JsonObject>(3);
		int nbStation = 3;
		for (int i = 0; i < stationsList.size(); ++i) {
			if ((stationsList.get(i).getInt("available_bike_stands") > 0)
					&& (stationsList.get(i).getString("status").equals("OPEN"))) {

				troisStations.add(stationsList.get(i));
				nbStation--;
				if (nbStation == 0) {
					i = stationsList.size();
				}
			}
		}

		return troisStations;
	}
	
	/**
	 * Permet de tester le user Strory 1b
	 * @param adresseDepart
	 * @return trois stations qui ont au moins une place disponible
	 */
	public StationsUserStory1BType userStory1b(String adresseDepart) {
		ObjectFactoryUserStory1B of = new ObjectFactoryUserStory1B();
		
		StationsAvecPlacesType stationPlaces = of.createStationsAvecPlacesType();
		List<StationBType> stationXML = stationPlaces.getStation();

		ArrayList<JsonObject> troisStations = new ArrayList<JsonObject>(3);
		troisStations = this.stationsAvecPlaces(adresseDepart);
		
		StationsUserStory1BType stationsB = of.createStationsType(); //ROOT
		stationsB.setVille("Toulouse");//Attribute
		
		// ELEMENT
		StationBType station_place1 = of.createStationType();
		StationBType station_place2 = of.createStationType();
		StationBType station_place3 = of.createStationType();

		station_place1.setName(troisStations.get(0).getString("name"));
		station_place1.setAdresse(troisStations.get(0).getString("address"));
		station_place1.setAvailableBikeStands(troisStations.get(0).getInt("available_bike_stands"));
		stationXML.add(station_place1);

		station_place2.setName(troisStations.get(1).getString("name"));
		station_place2.setAdresse(troisStations.get(1).getString("address"));
		station_place2.setAvailableBikeStands(troisStations.get(1).getInt("available_bike_stands"));
		stationXML.add(station_place2);

		station_place3.setName(troisStations.get(2).getString("name"));
		station_place3.setAdresse(troisStations.get(2).getString("address"));
		station_place3.setAvailableBikeStands(troisStations.get(2).getInt("available_bike_stands"));
		stationXML.add(station_place3);
		
		stationsB.setStationsAvecPlaces(stationPlaces);

		return stationsB;
	}
}