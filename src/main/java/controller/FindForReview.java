package controller;

import entity.Campsite;
import entity.Park;
import entity.Review;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@WebServlet(
        urlPatterns = {"/findForReview"}
)
public class FindForReview extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Return all sites for a park and show them to the user
        HttpSession session = req.getSession();
        final Logger logger = LogManager.getLogger(this.getClass());

        //access the info that was entered into the form - park and maybe site no
        String parkname = req.getParameter("park");

        //get a DAO for the park & set up an error message
        GenericDao<Park> parkDao = new GenericDao(Park.class);
        String parkerror = "";

        //use the Park Dao to find the ID of the park because I don't want to do a table join
        List<Park> parkList = parkDao.getByProperty("parkname",parkname); //this will require multi-state lookup soon

        //handle not finding the park
        if (parkList.isEmpty()) {
            parkerror = "We didn't find that park in the database. Typo? Try searching again.";
            req.setAttribute("parkerror",parkerror);
            //go home before you hurt yourself
            RequestDispatcher dispatcher = req.getRequestDispatcher("/reviewtable.jsp");
            dispatcher.forward(req, resp);
        }

        logger.debug("parkList contains: ", parkList.toString());

        //look up the ID of the park
        Park onepark = parkList.get(0); //assumption: park names must be unique within a state
        logger.debug("the single park is: ", onepark.toString());
        int parkid = onepark.getPark_id();

        //look up all the reviewable data related to that park
        GenericDao<Review> revDao = new GenericDao(Review.class);
        List<Review> siteList = revDao.getByPropertyEq("parkid",parkid);

        //put the review entries and the park ID into the session
        session.setAttribute("siteList",siteList);
        session.setAttribute("thePark",onepark);

        //forward the request to the contribute jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/reviewtable.jsp");
        dispatcher.forward(req, resp);
    }

}
