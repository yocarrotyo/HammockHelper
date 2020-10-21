package controller;

import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/contribute"}
)
public class Contribute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //This servlet does nothing except forward you to the contribute jsp??? I think?

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/contribute.jsp");
        dispatcher.forward(req, resp);
    }

}
