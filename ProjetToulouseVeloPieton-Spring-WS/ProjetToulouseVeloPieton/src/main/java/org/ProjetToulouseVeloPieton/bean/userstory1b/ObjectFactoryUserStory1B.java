
package org.ProjetToulouseVeloPieton.bean.userstory1b;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage1 package. 
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
public class ObjectFactoryUserStory1B {

    private final static QName _UserStory1BRequest_QNAME = new QName("http://iaws/ws/contractfirst/projet", "UserStory1BRequest");
    private final static QName _Stations_QNAME = new QName("http://iaws/ws/contractfirst/projet", "Stations");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage1
     * 
     */
    public ObjectFactoryUserStory1B() {
    }

    /**
     * Create an instance of {@link StationsUserStory1BType }
     * 
     */
    public StationsUserStory1BType createStationsType() {
        return new StationsUserStory1BType();
    }

    /**
     * Create an instance of {@link UserStory1BRequestType }
     * 
     */
    public UserStory1BRequestType createUserStory1BRequestType() {
        return new UserStory1BRequestType();
    }

    /**
     * Create an instance of {@link StationsAvecPlacesType }
     * 
     */
    public StationsAvecPlacesType createStationsAvecPlacesType() {
        return new StationsAvecPlacesType();
    }

    /**
     * Create an instance of {@link StationBType }
     * 
     */
    public StationBType createStationType() {
        return new StationBType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserStory1BRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "UserStory1BRequest")
    public JAXBElement<UserStory1BRequestType> createUserStory1BRequest(UserStory1BRequestType value) {
        return new JAXBElement<UserStory1BRequestType>(_UserStory1BRequest_QNAME, UserStory1BRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationsUserStory1BType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iaws/ws/contractfirst/projet", name = "Stations")
    public JAXBElement<StationsUserStory1BType> createStations(StationsUserStory1BType value) {
        return new JAXBElement<StationsUserStory1BType>(_Stations_QNAME, StationsUserStory1BType.class, null, value);
    }

}
