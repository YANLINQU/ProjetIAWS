
package org.ProjetToulouseVeloPieton.bean.userstory2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserStory2RequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserStory2RequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DepNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DepRue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DepCodePostal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DepVille" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DepPays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserStory2RequestType", propOrder = {

})
public class UserStory2RequestType {

    @XmlElement(name = "DepNumero")
    protected int depNumero;
    @XmlElement(name = "DepRue", required = true)
    protected String depRue;
    @XmlElement(name = "DepCodePostal")
    protected int depCodePostal;
    @XmlElement(name = "DepVille", required = true)
    protected String depVille;
    @XmlElement(name = "DepPays", required = true)
    protected String depPays;

    /**
     * Gets the value of the depNumero property.
     * 
     */
    public int getDepNumero() {
        return depNumero;
    }

    /**
     * Sets the value of the depNumero property.
     * 
     */
    public void setDepNumero(int value) {
        this.depNumero = value;
    }

    /**
     * Gets the value of the depRue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepRue() {
        return depRue;
    }

    /**
     * Sets the value of the depRue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepRue(String value) {
        this.depRue = value;
    }

    /**
     * Gets the value of the depCodePostal property.
     * 
     */
    public int getDepCodePostal() {
        return depCodePostal;
    }

    /**
     * Sets the value of the depCodePostal property.
     * 
     */
    public void setDepCodePostal(int value) {
        this.depCodePostal = value;
    }

    /**
     * Gets the value of the depVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepVille() {
        return depVille;
    }

    /**
     * Sets the value of the depVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepVille(String value) {
        this.depVille = value;
    }

    /**
     * Gets the value of the depPays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepPays() {
        return depPays;
    }

    /**
     * Sets the value of the depPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepPays(String value) {
        this.depPays = value;
    }

}
