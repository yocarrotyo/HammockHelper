package utils;

import entity.Campsite;
import entity.Park;
import entity.Review;
import persistence.GenericDao;

import java.util.Collections;
import java.util.List;

/**
 * The type Validation utility.
 *
 * Cleans up the review table. Transfers the review data we have a certain amount of confidence in over to the campsite
   table so it can be found in the search. Called every time someone submits a data review from the ProcessReview servlet.
    In the future, this can be modified to be run ad-hoc from the web interface by an admin user.
 */
public class ValidationUtility {

    /**
     * Cleanup. Removes data we're not confident in (defined as a confidence score lower than -2) from the Review table.
     * Removes duplicates from the Review table by retaining only the one with the highest confidence score.
     */
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
        while (duplicateRevs.size()>1) {
            Review leastConfidentRev = Collections.min(duplicateRevs);
            //delete from database and collection
            duplicateRevs.remove(leastConfidentRev);
            reviewDao.delete(leastConfidentRev);
        }

        }
    }

    /**
     * Copytocamp. Moves any data we're confident in (defined as a confidence score higher than 2) from the Review table
     * to the Campsite table. Deletes data out of the Review table after it's been copied.
     */
    public void copytocamp() {

        //go through the rows of the review table (use a getall to put them in a list)
        GenericDao<Review> reviewDao = new GenericDao<Review>(Review.class);
        List<Review> allReviews = reviewDao.getAll();
        //for any data that has confidence scores greater than 2,
        for (Review rev: allReviews) {

            if (rev.getConfidence() > 2) {

            //create a campsite and copy data from the review (this seems...like not how this should work??)
            Campsite newSite = new Campsite();
            newSite.setCapacity(rev.getCapacity());
            newSite.setConfidence(rev.getConfidence());
            //figure out the park dao (review table doesn't store park entities as its instance variable, just the digits)
            GenericDao parkDao = new GenericDao(Park.class);
            Park thePark = (Park) parkDao.getById(rev.getParkid());
            newSite.setParkid(thePark);
            newSite.setSiteno(rev.getSiteno());
            //add the campsite object to the actual database
            GenericDao siteDao = new GenericDao(Campsite.class);
            siteDao.insert(newSite);

            //once data is copied to the campsite table, delete it out of the review table
            reviewDao.delete(rev);
            }

        }



    }
}
