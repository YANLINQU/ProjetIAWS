
package org.ProjetToulouseVeloPieton.bean.userstory4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trajet_pied_depType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trajet_pied_depType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse_depart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresse_station_depart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temps" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trajet_pied_depType", propOrder = {
    "adresseDepart",
    "adresseStationDepart",
    "temps"
})
public class TrajetPiedDepType {

    @XmlElement(name = "adresse_depart", required = true)
    protected String adresseDepart;
    @XmlElement(name = "adresse_station_depart", required = true)
    protected String adresseStationDepart;
    @XmlElement(required = true)
    protected String temps;

    /**
     * Gets the value of the adresseDepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseDepart() {
        return adresseDepart;
    }

    /**
     * Sets the value of the adresseDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseDepart(String value) {
        this.adresseDepart = value;
    }

    /**
     * Gets the value of the adresseStationDepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseStationDepart() {
        return adresseStationDepart;
    }

    /**
     * Sets the value of the adresseStationDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseStationDepart(String value) {
        this.adresseStationDepart = value;
    }

    /**
     * Gets the value of the temps property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemps() {
        return temps;
    }

    /**
     * Sets the value of the temps property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemps(String value) {
        this.temps = value;
    }

}
