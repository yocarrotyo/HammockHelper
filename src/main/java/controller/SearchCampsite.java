package controller;

import entity.Campsite;
import persistence.GenericDao;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        //UserData userData = new UserData();
        GenericDao genericDao = new GenericDao(Campsite.class);

        //access the info that was entered into the form
        int searchTerm = 0;
        String searchTermString = req.getParameter("searchterm");
        if (searchTermString != null) {
            searchTerm = Integer.parseInt(searchTermString); //parse it
            req.setAttribute("campsites", genericDao.getById(searchTerm)); //look it up
        }
        else {
            req.setAttribute("campsites", genericDao.getAll());
        }

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/campsiteresults.jsp");
        dispatcher.forward(req, resp);
    }
}