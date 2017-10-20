
package org.ProjetToulouseVeloPieton.bean.userstory3;

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
public class ObjectFactoryUserStory3 {

    private final static QName _UserStory3Request_QNAME = new QName("http://iaws/ws/contractfirst/projet", "UserStory3Request");
    private final static QName _TrajetPied_QNAME = new QName("http://iaws/ws/contractfirst/projet", "Trajet_Pied");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactoryUserStory3() {
    }

    /**
     * Create an instance of {@link TrajetPiedType }
     * 
     */
    public TrajetPiedType createTrajetPiedType() {
        return new TrajetPiedType();
    }

    /**
     * Create an instance of {@link UserStory3RequestType }
     * 
     */
    public UserStory3RequestType createUserStory3RequestType() {
        return new UserStory3RequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStory3RequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "UserStory3Request")
    public JAXBElement<UserStory3RequestType> createUserStory3Request(UserStory3RequestType value) {
        return new JAXBElement<UserStory3RequestType>(_UserStory3Request_QNAME, UserStory3RequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrajetPiedType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "Trajet_Pied")
    public JAXBElement<TrajetPiedType> createTrajetPied(TrajetPiedType value) {
        return new JAXBElement<TrajetPiedType>(_TrajetPied_QNAME, TrajetPiedType.class, null, value);
    }

}
