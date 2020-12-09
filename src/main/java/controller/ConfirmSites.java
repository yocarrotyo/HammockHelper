package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/confirmSites"}
)
public class ConfirmSites extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Return all sites for a park and show them to the user
        //forward the request to the contribute jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/reviewtable.jsp");
        dispatcher.forward(req, resp);
    }

}
