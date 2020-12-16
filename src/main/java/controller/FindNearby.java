package controller;

import com.zipcodeapi.ZipCodesItem;
import entity.Campsite;
import entity.Park;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.zipCodeDataDao;


/**
 * Class for finding state parks that are nearby a given park that is stored in the HTTP session attributes.
 */
@WebServlet(
        urlPatterns = {"/findNearby"}
)

public class FindNearby extends HttpServlet{

    //DAOs for accessing the database
    GenericDao<Park> parkDao = new GenericDao(Park.class);
    GenericDao<Campsite> siteDao = new GenericDao(Campsite.class);
    String apiError;

    /**
     * Handles Http GET requests. No user input is provided immediately before this servlet is called, but it uses
     * session attribute data set by the searchCampsite servlet
     *
     *@param  req               the HttpRequest
     *@param  resp             the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        HttpSession session = req.getSession();

        //pull the session-scope attribute parkid
        int parkid = (int) session.getAttribute("parkid");

        //get the ZIP code for this park
        String parkZip = parkLookup(parkid);

        //find out nearby parks
        List<Park> nearbyParks = getNearbyParks(parkZip);

        //look up the campsites within the nearby parks
        Map<Park, ArrayList<Campsite>> friendlySitesMap = getFriendlySites(nearbyParks);

        session.setAttribute("nearbyParks",nearbyParks);
        session.setAttribute("friendlySites",friendlySitesMap);
        session.setAttribute("apiError",apiError);

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/nearbyresults.jsp");
        dispatcher.forward(req, resp);
    }
    /**
     * Looks up a park object based on the ID and returns the ZIP code
     *
     *@param  parkid            the id of the park
     *@return  the park's ZIP code
     */
    private String parkLookup(int parkid) {

        Park myPark = parkDao.getById(parkid);
        String parkZip = myPark.getZipcode();
        return parkZip;
    }

    /**
     * Calls the ZIP code API to find a list of ZIP codes near the ZIP code of a given park. Looks up the names of the
     * parks having one of the nearby ZIP codes.
     *
     *@param  parkZip           the ZIP code of the park
     *@return  A list of parks that are within 20 miles of the given park's zip code.
     */
    private List<Park> getNearbyParks(String parkZip) {

        //container for the nearby parks
        List<Park> nearbyParks = new ArrayList<>();

        //build a string to send to the ZIP code API
        String apiTargetParams = "/" + parkZip +"/20/mile";

        //create a zip code data dao
        zipCodeDataDao dao = new zipCodeDataDao();
        //call the getResponses method
        List<ZipCodesItem> apiZipCodes = dao.getResponses(apiTargetParams).getZipCodes();
        if (apiZipCodes.isEmpty()) {
            apiError = "Sorry, we couldn't look up nearby ZIP codes at this time. Try again later.";
        }

        for (ZipCodesItem onezipobj : apiZipCodes) {
            String onezip = onezipobj.getZipCode();
            //find the parks with this zip code
            nearbyParks.addAll(parkDao.getByProperty("zipcode",onezip));
        }

        return nearbyParks;

    }

    /**
     * Calls the ZIP code API to find a list of ZIP codes near the ZIP code of a given park. Looks up the names of the
     * parks having one of the nearby ZIP codes.
     *
     *@param  nearbyParks      parks that were identified as nearby a given park based on ZIP code
     *@return  Hashmap of park objects and a list of hammock-friendly sites at each park
     */
    private Map<Park, ArrayList<Campsite>> getFriendlySites(List<Park> nearbyParks) {

        Map<Park, ArrayList<Campsite>> friendlySitesMap = new HashMap<>();
        //go thru the nearby Parks container
        for(Park onepark : nearbyParks) {
            //look up a campsite with that park ID and a hammock capacity greater than 0
            ArrayList<Campsite> friendlySites = (ArrayList<Campsite>) siteDao.getBy2PropertiesEqAndGt("parkid",onepark.getPark_id(),"capacity","0");
            if (!friendlySites.isEmpty()) {
                //add the park and list of sites to the friendlySitesMap.
                friendlySitesMap.put(onepark, friendlySites);
            }
        }

        return friendlySitesMap;
    }

}
