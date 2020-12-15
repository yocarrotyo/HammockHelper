package controller;

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
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet for searching the campsite database for sites and determining if they're hammock-friendly.
 * @author chughes
 */

@WebServlet(
        urlPatterns = {"/searchCampsite"}
)

public class SearchCampsite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        final Logger logger = LogManager.getLogger(this.getClass());

        //access the info that was entered into the form - park and maybe site no
        String siteno= req.getParameter("siteno");
        String parkname = req.getParameter("park");
        logger.debug("the value of the parkname parameter is: ",parkname);

        //get DAOs for the campsite and the park & set up an error message
        GenericDao siteDao = new GenericDao(Campsite.class);
        GenericDao parkDao = new GenericDao(Park.class);
        String parkerror = "";
        String siteerror = "";

        //use the Park Dao to find the ID of the park because I don't want to do a table join
        List<Park> parkList = parkDao.getByProperty("parkname",parkname); //this will require multi-state lookup soon

        //handle not finding the park
        if (parkList.isEmpty()) {
            parkerror = "We didn't find that park in the database. Typo? Try searching again.";
            req.setAttribute("parkerror",parkerror);
            //go home before you hurt yourself
            RequestDispatcher dispatcher = req.getRequestDispatcher("/campsiteresults.jsp");
            dispatcher.forward(req, resp);
        }

        logger.debug("parkList contains: ", parkList.toString());

        //look up the ID of the park
        Park onepark = parkList.get(0); //assumption: park names must be unique within a state
        logger.debug("the single park is: ", onepark.toString());
        int parkid = onepark.getPark_id();

        //not finding the park ID... would indicate big probs
        if (!(parkid > 0)) {
            parkerror = "Something went wrong while looking up the park. We might not have data for it yet.";
            req.setAttribute("parkerror",parkerror);
            //go home before you hurt yourself
            RequestDispatcher dispatcher = req.getRequestDispatcher("/campsiteresults.jsp");
            dispatcher.forward(req, resp);
        }

        //set up variables for checking individual site
        int hamcap = 0;
        String hammockFriendly = "no";
        Campsite onesite = new Campsite();

        //perform the look up if they provided a number
        if (!siteno.equals("")) {
            //find the site with that park and site number
            List<Campsite> siteList = siteDao.getBy2PropertiesLikeAndEq("siteno",siteno,"parkid",parkid);

            //handle not finding the site
            if (siteList.isEmpty()) {
                siteerror = "The specific campsite you searched for was not found in our database. We might not have data for it yet. If the other sites at this park are booked, try Find Nearby to search for other park options.";
            }
            else {
                onesite = siteList.get(0);
            }

            //get the capacity for the found campsite
            hamcap = onesite.getCapacity();

            //if we have found a hammock capacity set the response to affirmative/yes
            if (hamcap > 0) {
                hammockFriendly="yes";
            }
        }

        //set the attributes describing the campsite results
        req.setAttribute("isFriendly", hammockFriendly);
        req.setAttribute("siteno",siteno);
        req.setAttribute("campsites", siteDao.getBy2PropertiesEqAndGt("parkid",parkid,"capacity","0"));
        req.setAttribute("park", parkname);
        req.setAttribute("parkerror",parkerror);
        req.setAttribute("siteerror",siteerror);
        session.setAttribute("parkid",parkid); //will need this later for the findnearby search

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/campsiteresults.jsp");
        dispatcher.forward(req, resp);
    }
}