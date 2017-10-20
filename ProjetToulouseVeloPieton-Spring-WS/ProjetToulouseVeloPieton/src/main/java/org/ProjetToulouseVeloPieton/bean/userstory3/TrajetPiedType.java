
package org.ProjetToulouseVeloPieton.bean.userstory3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Trajet_PiedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Trajet_PiedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse_depart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresse_arrivee" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "Trajet_PiedType", propOrder = {
    "adresseDepart",
    "adresseArrivee",
    "temps"
})
@XmlRootElement(name="Trajet_Pied")  
public class TrajetPiedType {

    @XmlElement(name = "adresse_depart", required = true)
    protected String adresseDepart;
    @XmlElement(name = "adresse_arrivee", required = true)
    protected String adresseArrivee;
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
     * Gets the value of the adresseArrivee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseArrivee() {
        return adresseArrivee;
    }

    /**
     * Sets the value of the adresseArrivee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseArrivee(String value) {
        this.adresseArrivee = value;
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
