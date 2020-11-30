package controller;


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
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Access the info that was entered into the form

        //Use the DAO to instantiate a campsite review entity
        //Update or create the campsite entry in the database
        //If there is already an entry with that site number at that park and they conflict
        //Let the user know about the discrepancy to see if they made a mistake
        //Entry goes into the review table
        //If everything is good copy the info to the campsite table

        //Add the returned message to the session - figure out from last semester.
        //HttpSession session = request.getSession(); //fetch the session
        //session.setAttribute("addMsg",success); //set the attribute

        //specify the url where to send results
        String url = "/thanksforcontributing";

        //Redirect to the thank you page and summarize what was added
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        response.sendRedirect(url);
    }
}