
package org.ProjetToulouseVeloPieton.bean.userstory2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactoryUserStory2 {

    private final static QName _Meteo_QNAME = new QName("http://iaws/ws/contractfirst/projet", "Meteo");
    private final static QName _UserStory2Request_QNAME = new QName("http://iaws/ws/contractfirst/projet", "UserStory2Request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactoryUserStory2() {
    }

    /**
     * Create an instance of {@link UserStory2RequestType }
     * 
     */
    public UserStory2RequestType createUserStory2RequestType() {
        return new UserStory2RequestType();
    }

    /**
     * Create an instance of {@link MeteoType }
     * 
     */
    public MeteoType createMeteoType() {
        return new MeteoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeteoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "Meteo")
    public JAXBElement<MeteoType> createMeteo(MeteoType value) {
        return new JAXBElement<MeteoType>(_Meteo_QNAME, MeteoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStory2RequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "UserStory2Request")
    public JAXBElement<UserStory2RequestType> createUserStory2Request(UserStory2RequestType value) {
        return new JAXBElement<UserStory2RequestType>(_UserStory2Request_QNAME, UserStory2RequestType.class, null, value);
    }

}
