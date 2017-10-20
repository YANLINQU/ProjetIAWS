
package org.ProjetToulouseVeloPieton.bean.userstory1a;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="available_bickes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stationType", namespace = "http://iaws/ws/contractfirst/projet", propOrder = {
    "adresse",
    "availableBickes",
    "name"
})
public class StationType {

    @XmlElement(namespace = "http://iaws/ws/contractfirst/projet", required = true)
    protected String adresse;
    @XmlElement(name = "available_bickes", namespace = "http://iaws/ws/contractfirst/projet")
    protected int availableBickes;
    @XmlElement(namespace = "http://iaws/ws/contractfirst/projet", required = true)
    protected String name;

    /**
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the availableBickes property.
     * 
     */
    public int getAvailableBickes() {
        return availableBickes;
    }

    /**
     * Sets the value of the availableBickes property.
     * 
     */
    public void setAvailableBickes(int value) {
        this.availableBickes = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
