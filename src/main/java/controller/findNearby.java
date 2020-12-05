package controller;

import com.zipcodeapi.ZipCodesItem;
import entity.Campsite;
import entity.Park;
import persistence.GenericDao;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.zipCodeDataDao;


@WebServlet(
        urlPatterns = {"/findNearby"}
)

public class findNearby extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());
        HttpSession session = req.getSession();

        //pull the session-scope attribute parkid
        int parkid = (int) session.getAttribute("parkid");

        //get the relevant park object and its zip code
        GenericDao parkDao = new GenericDao(Park.class);
        Park myPark = (Park) parkDao.getById(parkid);
        String parkZip = myPark.getZipcode();

        //build a string to send to the ZIP code API
        String apiTargetParams = "/" + parkZip +"/20/mile";

        //create a zip code data dao
        zipCodeDataDao dao = new zipCodeDataDao();
        List<String> myZips = new ArrayList<String>();
        //call the getResponses method
        List<ZipCodesItem> apiZipCodes = dao.getResponses(apiTargetParams).getZipCodes();
        for (int i=0; i < apiZipCodes.size(); i++) {

        }
        //use returned zip codes to look up parks with that ZIP

        //forward the request to the display jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/nearbyresults.jsp");
        dispatcher.forward(req, resp);
    }
    
}
