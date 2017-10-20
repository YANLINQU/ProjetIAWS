
package org.ProjetToulouseVeloPieton.bean.userstory1a;

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
public class ObjectFactoryUserStory1A {

    private final static QName _UserStory1ARequest_QNAME = new QName("http://iaws/ws/contractfirst/projet", "UserStory1ARequest");
    private final static QName _Stations_QNAME = new QName("http://iaws/ws/contractfirst/projet", "Stations");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactoryUserStory1A() {
    }

    /**
     * Create an instance of {@link StationsUserStory1AType }
     * 
     */
    public StationsUserStory1AType createStationsType() {
        return new StationsUserStory1AType();
    }

    /**
     * Create an instance of {@link UserStory1ARequestType }
     * 
     */
    public UserStory1ARequestType createUserStory1ARequestType() {
        return new UserStory1ARequestType();
    }

    /**
     * Create an instance of {@link StationsAvecVelosType }
     * 
     */
    public StationsAvecVelosType createStationsAvecVelosType() {
        return new StationsAvecVelosType();
    }

    /**
     * Create an instance of {@link StationType }
     * 
     */
    public StationType createStationType() {
        return new StationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStory1ARequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "UserStory1ARequest")
    public JAXBElement<UserStory1ARequestType> createUserStory1ARequest(UserStory1ARequestType value) {
        return new JAXBElement<UserStory1ARequestType>(_UserStory1ARequest_QNAME, UserStory1ARequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationsUserStory1AType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "Stations")
    public JAXBElement<StationsUserStory1AType> createStations(StationsUserStory1AType value) {
        return new JAXBElement<StationsUserStory1AType>(_Stations_QNAME, StationsUserStory1AType.class, null, value);
    }

}
