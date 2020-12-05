package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcodeapi.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class zipCodeDataDao {

    public Response getResponses(String apiTargetParams) {

        Client client = ClientBuilder.newClient();
        //request URL is currently hardcoded to ZIP codes within 25 miles of 53704. Hi neighbors!
        //TODO read in URI from properties
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/fuzqdKkFt2CnM0CV3Gkt8Lcv8tBWJNIn1cYLfT5GF6zXBnBnE1hbkHzrA4SSX6Zv/radius.json"+apiTargetParams);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Response zipresponse = null;
        try {
            zipresponse = mapper.readValue(response, Response.class);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return zipresponse;
    }
}
