package utils;

import entity.Review;
import persistence.GenericDao;

import java.util.List;
/* Cleans up the review table. Transfers the review data we have a certain amount of confience in over to the campsite
table so it can be found in the search*/
public class ValidationUtility {

    public void cleanup() {

    //go through the rows of the review table (use a getall to put them in a list)
    GenericDao<Review> reviewDao = new GenericDao<Review>(Review.class);
    List<Review> allReviews = reviewDao.getAll();

    //delete all data with a confidence score less than -2
    for (Review rev: allReviews) {
        if (rev.getConfidence() < -2) {
            reviewDao.delete(rev);
        }
        //find rows that have the same park id and siteno - delete the one with the lower confidence score
        List<Review> duplicateRevs = reviewDao.getBy2PropertiesLikeAndEq("siteno",rev.getSiteno(),"parkid",rev.getParkid());

        if (duplicateRevs.size()>1) {
            //set a value to compare to
            int compareConfidence = rev.getConfidence();

            for (Review similarrevs : duplicateRevs) {


            }

        }
    }

    }

    public void copytocamp() {

        //for any data that has confidence scores greater than 2,
        //create a campsite and add it to the database
        //if a campsite is already there, compare the confidence scores and keep the value that is higher confidence
        //once data is copied to the campsite table, delete it out of the review table

    }
}
