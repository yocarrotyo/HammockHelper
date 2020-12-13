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
 *  This servlet uses the information entered in the HTML form to kick off the employee search.
 *
 *@author Eric Knapp
 */
@WebServlet(
        name = "processReview",
        urlPatterns = { "/processReview" }
)
public class ProcessReview extends HttpServlet {

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
        //Get the list of sites
        List<Campsite> siteList = (List<Campsite>) session.getAttribute("siteList");
        //go thru the sitelist
        //get one site's siteno
        //build strings for the session attributes for affirmation
        //check the affirmation submissions
        //increment review confidence -- not just the instance variable but in the review table itself also
        //run the validation utility
        //build string for the session attribute for dispute
        //check the dispute submissions
        //reduce confidence on the existing review
        //add a new review with the submitted info

        //Run the validation utility

        //Send a thank you message to the user
        session.setAttribute("addedSite",newReview); //set the attribute
        session.setAttribute("thePark",thePark);

        //specify the url where to send results
        String url = "/HammockHelper_war/thanksforcontributing.jsp";

        //Redirect to the thank you page and summarize what was added
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        response.sendRedirect(url);
    }
}