package org.ProjetToulouseVeloPieton.WS;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.ResponseMatchers;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import static org.springframework.ws.test.server.RequestCreators.withPayload;

import java.io.File;

/**
 * @author YAN LIN QU
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
public class TestIntegrationProjetToulouseVeloPietonEndPoint {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @Before
    public void createClient() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }
    /*
     Tesrter UserStory1A
     UserStory1ARequest.xml:c'est la request pour UserStory1A
     UserStory1A.xsd:c'est le schema de UserStory1A
     */
    
    @Test
    public void testProjetEndpointUserStory1A() throws Exception {
    	File file = new File("src/main/resources/userstory1a/UserStory1A.xml");
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	if(file.exists()){
    		System.out.println("TestIntegration commence");
    		Source requestPayload = new StreamSource(new ClassPathResource("/userstory1a/UserStory1ARequest.xml").getInputStream() );
    		Resource schema = new FileSystemResource("src/main/resources/userstory1a/UserStory1A.xsd");        
    		mockClient.sendRequest(withPayload(requestPayload)).andExpect(ResponseMatchers.validPayload(schema));
    	}        
    }
    
    /*
    Tesrter UserStory1B
    UserStory1BRequest.xml:c'est la request pour UserStory1B
    UserStory1B.xsd:c'est le schema de UserStory1B
    */
    
    @Test
    public void testProjetEndpointUserStory1B() throws Exception {
    	File file = new File("src/main/resources/userstory1b/UserStory1B.xml");
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	if(file.exists()){
    		Source requestPayload = new StreamSource(new ClassPathResource("/userstory1b/UserStory1BRequest.xml").getInputStream() );
    		Resource schema = new FileSystemResource("src/main/resources/userstory1b/UserStory1B.xsd");        
    		mockClient.sendRequest(withPayload(requestPayload)).andExpect(ResponseMatchers.validPayload(schema));
    	}    	
    }
    
    /*
    Tesrter UserStory2
    UserStory2Request.xml:c'est la request pour UserStory2
    UserStory2.xsd:c'est le schema de UserStory2
    */
    
    @Test
    public void testProjetEndpointUserStory2() throws Exception {
    	File file = new File("src/main/resources/userstory2/UserStory2.xml");
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	if(file.exists()){
	    	Source requestPayload = new StreamSource(new ClassPathResource("/userstory2/UserStory2Request.xml").getInputStream() );
	    	Resource schema = new FileSystemResource("src/main/resources/userstory2/UserStory2.xsd");        
			mockClient.sendRequest(withPayload(requestPayload)).andExpect(ResponseMatchers.validPayload(schema));
    	}
    }
    
    /*
    Tesrter UserStory3
    UserStory3Request.xml:c'est la request pour UserStory3
    UserStory3.xsd:c'est le schema de UserStory3
    */
    
    @Test
    public void testProjetEndpointUserStory3() throws Exception {
    	File file = new File("src/main/resources/userstory3/UserStory3.xml");
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	if(file.exists()){
	    	Source requestPayload = new StreamSource(new ClassPathResource("/userstory3/UserStory3Request.xml").getInputStream() );
	    	Resource schema = new FileSystemResource("src/main/resources/userstory3/UserStory3.xsd");        
			mockClient.sendRequest(withPayload(requestPayload)).andExpect(ResponseMatchers.validPayload(schema));
    	}
    }
    
    /*
    Tesrter UserStory4
    UserStory4Request.xml:c'est la request pour UserStory4
    UserStory4.xsd:c'est le schema de UserStory4
    */
    
    @Test
    public void testProjetEndpointUserStory4() throws Exception {
    	File file = new File("src/main/resources/userstory4/UserStory4.xml");
    	if(!file.exists()){
    		file.createNewFile();
    	}
    	if(file.exists()){
	    	Source requestPayload = new StreamSource(new ClassPathResource("/userstory4/UserStory4Request.xml").getInputStream() );
	    	Resource schema = new FileSystemResource("src/main/resources/userstory4/UserStory4.xsd");        
			mockClient.sendRequest(withPayload(requestPayload)).andExpect(ResponseMatchers.validPayload(schema));
    	}
    }
    
}
