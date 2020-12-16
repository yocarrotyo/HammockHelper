package controller;
import utils.VerifyRecaptcha;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entity.Role;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

/**
 * Created by paulawaite on 3/3/16 and stolen by Caroline on 12/9/20. Class for registering new users to the Hammock Helper
 * so they can contribute to the database.
 */

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )

public class SignUpUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     *  Handles HTTP POST requests. Creates a new user based on form data provided by the user in the signup.jsp
     *@param  req               the HttpRequest
     *@param  resp              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setFname(req.getParameter("fname"));
        user.setLname(req.getParameter("lname"));
        user.setPassword(req.getParameter("password"));
        logger.debug("Adding User: " + user);
        Role role = new Role();
        role.setUser(user);
        role.setRolename("Camper");
        user.addRole(role);

        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean isVerified = VerifyRecaptcha.verify(gRecaptchaResponse);

        //if (isVerified) { commented code for future possible implementation of a ReCaptcha
        GenericDao userDao = new GenericDao(User.class);
        //look up a user with username provided
        List<User> existingUsers = userDao.getByProperty("username", req.getParameter("username"));
        if (existingUsers.isEmpty()) {
            userDao.insert(user);
        } else {
            req.setAttribute("errorMessage", "That username is already in use");
            logger.info("Existing user");
        }
        /*} else { commented code for future possible implementation of a ReCaptcha
            req.setAttribute("errorMessage", "Failed Captcha - Please try again");
            logger.info("Failed Captcha");
        }
        */
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signupconfirmation" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}