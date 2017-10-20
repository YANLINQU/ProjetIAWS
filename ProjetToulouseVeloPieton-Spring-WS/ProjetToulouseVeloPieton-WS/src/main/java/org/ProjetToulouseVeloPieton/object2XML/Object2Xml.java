package org.ProjetToulouseVeloPieton.object2XML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.ProjetToulouseVeloPieton.bean.userstory1a.StationsUserStory1AType;
import org.ProjetToulouseVeloPieton.bean.userstory1b.StationsUserStory1BType;
import org.ProjetToulouseVeloPieton.bean.userstory2.MeteoType;
import org.ProjetToulouseVeloPieton.bean.userstory3.TrajetPiedType;
import org.ProjetToulouseVeloPieton.bean.userstory4.TrajetType;



/*
 * 
 * 
 * transformer le fichier xml en java been 
 * 
 * cette class qui a besoin deux paramettre.
 * 
 * class:qui est un java been, tansformer le fichier xml en ce java been
 * 
 * chemin:conserver le fichier XML a cette adresse
 * 
 * px:UserStory1A: src/main/resources/userstory1a/UserStory1A.xml
 * 	  UserStory2: src/main/resources/userstory2/UserStory2.xml
 * 
 * */
/*
 * @author YAN LIN QU
 * 
 * */
public class Object2Xml {	
	public void creeXMLUserStory1A(StationsUserStory1AType stations){		
		
		try {  
            File file = new File("src/main/resources/userstory1a/UserStory1A.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(StationsUserStory1AType.class);  
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();                
            // output pretty printed              
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            jaxbMarshaller.marshal(stations, file);  
            jaxbMarshaller.marshal(stations, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
	}
	public void creeXMLUserStory1B(StationsUserStory1BType stationsB){
		try {  
            File file = new File("src/main/resources/userstory1b/UserStory1B.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(StationsUserStory1BType.class);  
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
            // output pretty printed  
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            jaxbMarshaller.marshal(stationsB, file);  
            jaxbMarshaller.marshal(stationsB, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
	}

	public void creeXMLUserStory2(MeteoType meteo){
		try {  
            File file = new File("src/main/resources/userstory2/UserStory2.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(MeteoType.class);  
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
            // output pretty printed  
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            jaxbMarshaller.marshal(meteo, file);  
            jaxbMarshaller.marshal(meteo, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
	}
	public void creeXMLUserStory3(TrajetPiedType trajetPied){
		try {  
            File file = new File("src/main/resources/userstory3/UserStory3.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(TrajetPiedType.class);  
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
            // output pretty printed  
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            jaxbMarshaller.marshal(trajetPied, file);  
            jaxbMarshaller.marshal(trajetPied, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
	}

	public void creeXMLUserStory4(TrajetType trajet){
		try {  
            File file = new File("src/main/resources/userstory4/UserStory4.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(TrajetType.class);  
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
            // output pretty printed  
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            jaxbMarshaller.marshal(trajet, file);  
            jaxbMarshaller.marshal(trajet, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
	}	
}
