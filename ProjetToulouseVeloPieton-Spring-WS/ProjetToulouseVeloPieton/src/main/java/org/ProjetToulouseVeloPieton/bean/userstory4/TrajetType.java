
package org.ProjetToulouseVeloPieton.bean.userstory4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrajetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrajetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tempstotal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Trajet_pieds" type="{http://iaws/ws/contractfirst/projet}Trajet_piedsType"/>
 *         &lt;element name="Trajet_velo" type="{http://iaws/ws/contractfirst/projet}Trajet_veloType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrajetType", propOrder = {
    "tempstotal",
    "trajetPieds",
    "trajetVelo"
})
@XmlRootElement(name="Trajet")
public class TrajetType {

    @XmlElement(required = true)
    protected String tempstotal;
    @XmlElement(name = "Trajet_pieds", required = true)
    protected TrajetPiedsType trajetPieds;
    @XmlElement(name = "Trajet_velo", required = true)
    protected TrajetVeloType trajetVelo;

    /**
     * Gets the value of the tempstotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempstotal() {
        return tempstotal;
    }

    /**
     * Sets the value of the tempstotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempstotal(String value) {
        this.tempstotal = value;
    }

    /**
     * Gets the value of the trajetPieds property.
     * 
     * @return
     *     possible object is
     *     {@link TrajetPiedsType }
     *     
     */
    public TrajetPiedsType getTrajetPieds() {
        return trajetPieds;
    }

    /**
     * Sets the value of the trajetPieds property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrajetPiedsType }
     *     
     */
    public void setTrajetPieds(TrajetPiedsType value) {
        this.trajetPieds = value;
    }

    /**
     * Gets the value of the trajetVelo property.
     * 
     * @return
     *     possible object is
     *     {@link TrajetVeloType }
     *     
     */
    public TrajetVeloType getTrajetVelo() {
        return trajetVelo;
    }

    /**
     * Sets the value of the trajetVelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrajetVeloType }
     *     
     */
    public void setTrajetVelo(TrajetVeloType value) {
        this.trajetVelo = value;
    }

}
