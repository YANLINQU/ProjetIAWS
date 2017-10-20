
package org.ProjetToulouseVeloPieton.bean.userstory2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeteoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chausse_mouillee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="humidite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="precipitation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeteoType", propOrder = {
    "adresse",
    "chausseMouillee",
    "humidite",
    "precipitation"
})
@XmlRootElement(name="Meteo")  
public class MeteoType {

    @XmlElement(required = true)
    protected String adresse;
    @XmlElement(name = "chausse_mouillee", required = true)
    protected String chausseMouillee;
    @XmlElement(required = true)
    protected String humidite;
    @XmlElement(required = true)
    protected String precipitation;

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
     * Gets the value of the chausseMouillee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChausseMouillee() {
        return chausseMouillee;
    }

    /**
     * Sets the value of the chausseMouillee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChausseMouillee(String value) {
        this.chausseMouillee = value;
    }

    /**
     * Gets the value of the humidite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumidite() {
        return humidite;
    }

    /**
     * Sets the value of the humidite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumidite(String value) {
        this.humidite = value;
    }

    /**
     * Gets the value of the precipitation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets the value of the precipitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecipitation(String value) {
        this.precipitation = value;
    }

}
