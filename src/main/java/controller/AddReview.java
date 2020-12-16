package controller;


import entity.Campsite;
import entity.Park;
import entity.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet uses the information entered in the HTML form to add an entry to the Review table.
 *
 * @author Caroline Hughes
 */
@WebServlet(
        name = "addReview",
        urlPatterns = { "/addReview" }
)
public class AddReview extends HttpServlet {

    /**
     *  Handles HTTP POST requests. Adds a new entry to the review table based on the information provided in the form
     *  on the contribute.jsp page.
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

        //get info about the park
        Park thePark = parkLookup(parkname);

        //Add a review based on inputs
        List<Review> allSites = addNew(capacity,thePark,siteno);

        //Set data to send back to the user
        session.setAttribute("allSites",allSites);
        session.setAttribute("thePark",thePark);

        //specify the url where to send results
        String url = "/HammockHelper/thanksforcontributing.jsp";

        //Redirect to the thank you page and summarize what was added
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        response.sendRedirect(url);
    }

    /**
     *  Adds data to the Review table based on user-provided info about a campsite. Sets session attribute to help return
     *  confirmation info to the user.
     *
     *@param  capacity              the hammock capacity of the site according to the user input
     *@param  thePark               park object where the site is located based on user input of the park's name
     *@param  siteno                the campsite number within the park according to user input
     */
    private List<Review> addNew(int capacity, Park thePark, String siteno) {

        GenericDao reviewDao = new GenericDao(Review.class);

        //Create a new review
        Review newReview = new Review();
        //set data on the campsite
        newReview.setCapacity(capacity);

        newReview.setParkid(thePark.getPark_id());
        newReview.setSiteno(siteno);
        newReview.setConfidence(0);
        reviewDao.insert(newReview);

        //Get thecontents of the review table for confirmation/summary for user
        List<Review> allSites = reviewDao.getByPropertyEq("parkid",thePark.getPark_id());
        return allSites;

    }
    /**
     *  Uses a DAO to find the park object with a given name. Assumes park names are unique within a state.
     *
     *@param  parkname              the hammock capacity of the site according to the user input
     */
    private Park parkLookup(String parkname) {

        GenericDao parkDao = new GenericDao(Park.class);
        List<Park> parkList= parkDao.getByProperty("parkname",parkname);
        Park thePark = parkList.get(0);
        return thePark;

    }
}