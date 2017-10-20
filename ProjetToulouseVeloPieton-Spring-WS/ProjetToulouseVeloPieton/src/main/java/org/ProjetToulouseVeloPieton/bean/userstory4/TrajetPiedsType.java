
package org.ProjetToulouseVeloPieton.bean.userstory4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Trajet_piedsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Trajet_piedsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="temps" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trajet_pied_dep" type="{http://iaws/ws/contractfirst/projet}trajet_pied_depType"/>
 *         &lt;element name="trajet_pied_arr" type="{http://iaws/ws/contractfirst/projet}trajet_pied_arrType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trajet_piedsType", propOrder = {
    "temps",
    "trajetPiedDep",
    "trajetPiedArr"
})
public class TrajetPiedsType {

    @XmlElement(required = true)
    protected String temps;
    @XmlElement(name = "trajet_pied_dep", required = true)
    protected TrajetPiedDepType trajetPiedDep;
    @XmlElement(name = "trajet_pied_arr", required = true)
    protected TrajetPiedArrType trajetPiedArr;

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

    /**
     * Gets the value of the trajetPiedDep property.
     * 
     * @return
     *     possible object is
     *     {@link TrajetPiedDepType }
     *     
     */
    public TrajetPiedDepType getTrajetPiedDep() {
        return trajetPiedDep;
    }

    /**
     * Sets the value of the trajetPiedDep property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrajetPiedDepType }
     *     
     */
    public void setTrajetPiedDep(TrajetPiedDepType value) {
        this.trajetPiedDep = value;
    }

    /**
     * Gets the value of the trajetPiedArr property.
     * 
     * @return
     *     possible object is
     *     {@link TrajetPiedArrType }
     *     
     */
    public TrajetPiedArrType getTrajetPiedArr() {
        return trajetPiedArr;
    }

    /**
     * Sets the value of the trajetPiedArr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrajetPiedArrType }
     *     
     */
    public void setTrajetPiedArr(TrajetPiedArrType value) {
        this.trajetPiedArr = value;
    }

}
