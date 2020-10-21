package controller;

import persistence.*;
import entity.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserData userData = new UserData();
        UserDao userDao = new UserDao();

        //access the info that was entered into the form
        int searchTerm = 0;
        String searchTermString = req.getParameter("searchterm");
        if (searchTermString != null) {
            searchTerm = Integer.parseInt(searchTermString); //parse it
            req.setAttribute("users", userDao.getById(searchTerm)); //look it up
        }
        else {
            req.setAttribute("users", userDao.getAll());
        }

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}