package controller;

import entity.Campsite;
import entity.Park;
import persistence.GenericDao;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchCampsite"}
)

public class SearchCampsite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        //access the info that was entered into the form - park and maybe site no
        String siteno= req.getParameter("siteno");
        String parkname = req.getParameter("park");
        logger.debug("the value of the parkname parameter is: ",parkname);

        //get DAOs for the campsite and the park
        GenericDao siteDao = new GenericDao(Campsite.class);
        GenericDao parkDao = new GenericDao(Park.class);

        //use the Park Dao to find the ID of the park because I don't want to do a table join
        List<Park> parkList = parkDao.getByProperty("parkname",parkname); //this will require multi-state lookup soon
        logger.debug("parkList contains: ",parkList.toString());
        //look up the ID of the park also because I don't want to do a join
        Park onepark = parkList.get(0);
        logger.debug("the single park is: ",onepark.toString());
        int parkid = onepark.getPark_id();

        //do stuff for checking an individual site
        if (siteno != null) {
            //assume we cannot do hammocks here
            String hammockFriendly = "no";
            //find the campsite in the database
            List<Campsite> siteList = siteDao.getBy2PropertiesLikeAndEq("siteno",siteno,"parkid",parkid);
            Campsite onesite = siteList.get(0);

            //see if the site hammock capacity is greater than 0
            int hamcap = 0;
            hamcap = onesite.getCapacity();

            //if we have found a hammock capacity set the response to affirmative/yes
            if (hamcap > 0) {
                hammockFriendly="yes";
            }
            //set the attributes describing the campsite
            //set the attributes describing the campsite
            req.setAttribute("isFriendly", hammockFriendly);
            req.setAttribute("siteno",siteno);
        }
        else {
            //for now just return every campsite in the table ... lol
            req.setAttribute("campsites", siteDao.getAll());
        }

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/campsiteresults.jsp");
        dispatcher.forward(req, resp);
    }
}