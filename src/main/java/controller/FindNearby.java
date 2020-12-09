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


@WebServlet(
        urlPatterns = {"/findNearby"}
)

public class FindNearby extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        HttpSession session = req.getSession();

        //pull the session-scope attribute parkid
        int parkid = (int) session.getAttribute("parkid");

        //get the relevant park object and its zip code
        GenericDao parkDao = new GenericDao(Park.class);
        Park myPark = (Park) parkDao.getById(parkid);
        String parkZip = myPark.getZipcode();

        //create a container for the nearby parks
        List<Park> nearbyParks = new ArrayList<>();
        //Create a dao for looking up stuff about the sitea in it
        GenericDao siteDao = new GenericDao(Campsite.class);

        //build a string to send to the ZIP code API
        String apiTargetParams = "/" + parkZip +"/20/mile";

        //create a zip code data dao
        zipCodeDataDao dao = new zipCodeDataDao();
        //call the getResponses method
        List<ZipCodesItem> apiZipCodes = dao.getResponses(apiTargetParams).getZipCodes();

        for (int i=0; i < apiZipCodes.size(); i++) {
            //get the zip code
            ZipCodesItem onezipobj = apiZipCodes.get(i);
            String onezip = onezipobj.getZipCode();
            //find the parks with this zip code
            nearbyParks.addAll(parkDao.getByProperty("zipcode",onezip));
        }

        //create a hashmap of parks and their campsites
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

        session.setAttribute("nearbyZIPS",apiZipCodes);
        session.setAttribute("nearbyParks",nearbyParks);
        session.setAttribute("friendlySites",friendlySitesMap);

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/nearbyresults.jsp");
        dispatcher.forward(req, resp);
    }

}
