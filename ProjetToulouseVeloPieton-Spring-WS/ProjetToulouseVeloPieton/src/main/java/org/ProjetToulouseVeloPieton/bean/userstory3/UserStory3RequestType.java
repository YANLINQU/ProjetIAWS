
package org.ProjetToulouseVeloPieton.bean.userstory3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserStory3RequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserStory3RequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="DepNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DepRue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DepCodePostal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DepVille" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DepPays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrNumero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArrRue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrCodePostal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ArrVille" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ArrPays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserStory3RequestType", propOrder = {

})
public class UserStory3RequestType {

    @XmlElement(name = "DepNumero")
    protected int depNumero;
    @XmlElement(name = "DepRue", required = true)
    protected String depRue;
    @XmlElement(name = "DepCodePostal")
    protected int depCodePostal;
    @XmlElement(name = "DepVille", required = true)
    protected String depVille;
    @XmlElement(name = "ArrNumero")
    protected int arrNumero;
    @XmlElement(name = "ArrRue", required = true)
    protected String arrRue;
    @XmlElement(name = "ArrCodePostal")
    protected int arrCodePostal;
    @XmlElement(name = "ArrVille", required = true)
    protected String arrVille;

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
    /**
     * Gets the value of the arrNumero property.
     * 
     */
    public int getArrNumero() {
        return arrNumero;
    }

    /**
     * Sets the value of the arrNumero property.
     * 
     */
    public void setArrNumero(int value) {
        this.arrNumero = value;
    }

    /**
     * Gets the value of the arrRue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrRue() {
        return arrRue;
    }

    /**
     * Sets the value of the arrRue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrRue(String value) {
        this.arrRue = value;
    }

    /**
     * Gets the value of the arrCodePostal property.
     * 
     */
    public int getArrCodePostal() {
        return arrCodePostal;
    }

    /**
     * Sets the value of the arrCodePostal property.
     * 
     */
    public void setArrCodePostal(int value) {
        this.arrCodePostal = value;
    }

    /**
     * Gets the value of the arrVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrVille() {
        return arrVille;
    }

    /**
     * Sets the value of the arrVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrVille(String value) {
        this.arrVille = value;
    }
}
