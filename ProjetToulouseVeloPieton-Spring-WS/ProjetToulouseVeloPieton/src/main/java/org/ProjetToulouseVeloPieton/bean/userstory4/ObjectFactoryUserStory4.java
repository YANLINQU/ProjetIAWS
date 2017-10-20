
package org.ProjetToulouseVeloPieton.bean.userstory4;

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
public class ObjectFactoryUserStory4 {

    private final static QName _Trajet_QNAME = new QName("http://iaws/ws/contractfirst/projet", "Trajet");
    private final static QName _UserStory4Request_QNAME = new QName("http://iaws/ws/contractfirst/projet", "UserStory4Request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactoryUserStory4() {
    }

    /**
     * Create an instance of {@link UserStory4RequestType }
     * 
     */
    public UserStory4RequestType createUserStory4RequestType() {
        return new UserStory4RequestType();
    }

    /**
     * Create an instance of {@link TrajetType }
     * 
     */
    public TrajetType createTrajetType() {
        return new TrajetType();
    }

    /**
     * Create an instance of {@link TrajetPiedArrType }
     * 
     */
    public TrajetPiedArrType createTrajetPiedArrType() {
        return new TrajetPiedArrType();
    }

    /**
     * Create an instance of {@link TrajetPiedsType }
     * 
     */
    public TrajetPiedsType createTrajetPiedsType() {
        return new TrajetPiedsType();
    }

    /**
     * Create an instance of {@link TrajetPiedDepType }
     * 
     */
    public TrajetPiedDepType createTrajetPiedDepType() {
        return new TrajetPiedDepType();
    }

    /**
     * Create an instance of {@link TrajetVeloType }
     * 
     */
    public TrajetVeloType createTrajetVeloType() {
        return new TrajetVeloType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrajetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "Trajet")
    public JAXBElement<TrajetType> createTrajet(TrajetType value) {
        return new JAXBElement<TrajetType>(_Trajet_QNAME, TrajetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStory4RequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "UserStory4Request")
    public JAXBElement<UserStory4RequestType> createUserStory4Request(UserStory4RequestType value) {
        return new JAXBElement<UserStory4RequestType>(_UserStory4Request_QNAME, UserStory4RequestType.class, null, value);
    }

}
