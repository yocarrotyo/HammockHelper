package controller;


import entity.Campsite;
import entity.Park;
import entity.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import utils.ValidationUtility;

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

    GenericDao<Review> revDao = new GenericDao(Review.class);

    /**
     *  Handles HTTP POST requests. Expected to include info about what the user agrees and disagrees with from the existing
     *  data in the Review table shared with them on the reviewtable.jsp page. Calls the checkReview method to do the bulk of
     *  the processing of the new information.
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

        //Get the list of sites and which park we're dealing with (set by the FindForReview servlet)
        List<Review> siteList = (List<Review>) session.getAttribute("siteList");
        Park thePark = (Park) session.getAttribute("thePark");
        int parkid = thePark.getPark_id(); //unlike the SearchCampsite servlet, this one deals with just the integer ID of the park not the whole object

        checkReview(parkid,siteList,req);

        //Run the validation utility
        ValidationUtility validator = new ValidationUtility();
        validator.cleanup();
        validator.copytocamp();

        //set up summary data for the user
        session.setAttribute("allSites",revDao.getByPropertyEq("parkid",parkid));
        session.setAttribute("thePark",thePark);

        //specify the url where to send results
        String url = "/HammockHelper/thanksforcontributing.jsp";

        //Redirect to the thank you page and summarize what was added
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        response.sendRedirect(url);
    }

    private void checkReview(int parkid, List<Review> siteList, HttpServletRequest req) {

        //create a new review in case one is needed and a list for sharing a summary of what was done
        Review newReview;
        List<Review> summaryList = new ArrayList<Review>();

        //go thru the sitelist
        for (Review onesite : siteList) {
            //get one site's siteno
            String siteno = onesite.getSiteno();
            //build strings for the request attributes
            String affirmstr = "affirm" + siteno;
            String dispstr = "dispute" + siteno;
            String hamcap = "hamcap" + siteno;


            //check the affirmation submissions
            String affirmsite = req.getParameter(affirmstr);
            String literally = req.getParameter("literally");
            if (affirmsite != null) {
                //fetch the review based on the siteno
                List<Review> revList = revDao.getBy2PropertiesLikeAndEq("siteno", siteno, "parkid", parkid);
                Review existingReview = revList.get(0); //we only need to review ONE of the (possibly several) submissions per park/siteno - assumption: if it's wrong, it'll eventually get corrected
                //increment review confidence
                int confidence = existingReview.getConfidence();
                existingReview.setConfidence(confidence + 1);
                //update the database
                revDao.saveOrUpdate(existingReview);

                //add this review to the list for summary return
                summaryList.add(existingReview);
            }

            //check the sites that disagree with the displayed data
            String disputesite = req.getParameter(dispstr);
            if (disputesite != null) {
                List<Review> revList = revDao.getBy2PropertiesLikeAndEq("siteno", siteno, "parkid", parkid);
                Review existingReview = revList.get(0);
                int confidence = existingReview.getConfidence();
                //reduce confidence on the existing review
                existingReview.setConfidence(confidence - 1);
                revDao.saveOrUpdate(existingReview);

                //copy data to the new review (re-instantiate each time)
                newReview = new Review();
                newReview.setCapacity(Integer.parseInt((req.getParameter(hamcap))));
                newReview.setParkid(existingReview.getParkid());
                newReview.setSiteno(existingReview.getSiteno());
                newReview.setConfidence(1);

                //add new review to the database
                revDao.insert(newReview);

                //add this review to the list for summary display
                summaryList.add(newReview);

            }
        }
    }
}