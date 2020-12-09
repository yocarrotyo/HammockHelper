package controller;


import entity.Campsite;
import entity.Park;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This servlet uses the information entered in the HTML form to kick off the employee search.
 *
 *@author Eric Knapp
 */
@WebServlet(
        name = "addReview",
        urlPatterns = { "/addReview" }
)
public class AddReview extends HttpServlet {

    /**
     *  Handles HTTP POST requests.
     *
     *@param  req               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        final Logger logger = LogManager.getLogger(this.getClass());
        //Access the info that was entered into the form
        String siteno= req.getParameter("siteno");
        int capacity= Integer.parseInt(req.getParameter("capacity"));
        String parkname = req.getParameter("park");
        //Use the DAO to instantiate a campsite entity
        GenericDao siteDao = new GenericDao(Campsite.class);
        GenericDao parkDao = new GenericDao(Park.class);

        //Update or create the campsite entry in the database
        Campsite newCampsite = new Campsite();
        //set data on the campsite
        newCampsite.setCapacity(capacity);
        List<Park> parkList= parkDao.getByProperty("parkname",parkname);
        Park thePark = parkList.get(0);
        newCampsite.setParkid(parkList.get(0));
        newCampsite.setSiteno(siteno);
        newCampsite.setConfidence(10);
        newCampsite.setRating(4);
        siteDao.insert(newCampsite);

        //If there is already an entry with that site number at that park and they conflict
        //Let the user know about the discrepancy to see if they made a mistake
        //Entry goes into the review table
        //If everything is good copy the info to the campsite table

        //Add the returned message to the session - figure out from last semester.
        session.setAttribute("addedSite",newCampsite); //set the attribute
        session.setAttribute("thePark",thePark);

        //specify the url where to send results
        String url = "/HammockHelper_war/thanksforcontributing.jsp";

        //Redirect to the thank you page and summarize what was added
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        response.sendRedirect(url);
    }
}