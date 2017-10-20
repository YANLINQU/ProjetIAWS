package org.ProjetToulouseVeloPieton.WS;



import javax.xml.bind.JAXBElement;

import org.ProjetToulouseVeloPieton.bean.userstory1a.ObjectFactoryUserStory1A;
import org.ProjetToulouseVeloPieton.bean.userstory1a.StationsUserStory1AType;
import org.ProjetToulouseVeloPieton.bean.userstory1a.UserStory1ARequestType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.ObjectFactoryUserStory1B;
import org.ProjetToulouseVeloPieton.bean.userstory1b.StationsUserStory1BType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.UserStory1BRequestType;
import org.ProjetToulouseVeloPieton.bean.userstory2.MeteoType;
import org.ProjetToulouseVeloPieton.bean.userstory2.ObjectFactoryUserStory2;
import org.ProjetToulouseVeloPieton.bean.userstory2.UserStory2RequestType;
import org.ProjetToulouseVeloPieton.bean.userstory3.ObjectFactoryUserStory3;
import org.ProjetToulouseVeloPieton.bean.userstory3.TrajetPiedType;
import org.ProjetToulouseVeloPieton.bean.userstory3.UserStory3RequestType;
import org.ProjetToulouseVeloPieton.bean.userstory4.ObjectFactoryUserStory4;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetType;
import org.ProjetToulouseVeloPieton.bean.userstory4.UserStory4RequestType;
import org.ProjetToulouseVeloPieton.jCDecaux.JCDecaux;
import org.ProjetToulouseVeloPieton.object2XML.Object2Xml;
import org.ProjetToulouseVeloPieton.openWeatherMap.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 * @author YAN LIN QU
 * @Endpoint
éˆ¥ï¿½ @PayloadRoot
éˆ¥ï¿½ @ResponsePayload
éˆ¥ï¿½ @RequestPayload
éˆ¥ï¿½ @Namespace
éˆ¥ï¿½ @XPathParam
 */
@Endpoint
public class ProjetToulouseVeloPietonEndpoint {

	private Object2Xml object2xml;
    private JCDecaux jcdecaux;
    private OpenWeatherMap openweathermap;
    private ObjectFactoryUserStory1A objectfactoryuserstory1a;
    private ObjectFactoryUserStory1B objectfactoryuserstory1b;
    private ObjectFactoryUserStory2 objectfactoryuserstory2;
    private ObjectFactoryUserStory3 objectfactoryuserstory3;
    private ObjectFactoryUserStory4 objectfactoryuserstory4;

    private static final String NAMESPACE_URI = "http://iaws/ws/contractfirst/projet";

    @Autowired
    public ProjetToulouseVeloPietonEndpoint(Object2Xml object2xml,
    										JCDecaux jcdecaux,
    										OpenWeatherMap openweathermap,
    										ObjectFactoryUserStory1A objectfactoryuserstory1a,
    										ObjectFactoryUserStory1B objectfactoryuserstory1b,
    										ObjectFactoryUserStory2 objectfactoryuserstory2,
    										ObjectFactoryUserStory3 objectfactoryuserstory3,
    										ObjectFactoryUserStory4 objectfactoryuserstory4) {
    	this.object2xml = object2xml;
    	this.jcdecaux = jcdecaux;
        this.openweathermap = openweathermap;
        this.objectfactoryuserstory1a = objectfactoryuserstory1a;
        this.objectfactoryuserstory1b = objectfactoryuserstory1b;
        this.objectfactoryuserstory2 = objectfactoryuserstory2;
        this.objectfactoryuserstory3 = objectfactoryuserstory3;
        this.objectfactoryuserstory4 = objectfactoryuserstory4;
    }   
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserStory1ARequest") // nom de l'element racine
    @ResponsePayload
    public JAXBElement<StationsUserStory1AType> handleUserStory1ARequest(@RequestPayload UserStory1ARequestType request)
            throws Exception {
        System.out.println("----------------Recuperer la Request de UserStory1-a : begin----------------");
        System.out.println("le Numero depart:"+request.getDepNumero());
        System.out.println("la Rue depart:"+request.getDepRue());
        System.out.println("le CodePostal depart:"+request.getDepCodePostal());
        System.out.println("la Ville depart:"+request.getDepVille());
        System.out.println("le Pays depart:"+request.getDepPays());
        System.out.println("----------------Recuperer la Request de UserStory1-a : end----------------");
        
        String adresseDepart=request.getDepNumero()+" "+request.getDepRue();    

        StationsUserStory1AType stations = this.jcdecaux.userStory1a(adresseDepart);
        this.object2xml.creeXMLUserStory1A(stations);
        return   this.objectfactoryuserstory1a.createStations(stations);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserStory1BRequest") // nom de l'element racine
    @ResponsePayload
    public JAXBElement<StationsUserStory1BType> handleUserStory1BRequest(@RequestPayload UserStory1BRequestType request)
            throws Exception {
       
    	System.out.println("----------------Recuperer la Request de UserStory1-b : begin----------------");
        System.out.println("le Numero depart:"+request.getDepNumero());
        System.out.println("la Rue depart:"+request.getDepRue());
        System.out.println("le CodePostal depart:"+request.getDepCodePostal());
        System.out.println("la Ville depart:"+request.getDepVille());
        System.out.println("le Pays depart:"+request.getDepPays());
        System.out.println("----------------Recuperer la Request de UserStory1-b : end----------------");

        String adresseDepart=request.getDepNumero()+" "+request.getDepRue();
        
        StationsUserStory1BType stationsB= this.jcdecaux.userStory1b(adresseDepart);
        this.object2xml.creeXMLUserStory1B(stationsB);
        return  this.objectfactoryuserstory1b.createStations(stationsB);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserStory2Request") // nom de l'element racine
    @ResponsePayload
    public JAXBElement<MeteoType> handleUserStory2Request(@RequestPayload UserStory2RequestType request)
            throws Exception {
       
    	System.out.println("----------------Recuperer la Request de UserStory2 : begin----------------");
        System.out.println("le Numero depart:"+request.getDepNumero());
        System.out.println("la Rue depart:"+request.getDepRue());
        System.out.println("le CodePostal depart:"+request.getDepCodePostal());
        System.out.println("la Ville depart:"+request.getDepVille());
        System.out.println("le Pays depart:"+request.getDepPays());
        System.out.println("----------------Recuperer la Request de UserStory2 : end----------------");
        // adresse :"4 avenue des herbettes, 31400 Toulouse"
        String adresse = request.getDepNumero()+" "+request.getDepRue()+", "+request.getDepCodePostal()+" "+request.getDepVille(); 

        MeteoType meteo = this.openweathermap.chausseePluviometrie(adresse);
        this.object2xml.creeXMLUserStory2(meteo);
        return  this.objectfactoryuserstory2.createMeteo(meteo);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserStory3Request") // nom de l'element racine
    @ResponsePayload
    public JAXBElement<TrajetPiedType> handleUserStory3Request(@RequestPayload UserStory3RequestType request)
            throws Exception {
       
    	System.out.println("----------------Recuperer la Request de UserStory3 : begin----------------");
        System.out.println("le Numero depart:"+request.getDepNumero());
        System.out.println("la Rue depart:"+request.getDepRue());
        System.out.println("le CodePostal depart:"+request.getDepCodePostal());
        System.out.println("la Ville depart:"+request.getDepVille());
        System.out.println("----------------Recuperer la Request de UserStory3 : end----------------");

        String adresseDepart = request.getDepNumero()+" "+request.getDepRue()+", "+request.getDepCodePostal()+" "+request.getDepVille();  
        String adresseArrivee = request.getArrNumero()+" "+request.getArrRue()+", "+request.getArrCodePostal()+" "+request.getArrVille();

        TrajetPiedType trajetPied=this.openweathermap.tempsEstimerApied(adresseDepart, adresseArrivee);
        this.object2xml.creeXMLUserStory3(trajetPied);
        return  this.objectfactoryuserstory3.createTrajetPied(trajetPied);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserStory4Request") // nom de l'element racine
    @ResponsePayload
    public JAXBElement<TrajetType> handleUserStory4Request(@RequestPayload UserStory4RequestType request)
            throws Exception {
    	
    	System.out.println("----------------Recuperer la Request de UserStory4 : begin----------------");
        System.out.println("le Numero depart:"+request.getDepNumero());
        System.out.println("la Rue depart:"+request.getDepRue());
        System.out.println("le CodePostal depart:"+request.getArrCodePostal());
        System.out.println("la Ville depart:"+request.getDepVille());
        
        System.out.println("le Numero arrive:"+request.getArrNumero());
        System.out.println("la Rue arrive:"+request.getArrRue());
        System.out.println("le CodePostal arrive:"+request.getArrCodePostal());
        System.out.println("la Ville arrive:"+request.getArrVille());
        System.out.println("----------------Recuperer la Request de UserStory4 : end----------------");

        String adresseDepart = request.getDepNumero()+" "+request.getDepRue()+", "+request.getDepCodePostal()+" "+request.getDepVille();  
        String adresseArrivee = request.getArrNumero()+" "+request.getArrRue()+", "+request.getArrCodePostal()+" "+request.getArrVille();      

        TrajetType trajet = openweathermap.tempsTotalTrajet(adresseDepart, adresseArrivee);
        this.object2xml.creeXMLUserStory4(trajet);
        return  this.objectfactoryuserstory4.createTrajet(trajet);
    }
}