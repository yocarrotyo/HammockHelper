package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcodeapi.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

public class zipCodeDataDao implements PropertiesLoader {

    final Logger logger = LogManager.getLogger(this.getClass());

    public Response getResponses(String apiTargetParams) {

        Client client = ClientBuilder.newClient();

        //create a properties object
        Properties apiProperties;
        //load the properties
        //apiProperties = loadProperties("APITarget.properties");
        //String apiURL = apiProperties.getProperty("session.apiurl"); i tried :(
        String apiURL = "https://www.zipcodeapi.com/rest/fuzqdKkFt2CnM0CV3Gkt8Lcv8tBWJNIn1cYLfT5GF6zXBnBnE1hbkHzrA4SSX6Zv/radius.json"+apiTargetParams;
        logger.debug("apiURL is: ",apiURL);

        WebTarget target =
                client.target(apiURL);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Response zipresponse = null;
        try {
            zipresponse = mapper.readValue(response, Response.class);
        }
        catch (JsonProcessingException e){
            logger.error("The zip code API did not return a ZIP code",e);
            return zipresponse; //return null so we know to use the error message
        }
        return zipresponse;
    }
}
