
package org.ProjetToulouseVeloPieton.bean.userstory1b;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Stations_Avec_Places" type="{http://iaws/ws/contractfirst/projet}Stations_Avec_PlacesType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ville" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StationsType", propOrder = {
    "stationsAvecPlaces"
})
@XmlRootElement(name="Stations")  
public class StationsUserStory1BType {

    @XmlElement(name = "Stations_Avec_Places", required = true)
    protected StationsAvecPlacesType stationsAvecPlaces;
    @XmlAttribute(name = "ville")
    protected String ville;

    /**
     * Gets the value of the stationsAvecPlaces property.
     * 
     * @return
     *     possible object is
     *     {@link StationsAvecPlacesType }
     *     
     */
    public StationsAvecPlacesType getStationsAvecPlaces() {
        return stationsAvecPlaces;
    }

    /**
     * Sets the value of the stationsAvecPlaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link StationsAvecPlacesType }
     *     
     */
    public void setStationsAvecPlaces(StationsAvecPlacesType value) {
        this.stationsAvecPlaces = value;
    }

    /**
     * Gets the value of the ville property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets the value of the ville property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

}
